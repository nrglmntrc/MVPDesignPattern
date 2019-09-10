package com.nurgulmantarci.mvpdesignpattern.Data.network.services;

import com.nurgulmantarci.mvpdesignpattern.Data.network.ApiClient;
import com.nurgulmantarci.mvpdesignpattern.Data.network.ApiInterface;
import com.nurgulmantarci.mvpdesignpattern.Data.network.NetworkError;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class CommandServiceImp implements CommandService {

    private ApiInterface apiService;

    @Inject
    public CommandServiceImp(){
        apiService= ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void getCommands(String language, final ServiceCallback<List<Command>> listServiceCallback, final ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        apiService.getCommands(language).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Command>>>() {
                    @Override
                    public Observable<? extends List<Command>> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<List<Command>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).responce(commonResponceServiceCallback);

            }

            @Override
            public void onNext(List<Command> listOfEvent) {
                listServiceCallback.onResponce(listOfEvent);
            }
        });
    }
}

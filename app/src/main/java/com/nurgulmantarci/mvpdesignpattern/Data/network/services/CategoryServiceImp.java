package com.nurgulmantarci.mvpdesignpattern.Data.network.services;

import com.nurgulmantarci.mvpdesignpattern.Data.network.ApiClient;
import com.nurgulmantarci.mvpdesignpattern.Data.network.ApiInterface;
import com.nurgulmantarci.mvpdesignpattern.Data.network.NetworkError;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class CategoryServiceImp implements CategoryService {

    private ApiInterface apiService;

    @Inject
    public CategoryServiceImp(){
        apiService= ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void getCategories(String language, ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        apiService.getCategory(language).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<Category>>>() {
                    @Override
                    public Observable<? extends List<Category>> call(Throwable throwable) {
                        return null;
                    }
                }).subscribe(new Subscriber<List<Category>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(List<Category> listOfCategory) {
                listServiceCallback.onResponse(listOfCategory);

            }
        });
    }

    @Override
    public void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        apiService.getCommandsOfCategory(categoryId).subscribeOn(Schedulers.io())
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

                new NetworkError(e).response(commonResponseServiceCallback);

            }

            @Override
            public void onNext(List<Command> listOfCommands) {
                listServiceCallback.onResponse(listOfCommands);

            }
        });
    }
}

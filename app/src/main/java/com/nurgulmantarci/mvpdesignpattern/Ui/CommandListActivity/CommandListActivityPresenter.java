package com.nurgulmantarci.mvpdesignpattern.Ui.CommandListActivity;

import android.app.Activity;

import com.nurgulmantarci.mvpdesignpattern.Data.DataManager;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.ServiceCallback;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.BasePresenter;

import java.util.List;

public class CommandListActivityPresenter<V extends CommandListActivityMvpView> extends BasePresenter<V> implements CommandListActivityMvpPresenter<V>  {

    private DataManager dataManager;

    public CommandListActivityPresenter(Activity activity,DataManager dataManager) {
        super(activity);
        this.dataManager=dataManager;
    }

    @Override
    public void getCommands(String categoryId) {
        getMvpView().showLoading();


        dataManager.getCommandsOfCategory(categoryId, new ServiceCallback<List<Command>>() {
            @Override
            public void onResponce(List<Command> responce) {
                getMvpView().loadDataToRecylerview(responce);
                getMvpView().dismissLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dismissLoading();

            }
        }, new ServiceCallback<CommonResponse>() {

            @Override
            public void onResponce(CommonResponse responce) {
                getMvpView().showError(responce.getMessage());
                getMvpView().dismissLoading();
            }

            @Override
            public void onError(String message) {
                getMvpView().showError(message);
                getMvpView().dismissLoading();
            }
        });
    }
}

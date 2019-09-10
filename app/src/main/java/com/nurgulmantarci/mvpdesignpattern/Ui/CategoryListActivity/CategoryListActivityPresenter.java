package com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity;

import android.app.Activity;

import com.nurgulmantarci.mvpdesignpattern.Data.DataManager;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.ServiceCallback;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.BasePresenter;

import java.util.List;

public class CategoryListActivityPresenter<V extends CategoryListActivityMvpView> extends BasePresenter<V> implements CategoryListActivityMvpPresenter<V> {

    private Activity activity;
    private DataManager dataManager;

    public CategoryListActivityPresenter(Activity activity, DataManager dataManager) {
        super(activity);
        this.activity=activity;
        this.dataManager=dataManager;
    }

    @Override
    public void getCategoryList(String language) {
        getMvpView().showLoading();

        dataManager.getCategories(language, new ServiceCallback<List<Category>>() {

            @Override
            public void onResponce(List<Category> responce) {
                getMvpView().loadDataToRecyclerview(responce);
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

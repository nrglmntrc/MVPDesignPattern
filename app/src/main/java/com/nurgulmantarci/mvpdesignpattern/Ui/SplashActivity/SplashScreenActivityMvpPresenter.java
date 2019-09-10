package com.nurgulmantarci.mvpdesignpattern.Ui.SplashActivity;

import com.nurgulmantarci.mvpdesignpattern.Ui.Base.MvpPresenter;

public interface SplashScreenActivityMvpPresenter<V extends SplashScreenActivityMvpView> extends MvpPresenter<V> {
    void openCategoryList();
}

package com.nurgulmantarci.mvpdesignpattern.Ui.SplashActivity;

import android.app.Activity;
import android.os.Handler;

import com.nurgulmantarci.mvpdesignpattern.Ui.Base.BasePresenter;
import com.nurgulmantarci.mvpdesignpattern.Utility.Constant;

public class SplashScreenActivityPresenter<V extends SplashScreenActivityMvpView> extends BasePresenter<V> implements SplashScreenActivityMvpPresenter<V> {
    private Activity activity;
    public SplashScreenActivityPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void openCategoryList() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().changeToCategoryList();

            }
        }, Constant.SPLASH_TIME);
    }
}
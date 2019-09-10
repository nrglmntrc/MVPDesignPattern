package com.nurgulmantarci.mvpdesignpattern.Ui.SplashActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nurgulmantarci.mvpdesignpattern.R;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.BaseActivity;
import com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity.CategoryListActivity;
import com.nurgulmantarci.mvpdesignpattern.Utility.Utils;

public class SplashScreenActivity extends BaseActivity implements SplashScreenActivityMvpView {

    private SplashScreenActivityPresenter splashScreenActivityPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashScreenActivityPresenter=new SplashScreenActivityPresenter(this);
        splashScreenActivityPresenter.openCategoryList();
    }

    @Override
    public void changeToCategoryList() {
        Utils.changeActivity(this, CategoryListActivity.class);

    }
}

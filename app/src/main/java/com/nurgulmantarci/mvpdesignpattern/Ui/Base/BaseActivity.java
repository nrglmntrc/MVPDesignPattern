package com.nurgulmantarci.mvpdesignpattern.Ui.Base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.EventBus.EventB;
import com.nurgulmantarci.mvpdesignpattern.Utility.Utils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseActivity extends AppCompatActivity implements MvpView,BaseFragment.Callback {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe
    public void getMessageEvent(EventB messageOTPEvent) {

    }


    @Override
    public void showLoading() {
        progressDialog = Utils.showLoadingDialog(this);
    }

    @Override
    public void dismissLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showMessageToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessageDialog(String text) {
        //   PopupFragment.newInstance().show(getSupportFragmentManager(),1,1);

    }

    @Override
    public void killActivity() {
        this.finish();
    }
}

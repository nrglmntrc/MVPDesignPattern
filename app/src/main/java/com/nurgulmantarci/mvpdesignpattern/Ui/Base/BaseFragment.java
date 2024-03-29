package com.nurgulmantarci.mvpdesignpattern.Ui.Base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.nurgulmantarci.mvpdesignpattern.Utility.Utils;

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity baseActivity;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity){
            BaseActivity activity= (BaseActivity) context;
            this.baseActivity=activity;
            activity.onFragmentAttached();
        }
    }

    protected abstract void setUp(View view);

    @Override
    public void showLoading() {
        dismissLoading();
        progressDialog = Utils.showLoadingDialog(this.getContext());
    }

    @Override
    public void dismissLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

    @Override
    public void showMessageToast(String message) {
        if (baseActivity != null) {

            baseActivity.showMessageToast(message);
        }
    }

    @Override
    public void showError(String message) {
        if (baseActivity != null) {
            baseActivity.showError(message);
        }
    }

    @Override
    public void showMessageDialog(String text) {
        if (baseActivity != null) {

            baseActivity.showMessageDialog(text);
        }
    }

    @Override
    public void killActivity() {
        if (baseActivity != null) {

            baseActivity.killActivity();
        }

    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}

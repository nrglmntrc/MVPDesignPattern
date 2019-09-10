package com.nurgulmantarci.mvpdesignpattern.Ui.Base;

import android.app.Activity;

import butterknife.ButterKnife;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private Activity activity;
    public BasePresenter(Activity activity){
        this.activity=activity;
        onAttach((V)activity);
        ButterKnife.bind(activity);
    }

    private V mvpView;

    public V getMvpView(){
        return this.mvpView;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView=mvpView;
    }

    @Override
    public void onDetach() {
        mvpView=null;
    }
}

package com.nurgulmantarci.mvpdesignpattern.Ui.Base;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);
    void onDetach();
}

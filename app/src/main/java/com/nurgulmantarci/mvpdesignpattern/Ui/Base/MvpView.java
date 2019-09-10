package com.nurgulmantarci.mvpdesignpattern.Ui.Base;

public interface MvpView {
    void showLoading();
    void dismissLoading();
    void showMessageToast(String text);
    void showError(String text);
    void showMessageDialog(String text);
    void killActivity();
}

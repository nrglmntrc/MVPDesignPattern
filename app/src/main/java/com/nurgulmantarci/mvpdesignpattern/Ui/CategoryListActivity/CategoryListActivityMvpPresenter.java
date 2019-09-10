package com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity;

import com.nurgulmantarci.mvpdesignpattern.Ui.Base.MvpPresenter;

public interface CategoryListActivityMvpPresenter<V extends CategoryListActivityMvpView> extends MvpPresenter<V> {
    void getCategoryList(String language);
}

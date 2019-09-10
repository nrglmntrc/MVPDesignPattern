package com.nurgulmantarci.mvpdesignpattern.Ui.CommandListActivity;

import com.nurgulmantarci.mvpdesignpattern.Ui.Base.MvpPresenter;
//import com.nurgulmantarci.mvpdesignpattern.Ui.Base.MvpView;
import com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity.CategoryListActivityMvpView;

public interface CommandListActivityMvpPresenter <V extends CommandListActivityMvpView> extends MvpPresenter<V> {
    void getCommands(String categoryId);

}

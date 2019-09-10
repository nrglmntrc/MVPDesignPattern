package com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.MvpView;

import java.util.List;

public interface CategoryListActivityMvpView extends MvpView {
    void loadDataToRecyclerview(List<Category> listOfCategory);
}

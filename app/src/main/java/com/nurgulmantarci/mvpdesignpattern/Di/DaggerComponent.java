package com.nurgulmantarci.mvpdesignpattern.Di;

import com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity.CategoryListActivity;
import com.nurgulmantarci.mvpdesignpattern.Ui.CommandListActivity.CommandListActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DaggerModule.class})
public interface DaggerComponent {
    void inject(CategoryListActivity categoryListActivity);
    void inject(CommandListActivity commandListActivity);
}

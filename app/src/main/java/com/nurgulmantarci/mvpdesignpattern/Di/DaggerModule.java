package com.nurgulmantarci.mvpdesignpattern.Di;

import android.app.Application;
import android.content.Context;

import com.nurgulmantarci.mvpdesignpattern.Data.AppDataManager;
import com.nurgulmantarci.mvpdesignpattern.Data.DataManager;
import com.nurgulmantarci.mvpdesignpattern.Data.network.ApiHelper;
import com.nurgulmantarci.mvpdesignpattern.Data.network.AppApiHelper;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CategoryService;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CategoryServiceImp;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CommandService;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CommandServiceImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {
    private Context context;

    public  DaggerModule(Application app){
        this.context=app;
    }

    @Provides
    Context providesContext(){
        return context;
    }

    @Singleton
    @Provides
    DataManager provideDataManager(ApiHelper apiHelper){
        return new AppDataManager(apiHelper);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(CommandService commandService, CategoryService categoryService){
        return new AppApiHelper(commandService,categoryService);
    }

    @Provides
    @Singleton
    CommandService provideCommandService(){
        return new CommandServiceImp();
    }

    @Provides
    @Singleton
    CategoryService proviceCategoryService(){
        return new CategoryServiceImp();
    }
}

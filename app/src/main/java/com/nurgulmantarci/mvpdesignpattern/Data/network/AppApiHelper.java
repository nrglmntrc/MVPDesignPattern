package com.nurgulmantarci.mvpdesignpattern.Data.network;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CategoryService;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.CommandService;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.ServiceCallback;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

public class AppApiHelper implements ApiHelper{

    CommandService commandService;
    CategoryService categoryService;

    @Inject
    public AppApiHelper(CommandService commandService, CategoryService categoryService){
        this.commandService=commandService;
        this.categoryService=categoryService;
    }

    @Override
    public void getCommands(String language, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        commandService.getCommands(language,listServiceCallback,commonResponceServiceCallback);
    }

    @Override
    public void getCategories(String language, ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        categoryService.getCategories(language,listServiceCallback,commonResponceServiceCallback);
    }

    @Override
    public void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
       categoryService.getCommandsOfCategory(categoryId,listServiceCallback,commonResponceServiceCallback);
    }


}

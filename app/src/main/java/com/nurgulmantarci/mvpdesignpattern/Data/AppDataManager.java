package com.nurgulmantarci.mvpdesignpattern.Data;

import com.nurgulmantarci.mvpdesignpattern.Data.network.ApiHelper;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.ServiceCallback;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;

import java.util.List;

import javax.inject.Inject;

public class AppDataManager implements DataManager{

    ApiHelper apiHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper){
        this.apiHelper=apiHelper;
    }

    @Override
    public void getCommands(String language, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        apiHelper.getCommands(language,listServiceCallback,commonResponceServiceCallback);
    }

    @Override
    public void getCategories(String language, ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        apiHelper.getCategories(language,listServiceCallback,commonResponceServiceCallback);
    }

    @Override
    public void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback) {
        apiHelper.getCommandsOfCategory(categoryId,listServiceCallback,commonResponceServiceCallback);
    }


}

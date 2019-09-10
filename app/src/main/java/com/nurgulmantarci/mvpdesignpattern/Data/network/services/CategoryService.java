package com.nurgulmantarci.mvpdesignpattern.Data.network.services;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponse;

import java.util.List;

public interface CategoryService {
    void getCategories(String language, ServiceCallback<List<Category>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback);
    void getCommandsOfCategory(String categoryId, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponse> commonResponceServiceCallback);
}

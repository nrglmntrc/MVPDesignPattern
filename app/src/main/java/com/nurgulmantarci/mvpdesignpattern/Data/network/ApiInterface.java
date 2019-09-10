package com.nurgulmantarci.mvpdesignpattern.Data.network;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {

    @GET("commands")
    Observable<List<Command>> getCommands(@Query("language") String language);

    @GET("categories")
    Observable<List<Category>> getCategory(@Query("language") String language);

    @GET("categories/{categoryId}/commands")
    Observable<List<Command>> getCommandsOfCategory(@Path("categoryId") String categoryId);


}

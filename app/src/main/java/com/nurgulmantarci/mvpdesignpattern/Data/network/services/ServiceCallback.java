package com.nurgulmantarci.mvpdesignpattern.Data.network.services;

public interface ServiceCallback<T> {

    void onResponce(T responce);

    void onError(String message);


}

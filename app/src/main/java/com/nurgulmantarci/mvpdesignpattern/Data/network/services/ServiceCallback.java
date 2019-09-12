package com.nurgulmantarci.mvpdesignpattern.Data.network.services;

public interface ServiceCallback<T> {

    void onResponse(T response);

    void onError(String message);


}

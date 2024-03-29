package com.nurgulmantarci.mvpdesignpattern.Data.network;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.ServiceCallback;
import com.nurgulmantarci.mvpdesignpattern.Utility.Constant;
import com.nurgulmantarci.mvpdesignpattern.Utility.Utils;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

public class NetworkError extends Throwable{
    public static final String DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again.";
    public static final String NETWORK_ERROR_MESSAGE = "Can not connect to server";
    private final Throwable error;

    public NetworkError(Throwable e) {
        super(e);
        this.error=e;
    }

    public String getMessage(){
        return error.getMessage();
    }

    public void response(ServiceCallback serviceCallback){
        if(this.error instanceof IOException){
            serviceCallback.onError(NETWORK_ERROR_MESSAGE);
        }else if(!(this.error instanceof HttpException)){
            serviceCallback.onError(DEFAULT_ERROR_MESSAGE);
        } else{
            retrofit2.Response<?> response = ((HttpException) this.error).response();
            if (!response.isSuccessful()) {
                if(response.code() == Constant.BAD_REQUEST){
                    serviceCallback.onError(DEFAULT_ERROR_MESSAGE);
                }else if(response.code()== Constant.SERVER_ERROR){
                    serviceCallback.onError(DEFAULT_ERROR_MESSAGE);
                }
                else {
                    serviceCallback.onResponse(Utils.errorHandler(response));
                }
            } else {
                serviceCallback.onError(DEFAULT_ERROR_MESSAGE);
            }
        }
    }


    public Throwable getError() {
        return error;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkError that = (NetworkError) o;
        return error != null ? error.equals(that.error) : that.error == null;
    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }


}

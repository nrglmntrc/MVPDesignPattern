package com.nurgulmantarci.mvpdesignpattern.Data.network.services;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.CommonResponce;

import java.util.List;

public interface CommandService {

    void getCommands(String language, ServiceCallback<List<Command>> listServiceCallback, ServiceCallback<CommonResponce> commonResponceServiceCallback);

}

package com.nurgulmantarci.mvpdesignpattern.Ui.CommandListActivity;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.MvpView;

import java.util.List;

public interface CommandListActivityMvpView extends MvpView {
    void loadDataToRecylerview(List<Command> listOfCommand);
}

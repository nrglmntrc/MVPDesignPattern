package com.nurgulmantarci.mvpdesignpattern.Ui.CommandListActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nurgulmantarci.mvpdesignpattern.Data.DataManager;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.EventBus.CategoryEvent;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Command;
import com.nurgulmantarci.mvpdesignpattern.Di.DaggerApplication;
import com.nurgulmantarci.mvpdesignpattern.R;
import com.nurgulmantarci.mvpdesignpattern.Ui.Adapters.CommandListRecylerViewAdapter;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.BaseActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CommandListActivity extends BaseActivity implements CommandListActivityMvpView {

    @BindView(R.id.activity_command_list_recyclerview)
    RecyclerView activityCommandListRecyclerview;

    private CommandListActivityPresenter presenter;
    private Category category;
    private CommandListRecylerViewAdapter commandListRecylerViewAdapter;

    @Inject
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_list);
        ((DaggerApplication) getApplication()).getDaggerComponent().inject(CommandListActivity.this);

        presenter=new CommandListActivityPresenter(this,dataManager);


    }

    @Override
    public void loadDataToRecylerview(List<Command> listOfCommand) {
        commandListRecylerViewAdapter =new CommandListRecylerViewAdapter(listOfCommand, new CommandListRecylerViewAdapter.ItemListener() {
            @Override
            public void onItemClick(Command item) {

            }
        });

        activityCommandListRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityCommandListRecyclerview.setAdapter(commandListRecylerViewAdapter);
    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void getCategory(CategoryEvent categoryEvent){
        category=categoryEvent.getCategory();
        presenter.getCommands(category.get_id());

    }


}

package com.nurgulmantarci.mvpdesignpattern.Ui.CategoryListActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nurgulmantarci.mvpdesignpattern.Data.DataManager;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;
import com.nurgulmantarci.mvpdesignpattern.Di.DaggerApplication;
import com.nurgulmantarci.mvpdesignpattern.Data.network.services.EventBus.CategoryEvent;
import com.nurgulmantarci.mvpdesignpattern.R;
import com.nurgulmantarci.mvpdesignpattern.Ui.Adapters.CategoryListRecylerView;
import com.nurgulmantarci.mvpdesignpattern.Ui.Base.BaseActivity;
import com.nurgulmantarci.mvpdesignpattern.Ui.CommandListActivity.CommandListActivity;
import com.nurgulmantarci.mvpdesignpattern.Utility.Utils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class CategoryListActivity extends BaseActivity implements CategoryListActivityMvpView {

    @Inject
    DataManager dataManager;

    @BindView(R.id.activity_category_list_recylerview)
    RecyclerView activityCategorylistrecyclerview;

    private CategoryListActivityPresenter presenter;
    private CategoryListRecylerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_category_list);
        ((DaggerApplication)getApplication()).getDaggerComponent().inject(CategoryListActivity.this);

        presenter=new CategoryListActivityPresenter(this,dataManager);
        presenter.getCategoryList("ENG");

    }

    @Override
    public void loadDataToRecyclerview(List<Category> listOfCategory) {
        adapter=new CategoryListRecylerView(listOfCategory, new CategoryListRecylerView.ItemListener() {
            @Override
            public void onItemClick(Category item) {
                EventBus.getDefault().postSticky(new CategoryEvent(item));
                Utils.changeActivity(CategoryListActivity.this, CommandListActivity.class);
            }
        });
        activityCategorylistrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        activityCategorylistrecyclerview.setAdapter(adapter);
    }
}

package com.nurgulmantarci.mvpdesignpattern.EventBus;

import com.nurgulmantarci.mvpdesignpattern.Data.network.services.models.Category;

public class CategoryEvent {

    private Category category;

    public CategoryEvent(Category category){
        this.category=category;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category=category;
    }
}

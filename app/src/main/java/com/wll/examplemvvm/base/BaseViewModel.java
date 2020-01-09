package com.wll.examplemvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.ArrayList;

/**
 * Created by leo
 * on 2019/10/15.
 */

public abstract class BaseViewModel<T extends BaseModel> extends AndroidViewModel {
    private T repository;
    private ArrayList<String> onNetTags;


    public BaseViewModel(@NonNull Application application) {
        super(application);
        createRepository();
        onNetTags = new ArrayList<>();
        repository.setOnNetTags(onNetTags);
    }

    /**
     * 设置LifecycleTransformer
     * @param objectLifecycleTransformer
     */
    public void setObjectLifecycleTransformer(LifecycleTransformer objectLifecycleTransformer) {
        if (repository!=null){
            repository.setObjectLifecycleTransformer(objectLifecycleTransformer);
        }
    }


    public void createRepository() {
        if (repository == null) {
            repository = (T) new RepositoryImpl();
        }
    }


    public T getRepository() {
        return repository;
    }


    @Override
    protected void onCleared() {
        super.onCleared();

    }
}

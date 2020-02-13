package com.wll.examplemvvm.fragment.publichao.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.fragment.publichao.model.PublicHaoBean;

import java.util.List;

/**
 * @author wanglili
 * @description: 公众号的列表的vm
 * @date : 2020-01-10 11:11
 */
public class PublicHaoViewModel extends BaseViewModel<RepositoryImpl> {


    public PublicHaoViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取公共号分类列表
     * @return
     */
    public LiveData<Resource<List<PublicHaoBean>>> getPublicList() {
        return getRepository().getPublictypeList();
    }
}

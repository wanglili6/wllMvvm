package com.wll.examplemvvm.ui.thepublic.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.wll.examplemvvm.base.BaseViewModel;
import com.wll.examplemvvm.base.RepositoryImpl;
import com.wll.examplemvvm.bean.Resource;
import com.wll.examplemvvm.ui.thepublic.model.PublicHistoryFaterBean;

/**
 * @author wanglili
 * @description: 历史公众号的vm
 * @date : 2020-01-10 16:17
 */
public class PublicHistoryViewModel extends BaseViewModel<RepositoryImpl> {

    public PublicHistoryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<PublicHistoryFaterBean>> getPublicHistoryList(int id, int page) {
        return getRepository().getPublicHistoryList(id, page);
    }
}

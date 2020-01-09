package com.wll.examplemvvm.utils;

import androidx.lifecycle.MutableLiveData;


import com.wll.examplemvvm.retrofitrxjava.uploadutils.UploadFileRequestBody;

import java.io.File;
import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by leo
 * on 2019/11/7.
 */
public class MultipartBodyUtils {
    public static MultipartBody.Part getBody(MutableLiveData liveData, Map<String, File> files) {
        UploadFileRequestBody uploadFileRequestBody = new UploadFileRequestBody(files, liveData);
        MultipartBody.Part body = MultipartBody.Part.create(uploadFileRequestBody);
        return body;
    }
}

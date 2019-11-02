package com.example.kanmeitu.api;

import com.example.kanmeitu.domain.Image;
import com.example.kanmeitu.domain.response.ListRespose;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by smile on 10/27/2019
 */
public interface Service {
    /**
     * 获取图片列表
     * @return
     */
    @GET("v1/images")
    Observable<ListRespose<Image>> images();
}

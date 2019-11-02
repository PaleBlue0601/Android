package com.example.kanmeitu.domain.response;

import java.util.List;

public class ListRespose<T> {
    private List<T> data;

    public List<T> getData(){
        return data;
    }

    public void setData(List<T> data){
        this.data = data;
    }
}

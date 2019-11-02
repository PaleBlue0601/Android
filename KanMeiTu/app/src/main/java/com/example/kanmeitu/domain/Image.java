package com.example.kanmeitu.domain;

public class Image {
    /**
     * 图片url
     */
    private String uri;

    public Image(String uri){
        this.uri = uri;
    }

    public String getUrl(){
        return this.uri;
    }

    public void setUrl(String uri){
        this.uri = uri;
    }
}

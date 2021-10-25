package com.example.wechart.DTO;

import android.widget.ImageView;
import android.widget.TextView;

public class WeixinContent {
    private Integer weChatAvatarId;
    private String weChatName;
    private String weChatContent;
    private String weChatTime;



    public WeixinContent(Integer weChatAvaterId, String weChatName, String weChatContent, String weChatTime) {
        this.weChatAvatarId = weChatAvaterId;
        this.weChatName = weChatName;
        this.weChatContent = weChatContent;
        this.weChatTime = weChatTime;

    }

    public WeixinContent() {

    }

    public Integer getWeChatAvaterId() {
        return weChatAvatarId;
    }

    public void setWeChatAvaterId(Integer weChatAvaterId) {
        this.weChatAvatarId = weChatAvaterId;
    }

    public String getWeChatName() {
        return weChatName;
    }

    public void setWeChatName(String weChatName) {
        this.weChatName = weChatName;
    }

    public String getWeChatContent() {
        return weChatContent;
    }

    public void setWeChatContent(String weChatContent) {
        this.weChatContent = weChatContent;
    }

    public String getWeChatTime() {
        return weChatTime;
    }

    public void setWeChatTime(String weChatTime) {
        this.weChatTime = weChatTime;
    }

}


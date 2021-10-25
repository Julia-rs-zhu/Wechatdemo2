package com.example.wechart.DTO;

public class WeixindetailContent {
    private Integer weChatdetailAvatarId;
    private String weChatdetailContent;
    private String weChatdetailTime;



    public WeixindetailContent(Integer weChatdetailAvatarId, String weChatdetailContent, String weChatdetailTime) {
        this.weChatdetailAvatarId = weChatdetailAvatarId;
        this.weChatdetailContent = weChatdetailContent;
        this.weChatdetailTime = weChatdetailTime;

    }

    public WeixindetailContent() {

    }

    public Integer getWeChatdetailAvaterId() {
        return weChatdetailAvatarId;
    }

    public void setWeChatdetailAvaterId(Integer weChatAvaterId) {
        this.weChatdetailAvatarId = weChatAvaterId;
    }

    public String getWeChatdetailContent() {
        return weChatdetailContent;
    }

    public void setWeChatdetailContent(String weChatContent) {
        this.weChatdetailContent = weChatContent;
    }

    public String getWeChatdetailTime() {
        return weChatdetailTime;
    }

    public void setWeChatdetailTime(String weChatTime) {
        this.weChatdetailTime = weChatTime;
    }
}

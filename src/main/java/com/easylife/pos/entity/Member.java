package com.easylife.pos.entity;

import java.util.Date;

public class Member {
    private Integer mid;
    private String mno;
    private String mnickname;
    private String maccount;
    private String mpassword;
    private String memail;
    private String mphone;
    private String mfrom;
    private String msex;
    private Date createtime;
    
    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMnickname() {
        return mnickname;
    }

    public void setMnickname(String mnickname) {
        this.mnickname = mnickname;
    }

    public String getMaccount() {
        return maccount;
    }

    public void setMaccount(String maccount) {
        this.maccount = maccount;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMfrom() {
        return mfrom;
    }

    public void setMfrom(String mfrom) {
        this.mfrom = mfrom;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMsex() {
        return msex;
    }

    public void setMsex(String msex) {
        this.msex = msex;
    }
    
    
    
}

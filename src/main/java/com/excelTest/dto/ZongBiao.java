package com.excelTest.dto;

public class ZongBiao {
    /**
     * 所属区域
     */
    private String region;
    /**
     * 医院代码
     */
    private String hcode;
    /**
     * 医院名称
     */
    private String hname;
    /**
     * 药厂代码
     */
    private String ycode;
    /**
     * 药厂名称
     */
    private String yname;
    /**
     * 医院应上传处方数
     */
    private String hUploadNum;
    /**
     * 医院上传的处方数
     */
    private String yUploadNum;
    /**
     * 门诊处方数
     */
    private String mzcfNum;
    /**
     * 住院处方数
     */
    private String zycfNum;
    /**
     * 互联网处方数
     */
    private String hlwcfNum;
    /**
     * 匹配数
     */
    private String ppNum;
    /**
     * 门诊匹配数
     */
    private String mzNum;
    /**
     * 住院匹配数
     */
    private String zyNum;
    /**
     * 互联网匹配数
     */
    private String hlwNUM;
    /**
     * 药厂上传处方数
     */
    private String ycUploadNum;
    /**
     * 医院上传，药厂没有上传 （空格分隔）
     */
    private String unUploadYC;
    /**
     * 药厂上传，医院没有上传 （空格分隔）
     */
    private String unUploadYY;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHcode() {
        return hcode;
    }

    public void setHcode(String hcode) {
        this.hcode = hcode;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getYcode() {
        return ycode;
    }

    public void setYcode(String ycode) {
        this.ycode = ycode;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public String gethUploadNum() {
        return hUploadNum;
    }

    public void sethUploadNum(String hUploadNum) {
        this.hUploadNum = hUploadNum;
    }

    public String getyUploadNum() {
        return yUploadNum;
    }

    public void setyUploadNum(String yUploadNum) {
        this.yUploadNum = yUploadNum;
    }

    public String getMzcfNum() {
        return mzcfNum;
    }

    public void setMzcfNum(String mzcfNum) {
        this.mzcfNum = mzcfNum;
    }

    public String getZycfNum() {
        return zycfNum;
    }

    public void setZycfNum(String zycfNum) {
        this.zycfNum = zycfNum;
    }

    public String getHlwcfNum() {
        return hlwcfNum;
    }

    public void setHlwcfNum(String hlwcfNum) {
        this.hlwcfNum = hlwcfNum;
    }

    public String getPpNum() {
        return ppNum;
    }

    public void setPpNum(String ppNum) {
        this.ppNum = ppNum;
    }

    public String getMzNum() {
        return mzNum;
    }

    public void setMzNum(String mzNum) {
        this.mzNum = mzNum;
    }

    public String getZyNum() {
        return zyNum;
    }

    public void setZyNum(String zyNum) {
        this.zyNum = zyNum;
    }

    public String getHlwNUM() {
        return hlwNUM;
    }

    public void setHlwNUM(String hlwNUM) {
        this.hlwNUM = hlwNUM;
    }

    public String getYcUploadNum() {
        return ycUploadNum;
    }

    public void setYcUploadNum(String ycUploadNum) {
        this.ycUploadNum = ycUploadNum;
    }

    public String getUnUploadYC() {
        return unUploadYC;
    }

    public void setUnUploadYC(String unUploadYC) {
        this.unUploadYC = unUploadYC;
    }

    public String getUnUploadYY() {
        return unUploadYY;
    }

    public void setUnUploadYY(String unUploadYY) {
        this.unUploadYY = unUploadYY;
    }
}

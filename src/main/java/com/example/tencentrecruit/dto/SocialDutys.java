package com.example.tencentrecruit.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:16
 * @since JDK 1.8
 */


public class SocialDutys {
    /**
     * 社会招聘职务的id
     */
    private int sId;
    /**
     * 社会招聘职务的职责
     */
    private String sReq;
    /**
     * 社会招聘职务的要求
     */
    private String sRes;
    /**
     * 社会招聘职务的工作地址
     */
    private String sAddress;
    /**
     * 社会招聘职务的名字
     */
    private String sName;
    /**
     * 社会招聘职务的类型
     */
    private String sType;
    /**
     * 社会招聘职务的人数
     */
    private int sPeoNum;
    /**
     * 社会招聘职务的发布时间
     */
    private String sDate;
    /**
     * 社会招聘职务的年信息
     */
    private int yearInfo;
    /**
     * 社会招聘职务的月信息
     */
    private int monthInfo;
    /**
     * 社会招聘职务的日信息
     */
    private int dayInfo;

    public SocialDutys() {
    }

    public SocialDutys(int sId, String sAddress, String sName, String sType, int sPeoNum, String sDate, int yearInfo, int monthInfo, int dayInfo) {
        this.sId = sId;
        this.sAddress = sAddress;
        this.sName = sName;
        this.sType = sType;
        this.sPeoNum = sPeoNum;
        this.sDate = sDate;
        this.yearInfo = yearInfo;
        this.monthInfo = monthInfo;
        this.dayInfo = dayInfo;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public int getsPeoNum() {
        return sPeoNum;
    }

    public void setsPeoNum(int sPeoNum) {
        this.sPeoNum = sPeoNum;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public int getYearInfo() {
        return yearInfo;
    }

    public void setYearInfo(int yearInfo) {
        this.yearInfo = yearInfo;
    }

    public int getMonthInfo() {
        return monthInfo;
    }

    public void setMonthInfo(int monthInfo) {
        this.monthInfo = monthInfo;
    }

    public int getDayInfo() {
        return dayInfo;
    }

    public void setDayInfo(int dayInfo) {
        this.dayInfo = dayInfo;
    }

}

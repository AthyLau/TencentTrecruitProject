package com.example.tencentrecruit.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2018/10/16 下午9:16
 * @since JDK 1.8
 */


public class ColleageDutys {
    /**
     * 校园招聘职务的id
     */
    private int cId;
    /**
     * 校园招聘职务的名字
     */
    private String cName;
    /**
     * 校园招聘职务的类型
     */
    private String cType;
    /**
     * 校园招聘职务的工作地址
     */
    private String cAddress;
    /**
     * 校园招聘职务的需求
     */
    private String cRequest;
    /**
     * 校园招聘职务的描述
     */
    private String cDescribe;
    /**
     * 校园招聘职务的的详情链接
     */
    private String cLink;
    /**
     * 校园招聘职务的年信息
     */
    private int yearInfo;
    /**
     * 校园招聘职务的月信息
     */
    private int monthInfo;
    /**
     * 校园招聘职务的日信息
     */
    private int dayInfo;

    public ColleageDutys() {
    }

    public ColleageDutys(int cId, String cName, String cType, String cAddress, String cRequest, String cDescribe, String cLink, int yearInfo, int monthInfo, int dayInfo) {
        this.cId = cId;
        this.cName = cName;
        this.cType = cType;
        this.cAddress = cAddress;
        this.cRequest = cRequest;
        this.cDescribe = cDescribe;
        this.cLink = cLink;
        this.yearInfo = yearInfo;
        this.monthInfo = monthInfo;
        this.dayInfo = dayInfo;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcRequest() {
        return cRequest;
    }

    public void setcRequest(String cRequest) {
        this.cRequest = cRequest;
    }

    public String getcDescribe() {
        return cDescribe;
    }

    public void setcDescribe(String cDescribe) {
        this.cDescribe = cDescribe;
    }

    public String getcLink() {
        return cLink;
    }

    public void setcLink(String cLink) {
        this.cLink = cLink;
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

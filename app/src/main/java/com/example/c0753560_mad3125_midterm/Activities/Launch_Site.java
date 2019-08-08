package com.example.c0753560_mad3125_midterm.Activities;

public class Launch_Site
{
    private String siteID;
    private String siteName;
    private String siteNameLong;

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

    public Launch_Site(String siteID, String siteName, String siteNameLong) {
        this.siteID = siteID;
        this.siteName = siteName;
        this.siteNameLong = siteNameLong;
    }
}

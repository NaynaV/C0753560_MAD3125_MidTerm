package com.example.c0753560_mad3125_midterm.JavaClass;

public class FlightMain
{
    private String filghtNumber;
    private String missionName;
    private String upcoming;
    private String launchYear;
    private String launchWindow;
    private String details;
    Rocket rocket;
    Launch_Site launchSite;
    Links links;

    public FlightMain(String filghtNumber, String missionName, String upcoming, String launchYear, String launchWindow, String details, Rocket rocket, Launch_Site launchSite, Links links) {
        this.filghtNumber = filghtNumber;
        this.missionName = missionName;
        this.upcoming = upcoming;
        this.launchYear = launchYear;
        this.launchWindow = launchWindow;
        this.details = details;
        this.rocket = rocket;
        this.launchSite = launchSite;
        this.links = links;
    }

    public String getFilghtNumber() {
        return filghtNumber;
    }

    public void setFilghtNumber(String filghtNumber) {
        this.filghtNumber = filghtNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(String upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public String getLaunchWindow() {
        return launchWindow;
    }

    public void setLaunchWindow(String launchWindow) {
        this.launchWindow = launchWindow;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Launch_Site getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(Launch_Site launchSite) {
        this.launchSite = launchSite;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }
}

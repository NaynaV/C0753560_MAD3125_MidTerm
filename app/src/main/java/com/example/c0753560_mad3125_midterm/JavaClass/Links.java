package com.example.c0753560_mad3125_midterm.JavaClass;

public class Links
{
    private String missionPatchSmall;
    private String articleLink;
    private String wikipedia;
    private String videoLink;

    public Links(String missionPatchSmall, String articleLink, String wikipedia, String videoLink) {
        this.missionPatchSmall = missionPatchSmall;
        this.articleLink = articleLink;
        this.wikipedia = wikipedia;
        this.videoLink = videoLink;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}

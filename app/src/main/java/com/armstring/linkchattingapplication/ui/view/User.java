package com.armstring.linkchattingapplication.ui.view;

/**
 * Created by Darkwood on 12/27/2017.
 */

public class User {
    private String name;
    private String status;
    private String image;

    public User(){

    }

    public User(String name, String status, String image) {
        this.name = name;
        this.status = status;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

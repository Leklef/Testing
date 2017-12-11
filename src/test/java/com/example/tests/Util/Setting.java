package com.example.tests.Util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Setting {
    private String name;
    private String baseURL;
    private String email;
    private String password;

    public String getBaseURL() {
        return baseURL;
    }

    @XmlElement
    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }


    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
}

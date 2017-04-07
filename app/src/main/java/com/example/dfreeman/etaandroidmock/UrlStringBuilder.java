package com.example.dfreeman.etaandroidmock;

public class UrlStringBuilder {

    public String getRoutesUrl(int company) {
        return "http://ec2-204-236-211-33.compute-1.amazonaws.com:8080/companies/" + company + "/routes";
    }
}
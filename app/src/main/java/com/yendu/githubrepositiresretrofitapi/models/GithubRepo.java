package com.yendu.githubrepositiresretrofitapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubRepo {

    @SerializedName("name")
    @Expose
    String name;

    public String getName() {
        return name;
    }
}

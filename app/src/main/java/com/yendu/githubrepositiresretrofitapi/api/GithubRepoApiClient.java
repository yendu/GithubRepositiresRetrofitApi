package com.yendu.githubrepositiresretrofitapi.api;

import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubRepoApiClient {

    @GET("/users/{users}/repos")
    Call<List<GithubRepo>> getGithubRepoList(@Path("user")String user);

}

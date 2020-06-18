package com.yendu.githubrepositiresretrofitapi.repositories;

import androidx.lifecycle.MutableLiveData;

import com.yendu.githubrepositiresretrofitapi.api.GithubRepoApiClient;
import com.yendu.githubrepositiresretrofitapi.api.RetrofitService;
import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepoWebRepository {

    private GithubRepoApiClient githubRepoApiClient;

    public GithubRepoWebRepository(){
        githubRepoApiClient= RetrofitService.createService(GithubRepoApiClient.class);

    }

    public MutableLiveData<List<GithubRepo>> getRepos(String name){
        final MutableLiveData<List<GithubRepo>> repoData=new MutableLiveData<>();
        githubRepoApiClient.getGithubRepoList(name).enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {

               if(response.isSuccessful()){
                   repoData.setValue(response.body());
               }
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

                repoData.setValue(null);

            }
        });
        return repoData;
    }
}

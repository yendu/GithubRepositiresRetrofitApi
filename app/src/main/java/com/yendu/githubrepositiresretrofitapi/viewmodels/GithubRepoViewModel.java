package com.yendu.githubrepositiresretrofitapi.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;
//import com.yendu.githubrepositiresretrofitapi.repositories.GithubRepoRoomRepository;
import com.yendu.githubrepositiresretrofitapi.repositories.GithubRepoRoomRepository;
import com.yendu.githubrepositiresretrofitapi.repositories.GithubRepoWebRepository;

import java.util.List;

public class GithubRepoViewModel extends AndroidViewModel {

    MutableLiveData<List<GithubRepo>> listRepos;
    private GithubRepoRoomRepository githubRepoRoomRepository;
    private GithubRepoWebRepository githubRepoWebRepository;
    public GithubRepoViewModel(@NonNull Application application) {
        super(application);
        githubRepoRoomRepository=new GithubRepoRoomRepository(application);
        githubRepoWebRepository=new GithubRepoWebRepository();

        listRepos=githubRepoWebRepository.getRepos("yendu");

//        listRepos.observe(this, new Observer<List<GithubRepo>>() {
//            @Override
//            public void onChanged(List<GithubRepo> repos) {
//
//            }
//        });
       // githubRepoRoomRepository.insert(listRepos.getValue());
    }

    public LiveData<List<GithubRepo>> listRepo(){
        return listRepos;
    }


}

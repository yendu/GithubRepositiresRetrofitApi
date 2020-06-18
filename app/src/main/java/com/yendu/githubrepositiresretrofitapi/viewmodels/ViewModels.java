package com.yendu.githubrepositiresretrofitapi.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;
import com.yendu.githubrepositiresretrofitapi.repositories.GithubRepoRoomRepository;
import com.yendu.githubrepositiresretrofitapi.repositories.GithubRepoWebRepository;

import java.util.List;

public class ViewModels extends AndroidViewModel {

    MutableLiveData<List<GithubRepo>> listRepos;
    private GithubRepoRoomRepository githubRepoRoomRepository;
    private GithubRepoWebRepository githubRepoWebRepository;
    public ViewModels(@NonNull Application application) {
        super(application);
        githubRepoRoomRepository=new GithubRepoRoomRepository(application);
        githubRepoWebRepository=new GithubRepoWebRepository();

        listRepos=githubRepoWebRepository.getRepos("yendu");
        githubRepoRoomRepository.insert(listRepos.getValue());
    }

    public LiveData<List<GithubRepo>> listRepo(){
        return listRepos;
    }


}

package com.yendu.githubrepositiresretrofitapi.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;
import com.yendu.githubrepositiresretrofitapi.room.AppDatabase;
import com.yendu.githubrepositiresretrofitapi.room.daos.GithubRepoDao;

import java.util.List;

public class GithubRepoRoomRepository {

    private GithubRepoDao dao;
    private LiveData<List<GithubRepo>> mGithubRepos;
    public GithubRepoRoomRepository(Application application){
        AppDatabase appDatabase=AppDatabase.getDatabase(application);
        dao=appDatabase.githubRepoDao();
        mGithubRepos=dao.getRepos();
    }

    public void insert(List<GithubRepo>lists){
        AppDatabase.databaseWriteExecutor.execute(()->{
            dao.insertRepos(lists);
        });
    }

    public LiveData<List<GithubRepo>> getmGithubRepos(){
        return this.mGithubRepos;
    }


}

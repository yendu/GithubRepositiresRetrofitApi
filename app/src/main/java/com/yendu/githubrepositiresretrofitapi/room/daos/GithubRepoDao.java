package com.yendu.githubrepositiresretrofitapi.room.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;

import java.util.List;

@Dao
public interface GithubRepoDao {
    @Query("SELECT * from githubrepo ORDER BY name ASC")
    LiveData<List<GithubRepo>> getRepos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRepos(List<GithubRepo>repos);
}

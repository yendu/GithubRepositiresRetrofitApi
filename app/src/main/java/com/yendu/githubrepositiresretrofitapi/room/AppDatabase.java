package com.yendu.githubrepositiresretrofitapi.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.android.material.appbar.AppBarLayout;
import com.yendu.githubrepositiresretrofitapi.room.daos.GithubRepoDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AppDatabase extends RoomDatabase {

    public abstract GithubRepoDao githubRepoDao();
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    public static final ExecutorService databaseWriteExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (AppDatabase.class){
                INSTANCE= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"app_database")
                        .build();
            }
        }

        return INSTANCE;
    }
}

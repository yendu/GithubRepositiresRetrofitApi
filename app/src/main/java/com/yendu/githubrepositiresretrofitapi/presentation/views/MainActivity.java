package com.yendu.githubrepositiresretrofitapi.presentation.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yendu.githubrepositiresretrofitapi.R;
import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;
import com.yendu.githubrepositiresretrofitapi.presentation.GithubReposAdapter;
import com.yendu.githubrepositiresretrofitapi.viewmodels.GithubRepoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GithubReposAdapter githubReposAdapter;
    GithubRepoViewModel repoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        repoViewModel= new ViewModelProvider(this).get(GithubRepoViewModel.class);
        githubReposAdapter=new GithubReposAdapter(this);


        repoViewModel.listRepo().observe(this, new Observer<List<GithubRepo>>() {
            @Override
            public void onChanged(List<GithubRepo> repos) {


                githubReposAdapter.setRepos(repos);
            }
        });

    }
}

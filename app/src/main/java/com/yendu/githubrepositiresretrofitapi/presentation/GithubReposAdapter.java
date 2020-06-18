package com.yendu.githubrepositiresretrofitapi.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ListViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.yendu.githubrepositiresretrofitapi.R;
import com.yendu.githubrepositiresretrofitapi.models.GithubRepo;

import java.util.List;

public class GithubReposAdapter extends RecyclerView.Adapter<GithubReposAdapter.GitRepoViewHolder>{

    private List<GithubRepo> githubRepoList;
    Context context;

    public GithubReposAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public GitRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.repo_item_view,parent,false);
        return new GitRepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitRepoViewHolder holder, int position) {

        holder.textView.setText(githubRepoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return githubRepoList==null ? 0:githubRepoList.size();
    }
    public void setRepos(List<GithubRepo>list){
        this.githubRepoList=list;
        notifyDataSetChanged();
    }

    public static class GitRepoViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public GitRepoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}

package com.codepath.synkae.cst438_proj1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.synkae.cst438_proj1.models.Job;

import java.util.ArrayList;

public class JobRecycleAdapter extends RecyclerView.Adapter<JobRecycleAdapter.JobViewHolder> {
    private ArrayList<Job> jobArrayList;
    private Context mContext;

    public JobRecycleAdapter(ArrayList<Job> jobArrayList, Context context){
        this.jobArrayList = jobArrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_job, parent,false);
        JobViewHolder jobEVH = new JobViewHolder(view);
        return jobEVH;
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobArrayList.get(position);
        /*
        if (!job.getCompany_logo_url().isEmpty()){
            Glide.with(mContext)
                    .asBitmap()
                    .load(job.getCompany_logo_url())
                    .into(holder.ivLogo);
        }
        */
        holder.tvTitle.setText(job.getTitle());
        holder.tvCompany.setText(job.getCompanyName());
    }

    @Override
    public int getItemCount() {
        return jobArrayList.size();
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivLogo;
        public TextView tvTitle;
        public TextView tvCompany;
        public Button btnAdd;
        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}

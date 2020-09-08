package com.example.trial1;

import android.util.LayoutDirection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.annotation.Target;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DatakuViewHolder> {
        private ArrayList<model> datalist;
        private Callback callback;
        View view;
        int posku;

        interface Callback{
            void onClick(int position);
            void test();
        }

        public DataAdapter(ArrayList<model> datlist,Callback callback){
            this.callback =callback;
            this.datalist = datalist;
            Log.d("makanan", "MahasiswaAdapter: "+datlist.size()+"" );
        }


    @Override
    public DatakuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.adapterrv, parent, false);
        return new DatakuViewHolder(view);
        }

    @Override
    public void onBindViewHolder(final DataAdapter.DatakuViewHolder holder, int position) {
        holder.txtNama.setText(datalist.get(position).getOriginal_title());
        holder.txtNpm.setText(datalist.get(position).getOverview());
        Log.d("makanan", "onBindViewHolder: "+datalist.get(position).getPoster_path());
        Glide.with(holder.itemView)
                .load(datalist.get(position).getPoster_path())
                .override(Target.SIZE_ORIGINAL)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivprofile)
    }
}
}

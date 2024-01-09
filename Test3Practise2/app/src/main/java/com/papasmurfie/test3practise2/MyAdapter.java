package com.papasmurfie.test3practise2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RVHolder> {
    private List<AvtobusDataModel> avtobusiList;
    private Context context;
    private MainActivity intentFromA1;
    private MainActivityCallback mainActivityCallback;


    public MyAdapter(List<AvtobusDataModel> avtobusiList, Context context, MainActivity intent, MainActivityCallback mainActivityCallback) {
        this.avtobusiList = avtobusiList;
        this.context = context;
        this.mainActivityCallback = mainActivityCallback;
        this.intentFromA1 = intent;
    }
    public void addNewItem(AvtobusDataModel newBus){
        avtobusiList.add(newBus);
        notifyItemInserted(avtobusiList.size() - 1);
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout, parent, false);
        RVHolder rvHolder = new RVHolder(view);
        return  rvHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        AvtobusDataModel oneBus = avtobusiList.get(position);
        holder.setNapravlenieTV(oneBus.getNapravlenie());
        holder.setChasTV(oneBus.getChasTrugvane());
        holder.setStatusTV(oneBus.getStatus());
        //produlji s onClick
        holder.itemView.setOnLongClickListener(view ->{
            Bundle bundle = new Bundle();
            bundle.putParcelable("bus", oneBus);
            bundle.putInt("pos", position);
            BlankFragment fragment = BlankFragment.newInstance(bundle);
            fragment.setListener((FragmentListener)context);
            FragmentManager fragmentManager = ((AppCompatActivity)view.getContext()).getSupportFragmentManager();
            fragment.show(fragmentManager, "NewDialogFragment");
            return false;
        });
        holder.itemView.setOnClickListener(view -> {
            //Tuk zaredi aktivity 2 !!
            mainActivityCallback.startA2WithIntent(intentFromA1.intent, oneBus);
        });
    }

    @Override
    public int getItemCount() {
        return avtobusiList.size();
    }
    public void updateItem(int position, AvtobusDataModel updatedBus){
        avtobusiList.set(position, updatedBus);
        notifyItemChanged(position);
    }
}

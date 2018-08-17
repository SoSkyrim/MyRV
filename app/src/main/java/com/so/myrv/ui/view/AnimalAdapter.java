package com.so.myrv.ui.view;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter {

    private AdapterDelegatesManager<List<Animal>> delegatesManager;
    private List<Animal> items;

    public AnimalAdapter(Activity activity, List<Animal> items) {
        this.items = items;

        delegatesManager = new AdapterDelegatesManager<>();

        // AdapterDelegatesManager internally assigns view types integers
        delegatesManager.addDelegate(new CatAdapterDelegate(activity))
                .addDelegate(new DogAdapterDelegate(activity));

        // You can explicitly assign integer view type if you want to
//        delegatesManager.addDelegate(23, new SnakeAdapterDelegate(activity));
    }

    @Override public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override public int getItemCount() {
        return items.size();
    }
}

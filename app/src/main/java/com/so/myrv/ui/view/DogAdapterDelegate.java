package com.so.myrv.ui.view;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.so.myrv.R;

import java.util.List;

public class DogAdapterDelegate extends AdapterDelegate<List<Animal>> {

    private LayoutInflater inflater;

    public DogAdapterDelegate(Activity activity) {
        inflater = activity.getLayoutInflater();
    }

    @Override
    public boolean isForViewType(@NonNull List<Animal> items, int position) {
        return items.get(position) instanceof Dog;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new DogViewHolder(inflater.inflate(R.layout.rv_txt_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<Animal> items, int position,
                                 @NonNull RecyclerView.ViewHolder holder, @Nullable List<Object> payloads) {

        DogViewHolder vh = (DogViewHolder) holder;
        Dog dog = (Dog) items.get(position);

        vh.name.setText(dog.getName());
    }

    static class DogViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public DogViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_txt);
        }
    }
}

package com.so.myrv.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.so.myrv.R;
import com.so.myrv.ui.adapter.MyRVAdapter;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvMain.setLayoutManager(linearLayoutManager);

//        ArrayList<Animal> animals = new ArrayList<>();
//        animals.add(new Dog("a"));
//        animals.add(new Dog("b"));
//        animals.add(new Dog("c"));
//        animals.add(new Dog("d"));
//        animals.add(new Cat("a"));
//        animals.add(new Cat("b"));
//        animals.add(new Cat("c"));
//        animals.add(new Cat("d"));
//        AnimalAdapter animalAdapter = new AnimalAdapter(this, animals);
//        mRvMain.setAdapter(animalAdapter);

        mRvMain.setAdapter(new MyRVAdapter(this));
    }
}

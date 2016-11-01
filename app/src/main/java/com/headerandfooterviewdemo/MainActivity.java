package com.headerandfooterviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);

        List<String> list=new ArrayList<>();
        for (int i=0;i<50;i++){
            list.add("yangtuhua"+i);
        }
        MyAdapter myAdapter=new MyAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        View view= LayoutInflater.from(this).inflate(R.layout.item_view,null);
        TextView tv= (TextView) view.findViewById(R.id.text);
        tv.setText("我是头部view");

        View view1= LayoutInflater.from(this).inflate(R.layout.item_view,null);
        TextView tv1= (TextView) view1.findViewById(R.id.text);
        tv1.setText("你猜是头部view");

        HeaderAndFooterWrapper wrapper=new HeaderAndFooterWrapper(myAdapter);
        wrapper.addHeaderView(view);
        wrapper.addHeaderView(view1);
        wrapper.addFootView(view);
        wrapper.addFootView(view1);
        recyclerView.setAdapter(wrapper);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}

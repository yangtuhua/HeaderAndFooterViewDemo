package com.headerandfooterviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yangtufa on 2016/10/27.
 */

public class CountingView extends FrameLayout{

    private Context context;
    private TextView tvCount;
    private ImageView ivAdd;
    private ImageView ivReduce;
    private int count;

    public CountingView(Context context) {
        super(context);
        this.context=context;
    }

    public CountingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }
    //获取计数
    private int getCount(){
        return count;
    }

    //初始化view
    private void initView() {
        View view =  LayoutInflater.from(context).inflate(R.layout.count_view,this);

        tvCount= (TextView) view.findViewById(R.id.tv_count);

        ivAdd= (ImageView) view.findViewById(R.id.add);
        ivReduce= (ImageView) view.findViewById(R.id.reduce);

        setListener();
    }

    private void setListener() {
        ivAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                addCount();
            }
        });

        ivReduce.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                reduceCount();
            }
        });
    }

    private void reduceCount() {
        if(count>0){
            count--;
        }
        tvCount.setText(String.valueOf(count));
    }

    private void addCount() {
        if(count<100){
            count++;
        }
        tvCount.setText(String.valueOf(count));
    }
}

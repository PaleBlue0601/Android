package com.example.hasee.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/*
* 这是一个适配器
* Android中大部分列表都是通过适配器指定数据等信息
* */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final Context context;
    private final ArrayList<String> strings;

    /*
    * 构造方法
    * @param context
    * @param strings
    * */
    public ListAdapter(Context context, ArrayList<String> strings){
        this.context = context;
        this.strings = strings;
        inflater = LayoutInflater.from(context);
    }

    /*
    * 根据要显示的内容创建一个ViewHolder
    * @param parent
    * @param viewType
    * @return
    * */
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        一定要把parent传递到inflater方法里
        return new ViewHolder(inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false));
    }
    /*
    * 当对应得数据显示到ViewHolder
    * @param holder
    * @param position
    * @return
    * */
    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        holder.bindData(strings.get(position));
    }
    /*
    * 显示多少条内容
    * @return
    * */
    @Override
    public int getItemCount() {
        return strings.size();
    }

    /*
    * 创建一个ViewHolder
    * 简单理解为这个控件显示到界面上需要的对象是ViewHolder
    * */
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView text1;

        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView)itemView.findViewById(android.R.id.text1);
        }

        public void bindData(String s) {
            text1.setText(s);
        }
    }
}

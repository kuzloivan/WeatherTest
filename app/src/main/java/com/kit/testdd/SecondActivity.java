package com.kit.testdd;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan.k on 25.03.2016.
 */
public class SecondActivity extends AppCompatActivity{

    private ListView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        list = (ListView) findViewById(R.id.list);


        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("#" + String.valueOf(i));
        }

        list.setAdapter(new Adapter(this,data));
    }


    private static class Adapter extends BaseAdapter{

        private LayoutInflater inflater;
        private List<String> data;

        public Adapter(Context context,List<String> data){
            this.data = data;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String title = (String) getItem(position);
            ViewHolder holder;
            if(convertView==null){
                convertView = inflater.inflate(R.layout.item_list_item,parent,false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(title);

            return convertView;
        }
    }

    private static class ViewHolder{
        TextView textView;

        public ViewHolder(View view){
            textView = (TextView) view.findViewById(R.id.item_text);
        }
    }

}

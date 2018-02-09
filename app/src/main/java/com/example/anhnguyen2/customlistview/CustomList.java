package com.example.anhnguyen2.customlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anh.nguyen2 on 2/8/2018.
 */

public class CustomList extends Fragment {
    ArrayList<Offers> listOffers = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String Offers[] = {"Tuan anh","Tuan anh","Tuan anh","Tuan anh","Tuan anh","Tuan anh","Tuan anh"};
    int Images[] = {R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple,R.drawable.apple};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listOffers.clear();
        for(int i =0; i<Offers.length; i++){
            Offers item = new Offers();
            item.textOffers = Offers[i];
            item.imageResourceId = Images[i];
            listOffers.add(item);
        }
        getActivity().setTitle("Tuan Anh");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.custom_list, container, false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        //Quan trong nhat la cai nay
        MyLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (listOffers.size() > 0 & MyRecyclerView != null){
            MyRecyclerView.setAdapter(new MyAdapter(listOffers));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<Offers> list;
        public  MyAdapter(ArrayList<Offers> Data){
            list = Data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textOffers.setText(list.get(position).textOffers);
            holder.imageView.setImageResource(list.get(position).imageResourceId);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textOffers;
        public ImageView imageView;

        public MyViewHolder(View v) {
            super(v);
            textOffers = (TextView) v.findViewById(R.id.textOffer);
            imageView = (ImageView) v.findViewById(R.id.imageOffers);

        }
    }
}

package com.example.vickypatel.multipanelayouttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Vicky Patel on 2/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<String> mItems;
    Context mContext;
    boolean mTwoPane;

    public RecyclerViewAdapter(Context context, ArrayList<String> items, boolean mTwoPane) {
        this.mContext = context;
        this.mItems = items;
        this.mTwoPane = mTwoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.single_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.list_item);

            linearLayout.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    if(mTwoPane){
                        Bundle arguments = new Bundle();
                        arguments.putString(DetailFragment.DATA,
                                mItems.get(getAdapterPosition()));
                        DetailFragment fragment = new DetailFragment();
                        fragment.setArguments(arguments);
                        ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                    }else{
                        Context context = v.getContext();
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra(DetailFragment.DATA, mItems.get(getAdapterPosition()));
                        context.startActivity(intent);
                    }

                }
            });

        }
    }
}

package com.example.notemag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<WordDict> mWordList;
    private LayoutInflater mInflater;
    public WordListAdapter(Context context, LinkedList<WordDict> wordlist)
    {
        mInflater=LayoutInflater.from(context);
        this.mWordList=wordlist;
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView= mInflater.inflate(R.layout.wordlist_item,parent,false);
        return  new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent=mWordList.get(position).getWord();
        String mCurrent2=mWordList.get(position).getDef();
        holder.wordItemview.setText(mCurrent);
        holder.defItemview.setText(mCurrent2);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemview;
        public final TextView defItemview;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemview, WordListAdapter adapter)
        {
            super(itemview);
            wordItemview=itemview.findViewById(R.id.txtWord);
            defItemview=itemview.findViewById(R.id.txtDef);
            this.mAdapter=adapter;
        }
    }
}


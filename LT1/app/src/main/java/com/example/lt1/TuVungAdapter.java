package com.example.lt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class TuVungAdapter extends RecyclerView.Adapter<TuVungAdapter.ViewHolder> {
    private final LinkedList<TuVung> mListTu;
    private LayoutInflater mInflater;
    public TuVungAdapter(Context context,LinkedList<TuVung> mList)
    {
        mListTu=mList;
        mInflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public TuVungAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_tuvung,parent,false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull TuVungAdapter.ViewHolder holder, int position) {
        TuVung tuVung=new TuVung(mListTu.get(position).getTuVung(),mListTu.get(position).getDinhNghia());
        holder.txtTuVung.setText(tuVung.getTuVung());
        holder.txtDinhNghia.setText(tuVung.getDinhNghia());
    }

    @Override
    public int getItemCount() {
        return mListTu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTuVung;
        private TextView txtDinhNghia;
        final TuVungAdapter tuVungAdapter;
        public ViewHolder(@NonNull View itemView,TuVungAdapter adapter) {
            super(itemView);
            txtTuVung=itemView.findViewById(R.id.txtTu);
            txtDinhNghia=itemView.findViewById(R.id.txtDN);
            this.tuVungAdapter=adapter;
        }
    }
}

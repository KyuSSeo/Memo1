package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder>{


    private Activity mcontext;

    private ArrayList<MemoItem> items = new ArrayList<>();


    public MemoAdapter(Activity context) {
        mcontext = context;
    }

    public void addItem(MemoItem item) {
        items.add(item);
    }

    @NonNull
    @Override
    public MemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.item_rv_memo, parent, false) ;
        MemoAdapter.ViewHolder vh = new MemoAdapter.ViewHolder(view) ;

        return vh;
    }

    @Override
    public int getItemCount() {
        return items.size() ;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull final MemoAdapter.ViewHolder holder, final int position) {
        MemoItem item = items.get(position);
        holder.setItem(item);

        holder.view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext, ViewActivity.class);
                intent.putExtra("key",holder.date.getText().toString());
                mcontext.startActivity(intent);
            }
        });


    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView title;
        Button view_btn;
        Button delete_btn;

        ViewHolder(View itemView){
            super(itemView);

            date = itemView.findViewById(R.id.date_contain);//아이템에 들어갈 텍스트
            title = itemView.findViewById(R.id.title_contain);//아이템에 들어갈 텍스트
            view_btn = itemView.findViewById(R.id.view_btn);
            delete_btn = itemView.findViewById(R.id.delete_btn);
        }

        public void setItem(MemoItem item) {
            date.setText(item.getDate());
            title.setText(item.getTitle());

        }
    }

}
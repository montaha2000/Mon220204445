package com.afq.mon220204445;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.nameviewholder> {
    ArrayList<Model> models;
    OnnameClickListener listener;
    Context mContext;

    public ClassAdapter(ArrayList<Model> mValues, Context mContext) {
        this.models = mValues;
        this.mContext = mContext;

    }

    public interface OnnameClickListener {
        void onnameItemClick(int position);

    }


    public void OnnameClickListener(ArrayList<Model> models, Context mContext) {
        this.models = models;
        this.mContext = mContext;

    }

    public void OnnameClickListener(OnnameClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public nameviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        nameviewholder holder = new nameviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull nameviewholder holder, int position) {
        Model model = models.get(position);

        holder.txtName.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    class nameviewholder extends RecyclerView.ViewHolder {

        private TextView txtName;
        Intent intent;


        public nameviewholder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.textView);

            intent = new Intent();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onnameItemClick(position);
                        }
                    }

                }
            });
        }
    }
}




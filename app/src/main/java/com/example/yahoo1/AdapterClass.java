package com.example.yahoo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass extends  RecyclerView.Adapter<AdapterClass.ViewHolder> {

//CLC

    Context ctx;
    List<ModelClass> modelClassList;

    public AdapterClass(Context ctx, List<ModelClass> modelClassList) {
        this.ctx = ctx;
        this.modelClassList = modelClassList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(ctx).inflate(R.layout.row_layout,parent,false);

        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        ModelClass data=modelClassList.get(position);

        holder.open_rowLayout.setText("TODAY'S OPEN  - "+data.getOpen());
        holder.high_rowLayout.setText("TODAY'S HIGH   - "+data.getHigh());
        holder.low_rowLayout.setText("TODAY'S LOW    -  "+data.getLow());
        holder.closed_rowLayout.setText("TODAY'S CLOSED -  "+data.getClosed());
        holder.adjusted_rowLayout.setText("TODAY'S ADJUSTED PRICE - "+data.getAdjusted());
        holder.volume_rowLayout.setText("TODAY'S VOLUME  - "+data.getVolume());
        holder.dividend_rowLayout.setText("DIVIDEND ALERTED - "+data.getDividendAmount());
        holder.split_rowLayout.setText("SPLIT COEEFICIENT - "+data.getSplitCoefficient());

    }


    @Override
    public int getItemCount() {
        return  modelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView open_rowLayout,high_rowLayout,low_rowLayout,closed_rowLayout,adjusted_rowLayout,volume_rowLayout,dividend_rowLayout,split_rowLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            open_rowLayout=itemView.findViewById(R.id.open_rowLayout);
            high_rowLayout=itemView.findViewById(R.id.high_rowlayout);
            low_rowLayout=itemView.findViewById(R.id.low_rowlayout);
            closed_rowLayout=itemView.findViewById(R.id.closed_rowlayout);
            adjusted_rowLayout=itemView.findViewById(R.id.adjusted_rowlayout);
            volume_rowLayout=itemView.findViewById(R.id.volume_rowlayout);
            dividend_rowLayout=itemView.findViewById(R.id.dividend_rowlayout);
            split_rowLayout=itemView.findViewById(R.id.split_rowlayout);






        }
    }






}

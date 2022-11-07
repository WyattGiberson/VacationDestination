package com.example.vacationdestination;

import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<VacationDestination> destinationList;

    public MyAdapter(){
        destinationList = DataBase.getData();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vacation_row_item, parent, false);

        return new MyViewHolder(view);

    }

    //Binds data to an empty row view
    //position = index in the list you want to show
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        VacationDestination vd = destinationList.get(position);
        holder.setData(vd);
    }


    @Override
    public int getItemCount(){
        return destinationList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imvPicture;
        private TextView txtName;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            imvPicture = itemView.findViewById(R.id.imvPlace);
            txtName = itemView.findViewById(R.id.tvPlaceName);
        }
        public void setData(VacationDestination vd){
            imvPicture.setImageResource(vd.getImageId());
            txtName.setText(vd.getName());
        }
    }

}

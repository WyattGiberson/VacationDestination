package com.example.vacationdestination;

import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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

        System.out.print("DONE CREATING A SINGLE ROW'S VIEW");
        return new MyViewHolder(view);

    }

    //Binds data to an empty row view
    //position = index in the list you want to show
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        VacationDestination vd = destinationList.get(position);
        holder.setData(vd, position);

        System.out.println("DONE CREATING POPULATING A ROW: " + position + " " + vd.getName());
    }


    @Override
    public int getItemCount(){
        return destinationList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imvPicture;
        private TextView txtName;
        private ImageView imvDelete;
        private ImageView imvMakeCopy;
        private ImageView imvFavorite;

        private int currentPositionInList = -1;
        private VacationDestination currentDest = null;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            imvPicture = itemView.findViewById(R.id.imvPlace);
            txtName = itemView.findViewById(R.id.tvPlaceName);
            imvDelete = itemView.findViewById(R.id.imvDelete);
            imvMakeCopy = itemView.findViewById(R.id.imvMakeCopy);
            imvFavorite = itemView.findViewById(R.id.imvHeart);


            imvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    destinationList.remove(currentPositionInList);
                    notifyItemRemoved(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, destinationList.size());
                }
            });

            imvMakeCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    destinationList.add(currentPositionInList, currentDest);
                    notifyItemInserted(currentPositionInList);
                    notifyItemRangeChanged(currentPositionInList, destinationList.size());
                }
            });

            imvFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(currentDest.isFavorite()){
                        currentDest.setFavorite(false);
                        imvFavorite.setImageResource(R.drawable.ic_emptyheart);
                    }
                    else{
                        currentDest.setFavorite(true);
                        imvFavorite.setImageResource(R.drawable.ic_heart);
                    }
                }
            });
        }

        public void setData(VacationDestination vd, int position){
            imvPicture.setImageResource(vd.getImageId());
            txtName.setText(vd.getName());
            currentPositionInList = position;
            currentDest = vd;
            if(vd.isFavorite()) {
                imvFavorite.setImageResource(R.drawable.ic_emptyheart);
            }
        }
    }

}

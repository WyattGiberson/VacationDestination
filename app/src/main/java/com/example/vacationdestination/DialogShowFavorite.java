package com.example.vacationdestination;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogShowFavorite extends DialogFragment {

    private VacationDestination destination;


    public DialogShowFavorite(VacationDestination d){
        destination = d;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_favorite, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        CheckBox favorite = dialogView.findViewById(R.id.favoriteBox);
        if(destination.isFavorite()){
            favorite.setChecked(true);
        }
        else{
            favorite.setChecked(false);
        }
        Button btnDone = dialogView.findViewById(R.id.btnDone);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        builder.setView(dialogView);

        return builder.create();
    }

}

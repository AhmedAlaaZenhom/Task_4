package com.example.ahmed.task_4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ahmed on 3/6/2018.
 */

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<PersonClass> list;

    // Constructor with the DataSource ArrayList as a parameter
    MyAdapter(ArrayList<PersonClass> list){
        this.list = list;
    }


    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflating the Layout you designed for the single cell in the RecyclerView
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_simple_person_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        // getting the corresponding object in the arrayList to the position of each cell in the recyclerView
        // and passing it to the bindData() method
        PersonClass data = list.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView nameTextView , ageTextView , personFirstLetterTextView;
        //in the constructor we initiate the designed cell view elements using the passed View object parameter
        public MyViewHolder(View v) {
            super(v);
            nameTextView = (TextView) v.findViewById(R.id.nameTextView) ;
            ageTextView = (TextView) v.findViewById(R.id.ageTextView) ;
            personFirstLetterTextView = (TextView) v.findViewById(R.id.personFirstLetterTextView) ;
        }
        //binding data of each object to the cell's view elements
        public void bindData( PersonClass obj){
            nameTextView.setText("Name: "+obj.getFirstName().trim()+" "+obj.getLastName().trim());
            ageTextView.setText("Age: "+String.valueOf(obj.getAge()));
            personFirstLetterTextView.setText(String.valueOf(Character.toUpperCase(obj.getFirstName().charAt(0))));
        }
    }

}

package com.example.ahmed.task_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    MyAdapter adapter ;
    ArrayList<PersonClass> arrayList ;

    EditText firstNameEditText , lastNameEditText ;
    TextView ageTextView ;
    SeekBar seekBar ;
    int age = 21 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initFields();
    }

    private void initFields() {
        firstNameEditText = (EditText) findViewById(R.id.firstNameEditText) ;
        lastNameEditText= (EditText) findViewById(R.id.lastNameEditText) ;
        ageTextView  = (TextView) findViewById(R.id.currentAge) ;
        seekBar = (SeekBar) findViewById(R.id.seekBar) ;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age = progress ;
                ageTextView.setText("Age: "+String.valueOf(age));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView) ;
        LinearLayoutManager layoutManager =  new LinearLayoutManager(MainActivity.this) ;
        arrayList = new ArrayList<>() ;
        adapter = new MyAdapter(arrayList) ;

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void Add(View view){
        String firstName , lastName ;
        firstName = firstNameEditText.getText().toString() ;
        lastName = lastNameEditText.getText().toString() ;
        if(firstName.isEmpty()||lastName.isEmpty()){
            Toast.makeText(MainActivity.this,"Please Enter Valid",Toast.LENGTH_LONG).show();
            return;
        }
        arrayList.add(new PersonClass(firstName,lastName,age)) ;
        adapter.notifyDataSetChanged();
    }
}

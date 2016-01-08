package com.example.sourabh.spinnertest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> arrayList;
    private ArrayAdapter adapter;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        layout = (LinearLayout)findViewById(R.id.layout);

        arrayList = new ArrayList<String>();  //Creating a new ArrayList
        arrayList.add("Red");
        arrayList.add("Yellow");
        arrayList.add("Green");
        arrayList.add("Blue");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayList); //Creating a new adapter which takes an arraylist and display this list in a spinner via adapter

        spinner.setAdapter(adapter); //Setting adapter to a spinner

        spinner.setOnItemSelectedListener(                         //Optional
                new AdapterView.OnItemSelectedListener() {  //Whenever any list item gets touched or pressed, onItemSelected() will be called

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spinner.getSelectedItemPosition(); //returns a position of a selected item
                        switch (arrayList.get(position))   //returns an item value corresponding to a selected item position
                        {
                            case "Red": layout.setBackgroundColor(Color.RED);
                                break;
                            case "Yellow": layout.setBackgroundColor(Color.YELLOW);
                                break;
                            case "Green": layout.setBackgroundColor(Color.GREEN);
                                break;
                            case "Blue": layout.setBackgroundColor(Color.BLUE);
                                break;
                            default: layout.setBackgroundColor(Color.WHITE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {  //This method will be called when nothing gets selected
                        // Nothing should happen when nothing gets selected

                    }

                }
        );
    }
}

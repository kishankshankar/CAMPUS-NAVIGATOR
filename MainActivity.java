package com.example.mvit_campus_navigator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String source,destination;
    Spinner srcspinner,destspinner;
    Button navigate;
    ArrayList<String> sourcelist=new ArrayList<>();
    ArrayList<String> destinationlist=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srcspinner=(Spinner) findViewById(R.id.Source);
        destspinner=(Spinner) findViewById(R.id.destination);
        navigate=(Button) findViewById(R.id.findroute);
        sourcelist.add("SIR MVIT CANTEEN");
        sourcelist.add("SIR MVIT BOYS HOSTEL UNIT 1");
        sourcelist.add("SIR MVIT AND KCDS LADIES HOSTEL");
        sourcelist.add("KRISHNADEVERAYA COLLEGE OF DENTAL SCIENCES AND HOSPITAL");
        sourcelist.add("MVIT NEW LIBRARY");
        sourcelist.add("SIR M VISVESVERAYA INSTITUTE OF TECHNOLOGY");
        sourcelist.add("SIR MVIT MECHANICAL BLOCK");
        sourcelist.add("SIR MVIT DEPARTMENT OF CIVIL ENGINEERING");
        sourcelist.add("MVIT SCIENCE BLOCK");
        sourcelist.add("SIR MVIT LIBRARY");
        sourcelist.add("SIR MVIT MBA & MCA BLOCK");
        sourcelist.add("SIR MV SCHOOL OF ARCHITECTURE");
        sourcelist.add("NEW SIR MVIT AUDITORIUM");
        sourcelist.add("SIR MVIT AND KCDS BASKETBALL COURT");

        ArrayAdapter<String> sourceadapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,sourcelist);

        srcspinner.setAdapter(sourceadapter);

        destinationlist.add("SIR MVIT CANTEEN");
        destinationlist.add("SIR MVIT BOYS HOSTEL UNIT 1");
        destinationlist.add("SIR MVIT AND KCDS LADIES HOSTEL");
        destinationlist.add("KRISHNADEVERAYA COLLEGE OF DENTAL SCIENCES AND HOSPITAL");
        destinationlist.add("MVIT NEW LIBRARY");
        destinationlist.add("SIR M VISVESVERAYA INSTITUTE OF TECHNOLOGY");
        destinationlist.add("SIR MVIT MECHANICAL BLOCK");
        destinationlist.add("SIR MVIT DEPARTMENT OF CIVIL ENGINEERING");
        destinationlist.add("MVIT SCIENCE BLOCK");
        destinationlist.add("SIR MVIT LIBRARY");
        destinationlist.add("SIR MVIT MBA & MCA BLOCK");
        destinationlist.add("SIR MV SCHOOL OF ARCHITECTURE");
        destinationlist.add("NEW SIR MVIT AUDITORIUM");
        destinationlist.add("SIR MVIT AND KCDS BASKETBALL COURT");

        ArrayAdapter<String> destinationadapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,sourcelist);
        destspinner.setAdapter(destinationadapter);
        srcspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                source= sourcelist.get(position);
                Toast.makeText(MainActivity.this, ""+source+"is selected as source", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        destspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                destination=destinationlist.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(source==destination)
                    Toast.makeText(MainActivity.this, "Source and destination and cannot be the same", Toast.LENGTH_SHORT).show();
                else {
                    Uri uri=Uri.parse("https://www.google.com/maps/dir/" + source + "/" + destination);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

    }
}

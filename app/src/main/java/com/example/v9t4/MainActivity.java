package com.example.v9t4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    areaXML areaXML = new areaXML();
    Spinner dropdown;
    TextView movies;
    EditText date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText date = (EditText) findViewById(R.id.date);
        EditText time = (EditText) findViewById(R.id.time);
        EditText time2 = (EditText) findViewById(R.id.time2);
        TextView movies = (TextView) findViewById(R.id.movies);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Spinner dropdown = (Spinner) findViewById(R.id.area);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, areaXML.readXML());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name = dropdown.getSelectedItem().toString(); //Get the name of the selected movie theatre
                movies.setText(areaXML.specificDate(name, date.getText().toString(), time.getText().toString(), time2.getText().toString()).toString()); //Sets the text for scrollview with the different movies returned in stringbuilder from method .specificDate
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
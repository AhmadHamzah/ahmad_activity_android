package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText nameField;
    private EditText salaryField;
    private Spinner salaryTypeSpinner;
    private ListView employeesListView;
    private Button addButton;
    private ArrayAdapter<Employee> adapter;
    private ArrayList<Employee> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        populateSpinner();
        setup();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new Employee(nameField.getText().toString(),Double. parseDouble(salaryField.getText().toString()) ) );
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void setup() {
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayList.add(new Employee("ahmad", 20.4));
        employeesListView.setAdapter(adapter);
    }

    public void setViews() {
        nameField = findViewById(R.id.nameField);
        salaryField = findViewById(R.id.salaryField);
        salaryTypeSpinner = findViewById(R.id.salaryTypeSpinner);
        employeesListView = findViewById(R.id.employeesListView);
        addButton = findViewById(R.id.addButton);
    }

    public void populateSpinner() {
        String [] salaryTypes = {"Full Time", "Part Time"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        salaryTypes);
        salaryTypeSpinner.setAdapter(spinnerArrayAdapter);
    }
}
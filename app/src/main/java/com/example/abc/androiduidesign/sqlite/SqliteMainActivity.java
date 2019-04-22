package com.example.abc.androiduidesign.sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.androiduidesign.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SqliteMainActivity extends AppCompatActivity {

    public static final String DATABASENAME = "mydatabase";
    DatabaseManager mDatabase;

    private EditText editTextName, editTextSalary;
    private Spinner spinnerDepartment;
    private Button buttonSave;
    private TextView textViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_main);

        mDatabase = new DatabaseManager(this);


        editTextName = findViewById(R.id.editTextName);
        editTextSalary = findViewById(R.id.editTextSalary);

        buttonSave = findViewById(R.id.buttonAddEmployee);

        spinnerDepartment = findViewById(R.id.spinnerDepartment);
        textViewShow = findViewById(R.id.textViewViewEmployees);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();

            }


        });
        textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), EmployeeActivity.class));

            }
        });

    }


    private void addEmployee() {

        String name = editTextName.getText().toString();
        String salary = editTextSalary.getText().toString().trim();
        String department = spinnerDepartment.getSelectedItem().toString();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String joiningDate = sdf.format(cal.getTime());

        if (name.isEmpty()) {

            editTextName.setError("Can't be empty");
            editTextName.setFocusable(true);
        }


        mDatabase.addEmployee(name, department, joiningDate, Double.parseDouble(salary));

        Toast.makeText(getApplicationContext(), "Added successfull", Toast.LENGTH_LONG).show();


    }
}

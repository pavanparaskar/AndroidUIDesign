package com.example.abc.androiduidesign.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.abc.androiduidesign.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {
    DatabaseManager mDatabase;

    List<Employee> employeeList;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        listView = findViewById(R.id.listViewEmployees);
        employeeList = new ArrayList<>();

        mDatabase =new DatabaseManager(this);
        loadEmployeeFromDB();

    }

    private void loadEmployeeFromDB() {

        String sql = "SELECT * FROM employees";

        Cursor cursor = mDatabase.getAllEmployee();

        if (cursor.moveToFirst()) {

            do {

                employeeList.add(new Employee(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getShort(4)

                ));

            } while (cursor.moveToNext());

            EmployeeAdapter employeeAdapter = new EmployeeAdapter(this, R.layout.list_layout_employees, employeeList,mDatabase);
            listView.setAdapter(employeeAdapter);
        }
    }
}

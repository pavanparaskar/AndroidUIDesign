package com.example.abc.androiduidesign.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.androiduidesign.R;

import java.util.List;

/**
 * Created by ABC on 26-12-2018.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    Context context;
    int layoutRes;
    List<Employee> employeeList;

    DatabaseManager mSqLiteDatabase;

    public EmployeeAdapter(@NonNull Context context, int layoutRes, @NonNull List<Employee> employeeList, DatabaseManager mSqLiteDatabase) {
        super(context, layoutRes, employeeList);

        this.context = context;
        this.layoutRes = layoutRes;
        this.employeeList = employeeList;
        this.mSqLiteDatabase = mSqLiteDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(layoutRes, null);

        final Employee employee = employeeList.get(position);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewDept = view.findViewById(R.id.textViewDepartment);
        TextView textViewSalary = view.findViewById(R.id.textViewSalary);
        TextView textViewJoiningDate = view.findViewById(R.id.textViewJoiningDate);
        Button buttonEditEmployee = view.findViewById(R.id.buttonEditEmployee);
        final Button buttonDeleteEmployee = view.findViewById(R.id.buttonDeleteEmployee);


        buttonEditEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmployee(employee);
            }
        });
        buttonDeleteEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEmployee(employee);
            }
        });
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        textViewJoiningDate.setText(employee.getJoiningDate());

        return view;
    }

    private void deleteEmployee(Employee employee) {
        mSqLiteDatabase.deleteemployee(employee.getId());
        loadEmployeeList();

    }

    private void updateEmployee(final Employee employee) {

        AlertDialog.Builder aBuilder = new AlertDialog.Builder(context);

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.dialog_employee_update, null);
        aBuilder.setView(view);

        final AlertDialog alertDialog = aBuilder.create();
        alertDialog.show();

        final EditText editTextName = view.findViewById(R.id.editTextName);
        final EditText editTextSalary = view.findViewById(R.id.editTextSalary);
        final Spinner spinnerDepartment = view.findViewById(R.id.spinnerDepartment);
        final Button buttonUpdateEmployee = view.findViewById(R.id.buttonUpdateEmployee);

        final String dep = employee.getDept();


        editTextName.setText(employee.getName());
        editTextSalary.setText((String.valueOf(employee.getSalary())));


        buttonUpdateEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String salary = editTextSalary.getText().toString().trim();

                String department = spinnerDepartment.getSelectedItem().toString();


                if (name.isEmpty()) {

                    editTextName.setError("Can't be empty");
                    editTextName.setFocusable(true);
                }

                mSqLiteDatabase.updateEmployee(employee.getId(), name, department, Double.parseDouble(salary));
                Toast.makeText(getContext(), "Update successfull", Toast.LENGTH_LONG).show();
                loadEmployeeList();
                alertDialog.dismiss();
            }
        });


    }

    private void loadEmployeeList() {

        Cursor cursor = mSqLiteDatabase.getAllEmployee();

        if (cursor.moveToFirst()) {
            employeeList.clear();
            do {

                employeeList.add(new Employee(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getShort(4)

                ));

            } while (cursor.moveToNext());

            notifyDataSetChanged();


        }
    }
}

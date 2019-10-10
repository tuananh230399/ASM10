package com.hanh.sqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.hanh.sqlite.R;
import com.hanh.sqlite.database.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edName, edDes;
    private Button btRegister;
    private Spinner spinner;
    private DBHelper db;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        db = new DBHelper(this);
        db.getReadableDatabase();
    }

    private void initView() {
        edName = findViewById(R.id.edUser);
        edDes = findViewById(R.id.edDes);
        btRegister = findViewById(R.id.btRegister);
        checkBox = findViewById(R.id.ck);
        btRegister .setOnClickListener(this);

        String[] genders = {"Male" , "Female", "Unknow"};
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void onClick(View v){
        if (v == btRegister){
            onRegister();
        }
    }

    private void onRegister() {
        if (edName.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter username", Toast.LENGTH_LONG).show();
            return;
        }
        if (!checkBox.isChecked()){
            Toast.makeText(this, "Please agree rules", Toast.LENGTH_LONG).show();
            return;
        }
        String isAdd = db.addUser(edName.getText().toString(), spinner.getSelectedItem().toString(), edDes.getText().toString());
        Toast.makeText(this, isAdd, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, ListUserAct.class);
        startActivity(intent);
    }
}

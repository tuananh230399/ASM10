package com.hanh.sqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanh.sqlite.R;
import com.hanh.sqlite.database.DBHelper;

public class UpdateAct extends AppCompatActivity {
    private DBHelper db;
    private int _id;
    private EditText edName, edGender, edDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        db = new DBHelper(this);
        initView();

        Intent intent = getIntent();
        _id = intent.getIntExtra(DBHelper.ID, 0);
        String name = intent.getStringExtra(DBHelper.NAME);
        String gender = intent.getStringExtra(DBHelper.GENDER);
        String des = intent.getStringExtra(DBHelper.DES);

        edDes.setText(des);
        edName.setText(name);
        edGender.setText(gender);


    }

    private void initView() {
        edName = findViewById(R.id.edName);
        edGender = findViewById(R.id.edGender);
        edDes = findViewById(R.id.edDes);
        Button btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener((View.OnClickListener) this);
        Button btDelete = findViewById(R.id.btDelete);
        btDelete.setOnClickListener((View.OnClickListener) this);
    }

    private void onUpdate(){
        String isUpdate = db.updateUser(_id, edName.getText().toString(), edGender.getText().toString() + "update", edDes.getText().toString());
        Toast.makeText(this, isUpdate, Toast.LENGTH_LONG).show();
        finish();
    }

    private void onDelete(){
        Toast.makeText(this, db.delateUser(_id), Toast.LENGTH_LONG).show();
        finish();
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btUpdate:onUpdate();
            break;
            case R.id.btDelete:onDelete();
                break;
                default:break;

        }
    }
}

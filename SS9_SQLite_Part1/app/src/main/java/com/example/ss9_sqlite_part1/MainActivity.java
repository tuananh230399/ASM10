package com.example.ss9_sqlite_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        //INSERT DATA
        insertUser();

        //GET DATA
        getAllUSer();

        //UPDATE DATA
        updateUser();

        //DELETE DATA
        deleteUser();
    }

    private void insertUser() {
        User user = new User("Dao Tuan Tu", "Male", 20);
        String message = db.insertDB(user);
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
    }

    private void getAllUSer() {
        List<User> listUser = db.getAllUSer();
        for (User user : listUser) {
            Log.d("USER", "name: "+user.getName() + "id: "+user.getId() + "age: "+user.getAge());
        }
    }

    private void updateUser() {
        User user = new User();
        user.setId(3);
        user.setName("Vu tri thanh Update");
        user.setAge(20);
        String message = db.updateUser(user);
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
    }

    private void deleteUser() {
        db.deleteUSer(5);
    }

    protected void onStop() {
        super.onStop();
        db.close();
    }
}

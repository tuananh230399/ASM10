package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContactModel> ListContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initData();

        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(ListContacts,this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = ListContacts.get(position);
                Toast.makeText(MainActivity.this,contactModel.getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Dao Tuan Tu", "09090909", R.drawable.ic_user_a);
        ListContacts.add(contact);

        contact = new ContactModel("Pham Thi Thanh Tuoi","08080808", R.drawable.ic_user_b);
        ListContacts.add(contact);
        contact = new ContactModel("Nguyen Xuan Tuan","08080808", R.drawable.ic_user_c);
        ListContacts.add(contact);
        contact = new ContactModel("Vu Tri Thanh","08080808", R.drawable.ic_user_a);
        ListContacts.add(contact);
        contact = new ContactModel("Pham Thi Thanh Tuoi","08080808", R.drawable.ic_user_b);
        ListContacts.add(contact);
        contact = new ContactModel("Nguyen Tuan Anh","08080808", R.drawable.ic_user_c);
        ListContacts.add(contact);
        contact = new ContactModel("Nguyen Hanh","08080808", R.drawable.ic_user_b);
        ListContacts.add(contact);
    }
}

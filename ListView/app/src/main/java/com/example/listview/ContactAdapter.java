package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<ContactModel> ListContacts;
    private Activity activity;

    public ContactAdapter(List<ContactModel> listContacts, Activity activity) {
        ListContacts = listContacts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return ListContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_contact,parent,false);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        ContactModel model = ListContacts.get(position);
        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhone());
        holder.ivAvatar.setImageResource(model.getImage());
        return convertView;
    }
}

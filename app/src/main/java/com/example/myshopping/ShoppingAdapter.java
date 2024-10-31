package com.example.myshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ShoppingAdapter extends ArrayAdapter<ShoppingItem> {

    public ShoppingAdapter(Context context, List<ShoppingItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ShoppingItem item = getItem(position);

        if (item != null) {
            ImageView itemImage = convertView.findViewById(R.id.imgIcon);
            TextView itemName = convertView.findViewById(R.id.txtView);
            TextView itemDescription = convertView.findViewById(R.id.textView2);

            itemImage.setImageResource(item.getImageResId());
            itemName.setText(item.getName());
            itemDescription.setText(item.getDescription());
        }

        return convertView;
    }
}

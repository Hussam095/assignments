package com.example.myshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView shoppingListView = findViewById(R.id.customListView);

        // Sample data for the shopping list
        List<ShoppingItem> shoppingItems = new ArrayList<>();
        shoppingItems.add(new ShoppingItem("Apples", "Red and delicious.", R.drawable.apples));
        shoppingItems.add(new ShoppingItem("Bananas", "Extra yummy!", R.drawable.banana));
        shoppingItems.add(new ShoppingItem("Strawberries", "Great for summer.", R.drawable.strawbarries));

        ShoppingAdapter adapter = new ShoppingAdapter(this, shoppingItems);
        shoppingListView.setAdapter(adapter);

        // Handle item clicks to open detail view
        shoppingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShoppingItem selectedItem = shoppingItems.get(position);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("itemName", selectedItem.getName());
                intent.putExtra("itemDescription", selectedItem.getDescription());
                intent.putExtra("itemImage", selectedItem.getImageResId());

                startActivity(intent);
            }
        });
    }
}

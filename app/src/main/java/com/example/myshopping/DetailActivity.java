package com.example.myshopping;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        ImageView itemImage = findViewById(R.id.imgIcon);
        TextView itemName = findViewById(R.id.txtView);
        TextView itemDescription = findViewById(R.id.textView2);

        String name = getIntent().getStringExtra("itemName");
        String description = getIntent().getStringExtra("itemDescription");
        int imageResId = getIntent().getIntExtra("itemImage", 0);

        itemName.setText(name);
        itemDescription.setText(description);
        itemImage.setImageResource(imageResId);

        // Enable the Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the Up button press
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close DetailActivity and go back to MainActivity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

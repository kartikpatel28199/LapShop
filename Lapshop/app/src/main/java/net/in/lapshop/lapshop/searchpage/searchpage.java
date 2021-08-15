package net.in.lapshop.lapshop.searchpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.showlaptop.showlaptop;

import br.com.mauker.materialsearchview.MaterialSearchView;

public class searchpage extends AppCompatActivity {

    String[] string = new String[]{"acer", "dell", "hp", "lenovo", "apple", "asus", "lg", "micromax", "micromax", "toshiba", "lava"};
    MaterialSearchView materialSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpage);
        materialSearchView = findViewById(R.id.searchView_searchpage);

        getSupportActionBar().hide();
        materialSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialSearchView.openSearch();
            }
        });
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
      Intent intent = new Intent(searchpage.this, showlaptop.class);
                                intent.putExtra("laptop_brand", query);
                                startActivity(intent);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
package net.in.lapshop.lapshop.homepage;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.address.ManageAddress;
import net.in.lapshop.lapshop.login.Login;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;
import net.in.lapshop.lapshop.login.change_password;
import net.in.lapshop.lapshop.mycart.My_Cart;
import net.in.lapshop.lapshop.mywalletandcard.MyWalletAndCard;
import net.in.lapshop.lapshop.notification.Notification;
import net.in.lapshop.lapshop.searchpage.searchpage;
import net.in.lapshop.lapshop.showlaptop.showlaptop;

public class customer_homepage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    SharedPreferenceConfig sharedPreferenceConfig;
    LinearLayout l1,l2,l3;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_homepage);

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        sharedPreferenceConfig=new SharedPreferenceConfig(getApplicationContext());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadFragment(new home());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_homepage, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        item.setVisible(true);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.i("onQueryTextChange", newText);

                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Log.i("onQueryTextSubmit", query);
                    Intent intent = new Intent(customer_homepage.this, showlaptop.class);
                    intent.putExtra("laptop_brand", query);
                    startActivity(intent);
                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_notification){
            startActivity(new Intent(customer_homepage.this, Notification.class));
        }else if(id==R.id.action_cart){
            startActivity(new Intent(customer_homepage.this, My_Cart.class));
        }else if(id==R.id.action_search){

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        android.support.v4.app.Fragment fragment=null;
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragment = new home();
        }else if (id == R.id.nav_categories) {

        } else if (id == R.id.nav_helpcenter) {

        } else if (id == R.id.nav_changepassword) {
            startActivity(new Intent(customer_homepage.this,change_password.class));
        } else if (id == R.id.nav_logout) {
            sharedPreferenceConfig.WriteLoginStatus(false);
            startActivity(new Intent(this,Login.class));
            finish();
        }
        else if (id == R.id.nav_rate) {

        }else if(id==R.id.navigation_home){
            fragment = new home();
        }else if(id==R.id.navigation_categories){
            fragment = new categories();
        }else if(id==R.id.navigation_compare){
            fragment=new compare();
        }else if(id==R.id.navigation_wishlist){
            fragment = new wishlist();
        }else if(id==R.id.navigation_profile) {
            fragment = new Account();
        }else if(id==R.id.l1){

        }else if (id==R.id.l2){
            l2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(customer_homepage.this, ManageAddress.class));
                }
            });

        }else if (id==R.id.l3){
            startActivity(new Intent(customer_homepage.this, MyWalletAndCard.class));
        }
        // Not implemented here
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return loadFragment(fragment);
    }
    public boolean loadFragment(android.support.v4.app.Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

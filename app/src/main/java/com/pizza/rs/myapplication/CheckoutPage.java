package com.pizza.rs.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;


import com.pizza.rs.myapplication.R;

public class CheckoutPage extends Activity {

    String pizzaSizeChosen;
    String totalCost;
    String toppings;
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);
        Bundle bundle = getIntent().getExtras();

//Extract the data…
        pizzaSizeChosen = bundle.getString("pizzaSize");
        toppings = "Toppings = " + bundle.getString("toppings");


        totalCost = "Total Cost = " + bundle.getString("totalCost");

        mainListView = (ListView) findViewById( R.id.listView );

        // Create and populate a List of planet names.
        String[] planets = new String[] { pizzaSizeChosen, toppings, totalCost};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetList);



        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.checkout_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putString("MyString", "Welcome back to Android");
        // etc.
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        
        String myString = savedInstanceState.getString("MyString");
    }

    public  void displayMessageActivity(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);


    }

}

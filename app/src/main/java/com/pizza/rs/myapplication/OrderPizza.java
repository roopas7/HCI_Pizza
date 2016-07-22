package com.pizza.rs.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import	android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;


import com.pizza.rs.myapplication.R;

public class OrderPizza extends Activity {


    private RadioGroup radioSizeGroup;
    private RadioButton radioSizeButton;
    private Button btnDisplay;
    String pizzaSizeChosen = "Medium";
    int cost = 0;
    int hamCost = 0;
    int chickenCost = 0;
    int sausageCost = 0;
    boolean cheeseSelected = false;
    boolean onionSelected = false;
    boolean tomatoSelected = false;
    boolean hamSelected = false;
    boolean sausageSelected = false;
    boolean chickenSelected = false;
    boolean peppersSelected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);
        final CheckBox cheeseBox = ((CheckBox)findViewById(R.id.checkBoxCheese));
        cheeseBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cheeseBox.isChecked()){
                  cheeseSelected = true;
                }else{
                    cheeseSelected = false;
                 }
            }
        });
        final CheckBox chickenBox = ((CheckBox)findViewById(R.id.checkBoxChicken));
        chickenBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chickenBox.isChecked()){
                    chickenSelected = true;
                    chickenCost = 1;
                }else{
                    chickenSelected = false;
                    chickenCost = 0;
                }
            }
        });



        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                    final RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
                    final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
                    final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

                    if (radioButton1.isChecked()) {
                        pizzaSizeChosen = "1 Small Pizza";
                        cost += 5;

                    } else if (radioButton2.isChecked()) {
                        pizzaSizeChosen = "1 Medium Pizza";
                        cost += 10;

                    }else if (radioButton3.isChecked()) {
                        pizzaSizeChosen = "1 Large Pizza";
                        cost += 15;

                    }else {
                        pizzaSizeChosen = "1 Medium Pizza";
                        cost += 10;
                    }
                }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.order_pizza, menu);
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




    public  void checkoutPage(View view)
    {
        Intent intent = new Intent(this, CheckoutPage.class);
        Bundle bundle = new Bundle();

//Add your data to bundle
        bundle.putString("pizzaSize", pizzaSizeChosen);
        String toppings = "";
        if (cheeseSelected) {toppings += " cheese ";}
        if (chickenSelected) {toppings += " chicken ";}
        if (onionSelected) {toppings += " onion ";}
        if (tomatoSelected) {toppings += " tomato ";}
        if (hamSelected) {toppings += " ham ";}
        if (sausageSelected) {toppings += " sausage ";}
        if (peppersSelected) {toppings += " peppers ";}


        boolean onionSelected = false;
        boolean tomatoSelected = false;
        boolean hamSelected = false;
        boolean sausageSelected = false;
        boolean chickenSelected = false;
        boolean peppersSelected = false;
        bundle.putString("totalCost", Integer.toString(cost + chickenCost + sausageCost + hamCost));
        bundle.putString("toppings", toppings);




//Add the bundle to the intent
        intent.putExtras(bundle);
        startActivity(intent);


    }
}

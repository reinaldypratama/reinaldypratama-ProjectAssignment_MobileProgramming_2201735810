package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderComplete extends AppCompatActivity {
    ArrayList<Product> arrOrder = new ArrayList<>();
    Integer nominal = 0;
    GridView gridView;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; //object
    public static final String EXTRA_ORDER = "abc"; //array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        arrOrder = (ArrayList<Product>) bundle.getSerializable(DrinksActivity.EXTRA_ORDER);
        nominal = (Integer) bundle.getSerializable("nominal");

       AdapterOrderComplete drinkadapter = new AdapterOrderComplete(OrderComplete.this,arrOrder);

        TextView totalPrice = findViewById(R.id.totalTxt);
        totalPrice.setText("Total Price : Rp. "+getTotalPrice());

        gridView = findViewById(R.id.gridOrder);
        gridView.setAdapter(drinkadapter);

    }
    private int getTotalPrice(){
        int totalPrice = 0;
        for(Product drinks : arrOrder){
            totalPrice += (drinks.getQty() * drinks.getPrice());
        }
        return totalPrice;
    }

    public void Menu(View view) {

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, MainActivity.class);


        bundle.putSerializable("nominal", nominal);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        //bundle.putSerializable(EXTRA_ORDER,arrOrder);
        bundle.putSerializable("nominal",nominal);
        //bundle.putSerializable(EXTRA_MESSAGE, );
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
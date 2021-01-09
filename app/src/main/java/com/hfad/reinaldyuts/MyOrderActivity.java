package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    ArrayList<Product> arrOrder = new ArrayList<>();
    Integer nominal = 0;
    GridView gridView;

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; //object
    public static final String EXTRA_ORDER = "abc"; //array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        arrOrder = (ArrayList<Product>) bundle.getSerializable(DrinksActivity.EXTRA_ORDER);
        nominal = (Integer) bundle.getSerializable("nominal");

        //Toast.makeText(getApplicationContext(),"You Clicked" + arrOrder.get(0).getQty(),Toast.LENGTH_SHORT).show();

        AdapterMyOrder drinkadapter = new AdapterMyOrder(MyOrderActivity.this,arrOrder, nominal);

        TextView totalPrice = findViewById(R.id.totalTxt);
        TextView saldo = findViewById(R.id.jumlahsaldoTxt);
        totalPrice.setText("Total Price : Rp. "+getTotalPrice());
        saldo.setText("Saldo kamu : Rp. "+nominal);


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

    public void Pay(View view) {

        if(getTotalPrice()> nominal){
            Toast.makeText(getApplicationContext(),"Saldo anda tidak cukup. silahkan top up ",Toast.LENGTH_SHORT).show();
        }
        else {
            nominal -= getTotalPrice();
            Intent intent = new Intent(this, OrderComplete.class);
            Bundle bundle = new Bundle();

            bundle.putSerializable(EXTRA_ORDER,arrOrder);
            bundle.putSerializable("nominal", nominal);
            intent.putExtras(bundle);


            startActivity(intent);
        }


    }

    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        bundle.putSerializable(EXTRA_ORDER,arrOrder);
        bundle.putSerializable("nominal", nominal);


        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
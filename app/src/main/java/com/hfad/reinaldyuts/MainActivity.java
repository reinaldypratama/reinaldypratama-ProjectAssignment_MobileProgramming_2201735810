package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 //private Intent move = new Intent();

    ArrayList<Product> arrOrder = new ArrayList<>();
    public static final String EXTRA_ORDER = "abc";
    Integer nominal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nominal = 10000;
        //nerima dari yg lain
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        if(bundle !=null){
            if(bundle.containsKey("abc") ){
                arrOrder = (ArrayList<Product>) bundle.getSerializable(EXTRA_ORDER);
            }

            if(bundle.containsKey("nominal")){

                nominal = (Integer) bundle.getSerializable("nominal");
                Log.e("abc", nominal.toString());
            }

        }

    }

    public void Drinks(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,DrinksActivity.class);
        bundle.putSerializable(EXTRA_ORDER, arrOrder);
        bundle.putSerializable("nominal", nominal);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void Snacks(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, SnacksActivity.class);
        bundle.putSerializable(EXTRA_ORDER, arrOrder);
        bundle.putSerializable("nominal", nominal);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }

    public void Foods(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, FoodsActivity.class);
        bundle.putSerializable(EXTRA_ORDER, arrOrder);
        bundle.putSerializable("nominal", nominal);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();


    }

    public void Topup(View view) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, TopupActivity.class);
        bundle.putSerializable(EXTRA_ORDER, arrOrder);
        bundle.putSerializable("nominal", nominal);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void myOrder(View view) {
        if(arrOrder.isEmpty()){
            Toast.makeText(getApplicationContext(),"Data masih kosong",Toast.LENGTH_SHORT).show();
        }
        else{
            Bundle bundle1 = new Bundle();
            Intent intent1 = new Intent(this,MyOrderActivity.class);
            bundle1.putSerializable(EXTRA_ORDER, arrOrder);
            bundle1.putSerializable("nominal", nominal);
            intent1.putExtras(bundle1);
            startActivity(intent1);
            finish();
        }

    }

    public void Store(View view) {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
        finish();
    }


}
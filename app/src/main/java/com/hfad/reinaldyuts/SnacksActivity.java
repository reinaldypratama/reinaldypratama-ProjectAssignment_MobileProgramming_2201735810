package com.hfad.reinaldyuts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class SnacksActivity extends AppCompatActivity {
    ArrayList<Product> arrSnacks = new ArrayList<>();
    ArrayList<Product> arrOrder = new ArrayList<>();
    Integer nominal = 0;
    GridView gridView ;
    public void isiSnacks(){

        arrSnacks.add(new Product("Cookie",50000,R.drawable.cookies));
        arrSnacks.add(new Product("Chicken Pop",30000,R.drawable.popchick));
        arrSnacks.add(new Product("Latiao haozi",10000,R.drawable.latiao));
        arrSnacks.add(new Product("Peperoniz",5000,R.drawable.peperoni));

    }


    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; //object
    public static final String EXTRA_ORDER = "abc"; //array
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        isiSnacks();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        arrOrder = (ArrayList<Product>) bundle.getSerializable(MainActivity.EXTRA_ORDER);
        nominal = (Integer) bundle.getSerializable("nominal");


        AdapterDrink drinkadapter = new AdapterDrink(SnacksActivity.this,arrSnacks);

        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(drinkadapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You Choosed Item",Toast.LENGTH_SHORT).show();
                Product objSnacks = arrSnacks.get(i);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getBaseContext(),OrderActivity.class);
                bundle.putSerializable(EXTRA_ORDER, arrOrder);
                bundle.putSerializable(EXTRA_MESSAGE,objSnacks);
                bundle.putSerializable("nominal", nominal);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });


    }
    public void myOrder(View view) {
        //Toast.makeText(getApplicationContext(),"abc" + arrOrder.size(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyOrderActivity.class);
        Bundle bundle = new Bundle();

        bundle.putSerializable(EXTRA_ORDER,arrOrder);
        bundle.putSerializable("nominal", nominal);
        intent.putExtras(bundle);


        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        bundle.putSerializable(EXTRA_ORDER,arrOrder);
        bundle.putSerializable("nominal", nominal);
        //bundle.putSerializable(EXTRA_MESSAGE, );
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}

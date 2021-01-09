package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"; //object
    public static final String EXTRA_ORDER = "abc";
    ArrayList<Product> arrOrder = new ArrayList<>();
    Integer nominal = 0;
    Product data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
         data = (Product) bundle.getSerializable(EXTRA_MESSAGE);

        arrOrder = (ArrayList<Product>) bundle.getSerializable(EXTRA_ORDER);
        nominal = (Integer) bundle.getSerializable("nominal");


        TextView textnama = findViewById(R.id.namaproductTxt);
        textnama.setText(data.getName());

        TextView textPrice = findViewById(R.id.rupiah);
        textPrice.setText(Integer.toString(data.getPrice()));




    }



    public void orderMore(View view) {

        EditText qtyText = findViewById(R.id.QuantityTxt);
        if(qtyText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }

        int qty = Integer.parseInt(qtyText.getText().toString());
        if(qty<=0){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }
//            data.setQty(Integer.parseInt(qtyText.getText().toString()));
        data.setQty(qty);


                arrOrder.add(new Product(data.getName(), data.getPrice(), data.getPicture(), qty));

                Bundle bundle1 = new Bundle();
                Intent intent1 = new Intent(this,MainActivity.class);
                bundle1.putSerializable(EXTRA_ORDER, arrOrder);

                bundle1.putSerializable("nominal", nominal);
                intent1.putExtras(bundle1);
                startActivity(intent1);
                finish();


    }

    public void myOrder(View view) {
        EditText qtyText = findViewById(R.id.QuantityTxt);
        if(qtyText.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }

        int qty = Integer.parseInt(qtyText.getText().toString());
        if(qty<=0){
            Toast.makeText(getApplicationContext(),"Jumlah barang harus di isi",Toast.LENGTH_SHORT).show();
            return;
        }
//            data.setQty(Integer.parseInt(qtyText.getText().toString()));
        data.setQty(qty);


        arrOrder.add(data);

        Bundle bundle1 = new Bundle();
        Intent intent1 = new Intent(this,MyOrderActivity.class);
        bundle1.putSerializable(EXTRA_ORDER, arrOrder);

        bundle1.putSerializable("nominal", nominal);
        intent1.putExtras(bundle1);
        startActivity(intent1);
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
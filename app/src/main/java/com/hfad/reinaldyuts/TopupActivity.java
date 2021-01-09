package com.hfad.reinaldyuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TopupActivity extends AppCompatActivity {
    Integer nominal = 0;
    ArrayList<Product> arrOrder = new ArrayList<>();
    public static final String EXTRA_ORDER = "abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        nominal = (Integer) bundle.getSerializable("nominal");

        arrOrder = (ArrayList<Product>) bundle.getSerializable(EXTRA_ORDER);

        TextView budget = findViewById(R.id.saldokamuTxt);
        budget.setText("Saldo Kamu : " +nominal);


    }

    public void Submit(View view){
        EditText nominaluang = findViewById(R.id.uangTxt);
        Integer input = Integer.parseInt(nominaluang.getText().toString());
        if(input<= 0){
            Toast.makeText(getApplicationContext(),"Minimal saldo untuk topup lebih dari 0",Toast.LENGTH_SHORT).show();
        }
        else if(input >2000000){
            Toast.makeText(getApplicationContext(),"Saldo harus kurang dari 2juta",Toast.LENGTH_SHORT).show();
        }
        else{
            nominal += input;

            Bundle bundle = new Bundle();
            Intent intent = new Intent(getBaseContext(), MainActivity.class);

            bundle.putSerializable(EXTRA_ORDER,arrOrder);
            bundle.putSerializable("nominal", nominal);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();

        }
    }

    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        bundle.putSerializable("nominal",nominal);
        bundle.putSerializable(EXTRA_ORDER,arrOrder);

        intent.putExtras(bundle);
        startActivity(intent);
        finish();

    }
}
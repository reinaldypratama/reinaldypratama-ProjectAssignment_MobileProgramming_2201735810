package com.hfad.reinaldyuts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterMyOrder extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<Product> arrMyOrder ;
    Integer nominal = 0;
    public static final String EXTRA_ORDER = "abc";
    public AdapterMyOrder(Context c,  ArrayList<Product> arrMyOrder, Integer nominal) {
        this.context = c;

        this.arrMyOrder = arrMyOrder;
        this.nominal = nominal;
    }

    @Override
    public int getCount() {
        return arrMyOrder.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view =inflater.inflate(R.layout.myorderlayout,null);
        }

        TextView text_Product = view.findViewById(R.id.text_Product);
        TextView text_qty = view.findViewById(R.id.text_qty);
        TextView text_price = view.findViewById(R.id.text_price);

        Product myOrder = arrMyOrder.get(i);
        text_Product.setText(myOrder.getName());
        text_qty.setText(Integer.toString(myOrder.getQty()) + " x ");
        text_price.setText("Rp. "+Integer.toString(myOrder.getPrice()));

        Button button = view.findViewById(R.id.hapusBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrMyOrder.remove(i);
                Intent intent = new Intent(view.getContext(), MyOrderActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("nominal", nominal);
                bundle.putSerializable(EXTRA_ORDER,arrMyOrder);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });


        return view;
    }
}

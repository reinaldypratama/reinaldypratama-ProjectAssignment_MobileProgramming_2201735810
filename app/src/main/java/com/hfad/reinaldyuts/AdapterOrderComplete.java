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

public class AdapterOrderComplete extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<Product> arrMyOrder ;
    public static final String EXTRA_ORDER = "abc";
    public AdapterOrderComplete(Context c,  ArrayList<Product> arrMyOrder) {
        this.context = c;

        this.arrMyOrder = arrMyOrder;
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
            view =inflater.inflate(R.layout.myorderlayoutcompleted,null);
        }

        TextView text_Product = view.findViewById(R.id.text_Product);
        TextView text_qty = view.findViewById(R.id.text_qty);
        TextView text_price = view.findViewById(R.id.text_price);

        Product myOrder = arrMyOrder.get(i);
        text_Product.setText(myOrder.getName());
        text_qty.setText(Integer.toString(myOrder.getQty()) + " x ");
        text_price.setText("Rp. "+Integer.toString(myOrder.getPrice()));




        return view;
    }
}

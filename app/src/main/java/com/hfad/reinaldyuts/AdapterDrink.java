package com.hfad.reinaldyuts;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDrink extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<Product> arrDrinks ;

    public AdapterDrink(Context c, ArrayList<Product> arrDrinks){
        context = c;
        this.arrDrinks = arrDrinks;

    }
    @Override
    public int getCount() {
        return  arrDrinks.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view =inflater.inflate(R.layout.row_item,null);
        }
        ImageView imageView = view.findViewById(R.id.image_view);
        TextView textName = view.findViewById(R.id.text_name);
        TextView textPrice = view.findViewById(R.id.text_price);
        Product drink = arrDrinks.get(i);

        imageView.setImageResource(drink.getPicture());
        textName.setText(drink.getName());
        textPrice.setText(Integer.toString(drink.getPrice()));
        return view;
    }
}

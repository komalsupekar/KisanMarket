package com.komal.krypton.kisan.market;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class citygenerator extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] cities;

    public citygenerator(@NonNull Context context, int[] images, String[] cities) {
        super(context, R.layout.city,cities);
        this.cities = cities;
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View city = li.inflate(R.layout.city,null);
        TextView cityname = city.findViewById(R.id.cityname);
        ImageView citypic = city.findViewById(R.id.citypic);

        cityname.setText(cities[position]);
        citypic.setImageResource(images[position]);

        return city;
    }
}

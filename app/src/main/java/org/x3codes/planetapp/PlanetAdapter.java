package org.x3codes.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {

//    private ArrayList<Planet> planetsArrayList;
    Context context;

    public PlanetAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.context = context;
    }

    private static class ViewHolder {
        TextView planetName, moonCount;
        ImageView planetImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);

        ViewHolder viewHolder;
        final View result;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);

            viewHolder.planetName = convertView.findViewById(R.id.planet_name);
            viewHolder.moonCount = convertView.findViewById(R.id.moon_count);
            viewHolder.planetImage = convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert planet != null;
        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(planet.getMoonCount());
        viewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return result;
    }
}

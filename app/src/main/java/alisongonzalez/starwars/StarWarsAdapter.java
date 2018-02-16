package alisongonzalez.starwars;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AlisonGonzalez on 16/02/18.
 */

public class StarWarsAdapter extends ArrayAdapter<Character> {
    private Context context;
    public StarWarsAdapter(@NonNull Context context, int resource, @NonNull List<Character> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.character_data, parent, false);
        }
        Character character = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView year = (TextView) convertView.findViewById(R.id.year);

        name.setText(character.name);
        year.setText(character.year);

        return super.getView(position, convertView, parent);
    }
}

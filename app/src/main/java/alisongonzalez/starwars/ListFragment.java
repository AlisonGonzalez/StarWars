package alisongonzalez.starwars;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_lists, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StarWarsAdapter adapter = getAdapter();
    }

    private StarWarsAdapter getAdapter() {
        StarWarsAdapter adapter = new StarWarsAdapter(
                getActivity(), R.layout.character_data,
                new ArrayList<Character>());
        try {
            JSONObject jsonObject = new JSONObject(getJSOND());
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject character = jsonArray.getJSONObject(i);
                Character c = new Character();
                c.name = character.getString("name");
                c.year = character.getString("birth_year");
                System.out.println(c.name);
                System.out.println(c.year);
                adapter.add(c);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return adapter;
    }

    private String getJSOND() {
        try {
            InputStream inputStream = getActivity().getAssets().open("one.json");
            int s = inputStream.available();
            byte[] archivo = new byte[s];
            inputStream.read(archivo);
            inputStream.close();
            return new String(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFrag extends Fragment {
    TextView nameText;
    SharedPreferences settings = null;
    String name;

    public static final String USER_NAME = "user_name";

    public SettingsFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("SettingsFrag", "onResume()");
        name = settings.getString(USER_NAME, null);
        nameText = (TextView) getActivity().findViewById(R.id.name_input);
        if(name == null) {
            Log.i("SettingsFrag", "name == null");
            name = "Name";
        }
        nameText.setText(name);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("SettingsFrag", "onPause()");
        String name = nameText.getText().toString();
        Log.i("TAG: Name changed to:", name);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER_NAME, name);
        editor.commit();
    }
}

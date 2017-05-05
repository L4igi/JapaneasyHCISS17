package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DictionaryFrag extends Fragment {

    public DictionaryFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);

        String [] menutItems = {"Pikachu", "DrZok", "L4igi"};

        ListView listView = (ListView) view.findViewById(R.id.list);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menutItems
        );

        listView.setAdapter(listViewAdapter);


        return view;


    }



}

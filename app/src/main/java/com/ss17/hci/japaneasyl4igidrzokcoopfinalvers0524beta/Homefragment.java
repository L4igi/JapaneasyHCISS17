package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment {
    ImageButton parkDictB, uniDictB, restDictB,
                parkLearnB, uniLearnB, restLearnB;

    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);

        parkDictB = (ImageButton) view.findViewById(R.id.ParkDicitonaryButton);
        parkLearnB = (ImageButton) view.findViewById(R.id.ParkLearnButton);

        restDictB = (ImageButton) view.findViewById(R.id.RestaurantDictionaryButton);
        restLearnB = (ImageButton) view.findViewById(R.id.RestaurantLearnButton);

        uniDictB = (ImageButton) view.findViewById(R.id.UniversityDictionaryButton);
        uniLearnB = (ImageButton) view.findViewById(R.id.UniversityLearnButton);

        parkDictB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Wörterbuch");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 1);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag);
                ft.commit();
            }
        });
 /*       parkLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Wörterbuch");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 1);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag);
                ft.commit();
            }
        });*/

        restDictB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Wörterbuch");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 2);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag);
                ft.commit();
            }
        });
/*        restLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Wörterbuch");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 1);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag);
                ft.commit();
            }
        });*/

        uniDictB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Wörterbuch");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 3);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag);
                ft.commit();
            }
        });
 /*       uniLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Wörterbuch");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 1);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag);
                ft.commit();
            }
        });*/

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("HomeFrag", "onViewCreated()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Homefragment", "onResume()");
    }
}

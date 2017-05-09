package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment {
    ImageButton parkDictB, uniDictB, restDictB,
                parkLearnB, uniLearnB, restLearnB;
    TextView freeParkUnitsView, freeRestUnitsView, freeUniUnitsView;
    TextView freeParkUnitsView, freeRestUnitsView, freeUniUnitsView;


    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);

        freeParkUnitsView = (TextView) view.findViewById(R.id.LernversuchePark);
        freeRestUnitsView = (TextView) view.findViewById(R.id.LernversucheRestaurant);
        freeUniUnitsView = (TextView) view.findViewById(R.id.LernversucheUni);

        freeParkUnitsView = (TextView) view.findViewById(R.id.LernversuchePark);
        freeRestUnitsView = (TextView) view.findViewById(R.id.LernversucheRestaurant);
        freeUniUnitsView = (TextView) view.findViewById(R.id.LernversucheUni);

        parkDictB = (ImageButton) view.findViewById(R.id.ParkDicitonaryButton);
        parkLearnB = (ImageButton) view.findViewById(R.id.ParkLearnButton);

        restDictB = (ImageButton) view.findViewById(R.id.RestaurantDictionaryButton);
        restLearnB = (ImageButton) view.findViewById(R.id.RestaurantLearnButton);

        uniDictB = (ImageButton) view.findViewById(R.id.UniversityDictionaryButton);
        uniLearnB = (ImageButton) view.findViewById(R.id.UniversityLearnButton);

    //    SharedPreferences settings = MainActivity.settings;
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);

        freeParkUnitsView.setText(settings.getString(MainActivity.uniFree, "0"));
        freeRestUnitsView.setText(settings.getString(MainActivity.restFree, "0"));
        freeUniUnitsView.setText(settings.getString(MainActivity.uniFree, "0"));

    //    SharedPreferences settings = MainActivity.settings;
        SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);

        freeParkUnitsView.setText(settings.getString(MainActivity.uniFree, "0"));
        freeRestUnitsView.setText(settings.getString(MainActivity.restFree, "0"));
        freeUniUnitsView.setText(settings.getString(MainActivity.uniFree, "0"));

        parkDictB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Dictionary");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 1);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag).addToBackStack("Nearby");
                ft.commit();
            }
        });

        restDictB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Dicitonary");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 2);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag).addToBackStack("Nearby");
                ft.commit();
            }
        });

        uniDictB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Dictionary");
                DictionaryFrag dictionaryFrag=new DictionaryFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(DictionaryFrag.DICT_EXPAND, 3);
                dictionaryFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, dictionaryFrag).addToBackStack("Nearby");
                ft.commit();
            }
        });

        parkLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Learn Park");
                LearnFrag learnFrag=new LearnFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(LearnFrag.PACKAGE, 1);
                learnFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, learnFrag).addToBackStack("Nearby");
                ft.commit();
            }
        });
        restLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Learn Restaurant");
                LearnFrag learnFrag=new LearnFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(LearnFrag.PACKAGE, 2);
                learnFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, learnFrag).addToBackStack("Nearby");
                ft.commit();
            }
        });
        uniLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setTitle("Learn University");
                LearnFrag learnFrag=new LearnFrag();

                Bundle bundle = new Bundle();
                bundle.putInt(LearnFrag.PACKAGE, 3);
                learnFrag.setArguments(bundle);

                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment, learnFrag).addToBackStack("Nearby");
                ft.commit();
            }
        });
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

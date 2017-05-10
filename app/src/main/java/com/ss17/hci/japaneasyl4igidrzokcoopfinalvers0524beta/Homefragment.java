package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment {
    ImageButton parkDictB, uniDictB, restDictB,
                parkLearnB, uniLearnB, restLearnB;
    ProgressBar freeParkUnits, freeRestUnits, freeUniUnits;


    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_homefragment, container, false);

        freeParkUnits = (ProgressBar) view.findViewById(R.id.ProgressBarPark);
        freeRestUnits = (ProgressBar) view.findViewById(R.id.ProgressBarrestaurant);
        freeUniUnits = (ProgressBar) view.findViewById(R.id.ProgressBarUni);

        parkDictB = (ImageButton) view.findViewById(R.id.ParkDicitonaryButton);
        parkLearnB = (ImageButton) view.findViewById(R.id.ParkLearnButton);

        restDictB = (ImageButton) view.findViewById(R.id.RestaurantDictionaryButton);
        restLearnB = (ImageButton) view.findViewById(R.id.RestaurantLearnButton);

        uniDictB = (ImageButton) view.findViewById(R.id.UniversityDictionaryButton);
        uniLearnB = (ImageButton) view.findViewById(R.id.UniversityLearnButton);

        final SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);

        freeParkUnits.setProgress(settings.getInt(MainActivity.parkFree, 0)/MainActivity.freeUnitsPerVisit * 100);
        freeRestUnits.setProgress(settings.getInt(MainActivity.restFree, 0)/MainActivity.freeUnitsPerVisit * 100);
        freeUniUnits.setProgress(settings.getInt(MainActivity.uniFree, 0)/MainActivity.freeUnitsPerVisit * 100);

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
            public void onClick(View v) {
                if(settings.getInt(MainActivity.parkFree, 0) > 0) {
                    Log.i("HomeFrag", "onClick parkLearnB "+String.valueOf(settings.getInt(MainActivity.parkFree, 0)));

                    getActivity().setTitle("Learn Park");
                    LearnFrag learnFrag = new LearnFrag();

                    Bundle bundle = new Bundle();
                    bundle.putInt(LearnFrag.PACKAGE, 1);
                    learnFrag.setArguments(bundle);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment, learnFrag).addToBackStack("Nearby");
                    ft.commit();
                } else {
                    Log.i("HomeFrag", "onClick parkLearnB else "+String.valueOf(settings.getInt(MainActivity.parkFree, 0)));

                    Toast toast = Toast.makeText(getActivity(), "No tries remaining!\nVisit Votivpark", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }
        });
        restLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(settings.getInt(MainActivity.restFree, 0) > 0) {
                    getActivity().setTitle("Learn Restaurant");
                    LearnFrag learnFrag = new LearnFrag();

                    Bundle bundle = new Bundle();
                    bundle.putInt(LearnFrag.PACKAGE, 2);
                    learnFrag.setArguments(bundle);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment, learnFrag).addToBackStack("Nearby");
                    ft.commit();
                } else {
                    Log.i("HomeFrag", "onClick parkLearnB else "+String.valueOf(settings.getInt(MainActivity.parkFree, 0)));

                    Toast toast = Toast.makeText(getActivity(), "No tries remaining!\nVisit Gagarin", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
            }
        });
        uniLearnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(settings.getInt(MainActivity.uniFree, 0) > 0) {
                    getActivity().setTitle("Learn University");
                    LearnFrag learnFrag = new LearnFrag();

                    Bundle bundle = new Bundle();
                    bundle.putInt(LearnFrag.PACKAGE, 3);
                    learnFrag.setArguments(bundle);

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment, learnFrag).addToBackStack("Nearby");
                    ft.commit();
                } else {
                    Log.i("HomeFrag", "onClick parkLearnB else "+String.valueOf(settings.getInt(MainActivity.parkFree, 0)));

                    Toast toast = Toast.makeText(getActivity(), "No tries remaining!\nVisit Währingerstr. 29", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                }
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

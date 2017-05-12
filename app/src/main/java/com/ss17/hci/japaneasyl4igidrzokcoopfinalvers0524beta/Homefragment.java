package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


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
        final View view = inflater.inflate(R.layout.fragment_homefragment, container, false);

        parkDictB = (ImageButton) view.findViewById(R.id.ParkDicitonaryButton);
        parkLearnB = (ImageButton) view.findViewById(R.id.ParkLearnButton);

        restDictB = (ImageButton) view.findViewById(R.id.RestaurantDictionaryButton);
        restLearnB = (ImageButton) view.findViewById(R.id.RestaurantLearnButton);

        uniDictB = (ImageButton) view.findViewById(R.id.UniversityDictionaryButton);
        uniLearnB = (ImageButton) view.findViewById(R.id.UniversityLearnButton);

        final SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);

        int parkFree = settings.getInt(MainActivity.parkFree, 0);
        int restFree = settings.getInt(MainActivity.restFree, 0);
        int uniFree  = settings.getInt(MainActivity.uniFree, 0);

        ProgressBar parkRemaining = (ProgressBar) view.findViewById(R.id.ProgressBarPark);
        ProgressBar restRemaining = (ProgressBar) view.findViewById(R.id.ProgressBarrestaurant);
        ProgressBar uniRemaining = (ProgressBar) view.findViewById(R.id.ProgressBarUni);

        parkRemaining.setProgress(parkFree*100/MainActivity.freeUnitsPerVisit);
        restRemaining.setProgress(restFree*100/MainActivity.freeUnitsPerVisit);
        uniRemaining.setProgress(uniFree*100/MainActivity.freeUnitsPerVisit);

        TextView parkRemainingText = (TextView) view.findViewById(R.id.parkprogresstxt);
        TextView restRemainingText = (TextView) view.findViewById(R.id.restaurantprogresstxt);
        TextView uniRemainingText = (TextView) view.findViewById(R.id.uniprogresstxt);

        parkRemainingText.setText(MainActivity.remainingTriesText+
                String.valueOf(parkFree)+"/"+String.valueOf(MainActivity.freeUnitsPerVisit)+")");
        restRemainingText.setText(MainActivity.remainingTriesText+
                String.valueOf(restFree)+"/"+String.valueOf(MainActivity.freeUnitsPerVisit)+")");
        uniRemainingText.setText(MainActivity.remainingTriesText+
                String.valueOf(uniFree)+"/"+String.valueOf(MainActivity.freeUnitsPerVisit)+")");

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
}

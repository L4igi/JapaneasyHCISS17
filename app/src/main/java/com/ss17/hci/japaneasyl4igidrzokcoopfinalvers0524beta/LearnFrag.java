package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta.MainActivity.allChars;


/**
 * A simple {@link Fragment} subclass.
 */

//TODO: Massively prettify Interface
public class LearnFrag extends Fragment {
    //TODO: Make kanji a Button and handle click
    TextView kanji;
    RadioGroup meanings;
    RadioGroup pronounciations;
    RadioButton[] means = new RadioButton[3];
    RadioButton[] pros = new RadioButton[3];

    public static final String PACKAGE = "package";

    String chosenMeaning = null;
    String chosenPronunciation = null;
    boolean feedBackGiven = false;

    public LearnFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        NavigationView navView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_lernen);

        final View view =inflater.inflate(R.layout.fragment_learn, container, false);
        kanji = (TextView) view.findViewById(R.id.KanjiInput);
        meanings = (RadioGroup) view.findViewById(R.id.meaningGroup);
        pronounciations = (RadioGroup) view.findViewById(R.id.pronounciationGroup);
        means[0] = (RadioButton) view.findViewById(R.id.translatebutton1);
        means[1] = (RadioButton) view.findViewById(R.id.translatebutton2);
        means[2] = (RadioButton) view.findViewById(R.id.translatebutton3);
        pros[0] = (RadioButton) view.findViewById(R.id.aussprachebutton1);
        pros[1] = (RadioButton) view.findViewById(R.id.aussprachebutton2);
        pros[2] = (RadioButton) view.findViewById(R.id.aussprachebutton3);

        Bundle bundle = getArguments();
        int kanjiGroup;
        try {
            kanjiGroup = bundle.getInt(PACKAGE);
        } catch (Exception e) {
            kanjiGroup = 0;
        }

        CharacterContents.LearnSelection randSet = allChars.getRandSet(kanjiGroup);
        kanji.setText(randSet.getCharacter());

        long seed = System.nanoTime();
        Random generator = new Random(seed);

        ArrayList<String> m = randSet.getFalseMeanings();
        m.add(randSet.getCorrMeaning());
        Collections.shuffle(m, generator);

        ArrayList<String> p = randSet.getFalsePronunciations();
        p.add(randSet.getCorrPronunciation());
        Collections.shuffle(m, generator);

        means[0].setText(m.get(0));
        means[1].setText(m.get(1));
        means[2].setText(m.get(2));
        pros[0].setText(p.get(0));
        pros[1].setText(p.get(1));
        pros[2].setText(p.get(2));

        meanings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checked = (RadioButton) view.findViewById(checkedId);
                chosenMeaning = checked.getText().toString();
                if(chosenPronunciation != null) {
                    giveFeedback();
                }
            }
        });

        pronounciations.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checked = (RadioButton) view.findViewById(checkedId);
                chosenPronunciation = checked.getText().toString();
                if(chosenMeaning != null) {
                    giveFeedback();
                }
            }
        });



        return view;
    }

    private void giveFeedback() {
        //TODO: Change Button color (but hooooow?)
    }
}

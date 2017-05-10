package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta.MainActivity.allChars;


/**
 * A simple {@link Fragment} subclass.
 */

//TODO: Massively prettify Interface
public class LearnFrag extends Fragment {
    Button kanji;
    TextView nexttext;
    RadioGroup meanings;
    RadioGroup pronounciations;
    RadioButton[] means = new RadioButton[3];
    RadioButton[] pros = new RadioButton[3];

    public static final String PACKAGE = "package";

    int kanjiGroup;

    String corrMeaning = null;
    String corrPronunciation = null;
    RadioButton corrM = null;
    RadioButton corrP = null;
    String chosenMeaning = null;
    String chosenPronunciation = null;
    boolean feedBackGiven = false;

    boolean allowedToProceed = true;


    public LearnFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final NavigationView navView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_lernen);


        final View view =inflater.inflate(R.layout.fragment_learn, container, false);
        kanji = (Button) view.findViewById(R.id.KanjiInput);
        nexttext = (TextView) view.findViewById(R.id.Nexttxt);
        meanings = (RadioGroup) view.findViewById(R.id.meaningGroup);
        pronounciations = (RadioGroup) view.findViewById(R.id.pronounciationGroup);
        means[0] = (RadioButton) view.findViewById(R.id.translatebutton1);
        means[1] = (RadioButton) view.findViewById(R.id.translatebutton2);
        means[2] = (RadioButton) view.findViewById(R.id.translatebutton3);
        pros[0] = (RadioButton) view.findViewById(R.id.aussprachebutton1);
        pros[1] = (RadioButton) view.findViewById(R.id.aussprachebutton2);
        pros[2] = (RadioButton) view.findViewById(R.id.aussprachebutton3);

        final Bundle bundle = getArguments();
        try {
            kanjiGroup = bundle.getInt(PACKAGE);
        } catch (Exception e) {
            kanjiGroup = 0;
        }

        CharacterContents.LearnSelection randSet = allChars.getRandSet(kanjiGroup);
        kanji.setText(randSet.getCharacter());

        long seed = System.nanoTime();
        Random generator = new Random(seed);

        corrMeaning = randSet.getCorrMeaning();
        ArrayList<String> m = randSet.getFalseMeanings();
        m.add(corrMeaning);
        Collections.shuffle(m, generator);

        corrPronunciation = randSet.getCorrPronunciation();
        ArrayList<String> p = randSet.getFalsePronunciations();
        p.add(corrPronunciation);
        Collections.shuffle(m, generator);

        means[0].setText(m.get(0));
        means[1].setText(m.get(1));
        means[2].setText(m.get(2));
        pros[0].setText(p.get(0));
        pros[1].setText(p.get(1));
        pros[2].setText(p.get(2));

        for(int i=0; i < 3; ++i) {
            if(m.get(i) == corrMeaning) {
                corrM = means[i];
            }
            if(p.get(i) == corrPronunciation) {
                corrP = pros[i];
            }
        }

        meanings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checked = (RadioButton) view.findViewById(checkedId);
                chosenMeaning = checked.getText().toString();
                if(chosenPronunciation != null && !feedBackGiven) {
                    // meanings.setClickable(false) doesn't work!
                    for(RadioButton button : means)
                        button.setClickable(false);
                    for(RadioButton button : pros)
                        button.setClickable(false);
                    giveFeedback();
                }
            }
        });

        pronounciations.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton checked = (RadioButton) view.findViewById(checkedId);
                chosenPronunciation = checked.getText().toString();
                if(chosenMeaning != null && !feedBackGiven) {
                    // meanings.setClickable(false) doesn't work!
                    for(RadioButton button : means)
                        button.setClickable(false);
                    for(RadioButton button : pros)
                        button.setClickable(false);
                    giveFeedback();
                }
            }
        });

        kanji.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feedBackGiven && allowedToProceed) {
                    //TODO: Von Freiversuchen abhängig machen
                    switch (kanjiGroup){
                        case 0:
                            getActivity().setTitle("Learn Basics");
                            break;
                        case 1:
                            getActivity().setTitle("Learn Park");
                            break;
                        case 2:
                            getActivity().setTitle("Learn Restaurant");
                            break;
                        case 3:
                            getActivity().setTitle("Learn University");
                            break;
                        default:
                            getActivity().setTitle("Learn");
                    }
                    LearnFrag nextKanjiSlide=new LearnFrag();

                    Bundle bundle = new Bundle();
                    bundle.putInt(PACKAGE, kanjiGroup);
                    nextKanjiSlide.setArguments(bundle);

                    FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.fragment, nextKanjiSlide);
                    ft.commit();
                } else if(!allowedToProceed) {
                    Toast toast = Toast.makeText(getActivity(), "No tries remaining", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                 //   throw new RuntimeException("no tries remaining");
                } else {
                    //TODO: Highlight Help Button (temporarily replace with another pic?)
                    Log.d("Testing", "Niccce");
                }
            }
        });

        return view;
    }

    private void giveFeedback() {
        Log.d("Testing feedback", "At least");
        RadioButton checkedM = (RadioButton) getView().findViewById(meanings.getCheckedRadioButtonId());
        RadioButton checkedP = (RadioButton) getView().findViewById(pronounciations.getCheckedRadioButtonId());
        //TODO: fix colors (change not reflected in interface and colors picked randomly)
        if(chosenMeaning == corrMeaning) {
            Log.d("Testing feedback", "Should assign corrColor");
            checkedM.setBackgroundResource(R.drawable.radioanserright);
        } else {
            Log.d("Testing feedback", "Should assign failColor");
            checkedM.setBackgroundResource(R.drawable.radioanswerwrong);
            corrM.setBackgroundResource(R.drawable.radioanserright);
        }
        if(chosenPronunciation == corrPronunciation) {
            checkedP.setBackgroundResource(R.drawable.radioanserright);
        } else {
            checkedP.setBackgroundResource(R.drawable.radioanswerwrong);
            corrP.setBackgroundResource(R.drawable.radioanserright);
        }
        if(chosenPronunciation == corrPronunciation && chosenMeaning == corrMeaning) {
            kanji.setBackgroundResource(R.drawable.radioanserright);
        }else {
            kanji.setBackgroundResource(R.drawable.radioanswerwrong);
            //TODO: Ändere freiversuche
            SharedPreferences settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            int remaining = 0;
            switch (kanjiGroup) {
                case 1: remaining = settings.getInt(MainActivity.parkFree, 0);
                    remaining--;
                    editor.putInt(MainActivity.parkFree, remaining);
                    break;
                case 2: remaining = settings.getInt(MainActivity.restFree, 0);
                    remaining--;
                    editor.putInt(MainActivity.restFree, remaining);
                    break;
                case 3: remaining = settings.getInt(MainActivity.uniFree, 0);
                    remaining--;
                    editor.putInt(MainActivity.uniFree, remaining);
                    break;
                default: remaining = 1;
            }
            if(remaining == 0)
                allowedToProceed = false;
            editor.commit();
        }

        nexttext.setText("Next ->");

        feedBackGiven = true;
    }
}

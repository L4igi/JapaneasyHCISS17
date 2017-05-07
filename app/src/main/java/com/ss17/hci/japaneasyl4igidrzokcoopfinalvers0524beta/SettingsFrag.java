package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFrag extends Fragment {
    TextView nameText;
    ImageButton pic1, pic2, pic3, pic4, pic5, pic6, pic7, pic8, pic9;
    ImageView profilePic;
    SharedPreferences settings = null;
    String name;

    public static final String USER_NAME = "user_name";
    public static final String PIC_ID = "pic_id";
    public static final int DEFAULT_PIC_ID = 1;

    public SettingsFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("SettingsFrag", "onCreate()");

        settings = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("SettingsFrag", "onCreateView()");
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        nameText = (TextView) view.findViewById(R.id.name_input);

        nameText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                Log.i("SettingsFrag", "onEditorAction()");
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    Log.i("SettingsFrag", "actionId == EditorInfo.IME_ACTION_DONE");
                    String name = nameText.getText().toString();
                    Log.i("TAG: Name changed to:", name);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString(USER_NAME, name);
                    editor.commit();
                //    return  true;
                }
                return false;
            }
        });

        pic1 = (ImageButton) view.findViewById(R.id.profilpic1);
        pic2 = (ImageButton) view.findViewById(R.id.profilpic2);
        pic3 = (ImageButton) view.findViewById(R.id.profilpic3);
        pic4 = (ImageButton) view.findViewById(R.id.profilpic4);
        pic5 = (ImageButton) view.findViewById(R.id.profilpic5);
        pic6 = (ImageButton) view.findViewById(R.id.profilpic6);
        pic7 = (ImageButton) view.findViewById(R.id.profilpic7);
        pic8 = (ImageButton) view.findViewById(R.id.profilpic8);
        pic9 = (ImageButton) view.findViewById(R.id.profilpic9);

        profilePic = (ImageView) view.findViewById(R.id.pic);

        pic1.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_1);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 1);
                editor.commit();
            }
        });
        pic2.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_2);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 2);
                editor.commit();
            }
        });
        pic3.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_3);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 3);
                editor.commit();
            }
        });
        pic4.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_4);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 4);
                editor.commit();
            }
        });
        pic5.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_5);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 5);
                editor.commit();
            }
        });
        pic6.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_6);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 6);
                editor.commit();
            }
        });
        pic7.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_7);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 7);
                editor.commit();
            }
        });
        pic8.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_8);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 8);
                editor.commit();
            }
        });
        pic9.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilePic.setImageResource(R.drawable.pic_9);
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt(PIC_ID, 9);
                editor.commit();
            }
        });
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("SettingsFrag", "onResume()");

        name = settings.getString(USER_NAME, null);
        if(name == null) {
            Log.i("SettingsFrag", "name == null");
            name = "Name";
        }
        nameText.setText(name);

        int picId = settings.getInt(PIC_ID, DEFAULT_PIC_ID);
        switch (picId) {
            case 1: profilePic.setImageResource(R.drawable.pic_1); break;
            case 2: profilePic.setImageResource(R.drawable.pic_2); break;
            case 3: profilePic.setImageResource(R.drawable.pic_3); break;
            case 4: profilePic.setImageResource(R.drawable.pic_4); break;
            case 5: profilePic.setImageResource(R.drawable.pic_5); break;
            case 6: profilePic.setImageResource(R.drawable.pic_6); break;
            case 7: profilePic.setImageResource(R.drawable.pic_7); break;
            case 8: profilePic.setImageResource(R.drawable.pic_8); break;
            case 9: profilePic.setImageResource(R.drawable.pic_9); break;
            default: profilePic.setImageResource(R.drawable.pic_1); break;
        }

    }

/*    @Override
    public void onPause() {
        super.onPause();
        Log.i("SettingsFrag", "onPause()");
        String name = nameText.getText().toString();
        Log.i("TAG: Name changed to:", name);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER_NAME, name);
        editor.commit();
    }*/
}

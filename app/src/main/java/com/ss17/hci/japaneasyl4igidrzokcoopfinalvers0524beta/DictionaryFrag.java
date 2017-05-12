package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import static com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta.MainActivity.allChars;

/**
 * Pieced together from:
 * Android samples: com.example.android.apis.view.ExpandableList1
 * http://androidword.blogspot.com/2012/01/how-to-use-expandablelistview.html
 * http://stackoverflow.com/questions/6938560/android-fragments-setcontentview-alternative
 * http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment-android
 */
public class DictionaryFrag extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;
    private String[][] turned = new String[4][10];

    public static final String DICT_EXPAND = "expand_id";
    Integer expandId;


    public DictionaryFrag() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("DictFrag", "onCreate()");

        groups = new String[]{"Basics", "Park", "Restaurant", "University"};

        children = new String[][]{
                allChars.getBaseChars(),
                allChars.getParkChars(),
                allChars.getResChars(),
                allChars.getUniChars()
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dictionary, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("DictFrag", "onViewCreated()");

        lv = (ExpandableListView) view.findViewById(R.id.explist);
        lv.setAdapter(new ExpandableListAdapter(groups, children));
        lv.setGroupIndicator(null);
        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Log.d("Testing", turned[groupPosition][childPosition]);
                TextView tv = (TextView) v.findViewById(R.id.itemtext);
                if(turned[groupPosition][childPosition] == null) {
                    Log.d("Testing", "alrighty");
                    CharacterContents.Pair answers = allChars.getMapping(groupPosition, (String) tv.getText());
                    turned[groupPosition][childPosition] = tv.getText().toString();
                    //TODO: Prettify output
                    String answer = "";
                    for (String meaning : answers.getFirst()) {
                        answer += meaning + ", ";
                    }
                    answer = answer.substring(0, answer.length() - 2) + "\n";
                    for (String pronounce : answers.getSecond()) {
                        answer += pronounce + ", ";
                    }
                    answer = answer.substring(0, answer.length() - 2);
                    tv.setText(answer);
                }else {
                    tv.setText(turned[groupPosition][childPosition]);
                    turned[groupPosition][childPosition] = null;
                }
                return true;
            }
        });

        Bundle bundle = getArguments();
        try {
            expandId = bundle.getInt(DICT_EXPAND);
        } catch (Exception e) {
            expandId = 0;
        }

        if(expandId != 0) {
            lv.expandGroup(expandId, true);
        }

        NavigationView navView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_wörterbuch);
    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        public ExpandableListAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
            inf = LayoutInflater.from(getActivity());
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View holderText, ViewGroup parent) {

            ViewHolder holder;
            View convertView = null;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.exp_list_item, parent, false);
                holder = new ViewHolder();

                holder.text = (TextView) convertView.findViewById(R.id.itemtext);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holderText = holder.text;
            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.exp_list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.listtext);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolder {
            TextView text;
        }
    }
}
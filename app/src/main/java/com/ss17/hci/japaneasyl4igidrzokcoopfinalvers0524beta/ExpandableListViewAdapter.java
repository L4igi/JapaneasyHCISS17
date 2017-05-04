package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Zoran on 04.05.2017.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    String[] groupNames = {"Park", "Restaurant", "Universität"};
    String[][] childNames = {{"ParkWort1","ParkWort2"},{"ResWort1","ResWort2"},{"UniWort1","UniWort2"}};

    Context context;

    public ExpandableListViewAdapter(Context context){

        this.context=context;


    }

    @Override
    public int getGroupCount() {
        return groupNames.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childNames[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupNames[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childNames[groupPosition][childPosition];
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {

        TextView textView=new TextView(context);
        textView.setText(groupNames[groupPosition]);
        textView.setPadding(100,0,0,0);
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final TextView textView=new TextView(context);
        textView.setText(childNames[groupPosition][childPosition]);
        textView.setPadding(100,0,0,0);


        return textView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

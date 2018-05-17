package com.example.akashravi.vriksha;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Custom_view extends BaseAdapter{

    private Context mContext;
    private List<tender_add>mList;
    TextView crop_name;
    TextView name;
    TextView quantity;
    TextView contact;
    TextView address;

    public Custom_view(Context mContext, List<tender_add> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        System.out.println("Neeru");
        View v=View.inflate(mContext,R.layout.customlayout,null);
        crop_name.setText(mList.get(i).pname.toString());
        contact.setText(mList.get(i).ph.toString());
        address.setText(mList.get(i).addr.toString());
        //quantity.setText(tenderlist.get(i).qt);
       v.setTag(mList.get(i).getId());
        return v;
    }
}

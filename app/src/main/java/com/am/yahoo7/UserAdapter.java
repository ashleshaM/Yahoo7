package com.am.yahoo7;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.am.yahoo7.Model.Item;

import java.util.ArrayList;

/**
 * Created by ashleshamahindre on 13/03/16.
 */

public class UserAdapter extends BaseAdapter {

    private ArrayList<Item> users ;
    private Context context ;
    TextView textViewName, textViewStartTime, textViewEndTime, textViewChannel, textViewRating;

    public UserAdapter(Context context, ArrayList<Item> items) {
        this.context = context ;
        this.users = items ;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public long getItemId(int i) {
        return 0 ;
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.listview_item, viewGroup, false);

        textViewName = (TextView) v.findViewById(R.id.textviewName);
        textViewStartTime = (TextView) v.findViewById(R.id.textviewStartTime);
        textViewEndTime = (TextView) v.findViewById(R.id.textviewEndTime);
        textViewChannel = (TextView) v.findViewById(R.id.textviewChannel);
        textViewRating = (TextView) v.findViewById(R.id.textviewrating);

        Item user = users.get(i);

        textViewName.setText("NAME: "+user.getName());
        textViewStartTime.setText("START TIME: "+user.getStart_time() );
        textViewEndTime.setText("END TIME: "+user.getEnd_time() );
        textViewChannel.setText("CHANNEL: "+user.getChannel() );
        textViewRating.setText("RATING: "+user.getRating() );

        Log.d("Adapter", user.getName());
        return v;
    }
}

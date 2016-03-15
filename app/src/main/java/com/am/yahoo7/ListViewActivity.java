package com.am.yahoo7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import com.am.yahoo7.Model.Item;
import com.am.yahoo7.Service.RestClient;
import java.util.ArrayList;
import com.am.yahoo7.Model.model;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by ashleshamahindre on 13/03/16.
 */

public class ListViewActivity extends AppCompatActivity {

    private ListViewAdapter mAdapter ;
    private int mStart = 0;
    private int mCount = 1;
    private boolean mIsLoading = false;

    ArrayList<Item> Users = new ArrayList<>();
    ListView listView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listView);
        mAdapter = new ListViewAdapter(ListViewActivity.this, Users);
        listView.setAdapter(mAdapter);
        listView.setOnScrollListener(onScrollListener());
//        populateData(mStart);
    }

     public void populateData(int offset)
     {
         RestClient.YahooApiInterface service = RestClient.getClient();
         Call<model> call = service.getOffset(offset);
         call.enqueue(new Callback<model>() {
             @Override
             public void onResponse(Response<model> response) {
                 Log.d("MainActivity", "Status Code = " + response.code());
                 if (response.isSuccess()) {

                     model result = response.body();

                     Users.addAll(result.getResults());
                     mAdapter.notifyDataSetChanged();
                     mIsLoading = false;

                     mCount = result.getCount();
                     mStart++;
                 } else {
                     //TODO: Handle errors when response is received but request not successful
                        populateData(mStart);
                 }
             }

             @Override
             public void onFailure(Throwable t) {
                 //TODO: Handle failure
             }
         });
     }

    private AbsListView.OnScrollListener onScrollListener() {
        return new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
            {

                if (firstVisibleItem + visibleItemCount >= totalItemCount - 1 && !mIsLoading && mStart < mCount)
                {
                    mIsLoading = true;
                    populateData(mStart);
                }
            }
        };
    }
}

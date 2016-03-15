package com.am.yahoo7.Service;

import android.os.Handler;
import android.provider.SyncStateContract;
import android.util.Log;

import com.am.yahoo7.Model.model;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by ashleshamahindre on 13/03/16.
 */
public class RestClient {
    private static YahooApiInterface yahooApiInterface ;
    private static String baseUrl = "https://www.whatsbeef.net" ;

    public static YahooApiInterface getClient() {
        if (yahooApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            yahooApiInterface = client.create(YahooApiInterface.class);
        }
        return yahooApiInterface ;
    }

    public interface YahooApiInterface {

        @GET("/wabz/guide.php")
        Call<model> getOffset(@Query("start") int offset);

    }

}

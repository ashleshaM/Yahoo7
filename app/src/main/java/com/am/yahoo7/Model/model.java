package com.am.yahoo7.Model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashleshamahindre on 15/03/16.
 */
public class model {

    @Expose
    private ArrayList<Item> results = new ArrayList<Item>();

    @Expose
    private int count;

    /**
     *
     * @return
     * The results
     */
    public ArrayList<Item> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(ArrayList<Item> results) {
        this.results = results;
    }


    /**
     *
     * @return
     * The count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(int count) {
        this.count = count;
    }

}

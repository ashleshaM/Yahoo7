package com.am.yahoo7.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashleshamahindre on 13/03/16.
 */
public class Item {

    @Expose
    private String name;

    @Expose
    private String start_time;

    @Expose
    private String end_time;

    @Expose
    private String channel;

    @Expose
    private String rating;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The end_time
     */
    public String getEnd_time() {
        return end_time;
    }

    /**
     *
     * @param end_time
     * The end_time
     */
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    /**
     *
     * @return
     * The start_time
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     *
     * @param start_time
     * The start_time
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }


    /**
     *
     * @return
     * The channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     *
     * @param channel
     * The channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     *
     * @return
     * The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

}

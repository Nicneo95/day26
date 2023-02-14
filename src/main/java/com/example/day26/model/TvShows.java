package com.example.day26.model;

import org.bson.Document;
import static com.example.day26.Constants.*;

public class TvShows {
    private int id;
    private String name;
    private String url;
    private float rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public static TvShows create(Document doc) {
        TvShows tvShow = new TvShows();
        tvShow.setId(doc.getInteger(FIELD_ID));
        tvShow.setName(doc.getString(FIELD_NAME));
        tvShow.setUrl(doc.getString(FIELD_URL));
        return tvShow;
    }

    public static TvShows createSummary(Document doc) {
        TvShows tvShow = new TvShows();
        tvShow.setId(doc.getInteger(FIELD_ID));
        tvShow.setName(doc.getString(FIELD_NAME));
        Document d = (Document) doc.get(FIELD_RATING);
        try {
            if (d.getDouble(FIELD_ID) != null)
                tvShow.setRating(d.getDouble(FIELD_AVERAGE).floatValue());
            else
                tvShow.setRating(Float.NaN);
        } catch (Exception ex) {
            tvShow.setRating(d.getInteger(FIELD_AVERAGE).floatValue());
        }
        return tvShow;
    }
}

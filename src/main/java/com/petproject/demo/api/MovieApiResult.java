package com.petproject.demo.api;

import com.petproject.demo.model.Film;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.List;

public class MovieApiResult {
    private List<Film> results;
    private String total_pages;

    public List<Film> getResults() {
        return Collections.unmodifiableList(results);
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return Integer.parseInt(total_pages);
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }
}

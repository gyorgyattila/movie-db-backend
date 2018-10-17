package com.petproject.demo.api;

import com.petproject.demo.model.Film;

import java.util.Collections;
import java.util.List;

public class MovieApiResult {
    private List<Film> results;

    public List<Film> getResults() {
        return Collections.unmodifiableList(results);
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}

package com.petproject.demo.api;

import org.json.simple.JSONObject;

import java.util.List;

public class TrailerResult {
    private List<JSONObject> results;

    public List<JSONObject> getResults() {
        return results;
    }

    public void setResults(List<JSONObject> results) {
        this.results = results;
    }
}

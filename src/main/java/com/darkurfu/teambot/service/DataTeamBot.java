package com.darkurfu.teambot.service;

import java.util.HashMap;

public class DataTeamBot {
    private HashMap<Long, String> infomap;
    public DataTeamBot() {
        this.infomap = new HashMap<>();

    }
    public String getData(Long id) {
        return infomap.get(id);
    }

    public void putData(Long id, String data) {
        infomap.put(id, data);
    }

    public void deleteData(Long id) {
        infomap.remove(id);
    }
}

package com.darkurfu.teambot.service;

import com.darkurfu.teambot.datamodels.CommandData;

import java.util.HashMap;

public class DataTeamBot {
    private HashMap<Long, CommandData> infomap;
    public DataTeamBot() {
        this.infomap = new HashMap<>();

    }
    public CommandData getData(Long id) {
        return infomap.get(id);
    }

    public void putData(Long id, CommandData data) {
        infomap.put(id, data);
    }

    public void deleteData(Long id) {
        infomap.remove(id);
    }
}

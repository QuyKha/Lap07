package com.example.qk_thuchanh_lap07;

public class Personal {
    private int id;
    private String name;

    public Personal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Personal(String name) {
        this.name = name;
    }

    public Personal() {
    }

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

}

package com.afq.mon220204445;

public class Model {
    String name;
    String des;
    String link;


    public Model(String name, String des, String link) {
        this.name = name;
        this.des = des;
        this.link = link;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

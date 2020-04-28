package com.softeem.bean.po;

public class Area {

    private Integer id;

    private String number;

    private String name;

    private String cityNumber;

    public Area() {
    }

    public Area(Integer id, String number, String name, String cityNumber) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.cityNumber = cityNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(String cityNumber) {
        this.cityNumber = cityNumber;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", cityNumber='" + cityNumber + '\'' +
                '}';
    }
}

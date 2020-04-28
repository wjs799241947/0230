package com.softeem.bean.po;

public class City {

    private Integer id;

    private String number;

    private String name;

    private String provinceNumber;

    public City() {
    }

    public City(Integer id, String number, String name, String provinceNumber) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.provinceNumber = provinceNumber;
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

    public String getProvinceNumber() {
        return provinceNumber;
    }

    public void setProvinceNumber(String provinceNumber) {
        this.provinceNumber = provinceNumber;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", provinceNumber='" + provinceNumber + '\'' +
                '}';
    }
}

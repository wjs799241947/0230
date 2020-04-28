package com.softeem.service;

import com.softeem.bean.po.City;
import com.softeem.bean.po.Province;
import com.softeem.dao.CityDAO;

import java.util.List;

public class CityService {

    private final CityDAO cityDAO;

    public CityService() {
        this.cityDAO = new CityDAO();
    }

    public List<City> listCityByProvinceNumber(String provinceNumber) {
        return cityDAO.selectByProvinceNumber(provinceNumber);
    }

}

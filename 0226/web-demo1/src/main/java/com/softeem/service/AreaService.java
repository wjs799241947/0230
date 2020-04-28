package com.softeem.service;

import com.softeem.bean.po.Area;
import com.softeem.bean.po.City;
import com.softeem.dao.AreaDAO;

import java.util.List;

public class AreaService {

    private final AreaDAO areaDAO;

    public AreaService() {
        this.areaDAO = new AreaDAO();
    }

    public List<Area> listAreaByCityNumber(String cityNumber) {

        return areaDAO.selectByCityNumber(cityNumber);
    }

}

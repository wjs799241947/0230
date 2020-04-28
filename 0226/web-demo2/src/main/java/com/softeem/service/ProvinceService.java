package com.softeem.service;

import com.softeem.bean.po.Province;
import com.softeem.dao.ProvinceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProvinceService {

    private final ProvinceDAO provinceDAO;

    public ProvinceService() {
        this.provinceDAO = new ProvinceDAO();
    }

    public List<Province> listProvince() {
        return provinceDAO.selectAll();
    }

}

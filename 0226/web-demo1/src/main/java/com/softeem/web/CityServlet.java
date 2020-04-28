package com.softeem.web;

import com.softeem.bean.po.City;
import com.softeem.bean.po.Province;
import com.softeem.service.CityService;
import com.softeem.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/city.do")
public class CityServlet extends HttpServlet {

    private final ProvinceService provinceService;
    private final CityService cityService;

    public CityServlet() {
        this.provinceService = new ProvinceService();
        this.cityService = new CityService();
    }

    /**
     * 根据省的id，去查询某个省下的所有的市
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String provinceNumber = req.getParameter("province");
        System.out.println("debug: 去查询 provinceNumber 为 " + provinceNumber + " 省下的所有的市");

        List<Province> provinceList = provinceService.listProvince();
        List<City> cityList = cityService.listCityByProvinceNumber(provinceNumber);

        req.setAttribute("provinceNumber", provinceNumber);
        req.setAttribute("provinceList", provinceList);
        req.setAttribute("cityList", cityList);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }


}

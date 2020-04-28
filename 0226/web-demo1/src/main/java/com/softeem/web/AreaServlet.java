package com.softeem.web;

import com.softeem.bean.po.Area;
import com.softeem.bean.po.City;
import com.softeem.bean.po.Province;
import com.softeem.service.AreaService;
import com.softeem.service.CityService;
import com.softeem.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/area.do")
public class AreaServlet extends HttpServlet {

    private final ProvinceService provinceService;
    private final CityService cityService;
    private final AreaService areaService;

    public AreaServlet() {
        this.provinceService = new ProvinceService();
        this.cityService = new CityService();
        this.areaService = new AreaService();
    }

    /**
     * 根据市的id，去查询某个实现的所有的区。
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String provinceNumber = req.getParameter("province");
        String cityNumber = req.getParameter("city");

        List<Province> provinceList = provinceService.listProvince();
        List<City> cityList = cityService.listCityByProvinceNumber(provinceNumber);
        List<Area> areaList = areaService.listAreaByCityNumber(cityNumber);

        req.setAttribute("provinceNumber", provinceNumber);
        req.setAttribute("cityNumber", cityNumber);
        req.setAttribute("provinceList", provinceList);
        req.setAttribute("cityList", cityList);
        req.setAttribute("areaList", areaList);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }


}

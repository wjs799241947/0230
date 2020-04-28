package com.softeem.web;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/area.do")
public class AreaServlet extends HttpServlet {

    private final AreaService areaService;

    public AreaServlet() {
        this.areaService = new AreaService();
    }

    /**
     * 根据市的id，去查询某个实现的所有的区。
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityNumber = req.getParameter("city");

        List<Area> areaList = areaService.listAreaByCityNumber(cityNumber);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.write(new ObjectMapper().writeValueAsString(areaList));
        out.flush();
    }
}

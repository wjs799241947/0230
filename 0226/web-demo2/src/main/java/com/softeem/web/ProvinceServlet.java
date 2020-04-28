package com.softeem.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.bean.po.Province;
import com.softeem.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/province.do")
public class ProvinceServlet extends HttpServlet {

    private final ProvinceService provinceService;

    public ProvinceServlet() {
        this.provinceService = new ProvinceService();
    }

    /**
     * 查询所有的省
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Province> provinceList = provinceService.listProvince();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.write(new ObjectMapper().writeValueAsString(provinceList));
        out.flush();
    }

}
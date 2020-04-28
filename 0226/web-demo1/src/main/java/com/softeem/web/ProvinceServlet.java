package com.softeem.web;

import com.softeem.bean.po.Province;
import com.softeem.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        System.out.println("debug: " + provinceList.size());

        req.setAttribute("provinceList", provinceList);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

}
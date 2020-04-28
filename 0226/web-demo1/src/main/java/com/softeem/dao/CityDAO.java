package com.softeem.dao;

import com.softeem.bean.po.City;
import com.softeem.bean.po.Province;
import com.softeem.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    /**
     * 根据省的 number 查询该省下的所有城市信息
     */
    public List<City> selectByProvinceNumber(String provinceNumber) {

        final String sql = "select * from city where province_num = ?";

        Connection connection = null;

        try {
            connection = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取 Connection 失败。无法执行【查询" + provinceNumber + "省下的所有城市信息】功能。");
            return new ArrayList<>();
        }

        List<City> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, provinceNumber);
            rs = pst.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String number = rs.getString("number");
                String name = rs.getString("name");

                list.add(new City(id, number, name, provinceNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.quietlyClose(rs);
            DataSourceUtil.quietlyClose(pst);
            DataSourceUtil.quietlyClose(connection);
        }

        return list;
    }

}

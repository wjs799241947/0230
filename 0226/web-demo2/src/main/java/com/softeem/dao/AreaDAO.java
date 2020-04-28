package com.softeem.dao;

import com.softeem.bean.po.Area;
import com.softeem.bean.po.City;
import com.softeem.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO {

    /**
     * 根据城市的 number 查询该市下的所有区县信息
     */
    public List<Area> selectByCityNumber(String cityNumber) {
        Connection connection = null;

        try {
            connection = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }


        List<Area> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        final String sql = "select * from area where city_num = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cityNumber);
            rs = pst.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String number = rs.getString("number");
                String name = rs.getString("name");

                list.add(new Area(id, number, name, cityNumber));
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

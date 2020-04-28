package com.softeem.dao;

import com.softeem.bean.po.Province;
import com.softeem.utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceDAO {

    /**
     * 查询所有省的信息
     */
    public List<Province> selectAll() {
        Connection connection = null;

        try {
            connection = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取 Connection 失败。无法执行【查询所有省份信息】功能。");
            return new ArrayList<>();
        }

        final String sql = "select * from province";

        List<Province> list = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String number = rs.getString("number");
                String name = rs.getString("name");

                list.add(new Province(id, number, name));
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

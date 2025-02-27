package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
    private Connection conn;
    public void connect() {
        try {
            conn = tryConnect();
        } catch (Exception e) {
            System.err.println("Nem lehet csatlakozni az adatbázishoz");
            System.err.println(e.getMessage());
        }
    }
    private Connection tryConnect() throws Exception {
        String host_str = String.format("jdbc:mysql://%s/%s", DBConfigj.host, DBConfigj.database);
        Connection conn = DriverManager.getConnection(host_str,DBConfigj.user,DBConfigj.password);
        return conn;
    }
    public void addRecord(Double radius, Double height, Double result) throws SQLException {
        if (conn != null) {
            String sql = "insert into cylinders (radius, height, result) values (?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setDouble(1, radius);
            stm.setDouble(2, height);
            stm.setDouble(3, result);
            stm.executeUpdate();
        }
    }
    public ArrayList<Model> getAll() throws SQLException {
        if (conn != null) {
            PreparedStatement stm = conn.prepareStatement("select * from cylinders");
            ResultSet res = stm.executeQuery();
            ArrayList<Model> data = new ArrayList<>();
            while (res.next()) {
                data.add(new Model(
                    Integer.parseInt(res.getString(1)),
                    Double.parseDouble(res.getString(2)),
                    Double.parseDouble(res.getString(3)),
                    Double.parseDouble(res.getString(4))
                ));
            }
            return data;
        }
        else {
            return null;
        }
    }
}

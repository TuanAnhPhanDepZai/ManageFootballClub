package ConnectDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.player;

public class ConnectDataBase {

    private final String classname = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/footballclub";
    private String user = "root";
    private String pass = "phantuananh123";
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public ConnectDataBase() {

        connnect();
    }

    public void connnect() {
        try {
            Class.forName(classname);

            try {
                connection = DriverManager.getConnection(url, user, pass);
                st = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isConnectToSingIn() {
        boolean Issucess = false;
        if (connection != null) {
            Issucess = true;
        } else {
            Issucess = false;
        }
        return Issucess;
    }

    public List<player> getDataPlayer() {
        List<player> list = new ArrayList<>();
        try {
            ResultSet resultset = null;

            String sqlcommand = "select * from player ";
            rs = st.executeQuery(sqlcommand);
            while (rs.next()) {
                String ID = rs.getString("ID");
                String name = rs.getString("NAME");
                String position = rs.getString("VI TRI");
                String adress = rs.getString("QUE QUAN");
                int tuoi = Integer.valueOf(rs.getString("TUOI"));
                int luong = Integer.valueOf(rs.getString("LUONG"));
                player player = new player(ID, name, position, adress, tuoi, luong);
                list.add(player);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String getDataplayerFromDatabase() {
        String s = "";
        String command = "select * from player ;";
        try {
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name = rs.getString("NAME");
                s += name + ",";
                String position = rs.getString("VI TRI");
                s += position + ",";
                String adress = rs.getString("QUE QUAN");
                s += adress + ",";
                String tuoi = String.valueOf(rs.getInt("TUOI"));
                s += tuoi + ",";
                String luong = String.valueOf(rs.getInt("LUONG"));
                s += luong + ",";
                s += "%";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public String getDataLanhDaoFromDatabase() {
        String s = "";
        try {

            String command = " select * from banlanhdao ;";
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name = rs.getString("NAME");
                s += name + ",";
                String position = rs.getString("POSITION");
                s += position + ",";
                String luong = String.valueOf(rs.getInt("LUONG"));
                s += luong + ",";
                s += "%";
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public String getThanhTichFromDatabase() {
        String string = "";
        String command = " select * from thanhtich ;";

        try {
            rs = st.executeQuery(command);
            while (rs.next()) {
                String namThidau = String.valueOf(rs.getInt("NAM"));
                string += namThidau + ",";
                String giaiDau = String.valueOf(rs.getString("GIAI DAU"));
                string += giaiDau + ",";
                String thanhtich = String.valueOf(rs.getString("THANH TICH"));
                string += thanhtich + ",";

                string += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return string;
    }

    public int insertPlayerToDatabase(String string[]) {
        int i = 0;
        try {
            String ID = string[0];
            String name = string[1];
            String position = string[2];
            String adress = string[3];
            int tuoi = 0;
            int luong = 0;
            try {
                tuoi = Integer.valueOf(string[4]);
                luong = Integer.valueOf(string[5]);
            } catch (Exception e) {
                return 0;
            }
            String command = "insert into player values('" + ID + "','" + name + "','" + position + "','" + adress + "'," + tuoi + "," + luong + ");";
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return i;
        }
        return i;
    }

    public int deletePlayerToDatabase(String ID) {
        int i = 0;
        try {

            String command = " delete from player where ID = '" + ID + "'";
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return 0;
        }
        return i;
    }

    public int updatePlayerToDatabase(String[] string) {
        int i = 0;
        try {

            int tuoi;
            int luong;
            String ID = string[0];
            String name = string[1];
            String position = string[2];
            String adress = string[3];
            try {
                tuoi = Integer.valueOf(string[4]);
                luong = Integer.valueOf(string[5]);
            } catch (Exception ex) {
                return 0;
            }

            String command = "update player set ID = '" + ID + "',NAME = '" + name + "', `VI TRI` ='" + position + "', `QUE QUAN` = '" + adress + "', TUOI =" + tuoi
                    + ", LUONG = " + luong + " where ID = '" + ID + "' ";

            if (st.executeUpdate(command) > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }

        return i;
    }

    public String getDataKeHoach() {
        String string = "";
        String command = "select * from kehoach ;";

        try {
            rs = st.executeQuery(command);
            while (rs.next()) {
                String vongdau = String.valueOf(rs.getInt(1));
                string += vongdau + ",";
                String giaidau = rs.getString("GIAI DAU");
                string += giaidau + ",";
                String ngaydau = rs.getString("NGAY DAU");
                string += ngaydau + ",";
                String diadiem = rs.getString("DIA DIEM");
                string += diadiem + ",";
                String doithu = rs.getString("DOI THU");
                string += doithu + ",";
                String trangthai = rs.getString("TRANG THAI");
                string += trangthai + ",";

                string += "%";
            }
        } catch (SQLException ex) {
            return "";
        }
        return string;
    }

    public String getDataCosoVatChatFromDatabase() {
        String string = "";
        String command = "select * from cosovatchat";

        try {
            rs = st.executeQuery(command);
            while (rs.next()) {
                String name = rs.getString(1);
                string += name + ",";
                String location = rs.getString(2);
                string += location + ",";

                string += "%";
            }
        } catch (Exception ex) {
            return "";
        }
        return string;
    }

    public String getDataPlayerById(String id) {
        String s = "";
        try {

            String command = " select * from player where ID = '" + id + "' ;";
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name = rs.getString("NAME");
                s += name + ",";
                String position = rs.getString("VI TRI");
                s += position + ",";
                String adress = rs.getString("QUE QUAN");
                s += adress + ",";
                String tuoi = String.valueOf(rs.getInt("TUOI"));
                s += tuoi + ",";
                String luong = String.valueOf(rs.getInt("LUONG"));
                s += luong + ",";
                s += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return s;
    }

    public String getDataPlayerByName(String name1) {
        String s = "";
        try {

            String command = " select * from player where NAME = '" + name1 + "' ;";
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name = rs.getString("NAME");
                s += name + ",";
                String position = rs.getString("VI TRI");
                s += position + ",";
                String adress = rs.getString("QUE QUAN");
                s += adress + ",";
                String tuoi = String.valueOf(rs.getInt("TUOI"));
                s += tuoi + ",";
                String luong = String.valueOf(rs.getInt("LUONG"));
                s += luong + ",";
                s += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return s;
    }

    public String getDataPlayerByLuong(String luong) {
            String s = "";
            int salary = Integer.valueOf(luong);
        try {

            String command = " select * from player where LUONG = " + salary + " ;"  ;
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name = rs.getString("NAME");
                s += name + ",";
                String position = rs.getString("VI TRI");
                s += position + ",";
                String adress = rs.getString("QUE QUAN");
                s += adress + ",";
                String tuoi = String.valueOf(rs.getInt("TUOI"));
                s += tuoi + ",";
                String sal = String.valueOf(rs.getInt("LUONG"));
                s += sal + ",";
                s += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return s;  
    }

    public String getDataPlayerLikeId(String id){
       String s = "";
        try {

            String command = " select * from player where ID like "+"'%"+id+"%'";
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name = rs.getString("NAME");
                s += name + ",";
                String position = rs.getString("VI TRI");
                s += position + ",";
                String adress = rs.getString("QUE QUAN");
                s += adress + ",";
                String tuoi = String.valueOf(rs.getInt("TUOI"));
                s += tuoi + ",";
                String luong = String.valueOf(rs.getInt("LUONG"));
                s += luong + ",";
                s += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return s;
    }
    
    public String getDataPlayerLikeName(String name){
       String s = "";
        try {

            String command = " select * from player where NAME like "+"'%"+name+"%'";
            rs = st.executeQuery(command);
            while (rs.next()) {
                String ID = rs.getString("ID");
                s += ID + ",";
                String name1 = rs.getString("NAME");
                s += name1 + ",";
                String position = rs.getString("VI TRI");
                s += position + ",";
                String adress = rs.getString("QUE QUAN");
                s += adress + ",";
                String tuoi = String.valueOf(rs.getInt("TUOI"));
                s += tuoi + ",";
                String luong = String.valueOf(rs.getInt("LUONG"));
                s += luong + ",";
                s += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return s;
    }
    public static void main(String[] args) {
        ConnectDataBase c = new ConnectDataBase();
      //  System.out.println(c.getDataPlayerLikeId("P"));
        String s = c.getDataPlayerById("P");
        System.out.println(s);
        
        System.out.println(s);
    }

}
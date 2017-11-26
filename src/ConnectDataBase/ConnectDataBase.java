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
                String vongdau = String.valueOf(rs.getInt(6));
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

    
    public String getDataKeHoachByGiaiDau(String giaidau1) {
        String string = "";
        String command = "select * from kehoach where `GIAI DAU` = '" +giaidau1+"'" ;

        try {
            rs = st.executeQuery(command);
            while (rs.next()) {
                String vongdau = String.valueOf(rs.getInt(6));
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
      public String getDataKeHoachByVongDau(String vongdau1) {
        String string = "";
        String command = "select * from kehoach where `VONG DAU` = '" +vongdau1+"'" ;

        try {
            rs = st.executeQuery(command);
            while (rs.next()) {
                String vongdau = String.valueOf(rs.getInt(6));
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
     public String getDataCosoVatChatFromDatabaseByLocation(String diadiem) {
        String string = "";
        String command = "select * from cosovatchat where `Dia Diem` = '"+diadiem+"'";

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
      public String getDataCosoVatChatFromDatabaseLikeLocation(String diadiem) {
        String string = "";
        String command = "select * from cosovatchat where `Dia Diem` like '%"+diadiem+"%';";

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
    
    public String getDataPlayerFollowLessSalary(String salary){
         int luong = Integer.valueOf(salary);
         String s = "";
        try {

            String command = " select * from player where  LUONG "+"< "+luong ;
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
                String luong1 = String.valueOf(rs.getInt("LUONG"));
                s += luong1 + ",";
                s += "%";
            }
        } catch (SQLException ex) {
            return "";
        }

        return s;
    }
    
    public String getDataBanLanhDaoId(String id ){
         String s = "";
        try {

            String command = " select * from banlanhdao where id = '" + id+"';" ;
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
     public String getDataBanLanhDaoName(String ten){
         String s = "";
        try {

            String command = " select * from banlanhdao where name like "+ "'%"+ten+"%';" ;
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
     
      public String getDataBanLanhDaoFollowSalary(String salary){
         int salary1 = Integer.valueOf(salary);
         String s = "";
        try {

            String command = " select * from banlanhdao where luong  < " + salary1 ;
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
      
      public int insertBanLanhDaoToDatabase(String string[]) {
        int i = 0;
        try {
            String ID = string[0];
            String name = string[1];
            String position = string[2];
            int luong = 0;
            try {
                luong = Integer.valueOf(string[3]);
            } catch (Exception e) {
                return 0;
            }
            String command = "insert into banlanhdao values('" + ID + "','" + name + "','" + position + "'," + luong +");" ;
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return i;
        }
        return i;
    } 
     public int insertFacility(String string[]) {
        int i = 0;
        try {
            String ten = string[0];
            String diadiem = string[1];
            
            
            String command = "insert into cosovatchat values('"+ten+"','"+diadiem+"');" ;
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return i;
        }
        return i;
    } 
      public int insertKeHoachToDatabase(String string[]) {
        int i = 0;
        try {
            
            String giaidau = string[1];
            String ngaydau = string[2];
            String diadiem = string[3];
            String doithu = string[4];
            String trangthai = string[5];
            int vongdau = 0;
            try {
                vongdau = Integer.valueOf(string[0]);
            } catch (Exception e) {
                return 0;
            }
            String command = "insert into kehoach values('"+giaidau+"','" +ngaydau+"','" + diadiem+"','"+doithu+"','"+trangthai+"'," + vongdau+");";
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return i;
        }
        return i;
    } 
      public int updateBanLanhDaoToDatabase(String[] string) {
        int i = 0;
        try {

          
            int luong;
            String ID = string[0];
            String name = string[1];
            String position = string[2];
         
            try {
              
                luong = Integer.valueOf(string[3]);
            } catch (Exception ex) {
                return 0;
            }

            String command = "update banlanhdao set ID = '" + ID + "',NAME = '" + name + "', POSITION ='" + position + "', LUONG = " + luong + " where ID = '" + ID + "' ";

            if (st.executeUpdate(command) > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }

        return i;
    }
    
    public int deleteBanlanhdaoToDatabase(String ID) {
        int i = 0;
        try {

            String command = " delete from banlanhdao where ID = '" + ID + "'";
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return 0;
        }
        return i;
    }
    
    public int deleteKeHoachToDatabase(String string[]) {
        int i = 0;
        String giaidau = string[1];
        try {
            int vongdau = Integer.valueOf(string[0]);
            String command = " delete from kehoach where `VONG DAU` = '" + vongdau +"' and `GIAI DAU` = '" + giaidau+"';"; 
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return 0;
        }
        return i;
    }
     public int deleteThanhTichToDatabase(String nam, String giaiDau) {
        int i = 0;
        int namThiDau = Integer.valueOf(nam);
        try {

            String command = " delete from thanhtich where nam = '"+ namThiDau+"' and `GIAI DAU` = '" + giaiDau +"';"  ;
            int t = st.executeUpdate(command);
            if (t > 0) {
                i = 1;
            }

        } catch (SQLException ex) {
            return 0;
        }
        return i;
    }

     public int deleteFacility(String string){
         int  i = 0;
        try {
            
            String name = string ;
            String command = "delete from cosovatchat where Ten= '" + name +"';" ;
            int t = st.executeUpdate(command);
            if (t>0) i =1 ;
            
        } catch (SQLException ex) {
            i= 0 ;
        }
        return i;
     }
     public String getDataThanhTichByNam(String nam){
         int nam1 = Integer.valueOf(nam);
         String s = "";
        try {

            String command = " select * from thanhtich where nam = " + nam1 ;
            rs = st.executeQuery(command);
            while (rs.next()) {
                String namthidau = rs.getString("NAM");
                s += namthidau + ",";
                String giaidau = rs.getString("GIAI DAU");
                s += giaidau + ",";
                String thanhtich = rs.getString("THANH TICH");
                
                s += thanhtich + ",";
                s += "%";
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
      public String getDataThanhTichByName(String name){
        
         String s = "";
        try {

             String command = " select * from thanhtich where `thanh tich` = '" + name +"';" ;
            rs = st.executeQuery(command);
            while (rs.next()) {
                String namthidau = rs.getString("NAM");
                s += namthidau + ",";
                String giaidau = rs.getString("GIAI DAU");
                s += giaidau + ",";
                String thanhtich = rs.getString("THANH TICH");
                
                s += thanhtich + ",";
                s += "%";
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
      
      
    public int checkUserLogin(String username ,String password){
        int i = 0 ;
        try {
          
            String command = "select * from taikhoan where username = '" + username +"';"  ;
            rs = st.executeQuery(command);
            
            while (rs.next()){
                String pass  = rs.getString(2);
                if (pass.equals(password)){
                i = 1 ;
            }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i ;
    }
    
    public int addTaiKhoan(String username,String password){
           int i = 0 ;
        try {
         
            String command = "insert into taikhoan values('"+username+"','"+password+"',0);" ;
            i = st.executeUpdate(command);
            if ( i > 0 ) i =1; 
        } catch (SQLException ex) {
            i = 0 ;
        }
        return i ;
    }
    
     public int updateTaiKhoan(String username,String password){
           int i = 0 ;
        try {
         
            String command = "update taikhoan set matkhau = '"+ password +"' where username = '"+ username +"';";
            i = st.executeUpdate(command);
            if ( i > 0 ) i =1; 
        } catch (SQLException ex) {
            i = 0 ;
        }
        return i ;
    }
     
    public List getNam(){
          List nam = new ArrayList<>();
        try {
          
            String command ="select distinct nam from  `doanh thu` order by nam asc ;" ;
            rs = st.executeQuery(command);
            while (rs.next()){
                int year = rs.getInt(1);
                nam.add(year);
            }
        } catch (SQLException ex) {
           return nam ;
        }
         return nam ;
    }
    
    public String getDoanhThuTheoQuy(int year, int quy ){
        String s ="";
        String command ="select *  from `doanh thu` where nam = " + year +" and quy = " + quy+" ;" ;
        // du lieu duoc sap theo quy
        try{
        rs =st. executeQuery(command);
        while (rs.next()){
            int doanhthu  = rs.getInt("doanh thu");
            s = String.valueOf(doanhthu);
        }
        }
        catch(Exception ex){
            return s ;
        }
        return s ;
    }
    
    public String getDoanhThuYears(){
        String s = "";
        List listYear = getNam();
        for (int i  = 0 ; i < listYear.size() ; i ++){
            // lay du lieu theo tung nam trong tung quy 
            String doanhthuquy1 = getDoanhThuTheoQuy((int) listYear.get(i), 1);
            s+= doanhthuquy1+"," ;
            String doanhthuquy2 = getDoanhThuTheoQuy((int) listYear.get(i), 2);
             s+= doanhthuquy2+",";
            String doanhthuquy3 = getDoanhThuTheoQuy((int) listYear.get(i), 3);
             s+= doanhthuquy3+",";
            String doanhthuquy4 = getDoanhThuTheoQuy((int) listYear.get(i), 4);
             s+= doanhthuquy4+",";
             s+=listYear.get(i);
            s+= "%";
        }
        return s ;
    }
    public static void main(String[] args) {
        ConnectDataBase c = new ConnectDataBase();
      //  System.out.println(c.getDataPlayerLikeId("P"));
       
       //String string [] ={"D1","Minh","Chu Tich Hoi Dong Quan Tri","4000"};
         // System.out.println(c.updateBanLanhDaoToDatabase(string));
       
        System.out.println(c.getDoanhThuYears()+":showdoanhthu");
      
    }

}

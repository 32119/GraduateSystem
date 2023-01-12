package coursedesign.db.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class shenbaoDAOImpl extends DAOBase implements shenbaoDAO {
    //向shenbao数据表插入一条数据
    private static final String SHENBAO_INSERT_SQL = "INSERT INTO shenbao(shenbao_id,student_id,zhiyuan1_id,zhiyuan2_id,zhiyuan1_jieguo,zhiyuan2_jieguo) VALUES(?,?,?,?,?,?) ";
    @Override
    public void addShenbao(shenbao s) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_INSERT_SQL);
            psmt.setString(1, s.getshenbao_id());
            psmt.setString(2, s.getstudent_id());
            psmt.setString(3, s.getzhiyuan1_id());
            psmt.setString(4, s.getzhiyuan2_id());
            psmt.setString(5, s.getzhiyuan1_jieguo());
            psmt.setString(6, s.getzhiyuan2_jieguo());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //更新志愿1
    private static final String SHENBAO_UPDATE1_SQL = "update shenbao set zhiyuan1_id=? where student_id=? ";
    @Override
    public void updateShenbao1(shenbao s) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_UPDATE1_SQL);
            psmt.setString(1, s.getzhiyuan1_id());
            psmt.setString(2, s.getstudent_id());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //更新志愿2
    private static final String SHENBAO_UPDATE2_SQL = "update shenbao set zhiyuan2_id=? where student_id=? ";
    @Override
    public void updateShenbao2(shenbao s) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_UPDATE2_SQL);
            psmt.setString(1, s.getzhiyuan2_id());
            psmt.setString(2, s.getstudent_id());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //更新志愿1结果
    private static final String SHENBAO_UPDATEJIEGUO1_SQL = "update shenbao set zhiyuan1_jieguo=? where shenbao_id=? ";
    @Override
    public void updateShenbaoJieguo1(shenbao s) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_UPDATEJIEGUO1_SQL);
            psmt.setString(1, s.getzhiyuan1_jieguo());
            psmt.setString(2, s.getshenbao_id());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //更新志愿2结果
    private static final String SHENBAO_UPDATEJIEGUO2_SQL = "update shenbao set zhiyuan2_jieguo=? where shenbao_id=? ";
    @Override
    public void updateShenbaoJieguo2(shenbao s) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_UPDATEJIEGUO2_SQL);
            psmt.setString(1, s.getzhiyuan2_jieguo());
            psmt.setString(2, s.getshenbao_id());
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //更新可选志愿数
    private static final String SHENBAO_ZHIYUAN_SQL = "update shenbao set zhiyuan2_id=NULL,zhiyuan2_jieguo=NULL where shenbao_id like 's%' ";
    @Override
    public void updateZhiyuanShuliang() {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_ZHIYUAN_SQL);
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //删除一条数据
    private static final String SHENBAO_DELETE_SQL = "delete from shenbao where shenbao_id=? ";
    @Override
    public void deleteShenbao(String shenbao_id) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_DELETE_SQL);
            psmt.setString(1, shenbao_id);
            psmt.executeUpdate();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //按照student_id查询数据
    private static final String SHENBAO_SELECT_SQL="SELECT * from shenbao where student_id=?";
    @Override
    public shenbao getShenbaoById(String student_id) {
        Connection con = null;
        shenbao s=new shenbao();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_SELECT_SQL);
            psmt.setString(1,student_id);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                s.setshenbao_id(rs.getString("shenbao_id"));
                s.setstudent_id(rs.getString("student_id"));
                s.setzhiyuan1_id(rs.getString("zhiyuan1_id"));
                s.setzhiyuan2_id(rs.getString("zhiyuan2_id"));
                s.setzhiyuan1_jieguo(rs.getString("zhiyuan1_jieguo"));
                s.setzhiyuan2_jieguo(rs.getString("zhiyuan2_jieguo"));
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return s;
    }

    //查询多条申报结果
    private static final String SHENBAO_SELECTALL_SQL="SELECT * from shenbao";
    @Override
    public List<shenbao> getShenbao() {
        Connection con = null;
        List<shenbao> list=new ArrayList<shenbao>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(SHENBAO_SELECTALL_SQL);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                shenbao s=new shenbao();
                s.setshenbao_id(rs.getString("shenbao_id"));
                s.setstudent_id(rs.getString("student_id"));
                s.setzhiyuan1_id(rs.getString("zhiyuan1_id"));
                s.setzhiyuan2_id(rs.getString("zhiyuan2_id"));
                s.setzhiyuan1_jieguo(rs.getString("zhiyuan1_jieguo"));
                s.setzhiyuan2_jieguo(rs.getString("zhiyuan2_jieguo"));
                list.add(s);
            }
            rs.close();
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
}

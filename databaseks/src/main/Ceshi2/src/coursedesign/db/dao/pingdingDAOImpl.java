package coursedesign.db.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class pingdingDAOImpl extends DAOBase implements pingdingDAO {
    //更新学生自述
    private static final String PINGDING_UPDATEZISHU_SQL = "update pingding set zishu=? where student_id=? ";
    @Override
    public void pingdingStudent(pingding p) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PINGDING_UPDATEZISHU_SQL);
            psmt.setString(1, p.getzishu());
            psmt.setString(2, p.getstudent_id());
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

    //更新老师评价和评价结果
    private static final String PINGDING_UPDATEPINGJIA_SQL = "update pingding set laoshipingjia=? and pingjiajieguo=? where student_id=? ";
    @Override
    public void pingdingTeacher(pingding p) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PINGDING_UPDATEPINGJIA_SQL);
            psmt.setString(1, p.getlaoshipingjia());
            psmt.setString(2, p.getpingjiajieguo());
            psmt.setString(3, p.getstudent_id());
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

    //向pingding数据表插入数据
    private static final String PINGDING_INSERT_SQL = "INSERT INTO pingding(pingding_id,course_id,student_id) VALUES(?,?,?) ";
    @Override
    public void addPingding(pingding p) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PINGDING_INSERT_SQL);
            psmt.setString(1, p.getpingding_id());
            psmt.setString(2, p.getcourse_id());
            psmt.setString(3, p.getstudent_id());
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

    //查询多条评价结果
    private static final String PINGDING_SELECTALL_SQL="SELECT * from pingding";
    @Override
    public List<pingding> getPingding() {
        Connection con = null;
        List<pingding> list=new ArrayList<pingding>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PINGDING_SELECTALL_SQL);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                pingding p=new pingding();
                p.setpingding_id(rs.getString("pingding_id"));
                p.setcourse_id(rs.getString("course_id"));
                p.setstudent_id(rs.getString("student_id"));
                p.setzishu(rs.getString("zishu"));
                p.setlaoshipingjia(rs.getString("laoshipingjia"));
                p.setpingjiajieguo(rs.getString("pingjiajieguo"));
                list.add(p);
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

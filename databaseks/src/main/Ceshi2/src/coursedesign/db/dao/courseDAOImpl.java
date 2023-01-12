package coursedesign.db.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class courseDAOImpl extends DAOBase implements courseDAO {
    //向course数据表插入一条数据
    private static final String COURSE_INSERT_SQL = "INSERT INTO course(course_id,course_name,course_xueshi,course_renshu,course_duixiang,course_xingzhi,course_time,student_id,teacher_id) VALUES(?,?,?,?,?,?,?,?,?) ";
    @Override
    public void addCourse(course c) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_INSERT_SQL);
            psmt.setString(1, c.getcourse_id());
            psmt.setString(2, c.getcourse_name());
            psmt.setInt(3, c.getcourse_xueshi());
            psmt.setInt(4, c.getcourse_renshu());
            psmt.setString(5, c.getcourse_duixiang());
            psmt.setString(6, c.getcourse_xingzhi());
            psmt.setString(7, c.getcourse_time());
            psmt.setString(8, c.getstudent_id());
            psmt.setString(9, c.getteacher_id());
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

    //更新一条课程信息
    private static final String COURSE_UPDATE_SQL = "update course set course_name=?,course_xueshi=?,course_renshu=?,course_duixiang=?,course_xingzhi=?,course_time=? where course_id=? ";
    @Override
    public void updateCourse(course c) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_UPDATE_SQL);
            psmt.setString(1, c.getcourse_name());
            psmt.setInt(2, c.getcourse_xueshi());
            psmt.setInt(3, c.getcourse_renshu());
            psmt.setString(4, c.getcourse_duixiang());
            psmt.setString(5, c.getcourse_xingzhi());
            psmt.setString(6, c.getcourse_time());
            psmt.setString(7, c.getcourse_id());
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
    private static final String COURSE_DELETE_SQL = "delete from course where course_id=? ";
    @Override
    public void deleteCourse(String course_id) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_DELETE_SQL);
            psmt.setString(1, course_id);
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

    //查询数据
    private static final String COURSE_SELECT_SQL="SELECT * from course where course_id=?";
    @Override
    public course getCourseById(String course_id) {
        Connection con = null;
        course c=new course();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_SELECT_SQL);
            psmt.setString(1,course_id);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                c.setcourse_id(rs.getString("course_id"));
                c.setcourse_name(rs.getString("course_name"));
                c.setcourse_xueshi(rs.getInt("course_xueshi"));
                c.setcourse_renshu(rs.getInt("course_renshu"));
                c.setcourse_duixiang(rs.getString("course_duixiang"));
                c.setcourse_xingzhi(rs.getString("course_xingzhi"));
                c.setcourse_time(rs.getString("course_time"));
                c.setstudent_id(rs.getString("student_id"));
                c.setteacher_id(rs.getString("teacher_id"));

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
        return c;
    }

    //查询多条
    private static final String COURSE_SELECTALL_SQL="SELECT * from course";
    @Override
    public List<course> getCourse() {
        Connection con = null;
        List<course> list=new ArrayList<course>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_SELECTALL_SQL);
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                course c=new course();
                c.setcourse_id(rs.getString("course_id"));
                c.setcourse_name(rs.getString("course_name"));
                c.setcourse_xueshi(rs.getInt("course_xueshi"));
                c.setcourse_renshu(rs.getInt("course_renshu"));
                c.setcourse_duixiang(rs.getString("course_duixiang"));
                c.setcourse_xingzhi(rs.getString("course_xingzhi"));
                c.setcourse_time(rs.getString("course_time"));
                c.setstudent_id(rs.getString("student_id"));
                c.setteacher_id(rs.getString("teacher_id"));
                list.add(c);
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

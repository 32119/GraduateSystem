package coursedesign.db.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//该chooseDAO持久层用于教师选课和取消选课
public class chooseDAOImpl extends DAOBase implements chooseDAO {
    //更新course类中的teacher_id
    private static final String COURSE_UPDATE_SQL = "update course set teacher_id=? where course_id=? ";
    @Override
    public void chooseCourse(course c) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_UPDATE_SQL);
            psmt.setString(1, c.getteacher_id());
            psmt.setString(2, c.getcourse_id());
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

    //取消选择之前所选择course，将teacher_id置为空
    private static final String COURSE_UPDATENULL_SQL = "update course set teacher_id=NULL where course_id=? ";
    @Override
    public void deleteCourse(String course_id) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(COURSE_UPDATENULL_SQL);
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
}

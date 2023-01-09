package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class pingtaiDaoImpl extends DAOBase implements pingtaiDao {
    private static final String PINGTAI_INSERT_SQL = "INSERT INTO pingtai(student_id,pingtaimingcheng,fuwudanwei,shangxianshijian,gongxiandupaiming,zuozhengcailiao) VALUES(?,?,?,?,?,?) ";

	@Override
	public void addpingtai(Dao.pingtai pingtai) {
		// TODO Auto-generated method stub
		Connection con = null;
		 try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(PINGTAI_INSERT_SQL);
	            psmt.setString(1, pingtai.getStudent_id());
	            psmt.setString(2, pingtai.getPingtaimingcheng());
	            psmt.setString(3,pingtai.getFuwudanwei());
	            psmt.setString(4, pingtai.getShangxianshijian());
	            psmt.setInt(5, pingtai.getGongxiandupaiming());
	            psmt.setString(6, pingtai.getZuozhengcailiao());
	           
	         
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
	private static final String  PINGTAI_UPDATE_SQL = "UPDATE pingtai SET student_id=?,pingtaimingcheng=?,fuwudanwei=?,shangxianshijian=?,gongxiandupaiming=?,zuozhengcailiao=? WHERE student_id=?";

	@Override
	public void updatepingtai(Dao.pingtai pingtai) {
		// TODO Auto-generated method stub
		Connection con = null;
		  try{
		con = getConnection();
  PreparedStatement psmt = con.prepareStatement(PINGTAI_UPDATE_SQL);
  psmt.setString(1, pingtai.getStudent_id());
  psmt.setString(2, pingtai.getPingtaimingcheng());
  psmt.setString(3, pingtai.getFuwudanwei());
  psmt.setString(4,pingtai.getShangxianshijian());
 
  psmt.setInt(5, pingtai.getGongxiandupaiming());
  psmt.setString(6,pingtai.getZuozhengcailiao());
  psmt.setString(7, pingtai.getStudent_id());
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
	private static final String PINGTAI_DELETE_SQL = "DELETE FROM pingtai WHERE student_id=?";
	@Override
	public void deletepingtai(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PINGTAI_DELETE_SQL);
            psmt.setString(1, student_id);
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
	private static final String PINGTAI_SELECT_SQL = "SELECT student_id,pingtaimingcheng,fuwudanwei,shangxianshijian,gongxiandupaiming,zuozhengcailiao FROM pingtai WHERE student_id=?";

	@Override
	public pingtai getpingtai(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		pingtai pingtai  = new pingtai ();
	        try{
	        	 con = getConnection();
	             PreparedStatement psmt = con.prepareStatement(PINGTAI_SELECT_SQL);

	             psmt.setString(1, student_id);
	             ResultSet rs = psmt.executeQuery();
	             while (rs.next()){
	            	 pingtai.setStudent_id(rs.getString("student_id"));
	            	 pingtai .setPingtaimingcheng(rs.getString("pingtaimingcheng"));
	            	 pingtai .setFuwudanwei(rs.getString("fuwudanwei"));
	            	 pingtai .setShangxianshijian(rs.getString("shangxianshijian"));
	            
	            	 pingtai .setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
	            	 pingtai .setZuozhengcailiao(rs.getString("zuozhengcailiao"));
	            	
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
	        return pingtai;
	}
	private static final String PINGTAI_SELECT_ALL_SQL = "SELECT student_id,pingtaimingcheng,fuwudanwei,shangxianshijian,gongxiandupaiming,zuozhengcailiao FROM pingtai";
	
	@Override
	public List<pingtai> selectAllpingtai() {
		// TODO Auto-generated method stub
		Connection con = null;
        List<pingtai> pingtais = new ArrayList<pingtai>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PINGTAI_SELECT_ALL_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
            	pingtai pingtai = new pingtai();
            	 pingtai.setStudent_id(rs.getString("student_id"));
            	 pingtai .setPingtaimingcheng(rs.getString("pingtaimingcheng"));
            	 pingtai .setFuwudanwei(rs.getString("fuwudanwei"));
            	 pingtai .setShangxianshijian(rs.getString("shangxianshijian"));
            
            	 pingtai .setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
            	 pingtai .setZuozhengcailiao(rs.getString("zuozhengcailiao"));
                pingtais.add(pingtai);
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
		return pingtais;
	}
	


}

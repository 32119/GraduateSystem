package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class zhuanliDaoImpl extends DAOBase implements zhuanliDao {
    private static final String ZHUANLI_INSERT_SQL = "INSERT INTO zhuanli(zhuanli_id,student_id,zhuanlimingcheng,zhuanlileixing,fabushijian,zhuanlizhuangtai,gongxiandupaiming,zuozhengcailiao) VALUES(?,?,?,?,?,?,?,?) ";

	@Override
	public void addzhuanli(zhuanli zhuanli) {
		// TODO Auto-generated method stub
		 Connection con = null;
		 try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(ZHUANLI_INSERT_SQL);
	            psmt.setString(1, zhuanli.getZhuanli_id());
	            psmt.setString(2, zhuanli.getStudent_id());
	            psmt.setString(3, zhuanli.getZhuanlimingcheng());
	            psmt.setString(4,zhuanli.getZhuanlileixing());
	            psmt.setString(5,zhuanli.getFabushijian());
	            psmt.setString(6, zhuanli.getZhuanlizhuangtai());
	            psmt.setInt(7,zhuanli.getGongxiandupaiming());
	            psmt.setString(8,zhuanli.getZuozhengcailiao());
	         
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
	private static final String  ZHUANLI_UPDATE_SQL = "UPDATE zhuanli SET zhuanli_id=?, student_id=?,zhuanlimingcheng=?,zhuanlileixing=?,fabushijian=?,zhuanlizhuangtai=?,gongxiandupaiming=?,zuozhengcailiao=? WHERE zhuanli_id=?";

	@Override
	public void updatezhuanli(zhuanli zhuanli) {
		// TODO Auto-generated method stub
		Connection con = null;
		  try{
		con = getConnection();
  PreparedStatement psmt = con.prepareStatement(ZHUANLI_UPDATE_SQL);
  psmt.setString(1, zhuanli.getZhuanli_id());
  psmt.setString(2, zhuanli.getStudent_id());
  psmt.setString(3, zhuanli.getZhuanlimingcheng());
  psmt.setString(4, zhuanli.getZhuanlileixing());
  psmt.setString(5,zhuanli.getFabushijian());
  psmt.setString(6,zhuanli.getZhuanlizhuangtai());
  psmt.setInt(7, zhuanli.getGongxiandupaiming());
  psmt.setString(8,zhuanli.getZuozhengcailiao());
  psmt.setString(9,zhuanli.getZhuanli_id());
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
	private static final String ZHUANLI_DELETE_SQL = "DELETE FROM zhuanli WHERE zhuanli_id=?";
	@Override
	public void deletezhuanli(String zhuanli_id) {
		// TODO Auto-generated method stub
		Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(ZHUANLI_DELETE_SQL);
            psmt.setString(1, zhuanli_id);
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
	private static final String ZHUANLI_SELECT_SQL = "SELECT zhuanli_id,student_id,zhuanlimingcheng,zhuanlileixing,fabushijian,zhuanlizhuangtai,gongxiandupaiming,zuozhengcailiao FROM zhuanli WHERE zhuanli_id=?";
	
	@Override
	public zhuanli getzhuanli(String zhuanli_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		zhuanli zhuanli = new zhuanli();
	        try{
	        	 con = getConnection();
	             PreparedStatement psmt = con.prepareStatement(ZHUANLI_SELECT_SQL);

	             psmt.setString(1, zhuanli_id);
	             ResultSet rs = psmt.executeQuery();
	             while (rs.next()){
	            	 zhuanli.setZhuanli_id(rs.getString("zhuanli_id"));
	            	 zhuanli.setStudent_id(rs.getString("student_id"));
	            	 zhuanli.setZhuanlimingcheng(rs.getString("zhuanlimingcheng"));
	            	 zhuanli.setZhuanlileixing(rs.getString("zhuanlileixing"));
	            	 zhuanli.setFabushijian(rs.getString("fabushijian"));
	            	 zhuanli.setZhuanlizhuangtai(rs.getString("zhuanlizhuangtai"));
	            	 zhuanli.setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
	            	 zhuanli.setZuozhengcailiao(rs.getString("zuozhengcailiao"));
	            	
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
	        return zhuanli;
	}
	private static final String ZHUANLI_SELECT_ALL_SQL = "SELECT zhuanli_id,student_id,zhuanlimingcheng,zhuanlileixing,fabushijian,zhuanlizhuangtai,gongxiandupaiming,zuozhengcailiao FROM zhuanli";
	
	@Override
	public List<zhuanli> selectAllzhuanli() {
		// TODO Auto-generated method stub
		Connection con = null;
        List<zhuanli> zhuanlis = new ArrayList<zhuanli>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(ZHUANLI_SELECT_ALL_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
            	zhuanli zhuanli = new zhuanli();
            	 zhuanli.setZhuanli_id(rs.getString("zhuanli_id"));
            	 zhuanli.setStudent_id(rs.getString("student_id"));
            	 zhuanli.setZhuanlimingcheng(rs.getString("zhuanlimingcheng"));
            	 zhuanli.setZhuanlileixing(rs.getString("zhuanlileixing"));
            	 zhuanli.setFabushijian(rs.getString("fabushijian"));
            	 zhuanli.setZhuanlizhuangtai(rs.getString("zhuanlizhuangtai"));
            	 zhuanli.setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
            	 zhuanli.setZuozhengcailiao(rs.getString("zuozhengcailiao"));
            	
            	zhuanlis.add(zhuanli);
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
		return zhuanlis;
	}

}

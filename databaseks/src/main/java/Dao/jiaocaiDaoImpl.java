package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class jiaocaiDaoImpl extends DAOBase implements jiaocaiDao {
    private static final String JIAOCAI_INSERT_SQL = "INSERT INTO jiaocai(student_id,jiaocaimingcheng,chubanshe,chubanshijian,gongxiandupaiming,zuozhengcailiao) VALUES(?,?,?,?,?,?) ";


	@Override
	public void addjiaocai(jiaocai jiaocai) {
		// TODO Auto-generated method stub
		
		 Connection con = null;
		 try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(JIAOCAI_INSERT_SQL);
	            psmt.setString(1, jiaocai.getStudent_id());
	            psmt.setString(2, jiaocai.getJiaocaimingcheng());
	            psmt.setString(3, jiaocai.getChubanshe());
	            psmt.setString(4, jiaocai.getChubanshijian());
	            psmt.setInt(5,jiaocai.getGongxiandupaiming());
	            psmt.setString(6, jiaocai.getZuozhengcailiao());
	         
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
	private static final String  JIAOCAI_UPDATE_SQL = "UPDATE jiaocai SET student_id=?,jiaocaimingcheng=?,chubanshe=?,chubanshijian=?,gongxiandupaiming=?,zuozhengcailiao=? WHERE student_id=?";
	@Override
	public void updatejiaocai(jiaocai jiaocai) {
		// TODO Auto-generated method stub
		Connection con = null;
		  try{
		con = getConnection();
      PreparedStatement psmt = con.prepareStatement(JIAOCAI_UPDATE_SQL);
      psmt.setString(1, jiaocai.getStudent_id());
      psmt.setString(2, jiaocai.getJiaocaimingcheng());
      psmt.setString(3, jiaocai.getChubanshe());
      psmt.setString(4, jiaocai.getChubanshijian());
      psmt.setInt(5,jiaocai.getGongxiandupaiming());
      psmt.setString(6, jiaocai.getZuozhengcailiao());
      psmt.setString(7, jiaocai.getStudent_id());
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

	
	
	private static final String JIAOCAI_DELETE_SQL = "DELETE FROM jiaocai WHERE student_id=?";
	@Override
	public void deletejiaocai(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(JIAOCAI_DELETE_SQL);
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

	private static final String JIAOCAI_SELECT_SQL = "SELECT student_id,jiaocaimingcheng,chubanshe,chubanshijian,gongxiandupaiming,zuozhengcailiao FROM jiaocai WHERE student_id=?";
	@Override
	public jiaocai getjiaocai(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
	       jiaocai jiaocai = new jiaocai();
	        try{
	        	 con = getConnection();
	             PreparedStatement psmt = con.prepareStatement(JIAOCAI_SELECT_SQL);

	             psmt.setString(1, student_id);
	             ResultSet rs = psmt.executeQuery();
	             while (rs.next()){
	            	 jiaocai.setStudent_id(rs.getString("student_id"));
	            	 jiaocai.setJiaocaimingcheng(rs.getString("jiaocaimingcheng"));
	            	 jiaocai.setChubanshe(rs.getString("chubanshe"));
	            	 jiaocai.setChubanshijian(rs.getString("chubanshijian"));
	            	 jiaocai.setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
	            	 jiaocai.setZuozhengcailiao(rs.getString("zuozhengcailiao"));
	            	
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
	        return jiaocai;
	}
	private static final String JIAOCAI_SELECT_ALL_SQL = "SELECT student_id,jiaocaimingcheng,chubanshe,chubanshijian,gongxiandupaiming,zuozhengcailiao FROM jiaocai";
	
	@Override
	public List<jiaocai> selectAlljiaocai() {
		// TODO Auto-generated method stub
		Connection con = null;
        List<jiaocai> jiaocais = new ArrayList<jiaocai>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(JIAOCAI_SELECT_ALL_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                jiaocai jiaocai = new jiaocai();
                jiaocai.setStudent_id(rs.getString("student_id"));
           	 jiaocai.setJiaocaimingcheng(rs.getString("jiaocaimingcheng"));
           	 jiaocai.setChubanshe(rs.getString("chubanshe"));
           	 jiaocai.setChubanshijian(rs.getString("chubanshijian"));
           	 jiaocai.setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
           	 jiaocai.setZuozhengcailiao(rs.getString("zuozhengcailiao"));
                jiaocais.add(jiaocai);
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
		return jiaocais;

	}

	
}

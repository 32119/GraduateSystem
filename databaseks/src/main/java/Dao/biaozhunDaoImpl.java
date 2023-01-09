package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class biaozhunDaoImpl extends DAOBase implements biaozhunDao {
    private static final String BIAOZHUN_INSERT_SQL = "INSERT INTO biaozhun(student_id,biaozhunmingcheng,biaozhunjibie,fabushijian,zuozhengcailiao) VALUES(?,?,?,?,?) ";

	@Override
	public void addbiaozhun(biaozhun biaozhun) {
		// TODO Auto-generated method stub
		 Connection con = null;
		 try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(BIAOZHUN_INSERT_SQL);
	            psmt.setString(1, biaozhun.getStudent_id());
	            psmt.setString(2, biaozhun.getBiaozhunmingcheng());
	            psmt.setString(3, biaozhun.getBiaozhunjibie());
	            psmt.setString(4, biaozhun.getFabushijian());
	            psmt.setString(5,biaozhun.getZuozhengcailiao());
	         
	         
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
	private static final String  BIAOZHUN_UPDATE_SQL = "UPDATE biaozhun SET student_id=?,biaozhunmingcheng=?,biaozhunjibie=?,fabushijian=?,zuozhengcailiao=? WHERE student_id=?";

	@Override
	public void updatebiaozhun(biaozhun biaozhun) {
		// TODO Auto-generated method stub
		Connection con = null;
		  try{
		con = getConnection();
    PreparedStatement psmt = con.prepareStatement(BIAOZHUN_UPDATE_SQL);
    psmt.setString(1, biaozhun.getStudent_id());
    psmt.setString(2, biaozhun.getBiaozhunmingcheng());
    psmt.setString(3, biaozhun.getBiaozhunjibie());
    psmt.setString(4, biaozhun.getFabushijian());
    psmt.setString(5,biaozhun.getZuozhengcailiao());
    psmt.setString(6, biaozhun.getStudent_id());
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

	private static final String BIAOZHUN_DELETE_SQL = "DELETE FROM biaozhun WHERE student_id=?";
	@Override
	public void deletebiaozhun(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(BIAOZHUN_DELETE_SQL);
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
	private static final String BIAOZHUN_SELECT_SQL = "SELECT student_id,biaozhunmingcheng,biaozhunjibie,fabushijian,zuozhengcailiao FROM biaozhun WHERE student_id=?";
	
	@Override
	public biaozhun getbiaozhun(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
	       biaozhun biaozhun = new biaozhun();
	        try{
	        	 con = getConnection();
	             PreparedStatement psmt = con.prepareStatement(BIAOZHUN_SELECT_SQL);

	             psmt.setString(1, student_id);
	             ResultSet rs = psmt.executeQuery();
	             while (rs.next()){
	            	 biaozhun.setStudent_id(rs.getString("student_id"));
	            	 biaozhun.setBiaozhunmingcheng(rs.getString("biaozhunmingcheng"));
	            	 biaozhun.setBiaozhunjibie(rs.getString("biaozhunjibie"));
	            	 biaozhun.setFabushijian(rs.getString("fabushijian"));
	            	
	            	 biaozhun.setZuozhengcailiao(rs.getString("zuozhengcailiao"));
	            	
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
	        return biaozhun;
	}
	private static final String BIAOZHUN_SELECT_ALL_SQL = "SELECT student_id,biaozhunmingcheng,biaozhunjibie,fabushijian,zuozhengcailiao FROM biaozhun";
	
	@Override
	public List<biaozhun> selectAllbiaozhun() {
		// TODO Auto-generated method stub
		Connection con = null;
        List<biaozhun> biaozhuns = new ArrayList<biaozhun>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(BIAOZHUN_SELECT_ALL_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
            	biaozhun biaozhun = new biaozhun();
            	 biaozhun.setStudent_id(rs.getString("student_id"));
            	 biaozhun.setBiaozhunmingcheng(rs.getString("biaozhunmingcheng"));
            	 biaozhun.setBiaozhunjibie(rs.getString("biaozhunjibie"));
            	 biaozhun.setFabushijian(rs.getString("fabushijian"));
            	
            	 biaozhun.setZuozhengcailiao(rs.getString("zuozhengcailiao"));
            	biaozhuns.add(biaozhun);
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
		return biaozhuns;
	}




}

package Dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

	public class lunwenDaoImpl extends DAOBase implements lunwenDao {
	    private static final String LUNWEN_INSERT_SQL = "INSERT INTO lunwen(student_id,lunwenmingcheng,kanwumingcheng,lunwenzhuangtai,fabiaoshijian,suoyinleixing,guishukuqingkuang) VALUES(?,?,?,?,?,?,?) ";

		@Override
		public void addlunwen(lunwen lunwen) {
			// TODO Auto-generated method stub
			 Connection con = null;
			 try{
		            con = getConnection();
		            PreparedStatement psmt = con.prepareStatement(LUNWEN_INSERT_SQL);
		            psmt.setString(1, lunwen.getStudent_id());
		            psmt.setString(2, lunwen.getLunwenmingcheng());
		            psmt.setString(3, lunwen.getKanwumingcheng());
		            psmt.setString(4, lunwen.getLunwenzhuangtai());
		            psmt.setString(5, lunwen.getFabiaoshijian());
		            psmt.setString(6, lunwen.getSuoyinleixing());
		            psmt.setString(7, lunwen.getGuishukuqingkuang());
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
		private static final String  LUNWEN_UPDATE_SQL = "UPDATE lunwen SET student_id=?,lunwenmingcheng=?,kanwumingcheng=?,lunwenzhuangtai=?,fabiaoshijian=?,suoyinleixing=?,guishukuqingkuang=? WHERE student_id=?";
	   
		@Override
		public void updatelunwen(lunwen lunwen) {
			// TODO Auto-generated method stub
			Connection con = null;
			  try{
			con = getConnection();
            PreparedStatement psmt = con.prepareStatement(LUNWEN_UPDATE_SQL);
            psmt.setString(1, lunwen.getStudent_id());
            psmt.setString(2, lunwen.getLunwenmingcheng());
            psmt.setString(3, lunwen.getKanwumingcheng());
            psmt.setString(4, lunwen.getLunwenzhuangtai());
            psmt.setString(5, lunwen.getFabiaoshijian());
            psmt.setString(6, lunwen.getSuoyinleixing());
            psmt.setString(7, lunwen.getGuishukuqingkuang());
            psmt.setString(8, lunwen.getStudent_id());
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
		 private static final String LUNWEN_DELETE_SQL = "DELETE FROM lunwen WHERE student_id=?";
		@Override
		public void deletelunwen(String student_id) {
			// TODO Auto-generated method stub
			
			Connection con = null;
	        try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(LUNWEN_DELETE_SQL);
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
		private static final String LUNWEN_SELECT_SQL = "SELECT student_id,lunwenmingcheng,kanwumingcheng,lunwenzhuangtai,fabiaoshijian,suoyinleixing,guishukuqingkuang FROM lunwen WHERE student_id=?";
		@Override
		public lunwen getlunwen(String student_id) {
			// TODO Auto-generated method stub
			Connection con = null;
	       lunwen lunwen = new lunwen();
	        try{
	        	 con = getConnection();
	             PreparedStatement psmt = con.prepareStatement(LUNWEN_SELECT_SQL);

	             psmt.setString(1, student_id);
	             ResultSet rs = psmt.executeQuery();
	             while (rs.next()){
	                 lunwen.setStudent_id(rs.getString("student_id"));
	                 lunwen.setLunwenmingcheng(rs.getString("lunwenmingcheng"));
	                 lunwen.setKanwumingcheng(rs.getString("kanwumingcheng"));
	                 lunwen.setLunwenzhuangtai(rs.getString("lunwenzhuangtai"));
	                 lunwen.setFabiaoshijian(rs.getString("fabiaoshijian"));
	                 lunwen.setSuoyinleixing(rs.getString("suoyinleixing"));
	                 lunwen.setGuishukuqingkuang(rs.getString("guishukuqingkuang"));
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
	        return lunwen;
		}
		 private static final String LUNWEN_SELECT_ALL_SQL = "SELECT student_id,lunwenmingcheng,kanwumingcheng,lunwenzhuangtai,fabiaoshijian,suoyinleixing,guishukuqingkuang  FROM lunwen";
			
		@Override
		public List<lunwen> selectAlllunwen() {
			// TODO Auto-generated method stub
			Connection con = null;
	        List<lunwen> lunwens = new ArrayList<lunwen>();
	        try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(LUNWEN_SELECT_ALL_SQL);
	            ResultSet rs = psmt.executeQuery();
	            while (rs.next()){
	                lunwen lunwen = new lunwen();
	                lunwen.setStudent_id(rs.getString("student_id"));
	                 lunwen.setLunwenmingcheng(rs.getString("lunwenmingcheng"));
	                 lunwen.setKanwumingcheng(rs.getString("kanwumingcheng"));
	                 lunwen.setLunwenzhuangtai(rs.getString("lunwenzhuangtai"));
	                 lunwen.setFabiaoshijian(rs.getString("fabiaoshijian"));
	                 lunwen.setSuoyinleixing(rs.getString("suoyinleixing"));
	                 lunwen.setGuishukuqingkuang(rs.getString("guishukuqingkuang"));
	                lunwens.add(lunwen);
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
			return lunwens;
		}

}

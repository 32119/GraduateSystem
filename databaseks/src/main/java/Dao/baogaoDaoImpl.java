package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class baogaoDaoImpl extends DAOBase implements baogaoDao {
    private static final String BAOGAO_INSERT_SQL = "INSERT INTO baogao(student_id,baogaomingcheng,baogaoleixing,baogaoshijian,baogaodanwei,gongxiandupaiming,zuozhengcailiao) VALUES(?,?,?,?,?,?,?) ";

	@Override
	public void addbaogao(baogao baogao) {
		// TODO Auto-generated method stub
		Connection con = null;
		 try{
	            con = getConnection();
	            PreparedStatement psmt = con.prepareStatement(BAOGAO_INSERT_SQL);
	            psmt.setString(1, baogao.getStudent_id());
	            psmt.setString(2, baogao.getBaogaomingcheng());
	            psmt.setString(3, baogao.getBaogaoleixing());
	            psmt.setString(4, baogao.getBaogaoshijian());
	            psmt.setString(5,baogao.getBaogaodanwei());
	            psmt.setInt(6, baogao.getGongxiandupaiming());
	            psmt.setString(7,baogao.getZuozhengcailiao());
	         
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
	private static final String  BAOGAO_UPDATE_SQL = "UPDATE baogao SET student_id=?,baogaomingcheng=?,baogaoleixing=?,baogaoshijian=?,baogaodanwei=?,gongxiandupaiming=?,zuozhengcailiao=? WHERE student_id=?";

	@Override
	public void updatebaogao(baogao baogao) {
		// TODO Auto-generated method stub
		Connection con = null;
		  try{
		con = getConnection();
    PreparedStatement psmt = con.prepareStatement(BAOGAO_UPDATE_SQL);
    psmt.setString(1, baogao.getStudent_id());
    psmt.setString(2, baogao.getBaogaomingcheng());
    psmt.setString(3, baogao.getBaogaoleixing());
    psmt.setString(4, baogao.getBaogaoshijian());
    psmt.setString(5,baogao.getBaogaodanwei());
    psmt.setInt(6, baogao.getGongxiandupaiming());
    psmt.setString(7,baogao.getZuozhengcailiao());
    psmt.setString(8, baogao.getStudent_id());
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
	private static final String BAOGAO_DELETE_SQL = "DELETE FROM baogao WHERE student_id=?";
	@Override
	public void deletebaogao(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(BAOGAO_DELETE_SQL);
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

	
	
	private static final String BAOGAO_SELECT_SQL = "SELECT student_id,baogaomingcheng,baogaoleixing,baogaoshijian,baogaodanwei,gongxiandupaiming,zuozhengcailiao FROM baogao WHERE student_id=?";

	@Override
	public baogao getbaogao(String student_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		baogao baogao  = new baogao ();
	        try{
	        	 con = getConnection();
	             PreparedStatement psmt = con.prepareStatement(BAOGAO_SELECT_SQL);

	             psmt.setString(1, student_id);
	             ResultSet rs = psmt.executeQuery();
	             while (rs.next()){
	            	 baogao .setStudent_id(rs.getString("student_id"));
	            	 baogao .setBaogaomingcheng(rs.getString("baogaomingcheng"));
	            	 baogao .setBaogaoleixing(rs.getString("baogaoleixing"));
	            	 baogao .setBaogaoshijian(rs.getString("baogaoshijian"));
	            	 baogao .setBaogaodanwei(rs.getString("baogaodanwei"));
	            	 baogao .setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
	            	 baogao .setZuozhengcailiao(rs.getString("zuozhengcailiao"));
	            	
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
	        return baogao;

	}
	private static final String BAOGAO_SELECT_ALL_SQL = "SELECT student_id,baogaomingcheng,baogaoleixing,baogaoshijian,baogaodanwei,gongxiandupaiming,zuozhengcailiao FROM baogao";
	
	@Override
	public List<baogao> selectAllbaogao() {
		// TODO Auto-generated method stub
		Connection con = null;
        List<baogao> baogaos = new ArrayList<baogao>();
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(BAOGAO_SELECT_ALL_SQL);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                baogao baogao = new baogao();
                baogao .setStudent_id(rs.getString("student_id"));
           	 baogao .setBaogaomingcheng(rs.getString("baogaomingcheng"));
           	 baogao .setBaogaoleixing(rs.getString("baogaoleixing"));
           	 baogao .setBaogaoshijian(rs.getString("baogaoshijian"));
           	 baogao .setBaogaodanwei(rs.getString("baogaodanwei"));
           	 baogao .setGongxiandupaiming(rs.getInt("gongxiandupaiming"));
           	 baogao .setZuozhengcailiao(rs.getString("zuozhengcailiao"));
                baogaos.add(baogao);
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
		return baogaos;
	}

}

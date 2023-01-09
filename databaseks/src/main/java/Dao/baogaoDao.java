package Dao;

import java.util.List;

public interface baogaoDao {
	 void addbaogao(  baogao   baogao);
	    void updatebaogao( baogao  baogao);
	    void deletebaogao(String student_id);
	    baogao getbaogao(String student_id);
	    List< baogao>selectAllbaogao();
}

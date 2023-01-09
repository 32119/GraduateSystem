package Dao;

import java.util.List;

public interface biaozhunDao {
	 void addbiaozhun( biaozhun  biaozhun);
	    void updatebiaozhun(biaozhun biaozhun);
	    void deletebiaozhun(String student_id);
	    biaozhun getbiaozhun(String student_id);
	    List<biaozhun> selectAllbiaozhun();
}

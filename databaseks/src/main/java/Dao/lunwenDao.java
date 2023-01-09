package Dao;

import java.util.List;

public interface lunwenDao {
	 void addlunwen(lunwen  lunwen);
	    void updatelunwen(lunwen lunwen);
	    void deletelunwen(String student_id);
	    lunwen getlunwen(String student_id);
	    List<lunwen> selectAlllunwen();
}

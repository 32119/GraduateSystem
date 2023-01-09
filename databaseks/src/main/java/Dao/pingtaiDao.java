package Dao;

import java.util.List;

public interface pingtaiDao {
	 void addpingtai( pingtai  pingtai);
	    void updatepingtai( pingtai pingtai);
	    void deletepingtai(String student_id);
	    pingtai getpingtai(String student_id);
	    List<pingtai>selectAllpingtai();
}

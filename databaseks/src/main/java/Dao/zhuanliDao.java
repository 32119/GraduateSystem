package Dao;

import java.util.List;

public interface zhuanliDao {
	 void addzhuanli( zhuanli  zhuanli);
	    void updatezhuanli(zhuanli zhuanli);
	    void deletezhuanli(String student_id);
	    zhuanli getzhuanli(String student_id);
	    List<zhuanli> selectAllzhuanli();
}

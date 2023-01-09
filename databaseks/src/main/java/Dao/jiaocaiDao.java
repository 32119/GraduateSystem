package Dao;

import java.util.List;

public interface jiaocaiDao {
	 void addjiaocai( jiaocai  jiaocai);
	    void updatejiaocai(jiaocai jiaocai);
	    void deletejiaocai(String student_id);
	    jiaocai getjiaocai(String student_id);
	    List<jiaocai> selectAlljiaocai();
}

package coursedesign.db.dao;

import java.util.List;

public interface pingdingDAO {
    void pingdingStudent(pingding p);
    void pingdingTeacher(pingding p);
    void addPingding(pingding p);
    List<pingding> getPingding();
}

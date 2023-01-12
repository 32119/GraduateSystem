package coursedesign.db.dao;

import java.util.List;

public interface shenbaoDAO {
    void addShenbao(shenbao s);
    void updateShenbao1(shenbao s);
    void updateShenbao2(shenbao s);
    void updateShenbaoJieguo1(shenbao s);
    void updateShenbaoJieguo2(shenbao s);
    void updateZhiyuanShuliang();
    void deleteShenbao(String shenbao_id);
    shenbao getShenbaoById(String student_id);
    List<shenbao> getShenbao();
}

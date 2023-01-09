package Dao;

public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory = new DAOFactory();
    }
    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return daoFactory;
    }

    public lunwenDao getlunwenDao(){
        return new lunwenDaoImpl();
    }
    public jiaocaiDao getjiaocaiDao(){
        return new jiaocaiDaoImpl();
    }
    public biaozhunDao getbiaozhunDao(){
        return new biaozhunDaoImpl();
    }
    public zhuanliDao getzhuanliDao(){
        return new zhuanliDaoImpl();
    }
    public baogaoDao getbaogaoDao(){
        return new baogaoDaoImpl();
    }
    public pingtaiDao getpingtaiDao(){
        return new pingtaiDaoImpl();
    }
}
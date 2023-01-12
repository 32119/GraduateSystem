package coursedesign.db.dao;


public class DAOFactory {
    private static DAOFactory daoFactory;
    static {
        daoFactory=new DAOFactory();
    }
    private DAOFactory(){

    }
    public static DAOFactory getInstance(){return daoFactory;}
    public courseDAO getCourseDAO(){return new courseDAOImpl();}
    public shenbaoDAO getShenbaoDAO(){return new shenbaoDAOImpl();}
    public chooseDAO getChooseDAO(){return new chooseDAOImpl();}
    public pingdingDAO getPingdingDAO(){return new pingdingDAOImpl();}
}

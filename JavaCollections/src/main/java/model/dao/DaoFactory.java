package model.dao;

public class DaoFactory {
    
    public static GameDaoJdbc newGameDao() throws Exception {
        return new GameDaoJdbc();
    }
    
    public static PlatformDaoJdbc newPlatformDao() throws Exception {
        return new PlatformDaoJdbc();
    }
    
}

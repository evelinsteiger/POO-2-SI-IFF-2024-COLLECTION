package model.dao;

import java.util.List;

public interface InterfaceDao<T> {
    
    public abstract void create(T input) throws Exception;
   
    public abstract void update(T input, int id) throws Exception;
    
    public abstract void delete(T input) throws Exception;
    
    public abstract T show(int id) throws Exception;
    
    public abstract List<T> index(String param) throws Exception;
    
    public abstract List<T> favorite(int id) throws Exception;
    
    public abstract List<T> updateStatus(T input) throws Exception;
    
}

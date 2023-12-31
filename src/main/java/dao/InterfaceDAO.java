package dao;

import java.util.ArrayList;

/**
 *
 * @author Nguyễn Thanh Nhứt
 */
public interface InterfaceDAO<T> {

    public ArrayList<T> selectAll();

    public T selectbyId(T t);

    public int insert(T t);

    public int update(T t);

    public int delete(T t);
}

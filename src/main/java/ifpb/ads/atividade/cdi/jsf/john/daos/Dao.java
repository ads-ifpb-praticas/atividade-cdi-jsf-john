/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.daos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author recursive
 */
public interface Dao <T>{
    
    void add(T obj)throws SQLException ;
    void remove(T obj)throws SQLException ;
    void update(T obj)throws SQLException ;
    T get(int key)throws SQLException ;
    List<T> list()throws SQLException ;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.daos;

import ifpb.ads.atividade.cdi.jsf.john.beans.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author recursive
 */
public class CategoriaDao implements Dao<Categoria>{
    private final Connection con;
    
    public CategoriaDao () throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }
    
    @Override
    public void add(Categoria obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO categoria (nome)"
            + " VALUES (?)");

        stmt.setString(1, obj.getNome());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(Categoria obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM categoria WHERE id = ?");
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(Categoria obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE categoria SET nome=? WHERE id=?");
        stmt.setString(1, obj.getNome());
        stmt.setInt(2, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public Categoria get(int key) throws SQLException {
        Categoria mar = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM categoria WHERE id = ?");
        stmt.setInt(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            
            mar = new Categoria();
            mar.setId(rs.getInt("id"));
            mar.setNome(rs.getString("nome"));
            
        }
        stmt.close();
        return mar;
    }

    @Override
    public List<Categoria> list() throws SQLException {
        List<Categoria> categorias = new LinkedList<>();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM categoria");
        
        ResultSet rs = stmt.executeQuery();
        Categoria mar =null;
        while (rs.next()){
            
            mar = new Categoria();
            mar.setId(rs.getInt("id"));
            mar.setNome(rs.getString("nome"));
            
            categorias.add(mar);
            
        }
        stmt.close();
        return categorias;
    }
    
}

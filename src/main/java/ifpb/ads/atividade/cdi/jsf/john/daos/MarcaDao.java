/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.daos;

import ifpb.ads.atividade.cdi.jsf.john.beans.Marca;
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
public class MarcaDao implements Dao<Marca>{
    
    private final Connection con;
    
    public MarcaDao () throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }
    @Override
    public void add(Marca obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO marca ( nome)"
            + " VALUES (?)");

        stmt.setString(1, obj.getNome());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(Marca obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM marca WHERE id = ?");
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(Marca obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE marca SET nome=?, WHERE id=?");
        stmt.setString(1, obj.getNome());
        stmt.setInt(2, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public Marca get(int key) throws SQLException {
        Marca mar = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM marca WHERE id = ?");
        stmt.setInt(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            
            mar = new Marca();
            mar.setId(rs.getInt("id"));
            mar.setNome(rs.getString("nome"));
            
        }
        stmt.close();
        return mar;
    }

    @Override
    public List<Marca> list() throws SQLException {
        List<Marca> marcas = new LinkedList<>();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM marca");
        
        ResultSet rs = stmt.executeQuery();
        Marca mar =null;
        while (rs.next()){
            
            mar = new Marca();
            mar.setId(rs.getInt("id"));
            mar.setNome(rs.getString("nome"));
            
            marcas.add(mar);
            
        }
        stmt.close();
        return marcas;
    }
    
    
    
}

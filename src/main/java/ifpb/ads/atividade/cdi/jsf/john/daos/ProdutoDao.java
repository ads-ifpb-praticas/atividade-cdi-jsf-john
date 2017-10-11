/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.daos;

import ifpb.ads.atividade.cdi.jsf.john.beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author recursive
 */
public class ProdutoDao implements Dao<Produto>{

    private final Connection con;
    
    public ProdutoDao () throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }
    
    @Override
    public void add(Produto obj)throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO produto (nome, descricao, preco, marca, categoria, foto)"
            + " VALUES (?,?,?,?,?,?)");
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getDescrição());
        stmt.setDouble(3, obj.getPreco());
        stmt.setString(4, obj.getMarca());
        stmt.setString(5, obj.getCategoria());
        stmt.setString(6, obj.getFoto());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(Produto obj)throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM produto WHERE id = ?");
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(Produto obj)throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE produto SET nome=?, descricao=?, preco=?, marca=?, categoria=?,  foto=? WHERE id=?");
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getDescrição());
        stmt.setDouble(3, obj.getPreco());
        stmt.setString(4, obj.getMarca());
        stmt.setString(5, obj.getCategoria());
        stmt.setString(6, obj.getFoto());
        stmt.setInt(7, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Inject
    @Override
    public Produto get(int key)throws SQLException {
        Produto prod = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM produto WHERE id = ?");
        stmt.setInt(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            
            prod.setId(rs.getInt("id"));
            prod.setNome(rs.getString("nome"));
            prod.setDescrição(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            prod.setMarca(rs.getString("marca"));
            prod.setCategoria(rs.getString("categoria"));
            prod.setFoto(rs.getString("foto"));
            
        }
        stmt.close();
        return prod;
    }

    @Inject
    @Override
    public List<Produto> list()throws SQLException {
        List<Produto> produtos = new LinkedList<>();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM produto");
        
        ResultSet rs = stmt.executeQuery();
        Produto prod;
        while (rs.next()){
            
            prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setNome(rs.getString("nome"));
            prod.setDescrição(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            prod.setMarca(rs.getString("marca"));
            prod.setCategoria(rs.getString("categoria"));
            prod.setFoto(rs.getString("foto"));
            
            produtos.add(prod);
            
        }
        stmt.close();
        return produtos;
    }
    
}

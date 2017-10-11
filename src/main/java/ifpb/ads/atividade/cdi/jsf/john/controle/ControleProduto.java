/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.controle;

import ifpb.ads.atividade.cdi.jsf.john.beans.Produto;
import java.util.List;
import javax.inject.Inject;
import ifpb.ads.atividade.cdi.jsf.john.daos.ProdutoDao;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
/**
 *
 * @author recursive
 */

@Named
@RequestScoped
public class ControleProduto {
    
    @Inject
    private ProdutoDao dao;
    @Inject
    private ControleCategoriaMarca ccm;
    @Inject
    private Produto produto;
    
    public List<Produto> getProdutos() throws SQLException {
        List<Produto> produtos = dao.list();
        return produtos;
    }

    public void addProduto(Produto produto) throws SQLException{
        dao.add(produto);
    }

    public ProdutoDao getDao() {
        return dao;
    }

    public void setDao(ProdutoDao dao) {
        this.dao = dao;
    }

    public ControleCategoriaMarca getCcm() {
        return ccm;
    }

    public void setCcm(ControleCategoriaMarca ccm) {
        this.ccm = ccm;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}

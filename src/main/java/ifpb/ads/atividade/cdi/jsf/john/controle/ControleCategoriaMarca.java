/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.atividade.cdi.jsf.john.controle;

import ifpb.ads.atividade.cdi.jsf.john.beans.Categoria;
import ifpb.ads.atividade.cdi.jsf.john.beans.Marca;
import ifpb.ads.atividade.cdi.jsf.john.daos.CategoriaDao;
import ifpb.ads.atividade.cdi.jsf.john.daos.MarcaDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author recursive
 */

@Named
@ApplicationScoped
public class ControleCategoriaMarca implements Serializable{
    
    @Inject
    private CategoriaDao cdao;
    @Inject
    private MarcaDao mdao;
    
    public List<Categoria> getCategorias() throws SQLException {
        List<Categoria> categorias = cdao.list();
        return categorias;
    }

    public void addCategoria(Categoria categoria) throws SQLException{
        cdao.add(categoria);
    }
    
    public List<Marca> getMarcas() throws SQLException {
        List<Marca> marcas = mdao.list();
        return marcas;
    }

    public void addMarcas(Marca marca) throws SQLException{
        mdao.add(marca);
    }

    public CategoriaDao getCdao() {
        return cdao;
    }

    public void setCdao(CategoriaDao cdao) {
        this.cdao = cdao;
    }

    public MarcaDao getMdao() {
        return mdao;
    }

    public void setMdao(MarcaDao mdao) {
        this.mdao = mdao;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Bodega;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Darwin
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {


    @PersistenceContext(name = "examenweb")
    private EntityManager em;
    
    @EJB
    private BodegaFacade bodegaFacade;
    
    public ProductoFacade(){
        super(Producto.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public Producto getProductoNombre(String nombre) {
        String jpql = "SELECT u FROM Producto p WHERE p.nombre = '" + nombre+"'";
        Producto producto = (Producto) em.createQuery(jpql).getSingleResult();
        return producto;
    }

    public List<String> getProductosNombres() {
        String jpql = "SELECT p.nombre FROM Producto p ";
        List<String> res = em.createQuery(jpql).getResultList();
        return res;
    }
    
    public void guardarProducto(String nombre, int stock, double precio) throws Exception {
        Producto pro = new Producto();
        pro.setNombre(nombre);
        pro.setStock(stock);
        pro.setPrecio(precio);
    }
    
    
}

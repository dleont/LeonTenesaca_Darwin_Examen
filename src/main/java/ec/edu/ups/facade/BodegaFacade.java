/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Darwin
 */
public class BodegaFacade extends AbstractFacade<Bodega>{
    
    @PersistenceContext(name = "examenweb")
    private EntityManager em;
    
    public BodegaFacade(){
        super(Bodega.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public Bodega getBodegaNombre(String nombre) {
        String jpql = "SELECT u FROM Bodega b WHERE b.nombre = '" + nombre+"'";
        Bodega bodega = (Bodega) em.createQuery(jpql).getSingleResult();
        return bodega;
    }

    public List<String> getBodegaNombres() {
        String jpql = "SELECT b.nombre FROM Bodega b ";
        List<String> res = em.createQuery(jpql).getResultList();
        return res;
    }
    
}

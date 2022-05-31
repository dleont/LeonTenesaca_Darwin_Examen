/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.*;

import ec.edu.ups.facade.BodegaFacade;
import ec.edu.ups.facade.ProductoFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darwin
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ProductoFacade productoFacade;
    
    @EJB
    private BodegaFacade bodegaFacade;
    
    private String nombre;
    private int stock;
    private double precio;
    private String bodega;
    
    List<String> list = new ArrayList<>();
    List<Producto> productos = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        //productos = productoFacade.findAll();

    }
    
    
    
}

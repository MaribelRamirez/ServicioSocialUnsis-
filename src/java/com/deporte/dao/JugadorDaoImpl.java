/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.dao;

import com.deporte.domain.Jugador;
import com.deporte.util.HibernateUtil;
import com.mchange.v2.c3p0.C3P0Registry;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Marifer
 */
public class JugadorDaoImpl implements JugadorDao{
//establecer la secion con la base de datos
    Session session;
    Properties props=new Properties();
   
    @Override
    public List<Jugador> obtenerRegistros() {
       try {
         
            session=HibernateUtil.getSessionFactory().openSession();
            List<Jugador> listaJugador=new ArrayList<>();
            session.createQuery("FROM Jugador").list();
            session.close();
            return listaJugador;
                    
        } catch (Exception e) {
            System.err.println("error al optener los registros");
         return null;
        }
         }

    @Override
    public void crearRegistro(Jugador jugador) {
        try {
           // props.load (new FileInputStream("properties"));
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //insertar el objeto en la base de datos
            session.save(jugador);
            session.getTransaction().commit();
            session.close();
           // System.out.println(props.getProperty("exito"));
        } catch (Exception e) {
            
               
            System.out.println(props.getProperty("errorAlta:")+ e.getMessage());
        }
       }

    @Override
    public void actualizarRegistro(Jugador jugador) {
        try {
            session=HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         session.update(jugador);
         session.getTransaction().commit();
            session.close();
           
        } catch (HibernateException e) {
            System.out.println("Error al obtener la lista"+ e.getMessage());
        
        }
     }

    @Override
    public void eliminarRegistro(int idJugador) {
       try {
            session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM jugador WHERE idJugador="+idJugador).executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Error al crear el registro"+ e.getMessage());
        }
   
    }

    public Jugador obtenerRegistro(int idJugador){
       try {
            session=HibernateUtil.getSessionFactory().openSession();
         Jugador jugador=(Jugador) session.createQuery("SELECT * FROM jugador WHERE idJugador="+idJugador).uniqueResult();
            session.close();
            return jugador;
        } catch (HibernateException e) {
            System.out.println("Error al obtener la lista"+ e.getMessage());
     
        }
        return null;
       
     }

    
    
       
     
}

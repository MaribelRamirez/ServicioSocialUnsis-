/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deporte.service;

import com.deporte.dao.JugadorDao;
import com.deporte.dao.JugadorDaoImpl;
import com.deporte.domain.Jugador;
import java.util.List;

/**
 *
 * @author Marifer
 */
public class JugadorServiceImplements  implements JugadorService{
private JugadorDao jugadorDao=new JugadorDaoImpl();
    @Override
    public void crearRegistro(Jugador jugador) {
        jugadorDao.crearRegistro(jugador);
    }

    @Override
    public List<Jugador> obtenerRegistros() {
       return jugadorDao.obtenerRegistros();
        
       }

    @Override
    public void actualizarRegistro(Jugador jugador) {
        jugadorDao.actualizarRegistro(jugador);
    }

    @Override
    public void eliminarRegistro(int idJugador) {
        jugadorDao.eliminarRegistro(idJugador);
     }

    @Override
    public Jugador obtenerRegistro(int idJugador) {
    return jugadorDao.obtenerRegistro(idJugador);
    }
    
}

package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    //Metodo que trae todos los elementos de la tabla
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();  //Se castea findAll a lista (List<Games>)
    }

    //Metodo para traer juego por id
    public Optional<Reservation> getReservation(int id) {    //Optional maneja los null investigar mas
        return reservationCrudRepository.findById(id);
    }

    //Metodo para guardar un objeto games, tambien sirve para actualizar
    public Reservation save(Reservation c) {
        return reservationCrudRepository.save(c);
    }

}

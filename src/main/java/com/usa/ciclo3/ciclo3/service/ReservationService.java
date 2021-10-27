package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Reservation;
import com.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()) {
                return reservationRepository.save(r);
            } else {
                return r;
            }
        }
    }

    public Reservation update(Reservation reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservacion.getIdReservation());
            if(!e.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

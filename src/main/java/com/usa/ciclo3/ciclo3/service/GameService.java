package com.usa.ciclo3.ciclo3.service;


import com.usa.ciclo3.ciclo3.model.Game;
import com.usa.ciclo3.ciclo3.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() {
        return gameRepository.getAll();
    }

    public Optional<Game> getGame(int id) {
        return gameRepository.getGames(id);
    }

    public Game save(Game g) {
        if (g.getId() == null) {
            return gameRepository.save(g);
        } else {
            Optional<Game> gaux = gameRepository.getGames(g.getId());
            if (gaux.isEmpty()) {
                return gameRepository.save(g);
            } else {
                return g;
            }
        }
    }

}

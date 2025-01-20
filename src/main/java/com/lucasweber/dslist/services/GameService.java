package com.lucasweber.dslist.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasweber.dslist.dto.GameMinDTO;
import com.lucasweber.dslist.entities.Game;
import com.lucasweber.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final ObjectMapper objectMapper;

    public GameService(GameRepository gameRepository, ObjectMapper objectMapper) {
        this.gameRepository = gameRepository;
        this.objectMapper = objectMapper;
    }

    public List<GameMinDTO> getAllMinGames(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(game -> objectMapper.convertValue(game, GameMinDTO.class)).collect(Collectors.toList());
    }
}

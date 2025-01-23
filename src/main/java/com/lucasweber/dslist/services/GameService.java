package com.lucasweber.dslist.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasweber.dslist.dto.GameDTO;
import com.lucasweber.dslist.dto.GameMinDTO;
import com.lucasweber.dslist.entities.Game;
import com.lucasweber.dslist.projections.GameMinProjection;
import com.lucasweber.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository, ObjectMapper objectMapper) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> getAllMinGames(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO getGameById(Long id){
        Game game = gameRepository.findById(id).orElse(null);
        return new GameDTO(game);
    }
    @Transactional(readOnly = true)
    public List<GameMinProjection> getAllGameByListId(Long listId) {
        return gameRepository.searchGameList(listId);
    }
}

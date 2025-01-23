package com.lucasweber.dslist.controllers;

import com.lucasweber.dslist.dto.GameListDTO;
import com.lucasweber.dslist.projections.GameMinProjection;
import com.lucasweber.dslist.services.GameListService;
import com.lucasweber.dslist.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(final GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> getAllGameLists() {
        return new ResponseEntity<>(gameListService.getAllGameLists(), HttpStatus.OK);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinProjection>> getGamesByListId(@PathVariable Long listId){
        return new ResponseEntity<>(gameService.getAllGameByListId(listId), HttpStatus.OK);
    }
}

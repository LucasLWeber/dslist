package com.lucasweber.dslist.controllers;

import com.lucasweber.dslist.dto.GameMinDTO;
import com.lucasweber.dslist.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> getAllGameMinDTO(){
        return new ResponseEntity<>(gameService.getAllMinGames(), HttpStatus.OK);
    }

}

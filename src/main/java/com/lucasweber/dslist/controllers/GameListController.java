package com.lucasweber.dslist.controllers;

import com.lucasweber.dslist.dto.GameListDTO;
import com.lucasweber.dslist.services.GameListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    private final GameListService gameListService;

    public GameListController(final GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> getAllGameLists() {
        return new ResponseEntity<>(gameListService.getAllGameLists(), HttpStatus.OK);
    }
}

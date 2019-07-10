package com.rps.rest;

import com.rps.core.CreateGameResultUseCase;
import com.rps.core.GameResult;
import com.rps.core.Outcome;
import com.rps.core.PlayPracticeGameUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/gameResults")
public class RpsRestController {

    private final CreateGameResultUseCase createGameResultUseCase;
    private final PlayPracticeGameUseCase playPracticeGameUseCase;

    @Autowired
    RpsRestController(CreateGameResultUseCase createGameResultUseCase, PlayPracticeGameUseCase playPracticeGameUseCase){
        this.createGameResultUseCase = createGameResultUseCase;
        this.playPracticeGameUseCase = playPracticeGameUseCase;
    }

    @PostMapping
    public GameResult CreateGameResult(@RequestBody CreateGameResultUseCase.Request request ){
        System.out.println("Player 1 throw: " + request.player1Throw );
        System.out.println("Player 2 throw: " + request.player2Throw );
        return createGameResultUseCase.execute( request );
    }


    @PostMapping("/practice")
    public PlayPracticeGameUseCase.Response PlayPracticeGameResult(@RequestBody PlayPracticeGameUseCase.Request request ){
        System.out.println("Player 1 throw: " + request.player1Throw );
        System.out.println("Player 2 throw: " + request.player2Throw );
        return playPracticeGameUseCase.execute( request );
    }
}
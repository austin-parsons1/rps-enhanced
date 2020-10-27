package com.rps.rest;

import com.rps.core.*;
import com.rps.persistence.DatabaseGameResultRepository;
import com.rps.persistence.DatabasePlayerRepository;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class GameResultsConfig {


    @Bean
    public CreateGameResultUseCase createGameResultUseCase( DatabaseGameResultRepository databaseGameResultRepository, GameResultIdProvider gameResultIdProvider ){
        return new DefaultCreateGameResultUseCase( databaseGameResultRepository, gameResultIdProvider );

    }

    @Bean
    public PlayPracticeGameUseCase playPracticeGameUseCase(){
        return new DefaultPlayPracticeGameUseCase();
    }

    @Bean
    public GetPlayersUseCase getPlayersUseCase( DatabasePlayerRepository playerRepository ){
        return new DefaultGetPlayersUseCase( playerRepository );
    }

    @Bean
    public GetPlayerStatsUseCase getPlayerStatsUseCase(DatabaseGameResultRepository databaseGameResultRepository){
        return new DefaultGetPlayerStatsUseCase( databaseGameResultRepository );
    }

    @Bean
    public GetPlayerGameRecordsUseCase getPlayerGameRecordsUseCase(DatabaseGameResultRepository databaseGameResultRepository){
        return new DefaultGetPlayerGameRecordsUseCase( databaseGameResultRepository );
    }



}

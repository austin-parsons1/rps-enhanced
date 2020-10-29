import { Component, OnInit } from "@angular/core";
import { PlayerStat, GameRecord } from "../game/game";
import { GameGateway } from "../game/game.gateway";

@Component({
  selector: "app-leaderboard",
  templateUrl: "./leaderboard.component.html",
  styleUrls: ["./leaderboard.component.css"],
})
export class LeaderboardComponent implements OnInit {
  playerStats: PlayerStat[] = [];
  gameRecords: GameRecord[] = [];
  selectedPlayer = -1;
  selectedPlayerStats: PlayerStat;

  constructor(private gameGateway: GameGateway) {
    this.playerStats = [];
    this.gameRecords = [];
  }

  ngOnInit() {
    this.getPlayerStats();
  }

  showPlayer(playerId: number) {
    console.log("Click - Player: ", playerId);
    this.selectedPlayer = playerId;
    if (playerId === -1) {
      this.getPlayerStats();
    } else {
      this.getPlayerStatsById(playerId);
      this.getGameRecords();
    }
  }
  getPlayerStatsById(id: number) {
    this.selectedPlayerStats = this.playerStats.filter(
      (x) => x.player.id === id
    )[0];
  }
  getPlayerStats() {
    this.playerStats = [];
    this.gameGateway.getPlayerStats().subscribe((returnedPlayerStats) => {
      for (let i = 0; i < returnedPlayerStats.length; i++) {
        this.playerStats.push(returnedPlayerStats[i]);
      }
      // this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
      console.log("got player Stats", this.playerStats);
    });
  }

  getGameRecords() {
    this.gameRecords = [];
    this.gameGateway
      .getPlayerGameRecords(this.selectedPlayer)
      .subscribe((returnedGameRecords) => {
        for (let i = 0; i < returnedGameRecords.length; i++) {
          this.gameRecords.push(returnedGameRecords[i]);
        }
        // this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
        console.log("got player game records", this.gameRecords);
      });
  }
}

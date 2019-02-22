package com.example.midterm;

import android.widget.Spinner;

public class Game {


    private String gameId;
    private String firstName;
    private String lastName;

    private String choice;
    private Boolean winner;


    // constructors
    public Game() {

    }

    public Game(String gameId, String firstName, String lastName, String choice, Boolean winner) {
        this.gameId = gameId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.choice = choice;
        this.winner = winner;
    }

    // getters for reading
    public String getArtistId() {
        return gameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getChoice() {
        return choice;
    }

    public Boolean getWinner() {
        return winner;
    }
}

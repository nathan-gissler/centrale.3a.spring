package com.centrale.rest.controller;

import com.centrale.rest.pierrefeuilleciseaux.Jeu;
import com.centrale.rest.pierrefeuilleciseaux.PlayerInfo;
import com.centrale.rest.pierrefeuilleciseaux.UserParams;
import com.centrale.rest.pierrefeuilleciseaux.UserParamsMult;
import com.centrale.rest.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping(value = "random")
@AllArgsConstructor
public class BasicController {

    private int totalGameCount = 0;

    private DataService dataService;

    @GetMapping(value = "/double")
    public double getRandomDouble(){
        return Math.random() * 10D;
    }

    @GetMapping(value = "/long/{min}/{max}")
    public Long getRandomIntFromInterval(@PathVariable int min, @PathVariable int max){
        Long random =  Math.round(Math.random() * (max - min) + min);
        dataService.addOccurrence(random);
        return random;
    }

    @GetMapping(value = "/statistics")
    public Map<Long, Integer> getStatisticsSeries(){
        return dataService.getOccurences();
    }

    @GetMapping(value = "/play")
    public String play(UserParams params) {
        totalGameCount += 1;
        Jeu jeu = new Jeu();
        jeu.play(params.getHandPlayerOne(), params.getHandPlayerTwo());
        if (jeu.getScoreJoueur1() > jeu.getScoreJoueur2()) {
            return "player 1 wins";
        }
        else if (jeu.getScoreJoueur1() < jeu.getScoreJoueur2()) {
            return "player 2 wins";
        }
        else {
            return "égalité";
        }
    }

    @GetMapping(value = "/play_mult")
    public String playMultiple(UserParamsMult params){
        int i = 0;
        int scorePlayerOne = 0;
        int scorePlayerTwo = 0;
        int gameCount = params.getGameCount();
        for(i = 0; i<gameCount; i++){
            totalGameCount += 1;
            Jeu jeu = new Jeu();
            jeu.play(params.getHandPlayerOne(), params.getHandPlayerTwo());
            if (jeu.getScoreJoueur1() > jeu.getScoreJoueur2()) {
                scorePlayerOne += 1;
            }
            else if (jeu.getScoreJoueur1() < jeu.getScoreJoueur2()) {
                scorePlayerTwo += 2;
            }
            else {
                scorePlayerOne += 1;
                scorePlayerTwo += 1;
            }
        }
        if (scorePlayerOne > scorePlayerTwo) {
            return "player 1 wins";
        }
        else if (scorePlayerOne < scorePlayerTwo) {
            return "player 2 wins";
        }
        else {
            return "égalité";
        }
    }


    @GetMapping(value = "/player/register")
    public String register(PlayerInfo info){
        String lastName = info.getLastName();
        String firstName = info.getFirstName();
        String id = info.getId();
        return "Bienvenue " + firstName + " " + lastName + ", votre id est " + id;
    }

    @GetMapping(value = "/rules")
    public String getRules(){
        return "Pierre gagne contre ciseaux, ciseaux gagne contre feuille, feuille gagne contre pierre.";
    }

    @GetMapping(value = "/games_played")
    public int getTotalGameCount(){
        return totalGameCount;
    }

}

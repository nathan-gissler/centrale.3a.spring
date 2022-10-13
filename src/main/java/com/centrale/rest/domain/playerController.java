package com.centrale.rest.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value="/player")
public class playerController {

    List<Player> listPlayer= new ArrayList<>();

    @PostMapping(value="/register")
    public Player register(@RequestBody Player p) {
        listPlayer.add(p);
        p.setId(listPlayer.toArray().length);
        return p;
    }

    @PostMapping(value="/update/{id}")
    public Player update(@RequestBody Player p, @PathVariable int id) {
        listPlayer.set(id, p);
        p.setId(id);
        return p;
    }

    @GetMapping(value="/get/{id}")
    public int getInfo(@PathVariable int id) {
        return id;
    }

    @GetMapping(value="/get/top")
    public void getTop() {

    }
}
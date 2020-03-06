package co.udea.hero.api.controller;

import co.udea.hero.api.model.Hero;
import co.udea.hero.api.service.HeroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private HeroService heroService;

    private HeroController(){
        heroService = new HeroService();
    }
    @GetMapping
    public Hero getHero(int id){
        return heroService.getHero(id);
    }
}

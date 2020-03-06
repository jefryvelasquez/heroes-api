package co.udea.hero.api.service;

import co.udea.hero.api.model.Hero;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    public Hero getHero(int id){
        return new Hero(1, "Chespirito");
    }
}

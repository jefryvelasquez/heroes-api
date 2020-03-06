package co.udea.hero.api.service;

import co.udea.hero.api.model.Hero;
import co.udea.hero.api.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    private HeroRepository heroRepository;

    public  HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    public Hero getHero(String id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        return optionalHero.get();
    }

    public List<Hero> getHeroes(){
        return heroRepository.findAll();

    }
}

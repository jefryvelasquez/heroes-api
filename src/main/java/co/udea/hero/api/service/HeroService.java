package co.udea.hero.api.service;

import co.udea.hero.api.exception.BusinessException;
import co.udea.hero.api.exception.DataBaseException;
import co.udea.hero.api.exception.DataDuplicatedException;
import co.udea.hero.api.model.Hero;
import co.udea.hero.api.repository.HeroRepository;
import co.udea.hero.api.util.Messages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    private Messages messages;
    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository, Messages messages) {
        this.heroRepository = heroRepository;
        this.messages = messages;
    }

    public Hero getHero(Integer id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        if (!optionalHero.isPresent()){
            throw new DataBaseException(messages.get("exception.data_id_not_exist.hero"));
        }
        return optionalHero.get();
    }

    public List<Hero> getHeroes(){

        if (heroRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.hero"));
        }
        return heroRepository.findAll();
    }


    public List <Hero> searchHeroes(String nombre){
        Optional<List<Hero>> optionalHero = heroRepository.findByNameContaining(nombre);
        if (!optionalHero.isPresent()){
            throw new BusinessException(messages.get("exception.data_not_found.hero"));
        }
        return optionalHero.get();
    }


    public Hero addHero(Hero hero){
        Optional<Hero> optionalHero = heroRepository.findByName(hero.getName());
        if(optionalHero.isPresent()){
            throw new DataDuplicatedException(messages.get("exception.data_duplicate_name.hero"));
        }
        return heroRepository.save(hero);
    }


    public void deleteHero (Integer id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        if(!optionalHero.isPresent()){
            throw new DataBaseException(messages.get("exception.data_id_not_exist.hero"));
        }
        heroRepository.deleteById(id);
    }

    public void updateHero (Hero hero){
        Optional<Hero> optionalHero = heroRepository.findById(hero.getId());
        if(!optionalHero.isPresent()){
            throw new DataBaseException(messages.get("exception.data_id_not_exist.hero"));
        }

        optionalHero.get().setName(hero.getName());
        addHero(optionalHero.get());
    }
}

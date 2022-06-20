package softuni.bg.heroes.services.factories.base;

import static softuni.bg.heroes.services.factories.HeroesConstants.INITIAL_ATTACK;
import static softuni.bg.heroes.services.factories.HeroesConstants.INITIAL_DEFENCE;
import static softuni.bg.heroes.services.factories.HeroesConstants.INITIAL_LEVEL;
import static softuni.bg.heroes.services.factories.HeroesConstants.INITIAL_STAMINA;
import static softuni.bg.heroes.services.factories.HeroesConstants.INITIAL_STRENGTH;

import softuni.bg.heroes.config.annotations.Factory;
import softuni.bg.heroes.data.models.Gender;
import softuni.bg.heroes.data.models.Hero;
import softuni.bg.heroes.services.factories.HeroesFactory;

@Factory
public class HeroesFactoryImpl implements HeroesFactory {
    @Override
    public Hero create(String name, Gender gender) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setGender(gender);
        hero.setAttack(INITIAL_ATTACK);
        hero.setDefence(INITIAL_DEFENCE);
        hero.setLevel(INITIAL_LEVEL);
        hero.setStamina(INITIAL_STAMINA);
        hero.setStrength(INITIAL_STRENGTH);

        return hero;
    }
}
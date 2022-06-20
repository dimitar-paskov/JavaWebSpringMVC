/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.services.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuni.bg.heroes.data.models.Hero;
import softuni.bg.heroes.data.models.Item;
import softuni.bg.heroes.data.models.Slot;
import softuni.bg.heroes.data.repositories.HeroesRepository;
import softuni.bg.heroes.errors.HeroNotFoundException;
import softuni.bg.heroes.services.factories.HeroesFactory;
import softuni.bg.heroes.services.models.HeroCreateServiceModel;
import softuni.bg.heroes.services.models.HeroDetailsServiceModel;
import softuni.bg.heroes.services.models.HeroItemServiceModel;
import softuni.bg.heroes.services.services.HeroesService;

@Service
public class HeroesServiceImpl implements HeroesService{
	
	private HeroesRepository heroesRepository;
	private HeroesFactory heroesFactory;
	private ModelMapper mapper;
	
	public HeroesServiceImpl(HeroesRepository heroesRepository, HeroesFactory heroesFactory, ModelMapper mapper) {
		this.heroesRepository = heroesRepository;
		this.heroesFactory = heroesFactory;
		this.mapper = mapper;
	}

	@Override
	public HeroDetailsServiceModel getByName(String name) {
		
//		Optional<Hero> heroOptional = heroesRepository.getByNameIgnoeCase(name);
//		if(heroOptional.isEmpty()) {
//			throw new NullPointerException("No such hero");
//		}
//		Hero hero =  heroOptional.get();
		Hero hero =  heroesRepository.getByNameIgnoreCase(name).orElseThrow(() -> new HeroNotFoundException("Nqma takuv geroj"));
		
		HeroDetailsServiceModel serviceModel = mapper.map(hero, HeroDetailsServiceModel.class);
		
		serviceModel.setWeapon(getItemBySlot(hero.getItems(),Slot.WEAPON));
		serviceModel.setGauntlets(getItemBySlot(hero.getItems(),Slot.GAUNTLETS));
		serviceModel.setHelmet(getItemBySlot(hero.getItems(),Slot.HELMET));
		serviceModel.setPads(getItemBySlot(hero.getItems(),Slot.PADS));
		serviceModel.setPauldrons(getItemBySlot(hero.getItems(),Slot.PAULDRON));
		
		return serviceModel;
		
	}

	@Override
	public Hero create(HeroCreateServiceModel heroServiceModel) {
		
		Hero hero = heroesFactory.create(heroServiceModel.getName(), heroServiceModel.getGender());
		heroesRepository.save(hero);
		
		return null;
	}
	
	private HeroItemServiceModel getItemBySlot(List<Item> items, Slot slot) {
        Optional<Item> item = items
                .stream()
                .filter(x -> x.getSlot() == slot)
                .findFirst();

        return item.isPresent()
                ? mapper.map(item, HeroItemServiceModel.class)
                : null;
    }

}

/**
 * @author dimitar
 *
 */
package softuni.bg.heroes.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import softuni.bg.heroes.data.models.Gender;
import softuni.bg.heroes.services.models.HeroCreateServiceModel;
import softuni.bg.heroes.web.models.HeroCreateModel;

@Configuration
public class ModelMapperConfig {
	
    private static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        initMapper(mapper);
    }

    private static void initMapper(ModelMapper mapper) {
        Converter<String, Gender> stringToGenderConverter =
                ctx -> Gender.valueOf(ctx.getSource().toUpperCase());

        mapper.createTypeMap(HeroCreateModel.class, HeroCreateServiceModel.class)
                .addMappings(map -> map
                        .using(stringToGenderConverter)
                        .map(
                                HeroCreateModel::getGender,
                                HeroCreateServiceModel::setGender
                        )
                );
    }
	
	@Bean
	public ModelMapper modelMapper() {
		
		return mapper;
	}

}

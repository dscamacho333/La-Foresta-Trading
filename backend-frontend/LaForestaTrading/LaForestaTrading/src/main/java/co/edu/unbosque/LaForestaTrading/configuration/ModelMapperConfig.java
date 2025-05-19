package co.edu.unbosque.LaForestaTrading.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        loadMappings(modelMapper);
        return modelMapper;
    }


    private void loadMappings(ModelMapper modelMappper){

    }



}

package br.com.api.infra.database.factories;

import org.modelmapper.ModelMapper;

public class ModelMapperFactory {
    public ModelMapper get() {
        var modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);

        return modelMapper;
    }
}

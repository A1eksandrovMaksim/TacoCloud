package com.example.TacoCloud.web;


import com.example.TacoCloud.Ingredient;
import com.example.TacoCloud.Ingredient.Type;
import com.example.TacoCloud.data.IngredientRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class IngredientByIdConverter 
        implements Converter<String, Ingredient>{

    private Map<String,  Ingredient> ingredientMap = new HashMap<>();

    private IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    
    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }    
}

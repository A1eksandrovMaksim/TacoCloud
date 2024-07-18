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

    private IngredientRepository ingredientRepo;
    
    private Map<String,  Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    
    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }    
}

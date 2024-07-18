package com.example.TacoCloud.data;

import com.example.TacoCloud.Ingredient;
import java.util.Optional;


public interface IngredientRepository {
    
    Iterable<Ingredient> findAll();
    
    Optional<Ingredient> findById(String id);
    
    Ingredient save(Ingredient ingredient);
    
}

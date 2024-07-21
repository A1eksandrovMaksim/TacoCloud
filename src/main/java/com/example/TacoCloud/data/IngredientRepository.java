package com.example.TacoCloud.data;

import com.example.TacoCloud.Ingredient;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository
        extends CrudRepository<Ingredient, String>{
}

package com.example.TacoCloud;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table
public class IngredientRef {
    
    private String ingredient;
    
}

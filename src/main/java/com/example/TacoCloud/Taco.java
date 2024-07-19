package com.example.TacoCloud;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table
public class Taco {
    
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    
    @NotNull
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
    
}

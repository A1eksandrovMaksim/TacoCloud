package com.example.TacoCloud.web;

import com.example.TacoCloud.Ingredient;
import com.example.TacoCloud.Ingredient.Type;
import com.example.TacoCloud.Taco;
import com.example.TacoCloud.TacoOrder;
import com.example.TacoCloud.data.IngredientRepository;
import jakarta.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    
    private final IngredientRepository ingredientRepo;
    
    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    
    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = (List)ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }
    
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    
    @PostMapping
    public String proccessTaco(@Valid Taco taco,
            Errors errors,
            @ModelAttribute TacoOrder tacoOrder){
        if(errors.hasErrors()){
            return "design";
        }
        
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        
        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
    
}

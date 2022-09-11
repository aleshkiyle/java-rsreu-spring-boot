package com.rodin.tacoCloud.controllers;

import com.rodin.tacoCloud.data.Ingredient;
import com.rodin.tacoCloud.data.Taco;
import com.rodin.tacoCloud.data.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = List.of(
                Ingredient.builder().id("FLTO").name("Flour Tortilla").type(Ingredient.Type.WRAP).build(),
                Ingredient.builder().id("COTO").name("Corn Tortilla").type(Ingredient.Type.WRAP).build(),
                Ingredient.builder().id("GRBF").name("Ground Beef").type(Ingredient.Type.PROTEIN).build(),
                Ingredient.builder().id("CARN").name("Carnitas").type(Ingredient.Type.PROTEIN).build(),
                Ingredient.builder().id("TMTO").name("Diced Tomatoes").type(Ingredient.Type.VEGGIES).build(),
                Ingredient.builder().id("LETC").name("Lettuce").type(Ingredient.Type.VEGGIES).build(),
                Ingredient.builder().id("CHED").name("Cheddar").type(Ingredient.Type.CHEESE).build(),
                Ingredient.builder().id("JACK").name("Monterrey Jack").type(Ingredient.Type.CHEESE).build(),
                Ingredient.builder().id("SLSA").name("Salsa").type(Ingredient.Type.SAUCE).build(),
                Ingredient.builder().id("SRCR").name("Sour Cream").type(Ingredient.Type.SAUCE).build()
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type: types) {
            model.addAttribute(type.toString().toLowerCase(Locale.ROOT),
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
    public String showDesignForm(){
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        Predicate<Ingredient> ingredientPredicate = ingredient -> ingredient.getType().equals(type);
        return ingredients.stream()
                .filter(ingredientPredicate)
                .collect(Collectors.toList());
    }
}

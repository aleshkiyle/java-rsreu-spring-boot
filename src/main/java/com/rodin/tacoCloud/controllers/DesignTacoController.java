package com.rodin.tacoCloud.controllers;

import com.rodin.tacoCloud.data.Ingredient;
import com.rodin.tacoCloud.data.Taco;
import com.rodin.tacoCloud.data.TacoOrder;
import com.rodin.tacoCloud.data.Type;
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

import static com.rodin.tacoCloud.data.Type.*;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = List.of(
                Ingredient.builder().id("FLTO").name("Flour Tortilla").type(WRAP).build(),
                Ingredient.builder().id("COTO").name("Corn Tortilla").type(WRAP).build(),
                Ingredient.builder().id("GRBF").name("Ground Beef").type(PROTEIN).build(),
                Ingredient.builder().id("CARN").name("Carnitas").type(PROTEIN).build(),
                Ingredient.builder().id("TMTO").name("Diced Tomatoes").type(VEGGIES).build(),
                Ingredient.builder().id("LETC").name("Lettuce").type(VEGGIES).build(),
                Ingredient.builder().id("CHED").name("Cheddar").type(CHEESE).build(),
                Ingredient.builder().id("JACK").name("Monterrey Jack").type(CHEESE).build(),
                Ingredient.builder().id("SLSA").name("Salsa").type(SAUCE).build(),
                Ingredient.builder().id("SRCR").name("Sour Cream").type(SAUCE).build()
        );

        Type[] types = Type.values();
        for (Type type: types) {
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

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        Predicate<Ingredient> ingredientPredicate = ingredient -> ingredient.getType().equals(type);
        return ingredients.stream()
                .filter(ingredientPredicate)
                .collect(Collectors.toList());
    }
}

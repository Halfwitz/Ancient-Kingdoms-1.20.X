package net.halfwitz.ancientkingdoms.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent ANCIENT_FRUIT = new FoodComponent.Builder().hunger(5).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING),.25f).build();
}

package com.example.examplemod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier CHOCOLATE = new ForgeTier(
            1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_CHOCOLATE_TOOL,
            () -> Ingredient.of(ModItems.CHOCOLATE.get()),
            ModTags.Blocks.INCORRECT_FOR_CHOCOLATE_TOOL);
}

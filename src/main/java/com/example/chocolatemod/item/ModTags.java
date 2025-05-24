package com.example.chocolatemod.item;

import com.example.chocolatemod.ChocolateMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_CHOCOLATE_TOOL = createTag("needs_chocolate_tool");
        public static final TagKey<Block> INCORRECT_FOR_CHOCOLATE_TOOL = createTag("incorrect_for_chocolate_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ChocolateMod.MOD_ID, name));
        }
    }

}

package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> CHOCOLATE = ITEMS.register("chocolate",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .nutrition(5)
                            .saturationModifier(2f)
                            .build()
                    )
            ));

    public static final RegistryObject<Item> CHOCOLATE_PICKAXE = ITEMS.register("chocolate_pickaxe",
            () -> new PickaxeItem(
                    ModToolTiers.CHOCOLATE,
                    new Item.Properties()
                    )
            );
    public static final RegistryObject<Block> CHOCOLATE_BLOCK = registerBlock("chocolate_block",
            () -> new Block(
                    BlockBehaviour
                            .Properties.of()
                            .strength(4f)
                            .requiresCorrectToolForDrops()
            )
    );


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }
}

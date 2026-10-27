package com.example.companionmod.registry;

import com.example.companionmod.CompanionMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CompanionMod.MOD_ID);

    public static final RegistryObject<Item> COMPANION_SPAWN_EGG = ITEMS.register("companion_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.COMPANION, 0x6B4F2A, 0xE0C080, new Item.Properties()));
}

package com.example.companionmod.client;

import net.minecraft.client.Minecraft;

/** Isolated so the server never loads client-only classes. */
public class ClientHooks {
    public static void openCommandScreen(int entityId) {
        Minecraft.getInstance().setScreen(new CompanionCommandScreen(entityId));
    }
}

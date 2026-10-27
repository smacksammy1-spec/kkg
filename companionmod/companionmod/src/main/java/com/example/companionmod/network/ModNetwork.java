package com.example.companionmod.network;

import com.example.companionmod.CompanionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetwork {
    private static final String PROTOCOL = "1";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(CompanionMod.MOD_ID, "main"),
            () -> PROTOCOL, PROTOCOL::equals, PROTOCOL::equals);

    public static void register() {
        int id = 0;
        CHANNEL.messageBuilder(OpenCommandScreenPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(OpenCommandScreenPacket::encode)
                .decoder(OpenCommandScreenPacket::decode)
                .consumerMainThread(OpenCommandScreenPacket::handle)
                .add();
        CHANNEL.messageBuilder(CommandPacket.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(CommandPacket::encode)
                .decoder(CommandPacket::decode)
                .consumerMainThread(CommandPacket::handle)
                .add();
    }
}

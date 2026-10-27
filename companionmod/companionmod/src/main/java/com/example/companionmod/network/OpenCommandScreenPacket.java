package com.example.companionmod.network;

import com.example.companionmod.client.ClientHooks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/** Server -> client: open the command screen for the given companion. */
public record OpenCommandScreenPacket(int entityId) {
    public static void encode(OpenCommandScreenPacket msg, FriendlyByteBuf buf) {
        buf.writeVarInt(msg.entityId);
    }

    public static OpenCommandScreenPacket decode(FriendlyByteBuf buf) {
        return new OpenCommandScreenPacket(buf.readVarInt());
    }

    public static void handle(OpenCommandScreenPacket msg, Supplier<NetworkEvent.Context> ctx) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientHooks.openCommandScreen(msg.entityId));
    }
}

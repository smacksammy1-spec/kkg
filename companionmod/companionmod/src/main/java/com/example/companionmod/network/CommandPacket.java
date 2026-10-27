package com.example.companionmod.network;

import com.example.companionmod.entity.CompanionCommand;
import com.example.companionmod.entity.CompanionEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/** Client -> server: issue a command to a companion. Server re-validates everything. */
public record CommandPacket(int entityId, CompanionCommand command) {
    public static void encode(CommandPacket msg, FriendlyByteBuf buf) {
        buf.writeVarInt(msg.entityId);
        buf.writeEnum(msg.command);
    }

    public static CommandPacket decode(FriendlyByteBuf buf) {
        return new CommandPacket(buf.readVarInt(), buf.readEnum(CompanionCommand.class));
    }

    public static void handle(CommandPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ServerPlayer player = ctx.get().getSender();
        if (player == null) return;
        Entity entity = player.level().getEntity(msg.entityId);
        if (entity instanceof CompanionEntity companion
                && companion.isOwnedBy(player)
                && player.distanceToSqr(companion) < 64.0) {
            companion.applyCommand(msg.command);
        }
    }
}

package com.example.companionmod.client;

import com.example.companionmod.entity.CompanionCommand;
import com.example.companionmod.network.CommandPacket;
import com.example.companionmod.network.ModNetwork;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CompanionCommandScreen extends Screen {
    private final int entityId;

    public CompanionCommandScreen(int entityId) {
        super(Component.translatable("gui.companionmod.title"));
        this.entityId = entityId;
    }

    @Override
    protected void init() {
        int cx = width / 2;
        int y = height / 2 - 30;
        addRenderableWidget(Button.builder(Component.translatable("gui.companionmod.follow"),
                b -> send(CompanionCommand.FOLLOW)).bounds(cx - 50, y, 100, 20).build());
        addRenderableWidget(Button.builder(Component.translatable("gui.companionmod.stay"),
                b -> send(CompanionCommand.STAY)).bounds(cx - 50, y + 26, 100, 20).build());
        addRenderableWidget(Button.builder(Component.translatable("gui.companionmod.dismiss"),
                b -> send(CompanionCommand.DISMISS)).bounds(cx - 50, y + 52, 100, 20).build());
    }

    private void send(CompanionCommand command) {
        ModNetwork.CHANNEL.sendToServer(new CommandPacket(entityId, command));
        onClose();
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        renderBackground(g);
        g.drawCenteredString(font, title, width / 2, height / 2 - 50, 0xFFFFFF);
        super.render(g, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

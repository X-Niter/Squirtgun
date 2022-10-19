package net.dirtengineers.squirtgun.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.widget.ExtendedButton;

@OnlyIn(Dist.CLIENT)
public class SquirtgunReloadScreen extends Screen {
    public SquirtgunReloadScreen() {
        super(MutableComponent.create(new TranslatableContents("item.squirtgun.gun_functionality")));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick){
        renderBackground(pPoseStack);
        int blah = this.width;
        int imageWidth = 2000;
        int imageHeight = 1016;
        int displayWidth = imageWidth / 4;
        int displayHeight = imageHeight / 4;
        int leftPos = (this.width - displayWidth) / 2;
        int topPos = (this.height - displayHeight) / 2;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        drawCenteredString(
                pPoseStack,
                Minecraft.getInstance().font,
                MutableComponent.create(new TranslatableContents("item.squirtgun.gun_functionality")).withStyle(ChatFormatting.BOLD),
                width / 2,
                12,
                0xFFFFFF);
        net.minecraftforge.client.gui.widget.ExtendedButton button = new ExtendedButton(200,50, 75, 20, Component.literal("BLAH!"), null);
        button.visible = true;
        button.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }
//    @Override
//    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
//        renderBackground(pPoseStack);
//
//        int imageWidth = 2000;
//        int imageHeight = 1016;
//        int displayWidth = imageWidth / 4;
//        int displayHeight = imageHeight / 4;
//        int leftPos = (this.width - displayWidth) / 2;
//        int topPos = (this.height - displayHeight) / 2;
//
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
//    }
}
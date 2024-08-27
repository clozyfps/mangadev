package net.mcreator.mangadev.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.mangadev.world.inventory.MangaGUIMenu;
import net.mcreator.mangadev.network.MangaGUIButtonMessage;
import net.mcreator.mangadev.MangadevMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MangaGUIScreen extends AbstractContainerScreen<MangaGUIMenu> {
	private final static HashMap<String, Object> guistate = MangaGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_twitter;
	Button button_ssnssl_chapters;
	Button button_ssnssl_writer;
	Button button_ssnssl_characters;

	public MangaGUIScreen(MangaGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mangadev:textures/screens/manga_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_twitter = new PlainTextButton(this.leftPos + -199, this.topPos + -11, 61, 20, Component.translatable("gui.mangadev.manga_gui.button_twitter"), e -> {
		}, this.font);
		guistate.put("button:button_twitter", button_twitter);
		this.addRenderableWidget(button_twitter);
		button_ssnssl_chapters = new PlainTextButton(this.leftPos + -199, this.topPos + 7, 98, 20, Component.translatable("gui.mangadev.manga_gui.button_ssnssl_chapters"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new MangaGUIButtonMessage(1, x, y, z));
				MangaGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnssl_chapters", button_ssnssl_chapters);
		this.addRenderableWidget(button_ssnssl_chapters);
		button_ssnssl_writer = new PlainTextButton(this.leftPos + -199, this.topPos + 25, 87, 20, Component.translatable("gui.mangadev.manga_gui.button_ssnssl_writer"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new MangaGUIButtonMessage(2, x, y, z));
				MangaGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnssl_writer", button_ssnssl_writer);
		this.addRenderableWidget(button_ssnssl_writer);
		button_ssnssl_characters = new PlainTextButton(this.leftPos + -199, this.topPos + 43, 108, 20, Component.translatable("gui.mangadev.manga_gui.button_ssnssl_characters"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new MangaGUIButtonMessage(3, x, y, z));
				MangaGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnssl_characters", button_ssnssl_characters);
		this.addRenderableWidget(button_ssnssl_characters);
	}
}

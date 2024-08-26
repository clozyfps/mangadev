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

import net.mcreator.mangadev.world.inventory.MangaChapterGUIMenu;
import net.mcreator.mangadev.procedures.DisplayRecentRatingProcedure;
import net.mcreator.mangadev.procedures.DisplayRecentChapterProcedure;
import net.mcreator.mangadev.procedures.DisplayChapterViewsProcedure;
import net.mcreator.mangadev.procedures.DisplayChapterNewFansProcedure;
import net.mcreator.mangadev.network.MangaChapterGUIButtonMessage;
import net.mcreator.mangadev.MangadevMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MangaChapterGUIScreen extends AbstractContainerScreen<MangaChapterGUIMenu> {
	private final static HashMap<String, Object> guistate = MangaChapterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ssnssl;

	public MangaChapterGUIScreen(MangaChapterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mangadev:textures/screens/manga_chapter_gui.png");

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
		guiGraphics.drawString(this.font,

				DisplayRecentChapterProcedure.execute(entity), -199, -11, -1, false);
		guiGraphics.drawString(this.font,

				DisplayRecentRatingProcedure.execute(entity), -199, 7, -1, false);
		guiGraphics.drawString(this.font,

				DisplayChapterViewsProcedure.execute(entity), -199, 25, -1, false);
		guiGraphics.drawString(this.font,

				DisplayChapterNewFansProcedure.execute(entity), -199, 43, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_ssnssl = new PlainTextButton(this.leftPos + 179, this.topPos + -29, 51, 20, Component.translatable("gui.mangadev.manga_chapter_gui.button_ssnssl"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new MangaChapterGUIButtonMessage(0, x, y, z));
				MangaChapterGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnssl", button_ssnssl);
		this.addRenderableWidget(button_ssnssl);
	}
}

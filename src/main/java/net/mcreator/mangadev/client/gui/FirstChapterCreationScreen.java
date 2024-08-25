package net.mcreator.mangadev.client.gui;

import org.apache.logging.log4j.core.appender.rolling.action.Action;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.mangadev.world.inventory.FirstChapterCreationMenu;
import net.mcreator.mangadev.procedures.MangaNameDisplayProcedure;
import net.mcreator.mangadev.network.FirstChapterCreationButtonMessage;
import net.mcreator.mangadev.MangadevMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FirstChapterCreationScreen extends AbstractContainerScreen<FirstChapterCreationMenu> {
	private final static HashMap<String, Object> guistate = FirstChapterCreationMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox MangaCreate;
	Checkbox Action;
	Checkbox Romance;
	Checkbox SliceOfLife;
	Checkbox Comedy;
	Checkbox Horror;
	Checkbox ActionSecond;
	Checkbox RomanceSecond;
	Checkbox SliceOfLifeSecond;
	Checkbox ComedySecond;
	Checkbox HorrorSecond;
	Button button_ssnsslyes;

	public FirstChapterCreationScreen(FirstChapterCreationMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mangadev:textures/screens/first_chapter_creation.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		MangaCreate.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (MangaCreate.isFocused())
			return MangaCreate.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		MangaCreate.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String MangaCreateValue = MangaCreate.getValue();
		super.resize(minecraft, width, height);
		MangaCreate.setValue(MangaCreateValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.first_chapter_creation.label_sslyou_can_only_have_1_genre"), -208, -29, -1, false);
		if (MangaNameDisplayProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.first_chapter_creation.label_ssltext_cannot_be_empty"), -64, 43, -65485, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.first_chapter_creation.label_sslsecondary_genre"), 116, -29, -1, false);
	}

	@Override
	public void init() {
		super.init();
		MangaCreate = new EditBox(this.font, this.leftPos + -63, this.topPos + 62, 118, 18, Component.translatable("gui.mangadev.first_chapter_creation.MangaCreate")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.first_chapter_creation.MangaCreate").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.first_chapter_creation.MangaCreate").getString());
				else
					setSuggestion(null);
			}
		};
		MangaCreate.setSuggestion(Component.translatable("gui.mangadev.first_chapter_creation.MangaCreate").getString());
		MangaCreate.setMaxLength(32767);
		guistate.put("text:MangaCreate", MangaCreate);
		this.addWidget(this.MangaCreate);
		button_ssnsslyes = new PlainTextButton(this.leftPos + -10, this.topPos + 88, 61, 20, Component.translatable("gui.mangadev.first_chapter_creation.button_ssnsslyes"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new FirstChapterCreationButtonMessage(0, x, y, z));
				FirstChapterCreationButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnsslyes", button_ssnsslyes);
		this.addRenderableWidget(button_ssnsslyes);
		Action = new Checkbox(this.leftPos + -208, this.topPos + -11, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Action"), false);
		guistate.put("checkbox:Action", Action);
		this.addRenderableWidget(Action);
		Romance = new Checkbox(this.leftPos + -208, this.topPos + 16, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Romance"), false);
		guistate.put("checkbox:Romance", Romance);
		this.addRenderableWidget(Romance);
		SliceOfLife = new Checkbox(this.leftPos + -208, this.topPos + 43, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.SliceOfLife"), false);
		guistate.put("checkbox:SliceOfLife", SliceOfLife);
		this.addRenderableWidget(SliceOfLife);
		Comedy = new Checkbox(this.leftPos + -208, this.topPos + 70, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Comedy"), false);
		guistate.put("checkbox:Comedy", Comedy);
		this.addRenderableWidget(Comedy);
		Horror = new Checkbox(this.leftPos + -208, this.topPos + 97, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Horror"), false);
		guistate.put("checkbox:Horror", Horror);
		this.addRenderableWidget(Horror);
		ActionSecond = new Checkbox(this.leftPos + 116, this.topPos + -11, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.ActionSecond"), false);
		guistate.put("checkbox:ActionSecond", ActionSecond);
		this.addRenderableWidget(ActionSecond);
		RomanceSecond = new Checkbox(this.leftPos + 116, this.topPos + 16, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.RomanceSecond"), false);
		guistate.put("checkbox:RomanceSecond", RomanceSecond);
		this.addRenderableWidget(RomanceSecond);
		SliceOfLifeSecond = new Checkbox(this.leftPos + 116, this.topPos + 43, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.SliceOfLifeSecond"), false);
		guistate.put("checkbox:SliceOfLifeSecond", SliceOfLifeSecond);
		this.addRenderableWidget(SliceOfLifeSecond);
		ComedySecond = new Checkbox(this.leftPos + 116, this.topPos + 70, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.ComedySecond"), false);
		guistate.put("checkbox:ComedySecond", ComedySecond);
		this.addRenderableWidget(ComedySecond);
		HorrorSecond = new Checkbox(this.leftPos + 116, this.topPos + 97, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.HorrorSecond"), false);
		guistate.put("checkbox:HorrorSecond", HorrorSecond);
		this.addRenderableWidget(HorrorSecond);
	}
}

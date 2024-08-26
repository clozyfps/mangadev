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
import net.mcreator.mangadev.procedures.TypeWarningDisplayProcedure;
import net.mcreator.mangadev.procedures.MangaNameDisplayProcedure;
import net.mcreator.mangadev.procedures.GenreWarningDisplayProcedure;
import net.mcreator.mangadev.procedures.ArcNameCreationDisplayProcedure;
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
	EditBox ArcName;
	Checkbox Action;
	Checkbox Romance;
	Checkbox SliceOfLife;
	Checkbox Comedy;
	Checkbox Horror;
	Checkbox Isekai;
	Checkbox BattleShonen;
	Checkbox Shojo;
	Checkbox Seinen;
	Checkbox Sports;
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
		ArcName.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (ArcName.isFocused())
			return ArcName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		MangaCreate.tick();
		ArcName.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String MangaCreateValue = MangaCreate.getValue();
		String ArcNameValue = ArcName.getValue();
		super.resize(minecraft, width, height);
		MangaCreate.setValue(MangaCreateValue);
		ArcName.setValue(ArcNameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				GenreWarningDisplayProcedure.execute(entity), -208, -29, -1, false);
		if (MangaNameDisplayProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.first_chapter_creation.label_ssltext_cannot_be_empty"), -82, 133, -65536, false);
		guiGraphics.drawString(this.font,

				TypeWarningDisplayProcedure.execute(entity), -64, -29, -1, false);
		if (ArcNameCreationDisplayProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.first_chapter_creation.label_ssltext_cannot_be_empty1"), -82, 160, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		MangaCreate = new EditBox(this.font, this.leftPos + -207, this.topPos + 134, 118, 18, Component.translatable("gui.mangadev.first_chapter_creation.MangaCreate")) {
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
		ArcName = new EditBox(this.font, this.leftPos + -207, this.topPos + 161, 118, 18, Component.translatable("gui.mangadev.first_chapter_creation.ArcName")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.first_chapter_creation.ArcName").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.first_chapter_creation.ArcName").getString());
				else
					setSuggestion(null);
			}
		};
		ArcName.setSuggestion(Component.translatable("gui.mangadev.first_chapter_creation.ArcName").getString());
		ArcName.setMaxLength(32767);
		guistate.put("text:ArcName", ArcName);
		this.addWidget(this.ArcName);
		button_ssnsslyes = new PlainTextButton(this.leftPos + -208, this.topPos + 187, 61, 20, Component.translatable("gui.mangadev.first_chapter_creation.button_ssnsslyes"), e -> {
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
		Isekai = new Checkbox(this.leftPos + -64, this.topPos + -11, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Isekai"), false);
		guistate.put("checkbox:Isekai", Isekai);
		this.addRenderableWidget(Isekai);
		BattleShonen = new Checkbox(this.leftPos + -64, this.topPos + 16, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.BattleShonen"), false);
		guistate.put("checkbox:BattleShonen", BattleShonen);
		this.addRenderableWidget(BattleShonen);
		Shojo = new Checkbox(this.leftPos + -64, this.topPos + 43, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Shojo"), false);
		guistate.put("checkbox:Shojo", Shojo);
		this.addRenderableWidget(Shojo);
		Seinen = new Checkbox(this.leftPos + -64, this.topPos + 70, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Seinen"), false);
		guistate.put("checkbox:Seinen", Seinen);
		this.addRenderableWidget(Seinen);
		Sports = new Checkbox(this.leftPos + -64, this.topPos + 97, 20, 20, Component.translatable("gui.mangadev.first_chapter_creation.Sports"), false);
		guistate.put("checkbox:Sports", Sports);
		this.addRenderableWidget(Sports);
	}
}

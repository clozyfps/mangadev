package net.mcreator.mangadev.client.gui;

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

import net.mcreator.mangadev.world.inventory.CharacterGUIMenu;
import net.mcreator.mangadev.procedures.EmptyCharacterWarningProcedure;
import net.mcreator.mangadev.procedures.DisplayCharacterWarningProcedure;
import net.mcreator.mangadev.network.CharacterGUIButtonMessage;
import net.mcreator.mangadev.MangadevMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CharacterGUIScreen extends AbstractContainerScreen<CharacterGUIMenu> {
	private final static HashMap<String, Object> guistate = CharacterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox CharacterName;
	Checkbox Hero;
	Checkbox Villain;
	Checkbox Neutral;
	Button button_empty;
	Button button_ssnssl;

	public CharacterGUIScreen(CharacterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mangadev:textures/screens/character_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		CharacterName.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (CharacterName.isFocused())
			return CharacterName.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		CharacterName.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String CharacterNameValue = CharacterName.getValue();
		super.resize(minecraft, width, height);
		CharacterName.setValue(CharacterNameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (DisplayCharacterWarningProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.character_gui.label_sslcharacter_created"), -55, 52, -13369549, false);
		if (EmptyCharacterWarningProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.character_gui.label_sslcannot_be_empty"), -55, 52, -65485, false);
	}

	@Override
	public void init() {
		super.init();
		CharacterName = new EditBox(this.font, this.leftPos + -63, this.topPos + 71, 118, 18, Component.translatable("gui.mangadev.character_gui.CharacterName")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.character_gui.CharacterName").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.character_gui.CharacterName").getString());
				else
					setSuggestion(null);
			}
		};
		CharacterName.setSuggestion(Component.translatable("gui.mangadev.character_gui.CharacterName").getString());
		CharacterName.setMaxLength(32767);
		guistate.put("text:CharacterName", CharacterName);
		this.addWidget(this.CharacterName);
		button_empty = Button.builder(Component.translatable("gui.mangadev.character_gui.button_empty"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new CharacterGUIButtonMessage(0, x, y, z));
				CharacterGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 62, this.topPos + 70, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_ssnssl = new PlainTextButton(this.leftPos + 179, this.topPos + -29, 51, 20, Component.translatable("gui.mangadev.character_gui.button_ssnssl"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new CharacterGUIButtonMessage(1, x, y, z));
				CharacterGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnssl", button_ssnssl);
		this.addRenderableWidget(button_ssnssl);
		Hero = new Checkbox(this.leftPos + -64, this.topPos + 97, 20, 20, Component.translatable("gui.mangadev.character_gui.Hero"), false);
		guistate.put("checkbox:Hero", Hero);
		this.addRenderableWidget(Hero);
		Villain = new Checkbox(this.leftPos + -64, this.topPos + 124, 20, 20, Component.translatable("gui.mangadev.character_gui.Villain"), false);
		guistate.put("checkbox:Villain", Villain);
		this.addRenderableWidget(Villain);
		Neutral = new Checkbox(this.leftPos + -64, this.topPos + 151, 20, 20, Component.translatable("gui.mangadev.character_gui.Neutral"), false);
		guistate.put("checkbox:Neutral", Neutral);
		this.addRenderableWidget(Neutral);
	}
}

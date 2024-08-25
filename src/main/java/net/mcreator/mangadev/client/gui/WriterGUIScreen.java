package net.mcreator.mangadev.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.mangadev.world.inventory.WriterGUIMenu;
import net.mcreator.mangadev.procedures.DisplaySideCharacterTimerProcedure;
import net.mcreator.mangadev.procedures.DisplayMainEventWarningProcedure;
import net.mcreator.mangadev.procedures.DisplayFocusedCharWarningProcedure;
import net.mcreator.mangadev.network.WriterGUIButtonMessage;
import net.mcreator.mangadev.MangadevMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class WriterGUIScreen extends AbstractContainerScreen<WriterGUIMenu> {
	private final static HashMap<String, Object> guistate = WriterGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox ChapterName;
	EditBox FocusedCharacter;
	EditBox SideCharacter;
	EditBox MainEvent;
	Button button_ssnsslpublish;
	Button button_ssnssl;

	public WriterGUIScreen(WriterGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("mangadev:textures/screens/writer_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		ChapterName.render(guiGraphics, mouseX, mouseY, partialTicks);
		FocusedCharacter.render(guiGraphics, mouseX, mouseY, partialTicks);
		SideCharacter.render(guiGraphics, mouseX, mouseY, partialTicks);
		MainEvent.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -163 && mouseX < leftPos + -139 && mouseY > topPos + 106 && mouseY < topPos + 130)
			guiGraphics.renderTooltip(font, Component.translatable("gui.mangadev.writer_gui.tooltip_a_existing_character"), mouseX, mouseY);
		if (mouseX > leftPos + -127 && mouseX < leftPos + -103 && mouseY > topPos + 106 && mouseY < topPos + 130)
			guiGraphics.renderTooltip(font, Component.translatable("gui.mangadev.writer_gui.tooltip_an_existing_character"), mouseX, mouseY);
		if (mouseX > leftPos + -199 && mouseX < leftPos + -175 && mouseY > topPos + 106 && mouseY < topPos + 130)
			guiGraphics.renderTooltip(font, Component.translatable("gui.mangadev.writer_gui.tooltip_an_existing_character1"), mouseX, mouseY);
		if (mouseX > leftPos + -199 && mouseX < leftPos + -175 && mouseY > topPos + 133 && mouseY < topPos + 157)
			guiGraphics.renderTooltip(font, Component.translatable("gui.mangadev.writer_gui.tooltip_an_existing_character2"), mouseX, mouseY);
		if (mouseX > leftPos + -163 && mouseX < leftPos + -139 && mouseY > topPos + 133 && mouseY < topPos + 157)
			guiGraphics.renderTooltip(font, Component.translatable("gui.mangadev.writer_gui.tooltip_an_existing_character3"), mouseX, mouseY);
		if (mouseX > leftPos + -127 && mouseX < leftPos + -103 && mouseY > topPos + 133 && mouseY < topPos + 157)
			guiGraphics.renderTooltip(font, Component.translatable("gui.mangadev.writer_gui.tooltip_an_existing_character4"), mouseX, mouseY);
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
		if (ChapterName.isFocused())
			return ChapterName.keyPressed(key, b, c);
		if (FocusedCharacter.isFocused())
			return FocusedCharacter.keyPressed(key, b, c);
		if (SideCharacter.isFocused())
			return SideCharacter.keyPressed(key, b, c);
		if (MainEvent.isFocused())
			return MainEvent.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		ChapterName.tick();
		FocusedCharacter.tick();
		SideCharacter.tick();
		MainEvent.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String ChapterNameValue = ChapterName.getValue();
		String FocusedCharacterValue = FocusedCharacter.getValue();
		String SideCharacterValue = SideCharacter.getValue();
		String MainEventValue = MainEvent.getValue();
		super.resize(minecraft, width, height);
		ChapterName.setValue(ChapterNameValue);
		FocusedCharacter.setValue(FocusedCharacterValue);
		SideCharacter.setValue(SideCharacterValue);
		MainEvent.setValue(MainEventValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (DisplayFocusedCharWarningProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.writer_gui.label_sslfocused_character_does_not_exi"), -82, 115, -65485, false);
		if (DisplaySideCharacterTimerProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.writer_gui.label_sslside_character_does_not_exist"), -82, 142, -65485, false);
		if (DisplayMainEventWarningProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.mangadev.writer_gui.label_sslmain_event_cannot_be_empty"), -82, 169, -65485, false);
	}

	@Override
	public void init() {
		super.init();
		ChapterName = new EditBox(this.font, this.leftPos + -63, this.topPos + 71, 118, 18, Component.translatable("gui.mangadev.writer_gui.ChapterName")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.ChapterName").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.ChapterName").getString());
				else
					setSuggestion(null);
			}
		};
		ChapterName.setSuggestion(Component.translatable("gui.mangadev.writer_gui.ChapterName").getString());
		ChapterName.setMaxLength(32767);
		guistate.put("text:ChapterName", ChapterName);
		this.addWidget(this.ChapterName);
		FocusedCharacter = new EditBox(this.font, this.leftPos + -207, this.topPos + 107, 118, 18, Component.translatable("gui.mangadev.writer_gui.FocusedCharacter")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.FocusedCharacter").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.FocusedCharacter").getString());
				else
					setSuggestion(null);
			}
		};
		FocusedCharacter.setSuggestion(Component.translatable("gui.mangadev.writer_gui.FocusedCharacter").getString());
		FocusedCharacter.setMaxLength(32767);
		guistate.put("text:FocusedCharacter", FocusedCharacter);
		this.addWidget(this.FocusedCharacter);
		SideCharacter = new EditBox(this.font, this.leftPos + -207, this.topPos + 134, 118, 18, Component.translatable("gui.mangadev.writer_gui.SideCharacter")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.SideCharacter").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.SideCharacter").getString());
				else
					setSuggestion(null);
			}
		};
		SideCharacter.setSuggestion(Component.translatable("gui.mangadev.writer_gui.SideCharacter").getString());
		SideCharacter.setMaxLength(32767);
		guistate.put("text:SideCharacter", SideCharacter);
		this.addWidget(this.SideCharacter);
		MainEvent = new EditBox(this.font, this.leftPos + -207, this.topPos + 161, 118, 18, Component.translatable("gui.mangadev.writer_gui.MainEvent")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.MainEvent").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.mangadev.writer_gui.MainEvent").getString());
				else
					setSuggestion(null);
			}
		};
		MainEvent.setSuggestion(Component.translatable("gui.mangadev.writer_gui.MainEvent").getString());
		MainEvent.setMaxLength(32767);
		guistate.put("text:MainEvent", MainEvent);
		this.addWidget(this.MainEvent);
		button_ssnsslpublish = new PlainTextButton(this.leftPos + -28, this.topPos + 97, 82, 20, Component.translatable("gui.mangadev.writer_gui.button_ssnsslpublish"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new WriterGUIButtonMessage(0, x, y, z));
				WriterGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnsslpublish", button_ssnsslpublish);
		this.addRenderableWidget(button_ssnsslpublish);
		button_ssnssl = new PlainTextButton(this.leftPos + 179, this.topPos + -29, 51, 20, Component.translatable("gui.mangadev.writer_gui.button_ssnssl"), e -> {
			if (true) {
				MangadevMod.PACKET_HANDLER.sendToServer(new WriterGUIButtonMessage(1, x, y, z));
				WriterGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_ssnssl", button_ssnssl);
		this.addRenderableWidget(button_ssnssl);
	}
}

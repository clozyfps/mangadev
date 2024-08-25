
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mangadev.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.mangadev.client.gui.WriterGUIScreen;
import net.mcreator.mangadev.client.gui.MangaGUIScreen;
import net.mcreator.mangadev.client.gui.MangaChapterGUIScreen;
import net.mcreator.mangadev.client.gui.FirstChapterCreationScreen;
import net.mcreator.mangadev.client.gui.CharacterGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MangadevModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MangadevModMenus.MANGA_GUI.get(), MangaGUIScreen::new);
			MenuScreens.register(MangadevModMenus.MANGA_CHAPTER_GUI.get(), MangaChapterGUIScreen::new);
			MenuScreens.register(MangadevModMenus.FIRST_CHAPTER_CREATION.get(), FirstChapterCreationScreen::new);
			MenuScreens.register(MangadevModMenus.WRITER_GUI.get(), WriterGUIScreen::new);
			MenuScreens.register(MangadevModMenus.CHARACTER_GUI.get(), CharacterGUIScreen::new);
		});
	}
}

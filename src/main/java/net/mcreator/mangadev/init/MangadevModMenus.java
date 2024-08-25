
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mangadev.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.mangadev.world.inventory.WriterGUIMenu;
import net.mcreator.mangadev.world.inventory.MangaGUIMenu;
import net.mcreator.mangadev.world.inventory.MangaChapterGUIMenu;
import net.mcreator.mangadev.world.inventory.FirstChapterCreationMenu;
import net.mcreator.mangadev.world.inventory.CharacterGUIMenu;
import net.mcreator.mangadev.MangadevMod;

public class MangadevModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MangadevMod.MODID);
	public static final RegistryObject<MenuType<MangaGUIMenu>> MANGA_GUI = REGISTRY.register("manga_gui", () -> IForgeMenuType.create(MangaGUIMenu::new));
	public static final RegistryObject<MenuType<MangaChapterGUIMenu>> MANGA_CHAPTER_GUI = REGISTRY.register("manga_chapter_gui", () -> IForgeMenuType.create(MangaChapterGUIMenu::new));
	public static final RegistryObject<MenuType<FirstChapterCreationMenu>> FIRST_CHAPTER_CREATION = REGISTRY.register("first_chapter_creation", () -> IForgeMenuType.create(FirstChapterCreationMenu::new));
	public static final RegistryObject<MenuType<WriterGUIMenu>> WRITER_GUI = REGISTRY.register("writer_gui", () -> IForgeMenuType.create(WriterGUIMenu::new));
	public static final RegistryObject<MenuType<CharacterGUIMenu>> CHARACTER_GUI = REGISTRY.register("character_gui", () -> IForgeMenuType.create(CharacterGUIMenu::new));
}

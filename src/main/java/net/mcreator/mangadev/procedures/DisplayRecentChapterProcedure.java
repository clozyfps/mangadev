package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mangadev.network.MangadevModVariables;

public class DisplayRecentChapterProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7lYour Most Recent Chapter: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentChapter;
	}
}

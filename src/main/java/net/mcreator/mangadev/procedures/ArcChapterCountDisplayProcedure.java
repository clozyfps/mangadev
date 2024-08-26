package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mangadev.network.MangadevModVariables;

public class ArcChapterCountDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Arc Chapters: " + new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CurrentArcChapters);
	}
}

package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mangadev.network.MangadevModVariables;

public class DisplayRecentRatingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7l\u25C6 Chapter Rating: " + new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating) + " Stars";
	}
}

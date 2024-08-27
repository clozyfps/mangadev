package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mangadev.network.MangadevModVariables;

public class DisplayArcRatingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).ArcRating == 0) {
			return "Arc Rating: " + new java.text.DecimalFormat("#").format((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).ArcRating);
		}
		return "Arc Rating: N/A";
	}
}

package net.mcreator.mangadev.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.mangadev.network.MangadevModVariables;

public class DisplayArcNameProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CurrentArc).isEmpty()) {
			return "Current Arc: " + (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CurrentArc;
		}
		return "Current Arc: None";
	}
}

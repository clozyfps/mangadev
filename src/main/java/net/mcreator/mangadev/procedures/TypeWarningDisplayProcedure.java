package net.mcreator.mangadev.procedures;

import net.minecraftforge.eventbus.api.Event;

public class TypeWarningDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getPersistentData().getDouble("typetimer") > 0) {
			return "\u00A7l2 or more types selected!";
		}
		return "\u00A7lType";
	}
}

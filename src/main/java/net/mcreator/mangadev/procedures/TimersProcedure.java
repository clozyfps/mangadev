package net.mcreator.mangadev.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TimersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("genretimer") > 0) {
			entity.getPersistentData().putDouble("genretimer", (entity.getPersistentData().getDouble("genretimer") - 1));
		}
		if (entity.getPersistentData().getDouble("manganametimer") > 0) {
			entity.getPersistentData().putDouble("manganametimer", (entity.getPersistentData().getDouble("manganametimer") - 1));
		}
		if (entity.getPersistentData().getDouble("sidechartimer") > 0) {
			entity.getPersistentData().putDouble("sidechartimer", (entity.getPersistentData().getDouble("sidechartimer") - 1));
		}
		if (entity.getPersistentData().getDouble("focusedchartimer") > 0) {
			entity.getPersistentData().putDouble("focusedchartimer", (entity.getPersistentData().getDouble("focusedchartimer") - 1));
		}
		if (entity.getPersistentData().getDouble("maineventtimer") > 0) {
			entity.getPersistentData().putDouble("maineventtimer", (entity.getPersistentData().getDouble("maineventtimer") - 1));
		}
		if (entity.getPersistentData().getDouble("characternametimer") > 0) {
			entity.getPersistentData().putDouble("characternametimer", (entity.getPersistentData().getDouble("characternametimer") - 1));
		}
		if (entity.getPersistentData().getDouble("characternamebadtimer") > 0) {
			entity.getPersistentData().putDouble("characternamebadtimer", (entity.getPersistentData().getDouble("characternamebadtimer") - 1));
		}
	}
}

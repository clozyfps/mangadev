package net.mcreator.mangadev.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.mangadev.network.MangadevModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PopularityTickProcedure {
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
		if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 100) {
			{
				double _setval = 1;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 100
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 250) {
			{
				double _setval = 2;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 250
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 500) {
			{
				double _setval = 3;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 500
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 1000) {
			{
				double _setval = 4;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 1000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 5000) {
			{
				double _setval = 5;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 5000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 20000) {
			{
				double _setval = 6;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 20000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 50000) {
			{
				double _setval = 7;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 50000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 200000) {
			{
				double _setval = 8;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 200000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 500000) {
			{
				double _setval = 9;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 500000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 1000000) {
			{
				double _setval = 10;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 1000000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 20000000) {
			{
				double _setval = 11;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 20000000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 100000000) {
			{
				double _setval = 12;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 100000000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 250000000) {
			{
				double _setval = 13;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 250000000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 800000000) {
			{
				double _setval = 14;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans >= 800000000
				&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Fans < 1000000000) {
			{
				double _setval = 15;
				entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PopularityGeneration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

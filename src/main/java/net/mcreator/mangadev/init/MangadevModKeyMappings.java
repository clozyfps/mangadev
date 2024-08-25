
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mangadev.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.mangadev.network.MangaMenuMessage;
import net.mcreator.mangadev.MangadevMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MangadevModKeyMappings {
	public static final KeyMapping MANGA_MENU = new KeyMapping("key.mangadev.manga_menu", GLFW.GLFW_KEY_M, "key.categories.manga") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MangadevMod.PACKET_HANDLER.sendToServer(new MangaMenuMessage(0, 0));
				MangaMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MANGA_MENU);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MANGA_MENU.consumeClick();
			}
		}
	}
}

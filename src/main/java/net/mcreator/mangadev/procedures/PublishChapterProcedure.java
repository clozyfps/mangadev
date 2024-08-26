package net.mcreator.mangadev.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.mangadev.world.inventory.MangaChapterGUIMenu;
import net.mcreator.mangadev.network.MangadevModVariables;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class PublishChapterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters)
				.contains(guistate.containsKey("text:FocusedCharacter") ? ((EditBox) guistate.get("text:FocusedCharacter")).getValue() : "")) {
			if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Characters)
					.contains(guistate.containsKey("text:SideCharacter") ? ((EditBox) guistate.get("text:SideCharacter")).getValue() : "")) {
				if (!(guistate.containsKey("text:MainEvent") ? ((EditBox) guistate.get("text:MainEvent")).getValue() : "").isEmpty()) {
					{
						double _setval = 0;
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DiscoveryRate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RecentChapterFans = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RecentChapterViews = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:ChapterName") ? ((EditBox) guistate.get("text:ChapterName")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RecentChapter = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:FocusedCharacter") ? ((EditBox) guistate.get("text:FocusedCharacter")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.FocusedCharacter = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:SideCharacter") ? ((EditBox) guistate.get("text:SideCharacter")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SideCharacter = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:MainEvent") ? ((EditBox) guistate.get("text:MainEvent")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MainEvent = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("MangaChapterGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new MangaChapterGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
					{
						double _setval = Mth.nextInt(RandomSource.create(), 1, 5);
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RecentRating = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Chapters + 1;
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Chapters = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (Math.random() < (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).RecentRating / 15) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("mangadev:viral"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7l\u00A76$ You Went Viral! $"), false);
						if (world.isClientSide())
							Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(Items.EMERALD));
						if (entity instanceof Player _player)
							_player.closeContainer();
					}
				} else {
					entity.getPersistentData().putDouble("maineventtimer", 20);
				}
			} else {
				entity.getPersistentData().putDouble("sidechartimer", 20);
			}
		} else {
			entity.getPersistentData().putDouble("focusedchartimer", 20);
		}
	}
}

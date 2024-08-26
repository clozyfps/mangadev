package net.mcreator.mangadev.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.mcreator.mangadev.world.inventory.MangaGUIMenu;
import net.mcreator.mangadev.network.MangadevModVariables;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class YesClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!((guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "").isEmpty()
				&& (guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "").startsWith(" "))) {
			if (!((guistate.containsKey("text:ArcName") ? ((EditBox) guistate.get("text:ArcName")).getValue() : "").isEmpty() && (guistate.containsKey("text:ArcName") ? ((EditBox) guistate.get("text:ArcName")).getValue() : "").startsWith(" "))) {
				{
					String _setval = guistate.containsKey("text:ArcName") ? ((EditBox) guistate.get("text:ArcName")).getValue() : "";
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentArc = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 1;
					entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ArcRating = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected()
						&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
								|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
					{
						String _setval = "Action";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaGenre = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaName = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1) + ""
									+ ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[1]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("MangaGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if (guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected()
						&& (guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
								|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
					{
						String _setval = "Horror";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaGenre = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaName = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1) + ""
									+ ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[1]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("MangaGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if (guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
						&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected()
								|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
					{
						String _setval = "Slice Of Life";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaGenre = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaName = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1) + ""
									+ ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[1]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("MangaGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if (guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected()
						&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
								|| guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected() || guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected())) {
					{
						String _setval = "Romance";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaGenre = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaName = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1) + ""
									+ ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[1]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("MangaGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if (guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected()
						&& !(guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
								|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected())) {
					{
						String _setval = "Comedy";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaGenre = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = guistate.containsKey("text:MangaCreate") ? ((EditBox) guistate.get("text:MangaCreate")).getValue() : "";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaName = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (!((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName).contains(" ")) {
						{
							String _setval = ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[0]).substring(0, 1) + ""
									+ ((((entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).MangaName)).split(" ")[1]).substring(0, 1);
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ShortMangaName = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("MangaGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new MangaGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if (guistate.containsKey("checkbox:Comedy") && ((Checkbox) guistate.get("checkbox:Comedy")).selected()
						&& (guistate.containsKey("checkbox:Horror") && ((Checkbox) guistate.get("checkbox:Horror")).selected() || guistate.containsKey("checkbox:SliceOfLife") && ((Checkbox) guistate.get("checkbox:SliceOfLife")).selected()
								|| guistate.containsKey("checkbox:Romance") && ((Checkbox) guistate.get("checkbox:Romance")).selected() || guistate.containsKey("checkbox:Action") && ((Checkbox) guistate.get("checkbox:Action")).selected())) {
					entity.getPersistentData().putDouble("genretimer", 20);
				} else {
					entity.getPersistentData().putDouble("genretimer", 20);
				}
				if (guistate.containsKey("checkbox:Isekai") && ((Checkbox) guistate.get("checkbox:Isekai")).selected()
						&& !(guistate.containsKey("checkbox:BattleShonen") && ((Checkbox) guistate.get("checkbox:BattleShonen")).selected() || guistate.containsKey("checkbox:Shojo") && ((Checkbox) guistate.get("checkbox:Shojo")).selected()
								|| guistate.containsKey("checkbox:Seinen") && ((Checkbox) guistate.get("checkbox:Seinen")).selected() || guistate.containsKey("checkbox:Sports") && ((Checkbox) guistate.get("checkbox:Sports")).selected())) {
					{
						String _setval = "Isekai";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaType = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (guistate.containsKey("checkbox:BattleShonen") && ((Checkbox) guistate.get("checkbox:BattleShonen")).selected()
						&& !(guistate.containsKey("checkbox:Isekai") && ((Checkbox) guistate.get("checkbox:Isekai")).selected() || guistate.containsKey("checkbox:Shojo") && ((Checkbox) guistate.get("checkbox:Shojo")).selected()
								|| guistate.containsKey("checkbox:Seinen") && ((Checkbox) guistate.get("checkbox:Seinen")).selected() || guistate.containsKey("checkbox:Sports") && ((Checkbox) guistate.get("checkbox:Sports")).selected())) {
					{
						String _setval = "BattleShonen";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaType = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (guistate.containsKey("checkbox:Shojo") && ((Checkbox) guistate.get("checkbox:Shojo")).selected()
						&& !(guistate.containsKey("checkbox:Isekai") && ((Checkbox) guistate.get("checkbox:Isekai")).selected() || guistate.containsKey("checkbox:BattleShonen") && ((Checkbox) guistate.get("checkbox:BattleShonen")).selected()
								|| guistate.containsKey("checkbox:Seinen") && ((Checkbox) guistate.get("checkbox:Seinen")).selected() || guistate.containsKey("checkbox:Sports") && ((Checkbox) guistate.get("checkbox:Sports")).selected())) {
					{
						String _setval = "Shojo";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaType = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (guistate.containsKey("checkbox:Seinen") && ((Checkbox) guistate.get("checkbox:Seinen")).selected()
						&& !(guistate.containsKey("checkbox:Isekai") && ((Checkbox) guistate.get("checkbox:Isekai")).selected() || guistate.containsKey("checkbox:BattleShonen") && ((Checkbox) guistate.get("checkbox:BattleShonen")).selected()
								|| guistate.containsKey("checkbox:Shojo") && ((Checkbox) guistate.get("checkbox:Shojo")).selected() || guistate.containsKey("checkbox:Sports") && ((Checkbox) guistate.get("checkbox:Sports")).selected())) {
					{
						String _setval = "Seinen";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaType = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (guistate.containsKey("checkbox:Sports") && ((Checkbox) guistate.get("checkbox:Sports")).selected()
						&& !(guistate.containsKey("checkbox:Isekai") && ((Checkbox) guistate.get("checkbox:Isekai")).selected() || guistate.containsKey("checkbox:BattleShonen") && ((Checkbox) guistate.get("checkbox:BattleShonen")).selected()
								|| guistate.containsKey("checkbox:Shojo") && ((Checkbox) guistate.get("checkbox:Shojo")).selected() || guistate.containsKey("checkbox:Seinen") && ((Checkbox) guistate.get("checkbox:Seinen")).selected())) {
					{
						String _setval = "Sports";
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangaType = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (guistate.containsKey("checkbox:Sports") && ((Checkbox) guistate.get("checkbox:Sports")).selected()
						&& (guistate.containsKey("checkbox:Isekai") && ((Checkbox) guistate.get("checkbox:Isekai")).selected() || guistate.containsKey("checkbox:BattleShonen") && ((Checkbox) guistate.get("checkbox:BattleShonen")).selected()
								|| guistate.containsKey("checkbox:Shojo") && ((Checkbox) guistate.get("checkbox:Shojo")).selected() || guistate.containsKey("checkbox:Seinen") && ((Checkbox) guistate.get("checkbox:Seinen")).selected())) {
					entity.getPersistentData().putDouble("typetimer", 20);
				} else {
					entity.getPersistentData().putDouble("typetimer", 20);
				}
			} else {
				entity.getPersistentData().putDouble("arcnametimer", 20);
			}
		} else {
			entity.getPersistentData().putDouble("manganametimer", 20);
		}
	}
}

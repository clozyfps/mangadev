package net.mcreator.mangadev.procedures;

import net.minecraftforge.eventbus.api.Event;

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
						double _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).Chapters + 1;
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Chapters = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CurrentArcChapters + 1;
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.CurrentArcChapters = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = Mth.nextInt(RandomSource.create(), 1, 5);
						entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.RecentRating = _setval;
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
					if (guistate.containsKey("checkbox:EndArc") && ((Checkbox) guistate.get("checkbox:EndArc")).selected()
							&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CurrentArcChapters > 10) {
						{
							boolean _setval = true;
							entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ArcEndChapter = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (guistate.containsKey("checkbox:EndArc") && ((Checkbox) guistate.get("checkbox:EndArc")).selected()
							&& (entity.getCapability(MangadevModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MangadevModVariables.PlayerVariables())).CurrentArcChapters <= 10) {
						entity.getPersistentData().putDouble("arcendbadtimer", 20);
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

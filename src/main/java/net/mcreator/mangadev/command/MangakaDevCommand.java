
package net.mcreator.mangadev.command;

@Mod.EventBusSubscriber
public class MangakaDevCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("manga")

				.then(Commands.literal("fans").then(Commands.argument("name", EntityArgument.player()).then(Commands.argument("fanamount", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();

					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();

					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);

					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					FanSetProcedure.execute(arguments);
					return 0;
				})))));
	}

}

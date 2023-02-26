package tech.williamist.shadowartifacts.aspects.emblems;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import tech.williamist.shadowartifacts.CustomRegistries;

public final class EmblemManagerCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("emblem")
                        .then(CommandManager.literal("list-all")
                                .executes(context -> {
                                    context.getSource().sendMessage(Text.literal("Emblem list:"));

                                    for (Identifier id : CustomRegistries.EMBLEMS.getIds()) {
                                        context.getSource().sendMessage(Text.literal(" - ").append(Text.literal(id.toString())));
                                    }

                                    return 1;
                                })
                        )
        );
    }

}

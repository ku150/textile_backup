package net.szum123321.textile_backup.util;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandUtil {

    public static boolean canUseCommand(CommandSourceStack source, Object commandLevel) {

        if (commandLevel instanceof Boolean) return (Boolean) commandLevel;
        String commandLevelString = commandLevel.toString();
        return switch (commandLevelString)
        {
            case "true"  -> true;
            case "false" -> false;
            case "ops"   -> Commands.LEVEL_GAMEMASTERS.check(source.permissions()); // typical for other cheaty commands
            case "0" ->  Commands.LEVEL_ALL.check(source.permissions());
            case "1" -> Commands.LEVEL_MODERATORS.check(source.permissions());
            case "2" -> Commands.LEVEL_GAMEMASTERS.check(source.permissions());
            case "3" -> Commands.LEVEL_ADMINS.check(source.permissions());
            case "4" -> Commands.LEVEL_OWNERS.check(source.permissions());
            default -> false;
        };
    }

}

package com.fox2code.foxloader.registry;

import com.fox2code.foxloader.network.NetworkPlayer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommandCompat {
    private static final HashMap<String, CommandCompat> commandsMap = new HashMap<>();
    private static final HashMap<String, CommandCompat> clientCommandsMap = new HashMap<>();
    public static final Map<String, CommandCompat> commands = Collections.unmodifiableMap(commandsMap);
    public static final Map<String, CommandCompat> clientCommands = Collections.unmodifiableMap(clientCommandsMap);
    public static final String[] NO_ALIASES = new String[0];

    public static void registerCommand(CommandCompat commandCompat) {
        commandsMap.put(commandCompat.name, commandCompat);
    }

    public static void registerClientCommand(CommandCompat commandCompat) {
        clientCommandsMap.put(commandCompat.name, commandCompat);
    }

    private final String name;
    private final boolean opOnly;
    private final boolean isHidden;
    private final String[] aliases;

    public CommandCompat(String name) {
        this(name, true, false, NO_ALIASES);
    }

    public CommandCompat(String name, boolean opOnly) {
        this(name, opOnly, false, NO_ALIASES);
    }

    public CommandCompat(String name, boolean opOnly, boolean isHidden, String[] aliases) {
        this.name = name;
        this.opOnly = opOnly;
        this.isHidden = isHidden;
        this.aliases = aliases == null ?
                NO_ALIASES : aliases;
    }

    public String getName() {
        return this.name;
    }

    public boolean isOpOnly() {
        return this.opOnly;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public String[] getAliases() {
        return this.aliases;
    }

    public void onExecute(String[] args, NetworkPlayer commandExecutor) {}

    public void printHelpInformation(NetworkPlayer commandExecutor) {

    }

    public String commandSyntax() {
        return this.name;
    }
}

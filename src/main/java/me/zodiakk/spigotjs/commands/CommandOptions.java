package me.zodiakk.spigotjs.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CommandOptions {
    private Map<String, String> options = new HashMap<String, String>();
    private List<String> arguments = new ArrayList<String>();

    public CommandOptions(String[] args, String optstring) {
        parseArguments(args, optstring);
    }

    public boolean hasOption(String option) {
        return options.containsKey(option);
    }

    public String getArgument(int idx) {
        return arguments.get(idx);
    }

    public String getOptionValue(String option) {
        return options.get(option);
    }

    private void parseArguments(String[] args, String optstring) {
        Map<Character, Boolean> options = new HashMap<Character, Boolean>();
        char[] optstringArray = optstring.toCharArray();

        for (int i = 0; i < optstringArray.length; i++) {
            if (i + 1 < optstringArray.length && optstringArray[i + 1] == ':') {
                options.put(optstringArray[i], true);
                i++;
            } else {
                options.put(optstringArray[i], false);
            }
        }
        forEachArgument:
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                char[] currentOpts = args[i].toCharArray();

                for (char opt : currentOpts) {
                    if (opt == '-') {
                        continue;
                    }
                    if (options.containsKey(opt)) {
                        if (options.get(opt)) {
                            this.options.put(Character.toString(opt), args[i + 1]);
                            i++;
                            continue forEachArgument;
                        } else {
                            this.options.put(Character.toString(opt), null);
                        }
                    }
                }
            } else {
                arguments.add(args[i]);
            }
        }
    }

    public int argumentCount() {
        return arguments.size();
    }
}

# SpigotJS

**WARNING:** This is an old, mostly undocumented project. It is however in a working state.

SpigotJS was a proof of concept for running JavaScript plugins on Minecraft. It never made it into a full project, mainly because of the time investment it required and the fact that, in Java 17, the features used by GraalJS (the JavaScript runtime) to run fast were partially removed from the JVM. They are still available, but locked behind multiple command-line arguments, making it unaccessible for most servers.

## About the plugin

SpigotJS has as objective to provide a complete platform for Javascript developers to easily create Spigot plugins.

No need to waste your time creating a full Java plugin, especially if you don't know anything about Java: SpigotJS is simple to use, yet very familiar, and so is Javascript.

SpigotJS uses GraalVM as the Javascript executor, and reproduce a full Javascript Spigot API in order to provide an interface to interact with the server.

## Install the plugin

#### Prerequisites

- Java 8 or higher (Java 11 is recommended).
- Spigot 1.16.x or PaperMC 1.16.x.
  - Note: While SpigotJS may work with other similar server softwares, such as Craftbukkit, it is not recommended.

#### Installation

1. Download SpigotJS from the official Spigot page.
2. Put the SpigotJS JAR file into your plugins directory.
3. Start your server, and add your scripts in the `plugins/SpigotJS/scripts` directory.
4. If you want to edit configuration files, stop the server, then edit the files in the `plugins/SpigotJS` directory

## For developers

### Build the plugin

**WARNING**: If you are not a Java developer, please download SpigotJS from the official Spigot page.
If, however, you want to contribute to SpigotJS, or just get the very latest features, you can build the plugin using Maven: `mvn clean package`. The plugin will be available in the `target` folder.

### Create a Javascript plugin

Here is a very, very simple Javascript plugin:

```js
const SpigotJS = require("spigotjs");

// Set the basic plugin informations ...
SpigotJS.register({
  name: "Test plugin",
  version: "1.0.0",
  author: "Zodiia",
  minecraftVersion: "1.16",
  apiVersion: "1",
  description: "An example plugin!",
});

// ... execute code ...
SpigotJS.on("enable", (server) => {
  server.log("Hello world!");
});

// ... listen to events ...
SpigotJS.on("blockPlace", (event, server) => {
  server.log(event.getBlock().getType());
});

// ... and create a nice command!
SpigotJS.command("/hello", (sender, args) => {
  sender.sendMessage("Hello there, " + sender.getName() + "!");
});
```

For more examples and a full documentation, please refer to the [Documentation](http://gitlab.com/manon.grivot/spigotjs/-/wikis/home)

### Implement SpigotJS into your plugin

This section is still under development. Please come back later!

Currently, you can get the SpigotJS API by using `SpigotJsApi.getInstance()`.

## License

Unknown

## Contact

Manon Grivot • Spigot: [Zodiak](https://www.spigotmc.org/members/zodiak.495642/) • Discord: zodiia • [hey@zodiia.moe](mailto:hey@zodiia.moe)

## Credits

Oracle Corporation • [GraalVM Community Edition](https://www.graalvm.org) • Released under GPLv2 license

tchristofferson • [YAML Config Updater](https://github.com/tchristofferson/Config-Updater) • No license
(thank you for helping my laziness :))

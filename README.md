
<div align="center" style="text-size: 24px;">
  <h1>SpigotJS</h1>
  SpigotJS aims at providing a Javascript plugins platform for Spigot.
  <br />
  <a href="http://gitlab.com/mael.grivot/spigotjs/-/wikis/home"><strong>Read the full documentation here ➜</strong></a>
  <br />
  <br />
  <a href="https://www.spigotmc.org/resources/spigotjs/">Spigot page</a>
  •
  <a href="https://gitlab.com/mael.grivot/spigotjs/-/issues">Issues</a>
  •
  <a href="https://gitlab.com/mael.grivot/spigotjs/-/issues">Request a feature</a>
</div>

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
  name: 'Test plugin',
  version: '1.0.0',
  author: 'Zodiak',
  minecraftVersion: '1.16',
  apiVersion: '1',
  description: 'An example plugin!'
});

// ... execute code ...
SpigotJS.on('enable', (server) => {
  server.log('Hello world!');
});

// ... listen to events ...
SpigotJS.on('blockPlace', (event, server) => {
  server.log(event.getBlock().getType());
});

// ... and create a nice command!
SpigotJS.command('/hello', (sender, args) => {
  sender.sendMessage('Hello there, ' + sender.getName() + '!');
});
```

For more examples and a full documentation, please refer to the [Documentation](http://gitlab.com/mael.grivot/spigotjs/-/wikis/home)

### Implement SpigotJS into your plugin

This section is still under development. Please come back later!

Currently, you can get the SpigotJS API by using `SpigotJsApi.getInstance()`.

## License

Unknown

## Contact

Maël Grivot • Spigot: [Zodiak](https://www.spigotmc.org/members/zodiak.495642/) • [@ZodiakSNW](http://twitter.com/ZodiakSNW) • [mael.grivot@epitech.eu](mailto:mael.grivot@epitech.eu)

## Credits

Oracle Corporation • [GraalVM Community Edition](https://www.graalvm.org) • Released under GPLv2 license

tchristofferson • [YAML Config Updater](https://github.com/tchristofferson/Config-Updater) • No license
(thank you for helping my laziness :))

# SpigotJS

Create and execute Javascript plugins in Spigot.

This place is still under construction! Come back later to get more informations about this project :)

## Creating a Javascript plugin

Here is a very, very simple Javascript plugin:

```js
const SpigotJS = require("spigotjs");

// Set the basic plugin informations ...
SpigotJS.register({
  name: 'Test plugin',
  version: '1.0.0',
  author: 'Zodiak',
  minecraft_version: '1.16'
});

// ... execute code ...
SpigotJS.on('enable', (server) => {
  server.log('Hello world!');
});

// ... and create a nice command!
SpigotJS.command('/hello', (sender, args) => {
  sender.sendMessage('Hello there, ' + sender.getName() + '!');
});
```

## Implementing SpigotJS into your plugin

```java
// Get the SpigotJS API instance
SpigotJsApi.getInstance();
```

<img src="languify.png">

## Beta 1.1
![GitHub Repo stars](https://img.shields.io/github/stars/Hekates/Languify?style=for-the-badge)
![GitHub](https://img.shields.io/github/license/Hekates/Languify?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/Hekates/Languify?style=for-the-badge)
![Minecraft version](https://img.shields.io/badge/Minecraft-1.18.2+-brightgreen?style=for-the-badge)
![Maintenance](https://img.shields.io/maintenance/yes/2022?style=for-the-badge)

A Java library wich brings support for multiple languages to a Spigot plugin.

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#support">Support</a></li>
    <li><a href="#implementation">Implementation</a></li>
    <li><a href="#usage">How to start</a></li>
    </li>
  </ol>
</details>

<h2 name="support">Support</h2>

* Please ask anything about the plugin [here](https://github.com/Hekates/Languify/discussions/categories/q-a).
* Always feel free to cantact me on discord: Hekates#2298.
* Or contact me on twitter: [@Hekates2](https://twitter.com/Hekates2).

<h2 name="implementation">Implementation</h2>
<h3>Maven</h3>

Step 1. Add the JitPack repository to your build file
<h4>Repository</h4>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency
<h4>Dependency</h4>

```xml
<dependency>
     <groupId>com.github.Hekates</groupId>
     <artifactId>Languify</artifactId>
     <version>v1.0-beta</version>
</dependency>
```

<h3>Gradle</h3>
Step 1. Add the JitPack repository to your build file
<h4>Repository</h4>
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```groovy
dependencies {
    implementation 'com.github.Hekates:Languify:v1.0-beta'
}
```
<h2 name="usage">How to start</h2>
<b>After <a href="#implementation">implementing<a> the library you have to do following things:</b>
<ol>
  <li>Add following code to your Main class:
  
  ```java
  package ch.hekates.example;

import ch.hekates.languify.Languify;
import ch.hekates.languify.language.LangLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Setting up Languify (necessary)
        String language = "en";
        Languify.setup(this, this.getDataFolder().toString());
        LangLoader.loadLanguage(language);
    }
}

  ```
  
  </li>
  <li>Create a folder called "lang" inside your source folder:<br>
  <img src="https://i.imgur.com/rHqW0wH.png" width="450px">
  </li>
  <li>Create a new file inside the "lang" folder named with the language you specified with the LangLoader#loadLanguage() method and the .json ending for example "en.json". <br>
  The language.json file must contain following line:
  
  ```json
  {
  "language" : "English"
  }
  ```
  
  "English" should be replaced with the name of your language.
  </li>
  <li>To add an new text to your plugin, add the path to the json file followed by the text that should be used instead. To use the newly set text simply use the Text#get() method with your path as an input.<br>
  Example:
  <b>en.json <br><img src="https://i.imgur.com/Fgs5AO7.png" width="600px"><br>
  Main.java <br><img src="https://i.imgur.com/44ar8PF.png" width="600px">
</ol>

The JavaDocs for this project can be found <a href="https://hekates.github.io/projects/Languify/JavaDocs/Beta-1.1/">here</a>. 
If there are any questions left or if something doesn't work, please create an issue.

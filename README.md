![](https://raw.githubusercontent.com/Hekates/Languify/main/languify.png)

# Beta 1.2
![GitHub Repo stars](https://img.shields.io/github/stars/Hekates/Languify?style=for-the-badge)
![GitHub](https://img.shields.io/github/license/Hekates/Languify?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/Hekates/Languify?style=for-the-badge)
![Minecraft version](https://img.shields.io/badge/Minecraft-1.18.2+-brightgreen?style=for-the-badge)
![Maintenance](https://img.shields.io/maintenance/yes/2022?style=for-the-badge)

A Java library wich brings support for multiple languages to a Spigot plugin.

## Support

- Please ask anything about the plugin [here](https://github.com/Hekates/Languify/discussions/categories/q-a).
- Always feel free to contact me on discord: [@hekates](https://discord.com/users/Hekates#2298)
- Or contact me on X (twitter): [@Hekates2](https://twitter.com/Hekates2)

## Implementation

### Maven
Step 1. Add the JitPack repository to your build file:
#### Repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency:
#### Dependency
```xml
<dependency>
     <groupId>com.github.Hekates</groupId>
     <artifactId>Languify</artifactId>
     <version>v1.2-beta</version>
</dependency>
```

### Gradle
Step 1. Add the JitPack repository to your build file

Append this to the end of the repositories in your build.gradle file:
#### Repository
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:
#### Dependency
```groovy
dependencies {
    implementation 'com.github.Hekates:Languify:v1.2-beta'
}
```

### Old fashioned way
Of course it is also possible to install the library via downloading and implementing the jar using your IDE.
The download to the jar binaries can be found  <a href="https://github.com/Hekates/Languify/releases" target="_blank">here</a>.

## Quick start
After [implementing](https://github.com/Hekates/Languify/tree/main#implementation) the library the next steps are as following:
#### Add this to your Main class:
```java
package ch.hekates.example;  
  
import ch.hekates.languify.Languify;  
import ch.hekates.languify.language.LangLoader;  
import ch.hekates.languify.language.Text;  
import org.bukkit.plugin.java.JavaPlugin;  
  
public final class Main extends JavaPlugin {  
  
    @Override  
    public void onEnable() {
	    //Setting up Languify (necessary)
        Languify.setup(this, this.getDataFolder().toString());  
        LangLoader.saveLanguages("PluginName"); // Plugin name specified in the plugin.yml
        Languify.setLanguage("en")
    }
}
```

#### Create a folder called "lang" inside your resources folder in which you add a new json file named after the language you specified with [Languify#setLanguage(String)](https://hekates.github.io/projects/Languify/JavaDocs/Beta-1.2/ch/hekates/languify/Languify.html#setLanguage(java.lang.String)) in your Main class:
```
. 
└── src/ 
	└── main/ 
		├── java/ 
		└── resources/ 
			└── lang/
				└── en.json
```

The {language}.json file **must** contain following line:
```json
{
	"language": "English"
}
```
*Of course you replace "English" with the name of your language.*

#### To add and use new text in your plugin, add the key to the end of your json file followed by the text that should be displayed instead. To use the newly set text simply use the [Text#get()](https://hekates.github.io/projects/Languify/JavaDocs/Beta-1.2/ch/hekates/languify/language/Text.html#get(java.lang.String)) method with the key as the input.

### Example

#### en.json
```json
{  
	"language": "English",  
	"test-message": "Hello World"  
}
```

#### Main.java
```java
package ch.hekates.example;  
  
import ch.hekates.languify.Languify;  
import ch.hekates.languify.language.LangLoader;  
import ch.hekates.languify.language.Text;  
import org.bukkit.plugin.java.JavaPlugin;  
  
import java.util.logging.Logger;  
  
public final class Main extends JavaPlugin {  
  
    @Override  
    public void onEnable() {  
        Logger log = this.getLogger();  
  
        Languify.setup(this, this.getDataFolder().toString());  
        LangLoader.saveLanguages("ExamplePlugin");  
        Languify.setLanguage("en");  
  
        log.info(Text.get("test-message"));  
    }}
```

*The JavaDocs for this project can be found <a href="https://hekates.github.io/projects/Languify/JavaDocs/Beta-1.2/" target="_blank">here</a>. 
If there are any questions left or if something doesn't work, please create an issue.*
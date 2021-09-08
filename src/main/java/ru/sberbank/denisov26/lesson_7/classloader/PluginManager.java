package ru.sberbank.denisov26.lesson_7.classloader;

//PluginManager ищет скомпилированные классы плагина в папке pluginRootDirectory\pluginName\
//
//Усложненная версия задания. Система должна вести себя корректно если в плагине,
// есть скомпилированные классы с именем, которые есть в вашем браузере(не в плагинах),
// должны использоваться классы плагина, а не вашего браузера. Для этого придется поменять модель
// делегирования класслоадера в методе loadClass

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        //todo
        return new Plugin() {
            @Override
            public void doUsefull() {

            }
        };
    }

}

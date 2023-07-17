rootProject.name = "Vanguard-Client"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if(requested.id.toString() == "com.mark.bootstrap.bootstrap")
                useModule("com.github.Mark7625:bootstrap-release:63065322f4")
        }
    }
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}
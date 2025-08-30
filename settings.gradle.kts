rootProject.name = "kotlin-liquibase"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://open-reliquary.nyc3.digitaloceanspaces.com")
        }
    }
}
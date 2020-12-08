buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("gradle.plugin.io.quarkus:quarkus-gradle-plugin:1.10.2.Final")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "io.quarkus")

    dependencies {
        val implementation by configurations

        implementation(platform("io.quarkus:quarkus-bom:1.10.2.Final"))
        implementation(kotlin("stdlib"))
        implementation("io.quarkus:quarkus-kotlin")
    }
}
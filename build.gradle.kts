buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
//        classpath("gradle.plugin.io.quarkus:quarkus-gradle-plugin:1.10.2.Final")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
//    apply(plugin = "io.quarkus")

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
        val implementation by configurations

        implementation(platform("io.quarkus:quarkus-bom:1.10.2.Final"))
        implementation(kotlin("stdlib"))
        implementation(kotlin("stdlib-jdk8"))
        implementation("io.quarkus:quarkus-kotlin")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
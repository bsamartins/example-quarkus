plugins {
    id("io.quarkus") version "1.10.2.Final"
}

dependencies {
    implementation("io.helidon.integrations.db:ojdbc:2.1.0")
    implementation("io.quarkus:quarkus-agroal")
}

tasks.register<io.quarkus.gradle.tasks.QuarkusBuild>("quarkusBuildNative") {
    System.setProperty("quarkus.package.type", "native")
}
plugins {
    kotlin("jvm") version "1.8.21"
    id("maven-publish")
    id("net.linguica.maven-settings") version "0.5"
}

group = "org.yashkov.cafs"

repositories {
    mavenCentral()
    maven {
        name = "yashkov"
        url = uri("https://repo.dev.yashkov.org/repository/maven-yashkov/")
    }
}

publishing {
    repositories {
        maven {
            name = "yashkov"
            url = uri(
                if (version.toString().endsWith("-SNAPSHOT"))
                    "https://repo.dev.yashkov.org/repository/maven-snapshots/"
                else
                    "https://repo.dev.yashkov.org/repository/maven-releases/"
            )
        }
    }
    publications {
        create<MavenPublication>("java") {
            from(components["java"])
        }
    }
}

kotlin {
    jvmToolchain(11)
}

plugins {
    kotlin("jvm") version "1.8.21"
//    id("maven-publish")
//    id("net.linguica.maven-settings") version "0.5"
}

group = "org.yashkov.cafs"

repositories {
    mavenCentral()
//    maven {
//        name = "yashkov"
//        url = uri("https://repo.dev.yashkov.org/repository/maven-yashkov/")
//    }
}

//publishing {
//    repositories {
//        maven {
//            name = "yashkov"
//            url = uri(
//                if (version.toString().endsWith("-SNAPSHOT"))
//                    "https://repo.dev.yashkov.org/repository/maven-snapshots/"
//                else
//                    "https://repo.dev.yashkov.org/repository/maven-releases/"
//            )
//        }
//    }
//    publications {
//        create<MavenPublication>("java") {
//            from(components["java"])
//        }
//    }
//}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}

kotlin {
    jvmToolchain(11)
}

tasks {
    test {
        useJUnitPlatform()
    }
}

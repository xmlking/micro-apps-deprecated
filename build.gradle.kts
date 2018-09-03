import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    val kotlinVersion = "1.2.61"
    val springDependencyManagement = "1.0.6.RELEASE"
    val springBootVersion = "2.0.4.RELEASE"
    val shadowPluginVersion = "2.0.4"
    val jibPluginVersion = "0.9.10"

    base
    java
    kotlin("jvm") version kotlinVersion apply false
    kotlin("kapt") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.noarg") version kotlinVersion apply false
    id("org.springframework.boot") version springBootVersion apply false
    id("io.spring.dependency-management") version springDependencyManagement apply false
    id("com.github.johnrengelman.shadow") version shadowPluginVersion apply false
    id("com.google.cloud.tools.jib") version jibPluginVersion apply false
}

allprojects {
    repositories {
        jcenter()
//        mavenCentral()
    }
}

subprojects {
    plugins.withId("application") {
        project.apply { plugin("com.google.cloud.tools.jib") }
    }

    plugins.withId("kotlin") {
        dependencies {
            compile(kotlin("stdlib-jdk8"))
            compile(kotlin("reflect"))
        }
    }
//    plugins.withType<ApplicationPlugin>().whenObjectAdded {
//        println("ApplicationPlugin $name")
//        project.apply { plugin("com.google.cloud.tools.jib") }
//    }

    plugins.withType(JavaPlugin::class.java).whenPluginAdded {
//         plugins.apply "com.google.cloud.tools.jib"
//        sourceCompatibility = 1.8
//        configurations {
//            this.create("provided", {
//                extendsFrom(configurations.compileOnly)
//            })
//        }
    }



//    plugins.withType(JUnitPlatformPlugin).whenPluginAdded {
//        junitPlatform {
//            platformVersion junitPlatformVersion
//                    enableStandardTestTask = true
//        }
//
//        dependencies {
//            testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: jupiterVersion
//            testRuntime group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: jupiterVersion
//        }
//    }

    tasks {
        withType<KotlinCompile>().all {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xjsr305=strict")
                //Will retain parameter names for Java reflection
                javaParameters = true
            }
        }
    }
}


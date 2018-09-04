import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    val kotlinVersion = "1.2.61"
    val springDependencyManagement = "1.0.6.RELEASE"
    val springBootVersion = "2.0.4.RELEASE"
    val shadowPluginVersion = "2.0.4"
    val jibPluginVersion = "0.9.10"

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
    }
}

subprojects {
    plugins.withId("application") {
        project.apply { plugin("com.google.cloud.tools.jib") }
    }

    plugins.withId("org.springframework.boot") {
//        println("module $name has org.springframework.boot plugin")
        project.apply { plugin("com.google.cloud.tools.jib") }
    }

    plugins.withId("kotlin") {
        dependencies {
            compile(kotlin("stdlib-jdk8"))
            compile(kotlin("reflect"))
        }
    }

    plugins.withType(JavaPlugin::class.java).whenPluginAdded {
        java {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

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


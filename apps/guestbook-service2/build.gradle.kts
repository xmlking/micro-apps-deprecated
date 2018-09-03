import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.springframework.boot.gradle.dsl.SpringBootExtension

plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
    id("com.github.johnrengelman.shadow")
    id("io.spring.dependency-management")
}


dependencies {
    // local libs modules
    compile(project(":libs:core"))
    compile(project(":libs:shared"))

    compile("io.micronaut:http-client")
    compile("io.micronaut.configuration:mongo-reactive")
    compile("io.micronaut.configuration:micrometer-core")
    compile("io.micronaut.configuration:micrometer-registry-prometheus")
    compile("io.micronaut.configuration:kafka-streams")
    compile("io.micronaut:http-server-netty")

    compile("io.micronaut:runtime")
    compile("io.micronaut:tracing")
    compile("io.micronaut:management")
    compile("io.micronaut.configuration:kafka")
    kapt("io.micronaut:inject-java")
    kaptTest("io.micronaut:inject-java")
    runtime("ch.qos.logback:logback-classic:1.2.3")
    runtime("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.4.1")
    runtime("io.jaegertracing:jaeger-core:0.27.0")
    testCompile("de.flapdoodle.embed:de.flapdoodle.embed.mongo:2.0.1")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testCompile("org.jetbrains.spek:spek-api:1.1.5")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testRuntime("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
}


configure<DependencyManagementExtension> {
    val micronautVersion = "1.0.0.M4"

    imports {
        mavenBom("io.micronaut:bom:$micronautVersion")
    }
}


val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

jib {
    to {
        image = "xmlking/micro-apps-guestbook-service2:${project.version}"
    }
}

tasks.withType<ShadowJar> {
    mergeServiceFiles()
}

application {
    mainClassName = "micro.apps.guestbook.GuestbookApp"
    applicationDefaultJvmArgs = listOf(
        "-noverify", "-XX:TieredStopAtLevel=1")
}



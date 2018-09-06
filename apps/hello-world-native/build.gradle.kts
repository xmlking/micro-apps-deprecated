import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.springframework.boot.gradle.dsl.SpringBootExtension

val junitVersion: String by project
val graalVMVersion: String by project
val logbackVersion: String by project

plugins {
    application
    id("com.github.johnrengelman.shadow")
    id("io.spring.dependency-management")
    id("net.ltgt.apt-eclipse")
    id("net.ltgt.apt-idea")
}

repositories {
    mavenLocal()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

configure<DependencyManagementExtension> {
    val micronautVersion = "1.0.0.BUILD-SNAPSHOT"

    imports {
        mavenBom("io.micronaut:bom:$micronautVersion")
    }
}

dependencies {
    // local libs modules
    compile(project(":libs:core"))

    // Micronaut
    compile("io.micronaut:http-client")
    compile("io.micronaut:http-server-netty")
    compile("io.micronaut:inject")
    compile("io.micronaut:runtime")
    annotationProcessor("io.micronaut:inject-java")
    compileOnly("io.micronaut:inject-java")
    testCompile("io.micronaut:inject-java")
    runtime("ch.qos.logback:logback-classic:$logbackVersion")

    // GraalVM
    compileOnly("com.oracle.substratevm:svm:$graalVMVersion")
    runtimeOnly("io.micronaut:graal")

    // Testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform {
    }
}

jib {
    to {
        image = "xmlking/${rootProject.name}-${project.name}:${project.version}"
        // image = "gcr.io/${gcloudProject}/${project.name}:${project.version}"
    }
}

tasks.withType<ShadowJar> {
    mergeServiceFiles()
}

application {
    mainClassName = "micro.apps.nativee.NativeApp"
    applicationDefaultJvmArgs = listOf(
        "-noverify", "-XX:TieredStopAtLevel=1")
}



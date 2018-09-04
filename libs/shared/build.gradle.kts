import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

val springBootVersion: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.noarg")
    id("io.spring.dependency-management")
}

configure<DependencyManagementExtension> {
    val springBootVersion = "2.0.4.RELEASE"

    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
    }
}

dependencies {
    compile("org.springframework:spring-context")

    // Testing
    testCompile("io.projectreactor:reactor-test")
    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform {
    }
}

noArg {
    annotation("micro.apps.shared.NoArg")
}

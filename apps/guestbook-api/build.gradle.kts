import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.springframework.boot.gradle.dsl.SpringBootExtension

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.noarg")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    // local libs modules
    compile(project(":libs:guestbook"))

    // Spring
    compile("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    compile("org.springframework.boot:spring-boot-starter-webflux")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Testing
    testCompile("io.projectreactor:reactor-test")
    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // Tooling
    compileOnly("org.springframework:spring-context-indexer")
    compile("org.springframework.boot:spring-boot-devtools")
    compile("org.springframework.boot:spring-boot-starter-actuator")
    compile("io.micrometer:micrometer-registry-prometheus")
    compile("org.springframework.cloud:spring-cloud-starter-sleuth")
    compile("org.springframework.cloud:spring-cloud-starter-zipkin")

    compileOnly("org.springframework.boot:spring-boot-configuration-processor")
}

configure<DependencyManagementExtension> {
    val springCloudVersion: String = "Finchley.RELEASE"
    val springCloudStreamVersion = "Fishtown.M2"

    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
//        mavenBom("org.springframework.cloud:spring-cloud-stream-dependencies:$springCloudStreamVersion")
    }
}


val test by tasks.getting(Test::class) {
    useJUnitPlatform {
        includeTags ("fast", "smoke")
        excludeTags ("slow", "ci")
        includeEngines ("junit-jupiter")
        excludeEngines ("junit-vintage")
    }
    failFast = true
    testLogging {
        events ("passed", "skipped", "failed")
    }
}

jib {
    to {
        image = "xmlking/${rootProject.name}-${project.name}:${project.version}"
        // image = "gcr.io/${gcloudProject}/${project.name}:${project.version}"
    }
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

configure<SpringBootExtension> {
    buildInfo()
}

noArg {
    annotation("micro.apps.shared.NoArg")
}

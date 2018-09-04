import org.jetbrains.kotlin.gradle.dsl.Coroutines

plugins {
    application
    kotlin("jvm")
}

application {
    mainClassName = "micro.apps.cli.CliAppKt"
}

dependencies {
    compile(project(":libs:core"))

    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}


kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

jib {
    to {
        image = "xmlking/${rootProject.name}-${project.name}:${project.version}"
        // image = "gcr.io/${gcloudProject}/${project.name}:${project.version}"
    }
}

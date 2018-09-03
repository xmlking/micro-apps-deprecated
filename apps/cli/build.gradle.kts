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
    compile(project(":libs:shared"))

    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}


kotlin {
    experimental.coroutines = Coroutines.ENABLE
}

jib {
    to {
        image = "xmlking/micro-apps-cli:${project.version}"
    }
}

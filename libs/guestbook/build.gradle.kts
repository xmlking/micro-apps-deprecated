plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.noarg")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}


dependencies {
    compile("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}

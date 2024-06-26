rootProject.name = "2023-12-otus-java-Kretsev"
include("hw01-gradle")
include("hw02-logging")
include("hw03-qa")
include("hw04-generics")
include("hw05-collections")
include("hw06-annotations")
include("hw07-lombok")
include("hw08-gc:demo")
include("hw08-gc:homework")
include("hw09-docker")
include("hw10-byteCodes")
include("hw11-Java8")
include("hw12-solid")
include("hw13-creationalPatterns")
include("hw14-behavioralPatterns")
include("hw15-structuralPatterns:demo")
include("hw15-structuralPatterns:homework")
include("hw16-io:demo")
include("hw16-io:homework")
include("hw17-nio")
include("hw18-jdbc:demo")
include("hw18-jdbc:homework")

pluginManagement {
    val jgitver: String by settings
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val johnrengelmanShadow: String by settings
    val jib: String by settings
    val protobufVer: String by settings
    val sonarlint: String by settings
    val spotless: String by settings
    val freeFair: String by settings

    plugins {
        id("fr.brouillard.oss.gradle.jgitver") version jgitver
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
        id("com.google.cloud.tools.jib") version jib
        id("com.google.protobuf") version protobufVer
        id("name.remal.sonarlint") version sonarlint
        id("com.diffplug.spotless") version spotless
        id ("io.freefair.lombok") version freeFair
    }
}

plugins {
    id ("java")
    id("java-library")
    id("io.qameta.allure") version "2.9.6"
    id("io.freefair.lombok") version "6.3.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.platform:junit-platform-launcher:1.8.2")
    implementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    implementation("io.qameta.allure:allure-junit5:2.16.1")
    implementation("io.qameta.allure:allure-assertj:2.16.1")
    runtimeOnly("org.aspectj:aspectjweaver:1.9.19")
    implementation("com.google.guava:guava:32.1.2-jre")
    implementation("com.codeborne:selenide:7.3.2")
    implementation("io.qameta.allure:allure-selenide:2.27.0")
    implementation("org.aeonbits.owner:owner:1.0.12")

}


tasks.getByName<Test>("test") {
    useJUnitPlatform()
    systemProperty("allure.results.directory", "$rootDir/allure-results")
    systemProperties["file.encoding"] = "UTF-8"
}

tasks.register<Test>("runUITests") {
    useJUnitPlatform(){
    }
    systemProperty("allure.results.directory", "$rootDir/allure-results")
    systemProperties["file.encoding"] = "UTF-8"
}
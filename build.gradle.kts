plugins {
    `java-library`
    id("io.qameta.allure") version "2.12.0"
}

repositories {
    mavenCentral()
}

allure {
    report {
        version.set("2.32.0")
    }
    adapter { // отвечает за появление папочки build/allure-results
        aspectjWeaver.set(true) // обработка аннотации @Step
        frameworks {
            junit5 { // название фреймворка
                adapterVersion.set("2.32.0") // версия интеграции фреймворка и Allure
            }
        }
    }
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("com.codeborne:selenide:6.19.1")
    implementation("net.datafaker:datafaker:2.7.0")
    testImplementation("org.aeonbits.owner:owner:1.0.12")
    testImplementation("io.qameta.allure:allure-selenide:2.32.0")
    testImplementation("net.datafaker:datafaker:2.7.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
    ignoreFailures = true

    testLogging {
        lifecycle {
            events("started", "skipped", "failed", "standard_error", "standard_out")
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
        }
    }
}
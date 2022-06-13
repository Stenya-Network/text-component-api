plugins {
    id("java")
}

group = "net.stenya.cacheoverflow"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    implementation("org.fusesource.jansi:jansi:2.4.0")
    implementation("org.jetbrains:annotations:23.0.0")
    implementation("com.google.code.gson:gson:2.9.0")
}

tasks.getByName<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
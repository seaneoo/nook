plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.serialization)
}

group = "dev.seano"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.slf4j.simple)
	implementation(libs.kotlinx.serialization.json)
	implementation(libs.kord.core)
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}

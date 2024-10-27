plugins {
	alias(libs.plugins.kotlin.jvm)
}

group = "dev.seano"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.slf4j.simple)
	implementation(libs.kord.core)
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}

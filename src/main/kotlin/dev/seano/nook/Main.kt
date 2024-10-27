package dev.seano.nook

import dev.kord.core.Kord
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.serialization.json.Json

private val logger = KotlinLogging.logger { }

fun readBirthdays(): List<Birthday> {
	val inputStream =
		object {}.javaClass.getResourceAsStream("/birthdays.json") ?: throw IllegalArgumentException("file not found")
	val content = inputStream.bufferedReader().use { it.readText() }
	return Json.decodeFromString<List<Birthday>>(content)
}

suspend fun main() {
	val birthdays = readBirthdays()
	if (birthdays.isEmpty()) throw RuntimeException("no birthdays")

	logger.info { "found ${birthdays.size} birthdays" }

	val kord = Kord(System.getenv("DISCORD_BOT_TOKEN"))

	kord.login {
		logger.info { "logging in" }
	}
}

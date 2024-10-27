package dev.seano.nook

import dev.kord.core.Kord
import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger { }

suspend fun main() {
	val kord = Kord(System.getenv("DISCORD_BOT_TOKEN"))

	kord.login {
		logger.info { "logging in" }
	}
}

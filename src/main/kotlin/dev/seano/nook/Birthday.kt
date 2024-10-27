package dev.seano.nook

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Birthday(
	val id: Int,
	val name: String,
	@Serializable(with = BirthdaySerializer::class) val birthday: LocalDate,
	val image: String,
)

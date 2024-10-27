package dev.seano.nook

import kotlinx.datetime.LocalDate
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object BirthdaySerializer : KSerializer<LocalDate> {

	@OptIn(FormatStringsInDatetimeFormats::class)
	private val dateTimeFormat = LocalDate.Format { byUnicodePattern("dd-MM-yyyy") }

	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): LocalDate {
		val dateString = decoder.decodeString()
		return LocalDate.parse(dateString, dateTimeFormat)
	}

	override fun serialize(encoder: Encoder, value: LocalDate) {
		encoder.encodeString(dateTimeFormat.format(value))
	}
}

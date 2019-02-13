package aero.geosystems

import java.math.BigInteger
import java.util.*

/*
 * Created by aimozg on 12.02.2019.
 * Confidential unless published on GitHub
 */
fun <T> T.formatAs(fmt: String): String = fmt.format(Locale.ENGLISH, this)

fun ByteArray.toHexString(): String = if (size == 0) "" else
		("%0${size * 2}X".format(BigInteger(1, this)))
fun <T> Iterable<T>.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...") =
		joinToString(separator, prefix, postfix, limit, truncated) { format.format(Locale.ENGLISH, it) }

inline fun <T> Iterable<T>.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((T) -> Any?)) =
		map { transform(it).formatAs(format) }.joinToString(separator, prefix, postfix, limit, truncated)

fun IntArray.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...") =
		joinToString(separator, prefix, postfix, limit, truncated) { format.format(Locale.ENGLISH, it) }

inline fun IntArray.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> Any?)) =
		map { transform(it).formatAs(format) }.joinToString(separator, prefix, postfix, limit, truncated)

fun DoubleArray.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...") =
		joinToString(separator, prefix, postfix, limit, truncated) { format.format(Locale.ENGLISH, it) }

inline fun DoubleArray.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Double) -> Any?)) =
		map { transform(it).formatAs(format) }.joinToString(separator, prefix, postfix, limit, truncated)

fun BooleanArray.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...") =
		joinToString(separator, prefix, postfix, limit, truncated) { format.format(Locale.ENGLISH, it) }

inline fun BooleanArray.joinFormatted(format: String = "%s", separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Boolean) -> Any?)) =
		map { transform(it).formatAs(format) }.joinToString(separator, prefix, postfix, limit, truncated)

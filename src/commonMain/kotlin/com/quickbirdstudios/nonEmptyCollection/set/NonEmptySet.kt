package com.quickbirdstudios.nonEmptyCollection.set

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
class NonEmptySet<out T> internal constructor(
    internal val full: Set<T>
) : Set<T> by full, NonEmptyCollection<T> {

    internal constructor(
        first: T,
        rest: Set<T>
    ) : this(
        full = HashSet<T>(rest.size + 1).apply {
            add(first)
            addAll(rest)
        }
    )

    override fun toString(): String = full.toString()

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()

    init {
        require(full.isNotEmpty()) {
            "Fatal Error! This is a bug. Please contact the library author."
        }
    }
}

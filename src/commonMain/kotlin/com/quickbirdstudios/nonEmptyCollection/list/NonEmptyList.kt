package com.quickbirdstudios.nonEmptyCollection.list

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@OptIn(ExperimentalJsExport::class)
@JsExport
class NonEmptyList<out T> internal constructor(
    internal val full: List<T>
) : List<T> by full, NonEmptyCollection<T> {

    internal constructor(
        head: T,
        tail: List<T>
    ) : this(
        full = ArrayList<T>(tail.size + 1).apply {
            add(head)
            addAll(tail)
        }
    )

    init {
        require(full.isNotEmpty()) {
            "Fatal Error! This is a bug. Please contact the library author."
        }
    }

    override fun toString(): String = full.toString()

    override fun equals(other: Any?): Boolean = full == other

    override fun hashCode(): Int = full.hashCode()
}

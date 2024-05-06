@file:Suppress("unused")
@file:OptIn(UnsafeNonEmptyCollectionApi::class)

package com.quickbirdstudios.nonEmptyCollection

import com.quickbirdstudios.nonEmptyCollection.unsafe.UnsafeNonEmptyCollectionApi
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyList
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptyMap
import com.quickbirdstudios.nonEmptyCollection.unsafe.toNonEmptySet
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

fun <T> List<T>.toNonEmptyListOrNull() = if (isEmpty()) null else toNonEmptyList()

fun <T> Set<T>.toNonEmptySetOrNull() = if (isEmpty()) null else toNonEmptySet()

fun <K, V> Map<K, V>.toNonEmptyMapOrNull() = if (isEmpty()) null else toNonEmptyMap()

@OptIn(ExperimentalJsExport::class)
@JsExport
fun <T> Array<T>.toNonEmptyListOrNull() = toList().toNonEmptyListOrNull()

@OptIn(ExperimentalJsExport::class)
@JsExport
fun <T> Array<T>.toNonEmptySetOrNull() = toSet().toNonEmptySetOrNull()

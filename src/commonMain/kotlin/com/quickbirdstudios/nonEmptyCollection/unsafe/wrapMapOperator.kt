@file:OptIn(ExperimentalTypeInference::class)

package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import com.quickbirdstudios.nonEmptyCollection.map.NonEmptyMap
import kotlin.experimental.ExperimentalTypeInference

@UnsafeNonEmptyCollectionApi
inline fun <InputType, Key, Value> NonEmptyCollection<InputType>.wrapOperator(
    noinline operator: Iterable<InputType>.() -> Map<Key, Value>
): NonEmptyMap<Key, Value> = wrapOperator(Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputType, Parameter, Key, Value> NonEmptyCollection<InputType>.wrapOperator(
    parameter: Parameter,
    noinline operator: Iterable<InputType>.(Parameter) -> Map<Key, Value>
): NonEmptyMap<Key, Value> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputType, FirstParameter, SecondParameter, Key, Value>
        NonEmptyCollection<InputType>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: Iterable<InputType>.(FirstParameter, SecondParameter) -> Map<Key, Value>
): NonEmptyMap<Key, Value> = operator(firstParameter, secondParameter).toNonEmptyMap()

@UnsafeNonEmptyCollectionApi
inline fun <InputKey, InputValue, OutputKey, OutputValue>
        NonEmptyMap<InputKey, InputValue>.wrapOperator(
    noinline operator: Map<InputKey, InputValue>.() -> Map<OutputKey, OutputValue>
): NonEmptyMap<OutputKey, OutputValue> = wrapOperator(Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputKey, InputValue, Parameter, OutputKey, OutputValue>
        NonEmptyMap<InputKey, InputValue>.wrapOperator(
    parameter: Parameter,
    noinline operator: Map<InputKey, InputValue>.(Parameter) -> Map<OutputKey, OutputValue>
): NonEmptyMap<OutputKey, OutputValue> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputKey, InputValue, FirstParameter, SecondParameter, OutputKey, OutputValue>
        NonEmptyMap<InputKey, InputValue>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: Map<InputKey, InputValue>.(
        FirstParameter, SecondParameter
    ) -> Map<OutputKey, OutputValue>
): NonEmptyMap<OutputKey, OutputValue> = operator(firstParameter, secondParameter).toNonEmptyMap()

@UnsafeNonEmptyCollectionApi
inline fun <InputKey, InputValue, Output> NonEmptyMap<InputKey, InputValue>.wrapOperator(
    noinline operator: Map<InputKey, InputValue>.() -> Iterable<Output>
): NonEmptyList<Output> = wrapOperator(Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputKey, InputValue, Parameter, Output> NonEmptyMap<InputKey, InputValue>.wrapOperator(
    parameter: Parameter,
    noinline operator: Map<InputKey, InputValue>.(Parameter) -> Iterable<Output>
): NonEmptyList<Output> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputKey, InputValue, FirstParameter, SecondParameter, Output>
        NonEmptyMap<InputKey, InputValue>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: Map<InputKey, InputValue>.(FirstParameter, SecondParameter) -> Iterable<Output>
): NonEmptyList<Output> = operator(firstParameter, secondParameter).toNonEmptyList()

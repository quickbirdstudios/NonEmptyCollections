@file:OptIn(ExperimentalTypeInference::class)

package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.set.NonEmptySet
import kotlin.experimental.ExperimentalTypeInference
import kotlin.jvm.JvmName

@UnsafeNonEmptyCollectionApi
inline fun <InputType, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    noinline operator: Iterable<InputType>.() -> Set<OutputType>,
): NonEmptySet<OutputType> = wrapOperator(Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputType, Parameter, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    parameter: Parameter,
    noinline operator: Iterable<InputType>.(Parameter) -> Set<OutputType>
): NonEmptySet<OutputType> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputType, FirstParameter, SecondParameter, OutputType>
        NonEmptyCollection<InputType>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: Iterable<InputType>.(FirstParameter, SecondParameter) -> Set<OutputType>
): NonEmptySet<OutputType> = operator(firstParameter, secondParameter).toNonEmptySet()

@JvmName("wrapSetOperator")
@UnsafeNonEmptyCollectionApi
inline fun <InputType, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    noinline operator: Set<InputType>.() -> Set<OutputType>,
): NonEmptySet<OutputType> = wrapOperator(Unit, operator.addUnitParameter())

@JvmName("wrapSetOperator")
@UnsafeNonEmptyCollectionApi
inline fun <InputType, Parameter, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    parameter: Parameter,
    noinline operator: Set<InputType>.(Parameter) -> Set<OutputType>
): NonEmptySet<OutputType> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@JvmName("wrapSetOperator")
@UnsafeNonEmptyCollectionApi
inline fun <InputType, FirstParameter, SecondParameter, OutputType>
        NonEmptyCollection<InputType>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: Set<InputType>.(FirstParameter, SecondParameter) -> Set<OutputType>
): NonEmptySet<OutputType> = toSet().operator(firstParameter, secondParameter).toNonEmptySet()

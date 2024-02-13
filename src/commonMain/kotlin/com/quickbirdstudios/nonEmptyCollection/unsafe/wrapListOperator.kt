@file:OptIn(ExperimentalTypeInference::class)

package com.quickbirdstudios.nonEmptyCollection.unsafe

import com.quickbirdstudios.nonEmptyCollection.NonEmptyCollection
import com.quickbirdstudios.nonEmptyCollection.list.NonEmptyList
import kotlin.experimental.ExperimentalTypeInference
import kotlin.jvm.JvmName

@UnsafeNonEmptyCollectionApi
inline fun <InputType, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    noinline operator: Iterable<InputType>.() -> List<OutputType>,
): NonEmptyList<OutputType> = wrapOperator(Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputType, Parameter, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    parameter: Parameter,
    noinline operator: Iterable<InputType>.(Parameter) -> List<OutputType>
): NonEmptyList<OutputType> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@UnsafeNonEmptyCollectionApi
inline fun <InputType, FirstParameter, SecondParameter, OutputType>
        NonEmptyCollection<InputType>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: Iterable<InputType>.(FirstParameter, SecondParameter) -> List<OutputType>
): NonEmptyList<OutputType> = operator(firstParameter, secondParameter).toNonEmptyList()

@JvmName("wrapListOperator")
@UnsafeNonEmptyCollectionApi
inline fun <InputType, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    noinline operator: List<InputType>.() -> List<OutputType>,
): NonEmptyList<OutputType> = wrapOperator(Unit, operator.addUnitParameter())

@JvmName("wrapListOperator")
@UnsafeNonEmptyCollectionApi
inline fun <InputType, Parameter, OutputType> NonEmptyCollection<InputType>.wrapOperator(
    parameter: Parameter,
    noinline operator: List<InputType>.(Parameter) -> List<OutputType>
): NonEmptyList<OutputType> = wrapOperator(parameter, Unit, operator.addUnitParameter())

@JvmName("wrapListOperator")
@UnsafeNonEmptyCollectionApi
inline fun <InputType, FirstParameter, SecondParameter, OutputType>
        NonEmptyCollection<InputType>.wrapOperator(
    firstParameter: FirstParameter,
    secondParameter: SecondParameter,
    operator: List<InputType>.(FirstParameter, SecondParameter) -> List<OutputType>
): NonEmptyList<OutputType> = toList().operator(firstParameter, secondParameter).toNonEmptyList()

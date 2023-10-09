package com.ecoservicios.comedorapp.domain

import kotlinx.coroutines.flow.Flow

sealed interface FlowUseCase{

    interface WithParams<Parameters, Result>: FlowUseCase {
        suspend operator fun invoke(params: Parameters): Flow<Result>
    }

    interface WithoutParams<Result>: FlowUseCase {
        suspend operator fun invoke(): Flow<Result>
    }

    interface OptionalParams<Parameters, Result>: FlowUseCase {
        suspend operator fun invoke(params: Parameters? = null): Flow<Result>
    }

}
package com.ecoservicios.comedorapp.domain

sealed interface SimpleUseCase{

    interface WithParams<Parameters, Result>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters): Result
    }

    interface WithoutParams<Result>: SimpleUseCase {
        suspend operator fun invoke(): Result
    }

    interface OptionalParams<Parameters, Result>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters? = null): Result
    }

    interface WithoutResult<Parameters>: SimpleUseCase {
        suspend operator fun invoke(params: Parameters)
    }

    interface Empty: SimpleUseCase {
        suspend operator fun invoke()
    }
}
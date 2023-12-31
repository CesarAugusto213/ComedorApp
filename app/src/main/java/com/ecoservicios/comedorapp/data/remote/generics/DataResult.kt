package com.ecoservicios.comedorapp.data.remote.generics

sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()

    open class Error(
        val code: Int? = 0,
        val message: String? = null,
        val cause: Throwable? = null
    ) : DataResult<Nothing>()

    fun <I> map(mapper: (T) -> I): DataResult<I> {
        return when (this) {
            is Success -> Success(data = mapper(data))
            is Error -> this
        }
    }
}

sealed class DataError(
    code: Int? = null,
    message: String? = null,
    cause: Throwable? = null
) : DataResult.Error(code, message, cause) {
    class HttpError(
        code: Int,
        message: String? = null,
        cause: Throwable? = null,
        val body: String? = null
    ) : DataError(code, message, cause)
}
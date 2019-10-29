package com.movefast.data.network.errorhandling

import com.movefast.data.network.Resource
import com.squareup.moshi.JsonEncodingException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
private const val HTTP_CODE_CLIENT_START = 400
private const val HTTP_CODE_CLIENT_END = 499

private const val HTTP_CODE_SERVER_START = 500
private const val HTTP_CODE_SERVER_END = 599

inline fun <T> tryResource(func: () -> T): Resource<T> {
    return try {
        Resource.Success(data = func())
    } catch (e: Exception) {
        Resource.Error(error = getRequestException(e))
    }
}


fun getRequestException(cause: Throwable): NetworkException {
    return when (cause) {
        is HttpException -> {
            handleHttpException(cause)
        }
        is SocketTimeoutException -> {
            NetworkException.Timeout(cause.message, cause)
        }
        is JsonEncodingException -> {
            NetworkException.Data(cause.message, cause)
        }
        is IOException -> {
            NetworkException.Network(cause.message, cause)
        }
        else -> {
            NetworkException.Unexpected(cause.message, cause)
        }
    }
}

fun handleHttpException(cause: HttpException): NetworkException {
    return when (cause.code()) {
        in HTTP_CODE_CLIENT_START..HTTP_CODE_CLIENT_END -> {
            NetworkException.Client(cause.message, cause)
        }
        in HTTP_CODE_SERVER_START..HTTP_CODE_SERVER_END -> {
            NetworkException.Server(cause.message, cause)
        }
        else -> {
            NetworkException.Unexpected(cause.message, cause)
        }
    }
}

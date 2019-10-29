package com.movefast.data.network.errorhandling

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
sealed class NetworkException(
    message: String?,
    cause: Throwable
) : RuntimeException(message, cause) {

    class Client(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Server(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Unauthorized(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Timeout(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Data(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Network(message: String?, cause: Throwable) : NetworkException(message, cause)

    class Unexpected(message: String?, cause: Throwable) : NetworkException(message, cause)
}

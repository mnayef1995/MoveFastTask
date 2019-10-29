package com.movefast.data

import kotlin.coroutines.CoroutineContext

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
interface CoroutinesContextProvider {

    val main: CoroutineContext

    val io: CoroutineContext
}

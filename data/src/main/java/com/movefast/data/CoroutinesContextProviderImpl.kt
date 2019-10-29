package com.movefast.data

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class CoroutinesContextProviderImpl : CoroutinesContextProvider {

    override val main: CoroutineContext
        get() = Dispatchers.Main

    override val io: CoroutineContext
        get() = Dispatchers.IO
}

package com.movefast.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.coroutines.CoroutineContext

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@UseExperimental(ExperimentalCoroutinesApi::class)
class CoroutinesContextTestProviderImpl : CoroutinesContextProvider {

    override val main: CoroutineContext
        get() = Dispatchers.Unconfined

    override val io: CoroutineContext
        get() = Dispatchers.Unconfined
}

package com.movefast.di

import android.app.Application
import com.movefast.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        RepositoriesModule::class,
        DaosModule::class,
        CommonModule::class,
        FragmentBuilderModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    override fun inject(instance: MyApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}

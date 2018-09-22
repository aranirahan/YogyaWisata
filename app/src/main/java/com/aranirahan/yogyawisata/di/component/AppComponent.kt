package com.aranirahan.yogyawisata.di.component

import android.app.Application
import com.aranirahan.yogyawisata.BaseApp
import com.aranirahan.yogyawisata.di.module.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    ActivityBuilderModule::class,
    RepositoryModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(baseApp: BaseApp)
}
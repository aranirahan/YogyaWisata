package com.aranirahan.yogyawisata.di.module

import com.aranirahan.yogyawisata.data.repository.WisataRepository
import com.aranirahan.yogyawisata.data.repository.WisataRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: WisataRepositoryImpl): WisataRepository = repositoryImpl
}
package us.smt.educationstatisticuz.data.api

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import us.smt.educationstatisticuz.data.repository.OliyTalimRepositoryImpl
import us.smt.educationstatisticuz.domen.repository.OliyTalimRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindOliyTalimRepository(repository: OliyTalimRepositoryImpl):OliyTalimRepository
}
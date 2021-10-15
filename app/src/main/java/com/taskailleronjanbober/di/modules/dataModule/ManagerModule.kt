package com.taskailleronjanbober.di.modules.dataModule

import com.data.client.api.AirQualityApi
import com.data.repositories.AqindexGetIndexStationIdRepositoryImpl
import com.data.repositories.FindAllRepositoryImpl
import com.data.repositories.StationSensorsStationIdRepositoryImpl
import com.domain.repositories.AqIndexGetIndexStationIdRepository
import com.domain.repositories.FindAllRepository
import com.domain.repositories.StationSensorsStationIdRepository
import com.domain.usecases.GetAqindexGetIndexStationIdUseCase
import com.domain.usecases.GetFindAllUseCase
import com.domain.usecases.GetStationSensorsStationIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ManagerModule {

    @Provides
    @Singleton
    internal fun provideFindAllRepository(
        airQualityApi: AirQualityApi
    ): FindAllRepository {
        return FindAllRepositoryImpl(airQualityApi)
    }

    @Provides
    @Singleton
    fun provideGetFindAllUseCase(findAllRepository: FindAllRepository): GetFindAllUseCase {
        return GetFindAllUseCase(findAllRepository)
    }

    @Provides
    @Singleton
    fun provideGetStationSensorsStationIdUseCase(
        stationSensorsStationIdRepository: StationSensorsStationIdRepository
    ): GetStationSensorsStationIdUseCase {
        return GetStationSensorsStationIdUseCase(stationSensorsStationIdRepository)
    }

    @Provides
    @Singleton
    fun provideStationSensorsStationIdRepository(
        airQualityApi: AirQualityApi
    ): StationSensorsStationIdRepository {
        return StationSensorsStationIdRepositoryImpl(airQualityApi)
    }

    @Provides
    @Singleton
    fun provideGetAqIndexGetIndexStationIdUseCase(
        aqIndexGetIndexStationIdRepository: AqIndexGetIndexStationIdRepository
    ): GetAqindexGetIndexStationIdUseCase {
        return GetAqindexGetIndexStationIdUseCase(aqIndexGetIndexStationIdRepository)
    }

    @Provides
    @Singleton
    fun provideAqIndexGetIndexStationIdRepository(
        airQualityApi: AirQualityApi
    ): AqIndexGetIndexStationIdRepository {
        return AqindexGetIndexStationIdRepositoryImpl(airQualityApi)
    }
}
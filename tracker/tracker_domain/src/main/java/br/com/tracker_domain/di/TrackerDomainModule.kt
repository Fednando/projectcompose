package br.com.tracker_domain.di

import br.com.core.domain.preferences.Preferences
import br.com.tracker_domain.repository.TrackerRepository
import br.com.tracker_domain.usecase.CalculateMealNutrients
import br.com.tracker_domain.usecase.DeleteTrackedFood
import br.com.tracker_domain.usecase.GetFoodsForDate
import br.com.tracker_domain.usecase.SearchFood
import br.com.tracker_domain.usecase.TrackFood
import br.com.tracker_domain.usecase.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}
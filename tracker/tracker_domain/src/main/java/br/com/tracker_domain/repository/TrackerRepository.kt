package br.com.tracker_domain.repository

import br.com.tracker_domain.model.TrackableFood
import br.com.tracker_domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {
    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackerFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>>
}
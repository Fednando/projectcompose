package br.com.tracker_presentation.trackeroverview

import android.os.Build
import androidx.annotation.RequiresApi
import br.com.tracker_domain.model.TrackedFood
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
data class TrackerOverviewState constructor(
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    val totalFat: Int = 0,
    val totalCalories: Int = 0,
    val carbsGoal: Int = 0,
    val proteinGoal: Int = 0,
    val fatGoal: Int = 0,
    val caloriesGoal: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val trackedFoods: List<TrackedFood> = emptyList(),
    val meals: List<Meal> = defaultMeals
)
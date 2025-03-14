package br.com.tracker_presentation.trackeroverview.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.core.LocalSpacing
import br.com.core.R
import br.com.core.util.UiText
import br.com.tracker_domain.model.MealType
import br.com.tracker_presentation.components.UnitDisplay
import br.com.tracker_presentation.trackeroverview.Meal

@Composable
fun ExpandableMeal(
    meal: Meal,
    content: @Composable () -> Unit,
    modifier: Modifier,
    onToggleClick: () -> Unit
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onToggleClick() }
                .padding(spacing.spaceMedium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = meal.drawableRes),
                contentDescription = meal.name.asString(context = context)
            )
            Spacer(modifier = Modifier.width(spacing.spaceMedium))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = meal.name.asString(context = context),
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Icon(
                        imageVector = if(meal.isExpanded) {
                            Icons.Default.KeyboardArrowUp
                        } else Icons.Default.KeyboardArrowDown,
                        contentDescription = if(meal.isExpanded) {
                            stringResource(R.string.collapse)
                        } else stringResource(R.string.extend)
                    )

                }
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    UnitDisplay(
                        amount = meal.calories,
                        unit = stringResource(R.string.kcal),
                        amountTextSize = 30.sp
                    )
                    Row{
                        NutrientInfo(
                            name = stringResource(id = R.string.carbs),
                            amount = meal.carbs,
                            unit = stringResource(R.string.grams)
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        NutrientInfo(
                            name = stringResource(R.string.protein),
                            amount = meal.protein,
                            unit = stringResource(R.string.grams)
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        NutrientInfo(
                            name = stringResource(R.string.fat),
                            amount = meal.fat,
                            unit = stringResource(R.string.grams)
                        )
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        AnimatedVisibility(visible = meal.isExpanded) {
            content()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ExpandableMealPreview(){
    ExpandableMeal(
        meal = Meal(
            name = UiText.DynamicString("Breakfast"),
            drawableRes = R.drawable.ic_breakfast,
            mealType = MealType.Breakfast
        ),
        content = {},
        modifier = Modifier,
    ) { }
}
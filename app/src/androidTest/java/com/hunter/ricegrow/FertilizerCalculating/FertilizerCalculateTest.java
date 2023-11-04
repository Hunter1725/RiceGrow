package com.hunter.ricegrow.FertilizerCalculating;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.hunter.ricegrow.Activity.Calculating.FertilizerCalculating.FertilizerCalculate;
import com.hunter.ricegrow.R;

import org.junit.Rule;
import org.junit.Test;

public class FertilizerCalculateTest {

    @Rule
    public ActivityScenarioRule<FertilizerCalculate> activityScenarioRule =
            new ActivityScenarioRule<>(FertilizerCalculate.class);

    @Test
    public void testFertilizerCalculation() {
        // Type nutrient values and area
        Espresso.onView(ViewMatchers.withId(R.id.nutrientNEditText)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.nutrientNEditText)).perform(ViewActions.typeText("80"));
        Espresso.onView(ViewMatchers.withId(R.id.nutrientPEditText)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.nutrientPEditText)).perform(ViewActions.typeText("30"));
        Espresso.onView(ViewMatchers.withId(R.id.nutrientKEditText)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.nutrientKEditText)).perform(ViewActions.typeText("40"));
        Espresso.onView(ViewMatchers.withId(R.id.fieldAreaEditText)).perform(ViewActions.typeText("1"));

        // Click the "Calculate" button
        Espresso.onView(ViewMatchers.withId(R.id.btnCalculating)).perform(ViewActions.click());

        // Check if the result layout is visible
        Espresso.onView(ViewMatchers.withId(R.id.resultLayout)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        // Check the calculated values
        Espresso.onView(ViewMatchers.withId(R.id.txtUrea)).check(ViewAssertions.matches(ViewMatchers.withText("148 Kg"))); // Replace 'X' with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.txtDAP)).check(ViewAssertions.matches(ViewMatchers.withText("65 Kg"))); // Replace 'Y' with the expected value
        Espresso.onView(ViewMatchers.withId(R.id.txtMOP)).check(ViewAssertions.matches(ViewMatchers.withText("67 Kg"))); // Replace 'Z' with the expected value
    }

    @Test
    public void testFertilizerCalculationReset() {
        // Type nutrient values and area
        Espresso.onView(ViewMatchers.withId(R.id.nutrientNEditText)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.nutrientPEditText)).perform(ViewActions.clearText());
        Espresso.onView(ViewMatchers.withId(R.id.nutrientKEditText)).perform(ViewActions.clearText());

        Espresso.onView(ViewMatchers.withId(R.id.nutrientNEditText)).perform(ViewActions.typeText("120"));
        Espresso.onView(ViewMatchers.withId(R.id.nutrientPEditText)).perform(ViewActions.typeText("60"));
        Espresso.onView(ViewMatchers.withId(R.id.nutrientKEditText)).perform(ViewActions.typeText("80"));

        // Click the "Reset" button
        Espresso.onView(ViewMatchers.withId(R.id.btnReset)).perform(ViewActions.click());

        // Check if the nutrient fields are cleared
        Espresso.onView(ViewMatchers.withId(R.id.nutrientNEditText)).check(ViewAssertions.matches(ViewMatchers.withText("80")));
        Espresso.onView(ViewMatchers.withId(R.id.nutrientPEditText)).check(ViewAssertions.matches(ViewMatchers.withText("30")));
        Espresso.onView(ViewMatchers.withId(R.id.nutrientKEditText)).check(ViewAssertions.matches(ViewMatchers.withText("40")));
    }
}

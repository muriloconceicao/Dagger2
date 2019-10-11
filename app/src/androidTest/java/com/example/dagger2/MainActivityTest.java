package com.example.dagger2;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.example.dagger2.views.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkViews() {
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextAge)).check(matches(isDisplayed()));

        onView(withId(R.id.editTextName)).check(matches(withText("")));
        onView(withId(R.id.editTextAge)).check(matches(withText("")));
        onView(withId(R.id.textViewName)).check(matches(withText("")));
        onView(withId(R.id.textViewAge)).check(matches(withText("")));

        onView(withId(R.id.btnSubmit)).check(matches(isDisplayed()));
    }

    @Test
    public void clickSubmitButtonSuccess() {
        onView(withId(R.id.editTextName)).perform(typeText("Teste"));
        onView(withId(R.id.editTextAge)).perform(typeText("18"));
        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.textViewName)).check(matches(withText("Teste")));
        onView(withId(R.id.textViewAge)).check(matches(withText("18")));
    }

    @Test
    public void clickSubmitButtonNameAndAgeFailure() {
        onView(withId(R.id.editTextName)).perform(typeText(""));
        onView(withId(R.id.editTextAge)).perform(typeText(""));
        onView(withId(R.id.btnSubmit)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void clickSubmitButtonNameFailure() {
        onView(withId(R.id.editTextName)).perform(typeText(""));
        onView(withId(R.id.editTextAge)).perform(typeText("18"));
        onView(withId(R.id.btnSubmit)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void clickSubmitButtonAgeFailure() {
        onView(withId(R.id.editTextName)).perform(typeText("Teste"));
        onView(withId(R.id.editTextAge)).perform(typeText("0"));
        onView(withId(R.id.btnSubmit)).perform(click()).check(matches(isDisplayed()));
    }

}
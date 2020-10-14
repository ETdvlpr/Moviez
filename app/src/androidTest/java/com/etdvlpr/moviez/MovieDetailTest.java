package com.etdvlpr.moviez;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.etdvlpr.moviez.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MovieDetailTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void getMovieDetail() {
        // Attempt to scroll to an item that contains the special text.
        onView(withId(R.id.main_movies_recycler))
                // scrollTo will fail the test if no item matches.
                .perform(RecyclerViewActions.scrollTo(
                        hasDescendant(withText("Mulan"))
                ));
    }
}

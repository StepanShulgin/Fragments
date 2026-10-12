package otus.gpb.homework.fragments

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert.assertTrue
import org.junit.Test

class FragmentRestorationTest {
    @Test
    fun portraitResultAndRecreationKeepPrimaryFragment() {
        ActivityScenario.launch(FragmentBAActivity::class.java).use { scenario ->
            orient(scenario, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT, Configuration.ORIENTATION_PORTRAIT)
            onView(withId(R.id.openBB)).perform(click())
            onView(withId(R.id.sendColor)).perform(click())
            scenario.recreate()
            scenario.onActivity {
                assertTrue(it.supportFragmentManager.findFragmentById(R.id.fragmentContainer) is FragmentBA)
            }
        }
    }

    @Test
    fun openSecondaryThenRotateBothWaysRestoresValidContainers() {
        ActivityScenario.launch(FragmentBAActivity::class.java).use { scenario ->
            orient(scenario, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT, Configuration.ORIENTATION_PORTRAIT)
            onView(withId(R.id.openBB)).perform(click())
            orient(scenario, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE, Configuration.ORIENTATION_LANDSCAPE)
            onView(withId(R.id.sendColor)).perform(click())
            scenario.onActivity {
                assertTrue(it.supportFragmentManager.findFragmentById(R.id.fragmentContainer) is FragmentBA)
                assertTrue(it.supportFragmentManager.findFragmentById(R.id.fragmentBBContainer) is FragmentBB)
            }
            orient(scenario, ActivityInfo.SCREEN_ORIENTATION_PORTRAIT, Configuration.ORIENTATION_PORTRAIT)
            onView(withId(R.id.openBB)).perform(click())
        }
    }

    private fun orient(scenario: ActivityScenario<FragmentBAActivity>, requested: Int, expected: Int) {
        scenario.onActivity { it.requestedOrientation = requested }
        val deadline = System.nanoTime() + 5_000_000_000L
        var matches = false
        while (!matches && System.nanoTime() < deadline) {
            scenario.onActivity { matches = it.resources.configuration.orientation == expected }
            if (!matches) Thread.sleep(50)
        }
        assertTrue("Orientation change was not applied", matches)
    }
}

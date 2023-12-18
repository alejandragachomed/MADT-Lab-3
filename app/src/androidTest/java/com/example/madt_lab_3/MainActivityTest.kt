package com.example.madt_lab_3

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Assert.assertEquals
import android.widget.TextView
import kotlin.math.sqrt



@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun testMemoryClearButton() {
        val expectedMemoryValue = 0.0


        onView(withId(R.id.button0_1)).perform(click())

        onView(withId(R.id.ResultDisplay))
            .check(matches(withText(expectedMemoryValue.toString())))
    }
    @Test
    fun testMemoryRecallButton() {
        val expectedMemoryValue = 10.0


        onView(withId(R.id.button0_2)).perform(click())


        onView(withId(R.id.ResultDisplay))
            .check(matches(withText(expectedMemoryValue.toString())))
    }

    @Test
    fun testMemorySaveButton() {
        val expectedValue = 12.0


        onView(withId(R.id.button0_3)).perform(click())


        activityRule.scenario.onActivity { activity ->
            val actualValue = activity.getMemoryValue()

            assertEquals(expectedValue, actualValue, 0.0)
        }
    }
    @Test
    fun testMemoryPlusButton() {
        val initialValue = 5.0


        val scenario = activityRule.scenario
        scenario.onActivity { activity ->
            activity.updateMemoryValue(initialValue)
        }

        val currentValueToAdd = 7.0


        onView(withId(R.id.button0_4)).perform(click())


        scenario.onActivity { activity ->
            assertEquals(initialValue + currentValueToAdd, activity.getMemoryValue(), 0.001)
        }
    }

    @Test
    fun testDelButton() {

        val initialText = "10"


        onView(withId(R.id.ResultDisplay)).check(matches(withText(initialText)))


        onView(withId(R.id.button1_0)).perform(click())


        val expectedTextAfterDelete = initialText.dropLast(1)
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedTextAfterDelete)))
    }

    @Test
    fun testCeButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            activity.findViewById<TextView>(R.id.ResultDisplay).text = initialText
        }


        onView(withId(R.id.button1_1)).perform(click())


        onView(withId(R.id.ResultDisplay)).check(matches(withText("")))
    }

    @Test
    fun testCButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button1_2)).perform(click())


        onView(withId(R.id.ResultDisplay)).check(matches(withText("")))
    }

    @Test
    fun testPnButtonNegativeNumber() {
        val initialText = "-456"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button1_3)).perform(click())


        val positiveInitialText = initialText.substring(1)
        onView(withId(R.id.ResultDisplay)).check(matches(withText(positiveInitialText)))
    }

    @Test
    fun testSqrtButtonValidInput() {
        val initialText = "25"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button1_4)).perform(click())


        val expectedSqrt = sqrt(initialText.toDouble()).toString()
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedSqrt)))
    }

    @Test
    fun testSqrtButtonInvalidInput() {
        val initialText = "-5"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button1_4)).perform(click())


        onView(withId(R.id.ResultDisplay)).check(matches(withText("Error: Square root of a negative number")))
    }

    @Test
    fun testSevenButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button2_0)).perform(click())



        val expectedText = initialText + "7"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testEightButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button2_1)).perform(click())



        val expectedText = initialText + "8"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testNineButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button2_2)).perform(click())



        val expectedText = initialText + "9"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testDivisionButton() {
        val initialText = "10"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button2_3)).perform(click())


        val expectedText = "$initialText /"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    fun testCocientButton() {
        val initialText = "20"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button2_4)).perform(click())


        val expectedText = "$initialText %%"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testFourButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button3_0)).perform(click())



        val expectedText = initialText + "4"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testFiveButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button3_1)).perform(click())



        val expectedText = initialText + "5"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testSixButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button3_2)).perform(click())



        val expectedText = initialText + "6"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    fun testMultiplicationButton() {
        val initialText = "20"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button3_3)).perform(click())


        val expectedText = "$initialText *"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    fun testDivByOneButton() {
        val initialText = "30"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button3_4)).perform(click())


        val expectedText = "1/$initialText"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText.trim())))
    }

    @Test
    fun testOneButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button4_0)).perform(click())



        val expectedText = initialText + "1"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testTwoButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button4_1)).perform(click())



        val expectedText = initialText + "2"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }


    @Test
    fun testThreeButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button4_2)).perform(click())



        val expectedText = initialText + "3"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    fun testMinusButton() {
        val initialText = "20"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button4_3)).perform(click())


        val expectedText = "$initialText -"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    @Test
    fun testCeroButton() {
        val initialText = "Initial Text"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button5_1)).perform(click())



        val expectedText = initialText + "0"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    fun testCommaButton() {
        val initialText = "20"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button5_2)).perform(click())


        val expectedText = "$initialText ,"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }

    fun testPlusButton() {
        val initialText = "20"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = initialText
        }


        onView(withId(R.id.button5_3)).perform(click())


        val expectedText = "$initialText +"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }


    @Test
    fun testEqualButton() {
        val expression = "8 + 4"


        activityRule.scenario.onActivity { activity ->
            val resultDisplay = activity.findViewById<TextView>(R.id.ResultDisplay)
            resultDisplay.text = expression
        }


        onView(withId(R.id.button5_4)).perform(click())


        val expectedText = "12.0"
        onView(withId(R.id.ResultDisplay)).check(matches(withText(expectedText)))
    }




    }
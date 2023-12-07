package com.myapp.x11ysample

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun verifyMovieCategoryHeadingHasCorrectAccessibilityHeading() {
        composeTestRule
            .onAllNodesWithTag(testTag = TAG_CATEGORY_HEADING)
            .assertAll(
                SemanticsMatcher(
                    description = "heading() set correctly"
                ) {
                    it.config.contains(SemanticsProperties.Heading)
                }
            )
    }
}
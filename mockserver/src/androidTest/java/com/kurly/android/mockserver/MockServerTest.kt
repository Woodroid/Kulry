package com.kurly.android.mockserver

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kurly.android.mockserver.core.FileProvider
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
internal class MockServerTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fileProvider: FileProvider

    @Inject
    lateinit var testFileProvider: FileProvider

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun readResourceFileTest() {
        println(fileProvider.getJsonFromAsset("section/products/section_products_1.json"))
    }

    @Test
    fun readResourceFileTest2() {
        print(testFileProvider.getJsonFromAsset("section/products/section_products_1.json"))
    }
}

package com.kurly.android.mockserver

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kurly.android.mockserver.core.FileProvider
import com.kurly.android.mockserver.di.AssetFileProviderForReal
import com.kurly.android.mockserver.di.AssetFileProviderForTest
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
    @AssetFileProviderForReal
    lateinit var fileProvider: FileProvider

    @Inject
    @AssetFileProviderForTest
    lateinit var testFileProvider: FileProvider

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun readResourceFileTest() {
        println(testFileProvider.getJsonFromAsset("resources/file_read_test.json"))
    }

    @Test
    fun readResourceFileReal() {
        print(fileProvider.getJsonFromAsset("section/products/section_products_1.json"))
    }
}

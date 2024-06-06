package com.kashif.zomatoclonecompose.ui

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.annotation.ExperimentalCoilApi
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.util.CoilUtils
import coil.util.DebugLogger
import okhttp3.OkHttpClient

/**
 * Created by Mohammad Kashif Ansari on 31,May,2024
 */
class MyApplication : Application(), ImageLoaderFactory {

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.20)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(cacheDir.resolve("image_cache"))
                    .maxSizeBytes(5 * 1024 * 1024)
                    .build()
            }
            .logger(DebugLogger())
            .okHttpClient {
                OkHttpClient.Builder().build()
            }
            .build()
    }
}
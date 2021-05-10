package com.srb.clout

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class CloutApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader(
            ImageLoader.Builder(this@CloutApp)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(this@CloutApp))
                } else {
                    add(GifDecoder())
                }
            }
            .build())
    }
}
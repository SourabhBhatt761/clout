import com.srb.libimgur.apis.ImgurAPIv3
import com.srb.libimgur.converter.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val API_KEY = "0fe9dfe72048fbc"
object ImgurClient {

    private val client : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()

                chain.proceed(request)
            }.build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .client(client)
            .build()

    }
     val api : ImgurAPIv3 by lazy {
         retrofit.create(ImgurAPIv3::class.java)
     }

}
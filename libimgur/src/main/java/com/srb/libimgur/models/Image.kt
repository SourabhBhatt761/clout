package com.srb.libimgur.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "account_id")
    val accountId: Int?,
    @Json(name = "account_url")
    val accountUrl: String?,
    @Json(name = "ad_config")
    val adConfig: AdConfig?,
    @Json(name = "ad_type")
    val adType: Int?,
    @Json(name = "ad_url")
    val adUrl: String?,
    val animated: Boolean?,
    val bandwidth: Long?,
    @Json(name = "comment_count")
    val commentCount: Int?,
    val cover: String?,
    @Json(name = "cover_height")
    val coverHeight: Int?,
    @Json(name = "cover_width")
    val coverWidth: Int?,
    val datetime: Int?,
    val description: Any?,
    val downs: Int?,
    val edited: Int?,
    val favorite: Boolean?,
    @Json(name = "favorite_count")
    val favoriteCount: Int?,
    val gifv: String?,
    @Json(name = "has_sound")
    val hasSound: Boolean?,
    val height: Int?,
    val hls: String?,
    val id: String?,
    val images: List<Image>?,
    @Json(name = "images_count")
    val imagesCount: Int?,
    @Json(name = "in_gallery")
    val inGallery: Boolean?,
    @Json(name = "in_most_viral")
    val inMostViral: Boolean?,
    @Json(name = "include_album_ads")
    val includeAlbumAds: Boolean?,
    @Json(name = "is_ad")
    val isAd: Boolean?,
    @Json(name = "is_album")
    val isAlbum: Boolean?,
    val layout: String?,
    val link: String?,
    val mp4: String?,
    @Json(name = "mp4_size")
    val mp4Size: Int?,
    val nsfw: Boolean?,
    val points: Int?,
    val privacy: String?,
    val processing: Processing?,
    val score: Int?,
    val section: String?,
    val size: Int?,
    val tags: List<Tag>,
    val title: String?,
    val topic: Any?,
    @Json(name = "topic_id")
    val topicId: Any?,
    val type: String?,
    val ups: Int?,
    val views: Int?,
    val vote: Any?,
    val width: Int?
)
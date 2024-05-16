package com.example.famgithubuser.model.response

import com.google.gson.annotations.SerializedName

class DetailUserResponseModel (
    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("id")
    val id: Long? = null,

    @field:SerializedName("node_id")
    val nodeID: String? = null,

    @field:SerializedName("avatar_url")
    val avatarURL: String? = null,

    @field:SerializedName("gravatar_id")
    val gravatarID: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("html_url")
    val htmlURL: String? = null,

    @field:SerializedName("followers_url")
    val followersURL: String? = null,

    @field:SerializedName("following_url")
    val followingURL: String? = null,

    @field:SerializedName("gists_url")
    val gistsURL: String? = null,

    @field:SerializedName("starred_url")
    val starredURL: String? = null,

    @field:SerializedName("subscriptions_url")
    val subscriptionsURL: String? = null,

    @field:SerializedName("organizations_url")
    val organizationsURL: String? = null,

    @field:SerializedName("repos_url")
    val reposURL: String? = null,

    @field:SerializedName("events_url")
    val eventsURL: String? = null,

    @field:SerializedName("received_events_url")
    val receivedEventsURL: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("site_admin")
    val siteAdmin: Boolean? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("company")
    val company: String? = null,

    @field:SerializedName("blog")
    val blog: String? = null,

    @field:SerializedName("location")
    val location: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("hireable")
    val hireable: String? = null,

    @field:SerializedName("bio")
    val bio: String? = null,

    @field:SerializedName("twitter_username")
    val twitterUsername: String? = null,

    @field:SerializedName("public_repos")
    val publicRepos: Long? = null,

    @field:SerializedName("public_gists")
    val publicGists: Long? = null,

    @field:SerializedName("followers")
    val followers: Long? = null,

    @field:SerializedName("following")
    val following: Long? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null
)
package com.hussainalmahdi.android.challenge.RemoteSource

data class Objects(
    val objects: List<Senator>
        )


data class Senator(
    val party:String ="",
    val person:Person,
    val extra:Extra,
    val description:String = "",
    val enddate:String = "",
    val website:String =""
)

data class Extra(
    val address:String ="",
    val office:String = "",


)

data class Person(
    val sortname:String = "",
    val gender:String = "",
    val name:String = "",
    val firstname:String ="",
    val lastname:String = "",
    val link:String ="",
    val bioguideid:String ="",
    val birthday:String = ""
)
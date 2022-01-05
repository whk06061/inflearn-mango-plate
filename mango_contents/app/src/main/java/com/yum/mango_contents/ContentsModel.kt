package com.yum.mango_contents

import java.io.Serializable

data class ContentsModel(
    val url: String = "",
    val imageUrl: String = "",
    val titleText: String = ""
):Serializable
package com.dreambroker.garage.critique;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageMetaData {

    @SerializedName("base_url")
    String baseUrl;

    @SerializedName("api_path")
    String apiPath;

    @SerializedName("extensions")
    List<String> extensions;

    @SerializedName("file_sizes")
    List<String> fileSizes;

    @SerializedName("image_texts")
    List<String> imageTexts;

}

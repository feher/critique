package com.dreambroker.garage.critique.repository;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageMetaData {

    @SerializedName("base_url")
    public String baseUrl;

    @SerializedName("api_path")
    public String apiPath;

    @SerializedName("extensions")
    public List<String> extensions;

    @SerializedName("file_sizes")
    public List<String> fileSizes;

    @SerializedName("image_texts")
    public List<String> imageTexts;

}

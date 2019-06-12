package com.dreambroker.garage.critique.model;

import android.net.Uri;

public class Image {

    private final Uri uri;
    private final String text;

    public Image(Uri uri, String text) {
        this.uri = uri;
        this.text = text;
    }

    public Uri getUri() {
        return uri;
    }

    public String getText() {
        return text;
    }

}

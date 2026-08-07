package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class Segment {

    @SerializedName("n")
    private String mName;

    public String getName() {
        return this.mName;
    }

    void setName(String name) {
        this.mName = name;
    }
}

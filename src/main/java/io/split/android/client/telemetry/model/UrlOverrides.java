package io.split.android.client.telemetry.model;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class UrlOverrides {

    @SerializedName(CmcdData.OBJECT_TYPE_AUDIO_ONLY)
    private boolean auth;

    @SerializedName("e")
    private boolean events;

    @SerializedName("s")
    private boolean sdkUrl;

    @SerializedName(CmcdConfiguration.KEY_STREAM_TYPE)
    private boolean stream;

    @SerializedName("t")
    private boolean telemetry;

    public boolean isSdkUrl() {
        return this.sdkUrl;
    }

    public void setSdkUrl(boolean sdkUrl) {
        this.sdkUrl = sdkUrl;
    }

    public boolean isEvents() {
        return this.events;
    }

    public void setEvents(boolean events) {
        this.events = events;
    }

    public boolean isAuth() {
        return this.auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isStream() {
        return this.stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public boolean isTelemetry() {
        return this.telemetry;
    }

    public void setTelemetry(boolean telemetry) {
        this.telemetry = telemetry;
    }
}

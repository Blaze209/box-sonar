package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.common.CompressionType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InstantUpdateChangeNotification extends IncomingNotification {

    @SerializedName("changeNumber")
    private long changeNumber;

    @SerializedName("c")
    private Integer compressionType;

    @SerializedName("d")
    private String data;

    @SerializedName("pcn")
    private Long previousChangeNumber;

    InstantUpdateChangeNotification() {
    }

    InstantUpdateChangeNotification(long changeNumber) {
        this.changeNumber = changeNumber;
    }

    public long getChangeNumber() {
        return this.changeNumber;
    }

    public Long getPreviousChangeNumber() {
        return this.previousChangeNumber;
    }

    public String getData() {
        return this.data;
    }

    public CompressionType getCompressionType() {
        Integer num = this.compressionType;
        if (num == null) {
            return null;
        }
        if (num.intValue() == 0) {
            return CompressionType.NONE;
        }
        if (this.compressionType.intValue() == 1) {
            return CompressionType.GZIP;
        }
        if (this.compressionType.intValue() == 2) {
            return CompressionType.ZLIB;
        }
        return null;
    }
}

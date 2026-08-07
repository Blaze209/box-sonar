package io.split.android.client.service.sseclient.notifications;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.annotations.SerializedName;
import io.split.android.client.common.CompressionType;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MembershipNotification extends IncomingNotification {

    @SerializedName("s")
    private Integer algorithmSeed;

    @SerializedName("cn")
    private Long changeNumber;

    @SerializedName("c")
    private CompressionType compression;

    @SerializedName("d")
    private String data;

    @SerializedName(CmcdData.STREAMING_FORMAT_HLS)
    private HashingAlgorithm hashingAlgorithm;

    @SerializedName("n")
    private Set<String> names;

    @SerializedName("i")
    private Long updateIntervalMs;

    @SerializedName("u")
    private MySegmentUpdateStrategy updateStrategy;

    public Long getChangeNumber() {
        return this.changeNumber;
    }

    public Set<String> getNames() {
        return this.names;
    }

    public CompressionType getCompression() {
        return this.compression;
    }

    public MySegmentUpdateStrategy getUpdateStrategy() {
        return this.updateStrategy;
    }

    public String getData() {
        return this.data;
    }

    public Long getUpdateIntervalMs() {
        return this.updateIntervalMs;
    }

    public HashingAlgorithm getHashingAlgorithm() {
        return this.hashingAlgorithm;
    }

    public Integer getAlgorithmSeed() {
        return this.algorithmSeed;
    }
}

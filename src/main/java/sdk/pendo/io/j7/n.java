package sdk.pendo.io.j7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005¨\u0006\f"}, d2 = {"Lsdk/pendo/io/j7/n;", "Lsdk/pendo/io/j7/d;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "value", "", "<init>", "(I)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class n extends d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String value;

    public n(int i) {
        super(null);
        this.name = "margin-top";
        this.value = i + "px";
    }

    @Override // sdk.pendo.io.j7.d
    /* JADX INFO: renamed from: a, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // sdk.pendo.io.j7.d
    /* JADX INFO: renamed from: b, reason: from getter */
    public String getValue() {
        return this.value;
    }
}

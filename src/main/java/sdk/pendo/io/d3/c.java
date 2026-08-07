package sdk.pendo.io.d3;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001e\u0010\u000f\u001a\u00060\u0002j\u0002`\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/d3/c;", "Lsdk/pendo/io/d3/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lexternal/sdk/pendo/io/org/koin/core/qualifier/QualifierValue;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final /* data */ class c implements a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String value;

    public c(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof c) && Intrinsics.areEqual(this.value, ((c) other).value);
    }

    @Override // sdk.pendo.io.d3.a
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return getValue();
    }
}

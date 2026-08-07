package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxIterator;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0006B\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cB1\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001dJ\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0003\u001a\u00020\u0000J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u0006\u001a\u00020\tJ\u0016\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/s2/v;", "", "c", "d", "b", "segment", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "byteCount", "", "sink", "", "[B", "data", "I", "pos", BoxIterator.FIELD_LIMIT, "", "Z", "shared", "e", "owner", "f", "Lsdk/pendo/io/s2/v;", ES6Iterator.NEXT_METHOD, "g", "prev", "<init>", "()V", "([BIIZZ)V", CmcdData.STREAMING_FORMAT_HLS, "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public final class v {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final byte[] data;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int pos;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int limit;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean shared;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public boolean owner;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public v next;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public v prev;

    public v() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void a() {
        int i;
        v vVar = this.prev;
        if (vVar == this) {
            throw new IllegalStateException("cannot compact".toString());
        }
        Intrinsics.checkNotNull(vVar);
        if (vVar.owner) {
            int i2 = this.limit - this.pos;
            v vVar2 = this.prev;
            Intrinsics.checkNotNull(vVar2);
            int i3 = 8192 - vVar2.limit;
            v vVar3 = this.prev;
            Intrinsics.checkNotNull(vVar3);
            if (vVar3.shared) {
                i = 0;
            } else {
                v vVar4 = this.prev;
                Intrinsics.checkNotNull(vVar4);
                i = vVar4.pos;
            }
            if (i2 > i3 + i) {
                return;
            }
            v vVar5 = this.prev;
            Intrinsics.checkNotNull(vVar5);
            a(vVar5, i2);
            b();
            w.a(this);
        }
    }

    public final v b() {
        v vVar = this.next;
        if (vVar == this) {
            vVar = null;
        }
        v vVar2 = this.prev;
        Intrinsics.checkNotNull(vVar2);
        vVar2.next = this.next;
        v vVar3 = this.next;
        Intrinsics.checkNotNull(vVar3);
        vVar3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return vVar;
    }

    public final v c() {
        this.shared = true;
        return new v(this.data, this.pos, this.limit, true, false);
    }

    public final v d() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
        return new v(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public v(byte[] data, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }

    public final v a(v segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        v vVar = this.next;
        Intrinsics.checkNotNull(vVar);
        vVar.prev = segment;
        this.next = segment;
        return segment;
    }

    public final v a(int byteCount) {
        v vVarB;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (byteCount >= 1024) {
            vVarB = c();
        } else {
            vVarB = w.b();
            byte[] bArr = this.data;
            byte[] bArr2 = vVarB.data;
            int i = this.pos;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i, i + byteCount, 2, (Object) null);
        }
        vVarB.limit = vVarB.pos + byteCount;
        this.pos += byteCount;
        v vVar = this.prev;
        Intrinsics.checkNotNull(vVar);
        vVar.a(vVarB);
        return vVarB;
    }

    public final void a(v sink, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i = sink.limit;
        int i2 = i + byteCount;
        if (i2 > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i3 = sink.pos;
            if (i2 - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            ArraysKt.copyInto$default(bArr, bArr, 0, i3, i, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i4 = sink.limit;
        int i5 = this.pos;
        ArraysKt.copyInto(bArr2, bArr3, i4, i5, i5 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }
}

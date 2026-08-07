package com.bumptech.glide.integration.ktx;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Flows.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bumptech/glide/integration/ktx/ImmediateGlideSize;", "Lcom/bumptech/glide/integration/ktx/ResolvableGlideSize;", "size", "Lcom/bumptech/glide/integration/ktx/Size;", "(Lcom/bumptech/glide/integration/ktx/Size;)V", "getSize", "()Lcom/bumptech/glide/integration/ktx/Size;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ImmediateGlideSize extends ResolvableGlideSize {
    private final Size size;

    public static /* synthetic */ ImmediateGlideSize copy$default(ImmediateGlideSize immediateGlideSize, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            size = immediateGlideSize.size;
        }
        return immediateGlideSize.copy(size);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public final ImmediateGlideSize copy(Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        return new ImmediateGlideSize(size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ImmediateGlideSize) && Intrinsics.areEqual(this.size, ((ImmediateGlideSize) other).size);
    }

    public int hashCode() {
        return this.size.hashCode();
    }

    public String toString() {
        return "ImmediateGlideSize(size=" + this.size + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmediateGlideSize(Size size) {
        super(null);
        Intrinsics.checkNotNullParameter(size, "size");
        this.size = size;
    }

    public final Size getSize() {
        return this.size;
    }
}

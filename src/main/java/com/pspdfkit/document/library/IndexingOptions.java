package com.pspdfkit.document.library;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.jni.NativeEnqueueOptions;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/document/library/IndexingOptions;", "", "ignoreAnnotations", "", "ignoreDocumentText", "<init>", "(ZZ)V", "getIgnoreAnnotations", "()Z", "getIgnoreDocumentText", "createNativeEnqueueOptions", "Ljava/util/EnumSet;", "Lcom/pspdfkit/internal/jni/NativeEnqueueOptions;", "createNativeEnqueueOptions$sdk_nutrient", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class IndexingOptions {
    public static final int $stable = 0;
    private final boolean ignoreAnnotations;
    private final boolean ignoreDocumentText;

    /* JADX WARN: Illegal instructions before constructor call */
    public IndexingOptions() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ IndexingOptions copy$default(IndexingOptions indexingOptions, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = indexingOptions.ignoreAnnotations;
        }
        if ((i & 2) != 0) {
            z2 = indexingOptions.ignoreDocumentText;
        }
        return indexingOptions.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIgnoreAnnotations() {
        return this.ignoreAnnotations;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIgnoreDocumentText() {
        return this.ignoreDocumentText;
    }

    public final IndexingOptions copy(boolean ignoreAnnotations, boolean ignoreDocumentText) {
        return new IndexingOptions(ignoreAnnotations, ignoreDocumentText);
    }

    public final EnumSet<NativeEnqueueOptions> createNativeEnqueueOptions$sdk_nutrient() {
        EnumSet<NativeEnqueueOptions> enumSetNoneOf = EnumSet.noneOf(NativeEnqueueOptions.class);
        if (this.ignoreAnnotations) {
            enumSetNoneOf.add(NativeEnqueueOptions.IGNORE_ANNOTATIONS);
        }
        if (this.ignoreDocumentText) {
            enumSetNoneOf.add(NativeEnqueueOptions.IGNORE_DOCUMENT_TEXT);
        }
        enumSetNoneOf.getClass();
        return enumSetNoneOf;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexingOptions)) {
            return false;
        }
        IndexingOptions indexingOptions = (IndexingOptions) other;
        return this.ignoreAnnotations == indexingOptions.ignoreAnnotations && this.ignoreDocumentText == indexingOptions.ignoreDocumentText;
    }

    public final boolean getIgnoreAnnotations() {
        return this.ignoreAnnotations;
    }

    public final boolean getIgnoreDocumentText() {
        return this.ignoreDocumentText;
    }

    public int hashCode() {
        return Boolean.hashCode(this.ignoreDocumentText) + (Boolean.hashCode(this.ignoreAnnotations) * 31);
    }

    public String toString() {
        return "IndexingOptions(ignoreAnnotations=" + this.ignoreAnnotations + ", ignoreDocumentText=" + this.ignoreDocumentText + ")";
    }

    public IndexingOptions(boolean z, boolean z2) {
        this.ignoreAnnotations = z;
        this.ignoreDocumentText = z2;
        if (z && z2) {
            throw new IllegalArgumentException("Both ignoreAnnotations and ignoreDocumentText cannot be true simultaneously. At least one content type must be indexed.");
        }
    }

    public /* synthetic */ IndexingOptions(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}

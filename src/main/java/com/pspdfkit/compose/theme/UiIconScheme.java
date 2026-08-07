package com.pspdfkit.compose.theme;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import io.nutrient.ui.theme.ThemeWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/pspdfkit/compose/theme/UiIconScheme;", "", "documentInfoIconScheme", "Lcom/pspdfkit/compose/theme/DocumentInfoIconScheme;", "<init>", "(Lcom/pspdfkit/compose/theme/DocumentInfoIconScheme;)V", "getDocumentInfoIconScheme", "()Lcom/pspdfkit/compose/theme/DocumentInfoIconScheme;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UiIconScheme {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DocumentInfoIconScheme documentInfoIconScheme;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/pspdfkit/compose/theme/UiIconScheme$Companion;", "", "<init>", "()V", "default", "Lcom/pspdfkit/compose/theme/UiIconScheme;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final UiIconScheme m13967default() {
            return ThemeWrapperKt.getDefaultUiIcons$default(null, 1, null);
        }

        private Companion() {
        }
    }

    public UiIconScheme(DocumentInfoIconScheme documentInfoIconScheme) {
        documentInfoIconScheme.getClass();
        this.documentInfoIconScheme = documentInfoIconScheme;
    }

    public static /* synthetic */ UiIconScheme copy$default(UiIconScheme uiIconScheme, DocumentInfoIconScheme documentInfoIconScheme, int i, Object obj) {
        if ((i & 1) != 0) {
            documentInfoIconScheme = uiIconScheme.documentInfoIconScheme;
        }
        return uiIconScheme.copy(documentInfoIconScheme);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DocumentInfoIconScheme getDocumentInfoIconScheme() {
        return this.documentInfoIconScheme;
    }

    public final UiIconScheme copy(DocumentInfoIconScheme documentInfoIconScheme) {
        documentInfoIconScheme.getClass();
        return new UiIconScheme(documentInfoIconScheme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UiIconScheme) && Intrinsics.areEqual(this.documentInfoIconScheme, ((UiIconScheme) other).documentInfoIconScheme);
    }

    public final DocumentInfoIconScheme getDocumentInfoIconScheme() {
        return this.documentInfoIconScheme;
    }

    public int hashCode() {
        return this.documentInfoIconScheme.hashCode();
    }

    public String toString() {
        return "UiIconScheme(documentInfoIconScheme=" + this.documentInfoIconScheme + ")";
    }
}

package com.pspdfkit.compose.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/compose/theme/SdkTheme;", "", "colors", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "icons", "Lcom/pspdfkit/compose/theme/UiIconScheme;", "<init>", "(Lcom/pspdfkit/compose/theme/UiColorScheme;Lcom/pspdfkit/compose/theme/UiIconScheme;)V", "getColors", "()Lcom/pspdfkit/compose/theme/UiColorScheme;", "getIcons", "()Lcom/pspdfkit/compose/theme/UiIconScheme;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SdkTheme {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final UiColorScheme colors;
    private final UiIconScheme icons;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pspdfkit/compose/theme/SdkTheme$Companion;", "", "<init>", "()V", "default", "Lcom/pspdfkit/compose/theme/SdkTheme;", "colors", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "icons", "Lcom/pspdfkit/compose/theme/UiIconScheme;", "(Lcom/pspdfkit/compose/theme/UiColorScheme;Lcom/pspdfkit/compose/theme/UiIconScheme;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/compose/theme/SdkTheme;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final SdkTheme m13945default(UiColorScheme uiColorScheme, UiIconScheme uiIconScheme, Composer composer, int i, int i2) {
            if ((i2 & 1) != 0) {
                uiColorScheme = UiColorScheme.INSTANCE.m13966default(composer, 6);
            }
            if ((i2 & 2) != 0) {
                uiIconScheme = UiIconScheme.INSTANCE.m13967default();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1314041483, i, -1, "com.pspdfkit.compose.theme.SdkTheme.Companion.default (UiTheme.kt:57)");
            }
            SdkTheme sdkTheme = new SdkTheme(uiColorScheme, uiIconScheme);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return sdkTheme;
        }

        private Companion() {
        }
    }

    public SdkTheme(UiColorScheme uiColorScheme, UiIconScheme uiIconScheme) {
        uiColorScheme.getClass();
        uiIconScheme.getClass();
        this.colors = uiColorScheme;
        this.icons = uiIconScheme;
    }

    public static /* synthetic */ SdkTheme copy$default(SdkTheme sdkTheme, UiColorScheme uiColorScheme, UiIconScheme uiIconScheme, int i, Object obj) {
        if ((i & 1) != 0) {
            uiColorScheme = sdkTheme.colors;
        }
        if ((i & 2) != 0) {
            uiIconScheme = sdkTheme.icons;
        }
        return sdkTheme.copy(uiColorScheme, uiIconScheme);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UiColorScheme getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UiIconScheme getIcons() {
        return this.icons;
    }

    public final SdkTheme copy(UiColorScheme colors, UiIconScheme icons) {
        colors.getClass();
        icons.getClass();
        return new SdkTheme(colors, icons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkTheme)) {
            return false;
        }
        SdkTheme sdkTheme = (SdkTheme) other;
        return Intrinsics.areEqual(this.colors, sdkTheme.colors) && Intrinsics.areEqual(this.icons, sdkTheme.icons);
    }

    public final UiColorScheme getColors() {
        return this.colors;
    }

    public final UiIconScheme getIcons() {
        return this.icons;
    }

    public int hashCode() {
        return this.icons.hashCode() + (this.colors.hashCode() * 31);
    }

    public String toString() {
        return "SdkTheme(colors=" + this.colors + ", icons=" + this.icons + ")";
    }
}

package com.pspdfkit.compose.theme;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import io.nutrient.ui.theme.ThemeWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/pspdfkit/compose/theme/UiColorScheme;", "", "mainToolbar", "Lcom/pspdfkit/compose/theme/MainToolbarColors;", "settingsColorScheme", "Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "aiAssistantColorScheme", "Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "documentInfoColorScheme", "Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "<init>", "(Lcom/pspdfkit/compose/theme/MainToolbarColors;Lcom/pspdfkit/compose/theme/SettingsColorScheme;Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;)V", "getMainToolbar", "()Lcom/pspdfkit/compose/theme/MainToolbarColors;", "getSettingsColorScheme", "()Lcom/pspdfkit/compose/theme/SettingsColorScheme;", "getAiAssistantColorScheme", "()Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "getDocumentInfoColorScheme", "()Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class UiColorScheme {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AiAssistantColorScheme aiAssistantColorScheme;
    private final DocumentInfoColorScheme documentInfoColorScheme;
    private final MainToolbarColors mainToolbar;
    private final SettingsColorScheme settingsColorScheme;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/pspdfkit/compose/theme/UiColorScheme$Companion;", "", "<init>", "()V", "default", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "(Landroidx/compose/runtime/Composer;I)Lcom/pspdfkit/compose/theme/UiColorScheme;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final UiColorScheme m13966default(Composer composer, int i) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-986786244, i, -1, "com.pspdfkit.compose.theme.UiColorScheme.Companion.default (StyleElements.kt:43)");
            }
            UiColorScheme defaultUiColors = ThemeWrapperKt.getDefaultUiColors(null, null, null, null, composer, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return defaultUiColors;
        }

        private Companion() {
        }
    }

    public UiColorScheme(MainToolbarColors mainToolbarColors, SettingsColorScheme settingsColorScheme, AiAssistantColorScheme aiAssistantColorScheme, DocumentInfoColorScheme documentInfoColorScheme) {
        mainToolbarColors.getClass();
        settingsColorScheme.getClass();
        aiAssistantColorScheme.getClass();
        documentInfoColorScheme.getClass();
        this.mainToolbar = mainToolbarColors;
        this.settingsColorScheme = settingsColorScheme;
        this.aiAssistantColorScheme = aiAssistantColorScheme;
        this.documentInfoColorScheme = documentInfoColorScheme;
    }

    public static /* synthetic */ UiColorScheme copy$default(UiColorScheme uiColorScheme, MainToolbarColors mainToolbarColors, SettingsColorScheme settingsColorScheme, AiAssistantColorScheme aiAssistantColorScheme, DocumentInfoColorScheme documentInfoColorScheme, int i, Object obj) {
        if ((i & 1) != 0) {
            mainToolbarColors = uiColorScheme.mainToolbar;
        }
        if ((i & 2) != 0) {
            settingsColorScheme = uiColorScheme.settingsColorScheme;
        }
        if ((i & 4) != 0) {
            aiAssistantColorScheme = uiColorScheme.aiAssistantColorScheme;
        }
        if ((i & 8) != 0) {
            documentInfoColorScheme = uiColorScheme.documentInfoColorScheme;
        }
        return uiColorScheme.copy(mainToolbarColors, settingsColorScheme, aiAssistantColorScheme, documentInfoColorScheme);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MainToolbarColors getMainToolbar() {
        return this.mainToolbar;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SettingsColorScheme getSettingsColorScheme() {
        return this.settingsColorScheme;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AiAssistantColorScheme getAiAssistantColorScheme() {
        return this.aiAssistantColorScheme;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DocumentInfoColorScheme getDocumentInfoColorScheme() {
        return this.documentInfoColorScheme;
    }

    public final UiColorScheme copy(MainToolbarColors mainToolbar, SettingsColorScheme settingsColorScheme, AiAssistantColorScheme aiAssistantColorScheme, DocumentInfoColorScheme documentInfoColorScheme) {
        mainToolbar.getClass();
        settingsColorScheme.getClass();
        aiAssistantColorScheme.getClass();
        documentInfoColorScheme.getClass();
        return new UiColorScheme(mainToolbar, settingsColorScheme, aiAssistantColorScheme, documentInfoColorScheme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiColorScheme)) {
            return false;
        }
        UiColorScheme uiColorScheme = (UiColorScheme) other;
        return Intrinsics.areEqual(this.mainToolbar, uiColorScheme.mainToolbar) && Intrinsics.areEqual(this.settingsColorScheme, uiColorScheme.settingsColorScheme) && Intrinsics.areEqual(this.aiAssistantColorScheme, uiColorScheme.aiAssistantColorScheme) && Intrinsics.areEqual(this.documentInfoColorScheme, uiColorScheme.documentInfoColorScheme);
    }

    public final AiAssistantColorScheme getAiAssistantColorScheme() {
        return this.aiAssistantColorScheme;
    }

    public final DocumentInfoColorScheme getDocumentInfoColorScheme() {
        return this.documentInfoColorScheme;
    }

    public final MainToolbarColors getMainToolbar() {
        return this.mainToolbar;
    }

    public final SettingsColorScheme getSettingsColorScheme() {
        return this.settingsColorScheme;
    }

    public int hashCode() {
        return this.documentInfoColorScheme.hashCode() + ((this.aiAssistantColorScheme.hashCode() + ((this.settingsColorScheme.hashCode() + (this.mainToolbar.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "UiColorScheme(mainToolbar=" + this.mainToolbar + ", settingsColorScheme=" + this.settingsColorScheme + ", aiAssistantColorScheme=" + this.aiAssistantColorScheme + ", documentInfoColorScheme=" + this.documentInfoColorScheme + ")";
    }
}

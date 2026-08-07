package com.pspdfkit.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.pspdfkit.compose.theme.DocumentInfoIconScheme;
import com.pspdfkit.compose.theme.UiTheme;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class md {
    public static final Unit a(ld ldVar, int i, Composer composer, int i2) {
        a(ldVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final ld ldVar, Composer composer, final int i) {
        int i2;
        int documentInfoChangesIcon;
        ldVar.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-636670136);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(ldVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-636670136, i2, -1, "com.pspdfkit.internal.documentinfo.UpdateDocumentInfoGroupWithThemeIcon (DocumentInfoHelper.kt:49)");
            }
            DocumentInfoIconScheme documentInfoIconScheme = UiTheme.INSTANCE.getIcons(composerStartRestartGroup, 6).getDocumentInfoIconScheme();
            int iA = y30.a(ldVar.a);
            if (iA != 1) {
                documentInfoChangesIcon = iA != 2 ? documentInfoIconScheme.getDocumentInfoContentIcon() : documentInfoIconScheme.getDocumentInfoSizeIcon();
            } else {
                documentInfoChangesIcon = documentInfoIconScheme.getDocumentInfoChangesIcon();
            }
            ldVar.c = documentInfoChangesIcon;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.md$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return md.a(ldVar, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

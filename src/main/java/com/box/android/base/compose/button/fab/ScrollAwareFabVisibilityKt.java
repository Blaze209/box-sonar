package com.box.android.base.compose.button.fab;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScrollAwareFabVisibility.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberScrollAwareFabVisibility", "Lcom/box/android/base/compose/button/fab/ScrollAwareFabVisibility;", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/base/compose/button/fab/ScrollAwareFabVisibility;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ScrollAwareFabVisibilityKt {
    public static final ScrollAwareFabVisibility rememberScrollAwareFabVisibility(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -587645348, "C(rememberScrollAwareFabVisibility)38@1248L39:ScrollAwareFabVisibility.kt#m9079x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-587645348, i, -1, "com.box.android.base.compose.button.fab.rememberScrollAwareFabVisibility (ScrollAwareFabVisibility.kt:38)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2086461469, "CC(remember):ScrollAwareFabVisibility.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ScrollAwareFabVisibility();
            composer.updateRememberedValue(objRememberedValue);
        }
        ScrollAwareFabVisibility scrollAwareFabVisibility = (ScrollAwareFabVisibility) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return scrollAwareFabVisibility;
    }
}

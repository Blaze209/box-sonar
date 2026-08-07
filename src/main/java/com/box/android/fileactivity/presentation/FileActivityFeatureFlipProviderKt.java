package com.box.android.fileactivity.presentation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityFeatureFlipProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"LocalFileActivityFeatureFlips", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/box/android/fileactivity/presentation/IFileActivityFeatureFlipProvider;", "getLocalFileActivityFeatureFlips", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideFileActivityFeatureFlips", "", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/box/android/fileactivity/presentation/IFileActivityFeatureFlipProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "file-activity_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActivityFeatureFlipProviderKt {
    private static final ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> LocalFileActivityFeatureFlips = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: com.box.android.fileactivity.presentation.FileActivityFeatureFlipProviderKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return FileActivityFeatureFlipProviderKt.LocalFileActivityFeatureFlips$lambda$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideFileActivityFeatureFlips$lambda$1(IFileActivityFeatureFlipProvider iFileActivityFeatureFlipProvider, Function2 function2, int i, Composer composer, int i2) {
        ProvideFileActivityFeatureFlips(iFileActivityFeatureFlipProvider, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IFileActivityFeatureFlipProvider LocalFileActivityFeatureFlips$lambda$0() {
        return new ConstantFileActivityFeatureFlipProvider(false, false, 3, null);
    }

    public static final ProvidableCompositionLocal<IFileActivityFeatureFlipProvider> getLocalFileActivityFeatureFlips() {
        return LocalFileActivityFeatureFlips;
    }

    public static final void ProvideFileActivityFeatureFlips(final IFileActivityFeatureFlipProvider provider, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(185368162);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideFileActivityFeatureFlips)N(provider,content)32@1456L25,32@1382L99:FileActivityFeatureFlipProvider.kt#dcyg9a");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(provider) : composerStartRestartGroup.changedInstance(provider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(185368162, i2, -1, "com.box.android.fileactivity.presentation.ProvideFileActivityFeatureFlips (FileActivityFeatureFlipProvider.kt:31)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalFileActivityFeatureFlips.provides(provider), ComposableLambdaKt.rememberComposableLambda(465437474, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivityFeatureFlipProviderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivityFeatureFlipProviderKt.ProvideFileActivityFeatureFlips$lambda$0(content, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivityFeatureFlipProviderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivityFeatureFlipProviderKt.ProvideFileActivityFeatureFlips$lambda$1(provider, content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideFileActivityFeatureFlips$lambda$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C33@1466L9:FileActivityFeatureFlipProvider.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(465437474, i, -1, "com.box.android.fileactivity.presentation.ProvideFileActivityFeatureFlips.<anonymous> (FileActivityFeatureFlipProvider.kt:33)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

package com.box.android.base.compose;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.media3.extractor.WavUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ComposeFragmentInjector.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\rH'¢\u0006\u0002\u0010\u000eJ-\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/base/compose/ComposeFragmentInjector;", "", "applyFragment", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "fragmentClass", "Lkotlin/reflect/KClass;", "modifier", "Landroidx/compose/ui/Modifier;", "arguments", "Landroid/os/Bundle;", "onUpdate", "Lkotlin/Function1;", "(Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "(Lkotlin/reflect/KClass;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ComposeFragmentInjector {
    <T extends Fragment> void applyFragment(KClass<T> kClass, Modifier modifier, Bundle bundle, Function1<? super T, Unit> function1, Composer composer, int i);

    /* JADX INFO: compiled from: ComposeFragmentInjector.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class ComposeDefaultImpls {
        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit applyFragment_default$lambda$0(KClass kClass, Modifier modifier, Bundle bundle, Function1 function1, ComposeFragmentInjector composeFragmentInjector, int i, int i2, Composer composer, int i3) {
            applyFragment$default(kClass, modifier, bundle, function1, composeFragmentInjector, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            return Unit.INSTANCE;
        }

        public static final <T extends Fragment> void applyFragment$default(KClass<T> fragmentClass, Modifier modifier, Bundle EMPTY, Function1<? super T, Unit> onUpdate, ComposeFragmentInjector composeFragmentInjector, Composer composer, final int i, final int i2) {
            int i3;
            Modifier modifier2;
            final ComposeFragmentInjector composeFragmentInjector2;
            final KClass<T> kClass;
            final Function1<? super T, Unit> function1;
            final Bundle bundle;
            Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
            Intrinsics.checkNotNullParameter(composeFragmentInjector, "$this$");
            Composer composerStartRestartGroup = composer.startRestartGroup(-162661799);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(applyFragment$default)N(fragmentClass,modifier,arguments,onUpdate):ComposeFragmentInjector.kt#vejmn0");
            if ((i & 6) == 0) {
                i3 = (composerStartRestartGroup.changedInstance(fragmentClass) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changedInstance(EMPTY)) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(onUpdate) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i3 |= (32768 & i) == 0 ? composerStartRestartGroup.changed(composeFragmentInjector) : composerStartRestartGroup.changedInstance(composeFragmentInjector) ? 16384 : 8192;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                } else if ((i2 & 4) != 0) {
                    EMPTY = Bundle.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                    i3 &= -897;
                }
                Bundle bundle2 = EMPTY;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-162661799, i3, -1, "com.box.android.base.compose.ComposeFragmentInjector.ComposeDefaultImpls.applyFragment$default (ComposeFragmentInjector.kt:-1)");
                }
                modifier2 = modifier;
                composeFragmentInjector.applyFragment(fragmentClass, modifier2, bundle2, onUpdate, composerStartRestartGroup, i3 & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
                composeFragmentInjector2 = composeFragmentInjector;
                kClass = fragmentClass;
                function1 = onUpdate;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bundle = bundle2;
            } else {
                modifier2 = modifier;
                composeFragmentInjector2 = composeFragmentInjector;
                kClass = fragmentClass;
                function1 = onUpdate;
                composerStartRestartGroup.skipToGroupEnd();
                bundle = EMPTY;
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ComposeFragmentInjector$ComposeDefaultImpls$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ComposeFragmentInjector.ComposeDefaultImpls.applyFragment_default$lambda$0(kClass, modifier3, bundle, function1, composeFragmentInjector2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: ComposeFragmentInjector.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends Fragment> void applyFragment(ComposeFragmentInjector composeFragmentInjector, KClass<T> fragmentClass, Modifier modifier, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            ComposeFragmentInjector.super.applyFragment(fragmentClass, modifier, composer, i);
        }
    }

    default <T extends Fragment> void applyFragment(KClass<T> fragmentClass, Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        composer.startReplaceGroup(-1743940042);
        ComposerKt.sourceInformation(composer, "C(applyFragment)N(fragmentClass,modifier)27@879L3,24@777L111:ComposeFragmentInjector.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1743940042, i, -1, "com.box.android.base.compose.ComposeFragmentInjector.applyFragment (ComposeFragmentInjector.kt:24)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -889129063, "CC(remember):ComposeFragmentInjector.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ComposeFragmentInjector$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposeFragmentInjector.applyFragment$lambda$0$0((Fragment) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposeDefaultImpls.applyFragment$default(fragmentClass, modifier, null, (Function1) objRememberedValue, this, composer, (i & 14) | 3072 | (i & 112) | ((i << 6) & 57344), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit applyFragment$lambda$0$0(Fragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}

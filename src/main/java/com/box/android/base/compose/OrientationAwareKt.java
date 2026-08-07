package com.box.android.base.compose;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OrientationAware.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\u001aZ\u0010\u0000\u001a\u00020\u00012#\b\u0002\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u00032&\u0010\b\u001a\"\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"OrientationAware", "", "onOrientationChange", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isPortrait", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease", "currentOrientation", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OrientationAwareKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrientationAware$lambda$5(Function1 function1, Function3 function3, int i, int i2, Composer composer, int i3) {
        OrientationAware(function1, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void OrientationAware(final Function1<? super Boolean, Unit> function1, final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1608454707);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OrientationAware)N(onOrientationChange,content)8@287L2,9@388L7,12@470L57,15@607L236,15@577L266,22@849L72:OrientationAware.kt#vejmn0");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -463250763, "CC(remember):OrientationAware.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.compose.OrientationAwareKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OrientationAwareKt.OrientationAware$lambda$0$0(((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1608454707, i3, -1, "com.box.android.base.compose.OrientationAware (OrientationAware.kt:8)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Configuration configuration = (Configuration) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -463244852, "CC(remember):OrientationAware.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(configuration.orientation);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableIntState mutableIntState = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -463240289, "CC(remember):OrientationAware.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 14) == 4) | composerStartRestartGroup.changedInstance(configuration);
            OrientationAwareKt$OrientationAware$2$1 orientationAwareKt$OrientationAware$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || orientationAwareKt$OrientationAware$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                orientationAwareKt$OrientationAware$2$1RememberedValue = new OrientationAwareKt$OrientationAware$2$1(configuration, function1, mutableIntState, null);
                composerStartRestartGroup.updateRememberedValue(orientationAwareKt$OrientationAware$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(configuration, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) orientationAwareKt$OrientationAware$2$1RememberedValue, composerStartRestartGroup, 0);
            content.invoke(Boolean.valueOf(configuration.orientation == 1), composerStartRestartGroup, Integer.valueOf(i3 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.OrientationAwareKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OrientationAwareKt.OrientationAware$lambda$5(function1, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OrientationAware$lambda$0$0(boolean z) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OrientationAware$lambda$2(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }
}

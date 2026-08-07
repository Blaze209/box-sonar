package com.box.brownfieldApi.featuresNavigator;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.fragment.app.FragmentActivity;
import com.callstack.reactnativebrownfield.ReactNativeBrownfield;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/ReactNativeCompose;", "", "<init>", "()V", "RECIPIENT_ID_KEY", "", "ReactNativeFeatureWidget", "", "module", "Lcom/box/brownfieldApi/featuresNavigator/FeatureModule;", "launchOptions", "Landroid/os/Bundle;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", SemanticAttributes.MessagingDestinationKindValues.TOPIC, "value", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/brownfieldApi/featuresNavigator/FeatureModule;Landroid/os/Bundle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeCompose {
    public static final int $stable = 0;
    public static final ReactNativeCompose INSTANCE = new ReactNativeCompose();
    private static final String RECIPIENT_ID_KEY = "recipientId";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReactNativeFeatureWidget$lambda$7(ReactNativeCompose reactNativeCompose, FeatureModule featureModule, Bundle bundle, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        reactNativeCompose.ReactNativeFeatureWidget(featureModule, bundle, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private ReactNativeCompose() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x019f  */
    /* JADX WARN: Code duplicated, block: B:101:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:104:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:111:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:116:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:119:0x0214  */
    /* JADX WARN: Code duplicated, block: B:123:0x0220  */
    /* JADX WARN: Code duplicated, block: B:125:0x022d  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b6 A[PHI: r1 r4 r8
      0x00b6: PHI (r1v24 int) = (r1v19 int), (r1v18 int), (r1v26 int) binds: [B:66:0x00c8, B:58:0x00b2, B:59:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r4v7 android.os.Bundle) = (r4v3 android.os.Bundle), (r4v2 android.os.Bundle), (r4v2 android.os.Bundle) binds: [B:66:0x00c8, B:58:0x00b2, B:59:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      0x00b6: PHI (r8v7 kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit>) = 
      (r8v3 kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit>)
     binds: [B:66:0x00c8, B:58:0x00b2, B:59:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:70:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:74:0x0101  */
    /* JADX WARN: Code duplicated, block: B:76:0x0104  */
    /* JADX WARN: Code duplicated, block: B:78:0x011b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x011d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0122  */
    /* JADX WARN: Code duplicated, block: B:84:0x013e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0146 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0148  */
    /* JADX WARN: Code duplicated, block: B:88:0x0155  */
    /* JADX WARN: Code duplicated, block: B:92:0x0171 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x0189  */
    public final void ReactNativeFeatureWidget(final FeatureModule module, Bundle bundle, Function2<? super String, ? super String, Unit> function2, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Bundle bundle2;
        Function2<? super String, ? super String, Unit> function3;
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        Function2<? super String, ? super String, Unit> function4;
        Modifier modifier3;
        Context context;
        final FragmentActivity fragmentActivity;
        Object objRememberedValue;
        String str;
        boolean zChanged;
        Object objRememberedValue2;
        final Bundle bundle3;
        int i7;
        boolean zChangedInstance;
        Object objRememberedValue3;
        final Bundle bundle4;
        final Modifier modifier4;
        final Function2<? super String, ? super String, Unit> function5;
        boolean z;
        boolean z2;
        ReactNativeCompose$ReactNativeFeatureWidget$1$1$1 reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(module, "module");
        Composer composerStartRestartGroup = composer.startRestartGroup(1373001297);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ReactNativeFeatureWidget)P(2!1,3)59@2343L7,63@2568L66,65@2677L277,87@3454L287,86@3419L365:ReactNativeCompose.kt#bsg48e");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(module.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                bundle2 = bundle;
                int i8 = composerStartRestartGroup.changedInstance(bundle2) ? 32 : 16;
                i3 |= i8;
            } else {
                bundle2 = bundle;
            }
            i3 |= i8;
        } else {
            bundle2 = bundle;
        }
        int i9 = i2 & 4;
        int i10 = 256;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                function3 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                    } else {
                        if ((i2 & 2) != 0) {
                            bundle2 = new Bundle();
                            i3 &= -113;
                        }
                        if (i9 != 0) {
                            function3 = null;
                        }
                        if (i4 != 0) {
                            i6 = i3;
                            function4 = function3;
                            modifier3 = Modifier.INSTANCE;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
                        }
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        context = (Context) objConsume;
                        if (context instanceof FragmentActivity) {
                            fragmentActivity = (FragmentActivity) context;
                        } else {
                            fragmentActivity = null;
                        }
                        if (fragmentActivity != null) {
                            throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
                        }
                        composerStartRestartGroup.startReplaceGroup(1849434622);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            if (function4 != null) {
                                objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                            } else {
                                objRememberedValue = null;
                            }
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        str = (String) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(bundle2);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            if (str != null) {
                                Bundle bundle5 = new Bundle(bundle2);
                                bundle5.putString(RECIPIENT_ID_KEY, str);
                                objRememberedValue2 = bundle5;
                            } else {
                                objRememberedValue2 = bundle2;
                            }
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        bundle3 = (Bundle) objRememberedValue2;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(899315678);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
                        i7 = -1746271574;
                        if (function4 != null && str != null && module.hasTopics()) {
                            for (String str2 : module.getTopics()) {
                                composerStartRestartGroup.startReplaceGroup(i7);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                                boolean zChanged2 = composerStartRestartGroup.changed(str2);
                                if ((i6 & 896) == i10) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                z2 = zChanged2 | z;
                                reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z2 || reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                                    composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                                i10 = 256;
                                i7 = -1746271574;
                            }
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1746271574);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        bundle4 = bundle2;
                        modifier4 = modifier3;
                        function5 = function4;
                    }
                    i6 = i3;
                    function4 = function3;
                    modifier3 = modifier2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
                    }
                    ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume2;
                    if (context instanceof FragmentActivity) {
                        fragmentActivity = (FragmentActivity) context;
                    } else {
                        fragmentActivity = null;
                    }
                    if (fragmentActivity != null) {
                        throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
                    }
                    composerStartRestartGroup.startReplaceGroup(1849434622);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        if (function4 != null) {
                            objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                        } else {
                            objRememberedValue = null;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    str = (String) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(bundle2);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        if (str != null) {
                            Bundle bundle6 = new Bundle(bundle2);
                            bundle6.putString(RECIPIENT_ID_KEY, str);
                            objRememberedValue2 = bundle6;
                        } else {
                            objRememberedValue2 = bundle2;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        if (str != null) {
                            Bundle bundle7 = new Bundle(bundle2);
                            bundle7.putString(RECIPIENT_ID_KEY, str);
                            objRememberedValue2 = bundle7;
                        } else {
                            objRememberedValue2 = bundle2;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    bundle3 = (Bundle) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(899315678);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
                    i7 = -1746271574;
                    if (function4 != null) {
                        while (r17.hasNext()) {
                            composerStartRestartGroup.startReplaceGroup(i7);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                            boolean zChanged3 = composerStartRestartGroup.changed(str2);
                            if ((i6 & 896) == i10) {
                                z = true;
                            } else {
                                z = false;
                            }
                            z2 = zChanged3 | z;
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                                composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                            } else {
                                reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                                composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                            i10 = 256;
                            i7 = -1746271574;
                        }
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    bundle4 = bundle2;
                    modifier4 = modifier3;
                    function5 = function4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    bundle4 = bundle2;
                    function5 = function3;
                    modifier4 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$7(this.f$0, module, bundle4, function5, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            modifier2 = modifier;
            if ((i3 & 1171) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                } else {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
                }
                ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localContext3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume3;
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
                }
                composerStartRestartGroup.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    if (function4 != null) {
                        objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                    } else {
                        objRememberedValue = null;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                str = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(bundle2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (str != null) {
                        Bundle bundle8 = new Bundle(bundle2);
                        bundle8.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle8;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    if (str != null) {
                        Bundle bundle9 = new Bundle(bundle2);
                        bundle9.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle9;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                bundle3 = (Bundle) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(899315678);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
                i7 = -1746271574;
                if (function4 != null) {
                    while (r17.hasNext()) {
                        composerStartRestartGroup.startReplaceGroup(i7);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(str2);
                        if ((i6 & 896) == i10) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = zChanged4 | z;
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        } else {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                        i10 = 256;
                        i7 = -1746271574;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bundle4 = bundle2;
                modifier4 = modifier3;
                function5 = function4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                } else {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
                }
                ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localContext4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume4;
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
                }
                composerStartRestartGroup.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    if (function4 != null) {
                        objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                    } else {
                        objRememberedValue = null;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                str = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(bundle2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (str != null) {
                        Bundle bundle10 = new Bundle(bundle2);
                        bundle10.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle10;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    if (str != null) {
                        Bundle bundle11 = new Bundle(bundle2);
                        bundle11.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle11;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                bundle3 = (Bundle) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(899315678);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
                i7 = -1746271574;
                if (function4 != null) {
                    while (r17.hasNext()) {
                        composerStartRestartGroup.startReplaceGroup(i7);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        boolean zChanged5 = composerStartRestartGroup.changed(str2);
                        if ((i6 & 896) == i10) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = zChanged5 | z;
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        } else {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                        i10 = 256;
                        i7 = -1746271574;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bundle4 = bundle2;
                modifier4 = modifier3;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ReactNativeCompose.ReactNativeFeatureWidget$lambda$7(this.f$0, module, bundle4, function5, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function3 = function2;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 1171) == 1170) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                } else {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
                }
                ProvidableCompositionLocal<Context> localContext5 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localContext5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume5;
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
                }
                composerStartRestartGroup.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    if (function4 != null) {
                        objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                    } else {
                        objRememberedValue = null;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                str = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(bundle2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (str != null) {
                        Bundle bundle12 = new Bundle(bundle2);
                        bundle12.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle12;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    if (str != null) {
                        Bundle bundle13 = new Bundle(bundle2);
                        bundle13.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle13;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                bundle3 = (Bundle) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(899315678);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
                i7 = -1746271574;
                if (function4 != null) {
                    while (r17.hasNext()) {
                        composerStartRestartGroup.startReplaceGroup(i7);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        boolean zChanged6 = composerStartRestartGroup.changed(str2);
                        if ((i6 & 896) == i10) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = zChanged6 | z;
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        } else {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                        i10 = 256;
                        i7 = -1746271574;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bundle4 = bundle2;
                modifier4 = modifier3;
                function5 = function4;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0) {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                } else {
                    if ((i2 & 2) != 0) {
                        bundle2 = new Bundle();
                        i3 &= -113;
                    }
                    if (i9 != 0) {
                        function3 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        i6 = i3;
                        function4 = function3;
                        modifier3 = modifier2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
                }
                ProvidableCompositionLocal<Context> localContext6 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localContext6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume6;
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                } else {
                    fragmentActivity = null;
                }
                if (fragmentActivity != null) {
                    throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
                }
                composerStartRestartGroup.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    if (function4 != null) {
                        objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                    } else {
                        objRememberedValue = null;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                str = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(bundle2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    if (str != null) {
                        Bundle bundle14 = new Bundle(bundle2);
                        bundle14.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle14;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    if (str != null) {
                        Bundle bundle15 = new Bundle(bundle2);
                        bundle15.putString(RECIPIENT_ID_KEY, str);
                        objRememberedValue2 = bundle15;
                    } else {
                        objRememberedValue2 = bundle2;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                bundle3 = (Bundle) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(899315678);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
                i7 = -1746271574;
                if (function4 != null) {
                    while (r17.hasNext()) {
                        composerStartRestartGroup.startReplaceGroup(i7);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                        boolean zChanged7 = composerStartRestartGroup.changed(str2);
                        if ((i6 & 896) == i10) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = zChanged7 | z;
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        } else {
                            reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                            composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                        i10 = 256;
                        i7 = -1746271574;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1746271574);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                bundle4 = bundle2;
                modifier4 = modifier3;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ReactNativeCompose.ReactNativeFeatureWidget$lambda$7(this.f$0, module, bundle4, function5, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if ((i2 & 2) != 0) {
                    bundle2 = new Bundle();
                    i3 &= -113;
                }
                if (i9 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = Modifier.INSTANCE;
                } else {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = modifier2;
                }
            } else {
                if ((i2 & 2) != 0) {
                    bundle2 = new Bundle();
                    i3 &= -113;
                }
                if (i9 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = Modifier.INSTANCE;
                } else {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = modifier2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
            }
            ProvidableCompositionLocal<Context> localContext7 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localContext7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume7;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
            }
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                if (function4 != null) {
                    objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                } else {
                    objRememberedValue = null;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            str = (String) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(bundle2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                if (str != null) {
                    Bundle bundle16 = new Bundle(bundle2);
                    bundle16.putString(RECIPIENT_ID_KEY, str);
                    objRememberedValue2 = bundle16;
                } else {
                    objRememberedValue2 = bundle2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                if (str != null) {
                    Bundle bundle17 = new Bundle(bundle2);
                    bundle17.putString(RECIPIENT_ID_KEY, str);
                    objRememberedValue2 = bundle17;
                } else {
                    objRememberedValue2 = bundle2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            bundle3 = (Bundle) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(899315678);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
            i7 = -1746271574;
            if (function4 != null) {
                while (r17.hasNext()) {
                    composerStartRestartGroup.startReplaceGroup(i7);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(str2);
                    if ((i6 & 896) == i10) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = zChanged8 | z;
                    reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                        composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                    } else {
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                        composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                    i10 = 256;
                    i7 = -1746271574;
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceGroup();
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            bundle4 = bundle2;
            modifier4 = modifier3;
            function5 = function4;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if ((i2 & 2) != 0) {
                    bundle2 = new Bundle();
                    i3 &= -113;
                }
                if (i9 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = Modifier.INSTANCE;
                } else {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = modifier2;
                }
            } else {
                if ((i2 & 2) != 0) {
                    bundle2 = new Bundle();
                    i3 &= -113;
                }
                if (i9 != 0) {
                    function3 = null;
                }
                if (i4 != 0) {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = Modifier.INSTANCE;
                } else {
                    i6 = i3;
                    function4 = function3;
                    modifier3 = modifier2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1373001297, i6, -1, "com.box.brownfieldApi.featuresNavigator.ReactNativeCompose.ReactNativeFeatureWidget (ReactNativeCompose.kt:58)");
            }
            ProvidableCompositionLocal<Context> localContext8 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localContext8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume8;
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                throw new IllegalStateException("Context must be FragmentActivity to use ReactNativeCompose.ReactNativeFeatureWidget");
            }
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                if (function4 != null) {
                    objRememberedValue = RecipientIdGeneratorKt.generateRecipientId();
                } else {
                    objRememberedValue = null;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            str = (String) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(bundle2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                if (str != null) {
                    Bundle bundle18 = new Bundle(bundle2);
                    bundle18.putString(RECIPIENT_ID_KEY, str);
                    objRememberedValue2 = bundle18;
                } else {
                    objRememberedValue2 = bundle2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                if (str != null) {
                    Bundle bundle19 = new Bundle(bundle2);
                    bundle19.putString(RECIPIENT_ID_KEY, str);
                    objRememberedValue2 = bundle19;
                } else {
                    objRememberedValue2 = bundle2;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            bundle3 = (Bundle) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(899315678);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*77@3137L240,77@3102L275");
            i7 = -1746271574;
            if (function4 != null) {
                while (r17.hasNext()) {
                    composerStartRestartGroup.startReplaceGroup(i7);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
                    boolean zChanged9 = composerStartRestartGroup.changed(str2);
                    if ((i6 & 896) == i10) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = zChanged9 | z;
                    reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                        composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                    } else {
                        reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue = new ReactNativeCompose$ReactNativeFeatureWidget$1$1$1(str, str2, function4, null);
                        composerStartRestartGroup.updateRememberedValue(reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(str, str2, (Function2) reactNativeCompose$ReactNativeFeatureWidget$1$1$1RememberedValue, composerStartRestartGroup, 6);
                    i10 = 256;
                    i7 = -1746271574;
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ReactNativeCompose.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(fragmentActivity) | ((i6 & 14) == 4) | composerStartRestartGroup.changedInstance(bundle3);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReactNativeCompose.ReactNativeFeatureWidget$lambda$6$lambda$5(fragmentActivity, module, bundle3, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceGroup();
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue3, modifier3, null, composerStartRestartGroup, (i6 >> 6) & 112, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            bundle4 = bundle2;
            modifier4 = modifier3;
            function5 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.brownfieldApi.featuresNavigator.ReactNativeCompose$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReactNativeCompose.ReactNativeFeatureWidget$lambda$7(this.f$0, module, bundle4, function5, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FrameLayout ReactNativeFeatureWidget$lambda$6$lambda$5(FragmentActivity fragmentActivity, FeatureModule featureModule, Bundle bundle, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return ReactNativeBrownfield.INSTANCE.getShared().createView(fragmentActivity, featureModule.getModuleName(), null, bundle);
    }
}

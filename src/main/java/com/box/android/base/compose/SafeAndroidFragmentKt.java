package com.box.android.base.compose;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SafeAndroidFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aY\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"SafeAndroidFragment", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "clazz", "Ljava/lang/Class;", "modifier", "Landroidx/compose/ui/Modifier;", "fragmentState", "Lcom/box/android/base/compose/SafeFragmentState;", "arguments", "Landroid/os/Bundle;", "onUpdate", "Lkotlin/Function1;", "(Ljava/lang/Class;Landroidx/compose/ui/Modifier;Lcom/box/android/base/compose/SafeFragmentState;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberSafeFragmentState", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/base/compose/SafeFragmentState;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SafeAndroidFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SafeAndroidFragment$lambda$4(Class cls, Modifier modifier, SafeFragmentState safeFragmentState, Bundle bundle, Function1 function1, int i, int i2, Composer composer, int i3) {
        SafeAndroidFragment(cls, modifier, safeFragmentState, bundle, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SafeAndroidFragment$lambda$0$0(Fragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:104:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:110:0x0209  */
    /* JADX WARN: Code duplicated, block: B:114:0x0217  */
    /* JADX WARN: Code duplicated, block: B:117:0x0239  */
    /* JADX WARN: Code duplicated, block: B:119:0x0241  */
    /* JADX WARN: Code duplicated, block: B:122:0x024f  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0107  */
    /* JADX WARN: Code duplicated, block: B:88:0x0118  */
    /* JADX WARN: Code duplicated, block: B:91:0x0124  */
    /* JADX WARN: Code duplicated, block: B:94:0x015d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0165  */
    /* JADX WARN: Code duplicated, block: B:99:0x0199  */
    public static final <T extends Fragment> void SafeAndroidFragment(final Class<T> clazz, Modifier modifier, SafeFragmentState safeFragmentState, Bundle bundle, Function1<? super T, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final SafeFragmentState safeFragmentState2;
        final Bundle bundle2;
        int i4;
        Function1<? super T, Unit> function2;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function1<? super T, Unit> function3;
        final SafeFragmentState safeFragmentState3;
        final Bundle bundle3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SafeFragmentState safeFragmentStateRememberSafeFragmentState;
        Bundle EMPTY;
        SafeFragmentState safeFragmentState4;
        Function1<? super T, Unit> function4;
        Bundle bundle4;
        Object objRememberedValue;
        final State stateRememberUpdatedState;
        final int currentCompositeKeyHash;
        View view;
        boolean zChanged;
        Object objRememberedValue2;
        final FragmentManager fragmentManager;
        final Context context;
        Object objRememberedValue3;
        final FragmentContainerViewFactory fragmentContainerViewFactory;
        boolean zChangedInstance;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Composer composerStartRestartGroup = composer.startRestartGroup(52393394);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SafeAndroidFragment)N(clazz,modifier,fragmentState,arguments,onUpdate)61@2818L30,62@2867L23,63@2916L7,64@2950L72,67@3054L7,68@3089L50,69@3144L49,71@3273L3317,71@3199L3391:SafeAndroidFragment.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(clazz) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    safeFragmentState2 = safeFragmentState;
                    int i7 = composerStartRestartGroup.changed(safeFragmentState2) ? 256 : 128;
                    i3 |= i7;
                } else {
                    safeFragmentState2 = safeFragmentState;
                }
                i3 |= i7;
            } else {
                safeFragmentState2 = safeFragmentState;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    bundle2 = bundle;
                    int i8 = composerStartRestartGroup.changedInstance(bundle2) ? 2048 : 1024;
                    i3 |= i8;
                } else {
                    bundle2 = bundle;
                }
                i3 |= i8;
            } else {
                bundle2 = bundle;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@2690L27,59@2785L3");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                        }
                        if ((i2 & 8) != 0) {
                            EMPTY = Bundle.EMPTY;
                            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                            i3 &= -7169;
                        } else {
                            EMPTY = bundle2;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                            bundle4 = EMPTY;
                            function4 = (Function1) objRememberedValue;
                        } else {
                            safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                            function4 = function2;
                            bundle4 = EMPTY;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        companion = modifier2;
                        safeFragmentState4 = safeFragmentState2;
                        function4 = function2;
                        bundle4 = bundle2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(52393394, i3, -1, "com.box.android.base.compose.SafeAndroidFragment (SafeAndroidFragment.kt:60)");
                    }
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189543206, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = FragmentManager.findFragmentManager(view);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    fragmentManager = (FragmentManager) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(fragmentManager);
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189538780, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i9 = i3;
                    Function1<? super T, Unit> function5 = function4;
                    AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i9 & 112, 4);
                    Modifier modifier4 = companion;
                    Object[] objArr = {fragmentManager, fragmentContainerViewFactory, clazz, safeFragmentState4};
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189529625, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(clazz) | ((((i9 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(safeFragmentState4)) || (i9 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        safeFragmentState2 = safeFragmentState4;
                        bundle2 = bundle4;
                        composer2 = composerStartRestartGroup;
                        Function1 function6 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(function6);
                        objRememberedValue4 = function6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        safeFragmentState2 = safeFragmentState4;
                        bundle2 = bundle4;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    EffectsKt.DisposableEffect(objArr, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function5;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = function2;
                }
                safeFragmentState3 = safeFragmentState2;
                bundle3 = bundle2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$4(clazz, modifier3, safeFragmentState3, bundle3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@2690L27,59@2785L3");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        EMPTY = Bundle.EMPTY;
                        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                        i3 &= -7169;
                    } else {
                        EMPTY = bundle2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        bundle4 = EMPTY;
                        function4 = (Function1) objRememberedValue;
                    } else {
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        function4 = function2;
                        bundle4 = EMPTY;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        EMPTY = Bundle.EMPTY;
                        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                        i3 &= -7169;
                    } else {
                        EMPTY = bundle2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        bundle4 = EMPTY;
                        function4 = (Function1) objRememberedValue;
                    } else {
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        function4 = function2;
                        bundle4 = EMPTY;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(52393394, i3, -1, "com.box.android.base.compose.SafeAndroidFragment (SafeAndroidFragment.kt:60)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189543206, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                fragmentManager = (FragmentManager) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(fragmentManager);
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189538780, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i10 = i3;
                Function1<? super T, Unit> function7 = function4;
                AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i10 & 112, 4);
                Modifier modifier5 = companion;
                Object[] objArr2 = {fragmentManager, fragmentContainerViewFactory, clazz, safeFragmentState4};
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189529625, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(clazz) | ((((i10 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(safeFragmentState4)) || (i10 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    safeFragmentState2 = safeFragmentState4;
                    bundle2 = bundle4;
                    composer2 = composerStartRestartGroup;
                    Function1 function8 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function8);
                    objRememberedValue4 = function8;
                } else {
                    safeFragmentState2 = safeFragmentState4;
                    bundle2 = bundle4;
                    composer2 = composerStartRestartGroup;
                    Function1 function9 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function9);
                    objRememberedValue4 = function9;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.DisposableEffect(objArr2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function7;
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
            }
            safeFragmentState3 = safeFragmentState2;
            bundle3 = bundle2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$4(clazz, modifier3, safeFragmentState3, bundle3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                safeFragmentState2 = safeFragmentState;
                if (composerStartRestartGroup.changed(safeFragmentState2)) {
                }
                i3 |= i7;
            } else {
                safeFragmentState2 = safeFragmentState;
            }
            i3 |= i7;
        } else {
            safeFragmentState2 = safeFragmentState;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                bundle2 = bundle;
                if (composerStartRestartGroup.changedInstance(bundle2)) {
                }
                i3 |= i8;
            } else {
                bundle2 = bundle;
            }
            i3 |= i8;
        } else {
            bundle2 = bundle;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@2690L27,59@2785L3");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        EMPTY = Bundle.EMPTY;
                        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                        i3 &= -7169;
                    } else {
                        EMPTY = bundle2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        bundle4 = EMPTY;
                        function4 = (Function1) objRememberedValue;
                    } else {
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        function4 = function2;
                        bundle4 = EMPTY;
                    }
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                    }
                    if ((i2 & 8) != 0) {
                        EMPTY = Bundle.EMPTY;
                        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                        i3 &= -7169;
                    } else {
                        EMPTY = bundle2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        bundle4 = EMPTY;
                        function4 = (Function1) objRememberedValue;
                    } else {
                        safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                        function4 = function2;
                        bundle4 = EMPTY;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(52393394, i3, -1, "com.box.android.base.compose.SafeAndroidFragment (SafeAndroidFragment.kt:60)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localView3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189543206, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = FragmentManager.findFragmentManager(view);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                fragmentManager = (FragmentManager) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Intrinsics.checkNotNull(fragmentManager);
                ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localContext3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189538780, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i11 = i3;
                Function1<? super T, Unit> function10 = function4;
                AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i11 & 112, 4);
                Modifier modifier6 = companion;
                Object[] objArr3 = {fragmentManager, fragmentContainerViewFactory, clazz, safeFragmentState4};
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189529625, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(clazz) | ((((i11 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(safeFragmentState4)) || (i11 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    safeFragmentState2 = safeFragmentState4;
                    bundle2 = bundle4;
                    composer2 = composerStartRestartGroup;
                    Function1 function11 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function11);
                    objRememberedValue4 = function11;
                } else {
                    safeFragmentState2 = safeFragmentState4;
                    bundle2 = bundle4;
                    composer2 = composerStartRestartGroup;
                    Function1 function12 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function12);
                    objRememberedValue4 = function12;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.DisposableEffect(objArr3, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function10;
                modifier3 = modifier6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
            }
            safeFragmentState3 = safeFragmentState2;
            bundle3 = bundle2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$4(clazz, modifier3, safeFragmentState3, bundle3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function1;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "57@2690L27,59@2785L3");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                }
                if ((i2 & 8) != 0) {
                    EMPTY = Bundle.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                    i3 &= -7169;
                } else {
                    EMPTY = bundle2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                    bundle4 = EMPTY;
                    function4 = (Function1) objRememberedValue;
                } else {
                    safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                    function4 = function2;
                    bundle4 = EMPTY;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    safeFragmentStateRememberSafeFragmentState = rememberSafeFragmentState(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    safeFragmentStateRememberSafeFragmentState = safeFragmentState2;
                }
                if ((i2 & 8) != 0) {
                    EMPTY = Bundle.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
                    i3 &= -7169;
                } else {
                    EMPTY = bundle2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189548555, "CC(remember):SafeAndroidFragment.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$0$0((Fragment) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                    bundle4 = EMPTY;
                    function4 = (Function1) objRememberedValue;
                } else {
                    safeFragmentState4 = safeFragmentStateRememberSafeFragmentState;
                    function4 = function2;
                    bundle4 = EMPTY;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(52393394, i3, -1, "com.box.android.base.compose.SafeAndroidFragment (SafeAndroidFragment.kt:60)");
            }
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composerStartRestartGroup, (i3 >> 12) & 14);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<View> localView4 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localView4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume7;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189543206, "CC(remember):SafeAndroidFragment.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = FragmentManager.findFragmentManager(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = FragmentManager.findFragmentManager(view);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            fragmentManager = (FragmentManager) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(fragmentManager);
            ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localContext4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume8;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189538780, "CC(remember):SafeAndroidFragment.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new FragmentContainerViewFactory(currentCompositeKeyHash);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            fragmentContainerViewFactory = (FragmentContainerViewFactory) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i12 = i3;
            Function1<? super T, Unit> function13 = function4;
            AndroidView_androidKt.AndroidView(fragmentContainerViewFactory, companion, null, composerStartRestartGroup, i12 & 112, 4);
            Modifier modifier7 = companion;
            Object[] objArr4 = {fragmentManager, fragmentContainerViewFactory, clazz, safeFragmentState4};
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1189529625, "CC(remember):SafeAndroidFragment.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(fragmentManager) | composerStartRestartGroup.changedInstance(fragmentContainerViewFactory) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(clazz) | ((((i12 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(safeFragmentState4)) || (i12 & 384) == 256) | composerStartRestartGroup.changedInstance(bundle4) | composerStartRestartGroup.changed(currentCompositeKeyHash) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                safeFragmentState2 = safeFragmentState4;
                bundle2 = bundle4;
                composer2 = composerStartRestartGroup;
                Function1 function14 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(function14);
                objRememberedValue4 = function14;
            } else {
                safeFragmentState2 = safeFragmentState4;
                bundle2 = bundle4;
                composer2 = composerStartRestartGroup;
                Function1 function15 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$3$0(fragmentManager, fragmentContainerViewFactory, context, clazz, stateRememberUpdatedState, safeFragmentState2, bundle2, currentCompositeKeyHash, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(function15);
                objRememberedValue4 = function15;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.DisposableEffect(objArr4, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function13;
            modifier3 = modifier7;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function3 = function2;
        }
        safeFragmentState3 = safeFragmentState2;
        bundle3 = bundle2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SafeAndroidFragmentKt.SafeAndroidFragment$lambda$4(clazz, modifier3, safeFragmentState3, bundle3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SafeAndroidFragment$lambda$3$0(final FragmentManager fragmentManager, FragmentContainerViewFactory fragmentContainerViewFactory, Context context, Class cls, State state, final SafeFragmentState safeFragmentState, Bundle bundle, int i, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(fragmentContainerViewFactory.getContainer().getId());
        if (fragmentFindFragmentById == null) {
            fragmentFindFragmentById = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), cls.getName());
            fragmentFindFragmentById.setInitialSavedState(safeFragmentState.getState().getValue());
            fragmentFindFragmentById.setArguments(bundle);
            FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().setReorderingAllowed(true).add(fragmentContainerViewFactory.getContainer(), fragmentFindFragmentById, String.valueOf(i));
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionAdd, "add(...)");
            if (fragmentManager.isStateSaved()) {
                booleanRef.element = true;
                fragmentFindFragmentById.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$SafeAndroidFragment$2$1$fragment$1$1
                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                    public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
                        super.onCreate(lifecycleOwner);
                    }

                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                    public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
                        super.onDestroy(lifecycleOwner);
                    }

                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
                        super.onPause(lifecycleOwner);
                    }

                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
                        super.onResume(lifecycleOwner);
                    }

                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
                        super.onStop(lifecycleOwner);
                    }

                    @Override // androidx.lifecycle.DefaultLifecycleObserver
                    public void onStart(LifecycleOwner owner) {
                        Intrinsics.checkNotNullParameter(owner, "owner");
                        booleanRef.element = false;
                        fragmentFindFragmentById.getLifecycle().removeObserver(this);
                    }
                });
                fragmentTransactionAdd.commitNowAllowingStateLoss();
            } else {
                fragmentTransactionAdd.commitNow();
            }
            Intrinsics.checkNotNullExpressionValue(fragmentFindFragmentById, "apply(...)");
        }
        fragmentManager.onContainerAvailable(fragmentContainerViewFactory.getContainer());
        ((Function1) state.getValue()).invoke(fragmentFindFragmentById);
        return new DisposableEffectResult() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$SafeAndroidFragment$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                if (fragmentFindFragmentById.isAdded()) {
                    safeFragmentState.getState().setValue(fragmentManager.saveFragmentInstanceState(fragmentFindFragmentById));
                }
                if (booleanRef.element) {
                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentById);
                    fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
                } else {
                    if (fragmentManager.isStateSaved()) {
                        return;
                    }
                    FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager.beginTransaction();
                    fragmentTransactionBeginTransaction2.remove(fragmentFindFragmentById);
                    fragmentTransactionBeginTransaction2.commitNow();
                }
            }
        };
    }

    public static final SafeFragmentState rememberSafeFragmentState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1603226497, "C(rememberSafeFragmentState)152@7431L18,153@7469L41,155@7519L23,148@7221L321:SafeAndroidFragment.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1603226497, i, -1, "com.box.android.base.compose.rememberSafeFragmentState (SafeAndroidFragment.kt:148)");
        }
        Object[] objArr = new Object[0];
        ComposerKt.sourceInformationMarkerStart(composer, -1192587213, "CC(remember):SafeAndroidFragment.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function2() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SafeAndroidFragmentKt.rememberSafeFragmentState$lambda$0$0((SaverScope) obj, (SafeFragmentState) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1192585974, "CC(remember):SafeAndroidFragment.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SafeAndroidFragmentKt.rememberSafeFragmentState$lambda$1$0((Fragment.SavedState) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Saver Saver = SaverKt.Saver(function2, (Function1) objRememberedValue2);
        ComposerKt.sourceInformationMarkerStart(composer, -1192584392, "CC(remember):SafeAndroidFragment.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.SafeAndroidFragmentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SafeAndroidFragmentKt.rememberSafeFragmentState$lambda$2$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SafeFragmentState safeFragmentState = (SafeFragmentState) RememberSaveableKt.m6247rememberSaveable(objArr, Saver, (Function0) objRememberedValue3, composer, 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return safeFragmentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Fragment.SavedState rememberSafeFragmentState$lambda$0$0(SaverScope Saver, SafeFragmentState it) {
        Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getState().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SafeFragmentState rememberSafeFragmentState$lambda$1$0(Fragment.SavedState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new SafeFragmentState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(it, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SafeFragmentState rememberSafeFragmentState$lambda$2$0() {
        return new SafeFragmentState(null, 1, null);
    }
}

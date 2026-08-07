package com.box.android.fragments.boxitem;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MyTasksScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002"}, d2 = {"MyTasksScreen", "", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "onNavigateToTask", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "Lkotlin/ParameterName;", "name", "itemModel", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/base/compose/ComposeFragmentInjector;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "box_generalProdRelease", "myTasksFragment", "Lcom/box/android/fragments/boxitem/MyTasksFragment;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MyTasksScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTasksScreen$lambda$5(ComposeFragmentInjector composeFragmentInjector, Function1 function1, SnackbarHostState snackbarHostState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MyTasksScreen(composeFragmentInjector, function1, snackbarHostState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0089  */
    /* JADX WARN: Code duplicated, block: B:43:0x0090  */
    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:55:0x0106  */
    /* JADX WARN: Code duplicated, block: B:58:0x012d  */
    /* JADX WARN: Code duplicated, block: B:59:0x012f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0139  */
    /* JADX WARN: Code duplicated, block: B:67:0x0149  */
    /* JADX WARN: Code duplicated, block: B:70:0x016c  */
    /* JADX WARN: Code duplicated, block: B:72:0x0172  */
    /* JADX WARN: Code duplicated, block: B:75:0x017c  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    public static final void MyTasksScreen(final ComposeFragmentInjector composeFragmentInjector, final Function1<? super ItemModel, Unit> onNavigateToTask, final SnackbarHostState snackbarHostState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Object objRememberedValue;
        final MutableState mutableState;
        Object objRememberedValue2;
        final CoroutineScope coroutineScope;
        Object objRememberedValue3;
        boolean z2;
        boolean zChangedInstance;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(onNavigateToTask, "onNavigateToTask");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(423417148);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MyTasksScreen)N(composeFragmentInjector,onNavigateToTask,snackbarHostState,modifier)24@944L45,28@1016L24,32@1206L176,38@1403L528,30@1070L867:MyTasksScreen.kt#rft9a4");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(composeFragmentInjector) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateToTask) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(423417148, i3, -1, "com.box.android.fragments.boxitem.MyTasksScreen (MyTasksScreen.kt:23)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1118005783, "CC(remember):MyTasksScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MyTasksFragment.class);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1117997268, "CC(remember):MyTasksScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MyTasksScreenKt.MyTasksScreen$lambda$3$0(mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue3, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1117990612, "CC(remember):MyTasksScreen.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | composerStartRestartGroup.changedInstance(coroutineScope) | ((i3 & 896) == 256);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MyTasksScreenKt.MyTasksScreen$lambda$4$0(onNavigateToTask, mutableState, coroutineScope, snackbarHostState, (MyTasksFragment) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposeFragmentInjector.ComposeDefaultImpls.applyFragment$default(orCreateKotlinClass, modifierOnVisibilityChanged$default, null, (Function1) objRememberedValue4, composeFragmentInjector, composerStartRestartGroup, (i3 << 12) & 57344, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MyTasksScreenKt.MyTasksScreen$lambda$5(composeFragmentInjector, onNavigateToTask, snackbarHostState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(423417148, i3, -1, "com.box.android.fragments.boxitem.MyTasksScreen (MyTasksScreen.kt:23)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1118005783, "CC(remember):MyTasksScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(MyTasksFragment.class);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1117997268, "CC(remember):MyTasksScreen.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MyTasksScreenKt.MyTasksScreen$lambda$3$0(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnVisibilityChanged$default2 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue3, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1117990612, "CC(remember):MyTasksScreen.kt#9igjgp");
            if ((i3 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChangedInstance = z2 | composerStartRestartGroup.changedInstance(coroutineScope) | ((i3 & 896) == 256);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MyTasksScreenKt.MyTasksScreen$lambda$4$0(onNavigateToTask, mutableState, coroutineScope, snackbarHostState, (MyTasksFragment) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MyTasksScreenKt.MyTasksScreen$lambda$4$0(onNavigateToTask, mutableState, coroutineScope, snackbarHostState, (MyTasksFragment) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposeFragmentInjector.ComposeDefaultImpls.applyFragment$default(orCreateKotlinClass2, modifierOnVisibilityChanged$default2, null, (Function1) objRememberedValue4, composeFragmentInjector, composerStartRestartGroup, (i3 << 12) & 57344, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MyTasksScreenKt.MyTasksScreen$lambda$5(composeFragmentInjector, onNavigateToTask, snackbarHostState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final MyTasksFragment MyTasksScreen$lambda$1(MutableState<MyTasksFragment> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTasksScreen$lambda$3$0(MutableState mutableState, boolean z) {
        MyTasksFragment myTasksFragmentMyTasksScreen$lambda$1;
        MyTasksFragment myTasksFragmentMyTasksScreen$lambda$2 = MyTasksScreen$lambda$1(mutableState);
        if (myTasksFragmentMyTasksScreen$lambda$2 != null) {
            myTasksFragmentMyTasksScreen$lambda$2.setTabVisibility(z);
        }
        if (z && (myTasksFragmentMyTasksScreen$lambda$1 = MyTasksScreen$lambda$1(mutableState)) != null) {
            myTasksFragmentMyTasksScreen$lambda$1.updateFromRemote();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTasksScreen$lambda$4$0(Function1 function1, MutableState mutableState, final CoroutineScope coroutineScope, final SnackbarHostState snackbarHostState, MyTasksFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        mutableState.setValue(fragment);
        fragment.itemClickListener = function1;
        fragment.showSnackbarListener = new Function4() { // from class: com.box.android.fragments.boxitem.MyTasksScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MyTasksScreenKt.MyTasksScreen$lambda$4$0$0(coroutineScope, snackbarHostState, (String) obj, (String) obj2, (SnackbarDuration) obj3, (Function0) obj4);
            }
        };
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MyTasksScreen$lambda$4$0$0(CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Function0 function0) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MyTasksScreenKt$MyTasksScreen$2$1$1$1(snackbarHostState, str, str2, snackbarDuration, function0, null), 3, null);
        return Unit.INSTANCE;
    }
}

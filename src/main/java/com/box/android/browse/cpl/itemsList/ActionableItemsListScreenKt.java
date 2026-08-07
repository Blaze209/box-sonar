package com.box.android.browse.cpl.itemsList;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.boxai.AiCenterLauncherKt;
import com.box.android.boxai.BoxAiScreenKt;
import com.box.android.browse.compose.FolderListingScreenKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: ActionableItemsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a´\u0001\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2a\b\u0002\u0010\f\u001a[\b\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\r2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"ActionableItemsListScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "emptyScreenConfig", "Lcom/box/android/base/compose/ItemsStateConfig;", "modifier", "Landroidx/compose/ui/Modifier;", "defaultSecondaryActionType", "Lcom/box/android/base/models/SecondaryActionType;", "onShowSnackbar", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "message", "actionLabel", "Landroidx/compose/material3/SnackbarDuration;", "duration", "Lkotlin/coroutines/Continuation;", "Landroidx/compose/material3/SnackbarResult;", "", "isRedesignedVersion", "", "shouldUseAiCenter", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/ItemsStateConfig;Landroidx/compose/ui/Modifier;Lcom/box/android/base/models/SecondaryActionType;Lkotlin/jvm/functions/Function4;ZZLandroidx/compose/runtime/Composer;II)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionableItemsListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionableItemsListScreen$lambda$3(Store store, ItemsStateConfig itemsStateConfig, Modifier modifier, SecondaryActionType secondaryActionType, Function4 function4, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        ActionableItemsListScreen(store, itemsStateConfig, modifier, secondaryActionType, function4, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x012a  */
    /* JADX WARN: Code duplicated, block: B:105:0x014b  */
    /* JADX WARN: Code duplicated, block: B:108:0x018b  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:114:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:118:0x0204  */
    /* JADX WARN: Code duplicated, block: B:120:0x020b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0219  */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00db  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fb A[PHI: r0 r4 r6 r9 r12
      0x00fb: PHI (r0v19 com.box.android.base.models.SecondaryActionType) = 
      (r0v2 com.box.android.base.models.SecondaryActionType)
      (r0v0 com.box.android.base.models.SecondaryActionType)
      (r0v0 com.box.android.base.models.SecondaryActionType)
     binds: [B:98:0x0119, B:85:0x00f7, B:86:0x00f9] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r4v30 int) = (r4v17 int), (r4v14 int), (r4v31 int) binds: [B:98:0x0119, B:85:0x00f7, B:86:0x00f9] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r6v10 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:98:0x0119, B:85:0x00f7, B:86:0x00f9] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r9v21 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>) = 
      (r9v4 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
      (r9v2 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
      (r9v2 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
     binds: [B:98:0x0119, B:85:0x00f7, B:86:0x00f9] A[DONT_GENERATE, DONT_INLINE]
      0x00fb: PHI (r12v9 boolean) = (r12v4 boolean), (r12v3 boolean), (r12v3 boolean) binds: [B:98:0x0119, B:85:0x00f7, B:86:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x0101 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:93:0x010c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0118  */
    /* JADX WARN: Code duplicated, block: B:99:0x011b  */
    public static final void ActionableItemsListScreen(final Store<ActionableItemsListReducer.State, ActionableItemsListReducer.Action> store, final ItemsStateConfig emptyScreenConfig, Modifier modifier, SecondaryActionType secondaryActionType, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, boolean z, boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function5;
        int i5;
        int i6;
        boolean z3;
        int i7;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        final SecondaryActionType secondaryActionType2;
        final Modifier modifier3;
        final Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function6;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SecondaryActionType secondaryActionType3;
        int i10;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function7;
        ActionableItemsListScreenKt$ActionableItemsListScreen$2$1 actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue;
        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue;
        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue;
        int i11;
        boolean zChangedInstance;
        SecondaryActionType.None none = secondaryActionType;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(emptyScreenConfig, "emptyScreenConfig");
        Composer composerStartRestartGroup = composer.startRestartGroup(805488894);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ActionableItemsListScreen)N(store,emptyScreenConfig,modifier,defaultSecondaryActionType,onShowSnackbar,isRedesignedVersion,shouldUseAiCenter)25@1169L50,22@1016L452,33@1473L41,35@1520L35:ActionableItemsListScreen.kt#j5t2uy");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(emptyScreenConfig) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) != 0) {
                    i11 = 1024;
                } else {
                    if ((i & 4096) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(none);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(none);
                    }
                    if (zChangedInstance) {
                        i11 = 2048;
                    } else {
                        i11 = 1024;
                    }
                }
                i3 |= i11;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((599187 & i3) != 599186) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 8) != 0) {
                                    none = SecondaryActionType.None.INSTANCE;
                                    i3 &= -7169;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    z3 = false;
                                }
                                if (i8 != 0) {
                                    secondaryActionType3 = none;
                                    i10 = i3;
                                    modifier3 = modifier2;
                                    function7 = function5;
                                    z4 = false;
                                }
                                boolean z8 = z3;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                                }
                                AnonymousClass1 anonymousClass1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                    public Object get(Object obj) {
                                        return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                                    }
                                };
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass1, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z8, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                                int i13 = i10 & 14;
                                ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i13);
                                MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i13);
                                if (z4) {
                                    composerStartRestartGroup.startReplaceGroup(338413489);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                        public Object get(Object obj) {
                                            return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                                        }
                                    };
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(338659753);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                        public Object get(Object obj) {
                                            return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                                        }
                                    };
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                secondaryActionType2 = secondaryActionType3;
                                function6 = function7;
                                z6 = z8;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                            }
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            boolean z9 = z3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                            }
                            AnonymousClass1 anonymousClass2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass2, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z9, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                            int i14 = i10 & 14;
                            ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i14);
                            MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i14);
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(338413489);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                                ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                    public Object get(Object obj) {
                                        return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                                    }
                                };
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(338659753);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                                ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                    public Object get(Object obj) {
                                        return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                                    }
                                };
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            secondaryActionType2 = secondaryActionType3;
                            function6 = function7;
                            z6 = z9;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            secondaryActionType2 = none;
                            modifier3 = modifier2;
                            function6 = function5;
                            z6 = z3;
                        }
                        z7 = z4;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    z4 = z2;
                    if ((599187 & i3) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        }
                        boolean z10 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                        }
                        AnonymousClass1 anonymousClass3 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass3, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z10, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                        int i15 = i10 & 14;
                        ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i15);
                        MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i15);
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(338413489);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$3 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$3, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(338659753);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$3 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$3, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        secondaryActionType2 = secondaryActionType3;
                        function6 = function7;
                        z6 = z10;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        secondaryActionType2 = none;
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                    }
                    z7 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z3 = z;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((599187 & i3) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        }
                        boolean z11 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                        }
                        AnonymousClass1 anonymousClass4 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass4, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z11, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                        int i16 = i10 & 14;
                        ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i16);
                        MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i16);
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(338413489);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$4 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$4, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(338659753);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$4 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$4, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        secondaryActionType2 = secondaryActionType3;
                        function6 = function7;
                        z6 = z11;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        secondaryActionType2 = none;
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                    }
                    z7 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z4 = z2;
                if ((599187 & i3) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    }
                    boolean z12 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                    }
                    AnonymousClass1 anonymousClass5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass5, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z12, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                    int i17 = i10 & 14;
                    ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i17);
                    MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i17);
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(338413489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$5, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(338659753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$5, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    z6 = z12;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function4;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((599187 & i3) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        }
                        boolean z13 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                        }
                        AnonymousClass1 anonymousClass6 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass6, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z13, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                        int i18 = i10 & 14;
                        ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i18);
                        MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i18);
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(338413489);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$6 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$6, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(338659753);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$6 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$6, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        secondaryActionType2 = secondaryActionType3;
                        function6 = function7;
                        z6 = z13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        secondaryActionType2 = none;
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                    }
                    z7 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z4 = z2;
                if ((599187 & i3) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    }
                    boolean z14 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                    }
                    AnonymousClass1 anonymousClass7 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass7, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z14, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                    int i19 = i10 & 14;
                    ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i19);
                    MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i19);
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(338413489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$7 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$7, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(338659753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$7 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$7, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    z6 = z14;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((599187 & i3) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    }
                    boolean z15 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                    }
                    AnonymousClass1 anonymousClass8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass8, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z15, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                    int i110 = i10 & 14;
                    ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i110);
                    MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i110);
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(338413489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$8, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(338659753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$8 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$8, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    z6 = z15;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z4 = z2;
            if ((599187 & i3) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                }
                boolean z16 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                }
                AnonymousClass1 anonymousClass9 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass9, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z16, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                int i111 = i10 & 14;
                ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i111);
                MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i111);
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(338413489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$9 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$9, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(338659753);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$9 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$9, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                z6 = z16;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
            }
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i11 = 1024;
            } else {
                if ((i & 4096) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(none);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(none);
                }
                if (zChangedInstance) {
                    i11 = 2048;
                } else {
                    i11 = 1024;
                }
            }
            i3 |= i11;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((599187 & i3) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if (i8 != 0) {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                                z4 = false;
                            } else {
                                secondaryActionType3 = none;
                                i10 = i3;
                                modifier3 = modifier2;
                                function7 = function5;
                            }
                        }
                        boolean z17 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                        }
                        AnonymousClass1 anonymousClass10 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass10, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z17, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                        int i112 = i10 & 14;
                        ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i112);
                        MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i112);
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(338413489);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$10 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$10, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(338659753);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                            ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$10 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                                public Object get(Object obj) {
                                    return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                                }
                            };
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$10, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        secondaryActionType2 = secondaryActionType3;
                        function6 = function7;
                        z6 = z17;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        secondaryActionType2 = none;
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                    }
                    z7 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z4 = z2;
                if ((599187 & i3) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    }
                    boolean z18 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                    }
                    AnonymousClass1 anonymousClass11 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass11, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z18, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                    int i113 = i10 & 14;
                    ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i113);
                    MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i113);
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(338413489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$11 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$11, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(338659753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$11 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$11, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    z6 = z18;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((599187 & i3) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    }
                    boolean z19 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                    }
                    AnonymousClass1 anonymousClass12 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass12, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z19, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                    int i114 = i10 & 14;
                    ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i114);
                    MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i114);
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(338413489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$12 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$12, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(338659753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$12 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$12, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    z6 = z19;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z4 = z2;
            if ((599187 & i3) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                }
                boolean z110 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                }
                AnonymousClass1 anonymousClass13 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass13, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z110, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                int i115 = i10 & 14;
                ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i115);
                MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i115);
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(338413489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$13 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$13, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(338659753);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$13 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$13, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                z6 = z110;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
            }
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function5 = function4;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((599187 & i3) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            z3 = false;
                        }
                        if (i8 != 0) {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                            z4 = false;
                        } else {
                            secondaryActionType3 = none;
                            i10 = i3;
                            modifier3 = modifier2;
                            function7 = function5;
                        }
                    }
                    boolean z111 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                    }
                    AnonymousClass1 anonymousClass14 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass14, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z111, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                    int i116 = i10 & 14;
                    ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i116);
                    MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i116);
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(338413489);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$14 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$14, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(338659753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                        ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$14 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$14, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    z6 = z111;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z4 = z2;
            if ((599187 & i3) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                }
                boolean z112 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                }
                AnonymousClass1 anonymousClass15 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass15, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z112, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                int i117 = i10 & 14;
                ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i117);
                MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i117);
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(338413489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$15 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$15, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(338659753);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$15 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$15, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                z6 = z112;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
            }
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((599187 & i3) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        z3 = false;
                    }
                    if (i8 != 0) {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                        z4 = false;
                    } else {
                        secondaryActionType3 = none;
                        i10 = i3;
                        modifier3 = modifier2;
                        function7 = function5;
                    }
                }
                boolean z113 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
                }
                AnonymousClass1 anonymousClass16 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass16, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z113, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
                int i118 = i10 & 14;
                ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i118);
                MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i118);
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(338413489);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$16 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$16, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(338659753);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                    ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$16 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$16, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                z6 = z113;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
            }
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z4 = z2;
        if ((599187 & i3) != 599186) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    z3 = false;
                }
                if (i8 != 0) {
                    secondaryActionType3 = none;
                    i10 = i3;
                    modifier3 = modifier2;
                    function7 = function5;
                    z4 = false;
                } else {
                    secondaryActionType3 = none;
                    i10 = i3;
                    modifier3 = modifier2;
                    function7 = function5;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    z3 = false;
                }
                if (i8 != 0) {
                    secondaryActionType3 = none;
                    i10 = i3;
                    modifier3 = modifier2;
                    function7 = function5;
                    z4 = false;
                } else {
                    secondaryActionType3 = none;
                    i10 = i3;
                    modifier3 = modifier2;
                    function7 = function5;
                }
            }
            boolean z114 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(805488894, i10, -1, "com.box.android.browse.cpl.itemsList.ActionableItemsListScreen (ActionableItemsListScreen.kt:21)");
            }
            AnonymousClass1 anonymousClass17 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt.ActionableItemsListScreen.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((ActionableItemsListReducer.State) obj).getItemsListViewState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980734416, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
            actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$2$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FolderListingScreenKt.FolderListingScreen(store.scope(anonymousClass17, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$2$1RememberedValue)), modifier3, emptyScreenConfig, secondaryActionType3, function7, z114, composerStartRestartGroup, ((i10 >> 3) & 112) | ((i10 << 3) & 896) | (SecondaryActionType.$stable << 9) | (i10 & 7168) | (57344 & i10) | (458752 & i10), 0);
            int i119 = i10 & 14;
            ActionableItemsListMessagesKt.ActionableItemsListDialogs(store, composerStartRestartGroup, i119);
            MultiselectActionModeComposeKt.MultiSelectActionModeCompose(store, composerStartRestartGroup, i119);
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(338413489);
                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1708L52,42@1779L42");
                ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$17 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getBoxAiCenterState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980751666, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AiCenterLauncherKt.AiCenterLauncher(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$17, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiCenterStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(338659753);
                ComposerKt.sourceInformation(composerStartRestartGroup, "46@1945L46,48@2010L36");
                ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1 actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$17 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ActionableItemsListReducer.State) obj).getBoxAiState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 980759244, "CC(remember):ActionableItemsListScreen.kt#9igjgp");
                actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue = ActionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAiScreenKt.BoxAiBottomSheet(store.ifScope(actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$17, (Function1) ((KFunction) actionableItemsListScreenKt$ActionableItemsListScreen$boxAiStore$2$1RememberedValue)), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            secondaryActionType2 = secondaryActionType3;
            function6 = function7;
            z6 = z114;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            secondaryActionType2 = none;
            modifier3 = modifier2;
            function6 = function5;
            z6 = z3;
        }
        z7 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionableItemsListScreenKt.ActionableItemsListScreen$lambda$3(store, emptyScreenConfig, modifier3, secondaryActionType2, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

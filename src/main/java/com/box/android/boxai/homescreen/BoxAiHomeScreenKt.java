package com.box.android.boxai.homescreen;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableDoubleState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotDoubleStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Density;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.multiselect.ContentPickerConstants;
import com.box.android.base.presentation.multiselect.SelectionItemInfo;
import com.box.android.boxai.R;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode;
import com.box.brownfieldApi.featuresNavigator.ContentPickerListener;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.box.brownfieldApi.featuresNavigator.PreviewRequest;
import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.providers.StyleVariant;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BoxAiHomeScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00010\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001aL\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010!\u001a\u00020\"H\u0000\u001aB\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u001f2\u0018\u0010'\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0000¨\u0006+²\u0006\n\u0010,\u001a\u00020-X\u008a\u008e\u0002²\u0006\f\u0010.\u001a\u0004\u0018\u00010/X\u008a\u008e\u0002²\u0006\f\u00100\u001a\u0004\u0018\u00010\u001aX\u008a\u008e\u0002"}, d2 = {"BoxAiHomeScreen", "", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "modifier", "Landroidx/compose/ui/Modifier;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "launchMode", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "hostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "viewModel", "Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel;", "onSessionChanged", "Lkotlin/Function1;", "", "onClose", "Lkotlin/Function0;", "(Lcom/box/android/coreservices/services/IntentServices;Landroidx/compose/ui/Modifier;Lcom/box/android/boxai/homescreen/AiCenterViewFactory;Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;Lcom/box/brownfieldApi/featuresNavigator/HostSurface;Lcom/box/android/base/cpl/IPreviewLauncher;Landroidx/compose/material3/SnackbarHostState;Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "openPreview", "previewRequest", "Lcom/box/brownfieldApi/featuresNavigator/PreviewRequest;", "context", "Landroidx/fragment/app/FragmentActivity;", "previewActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "handleContentPickerResult", "resultCode", "", "data", "onResult", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "onCancel", "boxai_generalProdRelease", "bottomNavBarHeight", "", "contentPickerListener", "Lcom/box/brownfieldApi/featuresNavigator/ContentPickerListener;", "activePreviewRequest"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiHomeScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$8(IntentServices intentServices, Modifier modifier, AiCenterViewFactory aiCenterViewFactory, AiCenterLaunchMode aiCenterLaunchMode, HostSurface hostSurface, IPreviewLauncher iPreviewLauncher, SnackbarHostState snackbarHostState, BoxAiHomeViewModel boxAiHomeViewModel, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        BoxAiHomeScreen(intentServices, modifier, aiCenterViewFactory, aiCenterLaunchMode, hostSurface, iPreviewLauncher, snackbarHostState, boxAiHomeViewModel, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$0$0(String str) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0137  */
    /* JADX WARN: Code duplicated, block: B:103:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x0142  */
    /* JADX WARN: Code duplicated, block: B:106:0x0149  */
    /* JADX WARN: Code duplicated, block: B:107:0x014b  */
    /* JADX WARN: Code duplicated, block: B:109:0x014e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0150  */
    /* JADX WARN: Code duplicated, block: B:112:0x0153  */
    /* JADX WARN: Code duplicated, block: B:113:0x0155  */
    /* JADX WARN: Code duplicated, block: B:116:0x015b  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:120:0x017c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0180  */
    /* JADX WARN: Code duplicated, block: B:124:0x0192  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:135:0x021c  */
    /* JADX WARN: Code duplicated, block: B:136:0x021e  */
    /* JADX WARN: Code duplicated, block: B:139:0x0230  */
    /* JADX WARN: Code duplicated, block: B:141:0x0238  */
    /* JADX WARN: Code duplicated, block: B:144:0x0277  */
    /* JADX WARN: Code duplicated, block: B:146:0x027f  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:152:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:156:0x0363  */
    /* JADX WARN: Code duplicated, block: B:159:0x037b  */
    /* JADX WARN: Code duplicated, block: B:161:0x0398  */
    /* JADX WARN: Code duplicated, block: B:164:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:167:0x03df  */
    /* JADX WARN: Code duplicated, block: B:170:0x040b  */
    /* JADX WARN: Code duplicated, block: B:173:0x0438  */
    /* JADX WARN: Code duplicated, block: B:175:0x0440  */
    /* JADX WARN: Code duplicated, block: B:178:0x0469  */
    /* JADX WARN: Code duplicated, block: B:179:0x046b  */
    /* JADX WARN: Code duplicated, block: B:182:0x0478  */
    /* JADX WARN: Code duplicated, block: B:186:0x0488  */
    /* JADX WARN: Code duplicated, block: B:189:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:190:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:193:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:195:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:198:0x04db  */
    /* JADX WARN: Code duplicated, block: B:199:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:201:0x0523  */
    /* JADX WARN: Code duplicated, block: B:204:0x0550  */
    /* JADX WARN: Code duplicated, block: B:206:0x055d  */
    /* JADX WARN: Code duplicated, block: B:209:0x0570  */
    /* JADX WARN: Code duplicated, block: B:211:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x007c  */
    /* JADX WARN: Code duplicated, block: B:35:0x007f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0083  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:40:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0099  */
    /* JADX WARN: Code duplicated, block: B:46:0x009c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104  */
    /* JADX WARN: Code duplicated, block: B:85:0x0107  */
    /* JADX WARN: Code duplicated, block: B:89:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0116  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0122  */
    /* JADX WARN: Code duplicated, block: B:95:0x0125  */
    /* JADX WARN: Code duplicated, block: B:99:0x0135  */
    public static final void BoxAiHomeScreen(final IntentServices intentServices, Modifier modifier, AiCenterViewFactory aiCenterViewFactory, AiCenterLaunchMode aiCenterLaunchMode, HostSurface hostSurface, final IPreviewLauncher previewLauncher, final SnackbarHostState snackbarHostState, final BoxAiHomeViewModel viewModel, Function1<? super String, Unit> function1, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        AiCenterViewFactory aiCenterViewFactory2;
        int i5;
        int i6;
        AiCenterLaunchMode aiCenterLaunchMode2;
        int i7;
        int i8;
        int iOrdinal;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        Composer composer2;
        final HostSurface hostSurface2;
        final Function0<Unit> function2;
        final Modifier modifier3;
        final AiCenterLaunchMode aiCenterLaunchMode3;
        final Function1<? super String, Unit> function3;
        final AiCenterViewFactory aiCenterViewFactory3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final AiCenterViewFactory aiCenterViewFactory4;
        final AiCenterLaunchMode aiCenterLaunchMode4;
        final HostSurface hostSurface3;
        final Function1<? super String, Unit> function4;
        Function0<Unit> function5;
        final Store<BoxAiHomeReducer.State, BoxAiHomeReducer.Action> store;
        int i14;
        final Density density;
        final int bottom;
        Object objRememberedValue;
        final MutableDoubleState mutableDoubleState;
        boolean z2;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChanged;
        Object objRememberedValue3;
        Function0<ComposeUiNode> constructor;
        AiCenterLaunchMode aiCenterLaunchMode5;
        final Activity activity;
        Object objRememberedValue4;
        final CoroutineScope coroutineScope;
        Object objRememberedValue5;
        final MutableState mutableState;
        Object objRememberedValue6;
        final MutableState mutableState2;
        Object objRememberedValue7;
        final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult;
        Object objRememberedValue8;
        final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2;
        boolean zChangedInstance2;
        Object objRememberedValue9;
        Function1<? super ContentPickerListener, Unit> function6;
        boolean z3;
        boolean zChangedInstance3;
        Object objRememberedValue10;
        Function1<? super PreviewRequest, Unit> function7;
        boolean z4;
        boolean z5;
        Object objRememberedValue11;
        Function1<? super String, Unit> function8;
        Object objRememberedValue12;
        Object objRememberedValue13;
        int i15;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(355255858);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiHomeScreen)N(intentServices,modifier,aiCenterViewFactory,launchMode,hostSurface,previewLauncher,snackbarHostState,viewModel,onSessionChanged,onClose)65@3128L3,66@3159L3,69@3230L7,70@3276L14,71@3340L38,76@3472L359,76@3457L374,86@3907L384,73@3384L4406:BoxAiHomeScreen.kt#ti6sa3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(intentServices) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i18 = i2 & 2;
        if (i18 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    aiCenterViewFactory2 = aiCenterViewFactory;
                    if (composerStartRestartGroup.changedInstance(aiCenterViewFactory2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        aiCenterLaunchMode2 = aiCenterLaunchMode;
                        if (composerStartRestartGroup.changedInstance(aiCenterLaunchMode2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        if (hostSurface == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = hostSurface.ordinal();
                        }
                        if (composerStartRestartGroup.changed(iOrdinal)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                            i17 = 131072;
                        } else {
                            i17 = 65536;
                        }
                        i3 |= i17;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changed(snackbarHostState)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i3 |= i16;
                    }
                    if ((12582912 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(viewModel)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function0)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        hostSurface2 = hostSurface;
                        function2 = function0;
                        modifier3 = modifier2;
                        aiCenterLaunchMode3 = aiCenterLaunchMode2;
                        function3 = function1;
                    } else {
                        if (i18 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            aiCenterViewFactory4 = null;
                        } else {
                            aiCenterViewFactory4 = aiCenterViewFactory2;
                        }
                        if (i6 != 0) {
                            aiCenterLaunchMode4 = null;
                        } else {
                            aiCenterLaunchMode4 = aiCenterLaunchMode2;
                        }
                        if (i8 != 0) {
                            hostSurface3 = null;
                        } else {
                            hostSurface3 = hostSurface;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue13;
                        } else {
                            function4 = function1;
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function5 = (Function0) objRememberedValue12;
                        } else {
                            function5 = function0;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                        }
                        store = viewModel.getStore();
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        i14 = i3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume;
                        bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableDoubleState = (MutableDoubleState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChanged2 = composerStartRestartGroup.changed(store);
                        Modifier modifier4 = modifier2;
                        if ((i14 & 57344) == 16384) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChangedInstance = z2 | zChanged2 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        Modifier modifierTestTag = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                        ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        zChanged = composer2.changed(bottom) | composer2.changed(density);
                        objRememberedValue3 = composer2.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag, (Function1) objRememberedValue3);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        aiCenterLaunchMode5 = aiCenterLaunchMode4;
                        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composer2.consume(localActivity);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        activity = (Activity) objConsume2;
                        ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue4 = composer2.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (activity instanceof FragmentActivity) {
                            composer2.startReplaceGroup(-186827876);
                            ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                            ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            objRememberedValue5 = composer2.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composer2.updateRememberedValue(objRememberedValue5);
                            }
                            mutableState = (MutableState) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            objRememberedValue6 = composer2.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composer2.updateRememberedValue(objRememberedValue6);
                            }
                            mutableState2 = (MutableState) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
                            ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            objRememberedValue7 = composer2.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult, (Function1) objRememberedValue7, composer2, 48);
                            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
                            ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            objRememberedValue8 = composer2.rememberedValue();
                            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult2, (Function1) objRememberedValue8, composer2, 48);
                            ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                            objRememberedValue9 = composer2.rememberedValue();
                            if (!zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue9);
                            }
                            function6 = (Function1) objRememberedValue9;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            boolean zChangedInstance4 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                            if ((i14 & 3670016) == 1048576) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            zChangedInstance3 = zChangedInstance4 | z3 | composer2.changedInstance(coroutineScope);
                            objRememberedValue10 = composer2.rememberedValue();
                            if (!zChangedInstance3 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                Function1 function9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                    }
                                };
                                composer2.updateRememberedValue(function9);
                                objRememberedValue10 = function9;
                            }
                            function7 = (Function1) objRememberedValue10;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                            boolean zChangedInstance5 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                            if ((i14 & 234881024) == 67108864) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            z5 = zChangedInstance5 | z4;
                            objRememberedValue11 = composer2.rememberedValue();
                            if (!z5 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue11);
                            }
                            function8 = (Function1) objRememberedValue11;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (aiCenterViewFactory4 == null) {
                                composer2.startReplaceGroup(-184065312);
                                composer2.endReplaceGroup();
                                aiCenterViewFactory2 = aiCenterViewFactory4;
                            } else {
                                composer2.startReplaceGroup(-283032255);
                                ComposerKt.sourceInformation(composer2, "160@7360L309");
                                aiCenterViewFactory2 = aiCenterViewFactory4;
                                aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                                composer2 = composer2;
                                composer2.endReplaceGroup();
                                Unit unit = Unit.INSTANCE;
                            }
                            composer2.endReplaceGroup();
                        } else {
                            hostSurface3 = hostSurface3;
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                            aiCenterLaunchMode5 = aiCenterLaunchMode5;
                            composer2.startReplaceGroup(-183749421);
                            composer2.endReplaceGroup();
                            BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                            Unit unit2 = Unit.INSTANCE;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function3 = function4;
                        function2 = function5;
                        modifier3 = modifier4;
                        aiCenterLaunchMode3 = aiCenterLaunchMode5;
                        hostSurface2 = hostSurface3;
                    }
                    aiCenterViewFactory3 = aiCenterViewFactory2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                aiCenterLaunchMode2 = aiCenterLaunchMode;
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (hostSurface == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = hostSurface.ordinal();
                    }
                    if (composerStartRestartGroup.changed(iOrdinal)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i3 |= i17;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changed(snackbarHostState)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i3 |= i16;
                }
                if ((12582912 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(viewModel)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    i3 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    hostSurface2 = hostSurface;
                    function2 = function0;
                    modifier3 = modifier2;
                    aiCenterLaunchMode3 = aiCenterLaunchMode2;
                    function3 = function1;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        aiCenterViewFactory4 = null;
                    } else {
                        aiCenterViewFactory4 = aiCenterViewFactory2;
                    }
                    if (i6 != 0) {
                        aiCenterLaunchMode4 = null;
                    } else {
                        aiCenterLaunchMode4 = aiCenterLaunchMode2;
                    }
                    if (i8 != 0) {
                        hostSurface3 = null;
                    } else {
                        hostSurface3 = hostSurface;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue13;
                    } else {
                        function4 = function1;
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = (Function0) objRememberedValue12;
                    } else {
                        function5 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                    }
                    store = viewModel.getStore();
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    i14 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume3;
                    bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableDoubleState = (MutableDoubleState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChanged3 = composerStartRestartGroup.changed(store);
                    Modifier modifier5 = modifier2;
                    if ((i14 & 57344) == 16384) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance = z2 | zChanged3 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierTestTag2 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default2, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                    ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    zChanged = composer2.changed(bottom) | composer2.changed(density);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag2, (Function1) objRememberedValue3);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    aiCenterLaunchMode5 = aiCenterLaunchMode4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                    ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composer2.consume(localActivity2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    activity = (Activity) objConsume4;
                    ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (activity instanceof FragmentActivity) {
                        composer2.startReplaceGroup(-186827876);
                        ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                        ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue5 = composer2.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        mutableState = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue6 = composer2.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        mutableState2 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ActivityResultContracts.StartActivityForResult startActivityForResult3 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue7 = composer2.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult3, (Function1) objRememberedValue7, composer2, 48);
                        ActivityResultContracts.StartActivityForResult startActivityForResult4 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue8 = composer2.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult4, (Function1) objRememberedValue8, composer2, 48);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                        objRememberedValue9 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        function6 = (Function1) objRememberedValue9;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChangedInstance6 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                        if ((i14 & 3670016) == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChangedInstance3 = zChangedInstance6 | z3 | composer2.changedInstance(coroutineScope);
                        objRememberedValue10 = composer2.rememberedValue();
                        if (!zChangedInstance3) {
                            Function1 function10 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                }
                            };
                            composer2.updateRememberedValue(function10);
                            objRememberedValue10 = function10;
                        } else {
                            Function1 function11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                }
                            };
                            composer2.updateRememberedValue(function11);
                            objRememberedValue10 = function11;
                        }
                        function7 = (Function1) objRememberedValue10;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChangedInstance7 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                        if ((i14 & 234881024) == 67108864) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = zChangedInstance7 | z4;
                        objRememberedValue11 = composer2.rememberedValue();
                        if (!z5) {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        }
                        function8 = (Function1) objRememberedValue11;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (aiCenterViewFactory4 == null) {
                            composer2.startReplaceGroup(-184065312);
                            composer2.endReplaceGroup();
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                        } else {
                            composer2.startReplaceGroup(-283032255);
                            ComposerKt.sourceInformation(composer2, "160@7360L309");
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                            aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                            composer2 = composer2;
                            composer2.endReplaceGroup();
                            Unit unit3 = Unit.INSTANCE;
                        }
                        composer2.endReplaceGroup();
                    } else {
                        hostSurface3 = hostSurface3;
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                        aiCenterLaunchMode5 = aiCenterLaunchMode5;
                        composer2.startReplaceGroup(-183749421);
                        composer2.endReplaceGroup();
                        BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                        Unit unit4 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    function2 = function5;
                    modifier3 = modifier5;
                    aiCenterLaunchMode3 = aiCenterLaunchMode5;
                    hostSurface2 = hostSurface3;
                }
                aiCenterViewFactory3 = aiCenterViewFactory2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            aiCenterViewFactory2 = aiCenterViewFactory;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    aiCenterLaunchMode2 = aiCenterLaunchMode;
                    if (composerStartRestartGroup.changedInstance(aiCenterLaunchMode2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (hostSurface == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = hostSurface.ordinal();
                    }
                    if (composerStartRestartGroup.changed(iOrdinal)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i3 |= i17;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changed(snackbarHostState)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i3 |= i16;
                }
                if ((12582912 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(viewModel)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    i3 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    hostSurface2 = hostSurface;
                    function2 = function0;
                    modifier3 = modifier2;
                    aiCenterLaunchMode3 = aiCenterLaunchMode2;
                    function3 = function1;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        aiCenterViewFactory4 = null;
                    } else {
                        aiCenterViewFactory4 = aiCenterViewFactory2;
                    }
                    if (i6 != 0) {
                        aiCenterLaunchMode4 = null;
                    } else {
                        aiCenterLaunchMode4 = aiCenterLaunchMode2;
                    }
                    if (i8 != 0) {
                        hostSurface3 = null;
                    } else {
                        hostSurface3 = hostSurface;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue13;
                    } else {
                        function4 = function1;
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = (Function0) objRememberedValue12;
                    } else {
                        function5 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                    }
                    store = viewModel.getStore();
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    i14 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume5;
                    bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableDoubleState = (MutableDoubleState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChanged4 = composerStartRestartGroup.changed(store);
                    Modifier modifier6 = modifier2;
                    if ((i14 & 57344) == 16384) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance = z2 | zChanged4 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierTestTag3 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default3, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                    ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    zChanged = composer2.changed(bottom) | composer2.changed(density);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag3, (Function1) objRememberedValue3);
                    Alignment center3 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    aiCenterLaunchMode5 = aiCenterLaunchMode4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer2);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                    ProvidableCompositionLocal<Activity> localActivity3 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composer2.consume(localActivity3);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    activity = (Activity) objConsume6;
                    ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (activity instanceof FragmentActivity) {
                        composer2.startReplaceGroup(-186827876);
                        ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                        ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue5 = composer2.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        mutableState = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue6 = composer2.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        mutableState2 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ActivityResultContracts.StartActivityForResult startActivityForResult5 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue7 = composer2.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult5, (Function1) objRememberedValue7, composer2, 48);
                        ActivityResultContracts.StartActivityForResult startActivityForResult6 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue8 = composer2.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult6, (Function1) objRememberedValue8, composer2, 48);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                        objRememberedValue9 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        function6 = (Function1) objRememberedValue9;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChangedInstance8 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                        if ((i14 & 3670016) == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChangedInstance3 = zChangedInstance8 | z3 | composer2.changedInstance(coroutineScope);
                        objRememberedValue10 = composer2.rememberedValue();
                        if (!zChangedInstance3) {
                            Function1 function12 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                }
                            };
                            composer2.updateRememberedValue(function12);
                            objRememberedValue10 = function12;
                        } else {
                            Function1 function13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                }
                            };
                            composer2.updateRememberedValue(function13);
                            objRememberedValue10 = function13;
                        }
                        function7 = (Function1) objRememberedValue10;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChangedInstance9 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                        if ((i14 & 234881024) == 67108864) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = zChangedInstance9 | z4;
                        objRememberedValue11 = composer2.rememberedValue();
                        if (!z5) {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        }
                        function8 = (Function1) objRememberedValue11;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (aiCenterViewFactory4 == null) {
                            composer2.startReplaceGroup(-184065312);
                            composer2.endReplaceGroup();
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                        } else {
                            composer2.startReplaceGroup(-283032255);
                            ComposerKt.sourceInformation(composer2, "160@7360L309");
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                            aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                            composer2 = composer2;
                            composer2.endReplaceGroup();
                            Unit unit5 = Unit.INSTANCE;
                        }
                        composer2.endReplaceGroup();
                    } else {
                        hostSurface3 = hostSurface3;
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                        aiCenterLaunchMode5 = aiCenterLaunchMode5;
                        composer2.startReplaceGroup(-183749421);
                        composer2.endReplaceGroup();
                        BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                        Unit unit6 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    function2 = function5;
                    modifier3 = modifier6;
                    aiCenterLaunchMode3 = aiCenterLaunchMode5;
                    hostSurface2 = hostSurface3;
                }
                aiCenterViewFactory3 = aiCenterViewFactory2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            aiCenterLaunchMode2 = aiCenterLaunchMode;
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                if (hostSurface == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = hostSurface.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i3 |= i17;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(snackbarHostState)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i3 |= i16;
            }
            if ((12582912 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(viewModel)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            i12 = i2 & 512;
            if (i12 != 0) {
                i3 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                hostSurface2 = hostSurface;
                function2 = function0;
                modifier3 = modifier2;
                aiCenterLaunchMode3 = aiCenterLaunchMode2;
                function3 = function1;
            } else {
                if (i18 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    aiCenterViewFactory4 = null;
                } else {
                    aiCenterViewFactory4 = aiCenterViewFactory2;
                }
                if (i6 != 0) {
                    aiCenterLaunchMode4 = null;
                } else {
                    aiCenterLaunchMode4 = aiCenterLaunchMode2;
                }
                if (i8 != 0) {
                    hostSurface3 = null;
                } else {
                    hostSurface3 = hostSurface;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue13;
                } else {
                    function4 = function1;
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = (Function0) objRememberedValue12;
                } else {
                    function5 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                }
                store = viewModel.getStore();
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                i14 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume7;
                bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableDoubleState = (MutableDoubleState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(store);
                Modifier modifier7 = modifier2;
                if ((i14 & 57344) == 16384) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | zChanged5 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                Modifier modifierTestTag4 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default4, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                zChanged = composer2.changed(bottom) | composer2.changed(density);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierOnGloballyPositioned4 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag4, (Function1) objRememberedValue3);
                Alignment center4 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                aiCenterLaunchMode5 = aiCenterLaunchMode4;
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                ProvidableCompositionLocal<Activity> localActivity4 = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composer2.consume(localActivity4);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                activity = (Activity) objConsume8;
                ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (activity instanceof FragmentActivity) {
                    composer2.startReplaceGroup(-186827876);
                    ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                    ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    mutableState = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue6 = composer2.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState2 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ActivityResultContracts.StartActivityForResult startActivityForResult7 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue7 = composer2.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult7, (Function1) objRememberedValue7, composer2, 48);
                    ActivityResultContracts.StartActivityForResult startActivityForResult8 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue8 = composer2.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult8, (Function1) objRememberedValue8, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                    objRememberedValue9 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    function6 = (Function1) objRememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChangedInstance10 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                    if ((i14 & 3670016) == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChangedInstance3 = zChangedInstance10 | z3 | composer2.changedInstance(coroutineScope);
                    objRememberedValue10 = composer2.rememberedValue();
                    if (!zChangedInstance3) {
                        Function1 function14 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                            }
                        };
                        composer2.updateRememberedValue(function14);
                        objRememberedValue10 = function14;
                    } else {
                        Function1 function15 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                            }
                        };
                        composer2.updateRememberedValue(function15);
                        objRememberedValue10 = function15;
                    }
                    function7 = (Function1) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChangedInstance11 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                    if ((i14 & 234881024) == 67108864) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 = zChangedInstance11 | z4;
                    objRememberedValue11 = composer2.rememberedValue();
                    if (!z5) {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    function8 = (Function1) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (aiCenterViewFactory4 == null) {
                        composer2.startReplaceGroup(-184065312);
                        composer2.endReplaceGroup();
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                    } else {
                        composer2.startReplaceGroup(-283032255);
                        ComposerKt.sourceInformation(composer2, "160@7360L309");
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                        aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                        composer2 = composer2;
                        composer2.endReplaceGroup();
                        Unit unit7 = Unit.INSTANCE;
                    }
                    composer2.endReplaceGroup();
                } else {
                    hostSurface3 = hostSurface3;
                    aiCenterViewFactory2 = aiCenterViewFactory4;
                    aiCenterLaunchMode5 = aiCenterLaunchMode5;
                    composer2.startReplaceGroup(-183749421);
                    composer2.endReplaceGroup();
                    BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                    Unit unit8 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                function2 = function5;
                modifier3 = modifier7;
                aiCenterLaunchMode3 = aiCenterLaunchMode5;
                hostSurface2 = hostSurface3;
            }
            aiCenterViewFactory3 = aiCenterViewFactory2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                aiCenterViewFactory2 = aiCenterViewFactory;
                if (composerStartRestartGroup.changedInstance(aiCenterViewFactory2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    aiCenterLaunchMode2 = aiCenterLaunchMode;
                    if (composerStartRestartGroup.changedInstance(aiCenterLaunchMode2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (hostSurface == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = hostSurface.ordinal();
                    }
                    if (composerStartRestartGroup.changed(iOrdinal)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                        i17 = 131072;
                    } else {
                        i17 = 65536;
                    }
                    i3 |= i17;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changed(snackbarHostState)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i3 |= i16;
                }
                if ((12582912 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(viewModel)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    i3 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    hostSurface2 = hostSurface;
                    function2 = function0;
                    modifier3 = modifier2;
                    aiCenterLaunchMode3 = aiCenterLaunchMode2;
                    function3 = function1;
                } else {
                    if (i18 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        aiCenterViewFactory4 = null;
                    } else {
                        aiCenterViewFactory4 = aiCenterViewFactory2;
                    }
                    if (i6 != 0) {
                        aiCenterLaunchMode4 = null;
                    } else {
                        aiCenterLaunchMode4 = aiCenterLaunchMode2;
                    }
                    if (i8 != 0) {
                        hostSurface3 = null;
                    } else {
                        hostSurface3 = hostSurface;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue13;
                    } else {
                        function4 = function1;
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function5 = (Function0) objRememberedValue12;
                    } else {
                        function5 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                    }
                    store = viewModel.getStore();
                    ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                    i14 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localDensity5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume9;
                    bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableDoubleState = (MutableDoubleState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChanged6 = composerStartRestartGroup.changed(store);
                    Modifier modifier8 = modifier2;
                    if ((i14 & 57344) == 16384) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance = z2 | zChanged6 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierTestTag5 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default5, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                    ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    zChanged = composer2.changed(bottom) | composer2.changed(density);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierOnGloballyPositioned5 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag5, (Function1) objRememberedValue3);
                    Alignment center5 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned5);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    aiCenterLaunchMode5 = aiCenterLaunchMode4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composer2);
                    Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                    ProvidableCompositionLocal<Activity> localActivity5 = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composer2.consume(localActivity5);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    activity = (Activity) objConsume10;
                    ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (activity instanceof FragmentActivity) {
                        composer2.startReplaceGroup(-186827876);
                        ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                        ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue5 = composer2.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        mutableState = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue6 = composer2.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        mutableState2 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ActivityResultContracts.StartActivityForResult startActivityForResult9 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue7 = composer2.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult9, (Function1) objRememberedValue7, composer2, 48);
                        ActivityResultContracts.StartActivityForResult startActivityForResult10 = new ActivityResultContracts.StartActivityForResult();
                        ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        objRememberedValue8 = composer2.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult10, (Function1) objRememberedValue8, composer2, 48);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                        objRememberedValue9 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        function6 = (Function1) objRememberedValue9;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChangedInstance12 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                        if ((i14 & 3670016) == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zChangedInstance3 = zChangedInstance12 | z3 | composer2.changedInstance(coroutineScope);
                        objRememberedValue10 = composer2.rememberedValue();
                        if (!zChangedInstance3) {
                            Function1 function16 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                }
                            };
                            composer2.updateRememberedValue(function16);
                            objRememberedValue10 = function16;
                        } else {
                            Function1 function17 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                                }
                            };
                            composer2.updateRememberedValue(function17);
                            objRememberedValue10 = function17;
                        }
                        function7 = (Function1) objRememberedValue10;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                        boolean zChangedInstance13 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                        if ((i14 & 234881024) == 67108864) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = zChangedInstance13 | z4;
                        objRememberedValue11 = composer2.rememberedValue();
                        if (!z5) {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        } else {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        }
                        function8 = (Function1) objRememberedValue11;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (aiCenterViewFactory4 == null) {
                            composer2.startReplaceGroup(-184065312);
                            composer2.endReplaceGroup();
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                        } else {
                            composer2.startReplaceGroup(-283032255);
                            ComposerKt.sourceInformation(composer2, "160@7360L309");
                            aiCenterViewFactory2 = aiCenterViewFactory4;
                            aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                            composer2 = composer2;
                            composer2.endReplaceGroup();
                            Unit unit9 = Unit.INSTANCE;
                        }
                        composer2.endReplaceGroup();
                    } else {
                        hostSurface3 = hostSurface3;
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                        aiCenterLaunchMode5 = aiCenterLaunchMode5;
                        composer2.startReplaceGroup(-183749421);
                        composer2.endReplaceGroup();
                        BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                        Unit unit10 = Unit.INSTANCE;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function4;
                    function2 = function5;
                    modifier3 = modifier8;
                    aiCenterLaunchMode3 = aiCenterLaunchMode5;
                    hostSurface2 = hostSurface3;
                }
                aiCenterViewFactory3 = aiCenterViewFactory2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            aiCenterLaunchMode2 = aiCenterLaunchMode;
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                if (hostSurface == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = hostSurface.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i3 |= i17;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(snackbarHostState)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i3 |= i16;
            }
            if ((12582912 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(viewModel)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            i12 = i2 & 512;
            if (i12 != 0) {
                i3 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                hostSurface2 = hostSurface;
                function2 = function0;
                modifier3 = modifier2;
                aiCenterLaunchMode3 = aiCenterLaunchMode2;
                function3 = function1;
            } else {
                if (i18 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    aiCenterViewFactory4 = null;
                } else {
                    aiCenterViewFactory4 = aiCenterViewFactory2;
                }
                if (i6 != 0) {
                    aiCenterLaunchMode4 = null;
                } else {
                    aiCenterLaunchMode4 = aiCenterLaunchMode2;
                }
                if (i8 != 0) {
                    hostSurface3 = null;
                } else {
                    hostSurface3 = hostSurface;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue13;
                } else {
                    function4 = function1;
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = (Function0) objRememberedValue12;
                } else {
                    function5 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                }
                store = viewModel.getStore();
                ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                i14 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localDensity6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume11;
                bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableDoubleState = (MutableDoubleState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                boolean zChanged7 = composerStartRestartGroup.changed(store);
                Modifier modifier9 = modifier2;
                if ((i14 & 57344) == 16384) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | zChanged7 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                Modifier modifierTestTag6 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default6, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                zChanged = composer2.changed(bottom) | composer2.changed(density);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierOnGloballyPositioned6 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag6, (Function1) objRememberedValue3);
                Alignment center6 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned6);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                aiCenterLaunchMode5 = aiCenterLaunchMode4;
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                ProvidableCompositionLocal<Activity> localActivity6 = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composer2.consume(localActivity6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                activity = (Activity) objConsume12;
                ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (activity instanceof FragmentActivity) {
                    composer2.startReplaceGroup(-186827876);
                    ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                    ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    mutableState = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue6 = composer2.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState2 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ActivityResultContracts.StartActivityForResult startActivityForResult11 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue7 = composer2.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult11, (Function1) objRememberedValue7, composer2, 48);
                    ActivityResultContracts.StartActivityForResult startActivityForResult12 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue8 = composer2.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult12, (Function1) objRememberedValue8, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                    objRememberedValue9 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    function6 = (Function1) objRememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChangedInstance14 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                    if ((i14 & 3670016) == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChangedInstance3 = zChangedInstance14 | z3 | composer2.changedInstance(coroutineScope);
                    objRememberedValue10 = composer2.rememberedValue();
                    if (!zChangedInstance3) {
                        Function1 function18 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                            }
                        };
                        composer2.updateRememberedValue(function18);
                        objRememberedValue10 = function18;
                    } else {
                        Function1 function19 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                            }
                        };
                        composer2.updateRememberedValue(function19);
                        objRememberedValue10 = function19;
                    }
                    function7 = (Function1) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChangedInstance15 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                    if ((i14 & 234881024) == 67108864) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 = zChangedInstance15 | z4;
                    objRememberedValue11 = composer2.rememberedValue();
                    if (!z5) {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    function8 = (Function1) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (aiCenterViewFactory4 == null) {
                        composer2.startReplaceGroup(-184065312);
                        composer2.endReplaceGroup();
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                    } else {
                        composer2.startReplaceGroup(-283032255);
                        ComposerKt.sourceInformation(composer2, "160@7360L309");
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                        aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                        composer2 = composer2;
                        composer2.endReplaceGroup();
                        Unit unit11 = Unit.INSTANCE;
                    }
                    composer2.endReplaceGroup();
                } else {
                    hostSurface3 = hostSurface3;
                    aiCenterViewFactory2 = aiCenterViewFactory4;
                    aiCenterLaunchMode5 = aiCenterLaunchMode5;
                    composer2.startReplaceGroup(-183749421);
                    composer2.endReplaceGroup();
                    BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                    Unit unit12 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                function2 = function5;
                modifier3 = modifier9;
                aiCenterLaunchMode3 = aiCenterLaunchMode5;
                hostSurface2 = hostSurface3;
            }
            aiCenterViewFactory3 = aiCenterViewFactory2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        aiCenterViewFactory2 = aiCenterViewFactory;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                aiCenterLaunchMode2 = aiCenterLaunchMode;
                if (composerStartRestartGroup.changedInstance(aiCenterLaunchMode2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                if (hostSurface == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = hostSurface.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                    i17 = 131072;
                } else {
                    i17 = 65536;
                }
                i3 |= i17;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changed(snackbarHostState)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i3 |= i16;
            }
            if ((12582912 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(viewModel)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            i12 = i2 & 512;
            if (i12 != 0) {
                i3 |= 805306368;
            } else if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                hostSurface2 = hostSurface;
                function2 = function0;
                modifier3 = modifier2;
                aiCenterLaunchMode3 = aiCenterLaunchMode2;
                function3 = function1;
            } else {
                if (i18 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    aiCenterViewFactory4 = null;
                } else {
                    aiCenterViewFactory4 = aiCenterViewFactory2;
                }
                if (i6 != 0) {
                    aiCenterLaunchMode4 = null;
                } else {
                    aiCenterLaunchMode4 = aiCenterLaunchMode2;
                }
                if (i8 != 0) {
                    hostSurface3 = null;
                } else {
                    hostSurface3 = hostSurface;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue13;
                } else {
                    function4 = function1;
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function5 = (Function0) objRememberedValue12;
                } else {
                    function5 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
                }
                store = viewModel.getStore();
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                i14 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume13;
                bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableDoubleState = (MutableDoubleState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                boolean zChanged8 = composerStartRestartGroup.changed(store);
                Modifier modifier10 = modifier2;
                if ((i14 & 57344) == 16384) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChangedInstance = z2 | zChanged8 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                Modifier modifierTestTag7 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default7, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
                ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                zChanged = composer2.changed(bottom) | composer2.changed(density);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierOnGloballyPositioned7 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag7, (Function1) objRememberedValue3);
                Alignment center7 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                aiCenterLaunchMode5 = aiCenterLaunchMode4;
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
                ProvidableCompositionLocal<Activity> localActivity7 = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composer2.consume(localActivity7);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                activity = (Activity) objConsume14;
                ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (activity instanceof FragmentActivity) {
                    composer2.startReplaceGroup(-186827876);
                    ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                    ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    mutableState = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue6 = composer2.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState2 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ActivityResultContracts.StartActivityForResult startActivityForResult13 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue7 = composer2.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult13, (Function1) objRememberedValue7, composer2, 48);
                    ActivityResultContracts.StartActivityForResult startActivityForResult14 = new ActivityResultContracts.StartActivityForResult();
                    ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    objRememberedValue8 = composer2.rememberedValue();
                    if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult14, (Function1) objRememberedValue8, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                    objRememberedValue9 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    function6 = (Function1) objRememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChangedInstance16 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                    if ((i14 & 3670016) == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChangedInstance3 = zChangedInstance16 | z3 | composer2.changedInstance(coroutineScope);
                    objRememberedValue10 = composer2.rememberedValue();
                    if (!zChangedInstance3) {
                        Function1 function110 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                            }
                        };
                        composer2.updateRememberedValue(function110);
                        objRememberedValue10 = function110;
                    } else {
                        Function1 function111 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                            }
                        };
                        composer2.updateRememberedValue(function111);
                        objRememberedValue10 = function111;
                    }
                    function7 = (Function1) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                    boolean zChangedInstance17 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                    if ((i14 & 234881024) == 67108864) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 = zChangedInstance17 | z4;
                    objRememberedValue11 = composer2.rememberedValue();
                    if (!z5) {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    function8 = (Function1) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (aiCenterViewFactory4 == null) {
                        composer2.startReplaceGroup(-184065312);
                        composer2.endReplaceGroup();
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                    } else {
                        composer2.startReplaceGroup(-283032255);
                        ComposerKt.sourceInformation(composer2, "160@7360L309");
                        aiCenterViewFactory2 = aiCenterViewFactory4;
                        aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                        composer2 = composer2;
                        composer2.endReplaceGroup();
                        Unit unit13 = Unit.INSTANCE;
                    }
                    composer2.endReplaceGroup();
                } else {
                    hostSurface3 = hostSurface3;
                    aiCenterViewFactory2 = aiCenterViewFactory4;
                    aiCenterLaunchMode5 = aiCenterLaunchMode5;
                    composer2.startReplaceGroup(-183749421);
                    composer2.endReplaceGroup();
                    BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                    Unit unit14 = Unit.INSTANCE;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
                function2 = function5;
                modifier3 = modifier10;
                aiCenterLaunchMode3 = aiCenterLaunchMode5;
                hostSurface2 = hostSurface3;
            }
            aiCenterViewFactory3 = aiCenterViewFactory2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        aiCenterLaunchMode2 = aiCenterLaunchMode;
        i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            if (hostSurface == null) {
                iOrdinal = -1;
            } else {
                iOrdinal = hostSurface.ordinal();
            }
            if (composerStartRestartGroup.changed(iOrdinal)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(previewLauncher)) {
                i17 = 131072;
            } else {
                i17 = 65536;
            }
            i3 |= i17;
        }
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changed(snackbarHostState)) {
                i16 = 1048576;
            } else {
                i16 = 524288;
            }
            i3 |= i16;
        }
        if ((12582912 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(viewModel)) {
                i15 = 8388608;
            } else {
                i15 = 4194304;
            }
            i3 |= i15;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        i12 = i2 & 512;
        if (i12 != 0) {
            i3 |= 805306368;
        } else if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i13 = 268435456;
            }
            i3 |= i13;
        }
        if ((i3 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            hostSurface2 = hostSurface;
            function2 = function0;
            modifier3 = modifier2;
            aiCenterLaunchMode3 = aiCenterLaunchMode2;
            function3 = function1;
        } else {
            if (i18 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i4 != 0) {
                aiCenterViewFactory4 = null;
            } else {
                aiCenterViewFactory4 = aiCenterViewFactory2;
            }
            if (i6 != 0) {
                aiCenterLaunchMode4 = null;
            } else {
                aiCenterLaunchMode4 = aiCenterLaunchMode2;
            }
            if (i8 != 0) {
                hostSurface3 = null;
            } else {
                hostSurface3 = hostSurface;
            }
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098475509, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$0$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function4 = (Function1) objRememberedValue13;
            } else {
                function4 = function1;
            }
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098476501, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function5 = (Function0) objRememberedValue12;
            } else {
                function5 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(355255858, i3, -1, "com.box.android.boxai.homescreen.BoxAiHomeScreen (BoxAiHomeScreen.kt:67)");
            }
            store = viewModel.getStore();
            ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
            i14 = i3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume15 = composerStartRestartGroup.consume(localDensity8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume15;
            bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098482328, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotDoubleStateKt.mutableDoubleStateOf(0.0d);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableDoubleState = (MutableDoubleState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2098486873, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
            boolean zChanged9 = composerStartRestartGroup.changed(store);
            Modifier modifier11 = modifier2;
            if ((i14 & 57344) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChangedInstance = z2 | zChanged9 | composerStartRestartGroup.changedInstance(aiCenterViewFactory4) | composerStartRestartGroup.changedInstance(aiCenterLaunchMode4);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$5$0(store, hostSurface3, aiCenterViewFactory4, aiCenterLaunchMode4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            Modifier modifierTestTag8 = TestTagKt.testTag(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default8, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), "BoxAi:HomeScreen");
            ComposerKt.sourceInformationMarkerStart(composer2, 2098500818, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
            zChanged = composer2.changed(bottom) | composer2.changed(density);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$6$0(bottom, density, mutableDoubleState, (LayoutCoordinates) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierOnGloballyPositioned8 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifierTestTag8, (Function1) objRememberedValue3);
            Alignment center8 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierOnGloballyPositioned8);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            aiCenterLaunchMode5 = aiCenterLaunchMode4;
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -186951472, "C94@4381L7,95@4418L24:BoxAiHomeScreen.kt#ti6sa3");
            ProvidableCompositionLocal<Activity> localActivity8 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume16 = composer2.consume(localActivity8);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            activity = (Activity) objConsume16;
            ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue4 = composer2.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (activity instanceof FragmentActivity) {
                composer2.startReplaceGroup(-186827876);
                ComposerKt.sourceInformation(composer2, "98@4528L57,99@4626L50,108@5000L433,106@4875L558,121@5602L61,119@5477L186,125@5734L764,141@6555L526,153@7135L190");
                ComposerKt.sourceInformationMarkerStart(composer2, -283123131, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue5 = composer2.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                mutableState = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -283120002, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue6 = composer2.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                mutableState2 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ActivityResultContracts.StartActivityForResult startActivityForResult15 = new ActivityResultContracts.StartActivityForResult();
                ComposerKt.sourceInformationMarkerStart(composer2, -283107651, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0(mutableState, (ActivityResult) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult15, (Function1) objRememberedValue7, composer2, 48);
                ActivityResultContracts.StartActivityForResult startActivityForResult16 = new ActivityResultContracts.StartActivityForResult();
                ComposerKt.sourceInformationMarkerStart(composer2, -283088759, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                objRememberedValue8 = composer2.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$7$0(mutableState2, (ActivityResult) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                managedActivityResultLauncherRememberLauncherForActivityResult2 = ActivityResultRegistryKt.rememberLauncherForActivityResult(startActivityForResult16, (Function1) objRememberedValue8, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -283083832, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance(intentServices) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                objRememberedValue9 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$8$0(intentServices, activity, managedActivityResultLauncherRememberLauncherForActivityResult, mutableState, (ContentPickerListener) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                function6 = (Function1) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -283057798, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                boolean zChangedInstance18 = composer2.changedInstance(previewLauncher) | composer2.changedInstance(activity) | composer2.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2);
                if ((i14 & 3670016) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChangedInstance3 = zChangedInstance18 | z3 | composer2.changedInstance(coroutineScope);
                objRememberedValue10 = composer2.rememberedValue();
                if (!zChangedInstance3) {
                    Function1 function112 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                        }
                    };
                    composer2.updateRememberedValue(function112);
                    objRememberedValue10 = function112;
                } else {
                    Function1 function113 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$9$0(previewLauncher, activity, managedActivityResultLauncherRememberLauncherForActivityResult2, snackbarHostState, coroutineScope, mutableState2, (PreviewRequest) obj);
                        }
                    };
                    composer2.updateRememberedValue(function113);
                    objRememberedValue10 = function113;
                }
                function7 = (Function1) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -283039574, "CC(remember):BoxAiHomeScreen.kt#9igjgp");
                boolean zChangedInstance19 = composer2.changedInstance(coroutineScope) | composer2.changed(r29);
                if ((i14 & 234881024) == 67108864) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                z5 = zChangedInstance19 | z4;
                objRememberedValue11 = composer2.rememberedValue();
                if (!z5) {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$10$0(coroutineScope, store, function4, (String) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                function8 = (Function1) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (aiCenterViewFactory4 == null) {
                    composer2.startReplaceGroup(-184065312);
                    composer2.endReplaceGroup();
                    aiCenterViewFactory2 = aiCenterViewFactory4;
                } else {
                    composer2.startReplaceGroup(-283032255);
                    ComposerKt.sourceInformation(composer2, "160@7360L309");
                    aiCenterViewFactory2 = aiCenterViewFactory4;
                    aiCenterViewFactory2.AiCenter(function6, function7, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxAiHomeScreen$lambda$3(mutableDoubleState), function8, function5, composer2, ((i14 >> 12) & 458752) | 384 | ((i14 << 12) & 3670016));
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                    Unit unit15 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
            } else {
                hostSurface3 = hostSurface3;
                aiCenterViewFactory2 = aiCenterViewFactory4;
                aiCenterLaunchMode5 = aiCenterLaunchMode5;
                composer2.startReplaceGroup(-183749421);
                composer2.endReplaceGroup();
                BoxLogUtils.e("XPlatform widgets can be used only inside FragmentActivity");
                Unit unit16 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
            function2 = function5;
            modifier3 = modifier11;
            aiCenterLaunchMode3 = aiCenterLaunchMode5;
            hostSurface2 = hostSurface3;
        }
        aiCenterViewFactory3 = aiCenterViewFactory2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$8(intentServices, modifier3, aiCenterViewFactory3, aiCenterLaunchMode3, hostSurface2, previewLauncher, snackbarHostState, viewModel, function3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final double BoxAiHomeScreen$lambda$3(MutableDoubleState mutableDoubleState) {
        return mutableDoubleState.getDoubleValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$5$0(Store store, HostSurface hostSurface, AiCenterViewFactory aiCenterViewFactory, AiCenterLaunchMode aiCenterLaunchMode) {
        StyleVariant styleVariant;
        if (hostSurface == null) {
            hostSurface = aiCenterViewFactory != null ? aiCenterViewFactory.getHostSurface() : null;
        }
        if (aiCenterLaunchMode != null) {
            styleVariant = StyleVariant.MODAL;
        } else {
            styleVariant = aiCenterViewFactory != null ? aiCenterViewFactory.getStyleVariant() : null;
        }
        store.send(new BoxAiHomeReducer.Action.ScreenViewed(hostSurface, styleVariant, aiCenterViewFactory != null ? aiCenterViewFactory.getSessionId() : null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$6$0(int i, Density density, MutableDoubleState mutableDoubleState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        mutableDoubleState.setDoubleValue(((double) Math.max(0, (((int) (LayoutCoordinatesKt.findRootCoordinates(coordinates).mo8273getSizeYbymL2g() & 4294967295L)) - ((int) (Float.intBitsToFloat((int) (LayoutCoordinatesKt.positionInRoot(coordinates) & 4294967295L)) + ((int) (4294967295L & coordinates.mo8273getSizeYbymL2g()))))) - i)) / ((double) density.getDensity()));
        return Unit.INSTANCE;
    }

    private static final ContentPickerListener BoxAiHomeScreen$lambda$7$1(MutableState<ContentPickerListener> mutableState) {
        return mutableState.getValue();
    }

    private static final PreviewRequest BoxAiHomeScreen$lambda$7$4(MutableState<PreviewRequest> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BoxAiHomeScreen$lambda$7$dismissActivePreviewRequest(MutableState<PreviewRequest> mutableState) {
        PreviewRequest previewRequestBoxAiHomeScreen$lambda$7$4 = BoxAiHomeScreen$lambda$7$4(mutableState);
        if (previewRequestBoxAiHomeScreen$lambda$7$4 != null) {
            previewRequestBoxAiHomeScreen$lambda$7$4.getOnDismiss().invoke();
        }
        mutableState.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$6$0(MutableState mutableState, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        final ContentPickerListener contentPickerListenerBoxAiHomeScreen$lambda$7$1 = BoxAiHomeScreen$lambda$7$1(mutableState);
        if (contentPickerListenerBoxAiHomeScreen$lambda$7$1 == null) {
            return Unit.INSTANCE;
        }
        handleContentPickerResult(result.getResultCode(), result.getData(), new Function1() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0$0(contentPickerListenerBoxAiHomeScreen$lambda$7$1, (List) obj);
            }
        }, new Function0() { // from class: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BoxAiHomeScreenKt.BoxAiHomeScreen$lambda$7$6$0$1(contentPickerListenerBoxAiHomeScreen$lambda$7$1);
            }
        });
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$6$0$0(ContentPickerListener contentPickerListener, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        contentPickerListener.getOnResult().invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$6$0$1(ContentPickerListener contentPickerListener) {
        contentPickerListener.getOnCancel().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$7$0(MutableState mutableState, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BoxAiHomeScreen$lambda$7$dismissActivePreviewRequest(mutableState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$8$0(IntentServices intentServices, Activity activity, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState, ContentPickerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        mutableState.setValue(listener);
        List<ItemInfo> currentItems = listener.getCurrentItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(currentItems, 10));
        for (ItemInfo itemInfo : currentItems) {
            String id = itemInfo.getId().getId();
            String name = itemInfo.getName();
            String lowerCase = itemInfo.getId().getType().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(new SelectionItemInfo(id, name, lowerCase, itemInfo.getSharedLink(), itemInfo.getBoxId(), null, 32, null));
        }
        Intent intentContentPickerActivityIntent = intentServices.contentPickerActivityIntent(activity);
        intentContentPickerActivityIntent.putParcelableArrayListExtra(ContentPickerConstants.EXTRA_INITIAL_SELECTIONS, new ArrayList<>(arrayList));
        managedActivityResultLauncher.launch(intentContentPickerActivityIntent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$9$0(IPreviewLauncher iPreviewLauncher, Activity activity, ManagedActivityResultLauncher managedActivityResultLauncher, SnackbarHostState snackbarHostState, CoroutineScope coroutineScope, MutableState mutableState, PreviewRequest previewRequest) {
        Intrinsics.checkNotNullParameter(previewRequest, "previewRequest");
        mutableState.setValue(previewRequest);
        openPreview(previewRequest, iPreviewLauncher, (FragmentActivity) activity, managedActivityResultLauncher, snackbarHostState, new BoxAiHomeScreenKt$BoxAiHomeScreen$5$showPreview$1$1$1(mutableState), coroutineScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiHomeScreen$lambda$7$10$0(CoroutineScope coroutineScope, Store store, Function1 function1, String str) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new BoxAiHomeScreenKt$BoxAiHomeScreen$5$onSessionChange$1$1$1(store, str, function1, null), 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.boxai.homescreen.BoxAiHomeScreenKt$openPreview$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiHomeScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.homescreen.BoxAiHomeScreenKt$openPreview$1", f = "BoxAiHomeScreen.kt", i = {1, 1, 1, 1}, l = {PsExtractor.PRIVATE_STREAM_1, 197}, m = "invokeSuspend", n = {"$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-BoxAiHomeScreenKt$openPreview$1$1"}, s = {"L$0", "L$2", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $boxId;
        final /* synthetic */ FragmentActivity $context;
        final /* synthetic */ Function0<Unit> $onDismiss;
        final /* synthetic */ ActivityResultLauncher<Intent> $previewActivityLauncher;
        final /* synthetic */ IPreviewLauncher $previewLauncher;
        final /* synthetic */ PreviewRequest $previewRequest;
        final /* synthetic */ SnackbarHostState $snackbarHostState;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IPreviewLauncher iPreviewLauncher, String str, FragmentActivity fragmentActivity, PreviewRequest previewRequest, ActivityResultLauncher<Intent> activityResultLauncher, SnackbarHostState snackbarHostState, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$previewLauncher = iPreviewLauncher;
            this.$boxId = str;
            this.$context = fragmentActivity;
            this.$previewRequest = previewRequest;
            this.$previewActivityLauncher = activityResultLauncher;
            this.$snackbarHostState = snackbarHostState;
            this.$onDismiss = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$previewLauncher, this.$boxId, this.$context, this.$previewRequest, this.$previewActivityLauncher, this.$snackbarHostState, this.$onDismiss, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function0<Unit> function0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = IPreviewLauncher.launchPreview$default(this.$previewLauncher, new ItemId.Remote(this.$boxId, ItemType.FILE), this.$context, PreviewSource.AICenter.INSTANCE, this.$previewRequest.getItem().getSharedLink(), this.$previewActivityLauncher, null, this, 32, null);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = (Function0) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.INSTANCE;
            Result result = (Result) obj;
            SnackbarHostState snackbarHostState = this.$snackbarHostState;
            FragmentActivity fragmentActivity = this.$context;
            Function0<Unit> function1 = this.$onDismiss;
            if (!(result instanceof Result.Success)) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                DomainError domainError = (DomainError) ((Result.Error) result).getValue();
                BoxLogUtils.e("Error opening preview from AI Center " + domainError.getMessage());
                String string = fragmentActivity.getString(R.string.box_ai_preview_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.L$0 = result;
                this.L$1 = function1;
                this.L$2 = SpillingKt.nullOutSpilledVariable(domainError);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
                if (SnackbarHostState.showSnackbar$default(snackbarHostState, string, null, false, null, this, 14, null) != coroutine_suspended) {
                    function0 = function1;
                    function0.invoke();
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void openPreview(PreviewRequest previewRequest, IPreviewLauncher previewLauncher, FragmentActivity context, ActivityResultLauncher<Intent> previewActivityLauncher, SnackbarHostState snackbarHostState, Function0<Unit> onDismiss, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(previewRequest, "previewRequest");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(previewActivityLauncher, "previewActivityLauncher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        try {
            String boxId = previewRequest.getItem().getBoxId();
            if (boxId == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(previewLauncher, boxId, context, previewRequest, previewActivityLauncher, snackbarHostState, onDismiss, null), 3, null);
        } catch (Throwable th) {
            BoxLogUtils.e("Error opening preview from AI Center " + th.getMessage(), th);
        }
    }

    public static final void handleContentPickerResult(int i, Intent intent, Function1<? super List<ItemInfo>, Unit> onResult, Function0<Unit> onCancel) {
        ArrayList arrayListEmptyList;
        com.margelo.nitro.boxcontext.ItemType itemType;
        ArrayList parcelableArrayListExtra;
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        if (i == -1) {
            if (intent != null && (parcelableArrayListExtra = IntentCompat.getParcelableArrayListExtra(intent, ContentPickerConstants.EXTRA_SELECTED_ITEMS, SelectionItemInfo.class)) != null) {
                arrayListEmptyList = parcelableArrayListExtra;
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            List<SelectionItemInfo> list = arrayListEmptyList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SelectionItemInfo selectionItemInfo : list) {
                String id = selectionItemInfo.getId();
                String upperCase = selectionItemInfo.getType().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                com.margelo.nitro.boxcontext.ItemType itemType2 = com.margelo.nitro.boxcontext.ItemType.FILE;
                com.margelo.nitro.boxcontext.ItemType[] itemTypeArrValues = com.margelo.nitro.boxcontext.ItemType.values();
                int length = itemTypeArrValues.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        itemType = null;
                        break;
                    }
                    itemType = itemTypeArrValues[i2];
                    if (StringsKt.equals(itemType.name(), upperCase, true)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                com.margelo.nitro.boxcontext.ItemType itemType3 = itemType;
                if (itemType3 != null) {
                    itemType2 = itemType3;
                }
                arrayList.add(new ItemInfo(new ItemIdentifier(id, itemType2), selectionItemInfo.getName(), selectionItemInfo.getBoxId(), selectionItemInfo.getSharedLinkUrl(), selectionItemInfo.getItemSource(), null));
            }
            onResult.invoke(arrayList);
            return;
        }
        onCancel.invoke();
    }
}

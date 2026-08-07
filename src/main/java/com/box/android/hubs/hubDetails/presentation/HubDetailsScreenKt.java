package com.box.android.hubs.hubDetails.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.webBridgeAuth.IBoxWebBridgeAuthenticator;
import com.box.android.hubs.R;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* JADX INFO: compiled from: HubDetailsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a1\u0010\t\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a5\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\\\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001b\u001a\u00020\u00162!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\u001dH\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\f\u0010\"\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010%X\u008a\u008e\u0002"}, d2 = {"HubDetailsScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "webBridgeAuthenticator", "Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;", "(Lcom/box/android/cpl/Store;Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;Landroidx/compose/runtime/Composer;I)V", "HubDetailsForm", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/cpl/Store;Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V", "HubDetailsViewEffectProcessor", GuideTransition.GUIDE_TRANSITION_EFFECT_FIELD, "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;", "webView", "Landroid/webkit/WebView;", "onProcessed", "Lkotlin/Function0;", "(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$ViewEffect;Landroid/webkit/WebView;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "message", "", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$HubDetailsError;", "(Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$HubDetailsError;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "HubDetailsWebView", HubDetailsInitialContext.HUB_ID_KEY, "hubUrl", "onWebViewCreated", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/String;Lcom/box/android/domain/webBridgeAuth/IBoxWebBridgeAuthenticator;Lcom/box/android/cpl/Store;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "hubs_generalProdRelease", "hubWebView", "state", "snackbarJob", "Lkotlinx/coroutines/Job;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsScreenKt {

    /* JADX INFO: compiled from: HubDetailsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HubDetailsReducer.HubDetailsError.values().length];
            try {
                iArr[HubDetailsReducer.HubDetailsError.WEB_LINK_LAUNCH_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsForm$lambda$9(Store store, IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, SnackbarHostState snackbarHostState, int i, Composer composer, int i2) {
        HubDetailsForm(store, iBoxWebBridgeAuthenticator, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsScreen$lambda$6(Store store, IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, int i, Composer composer, int i2) {
        HubDetailsScreen(store, iBoxWebBridgeAuthenticator, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsViewEffectProcessor$lambda$3(HubDetailsReducer.ViewEffect viewEffect, WebView webView, SnackbarHostState snackbarHostState, Function0 function0, int i, Composer composer, int i2) {
        HubDetailsViewEffectProcessor(viewEffect, webView, snackbarHostState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsViewEffectProcessor$lambda$6(HubDetailsReducer.ViewEffect viewEffect, WebView webView, SnackbarHostState snackbarHostState, Function0 function0, int i, Composer composer, int i2) {
        HubDetailsViewEffectProcessor(viewEffect, webView, snackbarHostState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsWebView$lambda$6(String str, IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, Store store, String str2, Function1 function1, int i, Composer composer, int i2) {
        HubDetailsWebView(str, iBoxWebBridgeAuthenticator, store, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HubDetailsScreen(final Store<HubDetailsReducer.State, HubDetailsReducer.Action> store, final IBoxWebBridgeAuthenticator webBridgeAuthenticator, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(webBridgeAuthenticator, "webBridgeAuthenticator");
        Composer composerStartRestartGroup = composer.startRestartGroup(1544065723);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubDetailsScreen)N(store,webBridgeAuthenticator)46@2117L63,46@2096L84,50@2198L47,50@2186L59,52@2275L32,55@2340L219,63@2584L84,66@2675L265,54@2313L627:HubDetailsScreen.kt#r6dsfu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(webBridgeAuthenticator) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1544065723, i2, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsScreen (HubDetailsScreen.kt:45)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2083448026, "CC(remember):HubDetailsScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            HubDetailsScreenKt$HubDetailsScreen$1$1 hubDetailsScreenKt$HubDetailsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || hubDetailsScreenKt$HubDetailsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                hubDetailsScreenKt$HubDetailsScreen$1$1RememberedValue = new HubDetailsScreenKt$HubDetailsScreen$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(hubDetailsScreenKt$HubDetailsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubDetailsScreenKt$HubDetailsScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2083450602, "CC(remember):HubDetailsScreen.kt#9igjgp");
            boolean z2 = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubDetailsScreenKt.HubDetailsScreen$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandlerKt.BackHandler(false, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2083453051, "CC(remember):HubDetailsScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(992401271, true, new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubDetailsScreenKt.HubDetailsScreen$lambda$3(store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(727753781, true, new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubDetailsScreenKt.HubDetailsScreen$lambda$4(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-677150516, true, new Function3() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HubDetailsScreenKt.HubDetailsScreen$lambda$5(store, webBridgeAuthenticator, snackbarHostState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805309488, 501);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubDetailsScreenKt.HubDetailsScreen$lambda$6(store, webBridgeAuthenticator, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsScreen$lambda$1$0(Store store) {
        store.send(HubDetailsReducer.Action.OnBack.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsScreen$lambda$3$0$0(Store store) {
        store.send(HubDetailsReducer.Action.OnBack.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsScreen$lambda$3(final Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C60@2506L29,57@2397L83,56@2354L195:HubDetailsScreen.kt#r6dsfu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(992401271, i, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsScreen.<anonymous> (HubDetailsScreen.kt:56)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.hubs, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 214883626, "CC(remember):HubDetailsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubDetailsScreenKt.HubDetailsScreen$lambda$3$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxSimpleTopBarKt.BoxSimpleTopBar(strStringResource, (Function0) objRememberedValue, null, false, null, composer, 0, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsScreen$lambda$4(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C64@2598L60:HubDetailsScreen.kt#r6dsfu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(727753781, i, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsScreen.<anonymous> (HubDetailsScreen.kt:64)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsScreen$lambda$5(Store store, IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, SnackbarHostState snackbarHostState, PaddingValues innerPadding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation(composer, "CN(innerPadding)67@2701L233:HubDetailsScreen.kt#r6dsfu");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(innerPadding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-677150516, i2, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsScreen.<anonymous> (HubDetailsScreen.kt:67)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, innerPadding.getTop(), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1501431695, "C72@2860L64:HubDetailsScreen.kt#r6dsfu");
            HubDetailsForm(store, iBoxWebBridgeAuthenticator, snackbarHostState, composer, 384);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [boolean, int] */
    private static final void HubDetailsForm(final Store<HubDetailsReducer.State, HubDetailsReducer.Action> store, final IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, SnackbarHostState snackbarHostState, Composer composer, final int i) {
        int i2;
        final SnackbarHostState snackbarHostState2;
        Composer composer2;
        int i3;
        int i4;
        ?? r0;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1892256677);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubDetailsForm)N(store,webBridgeAuthenticator,snackbarHostState)83@3176L45,84@3251L29,91@3491L82,87@3326L253:HubDetailsScreen.kt#r6dsfu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(iBoxWebBridgeAuthenticator) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            snackbarHostState2 = snackbarHostState;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1892256677, i2, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsForm (HubDetailsScreen.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1687493560, "CC(remember):HubDetailsScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            HubDetailsReducer.ScreenState screenState = HubDetailsForm$lambda$3(stateCollectAsStateWithLifecycle).getScreenState();
            HubDetailsReducer.ViewEffect viewEffect = HubDetailsForm$lambda$3(stateCollectAsStateWithLifecycle).getViewEffect();
            WebView webViewHubDetailsForm$lambda$1 = HubDetailsForm$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1687483443, "CC(remember):HubDetailsScreen.kt#9igjgp");
            int i5 = i2 & 14;
            boolean z = i5 == 4;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubDetailsScreenKt.HubDetailsForm$lambda$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = i2;
            HubDetailsViewEffectProcessor(viewEffect, webViewHubDetailsForm$lambda$1, snackbarHostState, (Function0) objRememberedValue2, composerStartRestartGroup, i2 & 896);
            snackbarHostState2 = snackbarHostState;
            composer2 = composerStartRestartGroup;
            boolean z2 = screenState instanceof HubDetailsReducer.ScreenState.Loaded;
            if (z2) {
                composer2.startReplaceGroup(-772213174);
                ComposerKt.sourceInformation(composer2, "102@3864L63,97@3652L285");
                String hubId = HubDetailsForm$lambda$3(stateCollectAsStateWithLifecycle).getHubId();
                String hubUrl = ((HubDetailsReducer.ScreenState.Loaded) screenState).getHubUrl();
                ComposerKt.sourceInformationMarkerStart(composer2, -1687471526, "CC(remember):HubDetailsScreen.kt#9igjgp");
                Object objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HubDetailsScreenKt.HubDetailsForm$lambda$5$0(mutableState, (WebView) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                i3 = -775845785;
                HubDetailsWebView(hubId, iBoxWebBridgeAuthenticator, store, hubUrl, (Function1) objRememberedValue3, composer2, (i6 & 112) | 24576 | ((i6 << 6) & 896));
            } else {
                i3 = -775845785;
                composer2.startReplaceGroup(-775845785);
            }
            composer2.endReplaceGroup();
            if (!(screenState instanceof HubDetailsReducer.ScreenState.Error)) {
                i4 = i3;
                r0 = 0;
                composer2.startReplaceGroup(i4);
            } else {
                composer2.startReplaceGroup(-771856426);
                ComposerKt.sourceInformation(composer2, "");
                if (DomainErrorKt.isNetworkConnectionError(((HubDetailsReducer.ScreenState.Error) screenState).getDomainError())) {
                    composer2.startReplaceGroup(-771802982);
                    ComposerKt.sourceInformation(composer2, "110@4122L47,110@4085L85");
                    ComposerKt.sourceInformationMarkerStart(composer2, -1687463286, "CC(remember):HubDetailsScreen.kt#9igjgp");
                    boolean z3 = i5 == 4;
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (z3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubDetailsScreenKt.HubDetailsForm$lambda$6$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    r0 = 0;
                    ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue4, false, composer2, 0, 2);
                    composer2.endReplaceGroup();
                    i4 = i3;
                } else {
                    r0 = 0;
                    composer2.startReplaceGroup(-771682671);
                    ComposerKt.sourceInformation(composer2, "113@4250L47,112@4200L286");
                    ComposerKt.sourceInformationMarkerStart(composer2, -1687459190, "CC(remember):HubDetailsScreen.kt#9igjgp");
                    boolean z4 = i5 == 4;
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (z4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubDetailsScreenKt.HubDetailsForm$lambda$7$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    i4 = i3;
                    ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, false, R.string.error_loading_hub, Integer.valueOf(R.string.error_loading_hub_subtitle), 0, "HubDetailsErrorScreen", composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                    composer2.endReplaceGroup();
                }
            }
            composer2.endReplaceGroup();
            if (!(screenState instanceof HubDetailsReducer.ScreenState.Initializing) && (!z2 || !((HubDetailsReducer.ScreenState.Loaded) screenState).isWebPageProcessing())) {
                composer2.startReplaceGroup(i4);
            } else {
                composer2.startReplaceGroup(-771196808);
                ComposerKt.sourceInformation(composer2, "127@4799L6,124@4686L287");
                Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11511getContentBackground0d7_KjU(), null, 2, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, r0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM589backgroundbw27NRU$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                ComposerKt.sourceInformationMarkerStart(composer2, 750128064, "C130@4898L65:HubDetailsScreen.kt#r6dsfu");
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, "HubDetailsCircularProgressBar", 0L, 0L, 0.0f, 0, null, composer2, 48, 125);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubDetailsScreenKt.HubDetailsForm$lambda$9(store, iBoxWebBridgeAuthenticator, snackbarHostState2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final WebView HubDetailsForm$lambda$1(MutableState<WebView> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsForm$lambda$4$0(Store store) {
        store.send(HubDetailsReducer.Action.OnViewEffectProcessed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsForm$lambda$5$0(MutableState mutableState, WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        mutableState.setValue(webView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsForm$lambda$6$0(Store store) {
        store.send(HubDetailsReducer.Action.Reload.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsForm$lambda$7$0(Store store) {
        store.send(HubDetailsReducer.Action.Reload.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void HubDetailsViewEffectProcessor(final HubDetailsReducer.ViewEffect viewEffect, final WebView webView, final SnackbarHostState snackbarHostState, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Function0<Unit> function1;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2137058703);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubDetailsViewEffectProcessor)N(effect,webView,snackbarHostState,onProcessed)142@5208L7,143@5239L39,144@5304L24:HubDetailsScreen.kt#r6dsfu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(viewEffect) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(webView) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function1 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2137058703, i2, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsViewEffectProcessor (HubDetailsScreen.kt:141)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -719038504, "CC(remember):HubDetailsScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!Intrinsics.areEqual(viewEffect, HubDetailsReducer.ViewEffect.None.INSTANCE)) {
                Job jobHubDetailsViewEffectProcessor$lambda$1 = HubDetailsViewEffectProcessor$lambda$1(mutableState);
                if (jobHubDetailsViewEffectProcessor$lambda$1 != null) {
                    Job.DefaultImpls.cancel$default(jobHubDetailsViewEffectProcessor$lambda$1, (CancellationException) null, 1, (Object) null);
                }
                if (viewEffect instanceof HubDetailsReducer.ViewEffect.OpenInExternalApp) {
                    composerStartRestartGroup.startReplaceGroup(-814961644);
                    composerStartRestartGroup.endReplaceGroup();
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((HubDetailsReducer.ViewEffect.OpenInExternalApp) viewEffect).getUrl())));
                } else if (viewEffect instanceof HubDetailsReducer.ViewEffect.OpenInBoxApp) {
                    composerStartRestartGroup.startReplaceGroup(-814777039);
                    composerStartRestartGroup.endReplaceGroup();
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((HubDetailsReducer.ViewEffect.OpenInBoxApp) viewEffect).getUrl()));
                    intent.setPackage(context.getPackageName());
                    context.startActivity(intent);
                } else if (viewEffect instanceof HubDetailsReducer.ViewEffect.DisplayErrorMessage) {
                    composerStartRestartGroup.startReplaceGroup(-814489514);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "166@6153L9,167@6196L152,167@6175L173");
                    String strMessage = message(((HubDetailsReducer.ViewEffect.DisplayErrorMessage) viewEffect).getError(), composerStartRestartGroup, 0);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -719007767, "CC(remember):HubDetailsScreen.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i2 & 896) == 256) | composerStartRestartGroup.changed(strMessage);
                    HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1 hubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || hubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        hubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1RememberedValue = new HubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1(coroutineScope, snackbarHostState, strMessage, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(hubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubDetailsScreenKt$HubDetailsViewEffectProcessor$2$1RememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (Intrinsics.areEqual(viewEffect, HubDetailsReducer.ViewEffect.GoBack.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-814194239);
                    composerStartRestartGroup.endReplaceGroup();
                    if (webView != null && webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        Activity activity = context instanceof Activity ? (Activity) context : null;
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                } else {
                    if (!Intrinsics.areEqual(viewEffect, HubDetailsReducer.ViewEffect.None.INSTANCE)) {
                        composerStartRestartGroup.startReplaceGroup(-719027253);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-718994027);
                    composerStartRestartGroup.endReplaceGroup();
                }
                function0.invoke();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final Function0<Unit> function3 = function1;
                function2 = new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubDetailsScreenKt.HubDetailsViewEffectProcessor$lambda$3(viewEffect, webView, snackbarHostState, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubDetailsScreenKt.HubDetailsViewEffectProcessor$lambda$6(viewEffect, webView, snackbarHostState, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final Job HubDetailsViewEffectProcessor$lambda$1(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    private static final String message(HubDetailsReducer.HubDetailsError hubDetailsError, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1598491798, "C(message):HubDetailsScreen.kt#r6dsfu");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598491798, i, -1, "com.box.android.hubs.hubDetails.presentation.message (HubDetailsScreen.kt:189)");
        }
        if (WhenMappings.$EnumSwitchMapping$0[hubDetailsError.ordinal()] != 1) {
            composer.startReplaceGroup(1447676081);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.startReplaceGroup(1447678466);
        ComposerKt.sourceInformation(composer, "190@6825L56");
        String strStringResource = StringResources_androidKt.stringResource(R.string.error_openning_hub_specific_url, composer, 0);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    private static final void HubDetailsWebView(final String str, final IBoxWebBridgeAuthenticator iBoxWebBridgeAuthenticator, final Store<HubDetailsReducer.State, HubDetailsReducer.Action> store, final String str2, final Function1<? super WebView, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2011558477);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubDetailsWebView)N(hubId,webBridgeAuthenticator,store,hubUrl,onWebViewCreated)202@7211L76,205@7326L163,211@7513L76,215@7655L71,216@7758L7,218@7785L229,231@8155L134,227@8020L275:HubDetailsScreen.kt#r6dsfu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(iBoxWebBridgeAuthenticator) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2011558477, i2, -1, "com.box.android.hubs.hubDetails.presentation.HubDetailsWebView (HubDetailsScreen.kt:200)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372403329, "CC(remember):HubDetailsScreen.kt#9igjgp");
            int i3 = i2 & 896;
            boolean z = i3 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubDetailsScreenKt.HubDetailsWebView$lambda$0$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function2 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372399562, "CC(remember):HubDetailsScreen.kt#9igjgp");
            boolean z2 = i3 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HubDetailsScreenKt.HubDetailsWebView$lambda$1$0(store, (Uri) obj));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function3 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372393665, "CC(remember):HubDetailsScreen.kt#9igjgp");
            boolean z3 = i3 == 256;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubDetailsScreenKt.HubDetailsWebView$lambda$2$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            HubDetailsWebCallbacks hubDetailsWebCallbacks = new HubDetailsWebCallbacks(function2, function3, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372389126, "CC(remember):HubDetailsScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new HubDetailsWebViewLoader(iBoxWebBridgeAuthenticator, hubDetailsWebCallbacks);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final HubDetailsWebViewLoader hubDetailsWebViewLoader = (HubDetailsWebViewLoader) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372384808, "CC(remember):HubDetailsScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue5;
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                MAMWebView mAMWebView = new MAMWebView(context);
                mAMWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                composerStartRestartGroup.updateRememberedValue(mAMWebView);
                obj = mAMWebView;
            }
            final WebView webView = (WebView) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "HubDetailsWebView" + str);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372373063, "CC(remember):HubDetailsScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(hubDetailsWebViewLoader) | composerStartRestartGroup.changedInstance(webView) | ((i2 & 7168) == 2048) | ((i2 & 57344) == 16384);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HubDetailsScreenKt.HubDetailsWebView$lambda$5$0(hubDetailsWebViewLoader, webView, str2, function1, (Context) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue6, modifierTestTag, null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.hubDetails.presentation.HubDetailsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return HubDetailsScreenKt.HubDetailsWebView$lambda$6(str, iBoxWebBridgeAuthenticator, store, str2, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsWebView$lambda$0$0(Store store, String str) {
        store.send(HubDetailsReducer.Action.OnHubPageLoaded.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HubDetailsWebView$lambda$1$0(Store store, Uri uri) {
        if (uri == null) {
            return true;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        store.send(new HubDetailsReducer.Action.NavigateToUrl(string));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubDetailsWebView$lambda$2$0(Store store, String str) {
        store.send(HubDetailsReducer.Action.InitializeError.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView HubDetailsWebView$lambda$5$0(HubDetailsWebViewLoader hubDetailsWebViewLoader, WebView webView, String str, Function1 function1, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        hubDetailsWebViewLoader.initWebView(webView, str);
        function1.invoke(webView);
        return webView;
    }

    private static final HubDetailsReducer.State HubDetailsForm$lambda$3(State<HubDetailsReducer.State> state) {
        return state.getValue();
    }
}

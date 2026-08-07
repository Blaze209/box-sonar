package com.box.android.boxai;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.core.content.IntentCompat;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.box.android.base.compose.SimpleBottomSheetKt;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.multiselect.SelectionManagerKt;
import com.box.android.boxai.homescreen.AiCenterViewFactory;
import com.box.android.boxai.homescreen.BoxAiHomeScreenKt;
import com.box.android.boxai.homescreen.BoxAiHomeViewModel;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.brownfieldApi.featuresNavigator.AiCenterInitialContext;
import com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.providers.StyleVariant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AiCenterActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a4\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {AiCenterActivityKt.EXTRA_HOST_SURFACE, "", AiCenterActivityKt.EXTRA_SESSION_ID, AiCenterActivityKt.EXTRA_ITEM_MODELS, AiCenterActivityKt.EXTRA_SHARED_LINK, AiCenterActivityKt.EXTRA_INITIAL_PROMPT, "AiCenterContent", "", "launchIntent", "Landroid/content/Intent;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "viewModel", "Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "(Landroid/content/Intent;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/cpl/IPreviewLauncher;Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel;Lcom/box/android/boxai/homescreen/AiCenterViewFactory;Landroidx/compose/runtime/Composer;II)V", "aiCenterLaunchSemantics", "Landroidx/compose/ui/Modifier;", "launchMode", "Lcom/box/brownfieldApi/featuresNavigator/AiCenterLaunchMode;", "hostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "resolveAiCenterLaunchMode", "sessionId", "itemModels", "", "Lcom/box/android/domain/models/item/ItemModel;", "sharedLinkContext", AiCenterInitialContext.INITIAL_PROMPT_KEY, "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AiCenterActivityKt {
    private static final String EXTRA_HOST_SURFACE = "EXTRA_HOST_SURFACE";
    private static final String EXTRA_INITIAL_PROMPT = "EXTRA_INITIAL_PROMPT";
    private static final String EXTRA_ITEM_MODELS = "EXTRA_ITEM_MODELS";
    private static final String EXTRA_SESSION_ID = "EXTRA_SESSION_ID";
    private static final String EXTRA_SHARED_LINK = "EXTRA_SHARED_LINK";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterContent$lambda$3(Intent intent, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, BoxAiHomeViewModel boxAiHomeViewModel, AiCenterViewFactory aiCenterViewFactory, int i, int i2, Composer composer, int i3) {
        AiCenterContent(intent, intentServices, iPreviewLauncher, boxAiHomeViewModel, aiCenterViewFactory, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0150  */
    /* JADX WARN: Code duplicated, block: B:77:0x0175  */
    /* JADX WARN: Code duplicated, block: B:80:0x0181  */
    /* JADX WARN: Code duplicated, block: B:83:0x0194  */
    /* JADX WARN: Code duplicated, block: B:84:0x0197  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:95:0x021d  */
    public static final void AiCenterContent(final Intent launchIntent, final IntentServices intentServices, final IPreviewLauncher previewLauncher, BoxAiHomeViewModel boxAiHomeViewModel, AiCenterViewFactory aiCenterViewFactory, Composer composer, final int i, final int i2) {
        int i3;
        BoxAiHomeViewModel boxAiHomeViewModel2;
        AiCenterViewFactory aiCenterViewFactory2;
        Composer composer2;
        final BoxAiHomeViewModel boxAiHomeViewModel3;
        final AiCenterViewFactory aiCenterViewFactory3;
        String str;
        BoxAiHomeViewModel boxAiHomeViewModel4;
        final BoxAiHomeViewModel boxAiHomeViewModel5;
        final AiCenterViewFactory aiCenterViewFactory4;
        CreationExtras.Empty defaultViewModelCreationExtras;
        final Activity activity;
        String stringExtra;
        String sessionId;
        ArrayList parcelableArrayListExtra;
        ArrayList arrayListEmptyList;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(launchIntent, "launchIntent");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Composer composerStartRestartGroup = composer.startRestartGroup(1933676935);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AiCenterContent)N(launchIntent,intentServices,previewLauncher,viewModel,aiCenterViewFactory)127@5588L7,144@6368L32,145@6428L241,157@6743L974,155@6674L1043:AiCenterActivity.kt#6z2y90");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(launchIntent) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(intentServices) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(previewLauncher) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                boxAiHomeViewModel2 = boxAiHomeViewModel;
                int i4 = composerStartRestartGroup.changedInstance(boxAiHomeViewModel2) ? 2048 : 1024;
                i3 |= i4;
            } else {
                boxAiHomeViewModel2 = boxAiHomeViewModel;
            }
            i3 |= i4;
        } else {
            boxAiHomeViewModel2 = boxAiHomeViewModel;
        }
        int i5 = i2 & 16;
        if (i5 != 0) {
            i3 |= 24576;
            aiCenterViewFactory2 = aiCenterViewFactory;
        } else {
            aiCenterViewFactory2 = aiCenterViewFactory;
            if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(aiCenterViewFactory2) ? 16384 : 8192;
            }
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 9363) != 9362, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "124@5473L23");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localActivity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    ComponentActivity componentActivity = (ComponentActivity) objConsume;
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BoxAiHomeViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    boxAiHomeViewModel4 = (BoxAiHomeViewModel) viewModel;
                    i6 &= -7169;
                } else {
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    composer2 = composerStartRestartGroup;
                    boxAiHomeViewModel4 = boxAiHomeViewModel2;
                }
                if (i5 != 0) {
                    boxAiHomeViewModel5 = boxAiHomeViewModel4;
                    aiCenterViewFactory4 = null;
                } else {
                    boxAiHomeViewModel5 = boxAiHomeViewModel4;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1933676935, i6, -1, "com.box.android.boxai.AiCenterContent (AiCenterActivity.kt:126)");
                }
                ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str);
                Object objConsume2 = composer2.consume(localActivity2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                activity = (Activity) objConsume2;
                stringExtra = launchIntent.getStringExtra(EXTRA_HOST_SURFACE);
                if (stringExtra == null) {
                    stringExtra = "PREVIEW";
                }
                final HostSurface hostSurfaceValueOf = HostSurface.valueOf(stringExtra);
                sessionId = boxAiHomeViewModel5.getSessionId();
                if (sessionId == null) {
                    sessionId = launchIntent.getStringExtra(EXTRA_SESSION_ID);
                }
                boxAiHomeViewModel5.setSessionId(sessionId);
                parcelableArrayListExtra = IntentCompat.getParcelableArrayListExtra(launchIntent, EXTRA_ITEM_MODELS, ItemModel.class);
                if (parcelableArrayListExtra != null) {
                    arrayListEmptyList = parcelableArrayListExtra;
                } else {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                final AiCenterLaunchMode aiCenterLaunchModeResolveAiCenterLaunchMode = resolveAiCenterLaunchMode(boxAiHomeViewModel5.getSessionId(), arrayListEmptyList, launchIntent.getStringExtra(EXTRA_SHARED_LINK), launchIntent.getStringExtra(EXTRA_INITIAL_PROMPT));
                ComposerKt.sourceInformationMarkerStart(composer2, -1457270905, "CC(remember):AiCenterActivity.kt#9igjgp");
                objRememberedValue = composer2.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composer2.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1457268776, "CC(remember):AiCenterActivity.kt#9igjgp");
                zChangedInstance = composer2.changedInstance(activity) | composer2.changedInstance(boxAiHomeViewModel5);
                objRememberedValue2 = composer2.rememberedValue();
                if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AiCenterActivityKt.AiCenterContent$lambda$1$0(activity, boxAiHomeViewModel5);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                final Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                SimpleBottomSheetKt.SimpleBottomSheet(function0, ComposableLambdaKt.rememberComposableLambda(-1240520291, true, new Function2() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AiCenterActivityKt.AiCenterContent$lambda$2(aiCenterViewFactory4, hostSurfaceValueOf, aiCenterLaunchModeResolveAiCenterLaunchMode, intentServices, previewLauncher, snackbarHostState, boxAiHomeViewModel5, function0, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                aiCenterViewFactory3 = aiCenterViewFactory4;
                boxAiHomeViewModel3 = boxAiHomeViewModel5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i6 &= -7169;
                }
                boxAiHomeViewModel5 = boxAiHomeViewModel2;
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                composer2 = composerStartRestartGroup;
            }
            aiCenterViewFactory4 = aiCenterViewFactory2;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1933676935, i6, -1, "com.box.android.boxai.AiCenterContent (AiCenterActivity.kt:126)");
            }
            ProvidableCompositionLocal<Activity> localActivity3 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str);
            Object objConsume3 = composer2.consume(localActivity3);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            activity = (Activity) objConsume3;
            stringExtra = launchIntent.getStringExtra(EXTRA_HOST_SURFACE);
            if (stringExtra == null) {
                stringExtra = "PREVIEW";
            }
            final HostSurface hostSurfaceValueOf2 = HostSurface.valueOf(stringExtra);
            sessionId = boxAiHomeViewModel5.getSessionId();
            if (sessionId == null) {
                sessionId = launchIntent.getStringExtra(EXTRA_SESSION_ID);
            }
            boxAiHomeViewModel5.setSessionId(sessionId);
            parcelableArrayListExtra = IntentCompat.getParcelableArrayListExtra(launchIntent, EXTRA_ITEM_MODELS, ItemModel.class);
            if (parcelableArrayListExtra != null) {
                arrayListEmptyList = parcelableArrayListExtra;
            } else {
                arrayListEmptyList = CollectionsKt.emptyList();
            }
            final AiCenterLaunchMode aiCenterLaunchModeResolveAiCenterLaunchMode2 = resolveAiCenterLaunchMode(boxAiHomeViewModel5.getSessionId(), arrayListEmptyList, launchIntent.getStringExtra(EXTRA_SHARED_LINK), launchIntent.getStringExtra(EXTRA_INITIAL_PROMPT));
            ComposerKt.sourceInformationMarkerStart(composer2, -1457270905, "CC(remember):AiCenterActivity.kt#9igjgp");
            objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1457268776, "CC(remember):AiCenterActivity.kt#9igjgp");
            zChangedInstance = composer2.changedInstance(activity) | composer2.changedInstance(boxAiHomeViewModel5);
            objRememberedValue2 = composer2.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AiCenterActivityKt.AiCenterContent$lambda$1$0(activity, boxAiHomeViewModel5);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AiCenterActivityKt.AiCenterContent$lambda$1$0(activity, boxAiHomeViewModel5);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            final Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SimpleBottomSheetKt.SimpleBottomSheet(function1, ComposableLambdaKt.rememberComposableLambda(-1240520291, true, new Function2() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AiCenterActivityKt.AiCenterContent$lambda$2(aiCenterViewFactory4, hostSurfaceValueOf2, aiCenterLaunchModeResolveAiCenterLaunchMode2, intentServices, previewLauncher, snackbarHostState2, boxAiHomeViewModel5, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            aiCenterViewFactory3 = aiCenterViewFactory4;
            boxAiHomeViewModel3 = boxAiHomeViewModel5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            boxAiHomeViewModel3 = boxAiHomeViewModel2;
            aiCenterViewFactory3 = aiCenterViewFactory2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AiCenterActivityKt.AiCenterContent$lambda$3(launchIntent, intentServices, previewLauncher, boxAiHomeViewModel3, aiCenterViewFactory3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterContent$lambda$1$0(Activity activity, BoxAiHomeViewModel boxAiHomeViewModel) {
        if (activity != null) {
            activity.setResult(-1, new Intent().putExtra(AiCenterActivity.RESULT_SESSION_ID, boxAiHomeViewModel.getSessionId()));
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterContent$lambda$2(AiCenterViewFactory aiCenterViewFactory, HostSurface hostSurface, AiCenterLaunchMode aiCenterLaunchMode, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, SnackbarHostState snackbarHostState, final BoxAiHomeViewModel boxAiHomeViewModel, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C158@6753L958:AiCenterActivity.kt#6z2y90");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1240520291, i, -1, "com.box.android.boxai.AiCenterContent.<anonymous> (AiCenterActivity.kt:158)");
            }
            Modifier modifierFillMaxHeight = SizeKt.fillMaxHeight(Modifier.INSTANCE, 0.9f);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxHeight);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1035091021, "C159@6826L78,160@6925L65,173@7566L28,161@7003L605,175@7621L80:AiCenterActivity.kt#6z2y90");
            ComposerKt.sourceInformationMarkerStart(composer, 1074988261, "CC(remember):AiCenterActivity.kt#9igjgp");
            boolean zChanged = composer.changed(aiCenterViewFactory);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                if (aiCenterViewFactory == null) {
                    aiCenterViewFactory = new AiCenterViewFactory();
                }
                composer.updateRememberedValue(aiCenterViewFactory);
                objRememberedValue = aiCenterViewFactory;
            }
            AiCenterViewFactory aiCenterViewFactory2 = (AiCenterViewFactory) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            aiCenterViewFactory2.RememberAiCenterView(hostSurface, StyleVariant.MODAL, aiCenterLaunchMode, composer, 48);
            Modifier modifierAiCenterLaunchSemantics = aiCenterLaunchSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), aiCenterLaunchMode, hostSurface);
            ComposerKt.sourceInformationMarkerStart(composer, 1075011891, "CC(remember):AiCenterActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(boxAiHomeViewModel);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AiCenterActivityKt.AiCenterContent$lambda$2$0$1$0(boxAiHomeViewModel, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiHomeScreenKt.BoxAiHomeScreen(intentServices, modifierAiCenterLaunchSemantics, aiCenterViewFactory2, aiCenterLaunchMode, hostSurface, iPreviewLauncher, snackbarHostState, boxAiHomeViewModel, (Function1) objRememberedValue2, function0, composer, 1572864, 0);
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), composer, 6, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiCenterContent$lambda$2$0$1$0(BoxAiHomeViewModel boxAiHomeViewModel, String str) {
        boxAiHomeViewModel.setSessionId(str);
        return Unit.INSTANCE;
    }

    public static final Modifier aiCenterLaunchSemantics(Modifier modifier, final AiCenterLaunchMode launchMode, final HostSurface hostSurface) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        Intrinsics.checkNotNullParameter(hostSurface, "hostSurface");
        return SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: com.box.android.boxai.AiCenterActivityKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AiCenterActivityKt.aiCenterLaunchSemantics$lambda$0(launchMode, hostSurface, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit aiCenterLaunchSemantics$lambda$0(AiCenterLaunchMode aiCenterLaunchMode, HostSurface hostSurface, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        semantics.set(AiCenterSemanticsProperties.INSTANCE.getLaunchMode(), aiCenterLaunchMode);
        semantics.set(AiCenterSemanticsProperties.INSTANCE.getLaunchHostSurface(), hostSurface);
        return Unit.INSTANCE;
    }

    public static final AiCenterLaunchMode resolveAiCenterLaunchMode(String str, List<? extends ItemModel> itemModels, String str2, String str3) {
        Intrinsics.checkNotNullParameter(itemModels, "itemModels");
        if (str != null) {
            return new AiCenterLaunchMode.ResumeSession(str);
        }
        ArrayList arrayList = new ArrayList();
        for (ItemModel itemModel : itemModels) {
            String strBoxIdOrNull = itemModel.boxIdOrNull();
            Object itemInfo = null;
            if (strBoxIdOrNull != null) {
                ItemType itemTypeType = ItemModelKt.type(itemModel);
                String value = itemTypeType != null ? itemTypeType.getValue() : null;
                com.margelo.nitro.boxcontext.ItemType itemType = com.margelo.nitro.boxcontext.ItemType.FILE;
                for (Object obj : com.margelo.nitro.boxcontext.ItemType.values()) {
                    if (StringsKt.equals(((Enum) obj).name(), value, true)) {
                        itemInfo = obj;
                        break;
                    }
                }
                Enum r1 = (Enum) itemInfo;
                if (r1 != null) {
                    itemType = r1;
                }
                itemInfo = new ItemInfo(new ItemIdentifier(strBoxIdOrNull, (com.margelo.nitro.boxcontext.ItemType) itemType), itemModel.getName(), strBoxIdOrNull, str2 == null ? SelectionManagerKt.sharedLinkUrl(itemModel) : str2, null, null);
            }
            if (itemInfo != null) {
                arrayList.add(itemInfo);
            }
        }
        return new AiCenterLaunchMode.NewSession(new AiCenterInitialContext(arrayList, str3, null, null, 12, null));
    }
}

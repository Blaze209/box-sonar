package com.box.android.collections.presentation.navigationmodernization;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.compose.button.fab.BoxFabButtonKt;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibility;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibilityKt;
import com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt;
import com.box.android.base.presentation.components.topbar.CenterSpaceConfig;
import com.box.android.base.presentation.components.topbar.SettingsButtonConfig;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.collections.R;
import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer;
import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt;
import com.box.android.collections.presentation.navigationmodernization.component.CreateCollectionDialogKt;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.cpl.Store;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionsDomainError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionsScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"CollectionsScreen", "", "navigator", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "collectionsViewModels", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsScreenViewModels;", "onNavigateToSettings", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;Lcom/box/android/collections/presentation/navigationmodernization/CollectionsScreenViewModels;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollectionCreationErrorSnackbar", "error", "Lcom/box/android/domain/models/DomainError;", "collectionName", "", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "(Lcom/box/android/domain/models/DomainError;Ljava/lang/String;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "collections_generalProdRelease", "state", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$State;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionCreationErrorSnackbar$lambda$2(DomainError domainError, String str, SnackbarHostState snackbarHostState, Function0 function0, int i, Composer composer, int i2) {
        CollectionCreationErrorSnackbar(domainError, str, snackbarHostState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$7(CollectionsNavigator collectionsNavigator, CollectionsScreenViewModels collectionsScreenViewModels, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollectionsScreen(collectionsNavigator, collectionsScreenViewModels, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:43:0x008e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:54:0x011e  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    public static final void CollectionsScreen(final CollectionsNavigator navigator, final CollectionsScreenViewModels collectionsViewModels, final Function0<Unit> onNavigateToSettings, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final Store<CollectionsReducer.State, CollectionsReducer.Action> store;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(collectionsViewModels, "collectionsViewModels");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Composer composerStartRestartGroup = composer.startRestartGroup(-834130628);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionsScreen)N(navigator,collectionsViewModels,onNavigateToSettings,modifier)49@2761L22,50@2819L29,53@2992L32,54@3049L34,83@4262L6,86@4386L82,86@4371L97,60@3225L555,57@3122L84,73@3813L413,90@4516L1352,56@3089L2779:CollectionsScreen.kt#z4izrv");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(navigator) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(collectionsViewModels) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateToSettings) ? 256 : 128;
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
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-834130628, i3, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionsScreen (CollectionsScreen.kt:48)");
                }
                store = collectionsViewModels.getCollectionsViewModel().invoke(composerStartRestartGroup, 0).getStore();
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final boolean zAreEqual = Intrinsics.areEqual(CollectionsScreen$lambda$0(stateCollectAsStateWithLifecycle).getCollectionsListState().getLoadingState(), CollectionsListReducer.LoadingState.Loaded.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1559365628, "CC(remember):CollectionsScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                long jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                Modifier modifier5 = modifier4;
                WindowInsets WindowInsets = WindowInsetsKt.WindowInsets();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1559410286, "CC(remember):CollectionsScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CollectionsScreenKt.CollectionsScreen$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ScaffoldKt.m4038ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(AnalyticsUtilsKt.trackOnVisible(modifier5, null, (Function0) objRememberedValue2, composerStartRestartGroup, (i3 >> 9) & 14, 1), scrollAwareFabVisibilityRememberScrollAwareFabVisibility, null, 2, null), ComposableLambdaKt.rememberComposableLambda(-47488000, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsScreenKt.CollectionsScreen$lambda$3(collectionsViewModels, store, onNavigateToSettings, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1183432446, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsScreenKt.CollectionsScreen$lambda$4(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1751404669, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsScreenKt.CollectionsScreen$lambda$5(zAreEqual, scrollAwareFabVisibilityRememberScrollAwareFabVisibility, store, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0, jM11498getAppBackground0d7_KjU, 0L, WindowInsets, ComposableLambdaKt.rememberComposableLambda(1663797323, true, new Function3() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CollectionsScreenKt.CollectionsScreen$lambda$6(store, navigator, snackbarHostState, stateCollectAsStateWithLifecycle, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805334064, Token.METHOD);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsScreenKt.CollectionsScreen$lambda$7(navigator, collectionsViewModels, onNavigateToSettings, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-834130628, i3, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionsScreen (CollectionsScreen.kt:48)");
            }
            store = collectionsViewModels.getCollectionsViewModel().invoke(composerStartRestartGroup, 0).getStore();
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final boolean zAreEqual2 = Intrinsics.areEqual(CollectionsScreen$lambda$0(stateCollectAsStateWithLifecycle2).getCollectionsListState().getLoadingState(), CollectionsListReducer.LoadingState.Loaded.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1559365628, "CC(remember):CollectionsScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility2 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
            long jM11498getAppBackground0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            Modifier modifier6 = modifier4;
            WindowInsets WindowInsets2 = WindowInsetsKt.WindowInsets();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1559410286, "CC(remember):CollectionsScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(store);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionsScreenKt.CollectionsScreen$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionsScreenKt.CollectionsScreen$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ScaffoldKt.m4038ScaffoldTvnljyQ(NestedScrollModifierKt.nestedScroll$default(AnalyticsUtilsKt.trackOnVisible(modifier6, null, (Function0) objRememberedValue2, composerStartRestartGroup, (i3 >> 9) & 14, 1), scrollAwareFabVisibilityRememberScrollAwareFabVisibility2, null, 2, null), ComposableLambdaKt.rememberComposableLambda(-47488000, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsScreenKt.CollectionsScreen$lambda$3(collectionsViewModels, store, onNavigateToSettings, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1183432446, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsScreenKt.CollectionsScreen$lambda$4(snackbarHostState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1751404669, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsScreenKt.CollectionsScreen$lambda$5(zAreEqual2, scrollAwareFabVisibilityRememberScrollAwareFabVisibility2, store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0, jM11498getAppBackground0d7_KjU2, 0L, WindowInsets2, ComposableLambdaKt.rememberComposableLambda(1663797323, true, new Function3() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CollectionsScreenKt.CollectionsScreen$lambda$6(store, navigator, snackbarHostState2, stateCollectAsStateWithLifecycle2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805334064, Token.METHOD);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsScreenKt.CollectionsScreen$lambda$7(navigator, collectionsViewModels, onNavigateToSettings, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$4(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@3136L60:CollectionsScreen.kt#z4izrv");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1183432446, i, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionsScreen.<anonymous> (CollectionsScreen.kt:58)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$3(CollectionsScreenViewModels collectionsScreenViewModels, final Store store, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@3372L21,64@3425L148,69@3662L36,61@3239L531:CollectionsScreen.kt#z4izrv");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-47488000, i, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionsScreen.<anonymous> (CollectionsScreen.kt:61)");
            }
            UserAvatarViewModel userAvatarViewModelInvoke = collectionsScreenViewModels.getUserAvatarViewModel().invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1608678804, "CC(remember):CollectionsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionsScreenKt.CollectionsScreen$lambda$3$0$0(store, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxPrimaryTopBarKt.BoxPrimaryTopBar(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.INSTANCE), new SettingsButtonConfig(userAvatarViewModelInvoke, (Function0) objRememberedValue), null, new CenterSpaceConfig.TitleBarConfig(StringResources_androidKt.stringResource(R.string.Collections, composer, 0)), null, null, composer, (SettingsButtonConfig.$stable << 3) | (CenterSpaceConfig.TitleBarConfig.$stable << 9), 52);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$3$0$0(Store store, Function0 function0) {
        store.send(CollectionsReducer.Action.SettingsClicked.INSTANCE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$5$0$0(Store store) {
        store.send(CollectionsReducer.Action.ShowCreateCollectionDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$5(boolean z, ScrollAwareFabVisibility scrollAwareFabVisibility, final Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@4010L42,79@4080L48,75@3867L104,74@3827L389:CollectionsScreen.kt#z4izrv");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1751404669, i, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionsScreen.<anonymous> (CollectionsScreen.kt:74)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.create_collection, composer, 0);
            Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_create_collection, composer, 0);
            boolean z2 = z && scrollAwareFabVisibility.isVisible();
            ComposerKt.sourceInformationMarkerStart(composer, 527294955, "CC(remember):CollectionsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionsScreenKt.CollectionsScreen$lambda$5$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxFabButtonKt.BoxFabButton((Function0) objRememberedValue, strStringResource, null, z2, painterPainterResource, composer, Painter.$stable << 12, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$2$0(Store store) {
        store.send(CollectionsReducer.Action.ScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$6(final Store store, final CollectionsNavigator collectionsNavigator, SnackbarHostState snackbarHostState, State state, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)91@4543L1319:CollectionsScreen.kt#z4izrv");
        if ((i & 6) == 0) {
            i2 = (composer.changed(paddingValues) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1663797323, i2, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionsScreen.<anonymous> (CollectionsScreen.kt:91)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues), "CollectionsScreen");
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierTestTag);
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
            ComposerKt.sourceInformationMarkerStart(composer, 689331603, "C99@4834L193,97@4721L375:CollectionsScreen.kt#z4izrv");
            Store<CollectionsListReducer.State, CollectionsListReducer.Action> storeScopeCollectionsList = CollectionsReducerKt.scopeCollectionsList(store);
            ComposerKt.sourceInformationMarkerStart(composer, 853523174, "CC(remember):CollectionsScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(collectionsNavigator);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionsScreenKt.CollectionsScreen$lambda$6$0$0$0(collectionsNavigator, (CollectionModel) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CollectionsListScreenKt.CollectionsListScreen(storeScopeCollectionsList, (Function1) objRememberedValue, snackbarHostState, composer, 384, 0);
            if (!CollectionsScreen$lambda$0(state).getCreateCollectionDialogVisible()) {
                composer.startReplaceGroup(684612317);
            } else {
                composer.startReplaceGroup(689731750);
                ComposerKt.sourceInformation(composer, "109@5225L68,110@5326L72,108@5169L247");
                ComposerKt.sourceInformationMarkerStart(composer, 853535561, "CC(remember):CollectionsScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CollectionsScreenKt.CollectionsScreen$lambda$6$0$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 853538797, "CC(remember):CollectionsScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionsScreenKt.CollectionsScreen$lambda$6$0$2$0(store, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CreateCollectionDialogKt.CreateCollectionDialog(function0, (Function1) objRememberedValue3, composer, 0);
            }
            composer.endReplaceGroup();
            CollectionsReducer.CollectionCreationError collectionCreationError = CollectionsScreen$lambda$0(state).getCollectionCreationError();
            if (collectionCreationError == null) {
                composer.startReplaceGroup(690056195);
            } else {
                composer.startReplaceGroup(690056196);
                ComposerKt.sourceInformation(composer, "*119@5748L72,115@5512L326");
                DomainError error = collectionCreationError.getError();
                String collectionName = collectionCreationError.getCollectionName();
                ComposerKt.sourceInformationMarkerStart(composer, -1129587545, "CC(remember):CollectionsScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(store);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CollectionsScreenKt.CollectionsScreen$lambda$6$0$3$0$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CollectionCreationErrorSnackbar(error, collectionName, snackbarHostState, (Function0) objRememberedValue4, composer, 384);
            }
            composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$6$0$0$0(CollectionsNavigator collectionsNavigator, CollectionModel collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        collectionsNavigator.navigateTo(new CollectionsDestination.InnerDestination.CollectionItemsList(collection));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$6$0$1$0(Store store) {
        store.send(CollectionsReducer.Action.HideCreateCollectionDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$6$0$2$0(Store store, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        store.send(new CollectionsReducer.Action.CreateCollection(name));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsScreen$lambda$6$0$3$0$0(Store store) {
        store.send(CollectionsReducer.Action.DismissCollectionCreationError.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void CollectionCreationErrorSnackbar(final DomainError domainError, final String str, final SnackbarHostState snackbarHostState, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(1700830339);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionCreationErrorSnackbar)N(error,collectionName,snackbarHostState,onDismiss)151@6705L176,151@6681L200,157@6910L134,157@6887L157:CollectionsScreen.kt#z4izrv");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(domainError) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1700830339, i2, -1, "com.box.android.collections.presentation.navigationmodernization.CollectionCreationErrorSnackbar (CollectionsScreen.kt:132)");
            }
            if ((domainError instanceof CollectionsDomainError.CollectionNameConflict) || (domainError instanceof DomainError.APIResourceConflict)) {
                composerStartRestartGroup.startReplaceGroup(1707712558);
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6179L89");
                strStringResource = StringResources_androidKt.stringResource(R.string.create_collection_collection_name_conflict_error, new Object[]{str}, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if ((domainError instanceof CollectionsDomainError.CollectionNameMalformed) || (domainError instanceof DomainError.APIRequestError)) {
                composerStartRestartGroup.startReplaceGroup(1707908974);
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@6378L57");
                strStringResource = StringResources_androidKt.stringResource(R.string.create_collection_malformed_name, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (DomainErrorKt.isNetworkConnectionError(domainError)) {
                composerStartRestartGroup.startReplaceGroup(1708034927);
                ComposerKt.sourceInformation(composerStartRestartGroup, "143@6505L56");
                strStringResource = StringResources_androidKt.stringResource(R.string.create_collection_network_error, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1708132143);
                ComposerKt.sourceInformation(composerStartRestartGroup, "147@6603L56");
                strStringResource = StringResources_androidKt.stringResource(R.string.create_collection_generic_error, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884557805, "CC(remember):CollectionsScreen.kt#9igjgp");
            boolean zChanged = ((i2 & 896) == 256) | composerStartRestartGroup.changed(strStringResource);
            int i3 = i2 & 7168;
            boolean z = zChanged | (i3 == 2048);
            CollectionsScreenKt$CollectionCreationErrorSnackbar$1$1 collectionsScreenKt$CollectionCreationErrorSnackbar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || collectionsScreenKt$CollectionCreationErrorSnackbar$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                collectionsScreenKt$CollectionCreationErrorSnackbar$1$1RememberedValue = new CollectionsScreenKt$CollectionCreationErrorSnackbar$1$1(snackbarHostState, strStringResource, function0, null);
                composerStartRestartGroup.updateRememberedValue(collectionsScreenKt$CollectionCreationErrorSnackbar$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(strStringResource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionsScreenKt$CollectionCreationErrorSnackbar$1$1RememberedValue, composerStartRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884551287, "CC(remember):CollectionsScreen.kt#9igjgp");
            boolean z2 = i3 == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionsScreenKt.CollectionCreationErrorSnackbar$lambda$1$0(function0, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsScreenKt.CollectionCreationErrorSnackbar$lambda$2(domainError, str, snackbarHostState, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final CollectionsReducer.State CollectionsScreen$lambda$0(State<CollectionsReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CollectionCreationErrorSnackbar$lambda$1$0(final Function0 function0, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt$CollectionCreationErrorSnackbar$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                function0.invoke();
            }
        };
    }
}

package com.box.android.hubs.presentation;

import android.content.Context;
import android.icu.number.LocalizedNumberFormatter;
import android.icu.number.Notation;
import android.icu.number.NumberFormatter;
import android.icu.number.Precision;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.EmptyItemsWithPullToRefreshWorkaroundKt;
import com.box.android.base.compose.BoxListViewItemKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.ViewInteropNestedScrollConnectionKt;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.compose.divider.BoxItemListingDividerKt;
import com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt;
import com.box.android.base.models.ClickActionsConfig;
import com.box.android.base.models.ListItemInfo;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemsScreenMode;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.hubs.R;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HubsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\f\u001a+\u0010\r\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\f\u001a\u001d\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001aO\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010!H\u0003¢\u0006\u0002\u0010\"¨\u0006#²\u0006\n\u0010$\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"HubsScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/hubs/presentation/HubsReducer$State;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lcom/box/android/coreservices/services/IntentServices;ZLandroidx/compose/runtime/Composer;II)V", "HubListingScreen", "(Lcom/box/android/cpl/Store;ZLandroidx/compose/runtime/Composer;II)V", "HubsList", "HubsScreenItemDivider", "itemsScreenMode", "Lcom/box/android/domain/models/ItemsScreenMode;", "isLastItem", "(Lcom/box/android/domain/models/ItemsScreenMode;ZLandroidx/compose/runtime/Composer;I)V", "hubsDescription", "", "hubState", "Lcom/box/android/hubs/presentation/HubReducer$State;", "(Lcom/box/android/hubs/presentation/HubReducer$State;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "HubItem", "Lcom/box/android/hubs/presentation/HubReducer$Action;", "isSelecting", "isSelected", "(Lcom/box/android/cpl/Store;Lcom/box/android/domain/models/ItemsScreenMode;ZZZZLandroidx/compose/runtime/Composer;II)V", "ErrorScreen", "domainError", "Lcom/box/android/domain/models/DomainError;", "retryClicked", "Lkotlin/Function0;", "(Lcom/box/android/domain/models/DomainError;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "hubs_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HubsScreenKt {

    /* JADX INFO: compiled from: HubsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HubsReducer.ConfigBarMode.values().length];
            try {
                iArr[HubsReducer.ConfigBarMode.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HubsReducer.ConfigBarMode.SORT_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ItemsScreenMode.values().length];
            try {
                iArr2[ItemsScreenMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ItemsScreenMode.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorScreen$lambda$0(DomainError domainError, Function0 function0, int i, Composer composer, int i2) {
        ErrorScreen(domainError, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubItem$lambda$5(Store store, ItemsScreenMode itemsScreenMode, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Composer composer, int i3) {
        HubItem(store, itemsScreenMode, z, z2, z3, z4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubListingScreen$lambda$3(Store store, boolean z, int i, int i2, Composer composer, int i3) {
        HubListingScreen(store, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$2(Store store, boolean z, int i, int i2, Composer composer, int i3) {
        HubsList(store, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreen$lambda$5(Store store, IntentServices intentServices, boolean z, int i, int i2, Composer composer, int i3) {
        HubsScreen(store, intentServices, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreenItemDivider$lambda$0(ItemsScreenMode itemsScreenMode, boolean z, int i, Composer composer, int i2) {
        HubsScreenItemDivider(itemsScreenMode, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:58:0x0113  */
    /* JADX WARN: Code duplicated, block: B:61:0x0146  */
    /* JADX WARN: Code duplicated, block: B:62:0x0148  */
    /* JADX WARN: Code duplicated, block: B:67:0x0157  */
    /* JADX WARN: Code duplicated, block: B:70:0x019c  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:74:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void HubsScreen(Store<HubsReducer.State, HubsReducer.Action> store, final IntentServices intentServices, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z2;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        State stateCollectAsStateWithLifecycle;
        Context context;
        int i4;
        boolean z5;
        HubsScreenKt$HubsScreen$1$1 hubsScreenKt$HubsScreen$1$1RememberedValue;
        boolean z6;
        boolean z7;
        final State state;
        int i5;
        HubsScreenKt$HubsScreen$2$1 hubsScreenKt$HubsScreen$2$1;
        int i6;
        Object objRememberedValue;
        final Store<HubsReducer.State, HubsReducer.Action> store2 = store;
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Composer composerStartRestartGroup = composer.startRestartGroup(-880025788);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubsScreen)N(store,intentServices,isRedesignedVersion)59@2859L29,60@2920L7,63@2975L52,63@2954L73,67@3061L589,67@3033L617,88@3719L43,89@3792L75,89@3777L90,92@3874L583,86@3656L801:HubsScreen.kt#l88pwb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(intentServices) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i7 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-880025788, i3, -1, "com.box.android.hubs.presentation.HubsScreen (HubsScreen.kt:58)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 403784216, "CC(remember):HubsScreen.kt#9igjgp");
                i4 = i3 & 14;
                if (i4 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                hubsScreenKt$HubsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5 || hubsScreenKt$HubsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    hubsScreenKt$HubsScreen$1$1RememberedValue = new HubsScreenKt$HubsScreen$1$1(store2, null);
                    composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubsScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubsScreen$1$1RememberedValue, composerStartRestartGroup, 6);
                HubsRoute route = HubsScreen$lambda$0(stateCollectAsStateWithLifecycle).getRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 403787505, "CC(remember):HubsScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(intentServices);
                if (i4 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged | z6;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z7 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    state = stateCollectAsStateWithLifecycle;
                    i5 = 1;
                    HubsScreenKt$HubsScreen$2$1 hubsScreenKt$HubsScreen$2$2 = new HubsScreenKt$HubsScreen$2$1(context, intentServices, store2, state, null);
                    store2 = store2;
                    hubsScreenKt$HubsScreen$2$1 = hubsScreenKt$HubsScreen$2$2;
                    composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubsScreen$2$1);
                } else {
                    state = stateCollectAsStateWithLifecycle;
                    i5 = 1;
                    hubsScreenKt$HubsScreen$2$1 = objRememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubsScreen$2$1, composerStartRestartGroup, (int) r4);
                Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, r4, i5), null, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 403810383, "CC(remember):HubsScreen.kt#9igjgp");
                if (i4 == 4) {
                    i6 = i5;
                } else {
                    i6 = 0;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (i6 == 0 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubsScreen$lambda$3$0(store2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z8 = i5;
                Modifier modifierTrackOnVisible = AnalyticsUtilsKt.trackOnVisible(modifierNestedScroll$default, null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1507594847, z8, new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubsScreen$lambda$4(store2, z2, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                z2 = z2;
                SurfaceKt.m4323SurfaceT9BRK9s(modifierTrackOnVisible, null, 0L, 0L, 0.0f, 0.0f, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubsScreen$lambda$5(store2, intentServices, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i3 & Token.DOTQUERY) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i7 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880025788, i3, -1, "com.box.android.hubs.presentation.HubsScreen (HubsScreen.kt:58)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 403784216, "CC(remember):HubsScreen.kt#9igjgp");
            i4 = i3 & 14;
            if (i4 == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            hubsScreenKt$HubsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                hubsScreenKt$HubsScreen$1$1RememberedValue = new HubsScreenKt$HubsScreen$1$1(store2, null);
                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubsScreen$1$1RememberedValue);
            } else {
                hubsScreenKt$HubsScreen$1$1RememberedValue = new HubsScreenKt$HubsScreen$1$1(store2, null);
                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubsScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            HubsRoute route2 = HubsScreen$lambda$0(stateCollectAsStateWithLifecycle).getRoute();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 403787505, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(intentServices);
            if (i4 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChanged2 | z6;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z7) {
                state = stateCollectAsStateWithLifecycle;
                i5 = 1;
                HubsScreenKt$HubsScreen$2$1 hubsScreenKt$HubsScreen$2$3 = new HubsScreenKt$HubsScreen$2$1(context, intentServices, store2, state, null);
                store2 = store2;
                hubsScreenKt$HubsScreen$2$1 = hubsScreenKt$HubsScreen$2$3;
                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubsScreen$2$1);
            } else {
                state = stateCollectAsStateWithLifecycle;
                i5 = 1;
                HubsScreenKt$HubsScreen$2$1 hubsScreenKt$HubsScreen$2$4 = new HubsScreenKt$HubsScreen$2$1(context, intentServices, store2, state, null);
                store2 = store2;
                hubsScreenKt$HubsScreen$2$1 = hubsScreenKt$HubsScreen$2$4;
                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubsScreen$2$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(route2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubsScreen$2$1, composerStartRestartGroup, (int) r4);
            Modifier modifierNestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, r4, i5), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 403810383, "CC(remember):HubsScreen.kt#9igjgp");
            if (i4 == 4) {
                i6 = i5;
            } else {
                i6 = 0;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (i6 == 0) {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsScreen$lambda$3$0(store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsScreen$lambda$3$0(store2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z9 = i5;
            Modifier modifierTrackOnVisible2 = AnalyticsUtilsKt.trackOnVisible(modifierNestedScroll$default2, null, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1507594847, z9, new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.HubsScreen$lambda$4(store2, z2, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            z2 = z2;
            SurfaceKt.m4323SurfaceT9BRK9s(modifierTrackOnVisible2, null, 0L, 0L, 0.0f, 0.0f, null, composableLambdaRememberComposableLambda2, composerStartRestartGroup, 12582912, 126);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        z4 = z2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.HubsScreen$lambda$5(store2, intentServices, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreen$lambda$3$0(Store store) {
        store.send(HubsReducer.Action.ScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreen$lambda$4(final Store store, boolean z, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:HubsScreen.kt#l88pwb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507594847, i, -1, "com.box.android.hubs.presentation.HubsScreen.<anonymous> (HubsScreen.kt:93)");
            }
            HubsReducer.ScreenState screenState = HubsScreen$lambda$0(state).getScreenState();
            if (screenState instanceof HubsReducer.ScreenState.Loading) {
                composer.startReplaceGroup(285178479);
                ComposerKt.sourceInformation(composer, "95@3997L20");
                ItemStateScreensKt.LoadingItemsScreen(null, false, composer, 0, 3);
                composer.endReplaceGroup();
            } else if (screenState instanceof HubsReducer.ScreenState.Error) {
                composer.startReplaceGroup(285282546);
                ComposerKt.sourceInformation(composer, "99@4136L76,99@4099L113");
                DomainError domainError = ((HubsReducer.ScreenState.Error) screenState).getDomainError();
                ComposerKt.sourceInformationMarkerStart(composer, 1394677675, "CC(remember):HubsScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubsScreen$lambda$4$0$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ErrorScreen(domainError, (Function0) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else {
                if (!(screenState instanceof HubsReducer.ScreenState.Loaded)) {
                    composer.startReplaceGroup(1394670102);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(285477567);
                ComposerKt.sourceInformation(composer, "105@4295L132");
                HubListingScreen(store, z, composer, 0, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreen$lambda$4$0$0(Store store) {
        store.send(HubsReducer.Action.Retry.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:44:0x0101  */
    /* JADX WARN: Code duplicated, block: B:47:0x010d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0111  */
    /* JADX WARN: Code duplicated, block: B:51:0x016c  */
    /* JADX WARN: Code duplicated, block: B:52:0x019d  */
    /* JADX WARN: Code duplicated, block: B:55:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:56:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    private static final void HubListingScreen(final Store<HubsReducer.State, HubsReducer.Action> store, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        State stateCollectAsStateWithLifecycle;
        boolean z5;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(1539231441);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubListingScreen)N(store,isRedesignedVersion)116@4624L29,118@4684L28,125@4923L50,119@4717L973:HubsScreen.kt#l88pwb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i5 != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1539231441, i4, -1, "com.box.android.hubs.presentation.HubListingScreen (HubsScreen.kt:115)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                composerStartRestartGroup = composerStartRestartGroup;
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean zIsPullToRefreshing = HubListingScreen$lambda$0(stateCollectAsStateWithLifecycle).isPullToRefreshing();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1732679171, "CC(remember):HubsScreen.kt#9igjgp");
                z5 = (i4 & 14) == 4;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubListingScreen$lambda$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxSize$default, zIsPullToRefreshing, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, (Function0) objRememberedValue, 12, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1626842576, "C143@5496L188:HubsScreen.kt#l88pwb");
                if (HubListingScreen$lambda$0(stateCollectAsStateWithLifecycle).getHubsList().isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1626824287);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "132@5185L41,133@5258L44,129@5048L286");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(new ItemsStateConfig(R.drawable.empty_hubs, StringResources_androidKt.stringResource(R.string.empty_hubs_title, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.empty_hubs_subtitle, composerStartRestartGroup, 0), null, 8, null), null, false, composerStartRestartGroup, 0, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1626516209);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "137@5364L112");
                    HubsList(store, z4, composerStartRestartGroup, i4 & 126, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState, HubListingScreen$lambda$0(stateCollectAsStateWithLifecycle).isPullToRefreshing(), boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubListingScreen$lambda$3(store, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i5 != 0) {
                z4 = false;
            } else {
                z4 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1539231441, i4, -1, "com.box.android.hubs.presentation.HubListingScreen (HubsScreen.kt:115)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composerStartRestartGroup = composerStartRestartGroup;
            PullToRefreshState pullToRefreshStateRememberPullToRefreshState2 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zIsPullToRefreshing2 = HubListingScreen$lambda$0(stateCollectAsStateWithLifecycle).isPullToRefreshing();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1732679171, "CC(remember):HubsScreen.kt#9igjgp");
            if ((i4 & 14) == 4) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubListingScreen$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubListingScreen$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM5119pullToRefreshZ4HSEVQ$default2 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxSize$default2, zIsPullToRefreshing2, pullToRefreshStateRememberPullToRefreshState2, false, 0.0f, (Function0) objRememberedValue, 12, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1626842576, "C143@5496L188:HubsScreen.kt#l88pwb");
            if (HubListingScreen$lambda$0(stateCollectAsStateWithLifecycle).getHubsList().isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1626824287);
                ComposerKt.sourceInformation(composerStartRestartGroup, "132@5185L41,133@5258L44,129@5048L286");
                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(new ItemsStateConfig(R.drawable.empty_hubs, StringResources_androidKt.stringResource(R.string.empty_hubs_title, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.empty_hubs_subtitle, composerStartRestartGroup, 0), null, 8, null), null, false, composerStartRestartGroup, 0, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1626516209);
                ComposerKt.sourceInformation(composerStartRestartGroup, "137@5364L112");
                HubsList(store, z4, composerStartRestartGroup, i4 & 126, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState2, HubListingScreen$lambda$0(stateCollectAsStateWithLifecycle).isPullToRefreshing(), boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.HubListingScreen$lambda$3(store, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubListingScreen$lambda$1$0(Store store) {
        store.send(HubsReducer.Action.PulledToRefresh.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:38:0x0109  */
    /* JADX WARN: Code duplicated, block: B:39:0x010b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0112  */
    /* JADX WARN: Code duplicated, block: B:48:0x0123  */
    /* JADX WARN: Code duplicated, block: B:51:0x0147  */
    /* JADX WARN: Code duplicated, block: B:52:0x014b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0155  */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    private static final void HubsList(final Store<HubsReducer.State, HubsReducer.Action> store, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z5;
        final State stateCollectAsStateWithLifecycle;
        long jM11499getAppBackgroundAlt0d7_KjU;
        boolean z6;
        boolean z7;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1300421102);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubsList)N(store,isRedesignedVersion)153@5849L29,154@5903L23,162@6309L2296,155@5931L2674:HubsScreen.kt#l88pwb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i5 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1300421102, i4, -1, "com.box.android.hubs.presentation.HubsList (HubsScreen.kt:152)");
                }
                z5 = z2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(130815551);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "158@6064L6");
                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(130816674);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "158@6099L6");
                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxSize$default, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null), "HubsList:" + HubsList$lambda$0(stateCollectAsStateWithLifecycle).getItemsScreenMode());
                PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 130825450, "CC(remember):HubsScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if ((i4 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged | z6 | ((i4 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return HubsScreenKt.HubsList$lambda$1$0(stateCollectAsStateWithLifecycle, store, z5, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                z4 = z5;
                composerStartRestartGroup = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierTestTag, lazyListStateRememberLazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 504);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubsList$lambda$2(store, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i5 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1300421102, i4, -1, "com.box.android.hubs.presentation.HubsList (HubsScreen.kt:152)");
            }
            z5 = z2;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(130815551);
                ComposerKt.sourceInformation(composerStartRestartGroup, "158@6064L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(130816674);
                ComposerKt.sourceInformation(composerStartRestartGroup, "158@6099L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierTestTag2 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxSize$default2, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null), "HubsList:" + HubsList$lambda$0(stateCollectAsStateWithLifecycle).getItemsScreenMode());
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default2 = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 130825450, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            if ((i4 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChanged2 | z6 | ((i4 & 112) == 32);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubsScreenKt.HubsList$lambda$1$0(stateCollectAsStateWithLifecycle, store, z5, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubsScreenKt.HubsList$lambda$1$0(stateCollectAsStateWithLifecycle, store, z5, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            z4 = z5;
            composerStartRestartGroup = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierTestTag2, lazyListStateRememberLazyListState2, paddingValuesM1215PaddingValuesa9UjIt4$default2, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.HubsList$lambda$2(store, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0(final State state, final Store store, final boolean z, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (!HubsList$lambda$0(state).getHubsList().isEmpty()) {
            int i = WhenMappings.$EnumSwitchMapping$0[HubsList$lambda$0(state).getConfigBarMode().ordinal()];
            if (i == 1) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1775748630, true, new Function3() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return HubsScreenKt.HubsList$lambda$1$0$0(store, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1669079263, true, new Function3() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return HubsScreenKt.HubsList$lambda$1$0$1(store, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), 3, null);
            }
        }
        final IdentifiedList<String, HubReducer.State> hubsList = HubsList$lambda$0(state).getHubsList();
        final HubsScreenKt$HubsList$lambda$1$0$$inlined$items$default$1 hubsScreenKt$HubsList$lambda$1$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenKt$HubsList$lambda$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(HubReducer.State state2) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((HubReducer.State) obj);
            }
        };
        LazyColumn.items(hubsList.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.hubs.presentation.HubsScreenKt$HubsList$lambda$1$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i2) {
                return hubsScreenKt$HubsList$lambda$1$0$$inlined$items$default$1.invoke(hubsList.get(i2));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.hubs.presentation.HubsScreenKt$HubsList$lambda$1$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i2, Composer composer, int i3) {
                int i4;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i3 & 6) == 0) {
                    i4 = (composer.changed(lazyItemScope) ? 4 : 2) | i3;
                } else {
                    i4 = i3;
                }
                if ((i3 & 48) == 0) {
                    i4 |= composer.changed(i2) ? 32 : 16;
                }
                if (!composer.shouldExecute((i4 & Token.DOTQUERY) != 146, i4 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i4, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                HubReducer.State state2 = (HubReducer.State) hubsList.get(i2);
                composer.startReplaceGroup(-1563668376);
                ComposerKt.sourceInformation(composer, "CN(it)*200@8242L29,196@8100L489:HubsScreen.kt#l88pwb");
                Store store2 = store;
                HubsScreenKt$HubsList$1$1$3$1 hubsScreenKt$HubsList$1$1$3$1 = new PropertyReference1Impl() { // from class: com.box.android.hubs.presentation.HubsScreenKt$HubsList$1$1$3$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((HubsReducer.State) obj).getHubsList();
                    }
                };
                String id = state2.getId();
                ComposerKt.sourceInformationMarkerStart(composer, -1713004817, "CC(remember):HubsScreen.kt#9igjgp");
                HubsScreenKt$HubsList$1$1$3$2$1 hubsScreenKt$HubsList$1$1$3$2$1RememberedValue = composer.rememberedValue();
                if (hubsScreenKt$HubsList$1$1$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    hubsScreenKt$HubsList$1$1$3$2$1RememberedValue = HubsScreenKt$HubsList$1$1$3$2$1.INSTANCE;
                    composer.updateRememberedValue(hubsScreenKt$HubsList$1$1$3$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                HubsScreenKt.HubItem(store2.scope(hubsScreenKt$HubsList$1$1$3$1, id, (Function2<? super String, ? super LocalAction, ? extends Action>) ((KFunction) hubsScreenKt$HubsList$1$1$3$2$1RememberedValue)), HubsScreenKt.HubsList$lambda$0(state).getItemsScreenMode(), Intrinsics.areEqual(((HubReducer.State) CollectionsKt.last((List) HubsScreenKt.HubsList$lambda$0(state).getHubsList())).getId(), state2.getId()), HubsScreenKt.HubsList$lambda$0(state).isSelecting(), HubsScreenKt.HubsList$lambda$0(state).isHubSelected(state2.getId()), z, composer, 0, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$0(final Store store, State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C171@6750L49,172@6845L87,173@6985L54,175@7190L41,174@7088L51,167@6498L842:HubsScreen.kt#l88pwb");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1775748630, i, -1, "com.box.android.hubs.presentation.HubsList.<anonymous>.<anonymous>.<anonymous> (HubsScreen.kt:167)");
            }
            ItemsScreenMode itemsScreenMode = HubsList$lambda$0(state).getItemsScreenMode();
            HubsSort sortBy = HubsList$lambda$0(state).getSortBy();
            HubsDirection sortDirection = HubsList$lambda$0(state).getSortDirection();
            boolean shouldShowSearchButton = HubsList$lambda$0(state).getShouldShowSearchButton();
            ComposerKt.sourceInformationMarkerStart(composer, -1392407973, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsList$lambda$1$0$0$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1392404895, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubsScreenKt.HubsList$lambda$1$0$0$1$0(store, (HubsSort) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1392400448, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged3 = composer.changed(store);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsList$lambda$1$0$0$2$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function0 function2 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1392393901, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged4 = composer.changed(store);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsList$lambda$1$0$0$3$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function0 function3 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1392397155, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged5 = composer.changed(store);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsList$lambda$1$0$0$4$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            HubsScreenConfigBarKt.HubsScreenConfigBar(itemsScreenMode, sortBy, sortDirection, function0, function1, function2, function3, (Function0) objRememberedValue5, shouldShowSearchButton, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$0$0$0(Store store) {
        store.send(HubsReducer.Action.SortingClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$0$1$0(Store store, HubsSort sortOptionClicked) {
        Intrinsics.checkNotNullParameter(sortOptionClicked, "sortOptionClicked");
        store.send(new HubsReducer.Action.ChangeSortBy(sortOptionClicked));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$0$2$0(Store store) {
        store.send(HubsReducer.Action.ToggleSortDirection.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$0$4$0(Store store) {
        store.send(HubsReducer.Action.ToggleScreenMode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$0$3$0(Store store) {
        store.send(HubsReducer.Action.Search.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$1(final Store store, State state, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C186@7675L49,187@7770L87,188@7910L54,183@7490L500:HubsScreen.kt#l88pwb");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669079263, i, -1, "com.box.android.hubs.presentation.HubsList.<anonymous>.<anonymous>.<anonymous> (HubsScreen.kt:183)");
            }
            HubsSort sortBy = HubsList$lambda$0(state).getSortBy();
            HubsDirection sortDirection = HubsList$lambda$0(state).getSortDirection();
            ComposerKt.sourceInformationMarkerStart(composer, -1962363534, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsList$lambda$1$0$1$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1962360456, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubsScreenKt.HubsList$lambda$1$0$1$1$0(store, (HubsSort) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1962356009, "CC(remember):HubsScreen.kt#9igjgp");
            boolean zChanged3 = composer.changed(store);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HubsScreenKt.HubsList$lambda$1$0$1$2$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            HubsScreenConfigBarKt.HubsSortOnlyConfigBar(sortBy, sortDirection, function0, function1, (Function0) objRememberedValue3, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$1$0$0(Store store) {
        store.send(HubsReducer.Action.SortingClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$1$1$0(Store store, HubsSort sortOptionClicked) {
        Intrinsics.checkNotNullParameter(sortOptionClicked, "sortOptionClicked");
        store.send(new HubsReducer.Action.ChangeSortBy(sortOptionClicked));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsList$lambda$1$0$1$2$0(Store store) {
        store.send(HubsReducer.Action.ToggleSortDirection.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void HubsScreenItemDivider(final ItemsScreenMode itemsScreenMode, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1096415428);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubsScreenItemDivider)N(itemsScreenMode,isLastItem):HubsScreen.kt#l88pwb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(itemsScreenMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1096415428, i2, -1, "com.box.android.hubs.presentation.HubsScreenItemDivider (HubsScreen.kt:213)");
            }
            if (itemsScreenMode == ItemsScreenMode.GRID) {
                composerStartRestartGroup.startReplaceGroup(85862181);
                ComposerKt.sourceInformation(composerStartRestartGroup, "215@8771L41");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (itemsScreenMode != ItemsScreenMode.LIST || z) {
                    composerStartRestartGroup.startReplaceGroup(77168510);
                } else {
                    composerStartRestartGroup.startReplaceGroup(85983639);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "217@8894L23");
                    BoxItemListingDividerKt.m11726BoxItemListingDivideryajeYGU(0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 7);
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.HubsScreenItemDivider$lambda$0(itemsScreenMode, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final String hubsDescription(HubReducer.State hubState, Composer composer, int i) {
        String str;
        Intrinsics.checkNotNullParameter(hubState, "hubState");
        ComposerKt.sourceInformationMarkerStart(composer, -1337149281, "C(hubsDescription)N(hubState)233@9393L58,235@9481L118:HubsScreen.kt#l88pwb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1337149281, i, -1, "com.box.android.hubs.presentation.hubsDescription (HubsScreen.kt:222)");
        }
        Date updatedDate = hubState.getUpdatedDate();
        if (updatedDate == null || (str = DateFormat.getDateInstance(2).format(updatedDate)) == null) {
            str = "";
        }
        LocalizedNumberFormatter localizedNumberFormatter = (LocalizedNumberFormatter) ((LocalizedNumberFormatter) NumberFormatter.withLocale(Locale.getDefault()).notation(Notation.compactShort())).precision(Precision.integer());
        Integer accessCount = hubState.getAccessCount();
        String string = localizedNumberFormatter.format(Integer.valueOf(accessCount != null ? accessCount.intValue() : 0)).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strStringResource = StringResources_androidKt.stringResource(R.string.mini_item_description_format, new Object[]{StringResources_androidKt.stringResource(R.string.view_count, new Object[]{string}, composer, 0), str}, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:103:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:104:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:107:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:109:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:112:0x020e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0224  */
    /* JADX WARN: Code duplicated, block: B:115:0x0227  */
    /* JADX WARN: Code duplicated, block: B:118:0x022e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0236  */
    /* JADX WARN: Code duplicated, block: B:122:0x024c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0274  */
    /* JADX WARN: Code duplicated, block: B:128:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:131:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:132:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:135:0x0330  */
    /* JADX WARN: Code duplicated, block: B:136:0x0333  */
    /* JADX WARN: Code duplicated, block: B:139:0x033a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0342  */
    /* JADX WARN: Code duplicated, block: B:144:0x035a  */
    /* JADX WARN: Code duplicated, block: B:145:0x035d  */
    /* JADX WARN: Code duplicated, block: B:148:0x0364  */
    /* JADX WARN: Code duplicated, block: B:150:0x036c  */
    /* JADX WARN: Code duplicated, block: B:153:0x038a  */
    /* JADX WARN: Code duplicated, block: B:154:0x038d  */
    /* JADX WARN: Code duplicated, block: B:158:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:160:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:163:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0077  */
    /* JADX WARN: Code duplicated, block: B:38:0x007a  */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x0097  */
    /* JADX WARN: Code duplicated, block: B:51:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:82:0x014a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0162  */
    /* JADX WARN: Code duplicated, block: B:85:0x0164  */
    /* JADX WARN: Code duplicated, block: B:88:0x016b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0173  */
    /* JADX WARN: Code duplicated, block: B:92:0x018e  */
    /* JADX WARN: Code duplicated, block: B:95:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a5  */
    public static final void HubItem(final Store<HubReducer.State, HubReducer.Action> store, final ItemsScreenMode itemsScreenMode, final boolean z, boolean z2, boolean z3, boolean z4, Composer composer, final int i, final int i2) {
        int i3;
        boolean z5;
        int i4;
        boolean z6;
        int i5;
        int i6;
        boolean z7;
        int i7;
        boolean z8;
        final boolean z9;
        final boolean z10;
        final boolean z11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        State stateCollectAsStateWithLifecycle;
        ListItemInfo listItemInfo;
        String title;
        String str;
        int i8;
        Function0<ComposeUiNode> constructor;
        int i9;
        boolean z16;
        Object objRememberedValue;
        boolean z17;
        Object objRememberedValue2;
        SecondaryActionType secondaryActionType;
        boolean z18;
        int i10;
        boolean z19;
        Object objRememberedValue3;
        boolean z20;
        HubsScreenKt$HubItem$4$1 hubsScreenKt$HubItem$4$1RememberedValue;
        boolean z21;
        HubsScreenKt$HubItem$1$1 hubsScreenKt$HubItem$1$1RememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1759144743);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubItem)N(store,itemsScreenMode,isLastItem,isSelecting,isSelected,isRedesignedVersion)252@9916L29,257@10106L22:HubsScreen.kt#l88pwb");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(itemsScreenMode.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
            if ((i & 3072) == 0) {
                z5 = z2;
                i3 |= composerStartRestartGroup.changed(z5) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z6 = z3;
                    if (composerStartRestartGroup.changed(z6)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z7 = z4;
                        if (composerStartRestartGroup.changed(z7)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((74899 & i3) != 74898) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z9 = z5;
                        z10 = z6;
                        z11 = z7;
                    } else {
                        if (i11 != 0) {
                            z12 = false;
                        } else {
                            z12 = z5;
                        }
                        if (i4 != 0) {
                            z13 = false;
                        } else {
                            z13 = z6;
                        }
                        z14 = z13;
                        if (i6 != 0) {
                            z15 = false;
                        } else {
                            z15 = z7;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                        }
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                        if (title == null) {
                            str = "";
                        } else {
                            str = title;
                        }
                        listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                        if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                            composerStartRestartGroup.startReplaceGroup(500339241);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(510497135);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                            Unit unit = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z21 = true;
                            } else {
                                z21 = false;
                            }
                            hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z21 || hubsScreenKt$HubItem$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                        if (i8 != 1) {
                            composerStartRestartGroup.startReplaceGroup(510733758);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                            Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int i12 = i3;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                            i9 = i12 & 14;
                            if (i9 == 4) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z16 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                            if (i9 == 4) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z17 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ClickActionsConfig clickActionsConfig = new ClickActionsConfig(function0, (Function0) objRememberedValue2, null, null, 12, null);
                            if (z12) {
                                secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                            } else {
                                secondaryActionType = SecondaryActionType.None.INSTANCE;
                            }
                            z18 = z14;
                            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i12 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i12 << 6) & 29360128), 330);
                            composerStartRestartGroup = composerStartRestartGroup;
                            HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i12 >> 3) & 126);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            if (i8 == 2) {
                                composerStartRestartGroup.startReplaceGroup(1679042203);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(511598131);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                            ItemThumbnail thumbnail = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                            String description = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                            String str2 = description != null ? description : "";
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                            i10 = i3 & 14;
                            if (i10 == 4) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z19 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return HubsScreenKt.HubItem$lambda$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                            if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                                composerStartRestartGroup.startReplaceGroup(500339241);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(511980237);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                                Unit unit3 = Unit.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                                if (i10 == 4) {
                                    z20 = true;
                                } else {
                                    z20 = false;
                                }
                                hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z20 || hubsScreenKt$HubItem$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                    composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit4 = Unit.INSTANCE;
                            z18 = z14;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z9 = z12;
                        z10 = z18;
                        z11 = z15;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z7 = z4;
                if ((74899 & i3) != 74898) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z5;
                    z10 = z6;
                    z11 = z7;
                } else {
                    if (i11 != 0) {
                        z12 = false;
                    } else {
                        z12 = z5;
                    }
                    if (i4 != 0) {
                        z13 = false;
                    } else {
                        z13 = z6;
                    }
                    z14 = z13;
                    if (i6 != 0) {
                        z15 = false;
                    } else {
                        z15 = z7;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                    if (title == null) {
                        str = "";
                    } else {
                        str = title;
                    }
                    listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                    if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                        composerStartRestartGroup.startReplaceGroup(510497135);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                        Unit unit5 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z21) {
                            hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                        } else {
                            hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(500339241);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                    if (i8 != 1) {
                        composerStartRestartGroup.startReplaceGroup(510733758);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                        Alignment bottomStart2 = Alignment.INSTANCE.getBottomStart();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart2, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i13 = i3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                        i9 = i13 & 14;
                        if (i9 == 4) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z16) {
                            objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function1 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                        if (i9 == 4) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z17) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ClickActionsConfig clickActionsConfig2 = new ClickActionsConfig(function1, (Function0) objRememberedValue2, null, null, 12, null);
                        if (z12) {
                            secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                        } else {
                            secondaryActionType = SecondaryActionType.None.INSTANCE;
                        }
                        z18 = z14;
                        BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig2, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i13 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i13 << 6) & 29360128), 330);
                        composerStartRestartGroup = composerStartRestartGroup;
                        HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i13 >> 3) & 126);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit6 = Unit.INSTANCE;
                    } else {
                        if (i8 == 2) {
                            composerStartRestartGroup.startReplaceGroup(1679042203);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(511598131);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                        ItemThumbnail thumbnail2 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                        String description2 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                        if (description2 != null) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                        i10 = i3 & 14;
                        if (i10 == 4) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z19) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail2, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                        if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                            composerStartRestartGroup.startReplaceGroup(500339241);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(511980237);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                            Unit unit7 = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                            if (i10 == 4) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                            } else {
                                hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit8 = Unit.INSTANCE;
                        z18 = z14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z9 = z12;
                    z10 = z18;
                    z11 = z15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z6 = z3;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z7 = z4;
                    if (composerStartRestartGroup.changed(z7)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z5;
                    z10 = z6;
                    z11 = z7;
                } else {
                    if (i11 != 0) {
                        z12 = false;
                    } else {
                        z12 = z5;
                    }
                    if (i4 != 0) {
                        z13 = false;
                    } else {
                        z13 = z6;
                    }
                    z14 = z13;
                    if (i6 != 0) {
                        z15 = false;
                    } else {
                        z15 = z7;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                    if (title == null) {
                        str = "";
                    } else {
                        str = title;
                    }
                    listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                    if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                        composerStartRestartGroup.startReplaceGroup(510497135);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                        Unit unit9 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z21) {
                            hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                        } else {
                            hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(500339241);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                    if (i8 != 1) {
                        composerStartRestartGroup.startReplaceGroup(510733758);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                        Alignment bottomStart3 = Alignment.INSTANCE.getBottomStart();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart3, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i14 = i3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                        i9 = i14 & 14;
                        if (i9 == 4) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z16) {
                            objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function2 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                        if (i9 == 4) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z17) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ClickActionsConfig clickActionsConfig3 = new ClickActionsConfig(function2, (Function0) objRememberedValue2, null, null, 12, null);
                        if (z12) {
                            secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                        } else {
                            secondaryActionType = SecondaryActionType.None.INSTANCE;
                        }
                        z18 = z14;
                        BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig3, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i14 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i14 << 6) & 29360128), 330);
                        composerStartRestartGroup = composerStartRestartGroup;
                        HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i14 >> 3) & 126);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit10 = Unit.INSTANCE;
                    } else {
                        if (i8 == 2) {
                            composerStartRestartGroup.startReplaceGroup(1679042203);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(511598131);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                        ItemThumbnail thumbnail3 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                        String description3 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                        if (description3 != null) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                        i10 = i3 & 14;
                        if (i10 == 4) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z19) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail3, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                        if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                            composerStartRestartGroup.startReplaceGroup(500339241);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(511980237);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                            Unit unit11 = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                            if (i10 == 4) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                            } else {
                                hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit12 = Unit.INSTANCE;
                        z18 = z14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z9 = z12;
                    z10 = z18;
                    z11 = z15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z7 = z4;
            if ((74899 & i3) != 74898) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z5;
                z10 = z6;
                z11 = z7;
            } else {
                if (i11 != 0) {
                    z12 = false;
                } else {
                    z12 = z5;
                }
                if (i4 != 0) {
                    z13 = false;
                } else {
                    z13 = z6;
                }
                z14 = z13;
                if (i6 != 0) {
                    z15 = false;
                } else {
                    z15 = z7;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                if (title == null) {
                    str = "";
                } else {
                    str = title;
                }
                listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                    composerStartRestartGroup.startReplaceGroup(510497135);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                    Unit unit13 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z21) {
                        hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                    } else {
                        hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(500339241);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                if (i8 != 1) {
                    composerStartRestartGroup.startReplaceGroup(510733758);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                    Alignment bottomStart4 = Alignment.INSTANCE.getBottomStart();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart4, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i15 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                    i9 = i15 & 14;
                    if (i9 == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z16) {
                        objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function3 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                    if (i9 == 4) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z17) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ClickActionsConfig clickActionsConfig4 = new ClickActionsConfig(function3, (Function0) objRememberedValue2, null, null, 12, null);
                    if (z12) {
                        secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                    } else {
                        secondaryActionType = SecondaryActionType.None.INSTANCE;
                    }
                    z18 = z14;
                    BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig4, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i15 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i15 << 6) & 29360128), 330);
                    composerStartRestartGroup = composerStartRestartGroup;
                    HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i15 >> 3) & 126);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit14 = Unit.INSTANCE;
                } else {
                    if (i8 == 2) {
                        composerStartRestartGroup.startReplaceGroup(1679042203);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(511598131);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                    ItemThumbnail thumbnail4 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                    String description4 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                    if (description4 != null) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                    i10 = i3 & 14;
                    if (i10 == 4) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z19) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail4, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                    if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                        composerStartRestartGroup.startReplaceGroup(500339241);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(511980237);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                        Unit unit15 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                        if (i10 == 4) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                        } else {
                            hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit16 = Unit.INSTANCE;
                    z18 = z14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z9 = z12;
                z10 = z18;
                z11 = z15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z5 = z2;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z6 = z3;
                if (composerStartRestartGroup.changed(z6)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z7 = z4;
                    if (composerStartRestartGroup.changed(z7)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z5;
                    z10 = z6;
                    z11 = z7;
                } else {
                    if (i11 != 0) {
                        z12 = false;
                    } else {
                        z12 = z5;
                    }
                    if (i4 != 0) {
                        z13 = false;
                    } else {
                        z13 = z6;
                    }
                    z14 = z13;
                    if (i6 != 0) {
                        z15 = false;
                    } else {
                        z15 = z7;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                    if (title == null) {
                        str = "";
                    } else {
                        str = title;
                    }
                    listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                    if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                        composerStartRestartGroup.startReplaceGroup(510497135);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                        Unit unit17 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z21) {
                            hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                        } else {
                            hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit17, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(500339241);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                    if (i8 != 1) {
                        composerStartRestartGroup.startReplaceGroup(510733758);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                        Alignment bottomStart5 = Alignment.INSTANCE.getBottomStart();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart5, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i16 = i3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                        i9 = i16 & 14;
                        if (i9 == 4) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z16) {
                            objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function4 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                        if (i9 == 4) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z17) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ClickActionsConfig clickActionsConfig5 = new ClickActionsConfig(function4, (Function0) objRememberedValue2, null, null, 12, null);
                        if (z12) {
                            secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                        } else {
                            secondaryActionType = SecondaryActionType.None.INSTANCE;
                        }
                        z18 = z14;
                        BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig5, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i16 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i16 << 6) & 29360128), 330);
                        composerStartRestartGroup = composerStartRestartGroup;
                        HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i16 >> 3) & 126);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit18 = Unit.INSTANCE;
                    } else {
                        if (i8 == 2) {
                            composerStartRestartGroup.startReplaceGroup(1679042203);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(511598131);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                        ItemThumbnail thumbnail5 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                        String description5 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                        if (description5 != null) {
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                        i10 = i3 & 14;
                        if (i10 == 4) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z19) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return HubsScreenKt.HubItem$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail5, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                        if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                            composerStartRestartGroup.startReplaceGroup(500339241);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(511980237);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                            Unit unit19 = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                            if (i10 == 4) {
                                z20 = true;
                            } else {
                                z20 = false;
                            }
                            hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z20) {
                                hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                            } else {
                                hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                                composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(unit19, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit110 = Unit.INSTANCE;
                        z18 = z14;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z9 = z12;
                    z10 = z18;
                    z11 = z15;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z7 = z4;
            if ((74899 & i3) != 74898) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z5;
                z10 = z6;
                z11 = z7;
            } else {
                if (i11 != 0) {
                    z12 = false;
                } else {
                    z12 = z5;
                }
                if (i4 != 0) {
                    z13 = false;
                } else {
                    z13 = z6;
                }
                z14 = z13;
                if (i6 != 0) {
                    z15 = false;
                } else {
                    z15 = z7;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                if (title == null) {
                    str = "";
                } else {
                    str = title;
                }
                listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                    composerStartRestartGroup.startReplaceGroup(510497135);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                    Unit unit111 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z21) {
                        hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                    } else {
                        hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(500339241);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                if (i8 != 1) {
                    composerStartRestartGroup.startReplaceGroup(510733758);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                    Alignment bottomStart6 = Alignment.INSTANCE.getBottomStart();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart6, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i17 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                    i9 = i17 & 14;
                    if (i9 == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z16) {
                        objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function5 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                    if (i9 == 4) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z17) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ClickActionsConfig clickActionsConfig6 = new ClickActionsConfig(function5, (Function0) objRememberedValue2, null, null, 12, null);
                    if (z12) {
                        secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                    } else {
                        secondaryActionType = SecondaryActionType.None.INSTANCE;
                    }
                    z18 = z14;
                    BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig6, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i17 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i17 << 6) & 29360128), 330);
                    composerStartRestartGroup = composerStartRestartGroup;
                    HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i17 >> 3) & 126);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit112 = Unit.INSTANCE;
                } else {
                    if (i8 == 2) {
                        composerStartRestartGroup.startReplaceGroup(1679042203);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(511598131);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                    ItemThumbnail thumbnail6 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                    String description6 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                    if (description6 != null) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                    i10 = i3 & 14;
                    if (i10 == 4) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z19) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail6, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                    if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                        composerStartRestartGroup.startReplaceGroup(500339241);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(511980237);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                        Unit unit113 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                        if (i10 == 4) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                        } else {
                            hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit114 = Unit.INSTANCE;
                    z18 = z14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z9 = z12;
                z10 = z18;
                z11 = z15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z6 = z3;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z7 = z4;
                if (composerStartRestartGroup.changed(z7)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z9 = z5;
                z10 = z6;
                z11 = z7;
            } else {
                if (i11 != 0) {
                    z12 = false;
                } else {
                    z12 = z5;
                }
                if (i4 != 0) {
                    z13 = false;
                } else {
                    z13 = z6;
                }
                z14 = z13;
                if (i6 != 0) {
                    z15 = false;
                } else {
                    z15 = z7;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
                if (title == null) {
                    str = "";
                } else {
                    str = title;
                }
                listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
                if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                    composerStartRestartGroup.startReplaceGroup(510497135);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                    Unit unit115 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z21) {
                        hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                    } else {
                        hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(500339241);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
                if (i8 != 1) {
                    composerStartRestartGroup.startReplaceGroup(510733758);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                    Alignment bottomStart7 = Alignment.INSTANCE.getBottomStart();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart7, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion7);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i18 = i3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                    i9 = i18 & 14;
                    if (i9 == 4) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z16) {
                        objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function6 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                    if (i9 == 4) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z17) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$2$1$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ClickActionsConfig clickActionsConfig7 = new ClickActionsConfig(function6, (Function0) objRememberedValue2, null, null, 12, null);
                    if (z12) {
                        secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                    } else {
                        secondaryActionType = SecondaryActionType.None.INSTANCE;
                    }
                    z18 = z14;
                    BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig7, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i18 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i18 << 6) & 29360128), 330);
                    composerStartRestartGroup = composerStartRestartGroup;
                    HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i18 >> 3) & 126);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit116 = Unit.INSTANCE;
                } else {
                    if (i8 == 2) {
                        composerStartRestartGroup.startReplaceGroup(1679042203);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(511598131);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                    ItemThumbnail thumbnail7 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                    String description7 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                    if (description7 != null) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                    i10 = i3 & 14;
                    if (i10 == 4) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z19) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HubsScreenKt.HubItem$lambda$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail7, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                    if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                        composerStartRestartGroup.startReplaceGroup(500339241);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(511980237);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                        Unit unit117 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                        if (i10 == 4) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z20) {
                            hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                        } else {
                            hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                    composerStartRestartGroup.endReplaceGroup();
                    Unit unit118 = Unit.INSTANCE;
                    z18 = z14;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z9 = z12;
                z10 = z18;
                z11 = z15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z7 = z4;
        if ((74899 & i3) != 74898) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z8, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z9 = z5;
            z10 = z6;
            z11 = z7;
        } else {
            if (i11 != 0) {
                z12 = false;
            } else {
                z12 = z5;
            }
            if (i4 != 0) {
                z13 = false;
            } else {
                z13 = z6;
            }
            z14 = z13;
            if (i6 != 0) {
                z15 = false;
            } else {
                z15 = z7;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1759144743, i3, -1, "com.box.android.hubs.presentation.HubItem (HubsScreen.kt:251)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            title = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getTitle();
            if (title == null) {
                str = "";
            } else {
                str = title;
            }
            listItemInfo = new ListItemInfo(str, HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().getThumbnail(), hubsDescription(HubItem$lambda$0(stateCollectAsStateWithLifecycle), composerStartRestartGroup, 0), "Hub:" + HubItem$lambda$0(stateCollectAsStateWithLifecycle).getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
            if (HubItem$lambda$0(stateCollectAsStateWithLifecycle).getIconThumbnailState().isThumbnailFetchAttempted()) {
                composerStartRestartGroup.startReplaceGroup(510497135);
                ComposerKt.sourceInformation(composerStartRestartGroup, "262@10265L117,262@10244L138");
                Unit unit119 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679036590, "CC(remember):HubsScreen.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                hubsScreenKt$HubItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z21) {
                    hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                } else {
                    hubsScreenKt$HubItem$1$1RememberedValue = new HubsScreenKt$HubItem$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$1$1RememberedValue, composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(500339241);
                composerStartRestartGroup.endReplaceGroup();
            }
            i8 = WhenMappings.$EnumSwitchMapping$1[itemsScreenMode.ordinal()];
            if (i8 != 1) {
                composerStartRestartGroup.startReplaceGroup(510733758);
                ComposerKt.sourceInformation(composerStartRestartGroup, "269@10465L819");
                Alignment bottomStart8 = Alignment.INSTANCE.getBottomStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion8 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart8, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion8);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i19 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -484544953, "C274@10735L93,277@10879L101,270@10529L673,285@11220L50:HubsScreen.kt#l88pwb");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678192524, "CC(remember):HubsScreen.kt#9igjgp");
                i9 = i19 & 14;
                if (i9 == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z16) {
                    objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubItem$lambda$2$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubItem$lambda$2$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function7 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1678187908, "CC(remember):HubsScreen.kt#9igjgp");
                if (i9 == 4) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z17) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubItem$lambda$2$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubItem$lambda$2$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ClickActionsConfig clickActionsConfig8 = new ClickActionsConfig(function7, (Function0) objRememberedValue2, null, null, 12, null);
                if (z12) {
                    secondaryActionType = SecondaryActionType.Checkbox.INSTANCE;
                } else {
                    secondaryActionType = SecondaryActionType.None.INSTANCE;
                }
                z18 = z14;
                BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z18, false, clickActionsConfig8, secondaryActionType, 0, z15, null, composerStartRestartGroup, ((i19 >> 6) & 896) | (SecondaryActionType.$stable << 15) | ((i19 << 6) & 29360128), 330);
                composerStartRestartGroup = composerStartRestartGroup;
                HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i19 >> 3) & 126);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                Unit unit1110 = Unit.INSTANCE;
            } else {
                if (i8 == 2) {
                    composerStartRestartGroup.startReplaceGroup(1679042203);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(511598131);
                ComposerKt.sourceInformation(composerStartRestartGroup, "294@11564L77,290@11342L313,305@11930L50");
                ItemThumbnail thumbnail8 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().getThumbnail();
                String description8 = HubItem$lambda$0(stateCollectAsStateWithLifecycle).getDescription();
                if (description8 != null) {
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679078118, "CC(remember):HubsScreen.kt#9igjgp");
                i10 = i3 & 14;
                if (i10 == 4) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z19) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubItem$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HubsScreenKt.HubItem$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxHubCardItemKt.BoxHubCardItem(listItemInfo, thumbnail8, str2, (Function0) objRememberedValue3, composerStartRestartGroup, ItemThumbnail.$stable << 3);
                if (!HubItem$lambda$0(stateCollectAsStateWithLifecycle).getBannerThumbnailState().isThumbnailFetchAttempted()) {
                    composerStartRestartGroup.startReplaceGroup(500339241);
                } else {
                    composerStartRestartGroup.startReplaceGroup(511980237);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "300@11767L135,300@11746L156");
                    Unit unit1111 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1679084672, "CC(remember):HubsScreen.kt#9igjgp");
                    if (i10 == 4) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    hubsScreenKt$HubItem$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z20) {
                        hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                    } else {
                        hubsScreenKt$HubItem$4$1RememberedValue = new HubsScreenKt$HubItem$4$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(hubsScreenKt$HubItem$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit1111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) hubsScreenKt$HubItem$4$1RememberedValue, composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                HubsScreenItemDivider(itemsScreenMode, z, composerStartRestartGroup, (i3 >> 3) & 126);
                composerStartRestartGroup.endReplaceGroup();
                Unit unit1112 = Unit.INSTANCE;
                z18 = z14;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z9 = z12;
            z10 = z18;
            z11 = z15;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.HubItem$lambda$5(store, itemsScreenMode, z, z9, z10, z11, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubItem$lambda$2$0$0(Store store) {
        store.send(HubReducer.Action.Clicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubItem$lambda$2$1$0(Store store) {
        store.send(HubReducer.Action.CheckboxClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubItem$lambda$3$0(Store store) {
        store.send(HubReducer.Action.Clicked.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void ErrorScreen(final DomainError domainError, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(921065569);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ErrorScreen)N(domainError,retryClicked):HubsScreen.kt#l88pwb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(domainError) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function1 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(921065569, i2, -1, "com.box.android.hubs.presentation.ErrorScreen (HubsScreen.kt:311)");
            }
            if (DomainErrorKt.isNetworkConnectionError(domainError)) {
                composerStartRestartGroup.startReplaceGroup(-1081569395);
                ComposerKt.sourceInformation(composerStartRestartGroup, "313@12148L36");
                ItemStateScreensKt.NetworkConnectionError(function0, false, composerStartRestartGroup, (i2 >> 3) & 14, 2);
                composerStartRestartGroup.endReplaceGroup();
                function1 = function0;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1081505907);
                ComposerKt.sourceInformation(composerStartRestartGroup, "315@12206L228");
                function1 = function0;
                ItemStateScreensKt.GenericErrorScreen(function1, false, R.string.error_loading_hubs, Integer.valueOf(R.string.error_loading_hubs_subtitle), 0, "HubsGenericError", composerStartRestartGroup, ((i2 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenKt.ErrorScreen$lambda$0(domainError, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsReducer.State HubsScreen$lambda$0(State<HubsReducer.State> state) {
        return state.getValue();
    }

    private static final HubsReducer.State HubListingScreen$lambda$0(State<HubsReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsReducer.State HubsList$lambda$0(State<HubsReducer.State> state) {
        return state.getValue();
    }

    private static final HubReducer.State HubItem$lambda$0(State<HubReducer.State> state) {
        return state.getValue();
    }
}

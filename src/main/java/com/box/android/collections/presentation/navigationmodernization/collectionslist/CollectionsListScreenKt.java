package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.EmptyItemsWithPullToRefreshWorkaroundKt;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.divider.BoxItemListingDividerKt;
import com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt;
import com.box.android.base.presentation.components.snackbar.ErrorSnackbarKt;
import com.box.android.collections.R;
import com.box.android.cpl.Store;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxItem;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.hc.core5.http.HttpStatus;

/* JADX INFO: compiled from: CollectionsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001aA\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002\u001aE\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0015\u001a9\u0010\u0016\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010\u001d\u001a\u0015\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010!\u001a\r\u0010\"\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010!¨\u0006#²\u0006\n\u0010\r\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"CollectionsListScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "onCollectionClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/CollectionModel;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)V", "refreshDataIfNeeded", "state", "CollectionsListWithPullToRefresh", BoxItem.FIELD_COLLECTIONS, "", "isRefreshing", "", "onPullToRefresh", "Lkotlin/Function0;", "(Ljava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CollectionsList", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollectionItem", BoxCollection.TYPE, ViewProps.ON_CLICK, "(Lcom/box/android/domain/models/CollectionModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollectionItemIcon", "(Lcom/box/android/domain/models/CollectionModel;Landroidx/compose/runtime/Composer;I)V", "CollectionsListScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "EmptyCollectionsListScreenPreview", "collections_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionsListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItem$lambda$2(CollectionModel collectionModel, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollectionItem(collectionModel, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemIcon$lambda$1(CollectionModel collectionModel, int i, Composer composer, int i2) {
        CollectionItemIcon(collectionModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsList$lambda$0(List list, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollectionsList(list, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsList$lambda$2(List list, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollectionsList(list, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$3(Store store, Function1 function1, SnackbarHostState snackbarHostState, int i, int i2, Composer composer, int i3) {
        CollectionsListScreen(store, function1, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreenPreview$lambda$0(int i, Composer composer, int i2) {
        CollectionsListScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListWithPullToRefresh$lambda$1(List list, boolean z, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        CollectionsListWithPullToRefresh(list, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyCollectionsListScreenPreview$lambda$0(int i, Composer composer, int i2) {
        EmptyCollectionsListScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0297  */
    /* JADX WARN: Code duplicated, block: B:101:0x0299  */
    /* JADX WARN: Code duplicated, block: B:106:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:109:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:111:0x02de  */
    /* JADX WARN: Code duplicated, block: B:112:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:115:0x0301  */
    /* JADX WARN: Code duplicated, block: B:120:0x0310  */
    /* JADX WARN: Code duplicated, block: B:123:0x0325  */
    /* JADX WARN: Code duplicated, block: B:124:0x0327  */
    /* JADX WARN: Code duplicated, block: B:129:0x0336  */
    /* JADX WARN: Code duplicated, block: B:131:0x0353  */
    /* JADX WARN: Code duplicated, block: B:135:0x037a  */
    /* JADX WARN: Code duplicated, block: B:137:0x037f  */
    /* JADX WARN: Code duplicated, block: B:139:0x038e  */
    /* JADX WARN: Code duplicated, block: B:142:0x0398  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0115  */
    /* JADX WARN: Code duplicated, block: B:54:0x0121  */
    /* JADX WARN: Code duplicated, block: B:55:0x0125  */
    /* JADX WARN: Code duplicated, block: B:58:0x0183  */
    /* JADX WARN: Code duplicated, block: B:60:0x0198  */
    /* JADX WARN: Code duplicated, block: B:61:0x019a  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:71:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:77:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:83:0x020a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0220  */
    /* JADX WARN: Code duplicated, block: B:87:0x0235  */
    /* JADX WARN: Code duplicated, block: B:88:0x0237  */
    /* JADX WARN: Code duplicated, block: B:93:0x0246  */
    /* JADX WARN: Code duplicated, block: B:96:0x026a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0274  */
    public static final void CollectionsListScreen(final Store<CollectionsListReducer.State, CollectionsListReducer.Action> store, final Function1<? super CollectionModel, Unit> onCollectionClick, SnackbarHostState snackbarHostState, Composer composer, final int i, final int i2) {
        int i3;
        SnackbarHostState snackbarHostState2;
        int i4;
        boolean z;
        final SnackbarHostState snackbarHostState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SnackbarHostState snackbarHostState4;
        final State stateCollectAsStateWithLifecycle;
        int i5;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        CollectionsListReducer.LoadingState loadingState;
        boolean z4;
        Object objRememberedValue2;
        SnackbarHostState snackbarHostState5;
        DomainError error;
        boolean z5;
        Object objRememberedValue3;
        boolean z6;
        Object objRememberedValue4;
        boolean z7;
        Object objRememberedValue5;
        boolean z8;
        Object objRememberedValue6;
        boolean z9;
        CollectionsListScreenKt$CollectionsListScreen$2$1$1 collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue;
        String str;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onCollectionClick, "onCollectionClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1894233526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionsListScreen)N(store,onCollectionClick,snackbarHostState)57@2735L29,60@2823L113,59@2770L2257:CollectionsListScreen.kt#60bvu");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCollectionClick) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                snackbarHostState2 = snackbarHostState;
                i3 |= composerStartRestartGroup.changed(snackbarHostState2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                snackbarHostState3 = snackbarHostState2;
            } else {
                if (i6 != 0) {
                    snackbarHostState4 = null;
                } else {
                    snackbarHostState4 = snackbarHostState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1894233526, i4, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreen (CollectionsListScreen.kt:56)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -707704473, "CC(remember):CollectionsListScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                i5 = i4 & 14;
                if (i5 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChanged | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionsListScreenKt.CollectionsListScreen$lambda$1$0(store, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion, 0L, 0.0f, null, (Function1) objRememberedValue, 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnVisibilityChanged$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -26484621, "C:CollectionsListScreen.kt#60bvu");
                loadingState = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getLoadingState();
                if (Intrinsics.areEqual(loadingState, CollectionsListReducer.LoadingState.Loading.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-26436975);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3098L97,68@3077L118,71@3212L46");
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386324995, "CC(remember):CollectionsListScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z9 || collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        str = null;
                        collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue = new CollectionsListScreenKt$CollectionsListScreen$2$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue);
                    } else {
                        str = null;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue, composerStartRestartGroup, 6);
                    ItemStateScreensKt.LoadingItemsScreen(str, true, composerStartRestartGroup, 48, 1);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (loadingState instanceof CollectionsListReducer.LoadingState.Error) {
                        composerStartRestartGroup.startReplaceGroup(-26153449);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (DomainErrorKt.isNetworkConnectionError(((CollectionsListReducer.LoadingState.Error) loadingState).getError())) {
                            composerStartRestartGroup.startReplaceGroup(-26094983);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3487L61,76@3425L197");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386312583, "CC(remember):CollectionsListScreen.kt#9igjgp");
                            if (i5 == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionsListScreenKt.CollectionsListScreen$lambda$2$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue6, true, composerStartRestartGroup, 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-25854051);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "82@3726L61,81@3668L193");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386304935, "CC(remember):CollectionsListScreen.kt#9igjgp");
                            if (i5 == 4) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!z7 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionsListScreenKt.CollectionsListScreen$lambda$2$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, true, 0, null, 0, null, composerStartRestartGroup, 48, 60);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        if (Intrinsics.areEqual(loadingState, CollectionsListReducer.LoadingState.Loaded.INSTANCE)) {
                            composerStartRestartGroup.startReplaceGroup(-1386327664);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-25523932);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "92@4151L114,89@3971L371");
                        List<CollectionModel> collections = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getCollections();
                        boolean zIsRefreshing = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386291282, "CC(remember):CollectionsListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionsListScreenKt.CollectionsListScreen$lambda$2$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsListWithPullToRefresh(collections, zIsRefreshing, (Function0) objRememberedValue2, onCollectionClick, composerStartRestartGroup, (i4 << 6) & 7168);
                        if (snackbarHostState4 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1386282043);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            error = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getError();
                            if (error == null) {
                                composerStartRestartGroup.startReplaceGroup(-25070372);
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup = composerStartRestartGroup;
                                snackbarHostState5 = snackbarHostState4;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-25070371);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4640L131,106@4813L118,100@4465L492");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 654827097, "CC(remember):CollectionsListScreen.kt#9igjgp");
                                if (i5 == 4) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionsListScreenKt.CollectionsListScreen$lambda$2$4$0$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                Function0 function0 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 654832620, "CC(remember):CollectionsListScreen.kt#9igjgp");
                                if (i5 == 4) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionsListScreenKt.CollectionsListScreen$lambda$2$4$1$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup = composerStartRestartGroup;
                                snackbarHostState5 = snackbarHostState4;
                                ErrorSnackbarKt.ErrorSnackbar(error, snackbarHostState5, function0, (Function0) objRememberedValue4, composerStartRestartGroup, (i4 >> 3) & 112);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            snackbarHostState5 = snackbarHostState4;
                            composerStartRestartGroup.startReplaceGroup(-29479098);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    snackbarHostState3 = snackbarHostState5;
                }
                snackbarHostState5 = snackbarHostState4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsListScreenKt.CollectionsListScreen$lambda$3(store, onCollectionClick, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        snackbarHostState2 = snackbarHostState;
        i4 = i3;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            snackbarHostState3 = snackbarHostState2;
        } else {
            if (i6 != 0) {
                snackbarHostState4 = null;
            } else {
                snackbarHostState4 = snackbarHostState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1894233526, i4, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreen (CollectionsListScreen.kt:56)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -707704473, "CC(remember):CollectionsListScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            i5 = i4 & 14;
            if (i5 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChanged2 | z2;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionsListScreenKt.CollectionsListScreen$lambda$1$0(store, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionsListScreenKt.CollectionsListScreen$lambda$1$0(store, stateCollectAsStateWithLifecycle, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnVisibilityChanged$default2 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(companion2, 0L, 0.0f, null, (Function1) objRememberedValue, 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnVisibilityChanged$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -26484621, "C:CollectionsListScreen.kt#60bvu");
            loadingState = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getLoadingState();
            if (Intrinsics.areEqual(loadingState, CollectionsListReducer.LoadingState.Loading.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-26436975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3098L97,68@3077L118,71@3212L46");
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386324995, "CC(remember):CollectionsListScreen.kt#9igjgp");
                if (i5 == 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z9) {
                    str = null;
                    collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue = new CollectionsListScreenKt$CollectionsListScreen$2$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue);
                } else {
                    str = null;
                    collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue = new CollectionsListScreenKt$CollectionsListScreen$2$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionsListScreenKt$CollectionsListScreen$2$1$1RememberedValue, composerStartRestartGroup, 6);
                ItemStateScreensKt.LoadingItemsScreen(str, true, composerStartRestartGroup, 48, 1);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (loadingState instanceof CollectionsListReducer.LoadingState.Error) {
                    composerStartRestartGroup.startReplaceGroup(-26153449);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (DomainErrorKt.isNetworkConnectionError(((CollectionsListReducer.LoadingState.Error) loadingState).getError())) {
                        composerStartRestartGroup.startReplaceGroup(-26094983);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3487L61,76@3425L197");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386312583, "CC(remember):CollectionsListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionsListScreenKt.CollectionsListScreen$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionsListScreenKt.CollectionsListScreen$lambda$2$1$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue6, true, composerStartRestartGroup, 48, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-25854051);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "82@3726L61,81@3668L193");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386304935, "CC(remember):CollectionsListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionsListScreenKt.CollectionsListScreen$lambda$2$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionsListScreenKt.CollectionsListScreen$lambda$2$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, true, 0, null, 0, null, composerStartRestartGroup, 48, 60);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (Intrinsics.areEqual(loadingState, CollectionsListReducer.LoadingState.Loaded.INSTANCE)) {
                        composerStartRestartGroup.startReplaceGroup(-1386327664);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-25523932);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "92@4151L114,89@3971L371");
                    List<CollectionModel> collections2 = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getCollections();
                    boolean zIsRefreshing2 = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1386291282, "CC(remember):CollectionsListScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z4) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CollectionsListScreenKt.CollectionsListScreen$lambda$2$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CollectionsListScreenKt.CollectionsListScreen$lambda$2$3$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CollectionsListWithPullToRefresh(collections2, zIsRefreshing2, (Function0) objRememberedValue2, onCollectionClick, composerStartRestartGroup, (i4 << 6) & 7168);
                    if (snackbarHostState4 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1386282043);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        error = CollectionsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getError();
                        if (error == null) {
                            composerStartRestartGroup.startReplaceGroup(-25070372);
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup = composerStartRestartGroup;
                            snackbarHostState5 = snackbarHostState4;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-25070371);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4640L131,106@4813L118,100@4465L492");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 654827097, "CC(remember):CollectionsListScreen.kt#9igjgp");
                            if (i5 == 4) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z5) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionsListScreenKt.CollectionsListScreen$lambda$2$4$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionsListScreenKt.CollectionsListScreen$lambda$2$4$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function1 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 654832620, "CC(remember):CollectionsListScreen.kt#9igjgp");
                            if (i5 == 4) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionsListScreenKt.CollectionsListScreen$lambda$2$4$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionsListScreenKt.CollectionsListScreen$lambda$2$4$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup = composerStartRestartGroup;
                            snackbarHostState5 = snackbarHostState4;
                            ErrorSnackbarKt.ErrorSnackbar(error, snackbarHostState5, function1, (Function0) objRememberedValue4, composerStartRestartGroup, (i4 >> 3) & 112);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        snackbarHostState5 = snackbarHostState4;
                        composerStartRestartGroup.startReplaceGroup(-29479098);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState5;
            }
            snackbarHostState5 = snackbarHostState4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            snackbarHostState3 = snackbarHostState5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionsListScreen$lambda$3(store, onCollectionClick, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$1$0(Store store, State state, boolean z) {
        if (z) {
            refreshDataIfNeeded(CollectionsListScreen$lambda$0(state), store);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$2$1$0(Store store) {
        store.send(CollectionsListReducer.Action.LoadCollections.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$2$2$0(Store store) {
        store.send(CollectionsListReducer.Action.LoadCollections.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$2$3$0(Store store) {
        store.send(new CollectionsListReducer.Action.RefreshCollections(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$2$4$0$0(Store store) {
        store.send(new CollectionsListReducer.Action.RefreshCollections(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsListScreen$lambda$2$4$1$0(Store store) {
        store.send(CollectionsListReducer.Action.DismissError.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void refreshDataIfNeeded(CollectionsListReducer.State state, Store<CollectionsListReducer.State, CollectionsListReducer.Action> store) {
        if (state.getLoadingState() instanceof CollectionsListReducer.LoadingState.Loaded) {
            store.send(new CollectionsListReducer.Action.RefreshCollections(false));
        }
        if (state.getLoadingState() instanceof CollectionsListReducer.LoadingState.Error) {
            store.send(CollectionsListReducer.Action.LoadCollections.INSTANCE);
        }
    }

    private static final void CollectionsListWithPullToRefresh(final List<CollectionModel> list, final boolean z, final Function0<Unit> function0, final Function1<? super CollectionModel, Unit> function1, Composer composer, final int i) {
        List<CollectionModel> list2;
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(371179570);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionsListWithPullToRefresh)N(collections,isRefreshing,onPullToRefresh,onCollectionClick)141@5941L28,151@6232L6,143@5975L649:CollectionsListScreen.kt#60bvu");
        if ((i & 6) == 0) {
            list2 = list;
            i2 = (composerStartRestartGroup.changedInstance(list2) ? 4 : 2) | i;
        } else {
            list2 = list;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(371179570, i2, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListWithPullToRefresh (CollectionsListScreen.kt:140)");
            }
            PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), z, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, function0, 12, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1731396527, "C153@6270L162,159@6442L176:CollectionsListScreen.kt#60bvu");
            CollectionsList(list2, function1, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, (i2 & 14) | 384 | ((i2 >> 6) & 112), 0);
            BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState, z, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, i2 & 112, 0);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionsListWithPullToRefresh$lambda$1(list, z, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:53:0x0107  */
    /* JADX WARN: Code duplicated, block: B:58:0x0118  */
    /* JADX WARN: Code duplicated, block: B:61:0x013a  */
    /* JADX WARN: Code duplicated, block: B:63:0x013f  */
    /* JADX WARN: Code duplicated, block: B:66:0x014b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0159 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    private static final void CollectionsList(final List<CollectionModel> list, final Function1<? super CollectionModel, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Function1<? super CollectionModel, Unit> function2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function3;
        Modifier modifier4;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(884638684);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionsList)N(collections,onCollectionClick,modifier)191@7604L497,188@7441L660:CollectionsListScreen.kt#60bvu");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                function2 = function1;
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(884638684, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsList (CollectionsListScreen.kt:172)");
                }
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(351904167);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "179@7183L47,180@7258L50,176@7028L386");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(new ItemsStateConfig(R.drawable.ic_collectionstar140, StringResources_androidKt.stringResource(R.string.empty_collections_text, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.empty_collections_subtext, composerStartRestartGroup, 0), null, 8, null), "EmptyCollections", true, composerStartRestartGroup, 432, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final Modifier modifier5 = modifier4;
                    function3 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CollectionsListScreenKt.CollectionsList$lambda$0(list, function1, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    function2 = function1;
                    Modifier modifier6 = modifier4;
                    composerStartRestartGroup.startReplaceGroup(345110982);
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierTestTag = TestTagKt.testTag(modifier6, "CollectionsList");
                    PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -265718195, "CC(remember):CollectionsListScreen.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i3 & 112) == 32);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CollectionsListScreenKt.CollectionsList$lambda$1$0(list, function2, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LazyDslKt.LazyColumn(modifierTestTag, null, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 506);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function3);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1<? super CollectionModel, Unit> function4 = function2;
                function3 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsListScreenKt.CollectionsList$lambda$2(list, function4, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function3);
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            function2 = function1;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(884638684, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsList (CollectionsListScreen.kt:172)");
            }
            if (list.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(351904167);
                ComposerKt.sourceInformation(composerStartRestartGroup, "179@7183L47,180@7258L50,176@7028L386");
                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(new ItemsStateConfig(R.drawable.ic_collectionstar140, StringResources_androidKt.stringResource(R.string.empty_collections_text, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.empty_collections_subtext, composerStartRestartGroup, 0), null, 8, null), "EmptyCollections", true, composerStartRestartGroup, 432, 0);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                }
                final Modifier modifier7 = modifier4;
                function3 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsListScreenKt.CollectionsList$lambda$0(list, function1, modifier7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            } else {
                function2 = function1;
                Modifier modifier8 = modifier4;
                composerStartRestartGroup.startReplaceGroup(345110982);
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierTestTag2 = TestTagKt.testTag(modifier8, "CollectionsList");
                PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default2 = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -265718195, "CC(remember):CollectionsListScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i3 & 112) == 32);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionsListScreenKt.CollectionsList$lambda$1$0(list, function2, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionsListScreenKt.CollectionsList$lambda$1$0(list, function2, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyColumn(modifierTestTag2, null, paddingValuesM1215PaddingValuesa9UjIt4$default2, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 506);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function3);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function5 = function2;
            function3 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionsList$lambda$2(list, function5, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionsList$lambda$1$0(final List list, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function2 = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsListScreenKt.CollectionsList$lambda$1$0$0((CollectionModel) obj);
            }
        };
        final CollectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$1 collectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(CollectionModel collectionModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((CollectionModel) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function2.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return collectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$CollectionsList$lambda$1$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final CollectionModel collectionModel = (CollectionModel) list.get(i);
                composer.startReplaceGroup(1338080832);
                ComposerKt.sourceInformation(composer, "CN(collection)*196@7720L365:CollectionsListScreen.kt#60bvu");
                Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
                ComposerKt.sourceInformationMarkerStart(composer, -479715000, "C199@7875L33,197@7784L142:CollectionsListScreen.kt#60bvu");
                ComposerKt.sourceInformationMarkerStart(composer, 538717309, "CC(remember):CollectionsListScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(collectionModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$CollectionsList$2$1$2$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function3.invoke(collectionModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CollectionsListScreenKt.CollectionItem(collectionModel, (Function0) objRememberedValue, null, composer, 0, 4);
                if (Intrinsics.areEqual(collectionModel.getId(), ((CollectionModel) CollectionsKt.last(list)).getId())) {
                    composer.startReplaceGroup(-487446618);
                } else {
                    composer.startReplaceGroup(-479518957);
                    ComposerKt.sourceInformation(composer, "203@8010L43");
                    BoxItemListingDividerKt.m11726BoxItemListingDivideryajeYGU(Dp.m9687constructorimpl(68), 0.0f, 0.0f, composer, 6, 6);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object CollectionsList$lambda$1$0$0(CollectionModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:46:0x0107  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    public static final void CollectionItem(final CollectionModel collectionModel, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1878554844);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItem)N(collection,onClick,modifier)213@8267L219,224@8629L54,228@8765L6,229@8826L6,227@8719L134,212@8231L628:CollectionsListScreen.kt#60bvu");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(collectionModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1878554844, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionItem (CollectionsListScreen.kt:211)");
                }
                composer2 = composerStartRestartGroup;
                ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(-1944600390, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsListScreenKt.CollectionItem$lambda$0(collectionModel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ClickableKt.m632clickableoSLSa3U$default(SizeKt.m1252height3ABfNKs(companion, BoxSizes.INSTANCE.m11612getListItemHeightD9Ej5fM()), false, null, null, null, function0, 15, null), null, null, ComposableLambdaKt.rememberComposableLambda(-1698037058, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsListScreenKt.CollectionItem$lambda$1(collectionModel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ListItemDefaults.INSTANCE.m3668colorsJ08w3E(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, ListItemDefaults.$stable << 27, 508), 0.0f, 0.0f, composer2, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionsListScreenKt.CollectionItem$lambda$2(collectionModel, function0, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1878554844, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionItem (CollectionsListScreen.kt:211)");
            }
            composer2 = composerStartRestartGroup;
            ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(-1944600390, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionItem$lambda$0(collectionModel, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ClickableKt.m632clickableoSLSa3U$default(SizeKt.m1252height3ABfNKs(companion, BoxSizes.INSTANCE.m11612getListItemHeightD9Ej5fM()), false, null, null, null, function0, 15, null), null, null, ComposableLambdaKt.rememberComposableLambda(-1698037058, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionItem$lambda$1(collectionModel, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ListItemDefaults.INSTANCE.m3668colorsJ08w3E(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, ListItemDefaults.$stable << 27, 508), 0.0f, 0.0f, composer2, 24582, HttpStatus.SC_PRECONDITION_REQUIRED);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionItem$lambda$2(collectionModel, function0, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItem$lambda$0(CollectionModel collectionModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C214@8281L195:CollectionsListScreen.kt#60bvu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1944600390, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionItem.<anonymous> (CollectionsListScreen.kt:214)");
            }
            TextKt.m4494TextNvy7gAk(collectionModel.getName(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 24960, 110590);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItem$lambda$1(CollectionModel collectionModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C225@8643L30:CollectionsListScreen.kt#60bvu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1698037058, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionItem.<anonymous> (CollectionsListScreen.kt:225)");
            }
            CollectionItemIcon(collectionModel, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CollectionItemIcon(final CollectionModel collectionModel, Composer composer, final int i) {
        int i2;
        Pair pair;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1206970082);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItemIcon)N(collection)247@9404L341:CollectionsListScreen.kt#60bvu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(collectionModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1206970082, i2, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionItemIcon (CollectionsListScreen.kt:235)");
            }
            if (collectionModel.getType() == CollectionType.FAVORITES) {
                composerStartRestartGroup.startReplaceGroup(-620344912);
                ComposerKt.sourceInformation(composerStartRestartGroup, "237@9049L6,237@9100L6");
                pair = new Pair(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11508getCollectionFavoritesIconBackground0d7_KjU()), Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11507getCollectionFavoritesIcon0d7_KjU()));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-620228414);
                ComposerKt.sourceInformation(composerStartRestartGroup, "239@9167L6,239@9209L6");
                pair = new Pair(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11510getCollectionIconBackground0d7_KjU()), Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11509getCollectionIcon0d7_KjU()));
                composerStartRestartGroup.endReplaceGroup();
            }
            long jM6824unboximpl = ((Color) pair.component1()).m6824unboximpl();
            long jM6824unboximpl2 = ((Color) pair.component2()).m6824unboximpl();
            if (collectionModel.getType() == CollectionType.FAVORITES) {
                i3 = R.drawable.ic_collections_star;
            } else {
                i3 = R.drawable.ic_collections;
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(32)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(8))), jM6824unboximpl, null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -109759612, "C255@9636L24,254@9608L131:CollectionsListScreen.kt#60bvu");
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i3, composerStartRestartGroup, 0), (String) null, (Modifier) null, jM6824unboximpl2, composerStartRestartGroup, Painter.$stable | 48, 4);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionItemIcon$lambda$1(collectionModel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void CollectionsListScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(383052184);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionsListScreenPreview)267@9881L1324:CollectionsListScreen.kt#60bvu");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(383052184, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenPreview (CollectionsListScreen.kt:266)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$CollectionsListScreenKt.INSTANCE.getLambda$382700579$collections_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.CollectionsListScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void EmptyCollectionsListScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1306223257);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyCollectionsListScreenPreview)313@11293L334:CollectionsListScreen.kt#60bvu");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1306223257, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionslist.EmptyCollectionsListScreenPreview (CollectionsListScreen.kt:312)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$CollectionsListScreenKt.INSTANCE.m12399getLambda$55518788$collections_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsListScreenKt.EmptyCollectionsListScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final CollectionsListReducer.State CollectionsListScreen$lambda$0(State<CollectionsListReducer.State> state) {
        return state.getValue();
    }
}

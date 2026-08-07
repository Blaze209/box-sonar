package com.box.android.browse.compose;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.EmptyItemsWithPullToRefreshWorkaroundKt;
import com.box.android.base.compose.BoxListViewItemKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.ViewInteropNestedScrollConnectionKt;
import com.box.android.base.compose.divider.BoxSelectionAwareDividerKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt;
import com.box.android.base.compose.semantics.BoxSemanticsProperties;
import com.box.android.base.models.ClickActionsConfig;
import com.box.android.base.models.ListItemInfo;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.base.presentation.fragments.IBoxFragmentActivity;
import com.box.android.base.utilities.OfflineManagerExtensionsKt;
import com.box.android.browse.R;
import com.box.android.browse.cpl.browse.FilesListingConfigBarKt;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.utilities.BoxFeatureBanner;
import com.box.android.browse.utilities.TestTagUtilsKt;
import com.box.android.common.extensions.ContextExtensionsKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.models.ItemId;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
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

/* JADX INFO: compiled from: FolderListingScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2a\b\u0002\u0010\f\u001a[\b\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a¨\u0001\u0010\u001b\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2a\b\u0002\u0010\f\u001a[\b\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001d\u001a\u008e\u0001\u0010\u001e\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u001f\u001a\u00020 2a\b\u0002\u0010\f\u001a[\b\u0001\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\rH\u0003¢\u0006\u0002\u0010!\u001a;\u0010\"\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010#\u001aA\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010+\u001aS\u0010,\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u001c\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u00101\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00102\u001a\r\u00103\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00104¨\u00065²\u0006\n\u0010\u001c\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"FolderListingScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "emptyScreenConfig", "Lcom/box/android/base/compose/ItemsStateConfig;", "defaultSecondaryActionType", "Lcom/box/android/base/models/SecondaryActionType;", "onShowSnackbar", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "message", "actionLabel", "Landroidx/compose/material3/SnackbarDuration;", "duration", "Lkotlin/coroutines/Continuation;", "Landroidx/compose/material3/SnackbarResult;", "", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Lcom/box/android/base/compose/ItemsStateConfig;Lcom/box/android/base/models/SecondaryActionType;Lkotlin/jvm/functions/Function4;ZLandroidx/compose/runtime/Composer;II)V", "ItemsWithPullToRefresh", "state", "(Lcom/box/android/cpl/Store;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lcom/box/android/base/compose/ItemsStateConfig;Lcom/box/android/base/models/SecondaryActionType;Lkotlin/jvm/functions/Function4;ZLandroidx/compose/runtime/Composer;II)V", "ShowSnackbarEffect", "errorRes", "", "(Lcom/box/android/cpl/Store;ILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ItemsList", "(Lcom/box/android/cpl/Store;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;ZLcom/box/android/base/models/SecondaryActionType;Landroidx/compose/runtime/Composer;II)V", "FeatureBanner", "visibility", HubsObservability.HUB_ASSET_BANNER, "Lcom/box/android/browse/utilities/BoxFeatureBanner;", ViewProps.ON_CLICK, "Lkotlin/Function0;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "(ZLcom/box/android/browse/utilities/BoxFeatureBanner;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BrowseItem", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "secondaryActionType", "isSelected", "fetchThumbnail", "isCheckboxEnabled", "(Lcom/box/android/cpl/Store;Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;Lcom/box/android/base/models/SecondaryActionType;ZZZZLandroidx/compose/runtime/Composer;II)V", "LoadMoreItem", "(Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FolderListingScreenKt {

    /* JADX INFO: compiled from: FolderListingScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FilesDisplayConfigReducer.ConfigBarMode.values().length];
            try {
                iArr[FilesDisplayConfigReducer.ConfigBarMode.SORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilesDisplayConfigReducer.ConfigBarMode.FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FilesDisplayConfigReducer.ConfigBarMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$7(Store store, ItemReducer.State state, SecondaryActionType secondaryActionType, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Composer composer, int i3) {
        BrowseItem(store, state, secondaryActionType, z, z2, z3, z4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureBanner$lambda$1(boolean z, BoxFeatureBanner boxFeatureBanner, Function0 function0, Function0 function1, boolean z2, int i, Composer composer, int i2) {
        FeatureBanner(z, boxFeatureBanner, function0, function1, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderListingScreen$lambda$2(Store store, Modifier modifier, ItemsStateConfig itemsStateConfig, SecondaryActionType secondaryActionType, Function4 function4, boolean z, int i, int i2, Composer composer, int i3) {
        FolderListingScreen(store, modifier, itemsStateConfig, secondaryActionType, function4, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsList$lambda$1(Store store, ItemsListReducer.State state, boolean z, SecondaryActionType secondaryActionType, int i, int i2, Composer composer, int i3) {
        ItemsList(store, state, z, secondaryActionType, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsWithPullToRefresh$lambda$3(Store store, ItemsListReducer.State state, ItemsStateConfig itemsStateConfig, SecondaryActionType secondaryActionType, Function4 function4, boolean z, int i, int i2, Composer composer, int i3) {
        ItemsWithPullToRefresh(store, state, itemsStateConfig, secondaryActionType, function4, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadMoreItem$lambda$1(int i, Composer composer, int i2) {
        LoadMoreItem(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowSnackbarEffect$lambda$3(Store store, int i, Function4 function4, int i2, int i3, Composer composer, int i4) {
        ShowSnackbarEffect(store, i, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0135  */
    /* JADX WARN: Code duplicated, block: B:104:0x0187  */
    /* JADX WARN: Code duplicated, block: B:106:0x018e  */
    /* JADX WARN: Code duplicated, block: B:109:0x019c  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ee A[PHI: r0 r3 r5 r6 r8
      0x00ee: PHI (r0v10 androidx.compose.ui.Modifier) = (r0v3 androidx.compose.ui.Modifier), (r0v11 androidx.compose.ui.Modifier) binds: [B:97:0x0129, B:83:0x00e8] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r3v21 com.box.android.base.compose.ItemsStateConfig) = (r3v17 com.box.android.base.compose.ItemsStateConfig), (r3v24 com.box.android.base.compose.ItemsStateConfig) binds: [B:97:0x0129, B:83:0x00e8] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r5v10 com.box.android.base.models.SecondaryActionType) = (r5v5 com.box.android.base.models.SecondaryActionType), (r5v13 com.box.android.base.models.SecondaryActionType) binds: [B:97:0x0129, B:83:0x00e8] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r6v13 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>) = 
      (r6v7 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
      (r6v14 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
     binds: [B:97:0x0129, B:83:0x00e8] A[DONT_GENERATE, DONT_INLINE]
      0x00ee: PHI (r8v16 int) = (r8v9 int), (r8v17 int) binds: [B:97:0x0129, B:83:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:93:0x0119  */
    /* JADX WARN: Code duplicated, block: B:95:0x0121  */
    /* JADX WARN: Code duplicated, block: B:98:0x012b  */
    public static final void FolderListingScreen(final Store<ItemsListReducer.State, ItemsListReducer.Action> store, Modifier modifier, ItemsStateConfig itemsStateConfig, SecondaryActionType secondaryActionType, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        ItemsStateConfig itemsStateConfig2;
        int i4;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function5;
        int i5;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        final SecondaryActionType secondaryActionType2;
        final Modifier modifier3;
        final ItemsStateConfig itemsStateConfig3;
        final Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function6;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        SecondaryActionType secondaryActionType3;
        Modifier modifier4;
        int i8;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function7;
        final boolean z5;
        int i9;
        boolean zChangedInstance;
        SecondaryActionType.None none = secondaryActionType;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(412001213);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderListingScreen)N(store,modifier,emptyScreenConfig,defaultSecondaryActionType,onShowSnackbar,isRedesignedVersion)100@5014L29,101@5089L43,101@5135L2476,101@5048L2563:FolderListingScreen.kt#9mvyw3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    itemsStateConfig2 = itemsStateConfig;
                    int i11 = composerStartRestartGroup.changed(itemsStateConfig2) ? 256 : 128;
                    i3 |= i11;
                } else {
                    itemsStateConfig2 = itemsStateConfig;
                }
                i3 |= i11;
            } else {
                itemsStateConfig2 = itemsStateConfig;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) != 0) {
                    i9 = 1024;
                } else {
                    if ((i & 4096) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(none);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(none);
                    }
                    if (zChangedInstance) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                }
                i3 |= i9;
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
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                            }
                            if ((i2 & 8) != 0) {
                                none = SecondaryActionType.None.INSTANCE;
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            Modifier modifier5 = companion;
                            secondaryActionType3 = none;
                            modifier4 = modifier5;
                            ItemsStateConfig itemsStateConfig4 = itemsStateConfig2;
                            i8 = i3;
                            itemsStateConfig3 = itemsStateConfig4;
                            function7 = function5;
                            if (i6 != 0) {
                                z5 = false;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                            }
                            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                            Modifier modifier6 = modifier4;
                            secondaryActionType2 = secondaryActionType3;
                            function6 = function7;
                            SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z5;
                            modifier3 = modifier6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            ItemsStateConfig itemsStateConfig5 = itemsStateConfig2;
                            i8 = i3;
                            itemsStateConfig3 = itemsStateConfig5;
                            secondaryActionType3 = none;
                            modifier4 = modifier2;
                            function7 = function5;
                        }
                        z5 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                        }
                        final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        Modifier modifier7 = modifier4;
                        secondaryActionType2 = secondaryActionType3;
                        function6 = function7;
                        SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z5;
                        modifier3 = modifier7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        secondaryActionType2 = none;
                        modifier3 = modifier2;
                        itemsStateConfig3 = itemsStateConfig2;
                        function6 = function5;
                        z4 = z2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        Modifier modifier8 = companion;
                        secondaryActionType3 = none;
                        modifier4 = modifier8;
                        ItemsStateConfig itemsStateConfig6 = itemsStateConfig2;
                        i8 = i3;
                        itemsStateConfig3 = itemsStateConfig6;
                        function7 = function5;
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        Modifier modifier9 = companion;
                        secondaryActionType3 = none;
                        modifier4 = modifier9;
                        ItemsStateConfig itemsStateConfig7 = itemsStateConfig2;
                        i8 = i3;
                        itemsStateConfig3 = itemsStateConfig7;
                        function7 = function5;
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                    }
                    final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    Modifier modifier10 = modifier4;
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    modifier3 = modifier10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    itemsStateConfig3 = itemsStateConfig2;
                    function6 = function5;
                    z4 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function4;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        Modifier modifier11 = companion;
                        secondaryActionType3 = none;
                        modifier4 = modifier11;
                        ItemsStateConfig itemsStateConfig8 = itemsStateConfig2;
                        i8 = i3;
                        itemsStateConfig3 = itemsStateConfig8;
                        function7 = function5;
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        Modifier modifier12 = companion;
                        secondaryActionType3 = none;
                        modifier4 = modifier12;
                        ItemsStateConfig itemsStateConfig9 = itemsStateConfig2;
                        i8 = i3;
                        itemsStateConfig3 = itemsStateConfig9;
                        function7 = function5;
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                    }
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    Modifier modifier13 = modifier4;
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    modifier3 = modifier13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    itemsStateConfig3 = itemsStateConfig2;
                    function6 = function5;
                    z4 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    Modifier modifier14 = companion;
                    secondaryActionType3 = none;
                    modifier4 = modifier14;
                    ItemsStateConfig itemsStateConfig10 = itemsStateConfig2;
                    i8 = i3;
                    itemsStateConfig3 = itemsStateConfig10;
                    function7 = function5;
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    Modifier modifier15 = companion;
                    secondaryActionType3 = none;
                    modifier4 = modifier15;
                    ItemsStateConfig itemsStateConfig11 = itemsStateConfig2;
                    i8 = i3;
                    itemsStateConfig3 = itemsStateConfig11;
                    function7 = function5;
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                }
                final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Modifier modifier16 = modifier4;
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                modifier3 = modifier16;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                itemsStateConfig3 = itemsStateConfig2;
                function6 = function5;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                itemsStateConfig2 = itemsStateConfig;
                if (composerStartRestartGroup.changed(itemsStateConfig2)) {
                }
                i3 |= i11;
            } else {
                itemsStateConfig2 = itemsStateConfig;
            }
            i3 |= i11;
        } else {
            itemsStateConfig2 = itemsStateConfig;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i9 = 1024;
            } else {
                if ((i & 4096) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(none);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(none);
                }
                if (zChangedInstance) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
            }
            i3 |= i9;
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
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        Modifier modifier17 = companion;
                        secondaryActionType3 = none;
                        modifier4 = modifier17;
                        ItemsStateConfig itemsStateConfig12 = itemsStateConfig2;
                        i8 = i3;
                        itemsStateConfig3 = itemsStateConfig12;
                        function7 = function5;
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                        }
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        Modifier modifier18 = companion;
                        secondaryActionType3 = none;
                        modifier4 = modifier18;
                        ItemsStateConfig itemsStateConfig13 = itemsStateConfig2;
                        i8 = i3;
                        itemsStateConfig3 = itemsStateConfig13;
                        function7 = function5;
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                    }
                    final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    Modifier modifier19 = modifier4;
                    secondaryActionType2 = secondaryActionType3;
                    function6 = function7;
                    SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    modifier3 = modifier19;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    modifier3 = modifier2;
                    itemsStateConfig3 = itemsStateConfig2;
                    function6 = function5;
                    z4 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    Modifier modifier110 = companion;
                    secondaryActionType3 = none;
                    modifier4 = modifier110;
                    ItemsStateConfig itemsStateConfig14 = itemsStateConfig2;
                    i8 = i3;
                    itemsStateConfig3 = itemsStateConfig14;
                    function7 = function5;
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    Modifier modifier111 = companion;
                    secondaryActionType3 = none;
                    modifier4 = modifier111;
                    ItemsStateConfig itemsStateConfig15 = itemsStateConfig2;
                    i8 = i3;
                    itemsStateConfig3 = itemsStateConfig15;
                    function7 = function5;
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                }
                final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Modifier modifier112 = modifier4;
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                modifier3 = modifier112;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                itemsStateConfig3 = itemsStateConfig2;
                function6 = function5;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function5 = function4;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    Modifier modifier113 = companion;
                    secondaryActionType3 = none;
                    modifier4 = modifier113;
                    ItemsStateConfig itemsStateConfig16 = itemsStateConfig2;
                    i8 = i3;
                    itemsStateConfig3 = itemsStateConfig16;
                    function7 = function5;
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                    }
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    Modifier modifier114 = companion;
                    secondaryActionType3 = none;
                    modifier4 = modifier114;
                    ItemsStateConfig itemsStateConfig17 = itemsStateConfig2;
                    i8 = i3;
                    itemsStateConfig3 = itemsStateConfig17;
                    function7 = function5;
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
                }
                final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Modifier modifier115 = modifier4;
                secondaryActionType2 = secondaryActionType3;
                function6 = function7;
                SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
                modifier3 = modifier115;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                modifier3 = modifier2;
                itemsStateConfig3 = itemsStateConfig2;
                function6 = function5;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                }
                if ((i2 & 8) != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                Modifier modifier116 = companion;
                secondaryActionType3 = none;
                modifier4 = modifier116;
                ItemsStateConfig itemsStateConfig18 = itemsStateConfig2;
                i8 = i3;
                itemsStateConfig3 = itemsStateConfig18;
                function7 = function5;
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    itemsStateConfig2 = new ItemsStateConfig(R.drawable.ic_folderfloat140, CommonBoxUtil.LS(R.string.empty_folder_text), null, null, 12, null);
                }
                if ((i2 & 8) != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                Modifier modifier117 = companion;
                secondaryActionType3 = none;
                modifier4 = modifier117;
                ItemsStateConfig itemsStateConfig19 = itemsStateConfig2;
                i8 = i3;
                itemsStateConfig3 = itemsStateConfig19;
                function7 = function5;
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(412001213, i8, -1, "com.box.android.browse.compose.FolderListingScreen (FolderListingScreen.kt:99)");
            }
            final State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Modifier modifier118 = modifier4;
            secondaryActionType2 = secondaryActionType3;
            function6 = function7;
            SurfaceKt.m4323SurfaceT9BRK9s(NestedScrollModifierKt.nestedScroll$default(modifier4, ViewInteropNestedScrollConnectionKt.rememberViewInteropNestedScrollConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1472235198, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.FolderListingScreen$lambda$1(z5, store, itemsStateConfig3, secondaryActionType2, function6, stateCollectAsStateWithLifecycle9, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
            modifier3 = modifier118;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            secondaryActionType2 = none;
            modifier3 = modifier2;
            itemsStateConfig3 = itemsStateConfig2;
            function6 = function5;
            z4 = z2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.FolderListingScreen$lambda$2(store, modifier3, itemsStateConfig3, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderListingScreen$lambda$1(boolean z, Store store, ItemsStateConfig itemsStateConfig, SecondaryActionType secondaryActionType, Function4 function4, State state, Composer composer, int i) {
        String strStringResource;
        String strStringResource2;
        ComposerKt.sourceInformation(composer, "C:FolderListingScreen.kt#9mvyw3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1472235198, i, -1, "com.box.android.browse.compose.FolderListingScreen.<anonymous> (FolderListingScreen.kt:102)");
            }
            ItemsListReducer.LoadingState itemLoadingState = FolderListingScreen$lambda$0(state).getItemLoadingState();
            if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Loading.INSTANCE)) {
                composer.startReplaceGroup(847344661);
                ComposerKt.sourceInformation(composer, "104@5248L61,105@5365L86,105@5326L125");
                ItemStateScreensKt.LoadingItemsScreen(null, z, composer, 0, 1);
                ItemsListReducer.LoadingState itemLoadingState2 = FolderListingScreen$lambda$0(state).getItemLoadingState();
                ComposerKt.sourceInformationMarkerStart(composer, -1773777448, "CC(remember):FolderListingScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                FolderListingScreenKt$FolderListingScreen$1$1$1 folderListingScreenKt$FolderListingScreen$1$1$1RememberedValue = composer.rememberedValue();
                if (zChanged || folderListingScreenKt$FolderListingScreen$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$FolderListingScreen$1$1$1RememberedValue = new FolderListingScreenKt$FolderListingScreen$1$1$1(store, null);
                    composer.updateRememberedValue(folderListingScreenKt$FolderListingScreen$1$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(itemLoadingState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$FolderListingScreen$1$1$1RememberedValue, composer, 0);
                composer.endReplaceGroup();
            } else if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Error.INSTANCE)) {
                composer.startReplaceGroup(847645888);
                ComposerKt.sourceInformation(composer, "111@5536L577,124@6151L89,124@6130L110");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                int i2 = R.drawable.ic_folderfloat140;
                Integer error = FolderListingScreen$lambda$0(state).getError();
                if (error == null) {
                    composer.startReplaceGroup(847864654);
                    composer.endReplaceGroup();
                    strStringResource2 = null;
                } else {
                    composer.startReplaceGroup(847864655);
                    ComposerKt.sourceInformation(composer, "*116@5791L85");
                    strStringResource2 = StringResources_androidKt.stringResource(error.intValue(), composer, 0);
                    composer.endReplaceGroup();
                }
                if (strStringResource2 == null) {
                    strStringResource2 = CommonBoxUtil.LS(R.string.box_browsesdk_problem_fetching_folder);
                }
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i2, strStringResource2, null, null, 12, null), "ErrorItemStateScreen", modifierFillMaxSize$default, false, z, 0L, composer, 432, 40);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1773752293, "CC(remember):FolderListingScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                FolderListingScreenKt$FolderListingScreen$1$3$1 folderListingScreenKt$FolderListingScreen$1$3$1RememberedValue = composer.rememberedValue();
                if (zChanged2 || folderListingScreenKt$FolderListingScreen$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$FolderListingScreen$1$3$1RememberedValue = new FolderListingScreenKt$FolderListingScreen$1$3$1(store, null);
                    composer.updateRememberedValue(folderListingScreenKt$FolderListingScreen$1$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$FolderListingScreen$1$3$1RememberedValue, composer, 6);
                composer.endReplaceGroup();
            } else if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.ForbiddenByPolicy.INSTANCE)) {
                composer.startReplaceGroup(848440387);
                ComposerKt.sourceInformation(composer, "130@6337L574,143@6949L89,143@6928L110");
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                int i3 = R.drawable.ic_shield_blocked_state;
                Integer error2 = FolderListingScreen$lambda$0(state).getError();
                if (error2 == null) {
                    composer.startReplaceGroup(848665198);
                    composer.endReplaceGroup();
                    strStringResource = null;
                } else {
                    composer.startReplaceGroup(848665199);
                    ComposerKt.sourceInformation(composer, "*135@6598L85");
                    strStringResource = StringResources_androidKt.stringResource(error2.intValue(), composer, 0);
                    composer.endReplaceGroup();
                }
                if (strStringResource == null) {
                    strStringResource = CommonBoxUtil.LS(R.string.shield_blocked_state);
                }
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i3, strStringResource, null, null, 12, null), "ForbiddenByPolicyStateScreen", modifierFillMaxSize$default2, false, z, 0L, composer, 432, 40);
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1773726757, "CC(remember):FolderListingScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(store);
                FolderListingScreenKt$FolderListingScreen$1$5$1 folderListingScreenKt$FolderListingScreen$1$5$1RememberedValue = composer.rememberedValue();
                if (zChanged3 || folderListingScreenKt$FolderListingScreen$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$FolderListingScreen$1$5$1RememberedValue = new FolderListingScreenKt$FolderListingScreen$1$5$1(store, null);
                    composer.updateRememberedValue(folderListingScreenKt$FolderListingScreen$1$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$FolderListingScreen$1$5$1RememberedValue, composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(849182775);
                ComposerKt.sourceInformation(composer, "149@7092L362,157@7492L89,157@7471L110");
                ItemsWithPullToRefresh(store, FolderListingScreen$lambda$0(state), itemsStateConfig, secondaryActionType, function4, z, composer, SecondaryActionType.$stable << 9, 0);
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1773709381, "CC(remember):FolderListingScreen.kt#9igjgp");
                boolean zChanged4 = composer.changed(store);
                FolderListingScreenKt$FolderListingScreen$1$6$1 folderListingScreenKt$FolderListingScreen$1$6$1RememberedValue = composer.rememberedValue();
                if (zChanged4 || folderListingScreenKt$FolderListingScreen$1$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$FolderListingScreen$1$6$1RememberedValue = new FolderListingScreenKt$FolderListingScreen$1$6$1(store, null);
                    composer.updateRememberedValue(folderListingScreenKt$FolderListingScreen$1$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$FolderListingScreen$1$6$1RememberedValue, composer, 6);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:103:0x0213  */
    /* JADX WARN: Code duplicated, block: B:106:0x026d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0279  */
    /* JADX WARN: Code duplicated, block: B:110:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:112:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:115:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:49:0x0096  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da A[PHI: r3 r5 r9
      0x00da: PHI (r3v34 com.box.android.base.models.SecondaryActionType) = 
      (r3v2 com.box.android.base.models.SecondaryActionType)
      (r3v0 com.box.android.base.models.SecondaryActionType)
      (r3v0 com.box.android.base.models.SecondaryActionType)
     binds: [B:79:0x00ec, B:70:0x00d6, B:71:0x00d8] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r5v28 int) = (r5v14 int), (r5v11 int), (r5v29 int) binds: [B:79:0x00ec, B:70:0x00d6, B:71:0x00d8] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r9v9 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>) = 
      (r9v4 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
      (r9v2 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
      (r9v2 kotlin.jvm.functions.Function4<? super java.lang.String, ? super java.lang.String, ? super androidx.compose.material3.SnackbarDuration, ? super kotlin.coroutines.Continuation<? super androidx.compose.material3.SnackbarResult>, ? extends java.lang.Object>)
     binds: [B:79:0x00ec, B:70:0x00d6, B:71:0x00d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:74:0x00df  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x011f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0126  */
    /* JADX WARN: Code duplicated, block: B:92:0x012e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0189  */
    /* JADX WARN: Code duplicated, block: B:98:0x0195  */
    /* JADX WARN: Code duplicated, block: B:99:0x0199  */
    public static final void ItemsWithPullToRefresh(final Store<ItemsListReducer.State, ItemsListReducer.Action> store, final ItemsListReducer.State state, final ItemsStateConfig emptyScreenConfig, SecondaryActionType secondaryActionType, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function5;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final SecondaryActionType secondaryActionType2;
        final Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function6;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function7;
        SecondaryActionType secondaryActionType3;
        int i7;
        boolean z5;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        SecondaryActionType secondaryActionType4;
        int i8;
        Integer error;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function8;
        int i9;
        SecondaryActionType.None none = secondaryActionType;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(emptyScreenConfig, "emptyScreenConfig");
        Composer composerStartRestartGroup = composer.startRestartGroup(-299729656);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemsWithPullToRefresh)N(store,state,emptyScreenConfig,defaultSecondaryActionType,onShowSnackbar,isRedesignedVersion)175@8117L28,182@8365L55,176@8150L952:FolderListingScreen.kt#9mvyw3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(emptyScreenConfig) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i9 = 1024;
            } else {
                if ((i & 4096) == 0 ? composerStartRestartGroup.changed(none) : composerStartRestartGroup.changedInstance(none)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
            }
            i3 |= i9;
        }
        int i10 = i2 & 16;
        if (i10 == 0) {
            if ((i & 24576) == 0) {
                function5 = function4;
                i3 |= composerStartRestartGroup.changedInstance(function5) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if ((i2 & 8) != 0) {
                            none = SecondaryActionType.None.INSTANCE;
                            i3 &= -7169;
                        }
                        if (i10 != 0) {
                            function5 = null;
                        }
                        if (i4 != 0) {
                            i6 = i3;
                            z2 = false;
                        }
                        function7 = function5;
                        secondaryActionType3 = none;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-299729656, i6, -1, "com.box.android.browse.compose.ItemsWithPullToRefresh (FolderListingScreen.kt:174)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean pullToRefreshIsRefreshing = state.getPullToRefreshIsRefreshing();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -277368193, "CC(remember):FolderListingScreen.kt#9igjgp");
                        i7 = i6 & 14;
                        z5 = i7 == 4;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxHeight$default, pullToRefreshIsRefreshing, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, (Function0) objRememberedValue, 12, null);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400057252, "C199@8901L195:FolderListingScreen.kt#9mvyw3");
                        if (state.getItems().isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(-1400045318);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "186@8492L142");
                            boolean z6 = z2;
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(emptyScreenConfig, null, z6, composerStartRestartGroup, ((i6 >> 6) & 14) | ((i6 >> 9) & 896), 2);
                            composerStartRestartGroup.endReplaceGroup();
                            z4 = z6;
                            secondaryActionType4 = secondaryActionType3;
                        } else {
                            boolean z7 = z2;
                            composerStartRestartGroup.startReplaceGroup(-1399872369);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "191@8664L217");
                            ItemsList(store, state, z7, secondaryActionType3, composerStartRestartGroup, (i6 & 126) | ((i6 >> 9) & 896) | (SecondaryActionType.$stable << 9) | (i6 & 7168), 0);
                            z4 = z7;
                            secondaryActionType4 = secondaryActionType3;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        i8 = i6;
                        BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState, state.getPullToRefreshIsRefreshing(), boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        error = state.getError();
                        if (error == null) {
                            composerStartRestartGroup.startReplaceGroup(-7726028);
                            composerStartRestartGroup.endReplaceGroup();
                            function8 = function7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-7726027);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9147L133");
                            function8 = function7;
                            ShowSnackbarEffect(store, error.intValue(), function8, composerStartRestartGroup, i7 | ((i8 >> 6) & 896), 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function8;
                        secondaryActionType2 = secondaryActionType4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                    }
                    i6 = i3;
                    function7 = function5;
                    secondaryActionType3 = none;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-299729656, i6, -1, "com.box.android.browse.compose.ItemsWithPullToRefresh (FolderListingScreen.kt:174)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState2 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                    boolean pullToRefreshIsRefreshing2 = state.getPullToRefreshIsRefreshing();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -277368193, "CC(remember):FolderListingScreen.kt#9igjgp");
                    i7 = i6 & 14;
                    if (i7 == 4) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default2 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxHeight$default2, pullToRefreshIsRefreshing2, pullToRefreshStateRememberPullToRefreshState2, false, 0.0f, (Function0) objRememberedValue, 12, null);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400057252, "C199@8901L195:FolderListingScreen.kt#9mvyw3");
                    if (state.getItems().isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(-1400045318);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "186@8492L142");
                        boolean z8 = z2;
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(emptyScreenConfig, null, z8, composerStartRestartGroup, ((i6 >> 6) & 14) | ((i6 >> 9) & 896), 2);
                        composerStartRestartGroup.endReplaceGroup();
                        z4 = z8;
                        secondaryActionType4 = secondaryActionType3;
                    } else {
                        boolean z9 = z2;
                        composerStartRestartGroup.startReplaceGroup(-1399872369);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "191@8664L217");
                        ItemsList(store, state, z9, secondaryActionType3, composerStartRestartGroup, (i6 & 126) | ((i6 >> 9) & 896) | (SecondaryActionType.$stable << 9) | (i6 & 7168), 0);
                        z4 = z9;
                        secondaryActionType4 = secondaryActionType3;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    i8 = i6;
                    BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState2, state.getPullToRefreshIsRefreshing(), boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    error = state.getError();
                    if (error == null) {
                        composerStartRestartGroup.startReplaceGroup(-7726028);
                        composerStartRestartGroup.endReplaceGroup();
                        function8 = function7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7726027);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9147L133");
                        function8 = function7;
                        ShowSnackbarEffect(store, error.intValue(), function8, composerStartRestartGroup, i7 | ((i8 >> 6) & 896), 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function8;
                    secondaryActionType2 = secondaryActionType4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    secondaryActionType2 = none;
                    function6 = function5;
                    z4 = z2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$3(store, state, emptyScreenConfig, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        function5 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        z2 = false;
                    } else {
                        i6 = i3;
                    }
                } else {
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        function5 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        z2 = false;
                    } else {
                        i6 = i3;
                    }
                }
                function7 = function5;
                secondaryActionType3 = none;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-299729656, i6, -1, "com.box.android.browse.compose.ItemsWithPullToRefresh (FolderListingScreen.kt:174)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState3 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierFillMaxHeight$default3 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean pullToRefreshIsRefreshing3 = state.getPullToRefreshIsRefreshing();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -277368193, "CC(remember):FolderListingScreen.kt#9igjgp");
                i7 = i6 & 14;
                if (i7 == 4) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default3 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxHeight$default3, pullToRefreshIsRefreshing3, pullToRefreshStateRememberPullToRefreshState3, false, 0.0f, (Function0) objRememberedValue, 12, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default3);
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
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400057252, "C199@8901L195:FolderListingScreen.kt#9mvyw3");
                if (state.getItems().isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1400045318);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "186@8492L142");
                    boolean z10 = z2;
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(emptyScreenConfig, null, z10, composerStartRestartGroup, ((i6 >> 6) & 14) | ((i6 >> 9) & 896), 2);
                    composerStartRestartGroup.endReplaceGroup();
                    z4 = z10;
                    secondaryActionType4 = secondaryActionType3;
                } else {
                    boolean z11 = z2;
                    composerStartRestartGroup.startReplaceGroup(-1399872369);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "191@8664L217");
                    ItemsList(store, state, z11, secondaryActionType3, composerStartRestartGroup, (i6 & 126) | ((i6 >> 9) & 896) | (SecondaryActionType.$stable << 9) | (i6 & 7168), 0);
                    z4 = z11;
                    secondaryActionType4 = secondaryActionType3;
                    composerStartRestartGroup.endReplaceGroup();
                }
                i8 = i6;
                BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState3, state.getPullToRefreshIsRefreshing(), boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                error = state.getError();
                if (error == null) {
                    composerStartRestartGroup.startReplaceGroup(-7726028);
                    composerStartRestartGroup.endReplaceGroup();
                    function8 = function7;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-7726027);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9147L133");
                    function8 = function7;
                    ShowSnackbarEffect(store, error.intValue(), function8, composerStartRestartGroup, i7 | ((i8 >> 6) & 896), 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function8;
                secondaryActionType2 = secondaryActionType4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                function6 = function5;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$3(store, state, emptyScreenConfig, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function5 = function4;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        function5 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        z2 = false;
                    } else {
                        i6 = i3;
                    }
                } else {
                    if ((i2 & 8) != 0) {
                        none = SecondaryActionType.None.INSTANCE;
                        i3 &= -7169;
                    }
                    if (i10 != 0) {
                        function5 = null;
                    }
                    if (i4 != 0) {
                        i6 = i3;
                        z2 = false;
                    } else {
                        i6 = i3;
                    }
                }
                function7 = function5;
                secondaryActionType3 = none;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-299729656, i6, -1, "com.box.android.browse.compose.ItemsWithPullToRefresh (FolderListingScreen.kt:174)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState4 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierFillMaxHeight$default4 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean pullToRefreshIsRefreshing4 = state.getPullToRefreshIsRefreshing();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -277368193, "CC(remember):FolderListingScreen.kt#9igjgp");
                i7 = i6 & 14;
                if (i7 == 4) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default4 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxHeight$default4, pullToRefreshIsRefreshing4, pullToRefreshStateRememberPullToRefreshState4, false, 0.0f, (Function0) objRememberedValue, 12, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default4);
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
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400057252, "C199@8901L195:FolderListingScreen.kt#9mvyw3");
                if (state.getItems().isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1400045318);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "186@8492L142");
                    boolean z12 = z2;
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(emptyScreenConfig, null, z12, composerStartRestartGroup, ((i6 >> 6) & 14) | ((i6 >> 9) & 896), 2);
                    composerStartRestartGroup.endReplaceGroup();
                    z4 = z12;
                    secondaryActionType4 = secondaryActionType3;
                } else {
                    boolean z13 = z2;
                    composerStartRestartGroup.startReplaceGroup(-1399872369);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "191@8664L217");
                    ItemsList(store, state, z13, secondaryActionType3, composerStartRestartGroup, (i6 & 126) | ((i6 >> 9) & 896) | (SecondaryActionType.$stable << 9) | (i6 & 7168), 0);
                    z4 = z13;
                    secondaryActionType4 = secondaryActionType3;
                    composerStartRestartGroup.endReplaceGroup();
                }
                i8 = i6;
                BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState4, state.getPullToRefreshIsRefreshing(), boxScopeInstance4.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                error = state.getError();
                if (error == null) {
                    composerStartRestartGroup.startReplaceGroup(-7726028);
                    composerStartRestartGroup.endReplaceGroup();
                    function8 = function7;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-7726027);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9147L133");
                    function8 = function7;
                    ShowSnackbarEffect(store, error.intValue(), function8, composerStartRestartGroup, i7 | ((i8 >> 6) & 896), 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function8;
                secondaryActionType2 = secondaryActionType4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                secondaryActionType2 = none;
                function6 = function5;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$3(store, state, emptyScreenConfig, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 8) != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                    i3 &= -7169;
                }
                if (i10 != 0) {
                    function5 = null;
                }
                if (i4 != 0) {
                    i6 = i3;
                    z2 = false;
                } else {
                    i6 = i3;
                }
            } else {
                if ((i2 & 8) != 0) {
                    none = SecondaryActionType.None.INSTANCE;
                    i3 &= -7169;
                }
                if (i10 != 0) {
                    function5 = null;
                }
                if (i4 != 0) {
                    i6 = i3;
                    z2 = false;
                } else {
                    i6 = i3;
                }
            }
            function7 = function5;
            secondaryActionType3 = none;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-299729656, i6, -1, "com.box.android.browse.compose.ItemsWithPullToRefresh (FolderListingScreen.kt:174)");
            }
            PullToRefreshState pullToRefreshStateRememberPullToRefreshState5 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            Modifier modifierFillMaxHeight$default5 = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean pullToRefreshIsRefreshing5 = state.getPullToRefreshIsRefreshing();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -277368193, "CC(remember):FolderListingScreen.kt#9igjgp");
            i7 = i6 & 14;
            if (i7 == 4) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM5119pullToRefreshZ4HSEVQ$default5 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(modifierFillMaxHeight$default5, pullToRefreshIsRefreshing5, pullToRefreshStateRememberPullToRefreshState5, false, 0.0f, (Function0) objRememberedValue, 12, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default5);
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
            Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1400057252, "C199@8901L195:FolderListingScreen.kt#9mvyw3");
            if (state.getItems().isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1400045318);
                ComposerKt.sourceInformation(composerStartRestartGroup, "186@8492L142");
                boolean z14 = z2;
                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(emptyScreenConfig, null, z14, composerStartRestartGroup, ((i6 >> 6) & 14) | ((i6 >> 9) & 896), 2);
                composerStartRestartGroup.endReplaceGroup();
                z4 = z14;
                secondaryActionType4 = secondaryActionType3;
            } else {
                boolean z15 = z2;
                composerStartRestartGroup.startReplaceGroup(-1399872369);
                ComposerKt.sourceInformation(composerStartRestartGroup, "191@8664L217");
                ItemsList(store, state, z15, secondaryActionType3, composerStartRestartGroup, (i6 & 126) | ((i6 >> 9) & 896) | (SecondaryActionType.$stable << 9) | (i6 & 7168), 0);
                z4 = z15;
                secondaryActionType4 = secondaryActionType3;
                composerStartRestartGroup.endReplaceGroup();
            }
            i8 = i6;
            BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState5, state.getPullToRefreshIsRefreshing(), boxScopeInstance5.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            error = state.getError();
            if (error == null) {
                composerStartRestartGroup.startReplaceGroup(-7726028);
                composerStartRestartGroup.endReplaceGroup();
                function8 = function7;
            } else {
                composerStartRestartGroup.startReplaceGroup(-7726027);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*207@9147L133");
                function8 = function7;
                ShowSnackbarEffect(store, error.intValue(), function8, composerStartRestartGroup, i7 | ((i8 >> 6) & 896), 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function8;
            secondaryActionType2 = secondaryActionType4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            secondaryActionType2 = none;
            function6 = function5;
            z4 = z2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.ItemsWithPullToRefresh$lambda$3(store, state, emptyScreenConfig, secondaryActionType2, function6, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsWithPullToRefresh$lambda$0$0(Store store) {
        store.send(ItemsListReducer.Action.PulledToRefresh.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:0x008a  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:60:0x0101  */
    /* JADX WARN: Code duplicated, block: B:62:0x0126  */
    /* JADX WARN: Code duplicated, block: B:63:0x0129  */
    /* JADX WARN: Code duplicated, block: B:65:0x012c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0136  */
    /* JADX WARN: Code duplicated, block: B:69:0x014d  */
    /* JADX WARN: Code duplicated, block: B:70:0x014f  */
    /* JADX WARN: Code duplicated, block: B:75:0x015e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0174  */
    /* JADX WARN: Code duplicated, block: B:80:0x0199  */
    /* JADX WARN: Code duplicated, block: B:81:0x019c  */
    /* JADX WARN: Code duplicated, block: B:83:0x019f  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:93:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:97:0x01de  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e2  */
    private static final void ShowSnackbarEffect(Store<ItemsListReducer.State, ItemsListReducer.Action> store, final int i, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, Composer composer, final int i2, final int i3) {
        int i4;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function5;
        boolean z;
        final Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        KeyEventDispatcher.Component componentRequireActivity;
        IBoxFragmentActivity iBoxFragmentActivity;
        boolean z2;
        FolderListingScreenKt$ShowSnackbarEffect$3$1 folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue;
        KeyEventDispatcher.Component componentRequireActivity2;
        IBoxFragmentActivity iBoxFragmentActivity2;
        boolean z3;
        Object objRememberedValue;
        boolean z4;
        String strStringResource;
        String strStringResource2;
        boolean zChanged;
        FolderListingScreenKt$ShowSnackbarEffect$1$1 folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue;
        final Store<ItemsListReducer.State, ItemsListReducer.Action> store2 = store;
        Composer composerStartRestartGroup = composer.startRestartGroup(316890437);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShowSnackbarEffect)N(store,errorRes,onShowSnackbar):FolderListingScreen.kt#9mvyw3");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(store2) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        int i5 = i3 & 4;
        if (i5 == 0) {
            if ((i2 & 384) == 0) {
                function5 = function4;
                i4 |= composerStartRestartGroup.changedInstance(function5) ? 256 : 128;
            }
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    function5 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(316890437, i4, -1, "com.box.android.browse.compose.ShowSnackbarEffect (FolderListingScreen.kt:220)");
                }
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceGroup(145193939);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@9699L24,224@9761L51,225@9842L489,225@9821L510");
                    if (i == R.string.boxsdk_error_network_connection) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i4 >> 3) & 14);
                    strStringResource2 = StringResources_androidKt.stringResource(R.string.box_browsesdk_tap_to_retry, composerStartRestartGroup, 0);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410950546, "CC(remember):FolderListingScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(z4) | composerStartRestartGroup.changedInstance(function5) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(strStringResource2) | ((i4 & 14) == 4);
                    folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function7 = function5;
                        FolderListingScreenKt$ShowSnackbarEffect$1$1 folderListingScreenKt$ShowSnackbarEffect$1$1 = new FolderListingScreenKt$ShowSnackbarEffect$1$1(z4, function7, strStringResource, strStringResource2, store, null);
                        store2 = store;
                        function5 = function7;
                        folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue = folderListingScreenKt$ShowSnackbarEffect$1$1;
                        composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue);
                    } else {
                        store2 = store;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(145942403);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "252@11091L72,252@11070L93");
                    if (i == R.string.boxsdk_error_network_connection) {
                        composerStartRestartGroup.startReplaceGroup(146073192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "238@10439L7");
                        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContext);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        componentRequireActivity2 = ContextExtensionsKt.requireActivity((Context) objConsume);
                        if (componentRequireActivity2 instanceof IBoxFragmentActivity) {
                            iBoxFragmentActivity2 = (IBoxFragmentActivity) componentRequireActivity2;
                        } else {
                            iBoxFragmentActivity2 = null;
                        }
                        if (iBoxFragmentActivity2 == null) {
                            composerStartRestartGroup.startReplaceGroup(146073191);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-410929958);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "241@10643L57");
                            int i6 = R.string.box_browsesdk_tap_to_retry;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410925346, "CC(remember):FolderListingScreen.kt#9igjgp");
                            if ((i4 & 14) == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new View.OnClickListener() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda5
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        FolderListingScreenKt.ShowSnackbarEffect$lambda$1$0(store2, view);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            iBoxFragmentActivity2.displaySnackbar(i, i6, (View.OnClickListener) objRememberedValue, -2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(146441348);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "245@10813L7");
                        ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        componentRequireActivity = ContextExtensionsKt.requireActivity((Context) objConsume2);
                        if (componentRequireActivity instanceof IBoxFragmentActivity) {
                            iBoxFragmentActivity = (IBoxFragmentActivity) componentRequireActivity;
                        } else {
                            iBoxFragmentActivity = null;
                        }
                        if (iBoxFragmentActivity != null) {
                            iBoxFragmentActivity.displaySnackbar(i, 0, (View.OnClickListener) null, 4000);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410910995, "CC(remember):FolderListingScreen.kt#9igjgp");
                    z2 = (i4 & 14) == 4;
                    folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue = new FolderListingScreenKt$ShowSnackbarEffect$3$1(store2, null);
                        composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function6 = function5;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.ShowSnackbarEffect$lambda$3(store2, i, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        function5 = function4;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                function5 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316890437, i4, -1, "com.box.android.browse.compose.ShowSnackbarEffect (FolderListingScreen.kt:220)");
            }
            if (function5 != null) {
                composerStartRestartGroup.startReplaceGroup(145193939);
                ComposerKt.sourceInformation(composerStartRestartGroup, "223@9699L24,224@9761L51,225@9842L489,225@9821L510");
                if (i == R.string.boxsdk_error_network_connection) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i4 >> 3) & 14);
                strStringResource2 = StringResources_androidKt.stringResource(R.string.box_browsesdk_tap_to_retry, composerStartRestartGroup, 0);
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410950546, "CC(remember):FolderListingScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(z4) | composerStartRestartGroup.changedInstance(function5) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(strStringResource2) | ((i4 & 14) == 4);
                folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function8 = function5;
                    FolderListingScreenKt$ShowSnackbarEffect$1$1 folderListingScreenKt$ShowSnackbarEffect$1$2 = new FolderListingScreenKt$ShowSnackbarEffect$1$1(z4, function8, strStringResource, strStringResource2, store, null);
                    store2 = store;
                    function5 = function8;
                    folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue = folderListingScreenKt$ShowSnackbarEffect$1$2;
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue);
                } else {
                    Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function9 = function5;
                    FolderListingScreenKt$ShowSnackbarEffect$1$1 folderListingScreenKt$ShowSnackbarEffect$1$3 = new FolderListingScreenKt$ShowSnackbarEffect$1$1(z4, function9, strStringResource, strStringResource2, store, null);
                    store2 = store;
                    function5 = function9;
                    folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue = folderListingScreenKt$ShowSnackbarEffect$1$3;
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$ShowSnackbarEffect$1$1RememberedValue, composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(145942403);
                ComposerKt.sourceInformation(composerStartRestartGroup, "252@11091L72,252@11070L93");
                if (i == R.string.boxsdk_error_network_connection) {
                    composerStartRestartGroup.startReplaceGroup(146073192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "238@10439L7");
                    ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContext3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    componentRequireActivity2 = ContextExtensionsKt.requireActivity((Context) objConsume3);
                    if (componentRequireActivity2 instanceof IBoxFragmentActivity) {
                        iBoxFragmentActivity2 = (IBoxFragmentActivity) componentRequireActivity2;
                    } else {
                        iBoxFragmentActivity2 = null;
                    }
                    if (iBoxFragmentActivity2 == null) {
                        composerStartRestartGroup.startReplaceGroup(146073191);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-410929958);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "241@10643L57");
                        int i7 = R.string.box_browsesdk_tap_to_retry;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410925346, "CC(remember):FolderListingScreen.kt#9igjgp");
                        if ((i4 & 14) == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue = new View.OnClickListener() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda5
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    FolderListingScreenKt.ShowSnackbarEffect$lambda$1$0(store2, view);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new View.OnClickListener() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda5
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    FolderListingScreenKt.ShowSnackbarEffect$lambda$1$0(store2, view);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        iBoxFragmentActivity2.displaySnackbar(i, i7, (View.OnClickListener) objRememberedValue, -2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(146441348);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "245@10813L7");
                    ProvidableCompositionLocal<Context> localContext4 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localContext4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    componentRequireActivity = ContextExtensionsKt.requireActivity((Context) objConsume4);
                    if (componentRequireActivity instanceof IBoxFragmentActivity) {
                        iBoxFragmentActivity = (IBoxFragmentActivity) componentRequireActivity;
                    } else {
                        iBoxFragmentActivity = null;
                    }
                    if (iBoxFragmentActivity != null) {
                        iBoxFragmentActivity.displaySnackbar(i, 0, (View.OnClickListener) null, 4000);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -410910995, "CC(remember):FolderListingScreen.kt#9igjgp");
                if ((i4 & 14) == 4) {
                }
                folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue = new FolderListingScreenKt$ShowSnackbarEffect$3$1(store2, null);
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue);
                } else {
                    folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue = new FolderListingScreenKt$ShowSnackbarEffect$3$1(store2, null);
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$ShowSnackbarEffect$3$1RememberedValue, composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        function6 = function5;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.ShowSnackbarEffect$lambda$3(store2, i, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShowSnackbarEffect$lambda$1$0(Store store, View view) {
        store.send(ItemsListReducer.Action.RefreshFromRemote.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006f  */
    public static final void ItemsList(final Store<ItemsListReducer.State, ItemsListReducer.Action> store, final ItemsListReducer.State state, final boolean z, SecondaryActionType secondaryActionType, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final SecondaryActionType secondaryActionType2;
        long jM11499getAppBackgroundAlt0d7_KjU;
        final LazyListState lazyListState;
        int i4;
        SecondaryActionType.None none = secondaryActionType;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(266693689);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemsList)N(store,state,isRedesignedVersion,defaultSecondaryActionType)265@11443L23,279@11923L3470,266@11471L3922:FolderListingScreen.kt#9mvyw3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i4 = 1024;
            } else {
                if ((i & 4096) == 0 ? composerStartRestartGroup.changed(none) : composerStartRestartGroup.changedInstance(none)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
            }
            i3 |= i4;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
            } else if ((i2 & 8) != 0) {
                none = SecondaryActionType.None.INSTANCE;
                i3 &= -7169;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(266693689, i3, -1, "com.box.android.browse.compose.ItemsList (FolderListingScreen.kt:264)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-617390812);
                ComposerKt.sourceInformation(composerStartRestartGroup, "271@11635L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-617316319);
                ComposerKt.sourceInformation(composerStartRestartGroup, "273@11710L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxSize$default, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null), "Items");
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1405375545, "CC(remember):FolderListingScreen.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 14) == 4) | composerStartRestartGroup.changedInstance(state) | ((i3 & 896) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changedInstance(none)) || (i3 & 3072) == 2048) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                lazyListState = lazyListStateRememberLazyListState;
                secondaryActionType2 = none;
                Function1 function1 = new Function1() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderListingScreenKt.ItemsList$lambda$0$0(state, store, z, secondaryActionType2, lazyListState, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue = function1;
            } else {
                lazyListState = lazyListStateRememberLazyListState;
                secondaryActionType2 = none;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierTestTag, lazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            secondaryActionType2 = none;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.ItemsList$lambda$1(store, state, z, secondaryActionType2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsList$lambda$0$0(final ItemsListReducer.State state, final Store store, final boolean z, final SecondaryActionType secondaryActionType, final LazyListState lazyListState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final BoxFeatureBanner featureBanner = state.getFeatureBanner();
        if (featureBanner != null) {
            LazyListScope.item$default(LazyColumn, "FeatureBanner", null, ComposableLambdaKt.composableLambdaInstance(1248654697, true, new Function3() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FolderListingScreenKt.ItemsList$lambda$0$0$0(state, featureBanner, store, z, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
        LazyListScope.item$default(LazyColumn, "ConfigBar", null, ComposableLambdaKt.composableLambdaInstance(-1994963058, true, new Function3() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FolderListingScreenKt.ItemsList$lambda$0$0$1(state, store, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        final IdentifiedList<ItemId.Remote, ItemReducer.State> items = state.getItems();
        LazyColumn.items(items.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.browse.compose.FolderListingScreenKt$ItemsList$lambda$0$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                items.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.browse.compose.FolderListingScreenKt$ItemsList$lambda$0$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:48:0x018b  */
            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                boolean z2;
                ComposerKt.sourceInformation(composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
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
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                ItemReducer.State state2 = (ItemReducer.State) items.get(i);
                composer.startReplaceGroup(-1316285553);
                ComposerKt.sourceInformation(composer, "CN(index,item)*333@14109L1123:FolderListingScreen.kt#9mvyw3");
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
                ComposerKt.sourceInformationMarkerStart(composer, 710810755, "C334@14173L529,344@14833L385:FolderListingScreen.kt#9mvyw3");
                FolderListingScreenKt.BrowseItem(store, state2, state.isSelecting() ? SecondaryActionType.Checkbox.INSTANCE : secondaryActionType, state.isItemSelected(state2.getId()), (state2.getThumbnailState().isThumbnailFetchAttempted() || lazyListState.isScrollInProgress()) ? false : true, z, state2.isEnabled(), composer, SecondaryActionType.$stable << 6, 0);
                boolean zAreEqual = Intrinsics.areEqual(state2.getId(), ((ItemReducer.State) CollectionsKt.last((List) state.getItems())).getId());
                boolean zIsItemSelected = state.isItemSelected(state2.getId());
                if (i != state.getItems().size() - 1) {
                    ItemsListReducer.State state3 = state;
                    if (state3.isItemSelected(((ItemReducer.State) state3.getItems().get(i + 1)).getId())) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                BoxSelectionAwareDividerKt.m11727BoxSelectionAwareDividerjt2gSs(zAreEqual, zIsItemSelected, z2, Dp.m9687constructorimpl(z ? 66 : 60), composer, 0, 0);
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
        if (Intrinsics.areEqual(state.getItemLoadingState(), ItemsListReducer.LoadingState.PartiallyLoaded.INSTANCE)) {
            LazyListScope.item$default(LazyColumn, "LoadMore", null, ComposableSingletons$FolderListingScreenKt.INSTANCE.getLambda$1444657248$browse_generalProdRelease(), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsList$lambda$0$0$0(ItemsListReducer.State state, final BoxFeatureBanner boxFeatureBanner, final Store store, boolean z, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C287@12295L68,286@12193L70,283@12048L396:FolderListingScreen.kt#9mvyw3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1248654697, i, -1, "com.box.android.browse.compose.ItemsList.<anonymous>.<anonymous>.<anonymous> (FolderListingScreen.kt:283)");
            }
            boolean displayFeatureBanner = state.getDisplayFeatureBanner();
            ComposerKt.sourceInformationMarkerStart(composer, 1661296781, "CC(remember):FolderListingScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store) | composer.changed(boxFeatureBanner == null ? -1 : boxFeatureBanner.ordinal());
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.ItemsList$lambda$0$0$0$0$0(store, boxFeatureBanner);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1661293519, "CC(remember):FolderListingScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(boxFeatureBanner != null ? boxFeatureBanner.ordinal() : -1) | composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.ItemsList$lambda$0$0$0$1$0(store, boxFeatureBanner);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FeatureBanner(displayFeatureBanner, boxFeatureBanner, function0, (Function0) objRememberedValue2, z, composer, 0);
            if (state.getDisplayFeatureBanner()) {
                composer.startReplaceGroup(-39204785);
                ComposerKt.sourceInformation(composer, "291@12536L205,291@12515L226");
                ComposerKt.sourceInformationMarkerStart(composer, 1661304630, "CC(remember):FolderListingScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(store);
                FolderListingScreenKt$ItemsList$1$1$1$3$1 folderListingScreenKt$ItemsList$1$1$1$3$1RememberedValue = composer.rememberedValue();
                if (zChanged3 || folderListingScreenKt$ItemsList$1$1$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$ItemsList$1$1$1$3$1RememberedValue = new FolderListingScreenKt$ItemsList$1$1$1$3$1(store, null);
                    composer.updateRememberedValue(folderListingScreenKt$ItemsList$1$1$1$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$ItemsList$1$1$1$3$1RememberedValue, composer, 6);
            } else {
                composer.startReplaceGroup(-51607079);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsList$lambda$0$0$0$1$0(Store store, BoxFeatureBanner boxFeatureBanner) {
        store.send(new ItemsListReducer.Action.FeatureBannerDismissed(boxFeatureBanner));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsList$lambda$0$0$0$0$0(Store store, BoxFeatureBanner boxFeatureBanner) {
        store.send(new ItemsListReducer.Action.FeatureBannerClicked(boxFeatureBanner));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsList$lambda$0$0$1(ItemsListReducer.State state, Store store, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C:FolderListingScreen.kt#9mvyw3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994963058, i, -1, "com.box.android.browse.compose.ItemsList.<anonymous>.<anonymous>.<anonymous> (FolderListingScreen.kt:300)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(56)), 0.0f, 1, null);
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.getFilesConfigState().getConfigBarMode().ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(1813212680);
                ComposerKt.sourceInformation(composer, "309@13264L36,305@13056L292");
                FolderListingScreenKt$ItemsList$1$1$2$1 folderListingScreenKt$ItemsList$1$1$2$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.compose.FolderListingScreenKt$ItemsList$1$1$2$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemsListReducer.State) obj).getFilesConfigState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1604070190, "CC(remember):FolderListingScreen.kt#9igjgp");
                FolderListingScreenKt$ItemsList$1$1$2$2$1 folderListingScreenKt$ItemsList$1$1$2$2$1RememberedValue = composer.rememberedValue();
                if (folderListingScreenKt$ItemsList$1$1$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$ItemsList$1$1$2$2$1RememberedValue = FolderListingScreenKt$ItemsList$1$1$2$2$1.INSTANCE;
                    composer.updateRememberedValue(folderListingScreenKt$ItemsList$1$1$2$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FilesListingConfigBarKt.SortFilesConfigBar(modifierFillMaxWidth$default, store.scope(folderListingScreenKt$ItemsList$1$1$2$1, (Function1) ((KFunction) folderListingScreenKt$ItemsList$1$1$2$2$1RememberedValue)), composer, 6);
                composer.endReplaceGroup();
            } else if (i2 == 2) {
                composer.startReplaceGroup(1813608953);
                ComposerKt.sourceInformation(composer, "319@13647L36,315@13456L275");
                FolderListingScreenKt$ItemsList$1$1$2$3 folderListingScreenKt$ItemsList$1$1$2$3 = new PropertyReference1Impl() { // from class: com.box.android.browse.compose.FolderListingScreenKt$ItemsList$1$1$2$3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemsListReducer.State) obj).getFilesConfigState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1604057934, "CC(remember):FolderListingScreen.kt#9igjgp");
                FolderListingScreenKt$ItemsList$1$1$2$4$1 folderListingScreenKt$ItemsList$1$1$2$4$1RememberedValue = composer.rememberedValue();
                if (folderListingScreenKt$ItemsList$1$1$2$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$ItemsList$1$1$2$4$1RememberedValue = FolderListingScreenKt$ItemsList$1$1$2$4$1.INSTANCE;
                    composer.updateRememberedValue(folderListingScreenKt$ItemsList$1$1$2$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FilesListingConfigBarKt.FilterFilesConfigBar(modifierFillMaxWidth$default, store.scope(folderListingScreenKt$ItemsList$1$1$2$3, (Function1) ((KFunction) folderListingScreenKt$ItemsList$1$1$2$4$1RememberedValue)), composer, 6);
                composer.endReplaceGroup();
            } else {
                if (i2 != 3) {
                    composer.startReplaceGroup(-1604080148);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(1813978783);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FeatureBanner(final boolean z, final BoxFeatureBanner banner, final Function0<Unit> onClick, final Function0<Unit> onDismiss, final boolean z2, Composer composer, final int i) {
        boolean z3;
        int i2;
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(2121685146);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeatureBanner)N(visibility,banner,onClick,onDismiss,isRedesignedVersion)366@15656L3419,366@15576L3499:FolderListingScreen.kt#9mvyw3");
        if ((i & 6) == 0) {
            z3 = z;
            i2 = (composerStartRestartGroup.changed(z3) ? 4 : 2) | i;
        } else {
            z3 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(banner.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2121685146, i2, -1, "com.box.android.browse.compose.FeatureBanner (FolderListingScreen.kt:365)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z3, (Modifier) null, (EnterTransition) null, EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-528931134, true, new Function3() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FolderListingScreenKt.FeatureBanner$lambda$0(z2, banner, onClick, onDismiss, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 199680, 22);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.FeatureBanner$lambda$1(z, banner, onClick, onDismiss, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureBanner$lambda$0$0(boolean z, final BoxFeatureBanner boxFeatureBanner, final Function0 function0, Function0 function1, ColumnScope Card, Composer composer, int i) {
        Modifier modifierM1218padding3ABfNKs;
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C393@16631L2428:FolderListingScreen.kt#9mvyw3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2005792912, i, -1, "com.box.android.browse.compose.FeatureBanner.<anonymous>.<anonymous> (FolderListingScreen.kt:393)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            if (z) {
                float f = 16;
                modifierM1218padding3ABfNKs = PaddingKt.m1221paddingqDBjuR0(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(4), Dp.m9687constructorimpl(f));
            } else {
                modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16));
            }
            Modifier modifierThen = companion.then(modifierM1218padding3ABfNKs);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierThen);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 932650493, "C404@17072L39,405@17173L6,403@17035L228,408@17307L11,413@17508L32,414@17571L349,409@17335L603:FolderListingScreen.kt#9mvyw3");
            ImageKt.Image(PainterResources_androidKt.painterResource(boxFeatureBanner.getImageResourceId(), composer, 0), (String) null, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0, 2, null), composer, Painter.$stable | 48, 60);
            final boolean zIsDarkTheme = BoxTheme.INSTANCE.isDarkTheme(composer, BoxTheme.$stable);
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m9687constructorimpl(16), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1771016660, "CC(remember):FolderListingScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderListingScreenKt.FeatureBanner$lambda$0$0$0$0$0((Context) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function2 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1771014327, "CC(remember):FolderListingScreen.kt#9igjgp");
            boolean zChanged = composer.changed(zIsDarkTheme) | composer.changed(boxFeatureBanner.ordinal()) | composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FolderListingScreenKt.FeatureBanner$lambda$0$0$0$1$0(zIsDarkTheme, boxFeatureBanner, function0, (TextView) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidView_androidKt.AndroidView(function2, modifierM1220paddingVpY3zN4$default, (Function1) objRememberedValue2, composer, 6, 0);
            if (z) {
                composer.startReplaceGroup(933564992);
                ComposerKt.sourceInformation(composer, "423@18043L41,430@18471L6,422@18002L566");
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_close_24dp, composer, 0), (String) null, TestTagKt.testTag(PaddingKt.m1218padding3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), false, null, null, null, function1, 15, null)), Dp.m9687constructorimpl(4)), "Feature banner dismiss"), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0, 2, null), composer, Painter.$stable | 48, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(934167353);
                ComposerKt.sourceInformation(composer, "435@18655L41,439@18930L6,434@18614L413");
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_close_24dp, composer, 0), (String) null, TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(Modifier.INSTANCE, false, null, null, null, function1, 15, null), "Feature banner dismiss"), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0, 2, null), composer, Painter.$stable | 48, 56);
                composer.endReplaceGroup();
            }
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
    public static final TextView FeatureBanner$lambda$0$0$0$0$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MAMTextView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureBanner$lambda$0$0$0$1$0(boolean z, BoxFeatureBanner boxFeatureBanner, final Function0 function0, TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setTextAppearance(R.style.TextAppearance_Box_Normal_12sp_Content);
        boxFeatureBanner.fillText(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                function0.invoke();
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:113:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:114:0x01de  */
    /* JADX WARN: Code duplicated, block: B:119:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:122:0x0208  */
    /* JADX WARN: Code duplicated, block: B:123:0x020a  */
    /* JADX WARN: Code duplicated, block: B:128:0x021f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0235  */
    /* JADX WARN: Code duplicated, block: B:132:0x0238  */
    /* JADX WARN: Code duplicated, block: B:137:0x024e  */
    /* JADX WARN: Code duplicated, block: B:140:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:142:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:145:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00be  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x010e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0121  */
    /* JADX WARN: Code duplicated, block: B:87:0x0138  */
    /* JADX WARN: Code duplicated, block: B:88:0x013a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0151  */
    /* JADX WARN: Code duplicated, block: B:96:0x019d  */
    /* JADX WARN: Code duplicated, block: B:97:0x019f  */
    public static final void BrowseItem(final Store<ItemsListReducer.State, ItemsListReducer.Action> store, final ItemReducer.State state, final SecondaryActionType secondaryActionType, final boolean z, final boolean z2, final boolean z3, boolean z4, Composer composer, final int i, final int i2) {
        int i3;
        boolean z5;
        boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        int i4;
        boolean z9;
        boolean zChangedInstance;
        FolderListingScreenKt$BrowseItem$2$1 folderListingScreenKt$BrowseItem$2$1RememberedValue;
        boolean z10;
        boolean zChangedInstance2;
        Object objRememberedValue;
        boolean z11;
        boolean z12;
        boolean zChangedInstance3;
        Object objRememberedValue2;
        boolean z13;
        boolean zChangedInstance4;
        Object objRememberedValue3;
        boolean z14;
        boolean zChangedInstance5;
        Object objRememberedValue4;
        boolean z15;
        boolean zChangedInstance6;
        FolderListingScreenKt$BrowseItem$1$1 folderListingScreenKt$BrowseItem$1$1RememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(secondaryActionType, "secondaryActionType");
        Composer composerStartRestartGroup = composer.startRestartGroup(1526824);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BrowseItem)N(store,state,secondaryActionType,isSelected,fetchThumbnail,isRedesignedVersion,isCheckboxEnabled)470@19761L180,470@19736L205,494@20610L154,504@20989L526,499@20792L158,515@21545L160,524@21962L2856,479@19947L4877:FolderListingScreen.kt#9mvyw3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(secondaryActionType) : composerStartRestartGroup.changedInstance(secondaryActionType) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        int i5 = i2 & 64;
        if (i5 == 0) {
            if ((1572864 & i) == 0) {
                z5 = z4;
                i3 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
            }
            if ((599187 & i3) != 599186) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z7 = z5;
            } else {
                if (i5 != 0) {
                    z8 = true;
                } else {
                    z8 = z5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1526824, i3, -1, "com.box.android.browse.compose.BrowseItem (FolderListingScreen.kt:457)");
                }
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-1777965734);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1758666467);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "460@19476L248,460@19455L269");
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467290432, "CC(remember):FolderListingScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    zChangedInstance6 = z15 | composerStartRestartGroup.changedInstance(state);
                    folderListingScreenKt$BrowseItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance6 || folderListingScreenKt$BrowseItem$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        folderListingScreenKt$BrowseItem$1$1RememberedValue = new FolderListingScreenKt$BrowseItem$1$1(store, state, null);
                        composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$BrowseItem$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$BrowseItem$1$1RememberedValue, composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                ItemId.Remote id = state.getId();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467299484, "CC(remember):FolderListingScreen.kt#9igjgp");
                i4 = i3 & 14;
                if (i4 == 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChangedInstance = z9 | composerStartRestartGroup.changedInstance(state);
                folderListingScreenKt$BrowseItem$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || folderListingScreenKt$BrowseItem$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    folderListingScreenKt$BrowseItem$2$1RememberedValue = new FolderListingScreenKt$BrowseItem$2$1(store, state, null);
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$BrowseItem$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(id, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$BrowseItem$2$1RememberedValue, composerStartRestartGroup, 0);
                ListItemInfo listItemInfo = new ListItemInfo(state.getName(), state.getItemThumbnail(), state.getFormattedDescription(), TestTagUtilsKt.toItemTestTag(state.getId()), OfflineManagerExtensionsKt.toOfflineBadgeType(state.getOfflineState()), state.isInCollections(), state.getCommentsCount(), state.getHasSharedLink());
                boolean zIsEnabled = state.isEnabled();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467326626, "CC(remember):FolderListingScreen.kt#9igjgp");
                if (i4 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zChangedInstance2 = z10 | composerStartRestartGroup.changedInstance(state);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.BrowseItem$lambda$2$0(store, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467339126, "CC(remember):FolderListingScreen.kt#9igjgp");
                if ((i3 & 896) != 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(secondaryActionType))) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i4 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                zChangedInstance3 = z11 | z12 | composerStartRestartGroup.changedInstance(state);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.BrowseItem$lambda$3$0(secondaryActionType, store, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467332454, "CC(remember):FolderListingScreen.kt#9igjgp");
                if (i4 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                zChangedInstance4 = z13 | composerStartRestartGroup.changedInstance(state);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.BrowseItem$lambda$4$0(store, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function2 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467356552, "CC(remember):FolderListingScreen.kt#9igjgp");
                if (i4 == 4) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                zChangedInstance5 = z14 | composerStartRestartGroup.changedInstance(state);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FolderListingScreenKt.BrowseItem$lambda$5$0(store, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i6 = i3;
                BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, zIsEnabled, z, z8, new ClickActionsConfig(function0, function1, function2, (Function0) objRememberedValue4), secondaryActionType, 0, z3, ComposableLambdaKt.rememberComposableLambda(-757272550, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.BrowseItem$lambda$6(state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 3) & 896) | 100663296 | ((i6 >> 9) & 7168) | (SecondaryActionType.$stable << 15) | (458752 & (i6 << 9)) | ((i6 << 6) & 29360128), 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FolderListingScreenKt.BrowseItem$lambda$7(store, state, secondaryActionType, z, z2, z3, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z5 = z4;
        if ((599187 & i3) != 599186) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z7 = z5;
        } else {
            if (i5 != 0) {
                z8 = true;
            } else {
                z8 = z5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1526824, i3, -1, "com.box.android.browse.compose.BrowseItem (FolderListingScreen.kt:457)");
            }
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-1777965734);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1758666467);
                ComposerKt.sourceInformation(composerStartRestartGroup, "460@19476L248,460@19455L269");
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467290432, "CC(remember):FolderListingScreen.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                zChangedInstance6 = z15 | composerStartRestartGroup.changedInstance(state);
                folderListingScreenKt$BrowseItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance6) {
                    folderListingScreenKt$BrowseItem$1$1RememberedValue = new FolderListingScreenKt$BrowseItem$1$1(store, state, null);
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$BrowseItem$1$1RememberedValue);
                } else {
                    folderListingScreenKt$BrowseItem$1$1RememberedValue = new FolderListingScreenKt$BrowseItem$1$1(store, state, null);
                    composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$BrowseItem$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$BrowseItem$1$1RememberedValue, composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            ItemId.Remote id2 = state.getId();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467299484, "CC(remember):FolderListingScreen.kt#9igjgp");
            i4 = i3 & 14;
            if (i4 == 4) {
                z9 = true;
            } else {
                z9 = false;
            }
            zChangedInstance = z9 | composerStartRestartGroup.changedInstance(state);
            folderListingScreenKt$BrowseItem$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                folderListingScreenKt$BrowseItem$2$1RememberedValue = new FolderListingScreenKt$BrowseItem$2$1(store, state, null);
                composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$BrowseItem$2$1RememberedValue);
            } else {
                folderListingScreenKt$BrowseItem$2$1RememberedValue = new FolderListingScreenKt$BrowseItem$2$1(store, state, null);
                composerStartRestartGroup.updateRememberedValue(folderListingScreenKt$BrowseItem$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(id2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) folderListingScreenKt$BrowseItem$2$1RememberedValue, composerStartRestartGroup, 0);
            ListItemInfo listItemInfo2 = new ListItemInfo(state.getName(), state.getItemThumbnail(), state.getFormattedDescription(), TestTagUtilsKt.toItemTestTag(state.getId()), OfflineManagerExtensionsKt.toOfflineBadgeType(state.getOfflineState()), state.isInCollections(), state.getCommentsCount(), state.getHasSharedLink());
            boolean zIsEnabled2 = state.isEnabled();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467326626, "CC(remember):FolderListingScreen.kt#9igjgp");
            if (i4 == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            zChangedInstance2 = z10 | composerStartRestartGroup.changedInstance(state);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$2$0(store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$2$0(store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function3 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467339126, "CC(remember):FolderListingScreen.kt#9igjgp");
            if ((i3 & 896) != 256) {
                z11 = true;
            } else {
                z11 = true;
            }
            if (i4 == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            zChangedInstance3 = z11 | z12 | composerStartRestartGroup.changedInstance(state);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance3) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$3$0(secondaryActionType, store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$3$0(secondaryActionType, store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function4 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467332454, "CC(remember):FolderListingScreen.kt#9igjgp");
            if (i4 == 4) {
                z13 = true;
            } else {
                z13 = false;
            }
            zChangedInstance4 = z13 | composerStartRestartGroup.changedInstance(state);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance4) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$4$0(store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$4$0(store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function5 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1467356552, "CC(remember):FolderListingScreen.kt#9igjgp");
            if (i4 == 4) {
                z14 = true;
            } else {
                z14 = false;
            }
            zChangedInstance5 = z14 | composerStartRestartGroup.changedInstance(state);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance5) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$5$0(store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FolderListingScreenKt.BrowseItem$lambda$5$0(store, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i7 = i3;
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo2, zIsEnabled2, z, z8, new ClickActionsConfig(function3, function4, function5, (Function0) objRememberedValue4), secondaryActionType, 0, z3, ComposableLambdaKt.rememberComposableLambda(-757272550, true, new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.BrowseItem$lambda$6(state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i7 >> 3) & 896) | 100663296 | ((i7 >> 9) & 7168) | (SecondaryActionType.$stable << 15) | (458752 & (i7 << 9)) | ((i7 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.BrowseItem$lambda$7(store, state, secondaryActionType, z, z2, z3, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$2$0(Store store, ItemReducer.State state) {
        store.send(new ItemsListReducer.Action.ItemAction(state.getId(), ItemReducer.Action.Clicked.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$4$0(Store store, ItemReducer.State state) {
        store.send(new ItemsListReducer.Action.ItemAction(state.getId(), ItemReducer.Action.LongClicked.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$3$0(SecondaryActionType secondaryActionType, Store store, ItemReducer.State state) {
        ItemReducer.Action.MenuClicked menuClicked;
        if (Intrinsics.areEqual(secondaryActionType, SecondaryActionType.Checkbox.INSTANCE)) {
            menuClicked = ItemReducer.Action.CheckboxClicked.INSTANCE;
        } else if (Intrinsics.areEqual(secondaryActionType, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
            menuClicked = ItemReducer.Action.MenuClicked.INSTANCE;
        } else {
            if (!Intrinsics.areEqual(secondaryActionType, SecondaryActionType.None.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            menuClicked = null;
        }
        if (menuClicked != null) {
            store.send(new ItemsListReducer.Action.ItemAction(state.getId(), menuClicked));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$5$0(Store store, ItemReducer.State state) {
        store.send(new ItemsListReducer.Action.ItemAction(state.getId(), ItemReducer.Action.UpdateClicked.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$6(ItemReducer.State state, Composer composer, int i) {
        String str;
        String str2;
        int i2;
        String str3;
        int i3;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C525@21976L2832:FolderListingScreen.kt#9mvyw3");
        if (!composer2.shouldExecute((i & 3) != 2, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-757272550, i, -1, "com.box.android.browse.compose.BrowseItem.<anonymous> (FolderListingScreen.kt:525)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "BadgesContainer");
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierTestTag);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -529411353, "C:FolderListingScreen.kt#9mvyw3");
            if (state.isInCollections()) {
                composer2.startReplaceGroup(-529452088);
                ComposerKt.sourceInformation(composer2, "530@22189L27,533@22351L57,535@22503L6,531@22237L388");
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(2)), composer2, 6);
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str = "C101@5233L9:Row.kt#2w3rfo";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i2 = 6;
                i3 = -551457500;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_collections_grey_12dp, composer2, 0), (String) null, TestTagKt.testTag(Modifier.INSTANCE, "CollectionsBadge"), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0, 2, null), composer2, Painter.$stable | 432, 56);
            } else {
                str = "C101@5233L9:Row.kt#2w3rfo";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                i2 = 6;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                i3 = -551457500;
                composer2.startReplaceGroup(-551457500);
            }
            composer2.endReplaceGroup();
            if (state.getCommentsCount() > 0) {
                composer2.startReplaceGroup(-528906984);
                ComposerKt.sourceInformation(composer2, "541@22711L27,546@22962L6,542@22759L1268");
                float f = 2;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer2, i2);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                Modifier modifierTestTag2 = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(BackgroundKt.m588backgroundbw27NRU(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f))), Dp.m9687constructorimpl(f), 0.0f, Dp.m9687constructorimpl(f), 0.0f, 10, null), "CommentsBadge");
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str2);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str3);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, str);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 205167449, "C553@23292L42,555@23459L6,552@23247L274,557@23546L27,564@23944L6,558@23598L407:FolderListingScreen.kt#9mvyw3");
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.mini_chat, composer2, 0), (String) null, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), 0, 2, null), composer2, Painter.$stable | 48, 60);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer2, i2);
                TextKt.m4494TextNvy7gAk(String.valueOf(state.getCommentsCount()), TestTagKt.testTag(OffsetKt.m1175offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl((float) (-0.5d)), 1, null), "CommentsBadgeText"), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal8(), composer, 0, 0, 131064);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
                i3 = -551457500;
            } else {
                composer2.startReplaceGroup(i3);
                composer2.endReplaceGroup();
            }
            final Integer resource = OfflineManagerExtensionsKt.getResource(state.getOfflineState());
            if (resource != null) {
                composer2.startReplaceGroup(-527468212);
                ComposerKt.sourceInformation(composer2, "570@24184L27,572@24273L37,577@24531L223,571@24232L544");
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(2)), composer2, 6);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(resource.intValue(), composer2, 0);
                float f2 = 12;
                Modifier modifierM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), Dp.m9687constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composer2, 1784111613, "CC(remember):FolderListingScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(resource);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FolderListingScreenKt.BrowseItem$lambda$6$0$1$0(resource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ImageKt.Image(painterPainterResource, (String) null, SemanticsModifierKt.semantics$default(modifierM1271width3ABfNKs, false, (Function1) objRememberedValue, 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer2, Painter.$stable | 48, 120);
            } else {
                composer2.startReplaceGroup(i3);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseItem$lambda$6$0$1$0(Integer num, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        semantics.set(BoxSemanticsProperties.INSTANCE.getDrawable(), num);
        return Unit.INSTANCE;
    }

    public static final void LoadMoreItem(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1402609475);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadMoreItem)592@24865L310:FolderListingScreen.kt#9mvyw3");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1402609475, i, -1, "com.box.android.browse.compose.LoadMoreItem (FolderListingScreen.kt:591)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM()), 0.0f, 1, null), "LoadMoreProgressBar");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1221756252, "C600@25145L24:FolderListingScreen.kt#9mvyw3");
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 0, 127);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FolderListingScreenKt.LoadMoreItem$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ItemsListReducer.State FolderListingScreen$lambda$0(State<ItemsListReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureBanner$lambda$0(final boolean z, final BoxFeatureBanner boxFeatureBanner, final Function0 function0, final Function0 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        long jM11530getItemListingContentBackground0d7_KjU;
        BorderStroke borderStrokeM622BorderStrokecXLIe8U;
        Modifier modifierM1218padding3ABfNKs;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C371@15818L247,392@16617L2452,367@15666L3403:FolderListingScreen.kt#9mvyw3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-528931134, i, -1, "com.box.android.browse.compose.FeatureBanner.<anonymous> (FolderListingScreen.kt:367)");
        }
        RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(z ? 12 : 8));
        CardDefaults cardDefaults = CardDefaults.INSTANCE;
        if (z) {
            composer.startReplaceGroup(847828439);
            ComposerKt.sourceInformation(composer, "373@15919L6");
            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11511getContentBackground0d7_KjU();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(847907148);
            ComposerKt.sourceInformation(composer, "375@15998L6");
            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU();
            composer.endReplaceGroup();
        }
        CardColors cardColorsM2903cardColorsro_MJ88 = cardDefaults.m2903cardColorsro_MJ88(jM11530getItemListingContentBackground0d7_KjU, 0L, 0L, 0L, composer, CardDefaults.$stable << 12, 14);
        if (z) {
            composer.startReplaceGroup(848052197);
            ComposerKt.sourceInformation(composer, "379@16175L6");
            borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11517getDivider0d7_KjU());
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(848146716);
            composer.endReplaceGroup();
            borderStrokeM622BorderStrokecXLIe8U = null;
        }
        BorderStroke borderStroke = borderStrokeM622BorderStrokecXLIe8U;
        Modifier.Companion companion = Modifier.INSTANCE;
        if (z) {
            float f = 16;
            modifierM1218padding3ABfNKs = PaddingKt.m1221paddingqDBjuR0(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(8));
        } else {
            modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16));
        }
        CardKt.Card(TestTagKt.testTag(companion.then(modifierM1218padding3ABfNKs), "Feature banner"), roundedCornerShapeM1573RoundedCornerShape0680j_4, cardColorsM2903cardColorsro_MJ88, null, borderStroke, ComposableLambdaKt.rememberComposableLambda(2005792912, true, new Function3() { // from class: com.box.android.browse.compose.FolderListingScreenKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FolderListingScreenKt.FeatureBanner$lambda$0$0(z, boxFeatureBanner, function0, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}

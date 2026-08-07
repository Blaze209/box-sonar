package com.box.android.browse.search;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.base.compose.SearchBarToSearchScreenTransition;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.message.BoxMessageListenerEffectKt;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.browse.search.component.FilesRecentSearchQueriesKt;
import com.box.android.browse.search.component.FilesSearchInputFieldKt;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.cpl.Store;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxSearchItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FilesSearchScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\u001a\u0097\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\r2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u0014*\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0003¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020\u0014*\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0003¢\u0006\u0002\u0010#¨\u0006$²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\f\u0010'\u001a\u0004\u0018\u00010(X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020*X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"FilesSearchScreen", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "searchFolder", "Lcom/box/androidsdk/content/models/BoxFolder;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "onGoBackClick", "Lkotlin/Function0;", "onSearchItemClick", "Lkotlin/Function1;", "Lcom/box/androidsdk/content/models/BoxSearchItem;", "Lkotlin/ParameterName;", "name", "boxSearchItem", "onSearchItemMoreActionClick", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/box/android/browse/search/FilesSearchViewModel;", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/androidsdk/content/models/BoxFolder;Lcom/box/android/base/compose/ComposeFragmentInjector;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/box/android/browse/search/FilesSearchViewModel;Landroidx/compose/runtime/Composer;II)V", "sharedTransitionAnimatedBackground", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "transitionColor", "sharedTransitionAnimatedBackground-9z6LAg8", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/AnimatedVisibilityScope;JJLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sharedBoundsModifier", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "browse_generalProdRelease", "state", "Lcom/box/android/browse/search/FilesSearchReducer$State;", "searchFragment", "Lcom/box/android/browse/fragments/SearchFragment;", "progress", "", "roundedCornerAnimation", "Landroidx/compose/ui/unit/Dp;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchScreenKt {

    /* JADX INFO: compiled from: FilesSearchScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.Visible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$8(IUserContextManager iUserContextManager, BoxFolder boxFolder, ComposeFragmentInjector composeFragmentInjector, BoxMessageDispatcher boxMessageDispatcher, Function0 function0, Function1 function1, Function1 function2, Modifier modifier, FilesSearchViewModel filesSearchViewModel, int i, int i2, Composer composer, int i3) {
        FilesSearchScreen(iUserContextManager, boxFolder, composeFragmentInjector, boxMessageDispatcher, function0, function1, function2, modifier, filesSearchViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:112:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:117:0x0221  */
    /* JADX WARN: Code duplicated, block: B:124:0x025a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0343  */
    /* JADX WARN: Code duplicated, block: B:130:0x034f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0353  */
    /* JADX WARN: Code duplicated, block: B:136:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:139:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:143:0x0425  */
    /* JADX WARN: Code duplicated, block: B:148:0x044b  */
    /* JADX WARN: Code duplicated, block: B:150:0x0471  */
    /* JADX WARN: Code duplicated, block: B:152:0x0481  */
    /* JADX WARN: Code duplicated, block: B:153:0x0483  */
    /* JADX WARN: Code duplicated, block: B:155:0x0486  */
    /* JADX WARN: Code duplicated, block: B:157:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:158:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:161:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:162:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:169:0x050b  */
    /* JADX WARN: Code duplicated, block: B:171:0x0538  */
    /* JADX WARN: Code duplicated, block: B:175:0x0568  */
    /* JADX WARN: Code duplicated, block: B:178:0x0587  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void FilesSearchScreen(final IUserContextManager userContextManager, final BoxFolder boxFolder, final ComposeFragmentInjector composeFragmentInjector, final BoxMessageDispatcher boxMessageDispatcher, final Function0<Unit> onGoBackClick, final Function1<? super BoxSearchItem, Unit> onSearchItemClick, final Function1<? super BoxSearchItem, Unit> onSearchItemMoreActionClick, Modifier modifier, FilesSearchViewModel filesSearchViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        FilesSearchViewModel filesSearchViewModel2;
        final Modifier modifier3;
        final FilesSearchViewModel filesSearchViewModel3;
        Modifier modifier4;
        int i4;
        int i5;
        CreationExtras.Empty defaultViewModelCreationExtras;
        FilesSearchViewModel filesSearchViewModel4;
        final Store<FilesSearchReducer.State, FilesSearchReducer.Action> store;
        int i6;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue;
        MutableState mutableState;
        boolean zChanged;
        FilesSearchScreenKt$FilesSearchScreen$1$1 filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue;
        boolean zChanged2;
        FilesSearchScreenKt$FilesSearchScreen$2$1 filesSearchScreenKt$FilesSearchScreen$2$1;
        Context context;
        Function0<ComposeUiNode> constructor;
        boolean zChanged3;
        Object objRememberedValue2;
        boolean z;
        String str;
        final MutableState mutableState2;
        boolean z2;
        boolean z3;
        boolean z4;
        Object objRememberedValue3;
        Object objRememberedValue4;
        boolean zChanged4;
        Object objRememberedValue5;
        boolean zChanged5;
        Object objRememberedValue6;
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(onGoBackClick, "onGoBackClick");
        Intrinsics.checkNotNullParameter(onSearchItemClick, "onSearchItemClick");
        Intrinsics.checkNotNullParameter(onSearchItemMoreActionClick, "onSearchItemMoreActionClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1910639709);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesSearchScreen)N(userContextManager,searchFolder,composeFragmentInjector,boxMessageDispatcher,onGoBackClick,onSearchItemClick,onSearchItemMoreActionClick,modifier,viewModel)60@2942L29,61@3015L45,65@3087L64,65@3066L85,69@3185L51,69@3157L79,73@3269L7,75@3337L7,76@3411L7,80@3473L68,83@3675L6,84@3750L6,81@3555L229,78@3424L2498,136@6038L165,134@5928L281:FilesSearchScreen.kt#2iufy5");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(userContextManager) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(boxFolder) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(composeFragmentInjector) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onGoBackClick) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSearchItemClick) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSearchItemMoreActionClick) ? 1048576 : 524288;
        }
        int i7 = i2 & 128;
        if (i7 != 0) {
            i3 |= 12582912;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
            }
        }
        if ((i & 100663296) == 0) {
            if ((i2 & 256) == 0) {
                filesSearchViewModel2 = filesSearchViewModel;
                int i8 = composerStartRestartGroup.changedInstance(filesSearchViewModel2) ? 67108864 : 33554432;
                i3 |= i8;
            } else {
                filesSearchViewModel2 = filesSearchViewModel;
            }
            i3 |= i8;
        } else {
            filesSearchViewModel2 = filesSearchViewModel;
        }
        int i9 = i3;
        if (composerStartRestartGroup.shouldExecute((i9 & 38347923) != 38347922, i9 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "57@2861L15");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 256) != 0) {
                    i9 &= -234881025;
                }
                modifier4 = modifier2;
                i5 = i9;
                i4 = 2;
            } else {
                modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 256) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    i4 = 2;
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FilesSearchViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    int i10 = i9 & (-234881025);
                    filesSearchViewModel4 = (FilesSearchViewModel) viewModel;
                    i5 = i10;
                } else {
                    i4 = 2;
                    i5 = i9;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1910639709, i5, -1, "com.box.android.browse.search.FilesSearchScreen (FilesSearchScreen.kt:58)");
                }
                store = filesSearchViewModel4.getStore();
                i6 = i5;
                Modifier modifier5 = modifier4;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121261392, "CC(remember):FilesSearchScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, i4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121263715, "CC(remember):FilesSearchScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue = new FilesSearchScreenKt$FilesSearchScreen$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue, composerStartRestartGroup, 6);
                String query = FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getQuery();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121266838, "CC(remember):FilesSearchScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    filesSearchScreenKt$FilesSearchScreen$2$1 = new FilesSearchScreenKt$FilesSearchScreen$2$1(mutableState, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(filesSearchScreenKt$FilesSearchScreen$2$1);
                } else {
                    filesSearchScreenKt$FilesSearchScreen$2$1 = objRememberedValue7;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(query, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchScreenKt$FilesSearchScreen$2$1, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localSharedTransitionScope);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnimatedVisibilityScope animatedVisibilityScope = (AnimatedVisibilityScope) objConsume3;
                Composer composer2 = composerStartRestartGroup;
                Modifier modifierM12293sharedTransitionAnimatedBackground9z6LAg8 = m12293sharedTransitionAnimatedBackground9z6LAg8(sharedBoundsModifier(modifier5, (SharedTransitionScope) objConsume2, animatedVisibilityScope, composerStartRestartGroup, (i6 >> 21) & 14), animatedVisibilityScope, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11547getSearchBarCapsuleBackground0d7_KjU(), composer2, 0);
                composerStartRestartGroup = composer2;
                Modifier modifierStatusBarsPadding = WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxSize$default(modifierM12293sharedTransitionAnimatedBackground9z6LAg8, 0.0f, 1, null));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierStatusBarsPadding);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1776366877, "C91@3945L98,89@3861L235:FilesSearchScreen.kt#2iufy5");
                String query2 = FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getQuery();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466719227, "CC(remember):FilesSearchScreen.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesSearchScreenKt.FilesSearchScreen$lambda$6$0$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FilesSearchInputFieldKt.FilesSearchInputField(query2, null, (Function1) objRememberedValue2, onGoBackClick, null, null, composerStartRestartGroup, (i6 >> 3) & 7168, 50);
                if (FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getRecentSearchQueriesState() != null) {
                    composerStartRestartGroup.startReplaceGroup(-1776128395);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4312L126,102@4489L117,97@4163L508");
                    FilesSearchReducer.RecentSearchQueriesState recentSearchQueriesState = FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getRecentSearchQueriesState();
                    Intrinsics.checkNotNull(recentSearchQueriesState);
                    List<String> queries = recentSearchQueriesState.getQueries();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466730999, "CC(remember):FilesSearchScreen.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(store);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesSearchScreenKt.FilesSearchScreen$lambda$6$1$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function1 function1 = (Function1) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466736654, "CC(remember):FilesSearchScreen.kt#9igjgp");
                    zChanged5 = composerStartRestartGroup.changed(store);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesSearchScreenKt.FilesSearchScreen$lambda$6$2$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    FilesRecentSearchQueriesKt.FilesRecentSearchQueries(queries, function1, (Function1) objRememberedValue6, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 3072, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    str = "CC(remember):FilesSearchScreen.kt#9igjgp";
                    mutableState2 = mutableState;
                } else {
                    if (FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getQuery().length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = "CC(remember):FilesSearchScreen.kt#9igjgp";
                        mutableState2 = mutableState;
                        composerStartRestartGroup.startReplaceGroup(-1780261687);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1775544262);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "118@5348L544,109@4829L1077");
                        String userId = userContextManager.getBoxSession(context).getUserId();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchFragment.class);
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Bundle bundle = new Bundle();
                        bundle.putString(BoxBrowseFragment.ARG_USER_ID, userId);
                        bundle.putSerializable(BoxSearchFragment.EXTRA_PARENT_FOLDER, boxFolder);
                        bundle.putSerializable(BoxSearchFragment.EXTRA_SEARCH_FILTERS, FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getFilters());
                        bundle.putBoolean(BoxSearchFragment.EXTRA_IS_REDESIGNED, true);
                        Unit unit2 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466764569, "CC(remember):FilesSearchScreen.kt#9igjgp");
                        boolean zChanged6 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(store);
                        if ((i6 & 458752) == 131072) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        boolean z5 = zChanged6 | z2;
                        if ((i6 & 3670016) == 1048576) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z4 = z5 | z3;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            mutableState2 = mutableState;
                            Function1 function2 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return FilesSearchScreenKt.FilesSearchScreen$lambda$6$4$0(onSearchItemMoreActionClick, stateCollectAsStateWithLifecycle, store, onSearchItemClick, mutableState2, (SearchFragment) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(function2);
                            objRememberedValue3 = function2;
                        } else {
                            mutableState2 = mutableState;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        str = "CC(remember):FilesSearchScreen.kt#9igjgp";
                        ComposeFragmentInjector.ComposeDefaultImpls.applyFragment$default(orCreateKotlinClass, modifierFillMaxSize$default, bundle, (Function1) objRememberedValue3, composeFragmentInjector, composerStartRestartGroup, ((i6 << 6) & 57344) | 48, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121358248, str);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesSearchScreenKt.FilesSearchScreen$lambda$7$0(mutableState2, (BoxMessage) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue4, composerStartRestartGroup, BoxMessageDispatcher.$stable | 48 | ((i6 >> 9) & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                filesSearchViewModel3 = filesSearchViewModel4;
                modifier3 = modifier5;
            }
            filesSearchViewModel4 = filesSearchViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1910639709, i5, -1, "com.box.android.browse.search.FilesSearchScreen (FilesSearchScreen.kt:58)");
            }
            store = filesSearchViewModel4.getStore();
            i6 = i5;
            Modifier modifier6 = modifier4;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121261392, "CC(remember):FilesSearchScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, i4, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121263715, "CC(remember):FilesSearchScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(store);
            filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue = new FilesSearchScreenKt$FilesSearchScreen$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue);
            } else {
                filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue = new FilesSearchScreenKt$FilesSearchScreen$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchScreenKt$FilesSearchScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            String query3 = FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getQuery();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121266838, "CC(remember):FilesSearchScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                filesSearchScreenKt$FilesSearchScreen$2$1 = new FilesSearchScreenKt$FilesSearchScreen$2$1(mutableState, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchScreenKt$FilesSearchScreen$2$1);
            } else {
                filesSearchScreenKt$FilesSearchScreen$2$1 = new FilesSearchScreenKt$FilesSearchScreen$2$1(mutableState, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(filesSearchScreenKt$FilesSearchScreen$2$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(query3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesSearchScreenKt$FilesSearchScreen$2$1, composerStartRestartGroup, 0);
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume4;
            ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope2 = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localSharedTransitionScope2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope2 = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedVisibilityScope animatedVisibilityScope2 = (AnimatedVisibilityScope) objConsume6;
            Composer composer3 = composerStartRestartGroup;
            Modifier modifierM12293sharedTransitionAnimatedBackground9z6LAg9 = m12293sharedTransitionAnimatedBackground9z6LAg8(sharedBoundsModifier(modifier6, (SharedTransitionScope) objConsume5, animatedVisibilityScope2, composerStartRestartGroup, (i6 >> 21) & 14), animatedVisibilityScope2, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11547getSearchBarCapsuleBackground0d7_KjU(), composer3, 0);
            composerStartRestartGroup = composer3;
            Modifier modifierStatusBarsPadding2 = WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxSize$default(modifierM12293sharedTransitionAnimatedBackground9z6LAg9, 0.0f, 1, null));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierStatusBarsPadding2);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1776366877, "C91@3945L98,89@3861L235:FilesSearchScreen.kt#2iufy5");
            String query4 = FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getQuery();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466719227, "CC(remember):FilesSearchScreen.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(store);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesSearchScreenKt.FilesSearchScreen$lambda$6$0$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesSearchScreenKt.FilesSearchScreen$lambda$6$0$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FilesSearchInputFieldKt.FilesSearchInputField(query4, null, (Function1) objRememberedValue2, onGoBackClick, null, null, composerStartRestartGroup, (i6 >> 3) & 7168, 50);
            if (FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getRecentSearchQueriesState() != null) {
                composerStartRestartGroup.startReplaceGroup(-1776128395);
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4312L126,102@4489L117,97@4163L508");
                FilesSearchReducer.RecentSearchQueriesState recentSearchQueriesState2 = FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getRecentSearchQueriesState();
                Intrinsics.checkNotNull(recentSearchQueriesState2);
                List<String> queries2 = recentSearchQueriesState2.getQueries();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466730999, "CC(remember):FilesSearchScreen.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(store);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesSearchScreenKt.FilesSearchScreen$lambda$6$1$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesSearchScreenKt.FilesSearchScreen$lambda$6$1$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function1 function3 = (Function1) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466736654, "CC(remember):FilesSearchScreen.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(store);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesSearchScreenKt.FilesSearchScreen$lambda$6$2$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesSearchScreenKt.FilesSearchScreen$lambda$6$2$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                FilesRecentSearchQueriesKt.FilesRecentSearchQueries(queries2, function3, (Function1) objRememberedValue6, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 3072, 0);
                composerStartRestartGroup.endReplaceGroup();
                str = "CC(remember):FilesSearchScreen.kt#9igjgp";
                mutableState2 = mutableState;
            } else {
                if (FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getQuery().length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = "CC(remember):FilesSearchScreen.kt#9igjgp";
                    mutableState2 = mutableState;
                    composerStartRestartGroup.startReplaceGroup(-1780261687);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1775544262);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "118@5348L544,109@4829L1077");
                    String userId2 = userContextManager.getBoxSession(context).getUserId();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(SearchFragment.class);
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(BoxBrowseFragment.ARG_USER_ID, userId2);
                    bundle2.putSerializable(BoxSearchFragment.EXTRA_PARENT_FOLDER, boxFolder);
                    bundle2.putSerializable(BoxSearchFragment.EXTRA_SEARCH_FILTERS, FilesSearchScreen$lambda$0(stateCollectAsStateWithLifecycle).getFilters());
                    bundle2.putBoolean(BoxSearchFragment.EXTRA_IS_REDESIGNED, true);
                    Unit unit4 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1466764569, "CC(remember):FilesSearchScreen.kt#9igjgp");
                    boolean zChanged7 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(store);
                    if ((i6 & 458752) == 131072) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z6 = zChanged7 | z2;
                    if ((i6 & 3670016) == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = z6 | z3;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z4) {
                        mutableState2 = mutableState;
                        Function1 function4 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesSearchScreenKt.FilesSearchScreen$lambda$6$4$0(onSearchItemMoreActionClick, stateCollectAsStateWithLifecycle, store, onSearchItemClick, mutableState2, (SearchFragment) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function4);
                        objRememberedValue3 = function4;
                    } else {
                        mutableState2 = mutableState;
                        Function1 function5 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FilesSearchScreenKt.FilesSearchScreen$lambda$6$4$0(onSearchItemMoreActionClick, stateCollectAsStateWithLifecycle, store, onSearchItemClick, mutableState2, (SearchFragment) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(function5);
                        objRememberedValue3 = function5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str = "CC(remember):FilesSearchScreen.kt#9igjgp";
                    ComposeFragmentInjector.ComposeDefaultImpls.applyFragment$default(orCreateKotlinClass2, modifierFillMaxSize$default2, bundle2, (Function1) objRememberedValue3, composeFragmentInjector, composerStartRestartGroup, ((i6 << 6) & 57344) | 48, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2121358248, str);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesSearchScreenKt.FilesSearchScreen$lambda$7$0(mutableState2, (BoxMessage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxMessageListenerEffectKt.BoxMessageListenerEffect(boxMessageDispatcher, (Function1) objRememberedValue4, composerStartRestartGroup, BoxMessageDispatcher.$stable | 48 | ((i6 >> 9) & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            filesSearchViewModel3 = filesSearchViewModel4;
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            filesSearchViewModel3 = filesSearchViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesSearchScreenKt.FilesSearchScreen$lambda$8(userContextManager, boxFolder, composeFragmentInjector, boxMessageDispatcher, onGoBackClick, onSearchItemClick, onSearchItemMoreActionClick, modifier3, filesSearchViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchFragment FilesSearchScreen$lambda$2(MutableState<SearchFragment> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$6$0$0(Store store, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        store.send(new FilesSearchReducer.Action.QueryChanged(query));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$6$1$0(Store store, String recentSearch) {
        Intrinsics.checkNotNullParameter(recentSearch, "recentSearch");
        store.send(new FilesSearchReducer.Action.RecentQueryClicked(recentSearch));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$6$2$0(Store store, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        store.send(new FilesSearchReducer.Action.DeleteRecentSearchQuery(query));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$6$4$0(Function1 function1, State state, final Store store, final Function1 function2, MutableState mutableState, SearchFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        fragment.search(FilesSearchScreen$lambda$0(state).getQuery());
        fragment.setItemClickListener(new Function1() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilesSearchScreenKt.FilesSearchScreen$lambda$6$4$0$0$0(store, function2, (BoxSearchItem) obj);
            }
        });
        fragment.setItemMoreActionClickListener(function1);
        mutableState.setValue(fragment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$6$4$0$0$0(Store store, Function1 function1, BoxSearchItem boxSearchItem) {
        store.send(FilesSearchReducer.Action.AddSearchQueryToRecent.INSTANCE);
        Intrinsics.checkNotNull(boxSearchItem);
        function1.invoke(boxSearchItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchScreen$lambda$7$0(MutableState mutableState, BoxMessage message) {
        SearchFragment searchFragmentFilesSearchScreen$lambda$2;
        Intrinsics.checkNotNullParameter(message, "message");
        SearchFragment searchFragmentFilesSearchScreen$lambda$3 = FilesSearchScreen$lambda$2(mutableState);
        if (searchFragmentFilesSearchScreen$lambda$3 != null && searchFragmentFilesSearchScreen$lambda$3.shouldUpdateFragment(message) && (searchFragmentFilesSearchScreen$lambda$2 = FilesSearchScreen$lambda$2(mutableState)) != null) {
            searchFragmentFilesSearchScreen$lambda$2.updateFragment(message);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: sharedTransitionAnimatedBackground-9z6LAg8, reason: not valid java name */
    private static final Modifier m12293sharedTransitionAnimatedBackground9z6LAg8(Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, long j, long j2, Composer composer, int i) {
        Object currentState;
        float f;
        float f2;
        composer.startReplaceGroup(-1355387966);
        ComposerKt.sourceInformation(composer, "C(sharedTransitionAnimatedBackground)N(animatedVisibilityScope,defaultColor:c#ui.graphics.Color,transitionColor:c#ui.graphics.Color)152@6634L291:FilesSearchScreen.kt#2iufy5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355387966, i, -1, "com.box.android.browse.search.sharedTransitionAnimatedBackground (FilesSearchScreen.kt:149)");
        }
        if (animatedVisibilityScope == null) {
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier, j, null, 2, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierM589backgroundbw27NRU$default;
        }
        final Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
        Function3 function3 = new Function3() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FilesSearchScreenKt.sharedTransitionAnimatedBackground_9z6LAg8$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composer.changed(transition);
            currentState = composer.rememberedValue();
            if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    EnterExitState currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        EnterExitState enterExitState = (EnterExitState) currentState;
        composer.startReplaceGroup(-2095999168);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):FilesSearchScreen.kt#2iufy5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2095999168, 0, -1, "com.box.android.browse.search.sharedTransitionAnimatedBackground.<anonymous> (FilesSearchScreen.kt:155)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i2 == 1) {
            f = 0.0f;
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<EnterExitState>() { // from class: com.box.android.browse.search.FilesSearchScreenKt$sharedTransitionAnimatedBackground-9z6LAg8$$inlined$animateFloat$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.animation.EnterExitState, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final EnterExitState invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EnterExitState enterExitState2 = (EnterExitState) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(-2095999168);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):FilesSearchScreen.kt#2iufy5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2095999168, 0, -1, "com.box.android.browse.search.sharedTransitionAnimatedBackground.<anonymous> (FilesSearchScreen.kt:155)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[enterExitState2.ordinal()];
        if (i3 == 1) {
            f2 = 0.0f;
        } else if (i3 != 2) {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(f2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged3 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<EnterExitState>>() { // from class: com.box.android.browse.search.FilesSearchScreenKt$sharedTransitionAnimatedBackground-9z6LAg8$$inlined$animateFloat$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<EnterExitState> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "FloatAnimation", composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(modifier, ColorKt.m6865lerpjxsXWHM(j2, j, sharedTransitionAnimatedBackground_9z6LAg8$lambda$2(stateCreateTransitionAnimation)), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM589backgroundbw27NRU$default2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec sharedTransitionAnimatedBackground_9z6LAg8$lambda$0(Transition.Segment animateFloat, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer.startReplaceGroup(1929168558);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1929168558, i, -1, "com.box.android.browse.search.sharedTransitionAnimatedBackground.<anonymous> (FilesSearchScreen.kt:153)");
        }
        TweenSpec tweenSpecAnimationSpec = SearchBarToSearchScreenTransition.INSTANCE.animationSpec();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecAnimationSpec;
    }

    private static final Modifier sharedBoundsModifier(Modifier modifier, SharedTransitionScope sharedTransitionScope, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Composer composer2;
        Modifier modifierSharedBounds$default;
        Object currentState;
        float fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM;
        float fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM2;
        ComposerKt.sourceInformationMarkerStart(composer, 981889948, "C(sharedBoundsModifier)N(sharedTransitionScope,animatedVisibilityScope):FilesSearchScreen.kt#2iufy5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(981889948, i, -1, "com.box.android.browse.search.sharedBoundsModifier (FilesSearchScreen.kt:168)");
        }
        if (sharedTransitionScope == null || animatedVisibilityScope == null) {
            composer2 = composer;
            composer2.startReplaceGroup(-1537485510);
            composer2.endReplaceGroup();
            modifierSharedBounds$default = modifier;
        } else {
            composer.startReplaceGroup(-1538555661);
            ComposerKt.sourceInformation(composer, "169@7313L410,*180@7839L52");
            final Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
            Function3 function3 = new Function3() { // from class: com.box.android.browse.search.FilesSearchScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FilesSearchScreenKt.sharedBoundsModifier$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -89793049, "CC(animateDp)N(transitionSpec,label,targetValueByState)1981@85315L75:Transition.kt#pdpnli");
            TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transition.isSeeking()) {
                composer.startReplaceGroup(1666827533);
                composer.endReplaceGroup();
                currentState = transition.getCurrentState();
            } else {
                composer.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composer, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean zChanged = composer.changed(transition);
                currentState = composer.rememberedValue();
                if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        EnterExitState currentState2 = transition.getCurrentState();
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        composer.updateRememberedValue(currentState2);
                        currentState = currentState2;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            EnterExitState enterExitState = (EnterExitState) currentState;
            composer.startReplaceGroup(3834146);
            ComposerKt.sourceInformation(composer, "CN(enterExitState):FilesSearchScreen.kt#2iufy5");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3834146, 0, -1, "com.box.android.browse.search.sharedBoundsModifier.<anonymous> (FilesSearchScreen.kt:172)");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
            if (i2 == 1) {
                fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM = SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM();
            } else if (i2 == 2) {
                fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM = Dp.m9687constructorimpl(0);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM = SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Dp dpM9685boximpl = Dp.m9685boximpl(fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM);
            ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged2 = composer.changed(transition);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<EnterExitState>() { // from class: com.box.android.browse.search.FilesSearchScreenKt$sharedBoundsModifier$$inlined$animateDp$1
                    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.animation.EnterExitState, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final EnterExitState invoke() {
                        return transition.getTargetState();
                    }
                });
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EnterExitState enterExitState2 = (EnterExitState) ((State) objRememberedValue).getValue();
            composer.startReplaceGroup(3834146);
            ComposerKt.sourceInformation(composer, "CN(enterExitState):FilesSearchScreen.kt#2iufy5");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(3834146, 0, -1, "com.box.android.browse.search.sharedBoundsModifier.<anonymous> (FilesSearchScreen.kt:172)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[enterExitState2.ordinal()];
            if (i3 == 1) {
                fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM2 = SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM();
            } else if (i3 == 2) {
                fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM2 = Dp.m9687constructorimpl(0);
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM2 = SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            Dp dpM9685boximpl2 = Dp.m9685boximpl(fM11663getSearchBarCapsuleCornerRadiusD9Ej5fM2);
            ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged3 = composer.changed(transition);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<EnterExitState>>() { // from class: com.box.android.browse.search.FilesSearchScreenKt$sharedBoundsModifier$$inlined$animateDp$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<EnterExitState> invoke() {
                        return transition.getSegment();
                    }
                });
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, dpM9685boximpl, dpM9685boximpl2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "DpAnimation", composer, 0);
            composer2 = composer;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            modifierSharedBounds$default = SharedTransitionScope.sharedBounds$default(sharedTransitionScope, modifier, sharedTransitionScope.rememberSharedContentState(SearchBarToSearchScreenTransition.SEARCH_SCREEN_BOUNDS_KEY, composer2, 6), animatedVisibilityScope, EnterTransition.INSTANCE.getNone(), ExitTransition.INSTANCE.getNone(), SearchBarToSearchScreenTransition.INSTANCE.getSearchBoundsTransform(), SharedTransitionScope.ResizeMode.INSTANCE.getRemeasureToBounds(), null, false, 0.0f, sharedTransitionScope.OverlayClip(RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(sharedBoundsModifier$lambda$2(stateCreateTransitionAnimation))), 448, null);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return modifierSharedBounds$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec sharedBoundsModifier$lambda$0(Transition.Segment animateDp, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animateDp, "$this$animateDp");
        composer.startReplaceGroup(-1601860354);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1601860354, i, -1, "com.box.android.browse.search.sharedBoundsModifier.<anonymous> (FilesSearchScreen.kt:170)");
        }
        TweenSpec tweenSpecAnimationSpec = SearchBarToSearchScreenTransition.INSTANCE.animationSpec();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FilesSearchReducer.State FilesSearchScreen$lambda$0(State<FilesSearchReducer.State> state) {
        return state.getValue();
    }

    private static final float sharedTransitionAnimatedBackground_9z6LAg8$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float sharedBoundsModifier$lambda$2(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }
}

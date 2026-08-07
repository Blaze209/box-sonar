package com.box.android.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.databinding.FeatureFlipsToggleFragmentBinding;
import com.box.android.common.utilities.MetroDevSettings;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IFeatureFlip;
import dagger.hilt.android.AndroidEntryPoint;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeatureFlipsToggleFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\r\u0010\u001a\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u001bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ²\u0006\n\u0010!\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u008e\u0002"}, d2 = {"Lcom/box/android/base/FeatureFlipsToggleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "binding", "Lcom/box/android/base/databinding/FeatureFlipsToggleFragmentBinding;", "featureFlipList", "", "Lcom/box/android/domain/configuration/IFeatureFlip;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "FeatureFlipScreen", "(Landroidx/compose/runtime/Composer;I)V", "FeatureFlipItem", "featureFlip", "(Lcom/box/android/domain/configuration/IFeatureFlip;Landroidx/compose/runtime/Composer;I)V", "MetroServerSetting", "base_generalProdRelease", "useMetro", "", "metroUrl", ""}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class FeatureFlipsToggleFragment extends Hilt_FeatureFlipsToggleFragment {
    public static final int $stable = 8;
    private FeatureFlipsToggleFragmentBinding binding;
    private final List<IFeatureFlip> featureFlipList = new ArrayList();

    @Inject
    public FeatureFlips featureFlips;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureFlipItem$lambda$2(FeatureFlipsToggleFragment featureFlipsToggleFragment, IFeatureFlip iFeatureFlip, int i, Composer composer, int i2) {
        featureFlipsToggleFragment.FeatureFlipItem(iFeatureFlip, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureFlipScreen$lambda$1(FeatureFlipsToggleFragment featureFlipsToggleFragment, int i, Composer composer, int i2) {
        featureFlipsToggleFragment.FeatureFlipScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MetroServerSetting$lambda$7(FeatureFlipsToggleFragment featureFlipsToggleFragment, int i, Composer composer, int i2) {
        featureFlipsToggleFragment.MetroServerSetting(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public final FeatureFlips getFeatureFlips() {
        FeatureFlips featureFlips = this.featureFlips;
        if (featureFlips != null) {
            return featureFlips;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlips");
        return null;
    }

    public final void setFeatureFlips(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "<set-?>");
        this.featureFlips = featureFlips;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Field[] declaredFields = getFeatureFlips().getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (Intrinsics.areEqual(field.getType(), IFeatureFlip.class)) {
                arrayList.add(field);
            }
        }
        ArrayList<Field> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Field field2 : arrayList2) {
            field2.setAccessible(true);
            Object obj = field2.get(getFeatureFlips());
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.android.domain.configuration.IFeatureFlip");
            arrayList3.add((IFeatureFlip) obj);
        }
        Iterator it = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.box.android.base.FeatureFlipsToggleFragment$onCreateView$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((IFeatureFlip) t).getName(), ((IFeatureFlip) t2).getName());
            }
        }).iterator();
        while (it.hasNext()) {
            this.featureFlipList.add((IFeatureFlip) it.next());
        }
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return FeatureFlipsToggleFragment.onCreateView$lambda$4(this.f$0, (OnBackPressedCallback) obj2);
            }
        }, 2, null);
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBindingInflate = FeatureFlipsToggleFragmentBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(featureFlipsToggleFragmentBindingInflate, "inflate(...)");
        this.binding = featureFlipsToggleFragmentBindingInflate;
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBinding = null;
        if (featureFlipsToggleFragmentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            featureFlipsToggleFragmentBindingInflate = null;
        }
        ComposeView composeView = featureFlipsToggleFragmentBindingInflate.composeView;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1701643946, true, new Function2() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return FeatureFlipsToggleFragment.onCreateView$lambda$5$0(this.f$0, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }));
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBinding2 = this.binding;
        if (featureFlipsToggleFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            featureFlipsToggleFragmentBinding = featureFlipsToggleFragmentBinding2;
        }
        ConstraintLayout root = featureFlipsToggleFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$4(FeatureFlipsToggleFragment featureFlipsToggleFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        featureFlipsToggleFragment.getParentFragmentManager().popBackStackImmediate();
        addCallback.setEnabled(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$5$0(FeatureFlipsToggleFragment featureFlipsToggleFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C64@2619L19:FeatureFlipsToggleFragment.kt#i3t43k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1701643946, i, -1, "com.box.android.base.FeatureFlipsToggleFragment.onCreateView.<anonymous>.<anonymous> (FeatureFlipsToggleFragment.kt:64)");
            }
            featureFlipsToggleFragment.FeatureFlipScreen(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBinding = this.binding;
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBinding2 = null;
        if (featureFlipsToggleFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            featureFlipsToggleFragmentBinding = null;
        }
        featureFlipsToggleFragmentBinding.settingsToolbar.toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBinding3 = this.binding;
        if (featureFlipsToggleFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            featureFlipsToggleFragmentBinding3 = null;
        }
        featureFlipsToggleFragmentBinding3.settingsToolbar.toolbar.setTitle("Debug settings");
        FeatureFlipsToggleFragmentBinding featureFlipsToggleFragmentBinding4 = this.binding;
        if (featureFlipsToggleFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            featureFlipsToggleFragmentBinding2 = featureFlipsToggleFragmentBinding4;
        }
        featureFlipsToggleFragmentBinding2.settingsToolbar.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeatureFlipsToggleFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(FeatureFlipsToggleFragment featureFlipsToggleFragment, View view) {
        featureFlipsToggleFragment.requireActivity().onBackPressed();
    }

    public final void FeatureFlipScreen(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-310781949);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeatureFlipScreen)79@3165L367,79@3156L376:FeatureFlipsToggleFragment.kt#i3t43k");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-310781949, i2, -1, "com.box.android.base.FeatureFlipsToggleFragment.FeatureFlipScreen (FeatureFlipsToggleFragment.kt:78)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2043202584, true, new Function2() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeatureFlipsToggleFragment.FeatureFlipScreen$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeatureFlipsToggleFragment.FeatureFlipScreen$lambda$1(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureFlipScreen$lambda$0$0$0(final FeatureFlipsToggleFragment featureFlipsToggleFragment, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List<IFeatureFlip> list = featureFlipsToggleFragment.featureFlipList;
        final FeatureFlipsToggleFragment$FeatureFlipScreen$lambda$0$0$0$$inlined$items$default$1 featureFlipsToggleFragment$FeatureFlipScreen$lambda$0$0$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.base.FeatureFlipsToggleFragment$FeatureFlipScreen$lambda$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(IFeatureFlip iFeatureFlip) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((IFeatureFlip) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.base.FeatureFlipsToggleFragment$FeatureFlipScreen$lambda$0$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return featureFlipsToggleFragment$FeatureFlipScreen$lambda$0$0$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.base.FeatureFlipsToggleFragment$FeatureFlipScreen$lambda$0$0$0$$inlined$items$default$4
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
                IFeatureFlip iFeatureFlip = (IFeatureFlip) list.get(i);
                composer.startReplaceGroup(937076985);
                ComposerKt.sourceInformation(composer, "CN(ff)*85@3389L19:FeatureFlipsToggleFragment.kt#i3t43k");
                featureFlipsToggleFragment.FeatureFlipItem(iFeatureFlip, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1422128227, true, new Function3() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return FeatureFlipsToggleFragment.FeatureFlipScreen$lambda$0$0$0$1(this.f$0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureFlipScreen$lambda$0$0$0$1(FeatureFlipsToggleFragment featureFlipsToggleFragment, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C88@3470L20:FeatureFlipsToggleFragment.kt#i3t43k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1422128227, i, -1, "com.box.android.base.FeatureFlipsToggleFragment.FeatureFlipScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FeatureFlipsToggleFragment.kt:88)");
            }
            featureFlipsToggleFragment.MetroServerSetting(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public final void FeatureFlipItem(final IFeatureFlip featureFlip, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(featureFlip, "featureFlip");
        Composer composerStartRestartGroup = composer.startRestartGroup(320917686);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FeatureFlipItem)N(featureFlip)96@3631L48,97@3688L722:FeatureFlipsToggleFragment.kt#i3t43k");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(featureFlip) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(320917686, i2, -1, "com.box.android.base.FeatureFlipsToggleFragment.FeatureFlipItem (FeatureFlipsToggleFragment.kt:95)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -835746746, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(featureFlip.getEnabled()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -990221653, "C106@4062L6,101@3818L275,111@4260L126,108@4106L294:FeatureFlipsToggleFragment.kt#i3t43k");
            TextKt.m4494TextNvy7gAk(featureFlip.getName(), RowScope.weight$default(rowScopeInstance, PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9529getLefte0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12582912, 130040);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Modifier modifierAlign = rowScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2110138928, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changedInstance(featureFlip);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeatureFlipsToggleFragment.FeatureFlipItem$lambda$1$0$0(mutableState, this, featureFlip, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwitchKt.Switch(zBooleanValue, (Function1) objRememberedValue2, modifierAlign, null, false, null, null, composerStartRestartGroup, 0, 120);
            composer2 = composerStartRestartGroup;
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeatureFlipsToggleFragment.FeatureFlipItem$lambda$2(this.f$0, featureFlip, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureFlipItem$lambda$1$0$0(MutableState mutableState, FeatureFlipsToggleFragment featureFlipsToggleFragment, IFeatureFlip iFeatureFlip, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
        featureFlipsToggleFragment.getFeatureFlips().toggleFeatureFlip(iFeatureFlip, z);
        return Unit.INSTANCE;
    }

    public final void MetroServerSetting(Composer composer, final int i) {
        Composer composer2;
        final MutableState mutableState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-787055070);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MetroServerSetting)121@4489L60,122@4574L54,123@4637L1764:FeatureFlipsToggleFragment.kt#i3t43k");
        int i2 = i & 1;
        if (!composerStartRestartGroup.shouldExecute(i2 != 0, i2)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787055070, i, -1, "com.box.android.base.FeatureFlipsToggleFragment.MetroServerSetting (FeatureFlipsToggleFragment.kt:120)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -445676482, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(MetroDevSettings.INSTANCE.getUseMetroServer()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -445673768, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MetroDevSettings.INSTANCE.getMetroUrl(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f = 8;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m9687constructorimpl(f), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1556285987, "C124@4719L792,146@5609L104,144@5524L413,161@6360L6,155@5950L441:FeatureFlipsToggleFragment.kt#i3t43k");
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1282704048, "C133@5144L6,128@4866L313,138@5357L122,135@5196L301:FeatureFlipsToggleFragment.kt#i3t43k");
            float f2 = 16;
            TextKt.m4494TextNvy7gAk("X-Platform: Use Metro Server", RowScope.weight$default(rowScopeInstance, PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9529getLefte0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 6, 12582912, 130040);
            boolean zMetroServerSetting$lambda$1 = MetroServerSetting$lambda$1(mutableState2);
            Modifier modifierAlign = rowScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1288318742, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue3 = new Function1() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeatureFlipsToggleFragment.MetroServerSetting$lambda$6$0$0$0(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwitchKt.Switch(zMetroServerSetting$lambda$1, (Function1) objRememberedValue3, modifierAlign, null, false, null, null, composerStartRestartGroup, 48, 120);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strMetroServerSetting$lambda$4 = MetroServerSetting$lambda$4(mutableState3);
            boolean zMetroServerSetting$lambda$2 = MetroServerSetting$lambda$1(mutableState);
            Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f2), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1750885632, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeatureFlipsToggleFragment.MetroServerSetting$lambda$6$1$0(mutableState3, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OutlinedTextFieldKt.OutlinedTextField(strMetroServerSetting$lambda$4, (Function1<? super String, Unit>) objRememberedValue4, modifierM1220paddingVpY3zN4$default2, zMetroServerSetting$lambda$2, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$FeatureFlipsToggleFragmentKt.INSTANCE.m11341getLambda$1553004366$base_generalProdRelease(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, 1573296, 12582912, 0, 8257456);
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk("Emulator: 10.0.2.2:8081. Physical device: run 'adb reverse tcp:8081 tcp:8081' and use localhost:8081. Restart the app after changing.", PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2), 0.0f, 8, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9529getLefte0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer2, 0, 12582912, 130040);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FeatureFlipsToggleFragment.MetroServerSetting$lambda$7(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean MetroServerSetting$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void MetroServerSetting$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final String MetroServerSetting$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MetroServerSetting$lambda$6$0$0$0(MutableState mutableState, boolean z) {
        MetroServerSetting$lambda$2(mutableState, z);
        MetroDevSettings.INSTANCE.setUseMetroServer(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MetroServerSetting$lambda$6$1$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        MetroDevSettings.INSTANCE.setMetroUrl(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeatureFlipScreen$lambda$0(final FeatureFlipsToggleFragment featureFlipsToggleFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@3320L202,80@3179L343:FeatureFlipsToggleFragment.kt#i3t43k");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2043202584, i, -1, "com.box.android.base.FeatureFlipsToggleFragment.FeatureFlipScreen.<anonymous> (FeatureFlipsToggleFragment.kt:80)");
            }
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(55), 7, null);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 717634114, "CC(remember):FeatureFlipsToggleFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(featureFlipsToggleFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.FeatureFlipsToggleFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeatureFlipsToggleFragment.FeatureFlipScreen$lambda$0$0$0(this.f$0, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LazyDslKt.LazyColumn(modifierFillMaxWidth$default, null, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composer, 390, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

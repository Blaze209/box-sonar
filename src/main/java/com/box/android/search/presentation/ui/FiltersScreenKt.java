package com.box.android.search.presentation.ui;

import android.os.Bundle;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.browse.fragments.BoxFilterSearchResultsFragment;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.browse.models.SearchFiltersMapper;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.search.navigation.SearchDestination;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: FiltersScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"FiltersScreen", "", SearchDestination.InnerDestination.Filters.FILTERS_ARGS_KEY, "Lcom/box/android/domain/models/search/FilesSearchFilters;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "onApplyFilters", "Lkotlin/Function1;", "onBack", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/domain/models/search/FilesSearchFilters;Lcom/box/android/base/compose/ComposeFragmentInjector;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FiltersScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FiltersScreen$lambda$3(FilesSearchFilters filesSearchFilters, ComposeFragmentInjector composeFragmentInjector, Function1 function1, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FiltersScreen(filesSearchFilters, composeFragmentInjector, function1, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0091  */
    /* JADX WARN: Code duplicated, block: B:48:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:61:0x0127  */
    /* JADX WARN: Code duplicated, block: B:63:0x012c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0138  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    public static final void FiltersScreen(final FilesSearchFilters initialFilters, final ComposeFragmentInjector composeFragmentInjector, final Function1<? super FilesSearchFilters, Unit> onApplyFilters, final Function0<Unit> onBack, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean zChanged;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(initialFilters, "initialFilters");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(onApplyFilters, "onApplyFilters");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer composerStartRestartGroup = composer.startRestartGroup(-359168229);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FiltersScreen)N(initialFilters,composeFragmentInjector,onApplyFilters,onBack,modifier)30@1291L70,33@1453L6,34@1492L200,41@1699L1296,31@1366L1629:FiltersScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(initialFilters) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(composeFragmentInjector) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onApplyFilters) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onBack) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
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
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-359168229, i3, -1, "com.box.android.search.presentation.ui.FiltersScreen (FiltersScreen.kt:29)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1563276351, "CC(remember):FiltersScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(initialFilters);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SearchFiltersMapper.INSTANCE.toLegacyBoxSearchFilters(initialFilters);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final BoxSearchFilters boxSearchFilters = (BoxSearchFilters) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                long jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-399495969, true, new Function2() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FiltersScreenKt.FiltersScreen$lambda$1(onBack, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1366906474, true, new Function3() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FiltersScreenKt.FiltersScreen$lambda$2(onApplyFilters, composeFragmentInjector, boxSearchFilters, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                Modifier modifier4 = companion;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m4038ScaffoldTvnljyQ(modifierFillMaxSize$default, composableLambdaRememberComposableLambda, null, null, null, 0, jM11498getAppBackground0d7_KjU, 0L, null, composableLambdaRememberComposableLambda2, composer2, 805306416, 444);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FiltersScreenKt.FiltersScreen$lambda$3(initialFilters, composeFragmentInjector, onApplyFilters, onBack, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
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
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-359168229, i3, -1, "com.box.android.search.presentation.ui.FiltersScreen (FiltersScreen.kt:29)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1563276351, "CC(remember):FiltersScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(initialFilters);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = SearchFiltersMapper.INSTANCE.toLegacyBoxSearchFilters(initialFilters);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = SearchFiltersMapper.INSTANCE.toLegacyBoxSearchFilters(initialFilters);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final BoxSearchFilters boxSearchFilters2 = (BoxSearchFilters) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            long jM11498getAppBackground0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-399495969, true, new Function2() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FiltersScreenKt.FiltersScreen$lambda$1(onBack, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1366906474, true, new Function3() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FiltersScreenKt.FiltersScreen$lambda$2(onApplyFilters, composeFragmentInjector, boxSearchFilters2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            Modifier modifier5 = companion;
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(modifierFillMaxSize$default2, composableLambdaRememberComposableLambda3, null, null, null, 0, jM11498getAppBackground0d7_KjU2, 0L, null, composableLambdaRememberComposableLambda4, composer2, 805306416, 444);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FiltersScreenKt.FiltersScreen$lambda$3(initialFilters, composeFragmentInjector, onApplyFilters, onBack, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FiltersScreen$lambda$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C36@1547L43,35@1506L176:FiltersScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399495969, i, -1, "com.box.android.search.presentation.ui.FiltersScreen.<anonymous> (FiltersScreen.kt:35)");
            }
            BoxSimpleTopBarKt.BoxSimpleTopBar(StringResources_androidKt.stringResource(R.string.filters_header, composer, 0), function0, null, true, null, composer, 3072, 20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FiltersScreen$lambda$2(final Function1 function1, ComposeFragmentInjector composeFragmentInjector, BoxSearchFilters boxSearchFilters, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)47@2216L21:FiltersScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i2 = (composer.changed(paddingValues) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1366906474, i2, -1, "com.box.android.search.presentation.ui.FiltersScreen.<anonymous> (FiltersScreen.kt:47)");
            }
            composer.startMovableGroup(-662852815, Boolean.valueOf(DarkThemeKt.isSystemInDarkTheme(composer, 0)));
            ComposerKt.sourceInformation(composer, "58@2780L185,49@2301L678");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BoxFilterSearchResultsFragment.class);
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
            Bundle bundle = new Bundle();
            bundle.putSerializable(BoxFilterSearchResultsFragment.EXTRA_FILTERS, boxSearchFilters);
            bundle.putBoolean(BoxFilterSearchResultsFragment.EXTRA_IS_REDESIGNED, true);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -662836285, "CC(remember):FiltersScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FiltersScreenKt.FiltersScreen$lambda$2$1$0(function1, (BoxFilterSearchResultsFragment) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposeFragmentInjector.ComposeDefaultImpls.applyFragment$default(orCreateKotlinClass, modifierPadding, bundle, (Function1) objRememberedValue, composeFragmentInjector, composer, 0, 0);
            composer.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FiltersScreen$lambda$2$1$0(final Function1 function1, BoxFilterSearchResultsFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        fragment.setOnApplyListener(new BoxFilterSearchResultsFragment.OnApplyListener() { // from class: com.box.android.search.presentation.ui.FiltersScreenKt$$ExternalSyntheticLambda4
            @Override // com.box.android.browse.fragments.BoxFilterSearchResultsFragment.OnApplyListener
            public final void onApply(BoxSearchFilters boxSearchFilters) {
                FiltersScreenKt.FiltersScreen$lambda$2$1$0$0(function1, boxSearchFilters);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FiltersScreen$lambda$2$1$0$0(Function1 function1, BoxSearchFilters boxSearchFilters) {
        SearchFiltersMapper searchFiltersMapper = SearchFiltersMapper.INSTANCE;
        Intrinsics.checkNotNull(boxSearchFilters);
        function1.invoke(searchFiltersMapper.toFilesSearchFilters(boxSearchFilters));
    }
}

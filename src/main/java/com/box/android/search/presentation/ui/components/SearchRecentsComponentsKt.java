package com.box.android.search.presentation.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchRecentsComponents.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001aG\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019H\u0003¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"searchRecentsSection", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/LazyListScope;", "sectionId", "", "title", AlertFragment.ARG_ITEMS, "", "getLabel", "Lkotlin/Function1;", "getKey", "", "leadingIcon", "Landroidx/compose/ui/graphics/painter/Painter;", "onItemClick", "onDeleteItem", "SearchRecentsSectionHeader", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SearchRecentsListItem", "label", HubsObservability.HUB_ASSET_ICON, ViewProps.ON_CLICK, "Lkotlin/Function0;", "onDeleteClick", "(Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SearchRecentsListItemPreview", "(Landroidx/compose/runtime/Composer;I)V", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchRecentsComponentsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsListItem$lambda$1(String str, Painter painter, Function0 function0, Modifier modifier, Function0 function1, int i, int i2, Composer composer, int i3) {
        SearchRecentsListItem(str, painter, function0, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsListItemPreview$lambda$0(int i, Composer composer, int i2) {
        SearchRecentsListItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsSectionHeader$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SearchRecentsSectionHeader(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final <T> void searchRecentsSection(LazyListScope lazyListScope, final String sectionId, final String title, final List<? extends T> items, final Function1<? super T, String> getLabel, final Function1<? super T, ? extends Object> getKey, final Painter leadingIcon, final Function1<? super T, Unit> onItemClick, final Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(sectionId, "sectionId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(getLabel, "getLabel");
        Intrinsics.checkNotNullParameter(getKey, "getKey");
        Intrinsics.checkNotNullParameter(leadingIcon, "leadingIcon");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        if (items.isEmpty()) {
            return;
        }
        LazyListScope.item$default(lazyListScope, sectionId + "_header", null, ComposableLambdaKt.composableLambdaInstance(-1105885544, true, new Function3() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SearchRecentsComponentsKt.searchRecentsSection$lambda$0(title, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        final Function1 function2 = new Function1() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchRecentsComponentsKt.searchRecentsSection$lambda$1(sectionId, getKey, obj);
            }
        };
        final SearchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$1 searchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$1 = new Function1() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(T t) {
                return null;
            }
        };
        lazyListScope.items(items.size(), new Function1<Integer, Object>() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function2.invoke(items.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return searchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$1.invoke(items.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$searchRecentsSection$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                Function0 function0;
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
                final Object obj = items.get(i);
                composer.startReplaceGroup(1644115191);
                ComposerKt.sourceInformation(composer, "CN(item)*60@2393L21,54@2151L351:SearchRecentsComponents.kt#1mmsr7");
                Modifier modifierTestTag = TestTagKt.testTag(LazyItemScope.animateItem$default(lazyItemScope, Modifier.INSTANCE, null, null, null, 7, null), "SearchRecentItem:" + sectionId + ":" + getKey.invoke(obj));
                String str = (String) getLabel.invoke(obj);
                if (function1 == null) {
                    composer.startReplaceGroup(1644443541);
                    composer.endReplaceGroup();
                    function0 = null;
                } else {
                    composer.startReplaceGroup(1644443542);
                    ComposerKt.sourceInformation(composer, "*61@2474L16");
                    final Function1 function3 = function1;
                    ComposerKt.sourceInformationMarkerStart(composer, -1155216744, "CC(remember):SearchRecentsComponents.kt#9igjgp");
                    boolean zChanged = composer.changed(function3) | composer.changedInstance(obj);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$searchRecentsSection$3$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Type inference fix 'apply assigned field type' failed
                            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                             */
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function3.invoke(obj);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                }
                Function0 function4 = function0;
                Painter painter = leadingIcon;
                ComposerKt.sourceInformationMarkerStart(composer, -1886618177, "CC(remember):SearchRecentsComponents.kt#9igjgp");
                boolean zChanged2 = composer.changed(onItemClick) | composer.changedInstance(obj);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function5 = onItemClick;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$searchRecentsSection$3$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                         */
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function5.invoke(obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SearchRecentsComponentsKt.SearchRecentsListItem(str, painter, (Function0) objRememberedValue2, modifierTestTag, function4, composer, Painter.$stable << 3, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchRecentsSection$lambda$0(String str, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C47@1926L76:SearchRecentsComponents.kt#1mmsr7");
        if ((i & 6) == 0) {
            i |= composer.changed(item) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1105885544, i, -1, "com.box.android.search.presentation.ui.components.searchRecentsSection.<anonymous> (SearchRecentsComponents.kt:47)");
            }
            SearchRecentsSectionHeader(str, LazyItemScope.animateItem$default(item, Modifier.INSTANCE, null, null, null, 7, null), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object searchRecentsSection$lambda$1(String str, Function1 function1, Object obj) {
        return str + "_" + function1.invoke(obj);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    private static final void SearchRecentsSectionHeader(final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1270491095);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchRecentsSectionHeader)N(title,modifier)71@2719L6,68@2615L275:SearchRecentsComponents.kt#1mmsr7");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1270491095, i3, -1, "com.box.android.search.presentation.ui.components.SearchRecentsSectionHeader (SearchRecentsComponents.kt:67)");
                }
                composer2 = composerStartRestartGroup;
                Modifier modifier3 = companion;
                TextKt.m4494TextNvy7gAk(str, PaddingKt.m1222paddingqDBjuR0$default(PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(20), 0.0f, 2, null), 0.0f, Dp.m9687constructorimpl(24), 0.0f, Dp.m9687constructorimpl(12), 5, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold16(), composer2, i3 & 14, 0, 131064);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchRecentsComponentsKt.SearchRecentsSectionHeader$lambda$0(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1270491095, i3, -1, "com.box.android.search.presentation.ui.components.SearchRecentsSectionHeader (SearchRecentsComponents.kt:67)");
            }
            composer2 = composerStartRestartGroup;
            Modifier modifier4 = companion;
            TextKt.m4494TextNvy7gAk(str, PaddingKt.m1222paddingqDBjuR0$default(PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(20), 0.0f, 2, null), 0.0f, Dp.m9687constructorimpl(24), 0.0f, Dp.m9687constructorimpl(12), 5, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold16(), composer2, i3 & 14, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchRecentsComponentsKt.SearchRecentsSectionHeader$lambda$0(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x0134  */
    /* JADX WARN: Code duplicated, block: B:70:0x0140  */
    /* JADX WARN: Code duplicated, block: B:71:0x0144  */
    /* JADX WARN: Code duplicated, block: B:74:0x024a  */
    /* JADX WARN: Code duplicated, block: B:75:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:78:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:80:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:83:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    public static final void SearchRecentsListItem(final String str, final Painter painter, final Function0<Unit> function0, Modifier modifier, Function0<Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function0<Unit> function2;
        int i5;
        boolean z;
        final Modifier modifier3;
        final Function0<Unit> function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<Unit> function4;
        Function0<ComposeUiNode> constructor;
        Function0<Unit> function5;
        Composer composerStartRestartGroup = composer.startRestartGroup(2022510021);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchRecentsListItem)N(label,icon,onClick,modifier,onDeleteClick)87@3087L1520:SearchRecentsComponents.kt#1mmsr7");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(painter) : composerStartRestartGroup.changedInstance(painter) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function3 = function2;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function4 = null;
                    } else {
                        function4 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2022510021, i3, -1, "com.box.android.search.presentation.ui.components.SearchRecentsListItem (SearchRecentsComponents.kt:86)");
                    }
                    float f = 6;
                    Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(SizeKt.m1266size3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(60)), false, null, null, null, function0, 15, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(f));
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 248435478, "C99@3509L6,103@3692L6,96@3405L321,108@3840L6,105@3735L257:SearchRecentsComponents.kt#1mmsr7");
                    Modifier modifier4 = companion;
                    IconKt.m3575Iconww6aTOc(painter, (String) null, PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11551getSearchIconBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(12))), Dp.m9687constructorimpl(f)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11552getSearchIconContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 48 | ((i3 >> 3) & 14), 0);
                    TextKt.m4494TextNvy7gAk(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, i3 & 14, 24960, 110584);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (function4 != null) {
                        composerStartRestartGroup.startReplaceGroup(249047324);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "120@4348L55,123@4556L6,114@4042L549");
                        function5 = function4;
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function5, StringResources_androidKt.stringResource(R.string.delete_recent_search_query, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_close), false, 17, null), TestTagKt.testTag(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), "DeleteRecentQuery:" + str), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11543getPopupSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 20);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        function5 = function4;
                        composerStartRestartGroup.startReplaceGroup(245019649);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function5;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchRecentsComponentsKt.SearchRecentsListItem$lambda$1(str, painter, function0, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2022510021, i3, -1, "com.box.android.search.presentation.ui.components.SearchRecentsListItem (SearchRecentsComponents.kt:86)");
                }
                float f2 = 6;
                Modifier modifierM1219paddingVpY3zN5 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(SizeKt.m1266size3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(60)), false, null, null, null, function0, 15, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(f2));
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN5);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 248435478, "C99@3509L6,103@3692L6,96@3405L321,108@3840L6,105@3735L257:SearchRecentsComponents.kt#1mmsr7");
                Modifier modifier5 = companion;
                IconKt.m3575Iconww6aTOc(painter, (String) null, PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11551getSearchIconBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(12))), Dp.m9687constructorimpl(f2)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11552getSearchIconContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 48 | ((i3 >> 3) & 14), 0);
                TextKt.m4494TextNvy7gAk(str, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, i3 & 14, 24960, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
                if (function4 != null) {
                    composerStartRestartGroup.startReplaceGroup(249047324);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "120@4348L55,123@4556L6,114@4042L549");
                    function5 = function4;
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function5, StringResources_androidKt.stringResource(R.string.delete_recent_search_query, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_close), false, 17, null), TestTagKt.testTag(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), "DeleteRecentQuery:" + str), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11543getPopupSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 20);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    function5 = function4;
                    composerStartRestartGroup.startReplaceGroup(245019649);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchRecentsComponentsKt.SearchRecentsListItem$lambda$1(str, painter, function0, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function3 = function2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function4 = null;
                } else {
                    function4 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2022510021, i3, -1, "com.box.android.search.presentation.ui.components.SearchRecentsListItem (SearchRecentsComponents.kt:86)");
                }
                float f3 = 6;
                Modifier modifierM1219paddingVpY3zN6 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(SizeKt.m1266size3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(60)), false, null, null, null, function0, 15, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(f3));
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_6 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_6, centerVertically3, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN6);
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
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 248435478, "C99@3509L6,103@3692L6,96@3405L321,108@3840L6,105@3735L257:SearchRecentsComponents.kt#1mmsr7");
                Modifier modifier6 = companion;
                IconKt.m3575Iconww6aTOc(painter, (String) null, PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11551getSearchIconBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(12))), Dp.m9687constructorimpl(f3)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11552getSearchIconContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 48 | ((i3 >> 3) & 14), 0);
                TextKt.m4494TextNvy7gAk(str, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, i3 & 14, 24960, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
                if (function4 != null) {
                    composerStartRestartGroup.startReplaceGroup(249047324);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "120@4348L55,123@4556L6,114@4042L549");
                    function5 = function4;
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function5, StringResources_androidKt.stringResource(R.string.delete_recent_search_query, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_close), false, 17, null), TestTagKt.testTag(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), "DeleteRecentQuery:" + str), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11543getPopupSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 20);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    function5 = function4;
                    composerStartRestartGroup.startReplaceGroup(245019649);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
                modifier3 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchRecentsComponentsKt.SearchRecentsListItem$lambda$1(str, painter, function0, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function1;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function3 = function2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                function4 = null;
            } else {
                function4 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2022510021, i3, -1, "com.box.android.search.presentation.ui.components.SearchRecentsListItem (SearchRecentsComponents.kt:86)");
            }
            float f4 = 6;
            Modifier modifierM1219paddingVpY3zN7 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(SizeKt.m1266size3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(60)), false, null, null, null, function0, 15, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(f4));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_7 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(8));
            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_7, centerVertically4, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN7);
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
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 248435478, "C99@3509L6,103@3692L6,96@3405L321,108@3840L6,105@3735L257:SearchRecentsComponents.kt#1mmsr7");
            Modifier modifier7 = companion;
            IconKt.m3575Iconww6aTOc(painter, (String) null, PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11551getSearchIconBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(12))), Dp.m9687constructorimpl(f4)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11552getSearchIconContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 48 | ((i3 >> 3) & 14), 0);
            TextKt.m4494TextNvy7gAk(str, RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, i3 & 14, 24960, 110584);
            composerStartRestartGroup = composerStartRestartGroup;
            if (function4 != null) {
                composerStartRestartGroup.startReplaceGroup(249047324);
                ComposerKt.sourceInformation(composerStartRestartGroup, "120@4348L55,123@4556L6,114@4042L549");
                function5 = function4;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function5, StringResources_androidKt.stringResource(R.string.delete_recent_search_query, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_close), false, 17, null), TestTagKt.testTag(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), "DeleteRecentQuery:" + str), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11543getPopupSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 20);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                function5 = function4;
                composerStartRestartGroup.startReplaceGroup(245019649);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function5;
            modifier3 = modifier7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchRecentsComponentsKt.SearchRecentsListItem$lambda$1(str, painter, function0, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SearchRecentsListItemPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1663874192);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchRecentsListItemPreview)134@4763L218:SearchRecentsComponents.kt#1mmsr7");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1663874192, i, -1, "com.box.android.search.presentation.ui.components.SearchRecentsListItemPreview (SearchRecentsComponents.kt:133)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$SearchRecentsComponentsKt.INSTANCE.m13039getLambda$1045418747$search_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchRecentsComponentsKt.SearchRecentsListItemPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

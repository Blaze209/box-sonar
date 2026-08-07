package com.box.android.preview.preview.previewbar.bottombar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.BottomAppBarDefaults;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeFadingEdgeKt;
import com.box.android.base.compose.button.BadgedIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.boxai.ui.BoxAIColorPalette;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt;
import com.box.android.preview.fileactions.FileAction;
import com.box.android.preview.fileactions.FileActionMapperKt;
import com.box.android.preview.fileactions.FileActionUIItem;
import com.box.android.preview.fileactions.FileActionsReducer;
import com.box.android.preview.fileactions.copylink.CopyLinkReducer;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.preview.PreviewReducerHelpersKt;
import com.box.android.preview.preview.PreviewUIDependencyProvider;
import com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotesCABViewKt;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: PreviewBottomBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a!\u0010\n\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0002\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"PreviewBottomBar", "", "state", "Lcom/box/android/preview/preview/PreviewReducer$State;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "dependencyProvider", "Lcom/box/android/preview/preview/PreviewUIDependencyProvider;", "(Lcom/box/android/preview/preview/PreviewReducer$State;Lcom/box/android/cpl/Store;Lcom/box/android/preview/preview/PreviewUIDependencyProvider;Landroidx/compose/runtime/Composer;I)V", "PreviewBottomBarContent", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "BoxAiButton", "isEnabled", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "hasUserPrompts", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewBottomBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiButton$lambda$2(boolean z, Function0 function0, boolean z2, int i, Composer composer, int i2) {
        BoxAiButton(z, function0, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewBottomBar$lambda$1(PreviewReducer.State state, Store store, PreviewUIDependencyProvider previewUIDependencyProvider, int i, Composer composer, int i2) {
        PreviewBottomBar(state, store, previewUIDependencyProvider, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewBottomBarContent$lambda$3(Store store, int i, Composer composer, int i2) {
        PreviewBottomBarContent(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviewBottomBar(final PreviewReducer.State state, final Store<PreviewReducer.State, PreviewReducer.Action> store, PreviewUIDependencyProvider dependencyProvider, Composer composer, final int i) {
        int i2;
        final PreviewUIDependencyProvider previewUIDependencyProvider;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dependencyProvider, "dependencyProvider");
        Composer composerStartRestartGroup = composer.startRestartGroup(201311066);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewBottomBar)N(state,store,dependencyProvider)60@2810L837:PreviewBottomBar.kt#wctmao");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(dependencyProvider) ? 256 : 128;
        }
        boolean z = false;
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            previewUIDependencyProvider = dependencyProvider;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(201311066, i2, -1, "com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBar (PreviewBottomBar.kt:59)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1194849162, "C:PreviewBottomBar.kt#wctmao");
            if (state.getIsCreateAnnotationMode()) {
                composerStartRestartGroup.startReplaceGroup(-1194826812);
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@3107L120,62@2908L390");
                CreateAnnotationReducer.State createAnnotationState = state.getCreateAnnotationState();
                if (createAnnotationState != null && createAnnotationState.getIsInWritingCommentState()) {
                    z = true;
                }
                boolean z2 = !z;
                PreviewBottomBarKt$PreviewBottomBar$1$1 previewBottomBarKt$PreviewBottomBar$1$1 = new PropertyReference1Impl() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$PreviewBottomBar$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((PreviewReducer.State) obj).getCreateAnnotationState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1701104264, "CC(remember):PreviewBottomBar.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(state);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PreviewBottomBarKt.PreviewBottomBar$lambda$0$0$0(state, (CreateAnnotationReducer.Action) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                previewUIDependencyProvider = dependencyProvider;
                ComposeAnnotationToolbarKt.ComposeAnnotationToolbar(z2, store.ifScope(previewBottomBarKt$PreviewBottomBar$1$1, (Function1) objRememberedValue), previewUIDependencyProvider, composerStartRestartGroup, i2 & 896, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                previewUIDependencyProvider = dependencyProvider;
                if (state.getIsBoxNoteEditingMode()) {
                    composerStartRestartGroup.startReplaceGroup(-1194384225);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3459L90,70@3360L203");
                    PreviewBottomBarKt$PreviewBottomBar$1$3 previewBottomBarKt$PreviewBottomBar$1$3 = new PropertyReference1Impl() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$PreviewBottomBar$1$3
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((PreviewReducer.State) obj).getBoxNoteEditModeState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1701093030, "CC(remember):PreviewBottomBar.kt#9igjgp");
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return PreviewBottomBarKt.PreviewBottomBar$lambda$0$1$0((BoxNoteEditModeReducer.Action) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxNotesCABViewKt.BoxNotesCABView(store.ifScope(previewBottomBarKt$PreviewBottomBar$1$3, (Function1) objRememberedValue2), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1194158204);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "76@3593L38");
                    PreviewBottomBarContent(store, composerStartRestartGroup, (i2 >> 3) & 14);
                    composerStartRestartGroup.endReplaceGroup();
                }
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewBottomBarKt.PreviewBottomBar$lambda$1(state, store, previewUIDependencyProvider, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewReducer.Action PreviewBottomBar$lambda$0$0$0(PreviewReducer.State state, CreateAnnotationReducer.Action it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PreviewReducerHelpersKt.createAnnotationAction(PreviewReducer.Action.SelectedItem.INSTANCE, state.getPreviewItem(), it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewReducer.Action PreviewBottomBar$lambda$0$1$0(BoxNoteEditModeReducer.Action it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PreviewReducerHelpersKt.boxNoteEdit(PreviewReducer.Action.SelectedItem.INSTANCE, it);
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
    public static final void PreviewBottomBarContent(final Store<PreviewReducer.State, PreviewReducer.Action> store, Composer composer, final int i) {
        CopyLinkReducer.State copyLinkState;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(436495086);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewBottomBarContent)N(store)83@3781L29,102@4650L1363:PreviewBottomBar.kt#wctmao");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(store) ? 4 : 2) | i : i;
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(436495086, i2, -1, "com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarContent (PreviewBottomBar.kt:82)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composerStartRestartGroup.startReplaceGroup(-1435010212);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*90@4293L44,92@4405L223");
            List<BottomBarReducer.BottomBarAction> actions = PreviewBottomBarContent$lambda$0(stateCollectAsStateWithLifecycle).getBottomBarState().getActions();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(actions, 10));
            for (final BottomBarReducer.BottomBarAction bottomBarAction : actions) {
                FileActionUIItem fileActionUIItemMapToFileActionItem = FileActionMapperKt.mapToFileActionItem(bottomBarAction.getAction(), PreviewBottomBarContent$lambda$0(stateCollectAsStateWithLifecycle).getPreviewSource());
                boolean z = bottomBarAction.getAction() == FileAction.CopySharedLink && (copyLinkState = PreviewBottomBarContent$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getCopyLinkState()) != null && copyLinkState.isFetching();
                ButtonItemIconResource.DrawableResource drawableResource = new ButtonItemIconResource.DrawableResource(fileActionUIItemMapToFileActionItem.getIconRes());
                boolean zIsEnabled = bottomBarAction.getState().isEnabled();
                String strStringResource = StringResources_androidKt.stringResource(fileActionUIItemMapToFileActionItem.getTitleRes(), composerStartRestartGroup, 0);
                Long badgeCount = bottomBarAction.getBadgeCount();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 139788892, "CC(remember):PreviewBottomBar.kt#9igjgp");
                boolean zChanged = ((i2 & 14) == 4) | composerStartRestartGroup.changed(bottomBarAction);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreviewBottomBarKt.PreviewBottomBarContent$lambda$1$0$0(store, bottomBarAction);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                arrayList.add(new ButtonItem.BadgedIconButtonItem(zIsEnabled, (Function0) objRememberedValue, strStringResource, drawableResource, badgeCount, z));
            }
            ArrayList<ButtonItem.BadgedIconButtonItem> arrayList2 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1453917007, "C105@4784L6,106@4847L6,107@4931L12,103@4667L1340:PreviewBottomBar.kt#wctmao");
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.m589backgroundbw27NRU$default(ComposeFadingEdgeKt.m11630topFadingEdgeH2RKhps(Modifier.INSTANCE, BoxTheme.INSTANCE.getSizes().m11608getBottomBarGradientHeightD9Ej5fM(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), null, 2, null), BottomAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, BottomAppBarDefaults.$stable)), BoxTheme.INSTANCE.getSizes().m11609getBottomBarHeightD9Ej5fM()), 0.0f, 1, null), Dp.m9687constructorimpl(4), 0.0f, 2, null), "Preview:BottomBar");
            Arrangement.HorizontalOrVertical spaceAround = Arrangement.INSTANCE.getSpaceAround();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceAround, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 198151734, "C:PreviewBottomBar.kt#wctmao");
            composerStartRestartGroup.startReplaceGroup(1807507681);
            ComposerKt.sourceInformation(composerStartRestartGroup, "116@5357L31");
            for (ButtonItem.BadgedIconButtonItem badgedIconButtonItem : arrayList2) {
                if (Intrinsics.areEqual(badgedIconButtonItem.getContentDescription(), StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0))) {
                    composerStartRestartGroup.startReplaceGroup(2009761511);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "117@5412L317");
                    BoxAiButton(badgedIconButtonItem.getIsEnabled(), badgedIconButtonItem.getOnClick(), PreviewBottomBarContent$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getBoxAiState().hasPrompts() || PreviewBottomBarContent$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getBoxAiCenterState().isSessionActive(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(2010117670);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "124@5775L190");
                    Composer composer2 = composerStartRestartGroup;
                    BadgedIconButtonKt.m11678BadgedIconButtoncf5BqRc(badgedIconButtonItem, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), 0L, 0.3f, composer2, 3120, 4);
                    composerStartRestartGroup = composer2;
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewBottomBarKt.PreviewBottomBarContent$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewBottomBarContent$lambda$1$0$0(Store store, BottomBarReducer.BottomBarAction bottomBarAction) {
        store.send(new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.PerformAction(bottomBarAction.getAction())));
        return Unit.INSTANCE;
    }

    private static final void BoxAiButton(final boolean z, final Function0<Unit> function0, final boolean z2, Composer composer, final int i) {
        int i2;
        final SolidColor solidColorM6763linearGradientmHitzGk$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(1491166419);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiButton)N(isEnabled,onClick,hasUserPrompts):PreviewBottomBar.kt#wctmao");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1491166419, i2, -1, "com.box.android.preview.preview.previewbar.bottombar.BoxAiButton (PreviewBottomBar.kt:136)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(492190766);
                ComposerKt.sourceInformation(composerStartRestartGroup, "155@6829L6,160@6988L523,147@6556L955");
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(492203445);
                    composerStartRestartGroup.endReplaceGroup();
                    solidColorM6763linearGradientmHitzGk$default = Brush.Companion.m6763linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6804boximpl(BoxAIColorPalette.INSTANCE.m12025getBOX_AI_MAGENTA0d7_KjU()), Color.m6804boximpl(BoxAIColorPalette.INSTANCE.m12026getBOX_AI_ROYAL_BLUE0d7_KjU())}), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) << 32)), 0, 8, (Object) null);
                } else {
                    composerStartRestartGroup.startReplaceGroup(492482631);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "145@6511L6");
                    SolidColor solidColor = new SolidColor(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, BoxAITheme.$stable).m12051getAiButtonBackground0d7_KjU(), null);
                    composerStartRestartGroup.endReplaceGroup();
                    solidColorM6763linearGradientmHitzGk$default = solidColor;
                }
                float f = 1;
                SurfaceKt.m4323SurfaceT9BRK9s(SizeKt.m1271width3ABfNKs(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), Dp.m9687constructorimpl(54)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(20)), Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0.0f, Dp.m9687constructorimpl(f), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(f), Color.m6813copywmQWz5c$default(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, BoxAITheme.$stable).m12052getAiButtonBorder0d7_KjU(), z2 ? 0.7f : 1.0f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableLambdaKt.rememberComposableLambda(1308781021, true, new Function2() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewBottomBarKt.BoxAiButton$lambda$0(solidColorM6763linearGradientmHitzGk$default, function0, z2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12779910, 24);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(493534089);
                ComposerKt.sourceInformation(composerStartRestartGroup, "177@7752L51,179@7866L2,173@7533L438");
                ButtonItemIconResource.DrawableResource drawableResource = new ButtonItemIconResource.DrawableResource(R.drawable.ic_box_ai);
                String strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_open_talkback_label, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1508089675, "CC(remember):PreviewBottomBar.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BadgedIconButtonKt.m11678BadgedIconButtoncf5BqRc(new ButtonItem.BadgedIconButtonItem(false, (Function0) objRememberedValue, strStringResource, drawableResource, null, false, 32, null), SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(48)), 0L, 0.3f, composerStartRestartGroup, 3120, 4);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.bottombar.PreviewBottomBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewBottomBarKt.BoxAiButton$lambda$2(z, function0, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiButton$lambda$0(Brush brush, Function0 function0, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C162@7035L42,167@7293L51,161@7002L499:PreviewBottomBar.kt#wctmao");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1308781021, i, -1, "com.box.android.preview.preview.previewbar.bottombar.BoxAiButton.<anonymous> (PreviewBottomBar.kt:161)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composer, 0), StringResources_androidKt.stringResource(R.string.box_ai_open_talkback_label, composer, 0), PaddingKt.m1220paddingVpY3zN4$default(ClickableKt.m632clickableoSLSa3U$default(BackgroundKt.background$default(Modifier.INSTANCE, brush, null, 0.0f, 6, null), false, null, null, null, function0, 15, null), 0.0f, Dp.m9687constructorimpl(6), 1, null), (Alignment) null, ContentScale.INSTANCE.getFillHeight(), 0.0f, z ? ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, Color.INSTANCE.m6851getWhite0d7_KjU(), 0, 2, null) : null, composer, Painter.$stable | 24576, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final PreviewReducer.State PreviewBottomBarContent$lambda$0(State<PreviewReducer.State> state) {
        return state.getValue();
    }
}

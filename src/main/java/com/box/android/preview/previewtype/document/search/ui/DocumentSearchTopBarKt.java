package com.box.android.preview.previewtype.document.search.ui;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.textfield.BoxSimpleTextFieldColorConfigs;
import com.box.android.base.compose.textfield.BoxSimpleTextFieldKt;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: DocumentSearchTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PreviewSearchTopBar", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$State;", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DocumentSearchTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSearchTopBar$lambda$0(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewSearchTopBar(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSearchTopBar$lambda$3(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewSearchTopBar(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    /* JADX WARN: Code duplicated, block: B:67:0x0187  */
    /* JADX WARN: Code duplicated, block: B:70:0x0190  */
    /* JADX WARN: Code duplicated, block: B:73:0x0199  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    public static final void PreviewSearchTopBar(final Store<DocumentSearchReducer.State, DocumentSearchReducer.Action> store, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        StateFlow<DocumentSearchReducer.State> state;
        State stateCollectAsStateWithLifecycle;
        final Modifier modifier5;
        DocumentSearchReducer.State state2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112119681);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewSearchTopBar)N(store,modifier)23@1117L60,25@1270L6,26@1322L6,27@1382L6,28@1448L6,31@1568L70,32@1664L87,35@1778L77,20@982L879:DocumentSearchTopBar.kt#z0e3so");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (!composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2112119681, i4, -1, "com.box.android.preview.previewtype.document.search.ui.PreviewSearchTopBar (DocumentSearchTopBar.kt:18)");
                }
                if (store != null) {
                    state = store.getState();
                } else {
                    state = null;
                }
                if (state == null) {
                    composerStartRestartGroup.startReplaceGroup(-886368667);
                    composerStartRestartGroup.endReplaceGroup();
                    stateCollectAsStateWithLifecycle = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1772522780);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "19@931L29");
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(state, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (stateCollectAsStateWithLifecycle != null || (state2 = (DocumentSearchReducer.State) stateCollectAsStateWithLifecycle.getValue()) == null) {
                    modifier5 = modifier4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DocumentSearchTopBarKt.PreviewSearchTopBar$lambda$0(store, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(modifier4, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
                    String searchQuery = state2.getSearchQuery();
                    String strStringResource = StringResources_androidKt.stringResource(R.string.preview_search_document_placeholder, composerStartRestartGroup, 0);
                    BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs = new BoxSimpleTextFieldColorConfigs(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 16, null);
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.clear_search_query_button_content_description, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1772546294, "CC(remember):DocumentSearchTopBar.kt#9igjgp");
                    int i6 = i4 & 14;
                    boolean z2 = i6 == 4;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DocumentSearchTopBarKt.PreviewSearchTopBar$lambda$1$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1772549932, "CC(remember):DocumentSearchTopBar.kt#9igjgp");
                    boolean z3 = i6 == 4;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DocumentSearchTopBarKt.PreviewSearchTopBar$lambda$2$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier3 = modifier4;
                    BoxSimpleTextFieldKt.BoxSimpleTextField(modifierFillMaxSize$default, searchQuery, strStringResource, null, boxSimpleTextFieldColorConfigs, "Preview:SearchTextField", strStringResource2, function1, (Function0) objRememberedValue2, null, composerStartRestartGroup, (BoxSimpleTextFieldColorConfigs.$stable << 12) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 520);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DocumentSearchTopBarKt.PreviewSearchTopBar$lambda$3(store, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (!composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112119681, i4, -1, "com.box.android.preview.previewtype.document.search.ui.PreviewSearchTopBar (DocumentSearchTopBar.kt:18)");
            }
            if (store != null) {
                state = store.getState();
            } else {
                state = null;
            }
            if (state == null) {
                composerStartRestartGroup.startReplaceGroup(-886368667);
                composerStartRestartGroup.endReplaceGroup();
                stateCollectAsStateWithLifecycle = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1772522780);
                ComposerKt.sourceInformation(composerStartRestartGroup, "19@931L29");
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(state, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (stateCollectAsStateWithLifecycle != null) {
            }
            modifier5 = modifier4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DocumentSearchTopBarKt.PreviewSearchTopBar$lambda$0(store, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            return;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.previewtype.document.search.ui.DocumentSearchTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentSearchTopBarKt.PreviewSearchTopBar$lambda$3(store, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSearchTopBar$lambda$1$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new DocumentSearchReducer.Action.SearchQueryChanged(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSearchTopBar$lambda$2$0(Store store) {
        store.send(DocumentSearchReducer.Action.ClearClicked.INSTANCE);
        return Unit.INSTANCE;
    }
}

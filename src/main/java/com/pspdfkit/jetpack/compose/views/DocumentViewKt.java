package com.pspdfkit.jetpack.compose.views;

import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.fragment.compose.AndroidFragmentKt;
import androidx.fragment.compose.FragmentState;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.u9;
import com.pspdfkit.internal.v9;
import com.pspdfkit.internal.x9;
import com.pspdfkit.jetpack.compose.interactors.AnnotationListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentManager;
import com.pspdfkit.jetpack.compose.interactors.DocumentManagerKt;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.jetpack.compose.interactors.DocumentStateKt;
import com.pspdfkit.jetpack.compose.interactors.FormListener;
import com.pspdfkit.jetpack.compose.interactors.InstantDocumentListener;
import com.pspdfkit.jetpack.compose.interactors.InstantDocumentManager;
import com.pspdfkit.jetpack.compose.interactors.UiListener;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"DocumentView", "", "documentUri", "Landroid/net/Uri;", "modifier", "Landroidx/compose/ui/Modifier;", "documentManager", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;", "(Landroid/net/Uri;Landroidx/compose/ui/Modifier;Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;Landroidx/compose/runtime/Composer;II)V", "documentState", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "(Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;Landroidx/compose/ui/Modifier;Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;Landroidx/compose/runtime/Composer;II)V", "InstantDocumentView", "instantDocumentManager", "Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentManager;", "(Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;Landroidx/compose/ui/Modifier;Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentManager;Landroidx/compose/runtime/Composer;II)V", "sdk-nutrient", "fragmentState", "Landroidx/fragment/compose/FragmentState;"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class DocumentViewKt {
    /* JADX WARN: Code duplicated, block: B:30:0x004e  */
    public static final void DocumentView(final Uri uri, Modifier modifier, DocumentManager documentManager, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final Modifier modifier2;
        final DocumentManager documentManager2;
        Composer composer3;
        Modifier modifier3;
        DocumentManager defaultDocumentManager;
        int i4;
        uri.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1918065407);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i4 = 128;
            } else {
                if ((i & 512) == 0 ? composerStartRestartGroup.changed(documentManager) : composerStartRestartGroup.changedInstance(documentManager)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
            }
            i3 |= i4;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -897;
                    modifier3 = modifier;
                    defaultDocumentManager = DocumentManagerKt.getDefaultDocumentManager(null, null, null, null, composer3, 0, 15);
                } else {
                    composer3 = composerStartRestartGroup;
                    modifier3 = modifier;
                    defaultDocumentManager = documentManager;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier3 = modifier;
                defaultDocumentManager = documentManager;
                composer3 = composerStartRestartGroup;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1918065407, i3, -1, "com.pspdfkit.jetpack.compose.views.DocumentView (DocumentView.kt:37)");
            }
            Composer composer4 = composer3;
            DocumentView(DocumentStateKt.rememberDocumentState(uri, (PdfActivityConfiguration) null, composer3, i3 & 14, 2), modifier3, defaultDocumentManager, composer4, i3 & 1008, 0);
            composer2 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            documentManager2 = defaultDocumentManager;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            documentManager2 = documentManager;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentViewKt.DocumentView$lambda$0(uri, modifier2, documentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentView$lambda$0(Uri uri, Modifier modifier, DocumentManager documentManager, int i, int i2, Composer composer, int i3) {
        DocumentView(uri, modifier, documentManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final FragmentState DocumentView$lambda$2(MutableState<FragmentState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentView$lambda$3$0(DocumentManager documentManager, final DocumentState documentState, v9 v9Var) {
        v9Var.getClass();
        DocumentListener documentListener = documentManager.getDocumentListener();
        documentListener.getClass();
        x9 x9Var = v9Var.a;
        x9Var.getClass();
        x9Var.d = documentListener;
        AnnotationListener annotationListener = documentManager.getAnnotationListener();
        annotationListener.getClass();
        x9 x9Var2 = v9Var.a;
        x9Var2.getClass();
        x9Var2.e = annotationListener;
        UiListener uiListener = documentManager.getUiListener();
        uiListener.getClass();
        x9 x9Var3 = v9Var.a;
        x9Var3.getClass();
        x9Var3.f = uiListener;
        FormListener formListener = documentManager.getFormListener();
        formListener.getClass();
        x9 x9Var4 = v9Var.a;
        x9Var4.getClass();
        x9Var4.g = formListener;
        documentState.setDocumentConnection(v9Var);
        documentState.setCustomPdfActions$sdk_nutrient(v9Var);
        Function1<? super Boolean, Unit> function1 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentViewKt.DocumentView$lambda$3$0$0$0(documentState, ((Boolean) obj).booleanValue());
            }
        };
        x9 x9Var5 = v9Var.a;
        x9Var5.getClass();
        x9Var5.c = function1;
        Function0<Unit> function0 = new Function0() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DocumentViewKt.DocumentView$lambda$3$0$0$1(documentState);
            }
        };
        x9 x9Var6 = v9Var.a;
        x9Var6.getClass();
        x9Var6.b = function0;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentView$lambda$3$0$0$0(DocumentState documentState, boolean z) {
        documentState.getOnMenuVisibleCallback$sdk_nutrient().invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentView$lambda$3$0$0$1(DocumentState documentState) {
        documentState.getOnDocumentLoadedCallback$sdk_nutrient().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult DocumentView$lambda$4$0(final DocumentState documentState, DisposableEffectScope disposableEffectScope) {
        disposableEffectScope.getClass();
        return new DisposableEffectResult() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$DocumentView$lambda$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                documentState.onDispose$sdk_nutrient();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DocumentView$lambda$5(DocumentState documentState, Modifier modifier, DocumentManager documentManager, int i, int i2, Composer composer, int i3) {
        DocumentView(documentState, modifier, documentManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x010c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0140  */
    /* JADX WARN: Code duplicated, block: B:81:0x0155  */
    /* JADX WARN: Code duplicated, block: B:82:0x0159  */
    /* JADX WARN: Code duplicated, block: B:85:0x0164  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public static final void InstantDocumentView(final DocumentState documentState, Modifier modifier, InstantDocumentManager instantDocumentManager, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final InstantDocumentManager instantDocumentManager2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        int i4;
        boolean zChangedInstance3;
        final InstantDocumentManager defaultInstantDocumentManager = instantDocumentManager;
        documentState.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-56647653);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(documentState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i4 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance3 = composerStartRestartGroup.changed(defaultInstantDocumentManager);
                    } else {
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(defaultInstantDocumentManager);
                    }
                    if (zChangedInstance3) {
                        i4 = 256;
                    } else {
                        i4 = 128;
                    }
                }
                i3 |= i4;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        defaultInstantDocumentManager = DocumentManagerKt.getDefaultInstantDocumentManager(null, null, null, null, null, composerStartRestartGroup, 0, 31);
                        i3 &= -897;
                    }
                    modifier2 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-56647653, i3, -1, "com.pspdfkit.jetpack.compose.views.InstantDocumentView (DocumentView.kt:96)");
                }
                zChanged = composerStartRestartGroup.changed(documentState.getState$sdk_nutrient());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FragmentState(documentState.getState$sdk_nutrient()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                FragmentState fragmentStateInstantDocumentView$lambda$1 = InstantDocumentView$lambda$1((MutableState) objRememberedValue);
                Bundle arguments$sdk_nutrient = documentState.getArguments$sdk_nutrient();
                zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changedInstance(defaultInstantDocumentManager)) || (i3 & 384) == 256);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DocumentViewKt.InstantDocumentView$lambda$2$0(defaultInstantDocumentManager, documentState, (u9) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.startReplaceableGroup(1765406104);
                AndroidFragmentKt.AndroidFragment(u9.class, modifier2, fragmentStateInstantDocumentView$lambda$1, arguments$sdk_nutrient, (Function1) objRememberedValue2, composerStartRestartGroup, (((i3 >> 3) & 14) << 3) & 112, 0);
                composerStartRestartGroup.endReplaceableGroup();
                zChangedInstance2 = composerStartRestartGroup.changedInstance(documentState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DocumentViewKt.InstantDocumentView$lambda$3$0(documentState, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.DisposableEffect(documentState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, i3 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            instantDocumentManager2 = defaultInstantDocumentManager;
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DocumentViewKt.InstantDocumentView$lambda$4(documentState, modifier3, instantDocumentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i4 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance3 = composerStartRestartGroup.changed(defaultInstantDocumentManager);
                } else {
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(defaultInstantDocumentManager);
                }
                if (zChangedInstance3) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
            }
            i3 |= i4;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    defaultInstantDocumentManager = DocumentManagerKt.getDefaultInstantDocumentManager(null, null, null, null, null, composerStartRestartGroup, 0, 31);
                    i3 &= -897;
                }
                modifier2 = modifier4;
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    defaultInstantDocumentManager = DocumentManagerKt.getDefaultInstantDocumentManager(null, null, null, null, null, composerStartRestartGroup, 0, 31);
                    i3 &= -897;
                }
                modifier2 = modifier4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-56647653, i3, -1, "com.pspdfkit.jetpack.compose.views.InstantDocumentView (DocumentView.kt:96)");
            }
            zChanged = composerStartRestartGroup.changed(documentState.getState$sdk_nutrient());
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FragmentState(documentState.getState$sdk_nutrient()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FragmentState(documentState.getState$sdk_nutrient()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            FragmentState fragmentStateInstantDocumentView$lambda$2 = InstantDocumentView$lambda$1((MutableState) objRememberedValue);
            Bundle arguments$sdk_nutrient2 = documentState.getArguments$sdk_nutrient();
            zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changedInstance(defaultInstantDocumentManager)) || (i3 & 384) == 256);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.InstantDocumentView$lambda$2$0(defaultInstantDocumentManager, documentState, (u9) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.InstantDocumentView$lambda$2$0(defaultInstantDocumentManager, documentState, (u9) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.startReplaceableGroup(1765406104);
            AndroidFragmentKt.AndroidFragment(u9.class, modifier2, fragmentStateInstantDocumentView$lambda$2, arguments$sdk_nutrient2, (Function1) objRememberedValue2, composerStartRestartGroup, (((i3 >> 3) & 14) << 3) & 112, 0);
            composerStartRestartGroup.endReplaceableGroup();
            zChangedInstance2 = composerStartRestartGroup.changedInstance(documentState);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.InstantDocumentView$lambda$3$0(documentState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.InstantDocumentView$lambda$3$0(documentState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.DisposableEffect(documentState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        instantDocumentManager2 = defaultInstantDocumentManager;
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentViewKt.InstantDocumentView$lambda$4(documentState, modifier3, instantDocumentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FragmentState InstantDocumentView$lambda$1(MutableState<FragmentState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InstantDocumentView$lambda$2$0(InstantDocumentManager instantDocumentManager, final DocumentState documentState, u9 u9Var) {
        u9Var.getClass();
        DocumentListener documentListener = instantDocumentManager.getDocumentListener();
        u9Var.getClass();
        documentListener.getClass();
        x9 x9Var = u9Var.a;
        x9Var.getClass();
        x9Var.d = documentListener;
        AnnotationListener annotationListener = instantDocumentManager.getAnnotationListener();
        annotationListener.getClass();
        x9 x9Var2 = u9Var.a;
        x9Var2.getClass();
        x9Var2.e = annotationListener;
        UiListener uiListener = instantDocumentManager.getUiListener();
        uiListener.getClass();
        x9 x9Var3 = u9Var.a;
        x9Var3.getClass();
        x9Var3.f = uiListener;
        FormListener formListener = instantDocumentManager.getFormListener();
        formListener.getClass();
        x9 x9Var4 = u9Var.a;
        x9Var4.getClass();
        x9Var4.g = formListener;
        InstantDocumentListener instantListener = instantDocumentManager.getInstantListener();
        instantListener.getClass();
        u9Var.b = instantListener;
        documentState.setDocumentConnection(u9Var);
        documentState.setCustomPdfActions$sdk_nutrient(u9Var);
        Function1<? super Boolean, Unit> function1 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentViewKt.InstantDocumentView$lambda$2$0$0$0(documentState, ((Boolean) obj).booleanValue());
            }
        };
        x9 x9Var5 = u9Var.a;
        x9Var5.getClass();
        x9Var5.c = function1;
        Function0<Unit> function0 = new Function0() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DocumentViewKt.InstantDocumentView$lambda$2$0$0$1(documentState);
            }
        };
        x9 x9Var6 = u9Var.a;
        x9Var6.getClass();
        x9Var6.b = function0;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InstantDocumentView$lambda$2$0$0$0(DocumentState documentState, boolean z) {
        documentState.getOnMenuVisibleCallback$sdk_nutrient().invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InstantDocumentView$lambda$2$0$0$1(DocumentState documentState) {
        documentState.getOnDocumentLoadedCallback$sdk_nutrient().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult InstantDocumentView$lambda$3$0(final DocumentState documentState, DisposableEffectScope disposableEffectScope) {
        disposableEffectScope.getClass();
        return new DisposableEffectResult() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$InstantDocumentView$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                documentState.onDispose$sdk_nutrient();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InstantDocumentView$lambda$4(DocumentState documentState, Modifier modifier, InstantDocumentManager instantDocumentManager, int i, int i2, Composer composer, int i3) {
        InstantDocumentView(documentState, modifier, instantDocumentManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x010a  */
    /* JADX WARN: Code duplicated, block: B:79:0x0140  */
    /* JADX WARN: Code duplicated, block: B:82:0x0155  */
    /* JADX WARN: Code duplicated, block: B:83:0x0159  */
    /* JADX WARN: Code duplicated, block: B:86:0x0165  */
    /* JADX WARN: Code duplicated, block: B:88:? A[RETURN, SYNTHETIC] */
    public static final void DocumentView(final DocumentState documentState, Modifier modifier, DocumentManager documentManager, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final DocumentManager documentManager2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Composer composer3;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        int i4;
        boolean zChangedInstance3;
        final DocumentManager defaultDocumentManager = documentManager;
        documentState.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-586720823);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(documentState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) != 0) {
                    i4 = 128;
                } else {
                    if ((i & 512) == 0) {
                        zChangedInstance3 = composerStartRestartGroup.changed(defaultDocumentManager);
                    } else {
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(defaultDocumentManager);
                    }
                    if (zChangedInstance3) {
                        i4 = 256;
                    } else {
                        i4 = 128;
                    }
                }
                i3 |= i4;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    composer3 = composerStartRestartGroup;
                    if ((i2 & 4) != 0) {
                        defaultDocumentManager = DocumentManagerKt.getDefaultDocumentManager(null, null, null, null, composer3, 0, 15);
                        i3 &= -897;
                    }
                    modifier2 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    composer3 = composerStartRestartGroup;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-586720823, i3, -1, "com.pspdfkit.jetpack.compose.views.DocumentView (DocumentView.kt:57)");
                }
                zChanged = composer3.changed(documentState.getState$sdk_nutrient());
                objRememberedValue = composer3.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FragmentState(documentState.getState$sdk_nutrient()), null, 2, null);
                    composer3.updateRememberedValue(objRememberedValue);
                }
                FragmentState fragmentStateDocumentView$lambda$2 = DocumentView$lambda$2((MutableState) objRememberedValue);
                Bundle arguments$sdk_nutrient = documentState.getArguments$sdk_nutrient();
                zChangedInstance = composer3.changedInstance(documentState) | ((((i3 & 896) ^ 384) <= 256 && composer3.changedInstance(defaultDocumentManager)) || (i3 & 384) == 256);
                objRememberedValue2 = composer3.rememberedValue();
                if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DocumentViewKt.DocumentView$lambda$3$0(defaultDocumentManager, documentState, (v9) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                composer3.startReplaceableGroup(1765406104);
                Composer composer4 = composer3;
                AndroidFragmentKt.AndroidFragment(v9.class, modifier2, fragmentStateDocumentView$lambda$2, arguments$sdk_nutrient, (Function1) objRememberedValue2, composer4, (((i3 >> 3) & 14) << 3) & 112, 0);
                composer2 = composer4;
                composer2.endReplaceableGroup();
                zChangedInstance2 = composer2.changedInstance(documentState);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DocumentViewKt.DocumentView$lambda$4$0(documentState, (DisposableEffectScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                EffectsKt.DisposableEffect(documentState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, i3 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            }
            documentManager2 = defaultDocumentManager;
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DocumentViewKt.DocumentView$lambda$5(documentState, modifier3, documentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) != 0) {
                i4 = 128;
            } else {
                if ((i & 512) == 0) {
                    zChangedInstance3 = composerStartRestartGroup.changed(defaultDocumentManager);
                } else {
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(defaultDocumentManager);
                }
                if (zChangedInstance3) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
            }
            i3 |= i4;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                composer3 = composerStartRestartGroup;
                if ((i2 & 4) != 0) {
                    defaultDocumentManager = DocumentManagerKt.getDefaultDocumentManager(null, null, null, null, composer3, 0, 15);
                    i3 &= -897;
                }
                modifier2 = modifier4;
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                composer3 = composerStartRestartGroup;
                if ((i2 & 4) != 0) {
                    defaultDocumentManager = DocumentManagerKt.getDefaultDocumentManager(null, null, null, null, composer3, 0, 15);
                    i3 &= -897;
                }
                modifier2 = modifier4;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-586720823, i3, -1, "com.pspdfkit.jetpack.compose.views.DocumentView (DocumentView.kt:57)");
            }
            zChanged = composer3.changed(documentState.getState$sdk_nutrient());
            objRememberedValue = composer3.rememberedValue();
            if (!zChanged) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FragmentState(documentState.getState$sdk_nutrient()), null, 2, null);
                composer3.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FragmentState(documentState.getState$sdk_nutrient()), null, 2, null);
                composer3.updateRememberedValue(objRememberedValue);
            }
            FragmentState fragmentStateDocumentView$lambda$3 = DocumentView$lambda$2((MutableState) objRememberedValue);
            Bundle arguments$sdk_nutrient2 = documentState.getArguments$sdk_nutrient();
            zChangedInstance = composer3.changedInstance(documentState) | ((((i3 & 896) ^ 384) <= 256 && composer3.changedInstance(defaultDocumentManager)) || (i3 & 384) == 256);
            objRememberedValue2 = composer3.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.DocumentView$lambda$3$0(defaultDocumentManager, documentState, (v9) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.DocumentView$lambda$3$0(defaultDocumentManager, documentState, (v9) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue2);
            }
            composer3.startReplaceableGroup(1765406104);
            Composer composer5 = composer3;
            AndroidFragmentKt.AndroidFragment(v9.class, modifier2, fragmentStateDocumentView$lambda$3, arguments$sdk_nutrient2, (Function1) objRememberedValue2, composer5, (((i3 >> 3) & 14) << 3) & 112, 0);
            composer2 = composer5;
            composer2.endReplaceableGroup();
            zChangedInstance2 = composer2.changedInstance(documentState);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.DocumentView$lambda$4$0(documentState, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DocumentViewKt.DocumentView$lambda$4$0(documentState, (DisposableEffectScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.DisposableEffect(documentState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer2, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        documentManager2 = defaultDocumentManager;
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.DocumentViewKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DocumentViewKt.DocumentView$lambda$5(documentState, modifier3, documentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

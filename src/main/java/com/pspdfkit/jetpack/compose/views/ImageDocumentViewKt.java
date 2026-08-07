package com.pspdfkit.jetpack.compose.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.compose.AndroidFragmentKt;
import androidx.fragment.compose.FragmentState;
import androidx.fragment.compose.FragmentStateKt;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.ImageDocumentLoader;
import com.pspdfkit.internal.v9;
import com.pspdfkit.internal.x9;
import com.pspdfkit.jetpack.compose.interactors.AnnotationListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentListener;
import com.pspdfkit.jetpack.compose.interactors.DocumentManager;
import com.pspdfkit.jetpack.compose.interactors.DocumentManagerKt;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.jetpack.compose.interactors.DocumentStateKt;
import com.pspdfkit.jetpack.compose.interactors.UiListener;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"ImageDocumentView", "", "imageUri", "Landroid/net/Uri;", "modifier", "Landroidx/compose/ui/Modifier;", "documentManager", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;", "(Landroid/net/Uri;Landroidx/compose/ui/Modifier;Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;Landroidx/compose/runtime/Composer;II)V", "documentState", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "(Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;Landroidx/compose/ui/Modifier;Lcom/pspdfkit/jetpack/compose/interactors/DocumentManager;Landroidx/compose/runtime/Composer;II)V", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ImageDocumentViewKt {
    /* JADX WARN: Code duplicated, block: B:30:0x004f  */
    public static final void ImageDocumentView(final Uri uri, Modifier modifier, DocumentManager documentManager, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        final Modifier modifier2;
        final DocumentManager documentManager2;
        Composer composer3;
        Modifier modifier3;
        DocumentManager defaultDocumentManager;
        int i4;
        uri.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1947739093);
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
                ComposerKt.traceEventStart(1947739093, i3, -1, "com.pspdfkit.jetpack.compose.views.ImageDocumentView (ImageDocumentView.kt:33)");
            }
            Composer composer4 = composer3;
            ImageDocumentView(DocumentStateKt.rememberImageDocumentState(uri, ImageDocumentLoader.getDefaultImageDocumentActivityConfiguration(new PdfActivityConfiguration.Builder((Context) composer3.consume(AndroidCompositionLocals_androidKt.getLocalContext())).build()), composer3, i3 & 14, 0), modifier3, defaultDocumentManager, composer4, i3 & 1008, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageDocumentViewKt.ImageDocumentView$lambda$0(uri, modifier2, documentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageDocumentView$lambda$0(Uri uri, Modifier modifier, DocumentManager documentManager, int i, int i2, Composer composer, int i3) {
        ImageDocumentView(uri, modifier, documentManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageDocumentView$lambda$1$0(DocumentManager documentManager, final DocumentState documentState, v9 v9Var) {
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
        documentState.setDocumentConnection(v9Var);
        documentState.setCustomPdfActions$sdk_nutrient(v9Var);
        Function1<? super Boolean, Unit> function1 = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageDocumentViewKt.ImageDocumentView$lambda$1$0$0$0(documentState, ((Boolean) obj).booleanValue());
            }
        };
        x9 x9Var4 = v9Var.a;
        x9Var4.getClass();
        x9Var4.c = function1;
        Function0<Unit> function0 = new Function0() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageDocumentViewKt.ImageDocumentView$lambda$1$0$0$1(documentState);
            }
        };
        x9 x9Var5 = v9Var.a;
        x9Var5.getClass();
        x9Var5.b = function0;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageDocumentView$lambda$1$0$0$0(DocumentState documentState, boolean z) {
        documentState.getOnMenuVisibleCallback$sdk_nutrient().invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageDocumentView$lambda$1$0$0$1(DocumentState documentState) {
        documentState.getOnDocumentLoadedCallback$sdk_nutrient().invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageDocumentView$lambda$2(DocumentState documentState, Modifier modifier, DocumentManager documentManager, int i, int i2, Composer composer, int i3) {
        ImageDocumentView(documentState, modifier, documentManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    /* JADX WARN: Code duplicated, block: B:73:0x010b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0117  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    public static final void ImageDocumentView(final DocumentState documentState, Modifier modifier, DocumentManager documentManager, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final DocumentManager documentManager2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Composer composer3;
        boolean zChangedInstance;
        Object objRememberedValue;
        int i4;
        boolean zChangedInstance2;
        final DocumentManager defaultDocumentManager = documentManager;
        documentState.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1388906997);
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
                        zChangedInstance2 = composerStartRestartGroup.changed(defaultDocumentManager);
                    } else {
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(defaultDocumentManager);
                    }
                    if (zChangedInstance2) {
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
                    ComposerKt.traceEventStart(-1388906997, i3, -1, "com.pspdfkit.jetpack.compose.views.ImageDocumentView (ImageDocumentView.kt:58)");
                }
                FragmentState fragmentStateRememberFragmentState = FragmentStateKt.rememberFragmentState(composer3, 0);
                Bundle arguments$sdk_nutrient = documentState.getArguments$sdk_nutrient();
                zChangedInstance = composer3.changedInstance(documentState) | ((((i3 & 896) ^ 384) <= 256 && composer3.changedInstance(defaultDocumentManager)) || (i3 & 384) == 256);
                objRememberedValue = composer3.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ImageDocumentViewKt.ImageDocumentView$lambda$1$0(defaultDocumentManager, documentState, (v9) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                composer3.startReplaceableGroup(1765406104);
                Composer composer4 = composer3;
                AndroidFragmentKt.AndroidFragment(v9.class, modifier2, fragmentStateRememberFragmentState, arguments$sdk_nutrient, (Function1) objRememberedValue, composer4, (((i3 >> 3) & 14) << 3) & 112, 0);
                composer2 = composer4;
                composer2.endReplaceableGroup();
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ImageDocumentViewKt.ImageDocumentView$lambda$2(documentState, modifier3, documentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    zChangedInstance2 = composerStartRestartGroup.changed(defaultDocumentManager);
                } else {
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(defaultDocumentManager);
                }
                if (zChangedInstance2) {
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
                ComposerKt.traceEventStart(-1388906997, i3, -1, "com.pspdfkit.jetpack.compose.views.ImageDocumentView (ImageDocumentView.kt:58)");
            }
            FragmentState fragmentStateRememberFragmentState2 = FragmentStateKt.rememberFragmentState(composer3, 0);
            Bundle arguments$sdk_nutrient2 = documentState.getArguments$sdk_nutrient();
            zChangedInstance = composer3.changedInstance(documentState) | ((((i3 & 896) ^ 384) <= 256 && composer3.changedInstance(defaultDocumentManager)) || (i3 & 384) == 256);
            objRememberedValue = composer3.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ImageDocumentViewKt.ImageDocumentView$lambda$1$0(defaultDocumentManager, documentState, (v9) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ImageDocumentViewKt.ImageDocumentView$lambda$1$0(defaultDocumentManager, documentState, (v9) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            composer3.startReplaceableGroup(1765406104);
            Composer composer5 = composer3;
            AndroidFragmentKt.AndroidFragment(v9.class, modifier2, fragmentStateRememberFragmentState2, arguments$sdk_nutrient2, (Function1) objRememberedValue, composer5, (((i3 >> 3) & 14) << 3) & 112, 0);
            composer2 = composer5;
            composer2.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.views.ImageDocumentViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ImageDocumentViewKt.ImageDocumentView$lambda$2(documentState, modifier3, documentManager2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

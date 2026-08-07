package com.box.android.preview.integration.nutrient;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.core.os.BundleKt;
import androidx.fragment.compose.AndroidFragmentKt;
import androidx.fragment.compose.FragmentStateKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.ImmutableWrapper;
import com.box.android.base.compose.ImmutableWrapperKt;
import com.box.android.base.compose.OrientationAwareKt;
import com.box.android.base.presentation.views.TouchInterceptorViewGroup;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.annotations.AnnotationUtils;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.ui.compose.AnnotationsOverlayKt;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.projection.ViewProjection;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NutrientPdfView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u001aÌ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\u0019\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u001a\u0010\u0017\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u001b0\u00190\u00182\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00190\u00182\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010 ¨\u0006!²\u0006\f\u0010\"\u001a\u0004\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u008e\u0002²\u0006\u0012\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&X\u008a\u008e\u0002"}, d2 = {"NutrientPdfView", "", "config", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "uri", "Landroid/net/Uri;", "itemId", "Lcom/box/android/domain/models/ItemId;", "pdfFragmentBuilder", "Lcom/box/android/preview/integration/nutrient/NutrientPdfFragmentBuilder;", "documentListener", "Lcom/pspdfkit/listeners/DocumentListener;", "boxAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "createAnnotationsManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "additionalInit", "Lkotlin/Function2;", "Lcom/box/android/base/presentation/views/TouchInterceptorViewGroup;", "Lcom/pspdfkit/ui/PdfUiFragment;", "additionalUpdates", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getAnnotationStore", "Lkotlin/Function0;", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$State;", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "getCreateAnnotationStore", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "onPasswordViewVisible", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroid/net/Uri;Lcom/box/android/domain/models/ItemId;Lcom/box/android/preview/integration/nutrient/NutrientPdfFragmentBuilder;Lcom/pspdfkit/listeners/DocumentListener;Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "preview_generalProdRelease", "annotationsState", "annotationsPopupViewLocation", "Landroid/graphics/PointF;", "pdfUiFragmentWrapper", "Lcom/box/android/base/compose/ImmutableWrapper;", "Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientPdfView$lambda$10(PdfActivityConfiguration pdfActivityConfiguration, Uri uri, ItemId itemId, NutrientPdfFragmentBuilder nutrientPdfFragmentBuilder, DocumentListener documentListener, BoxPdfAnnotationManager boxPdfAnnotationManager, CreateAnnotationsManager createAnnotationsManager, Function2 function2, Function1 function1, Function0 function0, Function0 function3, Function0 function4, int i, int i2, int i3, Composer composer, int i4) {
        NutrientPdfView(pdfActivityConfiguration, uri, itemId, nutrientPdfFragmentBuilder, documentListener, boxPdfAnnotationManager, createAnnotationsManager, function2, function1, function0, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0147  */
    /* JADX WARN: Code duplicated, block: B:108:0x0160  */
    /* JADX WARN: Code duplicated, block: B:111:0x0169  */
    /* JADX WARN: Code duplicated, block: B:113:0x016c  */
    /* JADX WARN: Code duplicated, block: B:115:0x016f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0171  */
    /* JADX WARN: Code duplicated, block: B:119:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:130:0x0200  */
    /* JADX WARN: Code duplicated, block: B:133:0x0245  */
    /* JADX WARN: Code duplicated, block: B:134:0x0254  */
    /* JADX WARN: Code duplicated, block: B:136:0x0268  */
    /* JADX WARN: Code duplicated, block: B:137:0x0276  */
    /* JADX WARN: Code duplicated, block: B:139:0x028f  */
    /* JADX WARN: Code duplicated, block: B:140:0x0291  */
    /* JADX WARN: Code duplicated, block: B:147:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:152:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:154:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:157:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0093  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:36:0x009c  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:74:0x0105  */
    /* JADX WARN: Code duplicated, block: B:75:0x0108  */
    /* JADX WARN: Code duplicated, block: B:79:0x0112  */
    /* JADX WARN: Code duplicated, block: B:81:0x0118  */
    /* JADX WARN: Code duplicated, block: B:82:0x011b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0123  */
    /* JADX WARN: Code duplicated, block: B:88:0x0129  */
    /* JADX WARN: Code duplicated, block: B:89:0x012c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0131  */
    /* JADX WARN: Code duplicated, block: B:94:0x0137  */
    /* JADX WARN: Code duplicated, block: B:95:0x013a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0140  */
    public static final void NutrientPdfView(final PdfActivityConfiguration config, final Uri uri, ItemId itemId, final NutrientPdfFragmentBuilder pdfFragmentBuilder, final DocumentListener documentListener, final BoxPdfAnnotationManager boxAnnotationManager, final CreateAnnotationsManager createAnnotationsManager, final Function2<? super TouchInterceptorViewGroup, ? super PdfUiFragment, Unit> function2, final Function1<? super PdfUiFragment, Unit> function1, final Function0<Store<AnnotationsReducer.State, AnnotationsReducer.Action>> getAnnotationStore, final Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore, Function0<Unit> function0, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        ItemId itemId2;
        int i5;
        int i6;
        int i7;
        boolean z;
        Composer composer2;
        final Function0<Unit> function3;
        final ItemId itemId3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> function4;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue;
        MutableState mutableState;
        Object objRememberedValue2;
        boolean zChangedInstance;
        Object objRememberedValue3;
        int i8;
        final PdfUIFragmentWrapper value;
        View view;
        boolean z2;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        final MutableState mutableState2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean zChangedInstance3;
        int i16;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(pdfFragmentBuilder, "pdfFragmentBuilder");
        Intrinsics.checkNotNullParameter(boxAnnotationManager, "boxAnnotationManager");
        Intrinsics.checkNotNullParameter(createAnnotationsManager, "createAnnotationsManager");
        Intrinsics.checkNotNullParameter(getAnnotationStore, "getAnnotationStore");
        Intrinsics.checkNotNullParameter(getCreateAnnotationStore, "getCreateAnnotationStore");
        Composer composerStartRestartGroup = composer.startRestartGroup(641632697);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NutrientPdfView)N(config,uri,itemId,pdfFragmentBuilder,documentListener,boxAnnotationManager,createAnnotationsManager,additionalInit,additionalUpdates,getAnnotationStore,getCreateAnnotationStore,onPasswordViewVisible)48@2476L29,50@2556L49,54@2680L66,59@2800L158,63@2965L1235,58@2752L1448,112@5009L120:NutrientPdfView.kt#4vuy7e");
        if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? composerStartRestartGroup.changed(config) : composerStartRestartGroup.changedInstance(config) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(uri) ? 32 : 16;
        }
        int i17 = i3 & 4;
        if (i17 == 0) {
            if ((i & 384) == 0) {
                itemId2 = itemId;
                i4 |= composerStartRestartGroup.changedInstance(itemId2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i & 4096) == 0) {
                    zChangedInstance3 = composerStartRestartGroup.changed(pdfFragmentBuilder);
                } else {
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(pdfFragmentBuilder);
                }
                if (zChangedInstance3) {
                    i16 = 2048;
                } else {
                    i16 = 1024;
                }
                i4 |= i16;
            }
            if ((i & 24576) != 0) {
                if (composerStartRestartGroup.changedInstance(documentListener)) {
                    i15 = 16384;
                } else {
                    i15 = 8192;
                }
                i4 |= i15;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(boxAnnotationManager)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i4 |= i14;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(createAnnotationsManager)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i4 |= i13;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i4 |= i12;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i4 |= i11;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(getAnnotationStore)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(getCreateAnnotationStore)) {
                    i9 = 4;
                } else {
                    i9 = 2;
                }
                i5 = i2 | i9;
            } else {
                i5 = i2;
            }
            i6 = i3 & 2048;
            if (i6 != 0) {
                i5 |= 48;
            } else if ((i2 & 48) == 0) {
                i5 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
            }
            i7 = i5;
            if ((i4 & 306783379) == 306783378 || (i7 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function3 = function0;
                itemId3 = itemId2;
            } else {
                if (i17 != 0) {
                    itemId2 = null;
                }
                if (i6 != 0) {
                    function4 = null;
                } else {
                    function4 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(641632697, i4, i7, "com.box.android.preview.integration.nutrient.NutrientPdfView (NutrientPdfView.kt:47)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(getAnnotationStore.invoke().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1866242742, "CC(remember):NutrientPdfView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PointF(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1866238757, "CC(remember):NutrientPdfView.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImmutableWrapperKt.ofNull(ImmutableWrapper.INSTANCE), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1866234825, "CC(remember):NutrientPdfView.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(createAnnotationsManager);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NutrientPdfViewKt.NutrientPdfView$lambda$7$0(createAnnotationsManager, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i8 = i4;
                itemId3 = itemId2;
                composer2 = composerStartRestartGroup;
                OrientationAwareKt.OrientationAware((Function1) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(-1422099217, true, new Function3() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NutrientPdfViewKt.NutrientPdfView$lambda$8(itemId3, pdfFragmentBuilder, uri, getCreateAnnotationStore, boxAnnotationManager, createAnnotationsManager, function2, function4, documentListener, mutableState3, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 48, 0);
                value = NutrientPdfView$lambda$5(mutableState3).getValue();
                if (value == null) {
                    composer2.startReplaceGroup(-2017182533);
                    composer2.endReplaceGroup();
                    mutableState2 = mutableState;
                } else {
                    composer2.startReplaceGroup(-2017182532);
                    ComposerKt.sourceInformation(composer2, "");
                    value.setConfiguration(config);
                    view = value.getView();
                    if (view == null) {
                        composer2.startReplaceGroup(-98798721);
                        composer2.endReplaceGroup();
                        mutableState2 = mutableState;
                    } else {
                        composer2.startReplaceGroup(1659380930);
                        ComposerKt.sourceInformation(composer2, "95@4405L592");
                        ComposerKt.sourceInformationMarkerStart(composer2, 1659381085, "CC(remember):NutrientPdfView.kt#9igjgp");
                        if ((i8 & 234881024) == 67108864) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChangedInstance2 = composer2.changedInstance(value) | z2 | composer2.changed(stateCollectAsStateWithLifecycle);
                        objRememberedValue4 = composer2.rememberedValue();
                        if (!zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            mutableState2 = mutableState;
                            objRememberedValue4 = new Runnable() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda3
                                @Override // java.lang.Runnable
                                public final void run() {
                                    NutrientPdfViewKt.NutrientPdfView$lambda$9$0$0(function1, value, stateCollectAsStateWithLifecycle, mutableState2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        } else {
                            mutableState2 = mutableState;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        boolean zPost = view.post((Runnable) objRememberedValue4);
                        composer2.endReplaceGroup();
                        Boolean.valueOf(zPost);
                    }
                    composer2.endReplaceGroup();
                }
                AnnotationsOverlayKt.AnnotationsOverlay(getAnnotationStore.invoke(), NutrientPdfView$lambda$2(mutableState2), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NutrientPdfViewKt.NutrientPdfView$lambda$10(config, uri, itemId3, pdfFragmentBuilder, documentListener, boxAnnotationManager, createAnnotationsManager, function2, function1, getAnnotationStore, getCreateAnnotationStore, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        itemId2 = itemId;
        if ((i & 3072) == 0) {
            if ((i & 4096) == 0) {
                zChangedInstance3 = composerStartRestartGroup.changed(pdfFragmentBuilder);
            } else {
                zChangedInstance3 = composerStartRestartGroup.changedInstance(pdfFragmentBuilder);
            }
            if (zChangedInstance3) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i4 |= i16;
        }
        if ((i & 24576) != 0) {
            if (composerStartRestartGroup.changedInstance(documentListener)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i4 |= i15;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(boxAnnotationManager)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i4 |= i14;
        }
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(createAnnotationsManager)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i4 |= i13;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i4 |= i12;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i4 |= i11;
        }
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(getAnnotationStore)) {
                i10 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i10 = 268435456;
            }
            i4 |= i10;
        }
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(getCreateAnnotationStore)) {
                i9 = 4;
            } else {
                i9 = 2;
            }
            i5 = i2 | i9;
        } else {
            i5 = i2;
        }
        i6 = i3 & 2048;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        i7 = i5;
        if ((i4 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function3 = function0;
            itemId3 = itemId2;
        } else {
            if (i17 != 0) {
                itemId2 = null;
            }
            if (i6 != 0) {
                function4 = null;
            } else {
                function4 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(641632697, i4, i7, "com.box.android.preview.integration.nutrient.NutrientPdfView (NutrientPdfView.kt:47)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(getAnnotationStore.invoke().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1866242742, "CC(remember):NutrientPdfView.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PointF(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1866238757, "CC(remember):NutrientPdfView.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImmutableWrapperKt.ofNull(ImmutableWrapper.INSTANCE), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1866234825, "CC(remember):NutrientPdfView.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(createAnnotationsManager);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NutrientPdfViewKt.NutrientPdfView$lambda$7$0(createAnnotationsManager, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NutrientPdfViewKt.NutrientPdfView$lambda$7$0(createAnnotationsManager, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i8 = i4;
            itemId3 = itemId2;
            composer2 = composerStartRestartGroup;
            OrientationAwareKt.OrientationAware((Function1) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(-1422099217, true, new Function3() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NutrientPdfViewKt.NutrientPdfView$lambda$8(itemId3, pdfFragmentBuilder, uri, getCreateAnnotationStore, boxAnnotationManager, createAnnotationsManager, function2, function4, documentListener, mutableState4, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 48, 0);
            value = NutrientPdfView$lambda$5(mutableState4).getValue();
            if (value == null) {
                composer2.startReplaceGroup(-2017182533);
                composer2.endReplaceGroup();
                mutableState2 = mutableState;
            } else {
                composer2.startReplaceGroup(-2017182532);
                ComposerKt.sourceInformation(composer2, "");
                value.setConfiguration(config);
                view = value.getView();
                if (view == null) {
                    composer2.startReplaceGroup(-98798721);
                    composer2.endReplaceGroup();
                    mutableState2 = mutableState;
                } else {
                    composer2.startReplaceGroup(1659380930);
                    ComposerKt.sourceInformation(composer2, "95@4405L592");
                    ComposerKt.sourceInformationMarkerStart(composer2, 1659381085, "CC(remember):NutrientPdfView.kt#9igjgp");
                    if ((i8 & 234881024) == 67108864) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance2 = composer2.changedInstance(value) | z2 | composer2.changed(stateCollectAsStateWithLifecycle);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChangedInstance2) {
                        mutableState2 = mutableState;
                        objRememberedValue4 = new Runnable() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                NutrientPdfViewKt.NutrientPdfView$lambda$9$0$0(function1, value, stateCollectAsStateWithLifecycle, mutableState2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        mutableState2 = mutableState;
                        objRememberedValue4 = new Runnable() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda3
                            @Override // java.lang.Runnable
                            public final void run() {
                                NutrientPdfViewKt.NutrientPdfView$lambda$9$0$0(function1, value, stateCollectAsStateWithLifecycle, mutableState2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    boolean zPost2 = view.post((Runnable) objRememberedValue4);
                    composer2.endReplaceGroup();
                    Boolean.valueOf(zPost2);
                }
                composer2.endReplaceGroup();
            }
            AnnotationsOverlayKt.AnnotationsOverlay(getAnnotationStore.invoke(), NutrientPdfView$lambda$2(mutableState2), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NutrientPdfViewKt.NutrientPdfView$lambda$10(config, uri, itemId3, pdfFragmentBuilder, documentListener, boxAnnotationManager, createAnnotationsManager, function2, function1, getAnnotationStore, getCreateAnnotationStore, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final PointF NutrientPdfView$lambda$2(MutableState<PointF> mutableState) {
        return mutableState.getValue();
    }

    private static final ImmutableWrapper<PdfUIFragmentWrapper> NutrientPdfView$lambda$5(MutableState<ImmutableWrapper<PdfUIFragmentWrapper>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientPdfView$lambda$7$0(CreateAnnotationsManager createAnnotationsManager, boolean z) {
        createAnnotationsManager.onAnnotationChanged(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientPdfView$lambda$8(ItemId itemId, NutrientPdfFragmentBuilder nutrientPdfFragmentBuilder, Uri uri, final Function0 function0, final BoxPdfAnnotationManager boxPdfAnnotationManager, final CreateAnnotationsManager createAnnotationsManager, final Function2 function2, final Function0 function1, final DocumentListener documentListener, final MutableState mutableState, boolean z, Composer composer, int i) {
        String str;
        String string;
        ComposerKt.sourceInformation(composer, "CN(it)70@3271L923,64@2975L1219:NutrientPdfView.kt#4vuy7e");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1422099217, i, -1, "com.box.android.preview.integration.nutrient.NutrientPdfView.<anonymous> (NutrientPdfView.kt:64)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            if (itemId == null || (string = itemId.toString()) == null || (str = ":" + string) == null) {
                str = "";
            }
            Modifier modifierTestTag = TestTagKt.testTag(companion, "Preview:NutrientPdfView" + str);
            Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to(NutrientPdfFragmentWrapper.BUILDER_ARG, nutrientPdfFragmentBuilder), TuplesKt.to(NutrientPdfFragmentWrapper.URI_ARG, uri));
            ComposerKt.sourceInformationMarkerStart(composer, -837736694, "CC(remember):NutrientPdfView.kt#9igjgp");
            boolean zChanged = composer.changed(function0) | composer.changedInstance(boxPdfAnnotationManager) | composer.changedInstance(createAnnotationsManager) | composer.changed(function2) | composer.changed(function1) | composer.changedInstance(documentListener);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function3 = new Function1() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NutrientPdfViewKt.NutrientPdfView$lambda$8$1$0(function1, documentListener, function0, boxPdfAnnotationManager, createAnnotationsManager, function2, mutableState, (NutrientPdfFragmentWrapper) obj);
                    }
                };
                composer.updateRememberedValue(function3);
                objRememberedValue = function3;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.startReplaceableGroup(1765406104);
            ComposerKt.sourceInformation(composer, "CC(AndroidFragment)P(2,1)54@2199L23,58@2311L84:AndroidFragment.kt#dnbm1l");
            AndroidFragmentKt.AndroidFragment(NutrientPdfFragmentWrapper.class, modifierTestTag, FragmentStateKt.rememberFragmentState(composer, 0), bundleBundleOf, (Function1) objRememberedValue, composer, 0, 0);
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientPdfView$lambda$8$1$0(Function0 function0, DocumentListener documentListener, final Function0 function1, final BoxPdfAnnotationManager boxPdfAnnotationManager, final CreateAnnotationsManager createAnnotationsManager, final Function2 function2, final MutableState mutableState, final NutrientPdfFragmentWrapper fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        View view = fragment.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.box.android.base.presentation.views.TouchInterceptorViewGroup");
        final TouchInterceptorViewGroup touchInterceptorViewGroup = (TouchInterceptorViewGroup) view;
        fragment.getPdfUiFragment().setOnDocumentLoaded(new Function1() { // from class: com.box.android.preview.integration.nutrient.NutrientPdfViewKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NutrientPdfViewKt.NutrientPdfView$lambda$8$1$0$0(function1, boxPdfAnnotationManager, createAnnotationsManager, function2, touchInterceptorViewGroup, fragment, mutableState, (PdfUIFragmentWrapper) obj);
            }
        });
        fragment.getPdfUiFragment().setOnPasswordViewVisible(function0);
        if (documentListener != null) {
            fragment.addDocumentListener(documentListener);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutrientPdfView$lambda$8$1$0$0(Function0 function0, BoxPdfAnnotationManager boxPdfAnnotationManager, CreateAnnotationsManager createAnnotationsManager, Function2 function2, TouchInterceptorViewGroup touchInterceptorViewGroup, NutrientPdfFragmentWrapper nutrientPdfFragmentWrapper, MutableState mutableState, PdfUIFragmentWrapper pdfUiFragment) {
        Intrinsics.checkNotNullParameter(pdfUiFragment, "pdfUiFragment");
        new NutrientPdfInitializeHelper(pdfUiFragment, function0, boxPdfAnnotationManager, createAnnotationsManager).initialize();
        if (function2 != null) {
            function2.invoke(touchInterceptorViewGroup, pdfUiFragment);
        }
        mutableState.setValue(new ImmutableWrapper(nutrientPdfFragmentWrapper.getPdfUiFragment()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NutrientPdfView$lambda$9$0$0(Function1 function1, PdfUIFragmentWrapper pdfUIFragmentWrapper, State state, MutableState mutableState) {
        AnnotationsReducer.AnnotationPopupLocation annotationPopUpLocation;
        PdfFragment pdfFragment;
        if (function1 != null) {
            function1.invoke(pdfUIFragmentWrapper);
        }
        AnnotationsReducer.State stateNutrientPdfView$lambda$0 = NutrientPdfView$lambda$0(state);
        PointF pointF = null;
        if (stateNutrientPdfView$lambda$0 != null && (annotationPopUpLocation = stateNutrientPdfView$lambda$0.getAnnotationPopUpLocation()) != null && (pdfFragment = pdfUIFragmentWrapper.getPdfFragment()) != null) {
            pointF = new PointF(annotationPopUpLocation.getPoint());
            Context contextRequireContext = pdfFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int pageIndex = annotationPopUpLocation.getPageIndex();
            ViewProjection viewProjection = pdfFragment.getViewProjection();
            Intrinsics.checkNotNullExpressionValue(viewProjection, "getViewProjection(...)");
            AnnotationUtils.calculateAnnotationContextMenuPosition(contextRequireContext, pointF, pageIndex, viewProjection);
        }
        mutableState.setValue(pointF);
    }

    private static final AnnotationsReducer.State NutrientPdfView$lambda$0(State<AnnotationsReducer.State> state) {
        return state.getValue();
    }
}

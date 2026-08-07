package com.box.android.preview.previewtype.gif;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.view.View;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector3D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.R;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.compose.GlideImageKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: GifPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aC\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a \u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001b\u001a/\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010!H\u0003¢\u0006\u0002\u0010\"\u001a\u0014\u0010#\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001eH\u0002\u001ai\u0010$\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010&2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010(2$\u0010*\u001a \u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00010+H\u0002¢\u0006\u0004\b.\u0010/¨\u00060²\u0006\n\u00101\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"GifPreviewScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "isImmersiveMode", "", "(Lcom/box/android/cpl/Store;ZLandroidx/compose/runtime/Composer;I)V", "GifImage", "uri", "Landroid/net/Uri;", "itemId", "Lcom/box/android/domain/models/ItemId;", "contentDescription", "", "gifListener", "Lcom/box/android/preview/previewtype/gif/BoxGifListener;", "screenSize", "Landroidx/compose/ui/unit/IntSize;", "modifier", "Landroidx/compose/ui/Modifier;", "GifImage-y2J1wZk", "(Landroid/net/Uri;Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/preview/previewtype/gif/BoxGifListener;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "fileDimension", "context", "Landroid/content/Context;", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateGifZoomPositionAsState", "Landroidx/compose/runtime/State;", "Lcom/box/android/preview/previewtype/gif/GifZoomPosition;", ViewProps.POSITION, "finishedListener", "Lkotlin/Function1;", "(Lcom/box/android/preview/previewtype/gif/GifZoomPosition;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "scaleAndTransform", "enableGesturesControl", ViewProps.ON_CLICK, "Lkotlin/Function0;", "onDoubleClick", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "onPinch", "Lkotlin/Function4;", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "enableGesturesControl--HDNwks", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;)Landroidx/compose/ui/Modifier;", "preview_generalProdRelease", "state", "needAnimatePosition", "animatedPosition"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GifPreviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifImage_y2J1wZk$lambda$13(Uri uri, ItemId itemId, String str, BoxGifListener boxGifListener, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m12935GifImagey2J1wZk(uri, itemId, str, boxGifListener, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifPreviewScreen$lambda$4(Store store, boolean z, int i, Composer composer, int i2) {
        GifPreviewScreen(store, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void GifPreviewScreen(final Store<GifPreviewReducer.State, GifPreviewReducer.Action> store, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2101416104);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GifPreviewScreen)N(store,isImmersiveMode)45@2049L29,47@2094L45,50@2162L46,54@2239L7,55@2297L7,68@2626L602,63@2472L756:GifPreviewScreen.kt#uj0qar");
        int i3 = 2;
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2101416104, i2, -1, "com.box.android.preview.previewtype.gif.GifPreviewScreen (GifPreviewScreen.kt:44)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826240763, "CC(remember):GifPreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = Uri.parse(GifPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getUrl());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Uri uri = (Uri) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -826238586, "CC(remember):GifPreviewScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            CoroutineScope coroutineScope = null;
            Object[] objArr = 0;
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new BoxGifListener(store, coroutineScope, i3, objArr == true ? 1 : 0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final BoxGifListener boxGifListener = (BoxGifListener) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            View rootView = ((View) objConsume).getRootView();
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startMovableGroup(-826232748, Integer.valueOf(((Configuration) objConsume2).orientation));
            final long jM9853constructorimpl = IntSize.m9853constructorimpl((((long) rootView.getHeight()) & 4294967295L) | (((long) rootView.getWidth()) << 32));
            composerStartRestartGroup.endMovableGroup();
            BoxWithConstraintsKt.BoxWithConstraints(ClipKt.clipToBounds(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), Alignment.INSTANCE.getCenter(), false, ComposableLambdaKt.rememberComposableLambda(346702914, true, new Function3() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GifPreviewScreenKt.GifPreviewScreen$lambda$3(uri, boxGifListener, z, jM9853constructorimpl, stateCollectAsStateWithLifecycle, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3126, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GifPreviewScreenKt.GifPreviewScreen$lambda$4(store, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifPreviewScreen$lambda$3(Uri uri, BoxGifListener boxGifListener, boolean z, long j, State state, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        long jM9853constructorimpl;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C72@2747L54,69@2636L586:GifPreviewScreen.kt#uj0qar");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(346702914, i2, -1, "com.box.android.preview.previewtype.gif.GifPreviewScreen.<anonymous> (GifPreviewScreen.kt:69)");
            }
            Intrinsics.checkNotNull(uri);
            ItemId itemId = GifPreviewScreen$lambda$0(state).getFileModel().getItemId();
            String strStringResource = StringResources_androidKt.stringResource(R.string.gif_image_preview_description, composer, 0);
            if (z) {
                jM9853constructorimpl = IntSize.m9853constructorimpl((((long) ((int) (j & 4294967295L))) & 4294967295L) | (((long) ((int) (j >> 32))) << 32));
            } else {
                jM9853constructorimpl = IntSize.m9853constructorimpl((((long) Constraints.m9639getMaxHeightimpl(BoxWithConstraints.mo1099getConstraintsmsEJaDk())) & 4294967295L) | (((long) Constraints.m9640getMaxWidthimpl(BoxWithConstraints.mo1099getConstraintsmsEJaDk())) << 32));
            }
            m12935GifImagey2J1wZk(uri, itemId, strStringResource, boxGifListener, jM9853constructorimpl, null, composer, 0, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0242  */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:69:0x0107  */
    /* JADX WARN: Code duplicated, block: B:72:0x0126  */
    /* JADX WARN: Code duplicated, block: B:73:0x0136  */
    /* JADX WARN: Code duplicated, block: B:76:0x0153  */
    /* JADX WARN: Code duplicated, block: B:81:0x0183  */
    /* JADX WARN: Code duplicated, block: B:84:0x01af  */
    /* JADX WARN: Code duplicated, block: B:87:0x01df  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:91:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:95:0x0232  */
    /* JADX WARN: Code duplicated, block: B:97:0x0237  */
    /* JADX INFO: renamed from: GifImage-y2J1wZk, reason: not valid java name */
    private static final void m12935GifImagey2J1wZk(final Uri uri, final ItemId itemId, final String str, final BoxGifListener boxGifListener, final long j, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final BoxGifListener boxGifListener2;
        long j2;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Context context;
        Object objRememberedValue;
        MutableState mutableState;
        Object objRememberedValue2;
        Object objRememberedValue3;
        final MutableState mutableState2;
        Object objRememberedValue4;
        boolean zChangedInstance;
        GifPreviewScreenKt$GifImage$1$1 gifPreviewScreenKt$GifImage$1$1RememberedValue;
        GifPreviewScreenKt$GifImage$2$1 gifPreviewScreenKt$GifImage$2$1RememberedValue;
        Modifier modifierTestTag;
        IntSize intSizeGifImage_y2J1wZk$lambda$1;
        Object obj;
        boolean z2;
        Modifier modifierFillMaxSize$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2103629513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GifImage)N(uri,itemId,contentDescription,gifListener,screenSize:c#ui.unit.IntSize,modifier)99@3503L7,100@3536L55,103@3616L47,106@3695L46,111@3871L31,109@3770L138,114@3934L59,114@3914L79,117@4025L42,117@3998L69,130@4495L1670,121@4073L2092:GifPreviewScreen.kt#uj0qar");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(uri) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(itemId) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            boxGifListener2 = boxGifListener;
            i3 |= composerStartRestartGroup.changedInstance(boxGifListener2) ? 2048 : 1024;
        } else {
            boxGifListener2 = boxGifListener;
        }
        if ((i & 24576) == 0) {
            j2 = j;
            i3 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
        } else {
            j2 = j;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
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
                    ComposerKt.traceEventStart(-2103629513, i3, -1, "com.box.android.preview.previewtype.gif.GifImage (GifPreviewScreen.kt:98)");
                }
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341642190, "CC(remember):GifPreviewScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341644742, "CC(remember):GifPreviewScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new GifZoomPositionState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final GifZoomPositionState gifZoomPositionState = (GifZoomPositionState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341647269, "CC(remember):GifPreviewScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                GifZoomPosition position = gifZoomPositionState.getPosition();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341652886, "CC(remember):GifPreviewScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$7$0(mutableState2, (GifZoomPosition) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final State<GifZoomPosition> stateAnimateGifZoomPositionAsState = animateGifZoomPositionAsState(position, (Function1) objRememberedValue4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341654930, "CC(remember):GifPreviewScreen.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(uri) | composerStartRestartGroup.changedInstance(context);
                gifPreviewScreenKt$GifImage$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || gifPreviewScreenKt$GifImage$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    gifPreviewScreenKt$GifImage$1$1RememberedValue = new GifPreviewScreenKt$GifImage$1$1(uri, context, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(gifPreviewScreenKt$GifImage$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(uri, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) gifPreviewScreenKt$GifImage$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
                IntSize intSizeM9850boximpl = IntSize.m9850boximpl(j2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341657825, "CC(remember):GifPreviewScreen.kt#9igjgp");
                gifPreviewScreenKt$GifImage$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (gifPreviewScreenKt$GifImage$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    gifPreviewScreenKt$GifImage$2$1RememberedValue = new GifPreviewScreenKt$GifImage$2$1(mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(gifPreviewScreenKt$GifImage$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(intSizeM9850boximpl, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) gifPreviewScreenKt$GifImage$2$1RememberedValue, composerStartRestartGroup, (i3 >> 12) & 14);
                modifierTestTag = TestTagKt.testTag(companion, "Preview:GifImage:" + itemId);
                intSizeGifImage_y2J1wZk$lambda$1 = GifImage_y2J1wZk$lambda$1(mutableState);
                if (intSizeGifImage_y2J1wZk$lambda$1 != null) {
                    long jM9862unboximpl = intSizeGifImage_y2J1wZk$lambda$1.m9862unboximpl();
                    obj = null;
                    modifierFillMaxSize$default = AspectRatioKt.aspectRatio$default(modifierTestTag, ((int) (jM9862unboximpl >> 32)) / ((int) (jM9862unboximpl & 4294967295L)), false, 2, null);
                    if (modifierFillMaxSize$default == null) {
                        z2 = true;
                    }
                    Modifier modifier4 = modifierFillMaxSize$default;
                    final long j3 = j2;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1342790433, z2, new Function3() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12(gifZoomPositionState, j3, uri, str, boxGifListener2, mutableState2, stateAnimateGifZoomPositionAsState, (BoxWithConstraintsScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composer2 = composerStartRestartGroup;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier4, null, false, composableLambdaRememberComposableLambda, composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                } else {
                    obj = null;
                }
                z2 = true;
                modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifierTestTag, 0.0f, 1, obj);
                Modifier modifier5 = modifierFillMaxSize$default;
                final long j4 = j2;
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1342790433, z2, new Function3() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12(gifZoomPositionState, j4, uri, str, boxGifListener2, mutableState2, stateAnimateGifZoomPositionAsState, (BoxWithConstraintsScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(modifier5, null, false, composableLambdaRememberComposableLambda2, composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$13(uri, itemId, str, boxGifListener, j, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i3) != 74898) {
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
                ComposerKt.traceEventStart(-2103629513, i3, -1, "com.box.android.preview.previewtype.gif.GifImage (GifPreviewScreen.kt:98)");
            }
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341642190, "CC(remember):GifPreviewScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341644742, "CC(remember):GifPreviewScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new GifZoomPositionState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final GifZoomPositionState gifZoomPositionState2 = (GifZoomPositionState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341647269, "CC(remember):GifPreviewScreen.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            GifZoomPosition position2 = gifZoomPositionState2.getPosition();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341652886, "CC(remember):GifPreviewScreen.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$7$0(mutableState2, (GifZoomPosition) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateAnimateGifZoomPositionAsState2 = animateGifZoomPositionAsState(position2, (Function1) objRememberedValue4, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341654930, "CC(remember):GifPreviewScreen.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(uri) | composerStartRestartGroup.changedInstance(context);
            gifPreviewScreenKt$GifImage$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                gifPreviewScreenKt$GifImage$1$1RememberedValue = new GifPreviewScreenKt$GifImage$1$1(uri, context, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(gifPreviewScreenKt$GifImage$1$1RememberedValue);
            } else {
                gifPreviewScreenKt$GifImage$1$1RememberedValue = new GifPreviewScreenKt$GifImage$1$1(uri, context, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(gifPreviewScreenKt$GifImage$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(uri, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) gifPreviewScreenKt$GifImage$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
            IntSize intSizeM9850boximpl2 = IntSize.m9850boximpl(j2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341657825, "CC(remember):GifPreviewScreen.kt#9igjgp");
            gifPreviewScreenKt$GifImage$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (gifPreviewScreenKt$GifImage$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                gifPreviewScreenKt$GifImage$2$1RememberedValue = new GifPreviewScreenKt$GifImage$2$1(mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(gifPreviewScreenKt$GifImage$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(intSizeM9850boximpl2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) gifPreviewScreenKt$GifImage$2$1RememberedValue, composerStartRestartGroup, (i3 >> 12) & 14);
            modifierTestTag = TestTagKt.testTag(companion, "Preview:GifImage:" + itemId);
            intSizeGifImage_y2J1wZk$lambda$1 = GifImage_y2J1wZk$lambda$1(mutableState);
            if (intSizeGifImage_y2J1wZk$lambda$1 != null) {
                long jM9862unboximpl2 = intSizeGifImage_y2J1wZk$lambda$1.m9862unboximpl();
                obj = null;
                modifierFillMaxSize$default = AspectRatioKt.aspectRatio$default(modifierTestTag, ((int) (jM9862unboximpl2 >> 32)) / ((int) (jM9862unboximpl2 & 4294967295L)), false, 2, null);
                if (modifierFillMaxSize$default == null) {
                    z2 = true;
                }
                Modifier modifier6 = modifierFillMaxSize$default;
                final long j5 = j2;
                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(1342790433, z2, new Function3() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12(gifZoomPositionState2, j5, uri, str, boxGifListener2, mutableState2, stateAnimateGifZoomPositionAsState2, (BoxWithConstraintsScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                BoxWithConstraintsKt.BoxWithConstraints(modifier6, null, false, composableLambdaRememberComposableLambda3, composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            } else {
                obj = null;
            }
            z2 = true;
            modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifierTestTag, 0.0f, 1, obj);
            Modifier modifier7 = modifierFillMaxSize$default;
            final long j6 = j2;
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1342790433, z2, new Function3() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12(gifZoomPositionState2, j6, uri, str, boxGifListener2, mutableState2, stateAnimateGifZoomPositionAsState2, (BoxWithConstraintsScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54);
            composer2 = composerStartRestartGroup;
            BoxWithConstraintsKt.BoxWithConstraints(modifier7, null, false, composableLambdaRememberComposableLambda4, composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$13(uri, itemId, str, boxGifListener, j, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final IntSize GifImage_y2J1wZk$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean GifImage_y2J1wZk$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GifImage_y2J1wZk$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifImage_y2J1wZk$lambda$7$0(MutableState mutableState, GifZoomPosition it) {
        Intrinsics.checkNotNullParameter(it, "it");
        GifImage_y2J1wZk$lambda$6(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifImage_y2J1wZk$lambda$12(final GifZoomPositionState gifZoomPositionState, final long j, Uri uri, String str, final BoxGifListener boxGifListener, final MutableState mutableState, State state, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C149@5162L25,150@5225L337,158@5594L411,169@6063L86,139@4746L1413:GifPreviewScreen.kt#uj0qar");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1342790433, i2, -1, "com.box.android.preview.previewtype.gif.GifImage.<anonymous> (GifPreviewScreen.kt:131)");
            }
            gifZoomPositionState.m12945updateCurrentPositionTemP2vQ(j, IntSize.m9853constructorimpl((((long) Constraints.m9640getMaxWidthimpl(BoxWithConstraints.mo1099getConstraintsmsEJaDk())) << 32) | (((long) Constraints.m9639getMaxHeightimpl(BoxWithConstraints.mo1099getConstraintsmsEJaDk())) & 4294967295L)));
            Modifier modifierScaleAndTransform = scaleAndTransform(BoxWithConstraints.matchParentSize(Modifier.INSTANCE), GifImage_y2J1wZk$lambda$5(mutableState) ? GifImage_y2J1wZk$lambda$8(state) : gifZoomPositionState.getPosition());
            ComposerKt.sourceInformationMarkerStart(composer, 1931438682, "CC(remember):GifPreviewScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(boxGifListener);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12$0$0(boxGifListener);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1931441010, "CC(remember):GifPreviewScreen.kt#9igjgp");
            boolean zChanged = composer.changed(j);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12$1$0(gifZoomPositionState, j, mutableState, (Offset) obj, (IntSize) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function2 function2 = (Function2) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1931452892, "CC(remember):GifPreviewScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(j);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function4() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12$2$0(gifZoomPositionState, j, mutableState, (Offset) obj, ((Float) obj2).floatValue(), (IntSize) obj3, (PointerEvent) obj4);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM12936enableGesturesControlHDNwks = m12936enableGesturesControlHDNwks(modifierScaleAndTransform, j, function0, function2, (Function4) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, 1931467575, "CC(remember):GifPreviewScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(boxGifListener);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GifPreviewScreenKt.GifImage_y2J1wZk$lambda$12$3$0(boxGifListener, (RequestBuilder) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            GlideImageKt.GlideImage(uri, str, modifierM12936enableGesturesControlHDNwks, null, null, 0.0f, null, null, null, null, (Function1) objRememberedValue4, composer, 0, 0, 1016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifImage_y2J1wZk$lambda$12$0$0(BoxGifListener boxGifListener) {
        boxGifListener.onClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifImage_y2J1wZk$lambda$12$1$0(GifZoomPositionState gifZoomPositionState, long j, MutableState mutableState, Offset offset, IntSize intSize) {
        GifImage_y2J1wZk$lambda$6(mutableState, true);
        gifZoomPositionState.m12946updatePositionOnDoubleClickrU8d4M(offset.m6579unboximpl(), intSize.m9862unboximpl(), j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GifImage_y2J1wZk$lambda$12$2$0(GifZoomPositionState gifZoomPositionState, long j, MutableState mutableState, Offset offset, float f, IntSize intSize, PointerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GifImage_y2J1wZk$lambda$6(mutableState, false);
        gifZoomPositionState.m12947updatePositionOnPinchs0lP2Ac(offset.m6579unboximpl(), f, intSize.m9862unboximpl(), j, event);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestBuilder GifImage_y2J1wZk$lambda$12$3$0(BoxGifListener boxGifListener, RequestBuilder requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        RequestBuilder requestBuilderListener = requestBuilder.listener(boxGifListener);
        Intrinsics.checkNotNullExpressionValue(requestBuilderListener, "listener(...)");
        return requestBuilderListener;
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$fileDimension$2, reason: invalid class name */
    /* JADX INFO: compiled from: GifPreviewScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.gif.GifPreviewScreenKt$fileDimension$2", f = "GifPreviewScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntSize>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Uri uri, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IntSize> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                ImageDecoder.Source sourceCreateSource = ImageDecoder.createSource(this.$context.getContentResolver(), this.$uri);
                Intrinsics.checkNotNullExpressionValue(sourceCreateSource, "createSource(...)");
                Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(sourceCreateSource);
                Intrinsics.checkNotNullExpressionValue(bitmapDecodeBitmap, "decodeBitmap(...)");
                int width = bitmapDecodeBitmap.getWidth();
                return IntSize.m9850boximpl(IntSize.m9853constructorimpl((((long) bitmapDecodeBitmap.getHeight()) & 4294967295L) | (((long) width) << 32)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object fileDimension(Uri uri, Context context, Continuation<? super IntSize> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass2(context, uri, null), continuation);
    }

    private static final State<GifZoomPosition> animateGifZoomPositionAsState(GifZoomPosition gifZoomPosition, Function1<? super GifZoomPosition, Unit> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 334857811, "C(animateGifZoomPositionAsState)N(position,finishedListener)194@6835L152,197@7017L109,191@6723L541:GifPreviewScreen.kt#uj0qar");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(334857811, i, -1, "com.box.android.preview.previewtype.gif.animateGifZoomPositionAsState (GifPreviewScreen.kt:191)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -324183637, "CC(remember):GifPreviewScreen.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GifPreviewScreenKt.animateGifZoomPositionAsState$lambda$0$0((GifZoomPosition) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function2 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -324177856, "CC(remember):GifPreviewScreen.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.gif.GifPreviewScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GifPreviewScreenKt.animateGifZoomPositionAsState$lambda$1$0((AnimationVector3D) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<GifZoomPosition> stateAnimateValueAsState = AnimateAsStateKt.animateValueAsState(gifZoomPosition, VectorConvertersKt.TwoWayConverter(function2, (Function1) objRememberedValue2), AnimationSpecKt.tween$default(500, 0, null, 6, null), null, "GifZoomPositionAnimation", function1, composer, (i & 14) | 24960 | ((i << 12) & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationVector3D animateGifZoomPositionAsState$lambda$0$0(GifZoomPosition gifZoomPosition) {
        Intrinsics.checkNotNullParameter(gifZoomPosition, "gifZoomPosition");
        return new AnimationVector3D(gifZoomPosition.getScale(), Float.intBitsToFloat((int) (gifZoomPosition.m12943getOffsetF1C5BW0() >> 32)), Float.intBitsToFloat((int) (gifZoomPosition.m12943getOffsetF1C5BW0() & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GifZoomPosition animateGifZoomPositionAsState$lambda$1$0(AnimationVector3D vector) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        float v1 = vector.getV1();
        float v2 = vector.getV2();
        float v3 = vector.getV3();
        return new GifZoomPosition(v1, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(v2)) << 32) | (((long) Float.floatToRawIntBits(v3)) & 4294967295L)), null);
    }

    private static final Modifier scaleAndTransform(Modifier modifier, GifZoomPosition gifZoomPosition) {
        return modifier.then(GraphicsLayerModifierKt.m6981graphicsLayer_6ThJ44$default(Modifier.INSTANCE, gifZoomPosition.getScale(), gifZoomPosition.getScale(), 0.0f, Float.intBitsToFloat((int) (gifZoomPosition.m12943getOffsetF1C5BW0() >> 32)), Float.intBitsToFloat((int) (gifZoomPosition.m12943getOffsetF1C5BW0() & 4294967295L)), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524260, null));
    }

    /* JADX INFO: renamed from: enableGesturesControl--HDNwks, reason: not valid java name */
    private static final Modifier m12936enableGesturesControlHDNwks(Modifier modifier, long j, Function0<Unit> function0, Function2<? super Offset, ? super IntSize, Unit> function2, Function4<? super Offset, ? super Float, ? super IntSize, ? super PointerEvent, Unit> function4) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, IntSize.m9850boximpl(j), new GifPreviewScreenKt$enableGesturesControl$1(function2, function0)), IntSize.m9850boximpl(j), new GifPreviewScreenKt$enableGesturesControl$2(function4)));
    }

    private static final GifPreviewReducer.State GifPreviewScreen$lambda$0(State<GifPreviewReducer.State> state) {
        return state.getValue();
    }

    private static final GifZoomPosition GifImage_y2J1wZk$lambda$8(State<GifZoomPosition> state) {
        return state.getValue();
    }
}

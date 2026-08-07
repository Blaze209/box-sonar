package com.bumptech.glide.integration.compose;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Preload.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\u001a\u00ad\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00040\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012L\u0010\r\u001aH\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000ej\b\u0012\u0004\u0012\u0002H\u0004`\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u009f\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00192\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012L\u0010\r\u001aH\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000ej\b\u0012\u0004\u0012\u0002H\u0004`\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001c\u001a\u00020\u001d*\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*\u0088\u0001\u0010 \u001a\u0004\b\u0000\u0010!\">\u0012\u0013\u0012\u0011H!¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e2>\u0012\u0013\u0012\u0011H!¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"DEFAULT_ITEMS_TO_PRELOAD", "", "rememberGlidePreloadingData", "Lcom/bumptech/glide/integration/compose/GlidePreloadingData;", "DataT", "", "dataSize", "dataGetter", "Lkotlin/Function1;", "preloadImageSize", "Landroidx/compose/ui/geometry/Size;", "numberOfItemsToPreload", "fixedVisibleItemCount", "requestBuilderTransform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "requestBuilder", "Lcom/bumptech/glide/integration/compose/PreloadRequestBuilderTransform;", "rememberGlidePreloadingData-u6VnWhU", "(ILkotlin/jvm/functions/Function1;JILjava/lang/Integer;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)Lcom/bumptech/glide/integration/compose/GlidePreloadingData;", "data", "", "rememberGlidePreloadingData-Z8o_i8w", "(Ljava/util/List;JILjava/lang/Integer;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)Lcom/bumptech/glide/integration/compose/GlidePreloadingData;", "toIntArray", "", "toIntArray-uvyYCjk", "(J)[I", "PreloadRequestBuilderTransform", "DataTypeT", "compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PreloadKt {
    private static final int DEFAULT_ITEMS_TO_PRELOAD = 10;

    /* JADX INFO: renamed from: rememberGlidePreloadingData-u6VnWhU, reason: not valid java name */
    public static final <DataT> GlidePreloadingData<DataT> m13166rememberGlidePreloadingDatau6VnWhU(int i, Function1<? super Integer, ? extends DataT> dataGetter, long j, int i2, Integer num, Function2<? super DataT, ? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> requestBuilderTransform, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(dataGetter, "dataGetter");
        Intrinsics.checkNotNullParameter(requestBuilderTransform, "requestBuilderTransform");
        composer.startReplaceableGroup(862519803);
        ComposerKt.sourceInformation(composer, "C(rememberGlidePreloadingData)P(1!1,4:c#ui.geometry.Size,3)");
        int i5 = (i4 & 8) != 0 ? 10 : i2;
        Integer num2 = (i4 & 16) != 0 ? null : num;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(862519803, i3, -1, "com.bumptech.glide.integration.compose.rememberGlidePreloadingData (Preload.kt:81)");
        }
        composer.startReplaceableGroup(-1425374817);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(context);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = Glide.with(context);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        RequestManager requestManager = (RequestManager) objRememberedValue;
        composer.endReplaceableGroup();
        Intrinsics.checkNotNullExpressionValue(requestManager, "LocalContext.current.let…(it) { Glide.with(it) } }");
        Object[] objArr = {requestManager, Integer.valueOf(i), dataGetter, Size.m6626boximpl(j), Integer.valueOf(i5), num2, requestBuilderTransform};
        Integer num3 = num2;
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged2 = false;
        for (int i6 = 0; i6 < 7; i6++) {
            zChanged2 |= composer.changed(objArr[i6]);
        }
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            PreloaderData preloaderData = new PreloaderData(i, dataGetter, requestBuilderTransform, j, null);
            Object preloadDataImpl = new PreloadDataImpl(i, dataGetter, requestManager, j, num3, new ListPreloader(requestManager, new PreloadModelProvider(requestManager, preloaderData), new PreloadDimensionsProvider(preloaderData), i5), requestBuilderTransform, null);
            composer.updateRememberedValue(preloadDataImpl);
            objRememberedValue2 = preloadDataImpl;
        }
        composer.endReplaceableGroup();
        PreloadDataImpl preloadDataImpl2 = (PreloadDataImpl) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return preloadDataImpl2;
    }

    /* JADX INFO: renamed from: rememberGlidePreloadingData-Z8o_i8w, reason: not valid java name */
    public static final <DataT> GlidePreloadingData<DataT> m13165rememberGlidePreloadingDataZ8o_i8w(List<? extends DataT> data, long j, int i, Integer num, Function2<? super DataT, ? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> requestBuilderTransform, Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(requestBuilderTransform, "requestBuilderTransform");
        composer.startReplaceableGroup(-510325645);
        ComposerKt.sourceInformation(composer, "C(rememberGlidePreloadingData)P(!1,3:c#ui.geometry.Size,2)");
        if ((i3 & 4) != 0) {
            i = 10;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-510325645, i2, -1, "com.bumptech.glide.integration.compose.rememberGlidePreloadingData (Preload.kt:128)");
        }
        GlidePreloadingData<DataT> glidePreloadingDataM13166rememberGlidePreloadingDatau6VnWhU = m13166rememberGlidePreloadingDatau6VnWhU(data.size(), new PreloadKt$rememberGlidePreloadingData$2(data), j, i4, num2, requestBuilderTransform, composer, (i2 << 3) & 524160, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return glidePreloadingDataM13166rememberGlidePreloadingDatau6VnWhU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toIntArray-uvyYCjk, reason: not valid java name */
    public static final int[] m13167toIntArrayuvyYCjk(long j) {
        return new int[]{(int) Size.m6638getWidthimpl(j), (int) Size.m6635getHeightimpl(j)};
    }
}

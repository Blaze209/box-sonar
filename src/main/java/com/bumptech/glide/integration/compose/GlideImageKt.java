package com.bumptech.glide.integration.compose;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¥\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142*\b\u0002\u0010\u0015\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0018`\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001ak\u0010\u001b\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072*\b\u0002\u0010\u0015\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001a'\u0010!\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010$\u001a \u0010%\u001a\u00020\u00112\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00010'¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010(\u001a\u0012\u0010%\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0007\u001a\u0012\u0010%\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+H\u0007\u001a\u0012\u0010%\u001a\u00020\u00112\b\b\u0001\u0010,\u001a\u00020-H\u0007\u001aW\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u0002002(\u0010\u0015\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u00101\u001a \u00102\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017*\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0002*@\u00103\u001a\u0004\b\u0000\u00104\"\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40\u00170\u00162\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H40\u00170\u0016¨\u00065"}, d2 = {"GlideImage", "", "model", "", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "loading", "Lcom/bumptech/glide/integration/compose/Placeholder;", "failure", "transition", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "requestBuilderTransform", "Lkotlin/Function1;", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "Lcom/bumptech/glide/integration/compose/RequestBuilderTransform;", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lcom/bumptech/glide/integration/compose/Placeholder;Lcom/bumptech/glide/integration/compose/Placeholder;Lcom/bumptech/glide/integration/compose/Transition$Factory;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "GlideSubcomposition", "content", "Lcom/bumptech/glide/integration/compose/GlideSubcompositionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PreviewResourceOrDrawable", "(Lcom/bumptech/glide/integration/compose/Placeholder;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "SimpleLayout", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", ReactTextInputShadowNode.PROP_PLACEHOLDER, ComposeNavigator.NAME, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;)Lcom/bumptech/glide/integration/compose/Placeholder;", "drawable", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "resourceId", "", "rememberRequestBuilderWithDefaults", "requestManager", "Lcom/bumptech/glide/RequestManager;", "(Ljava/lang/Object;Lcom/bumptech/glide/RequestManager;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)Lcom/bumptech/glide/RequestBuilder;", "contentScaleTransform", "RequestBuilderTransform", ExifInterface.GPS_DIRECTION_TRUE, "compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GlideImageKt {
    public static final void GlideImage(final Object obj, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Placeholder placeholder, Placeholder placeholder2, Transition.Factory factory, Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1, Composer composer, final int i, final int i2, final int i3) {
        Alignment alignment2;
        final ContentScale contentScale2;
        Alignment alignment3;
        Composer composer2;
        RequestBuilder<Drawable> requestBuilderApply$compose_release;
        Composer composerStartRestartGroup = composer.startRestartGroup(1955430130);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlideImage)P(7,3,8!1,4!2,6!1,10)");
        final Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        Alignment center = (i3 & 8) != 0 ? Alignment.INSTANCE.getCenter() : alignment;
        ContentScale fit = (i3 & 16) != 0 ? ContentScale.INSTANCE.getFit() : contentScale;
        final float f2 = (i3 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i3 & 64) != 0 ? null : colorFilter;
        final Placeholder placeholder3 = (i3 & 128) != 0 ? null : placeholder;
        Placeholder placeholder4 = (i3 & 256) != 0 ? null : placeholder2;
        final Transition.Factory factory2 = (i3 & 512) != 0 ? null : factory;
        AnonymousClass1 anonymousClass1 = (i3 & 1024) != 0 ? new Function1<RequestBuilder<Drawable>, RequestBuilder<Drawable>>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideImage.1
            @Override // kotlin.jvm.functions.Function1
            public final RequestBuilder<Drawable> invoke(RequestBuilder<Drawable> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1955430130, i, i2, "com.bumptech.glide.integration.compose.GlideImage (GlideImage.kt:84)");
        }
        composerStartRestartGroup.startReplaceableGroup(482162156);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Context context = (Context) objConsume;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composerStartRestartGroup.changed(context);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = Glide.with(context);
            Intrinsics.checkNotNullExpressionValue(objRememberedValue, "with(it)");
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        RequestManager requestManager = (RequestManager) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        Intrinsics.checkNotNullExpressionValue(requestManager, "LocalContext.current.let…(it) { Glide.with(it) } }");
        int i4 = i >> 3;
        final ContentScale contentScale3 = fit;
        final Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function2 = anonymousClass1;
        RequestBuilder<Drawable> requestBuilderRememberRequestBuilderWithDefaults = rememberRequestBuilderWithDefaults(obj, requestManager, function2, contentScale3, composerStartRestartGroup, (i4 & 7168) | ((i2 << 6) & 896) | 72);
        if (placeholder3 != null) {
            alignment2 = center;
            RequestBuilder<Drawable> requestBuilderApply$compose_release2 = placeholder3.apply$compose_release(new GlideImageKt$GlideImage$requestBuilder$1$1(requestBuilderRememberRequestBuilderWithDefaults), new GlideImageKt$GlideImage$requestBuilder$1$2(requestBuilderRememberRequestBuilderWithDefaults));
            if (requestBuilderApply$compose_release2 != null) {
                requestBuilderRememberRequestBuilderWithDefaults = requestBuilderApply$compose_release2;
            }
        } else {
            alignment2 = center;
        }
        RequestBuilder<Drawable> requestBuilder = (placeholder4 == null || (requestBuilderApply$compose_release = placeholder4.apply$compose_release(new GlideImageKt$GlideImage$requestBuilder$2$1(requestBuilderRememberRequestBuilderWithDefaults), new GlideImageKt$GlideImage$requestBuilder$2$2(requestBuilderRememberRequestBuilderWithDefaults))) == null) ? requestBuilderRememberRequestBuilderWithDefaults : requestBuilderApply$compose_release;
        composerStartRestartGroup.startReplaceableGroup(482162656);
        ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composerStartRestartGroup.consume(localInspectionMode);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        if (((Boolean) objConsume2).booleanValue() && placeholder3 != null && placeholder3.isResourceOrDrawable$compose_release()) {
            PreviewResourceOrDrawable(placeholder3, str, modifier2, composerStartRestartGroup, ((i >> 21) & 14) | (i & 112) | (i & 896));
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            final ColorFilter colorFilter3 = colorFilter2;
            final Placeholder placeholder5 = placeholder4;
            final Alignment alignment4 = alignment2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideImage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    GlideImageKt.GlideImage(obj, str, modifier2, alignment4, contentScale3, f2, colorFilter3, placeholder3, placeholder5, factory2, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
            return;
        }
        final Placeholder placeholder6 = placeholder4;
        final float f3 = f2;
        final Placeholder placeholder7 = placeholder3;
        final Alignment alignment5 = alignment2;
        composerStartRestartGroup.endReplaceableGroup();
        Function2<Composer, Integer, Unit> function2MaybeComposable$compose_release = placeholder7 != null ? placeholder7.maybeComposable$compose_release() : null;
        Function2<Composer, Integer, Unit> function2MaybeComposable$compose_release2 = placeholder6 != null ? placeholder6.maybeComposable$compose_release() : null;
        if (function2MaybeComposable$compose_release == null && function2MaybeComposable$compose_release2 == null) {
            composerStartRestartGroup.startReplaceableGroup(482163560);
            composer2 = composerStartRestartGroup;
            contentScale2 = contentScale3;
            SimpleLayout(GlideModifierKt.glideNode$default(modifier2, requestBuilder, str, alignment5, contentScale3, Float.valueOf(f3), colorFilter2, factory2, null, null, placeholder7 != null ? placeholder7.maybePainter$compose_release() : null, placeholder6 != null ? placeholder6.maybePainter$compose_release() : null, 384, null), composer2, 0);
            composer2.endReplaceableGroup();
            alignment3 = alignment5;
        } else {
            final ColorFilter colorFilter4 = colorFilter2;
            final RequestBuilder<Drawable> requestBuilder2 = requestBuilder;
            contentScale2 = contentScale3;
            composerStartRestartGroup.startReplaceableGroup(482163071);
            Function1<RequestBuilder<Drawable>, RequestBuilder<Drawable>> function3 = new Function1<RequestBuilder<Drawable>, RequestBuilder<Drawable>>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideImage.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final RequestBuilder<Drawable> invoke(RequestBuilder<Drawable> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return requestBuilder2;
                }
            };
            final Modifier modifier3 = modifier2;
            final Function2<Composer, Integer, Unit> function4 = function2MaybeComposable$compose_release;
            final Function2<Composer, Integer, Unit> function5 = function2MaybeComposable$compose_release2;
            alignment3 = alignment5;
            colorFilter2 = colorFilter4;
            GlideSubcomposition(obj, modifier2, function3, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1823704622, true, new Function3<GlideSubcompositionScope, Composer, Integer, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideImage.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(GlideSubcompositionScope glideSubcompositionScope, Composer composer3, Integer num) {
                    invoke(glideSubcompositionScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GlideSubcompositionScope GlideSubcomposition, Composer composer3, int i5) {
                    int i6;
                    Intrinsics.checkNotNullParameter(GlideSubcomposition, "$this$GlideSubcomposition");
                    if ((i5 & 14) == 0) {
                        i6 = (composer3.changed(GlideSubcomposition) ? 4 : 2) | i5;
                    } else {
                        i6 = i5;
                    }
                    if ((i6 & 91) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1823704622, i5, -1, "com.bumptech.glide.integration.compose.GlideImage.<anonymous> (GlideImage.kt:119)");
                        }
                        if (Intrinsics.areEqual(GlideSubcomposition.getState(), RequestState.Loading.INSTANCE) && function4 != null) {
                            composer3.startReplaceableGroup(-1111684313);
                            function4.invoke(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (Intrinsics.areEqual(GlideSubcomposition.getState(), RequestState.Failure.INSTANCE) && function5 != null) {
                            composer3.startReplaceableGroup(-1111684206);
                            function5.invoke(composer3, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1111684163);
                            Painter painter = GlideSubcomposition.getPainter();
                            String str2 = str;
                            Modifier modifier4 = modifier3;
                            Alignment alignment6 = alignment5;
                            ContentScale contentScale4 = contentScale2;
                            float f4 = f3;
                            ColorFilter colorFilter5 = colorFilter4;
                            int i7 = i;
                            ImageKt.Image(painter, str2, modifier4, alignment6, contentScale4, f4, colorFilter5, composer3, (i7 & 112) | 8 | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (i7 & 3670016), 0);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composerStartRestartGroup, (i4 & 112) | 3080, 0);
            composer2 = composerStartRestartGroup;
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 == null) {
            return;
        }
        final Alignment alignment6 = alignment3;
        final ColorFilter colorFilter5 = colorFilter2;
        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideImage.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i5) {
                GlideImageKt.GlideImage(obj, str, modifier2, alignment6, contentScale2, f3, colorFilter5, placeholder7, placeholder6, factory2, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
            }
        });
    }

    public static final void GlideSubcomposition(final Object obj, Modifier modifier, Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1, final Function3<? super GlideSubcompositionScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(289486858);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlideSubcomposition)P(1,2,3)");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        final C17311 c17311 = (i2 & 4) != 0 ? new Function1<RequestBuilder<Drawable>, RequestBuilder<Drawable>>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideSubcomposition.1
            @Override // kotlin.jvm.functions.Function1
            public final RequestBuilder<Drawable> invoke(RequestBuilder<Drawable> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it;
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(289486858, i, -1, "com.bumptech.glide.integration.compose.GlideSubcomposition (GlideImage.kt:251)");
        }
        composerStartRestartGroup.startReplaceableGroup(1096724416);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Context context = (Context) objConsume;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composerStartRestartGroup.changed(context);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = Glide.with(context);
            Intrinsics.checkNotNullExpressionValue(objRememberedValue, "with(it)");
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        RequestManager requestManager = (RequestManager) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        Intrinsics.checkNotNullExpressionValue(requestManager, "LocalContext.current.let…(it) { Glide.with(it) } }");
        composerStartRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged2 = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(requestManager) | composerStartRestartGroup.changed(c17311);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            RequestBuilder<Drawable> requestBuilderLoad = requestManager.load(obj);
            Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "requestManager.load(model)");
            objRememberedValue2 = (RequestBuilder) c17311.invoke(requestBuilderLoad);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        RequestBuilder requestBuilder = (RequestBuilder) objRememberedValue2;
        composerStartRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged3 = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(requestManager) | composerStartRestartGroup.changed(c17311);
        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RequestState.Loading.INSTANCE, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        }
        composerStartRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue3;
        composerStartRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged4 = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(requestManager) | composerStartRestartGroup.changed(c17311);
        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
        }
        composerStartRestartGroup.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) objRememberedValue4;
        composerStartRestartGroup.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged5 = composerStartRestartGroup.changed(obj) | composerStartRestartGroup.changed(requestManager) | composerStartRestartGroup.changed(c17311);
        Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new StateTrackingListener(mutableState, mutableState2);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
        }
        composerStartRestartGroup.endReplaceableGroup();
        GlideSubcompositionScopeImpl glideSubcompositionScopeImpl = new GlideSubcompositionScopeImpl((Painter) mutableState2.getValue(), (RequestState) mutableState.getValue());
        Modifier modifierGlideNode$default = GlideModifierKt.glideNode$default(modifier2, requestBuilder, null, null, null, null, null, null, (StateTrackingListener) objRememberedValue5, false, null, null, 1662, null);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)69@3214L67,70@3286L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierGlideNode$default);
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
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m6030boximpl(SkippableUpdater.m6031constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629358, "C71@3331L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        content.invoke(glideSubcompositionScopeImpl, composerStartRestartGroup, Integer.valueOf(((i >> 6) & 112) | 8));
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.GlideSubcomposition.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                GlideImageKt.GlideSubcomposition(obj, modifier3, c17311, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PreviewResourceOrDrawable(final Placeholder placeholder, String str, Modifier modifier, Composer composer, final int i) {
        int i2;
        Painter painter;
        final String str2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1753501208);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(placeholder) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1753501208, i2, -1, "com.bumptech.glide.integration.compose.PreviewResourceOrDrawable (GlideImage.kt:307)");
            }
            composerStartRestartGroup.startReplaceableGroup(910160286);
            if (placeholder instanceof Placeholder.OfDrawable) {
                painter = PainterKt.toPainter(((Placeholder.OfDrawable) placeholder).getDrawable());
            } else if (placeholder instanceof Placeholder.OfResourceId) {
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                painter = PainterKt.toPainter(((Context) objConsume).getDrawable(((Placeholder.OfResourceId) placeholder).getResourceId()));
            } else {
                if (!(placeholder instanceof Placeholder.OfPainter)) {
                    if (!(placeholder instanceof Placeholder.OfComposable)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalArgumentException("Composables should go through the production codepath");
                }
                painter = ((Placeholder.OfPainter) placeholder).getPainter();
            }
            Painter painter2 = painter;
            composerStartRestartGroup.endReplaceableGroup();
            str2 = str;
            modifier2 = modifier;
            ImageKt.Image(painter2, str2, modifier2, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, (i2 & 112) | 8 | (i2 & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            str2 = str;
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.PreviewResourceOrDrawable.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                GlideImageKt.PreviewResourceOrDrawable(placeholder, str2, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    public static final Placeholder placeholder(Drawable drawable) {
        return new Placeholder.OfDrawable(drawable);
    }

    public static final Placeholder placeholder(int i) {
        return new Placeholder.OfResourceId(i);
    }

    public static final Placeholder placeholder(Painter painter) {
        if (painter == null) {
            painter = new ColorPainter(Color.INSTANCE.m6849getTransparent0d7_KjU(), null);
        }
        return new Placeholder.OfPainter(painter);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Using this method forces recomposition when the image load state changes. If you require this behavior use GlideSubcomposition instead")
    public static final Placeholder placeholder(Function2<? super Composer, ? super Integer, Unit> composable) {
        Intrinsics.checkNotNullParameter(composable, "composable");
        return new Placeholder.OfComposable(composable);
    }

    private static final RequestBuilder<Drawable> rememberRequestBuilderWithDefaults(Object obj, RequestManager requestManager, Function1<? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> function1, ContentScale contentScale, Composer composer, int i) {
        composer.startReplaceableGroup(1761561633);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1761561633, i, -1, "com.bumptech.glide.integration.compose.rememberRequestBuilderWithDefaults (GlideImage.kt:429)");
        }
        Object[] objArr = {obj, requestManager, function1, contentScale};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i2 = 0; i2 < 4; i2++) {
            zChanged |= composer.changed(objArr[i2]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            RequestBuilder<Drawable> requestBuilderLoad = requestManager.load(obj);
            Intrinsics.checkNotNullExpressionValue(requestBuilderLoad, "requestManager.load(model)");
            objRememberedValue = (RequestBuilder) function1.invoke(contentScaleTransform(requestBuilderLoad, contentScale));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        RequestBuilder<Drawable> requestBuilder = (RequestBuilder) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return requestBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestBuilder<Drawable> contentScaleTransform(RequestBuilder<Drawable> requestBuilder, ContentScale contentScale) {
        if (Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getCrop())) {
            Cloneable cloneableOptionalCenterCrop = requestBuilder.optionalCenterCrop();
            Intrinsics.checkNotNullExpressionValue(cloneableOptionalCenterCrop, "{\n      optionalCenterCrop()\n    }");
            return (RequestBuilder) cloneableOptionalCenterCrop;
        }
        if (!(Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getInside()) ? true : Intrinsics.areEqual(contentScale, ContentScale.INSTANCE.getFit()))) {
            return requestBuilder;
        }
        Cloneable cloneableOptionalCenterInside = requestBuilder.optionalCenterInside();
        Intrinsics.checkNotNullExpressionValue(cloneableOptionalCenterInside, "{\n      // Outside compo…ionalCenterInside()\n    }");
        return (RequestBuilder) cloneableOptionalCenterInside;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SimpleLayout(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1856253139);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1856253139, i2, -1, "com.bumptech.glide.integration.compose.SimpleLayout (GlideImage.kt:465)");
            }
            C17341 c17341 = new MeasurePolicy() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.SimpleLayout.1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo344measure3p2s80s(MeasureScope Layout, List<? extends Measurable> list, long j) {
                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                    Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                    return MeasureScope.layout$default(Layout, Constraints.m9642getMinWidthimpl(j), Constraints.m9641getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$SimpleLayout$1$measure$1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope layout) {
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(544976794);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            composerStartRestartGroup.startReplaceableGroup(1405779621);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(new Function0<ComposeUiNode>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt$SimpleLayout$$inlined$Layout$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ComposeUiNode invoke() {
                        return constructor.invoke();
                    }
                });
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, c17341, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideImageKt.SimpleLayout.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                GlideImageKt.SimpleLayout(modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}

package expo.modules.ui.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.ui.ExpoUIModule;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.UtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: IconView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0003¢\u0006\u0002\u0010\u001eR\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006 ²\u0006\f\u0010!\u001a\u0004\u0018\u00010\"X\u008a\u008e\u0002²\u0006\f\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u008a\u008e\u0002"}, d2 = {"Lexpo/modules/ui/icon/IconView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/icon/IconProps;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/icon/IconProps;", "iconLoader", "Lexpo/modules/ui/icon/VectorIconLoader;", "getIconLoader", "()Lexpo/modules/ui/icon/VectorIconLoader;", "iconLoader$delegate", "Lkotlin/Lazy;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "resolveUri", "", "source", "Lexpo/modules/ui/icon/Source;", "rememberDrawableAsPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "DrawablePainter", "expo-ui_release", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconView extends ExpoComposeView<IconProps> {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: iconLoader$delegate, reason: from kotlin metadata */
    private final Lazy iconLoader;
    private final IconProps props;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$11(IconView iconView, ComposableScope composableScope, int i, Composer composer, int i2) {
        iconView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconView(final Context context, final AppContext appContext) {
        super(context, appContext, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new IconProps(null, null, null, null, null, 31, null);
        this.iconLoader = LazyKt.lazy(new Function0() { // from class: expo.modules.ui.icon.IconView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IconView.iconLoader_delegate$lambda$1(appContext, context);
            }
        });
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public IconProps getProps() {
        return this.props;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VectorIconLoader getIconLoader() {
        return (VectorIconLoader) this.iconLoader.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VectorIconLoader iconLoader_delegate$lambda$1(AppContext appContext, Context context) {
        Object next;
        Iterator<T> it = appContext.getRegistry().getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModuleHolder) next).getModule() instanceof ExpoUIModule));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module = moduleHolder != null ? moduleHolder.getModule() : null;
        if (!(module instanceof ExpoUIModule)) {
            module = null;
        }
        ExpoUIModule expoUIModule = (ExpoUIModule) module;
        OkHttpClient okHttpClient = expoUIModule != null ? expoUIModule.getOkHttpClient() : null;
        if (okHttpClient == null) {
            throw new IllegalArgumentException("ExpoUIModule.okHttpClient is not initialized".toString());
        }
        return new VectorIconLoader(context, okHttpClient);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0190  */
    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        MutableState mutableState;
        MutableState mutableState2;
        IconView$Content$1$1 iconView$Content$1$1;
        VectorPainter vectorPainterRememberDrawableAsPainter;
        final ComposableScope composableScope2;
        Modifier.Companion companionM1266size3ABfNKs;
        final IconView iconView = this;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1204827952);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)75@2795L47,76@2863L44,79@2977L356,79@2954L379,104@3875L74,98@3584L374:IconView.kt#xj628g");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(iconView) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1204827952, i3, -1, "expo.modules.ui.icon.IconView.Content (IconView.kt:68)");
            }
            Source sourceComponent1 = iconView.getProps().getSource().component1();
            Color colorComponent1 = iconView.getProps().getTintColor().component1();
            Integer numComponent1 = iconView.getProps().getSize().component1();
            String strComponent1 = iconView.getProps().getContentDescription().component1();
            List<Map<String, Object>> listComponent1 = iconView.getProps().getModifiers().component1();
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1224400529);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):IconView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(sourceComponent1) | composerStartRestartGroup.changedInstance(iconView);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState4;
                mutableState2 = mutableState3;
                iconView$Content$1$1 = new IconView$Content$1$1(sourceComponent1, iconView, mutableState2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(iconView$Content$1$1);
            } else {
                mutableState = mutableState4;
                iconView$Content$1$1 = objRememberedValue3;
                mutableState2 = mutableState3;
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(sourceComponent1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) iconView$Content$1$1, composerStartRestartGroup, 0);
            ImageVector imageVectorContent$lambda$3 = Content$lambda$3(mutableState2);
            composerStartRestartGroup.startReplaceGroup(1801537073);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3437L25");
            VectorPainter vectorPainterRememberVectorPainter = imageVectorContent$lambda$3 != null ? VectorPainterKt.rememberVectorPainter(imageVectorContent$lambda$3, composerStartRestartGroup, 0) : null;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1801536715);
            ComposerKt.sourceInformation(composerStartRestartGroup, "94@3474L35");
            if (vectorPainterRememberVectorPainter != null) {
                vectorPainterRememberDrawableAsPainter = vectorPainterRememberVectorPainter;
            } else {
                vectorPainterRememberDrawableAsPainter = iconView.rememberDrawableAsPainter(Content$lambda$6(mutableState), composerStartRestartGroup, i3 & 112);
            }
            Painter painter = vectorPainterRememberDrawableAsPainter;
            composerStartRestartGroup.endReplaceGroup();
            if (painter != null) {
                long compose = colorComponent1 != null ? UtilsKt.getCompose(colorComponent1) : androidx.compose.ui.graphics.Color.INSTANCE.m6850getUnspecified0d7_KjU();
                Modifier.Companion companion = Modifier.INSTANCE;
                if (numComponent1 != null) {
                    companionM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(numComponent1.intValue()));
                    if (companionM1266size3ABfNKs == null) {
                        companionM1266size3ABfNKs = Modifier.INSTANCE;
                    }
                } else {
                    companionM1266size3ABfNKs = Modifier.INSTANCE;
                }
                composableScope2 = composableScope;
                iconView = this;
                IconKt.m3575Iconww6aTOc(painter, strComponent1, companion.then(companionM1266size3ABfNKs).then(ModifierRegistry.INSTANCE.applyModifiers(listComponent1, iconView.getAppContext(), composableScope2, iconView.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6) | ((i3 << 6) & 896))), compose, composerStartRestartGroup, Painter.$stable, 0);
            } else {
                composableScope2 = composableScope;
                iconView = iconView;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composableScope2 = composableScope;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.icon.IconView$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconView.Content$lambda$11(this.f$0, composableScope2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ImageVector Content$lambda$3(MutableState<ImageVector> mutableState) {
        return mutableState.getValue();
    }

    private static final Drawable Content$lambda$6(MutableState<Drawable> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveUri(Source source) {
        String uri = source.getUri();
        try {
            if (Uri.parse(uri).getScheme() != null) {
                return uri;
            }
            ResourceIdHelper resourceIdHelper = ResourceIdHelper.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Uri resourceUri = resourceIdHelper.getResourceUri(context, uri);
            if (resourceUri != null) {
                return resourceUri.toString();
            }
            return null;
        } catch (Exception unused) {
            ResourceIdHelper resourceIdHelper2 = ResourceIdHelper.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            Uri resourceUri2 = resourceIdHelper2.getResourceUri(context2, uri);
            if (resourceUri2 != null) {
                return resourceUri2.toString();
            }
            return null;
        }
    }

    private final Painter rememberDrawableAsPainter(Drawable drawable, Composer composer, int i) {
        DrawablePainter drawablePainter;
        composer.startReplaceGroup(1506891057);
        ComposerKt.sourceInformation(composer, "C(rememberDrawableAsPainter)131@4647L206:IconView.kt#xj628g");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1506891057, i, -1, "expo.modules.ui.icon.IconView.rememberDrawableAsPainter (IconView.kt:130)");
        }
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):IconView.kt#9igjgp");
        boolean zChanged = composer.changed(drawable);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (drawable == null) {
                drawablePainter = null;
            } else {
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                    objRememberedValue = new BitmapPainter(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), 0L, 0L, 6, null);
                } else {
                    Drawable drawableMutate = drawable.mutate();
                    Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
                    drawablePainter = new DrawablePainter(drawableMutate);
                }
                composer.updateRememberedValue(objRememberedValue);
            }
            objRememberedValue = drawablePainter;
            composer.updateRememberedValue(objRememberedValue);
        }
        Painter painter = (Painter) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return painter;
    }

    /* JADX INFO: compiled from: IconView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lexpo/modules/ui/icon/IconView$DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class DrawablePainter extends Painter {
        private final Drawable drawable;

        public DrawablePainter(Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.drawable = drawable;
        }

        @Override // androidx.compose.ui.graphics.painter.Painter
        /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
        public long getDrawableIntrinsicSize() {
            Float fValueOf = Float.valueOf(this.drawable.getIntrinsicWidth());
            if (fValueOf.floatValue() <= 0.0f) {
                fValueOf = null;
            }
            float fFloatValue = fValueOf != null ? fValueOf.floatValue() : Float.intBitsToFloat((int) (Size.INSTANCE.m6646getUnspecifiedNHjbRc() >> 32));
            Float fValueOf2 = Float.valueOf(this.drawable.getIntrinsicHeight());
            Float f = fValueOf2.floatValue() > 0.0f ? fValueOf2 : null;
            return Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(f != null ? f.floatValue() : Float.intBitsToFloat((int) (Size.INSTANCE.m6646getUnspecifiedNHjbRc() & 4294967295L)))) & 4294967295L));
        }

        @Override // androidx.compose.ui.graphics.painter.Painter
        protected void onDraw(DrawScope drawScope) {
            Intrinsics.checkNotNullParameter(drawScope, "<this>");
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            Drawable drawable = this.drawable;
            drawable.setBounds(0, 0, (int) Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)), (int) Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() & 4294967295L)));
            drawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }
}

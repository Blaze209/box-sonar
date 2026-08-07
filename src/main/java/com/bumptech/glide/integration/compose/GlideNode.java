package com.bumptech.glide.integration.compose;

import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import com.bumptech.glide.ModelExtractorKt;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.ktx.AsyncGlideSize;
import com.bumptech.glide.integration.ktx.FlowsKt;
import com.bumptech.glide.integration.ktx.GlideFlowInstant;
import com.bumptech.glide.integration.ktx.ImmediateGlideSize;
import com.bumptech.glide.integration.ktx.ResolvableGlideSize;
import com.bumptech.glide.integration.ktx.Resource;
import com.bumptech.glide.integration.ktx.Size;
import com.bumptech.glide.integration.ktx.Status;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.util.Preconditions;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: GlideModifier.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002rsB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010?\u001a\u00020@H\u0002J\u0013\u0010A\u001a\u00020\u00172\b\u0010B\u001a\u0004\u0018\u00010CH\u0096\u0002J\b\u0010D\u001a\u00020EH\u0016J\u0016\u0010F\u001a\u00020@2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u001d\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001a\u00020@H\u0016J\b\u0010M\u001a\u00020@H\u0016Jo\u0010N\u001a\u00020@2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u00103\u001a\u0004\u0018\u0001042\b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u00020@H\u0016J\u0012\u0010Q\u001a\u00020@2\b\u0010R\u001a\u0004\u0018\u00010$H\u0002J\f\u0010S\u001a\u00020@*\u00020TH\u0016J\f\u0010\u0016\u001a\u00020@*\u00020UH\u0016JD\u0010V\u001a\u0004\u0018\u00010\u0019*\u00020U2\b\u0010W\u001a\u0004\u0018\u00010\u001b2\b\u0010X\u001a\u0004\u0018\u00010\u00192\u001d\u0010V\u001a\u0019\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020@0Y¢\u0006\u0002\b[H\u0002ø\u0001\u0000J\u0019\u0010\u001c\u001a\u00020\u0017*\u00020HH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u00108J\u001a\u0010]\u001a\u00020@*\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020'0`H\u0002J\u0012\u0010a\u001a\u0004\u0018\u00010b*\u0006\u0012\u0002\b\u00030&H\u0002J)\u0010c\u001a\u00020d*\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010I\u001a\u00020HH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u0019\u0010j\u001a\u00020k*\u000206H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010KJ\u0019\u0010m\u001a\u00020n*\u00020oH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010qR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u00020\u0017*\u0002068BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u00109\u001a\u00020\u0017*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020\u0017*\u0002068BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b<\u00108R\u001b\u0010=\u001a\u00020\u0017*\u0002068BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b>\u00108\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006t"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "alignment", "Landroidx/compose/ui/Alignment;", "alpha", "", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "currentJob", "Lkotlinx/coroutines/Job;", "draw", "", "drawablePositionAndSize", "Lcom/bumptech/glide/integration/compose/GlideNode$CachedPositionAndSize;", "errorPlaceholder", "Landroidx/compose/ui/graphics/painter/Painter;", "hasFixedSize", "inferredGlideSize", "Lcom/bumptech/glide/integration/ktx/Size;", "isFirstResource", "loadingPlaceholder", ReactTextInputShadowNode.PROP_PLACEHOLDER, "placeholderPositionAndSize", "primary", "Lcom/bumptech/glide/integration/compose/GlideNode$Primary;", "requestBuilder", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "requestListener", "Lcom/bumptech/glide/integration/compose/RequestListener;", "resolvableGlideSize", "Lcom/bumptech/glide/integration/ktx/ResolvableGlideSize;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "state", "Lcom/bumptech/glide/integration/compose/RequestState;", "transition", "Lcom/bumptech/glide/integration/compose/Transition;", "transitionFactory", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "isValid", "Landroidx/compose/ui/geometry/Size;", "isValid-uvyYCjk", "(J)Z", "isValidDimension", "(F)Z", "isValidHeight", "isValidHeight-uvyYCjk", "isValidWidth", "isValidWidth-uvyYCjk", DiagnosisParams.CLEAR_ON_LOGOUT, "", "equals", "other", "", "hashCode", "", "launchRequest", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "(J)J", "onAttach", "onDetach", "onNewRequest", "(Lcom/bumptech/glide/RequestBuilder;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;Ljava/lang/Float;Landroidx/compose/ui/graphics/ColorFilter;Lcom/bumptech/glide/integration/compose/RequestListener;Ljava/lang/Boolean;Lcom/bumptech/glide/integration/compose/Transition$Factory;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)V", "onReset", "updatePrimary", "newPrimary", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOne", "painter", SemanticAttributes.DbSystemValues.CACHE, "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "hasFixedSize-BRTryo0", "maybeAnimate", "Lkotlinx/coroutines/CoroutineScope;", "instant", "Lcom/bumptech/glide/integration/ktx/Resource;", "maybeImmediateSize", "Lcom/bumptech/glide/integration/ktx/ImmediateGlideSize;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "roundToInt", "Landroidx/compose/ui/unit/IntSize;", "roundToInt-OLKMvJU", "toPointF", "Landroid/graphics/PointF;", "Landroidx/compose/ui/unit/IntOffset;", "toPointF--gyyYBs", "(J)Landroid/graphics/PointF;", "CachedPositionAndSize", "Primary", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlideNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    private Alignment alignment;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Job currentJob;
    private CachedPositionAndSize drawablePositionAndSize;
    private Painter errorPlaceholder;
    private boolean hasFixedSize;
    private Size inferredGlideSize;
    private Painter loadingPlaceholder;
    private Painter placeholder;
    private CachedPositionAndSize placeholderPositionAndSize;
    private Primary primary;
    private RequestBuilder<Drawable> requestBuilder;
    private RequestListener requestListener;
    private ResolvableGlideSize resolvableGlideSize;
    private float alpha = 1.0f;
    private Transition.Factory transitionFactory = DoNotTransition.Factory.INSTANCE;
    private boolean draw = true;
    private RequestState state = RequestState.Loading.INSTANCE;
    private boolean isFirstResource = true;
    private Transition transition = DoNotTransition.INSTANCE;

    /* JADX INFO: renamed from: callback$delegate, reason: from kotlin metadata */
    private final Lazy callback = LazyKt.lazy(new Function0<GlideNode$callback$2.AnonymousClass1>() { // from class: com.bumptech.glide.integration.compose.GlideNode$callback$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.bumptech.glide.integration.compose.GlideNode$callback$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final GlideNode glideNode = this.this$0;
            return new Drawable.Callback() { // from class: com.bumptech.glide.integration.compose.GlideNode$callback$2.1
                @Override // android.graphics.drawable.Drawable.Callback
                public void invalidateDrawable(Drawable d) {
                    Intrinsics.checkNotNullParameter(d, "d");
                    DrawModifierNodeKt.invalidateDraw(glideNode);
                }

                @Override // android.graphics.drawable.Drawable.Callback
                public void scheduleDrawable(Drawable d, Runnable what, long time) {
                    Intrinsics.checkNotNullParameter(d, "d");
                    Intrinsics.checkNotNullParameter(what, "what");
                    GlideModifierKt.getMAIN_HANDLER().postAtTime(what, time);
                }

                @Override // android.graphics.drawable.Drawable.Callback
                public void unscheduleDrawable(Drawable d, Runnable what) {
                    Intrinsics.checkNotNullParameter(d, "d");
                    Intrinsics.checkNotNullParameter(what, "what");
                    GlideModifierKt.getMAIN_HANDLER().removeCallbacks(what);
                }
            };
        }
    });

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    private final Drawable.Callback getCallback() {
        return (Drawable.Callback) this.callback.getValue();
    }

    private final ImmediateGlideSize maybeImmediateSize(RequestBuilder<?> requestBuilder) {
        Size sizeOverrideSize = SizesKt.overrideSize(requestBuilder);
        if (sizeOverrideSize != null) {
            return new ImmediateGlideSize(sizeOverrideSize);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    public final void onNewRequest(RequestBuilder<Drawable> requestBuilder, ContentScale contentScale, Alignment alignment, Float alpha, ColorFilter colorFilter, RequestListener requestListener, Boolean draw, Transition.Factory transitionFactory, Painter loadingPlaceholder, Painter errorPlaceholder) {
        boolean z;
        AsyncGlideSize asyncGlideSize;
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        RequestBuilder<Drawable> requestBuilder2 = this.requestBuilder;
        if (requestBuilder2 == null) {
            z = true;
        } else {
            if (requestBuilder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestBuilder");
                requestBuilder2 = null;
            }
            if (Intrinsics.areEqual(requestBuilder, requestBuilder2) && Intrinsics.areEqual(loadingPlaceholder, this.loadingPlaceholder) && Intrinsics.areEqual(errorPlaceholder, this.errorPlaceholder)) {
                z = false;
            } else {
                z = true;
            }
        }
        this.requestBuilder = requestBuilder;
        this.contentScale = contentScale;
        this.alignment = alignment;
        this.alpha = alpha != null ? alpha.floatValue() : 1.0f;
        this.colorFilter = colorFilter;
        this.requestListener = requestListener;
        this.draw = draw != null ? draw.booleanValue() : true;
        if (transitionFactory == null) {
            transitionFactory = DoNotTransition.Factory.INSTANCE;
        }
        this.transitionFactory = transitionFactory;
        this.loadingPlaceholder = loadingPlaceholder;
        this.errorPlaceholder = errorPlaceholder;
        ImmediateGlideSize immediateGlideSizeMaybeImmediateSize = maybeImmediateSize(requestBuilder);
        if (immediateGlideSizeMaybeImmediateSize != null) {
            asyncGlideSize = immediateGlideSizeMaybeImmediateSize;
        } else {
            Size size = this.inferredGlideSize;
            ImmediateGlideSize immediateGlideSize = size != null ? new ImmediateGlideSize(size) : null;
            if (immediateGlideSize != null) {
                asyncGlideSize = immediateGlideSize;
            } else {
                asyncGlideSize = new AsyncGlideSize();
            }
        }
        this.resolvableGlideSize = asyncGlideSize;
        if (z) {
            clear();
            updatePrimary(null);
            if (getIsAttached()) {
                launchRequest(requestBuilder);
                return;
            }
            return;
        }
        DrawModifierNodeKt.invalidateDraw(this);
    }

    private final boolean isValidDimension(float f) {
        return (f <= 0.0f || Float.isInfinite(f) || Float.isNaN(f)) ? false : true;
    }

    /* JADX INFO: renamed from: isValid-uvyYCjk, reason: not valid java name */
    private final boolean m13151isValiduvyYCjk(long j) {
        return m13153isValidWidthuvyYCjk(j) && m13152isValidHeightuvyYCjk(j);
    }

    /* JADX INFO: renamed from: roundToInt-OLKMvJU, reason: not valid java name */
    private final long m13155roundToIntOLKMvJU(long j) {
        return IntSizeKt.IntSize(MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6638getWidthimpl(j)), MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6635getHeightimpl(j)));
    }

    /* JADX INFO: renamed from: toPointF--gyyYBs, reason: not valid java name */
    private final PointF m13156toPointFgyyYBs(long j) {
        return new PointF(IntOffset.m9815getXimpl(j), IntOffset.m9816getYimpl(j));
    }

    /* JADX INFO: compiled from: GlideModifier.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\nJ*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideNode$CachedPositionAndSize;", "", ViewProps.POSITION, "Landroid/graphics/PointF;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroid/graphics/PointF;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPosition", "()Landroid/graphics/PointF;", "getSize-NH-jbRc", "()J", "J", "component1", "component2", "component2-NH-jbRc", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-d16Qtg0", "(Landroid/graphics/PointF;J)Lcom/bumptech/glide/integration/compose/GlideNode$CachedPositionAndSize;", "equals", "", "other", "hashCode", "", "toString", "", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CachedPositionAndSize {
        private final PointF position;
        private final long size;

        public /* synthetic */ CachedPositionAndSize(PointF pointF, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(pointF, j);
        }

        /* JADX INFO: renamed from: copy-d16Qtg0$default, reason: not valid java name */
        public static /* synthetic */ CachedPositionAndSize m13157copyd16Qtg0$default(CachedPositionAndSize cachedPositionAndSize, PointF pointF, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                pointF = cachedPositionAndSize.position;
            }
            if ((i & 2) != 0) {
                j = cachedPositionAndSize.size;
            }
            return cachedPositionAndSize.m13159copyd16Qtg0(pointF, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PointF getPosition() {
            return this.position;
        }

        /* JADX INFO: renamed from: component2-NH-jbRc, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: copy-d16Qtg0, reason: not valid java name */
        public final CachedPositionAndSize m13159copyd16Qtg0(PointF position, long size) {
            Intrinsics.checkNotNullParameter(position, "position");
            return new CachedPositionAndSize(position, size, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedPositionAndSize)) {
                return false;
            }
            CachedPositionAndSize cachedPositionAndSize = (CachedPositionAndSize) other;
            return Intrinsics.areEqual(this.position, cachedPositionAndSize.position) && androidx.compose.ui.geometry.Size.m6634equalsimpl0(this.size, cachedPositionAndSize.size);
        }

        public int hashCode() {
            return (this.position.hashCode() * 31) + androidx.compose.ui.geometry.Size.m6639hashCodeimpl(this.size);
        }

        public String toString() {
            return "CachedPositionAndSize(position=" + this.position + ", size=" + ((Object) androidx.compose.ui.geometry.Size.m6642toStringimpl(this.size)) + ')';
        }

        private CachedPositionAndSize(PointF position, long j) {
            Intrinsics.checkNotNullParameter(position, "position");
            this.position = position;
            this.size = j;
        }

        public final PointF getPosition() {
            return this.position;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m13160getSizeNHjbRc() {
            return this.size;
        }
    }

    private final CachedPositionAndSize drawOne(ContentDrawScope contentDrawScope, Painter painter, CachedPositionAndSize cachedPositionAndSize, Function2<? super DrawScope, ? super androidx.compose.ui.geometry.Size, Unit> function2) {
        float fM6638getWidthimpl;
        float fM6635getHeightimpl;
        long jM6647getZeroNHjbRc;
        Alignment alignment;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (painter == null) {
            return null;
        }
        if (cachedPositionAndSize == null) {
            if (m13153isValidWidthuvyYCjk(painter.getDrawableIntrinsicSize())) {
                fM6638getWidthimpl = androidx.compose.ui.geometry.Size.m6638getWidthimpl(painter.getDrawableIntrinsicSize());
            } else {
                fM6638getWidthimpl = androidx.compose.ui.geometry.Size.m6638getWidthimpl(contentDrawScope.mo7395getSizeNHjbRc());
            }
            if (m13152isValidHeightuvyYCjk(painter.getDrawableIntrinsicSize())) {
                fM6635getHeightimpl = androidx.compose.ui.geometry.Size.m6635getHeightimpl(painter.getDrawableIntrinsicSize());
            } else {
                fM6635getHeightimpl = androidx.compose.ui.geometry.Size.m6635getHeightimpl(contentDrawScope.mo7395getSizeNHjbRc());
            }
            long jSize = SizeKt.Size(fM6638getWidthimpl, fM6635getHeightimpl);
            if (m13151isValiduvyYCjk(contentDrawScope.mo7395getSizeNHjbRc())) {
                ContentScale contentScale = this.contentScale;
                if (contentScale == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentScale");
                    contentScale = null;
                }
                jM6647getZeroNHjbRc = ScaleFactorKt.m8397timesmw2e94(contentScale.mo8258computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo7395getSizeNHjbRc()), jSize);
            } else {
                jM6647getZeroNHjbRc = androidx.compose.ui.geometry.Size.INSTANCE.m6647getZeroNHjbRc();
            }
            Alignment alignment2 = this.alignment;
            if (alignment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("alignment");
                alignment = null;
            } else {
                alignment = alignment2;
            }
            cachedPositionAndSize = new CachedPositionAndSize(m13156toPointFgyyYBs(alignment.mo6288alignKFBX0sM(m13155roundToIntOLKMvJU(jM6647getZeroNHjbRc), m13155roundToIntOLKMvJU(contentDrawScope.mo7395getSizeNHjbRc()), contentDrawScope.getLayoutDirection())), jM6647getZeroNHjbRc, defaultConstructorMarker);
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float fM6638getWidthimpl2 = androidx.compose.ui.geometry.Size.m6638getWidthimpl(contentDrawScope2.mo7395getSizeNHjbRc());
        float fM6635getHeightimpl2 = androidx.compose.ui.geometry.Size.m6635getHeightimpl(contentDrawScope2.mo7395getSizeNHjbRc());
        int iM6803getIntersectrtfAjoo = ClipOp.INSTANCE.m6803getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo7319clipRectN_I0leg(0.0f, 0.0f, fM6638getWidthimpl2, fM6635getHeightimpl2, iM6803getIntersectrtfAjoo);
        float f = cachedPositionAndSize.getPosition().x;
        float f2 = cachedPositionAndSize.getPosition().y;
        contentDrawScope2.getDrawContext().getTransform().translate(f, f2);
        function2.invoke(contentDrawScope2, androidx.compose.ui.geometry.Size.m6626boximpl(cachedPositionAndSize.m13160getSizeNHjbRc()));
        contentDrawScope2.getDrawContext().getTransform().translate(-f, -f2);
        drawContext.getCanvas().restore();
        drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        return cachedPositionAndSize;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        final Painter painter;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        if (this.draw) {
            final Function5<DrawScope, Painter, androidx.compose.ui.geometry.Size, Float, ColorFilter, Unit> drawPlaceholder = this.transition.getDrawPlaceholder();
            if (drawPlaceholder == null) {
                drawPlaceholder = DoNotTransition.INSTANCE.getDrawPlaceholder();
            }
            final Painter painter2 = this.placeholder;
            if (painter2 != null) {
                Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
                try {
                    canvas.save();
                    this.placeholderPositionAndSize = drawOne(contentDrawScope, painter2, this.placeholderPositionAndSize, new Function2<DrawScope, androidx.compose.ui.geometry.Size, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideNode$draw$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, androidx.compose.ui.geometry.Size size) {
                            m13162invoked16Qtg0(drawScope, size.m6643unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-d16Qtg0, reason: not valid java name */
                        public final void m13162invoked16Qtg0(DrawScope drawOne, long j) {
                            Intrinsics.checkNotNullParameter(drawOne, "$this$drawOne");
                            drawPlaceholder.invoke(drawOne, painter2, androidx.compose.ui.geometry.Size.m6626boximpl(j), Float.valueOf(this.alpha), this.colorFilter);
                        }
                    });
                    canvas.restore();
                } catch (Throwable th) {
                    canvas.restore();
                    throw th;
                }
            }
            Primary primary = this.primary;
            if (primary != null && (painter = primary.getPainter()) != null) {
                Canvas canvas2 = contentDrawScope.getDrawContext().getCanvas();
                try {
                    canvas2.save();
                    this.drawablePositionAndSize = drawOne(contentDrawScope, painter, this.drawablePositionAndSize, new Function2<DrawScope, androidx.compose.ui.geometry.Size, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideNode$draw$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope, androidx.compose.ui.geometry.Size size) {
                            m13163invoked16Qtg0(drawScope, size.m6643unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-d16Qtg0, reason: not valid java name */
                        public final void m13163invoked16Qtg0(DrawScope drawOne, long j) {
                            Intrinsics.checkNotNullParameter(drawOne, "$this$drawOne");
                            this.this$0.transition.getDrawCurrent().invoke(drawOne, painter, androidx.compose.ui.geometry.Size.m6626boximpl(j), Float.valueOf(this.this$0.alpha), this.this$0.colorFilter);
                        }
                    });
                    canvas2.restore();
                } catch (Throwable th2) {
                    canvas2.restore();
                    throw th2;
                }
            }
        }
        contentDrawScope.drawContent();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        if (this.currentJob == null) {
            RequestBuilder<Drawable> requestBuilder = this.requestBuilder;
            if (requestBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestBuilder");
                requestBuilder = null;
            }
            launchRequest(requestBuilder);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        clear();
        updatePrimary(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeAnimate(CoroutineScope coroutineScope, Resource<Drawable> resource) {
        if (resource.getDataSource() == DataSource.MEMORY_CACHE || !this.isFirstResource || Intrinsics.areEqual(this.transitionFactory, DoNotTransition.Factory.INSTANCE)) {
            this.isFirstResource = false;
            this.transition = DoNotTransition.INSTANCE;
        } else {
            this.isFirstResource = false;
            this.transition = this.transitionFactory.build();
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C17371(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.GlideNode$maybeAnimate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlideModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.compose.GlideNode$maybeAnimate$1", f = "GlideModifier.kt", i = {}, l = {385}, m = "invokeSuspend", n = {}, s = {})
    static final class C17371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17371(Continuation<? super C17371> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlideNode.this.new C17371(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17371) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Transition transition = GlideNode.this.transition;
                final GlideNode glideNode = GlideNode.this;
                this.label = 1;
                if (transition.transition(new Function0<Unit>() { // from class: com.bumptech.glide.integration.compose.GlideNode.maybeAnimate.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DrawModifierNodeKt.invalidateDraw(glideNode);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void launchRequest(final RequestBuilder<Drawable> requestBuilder) {
        sideEffect(new Function0<Unit>() { // from class: com.bumptech.glide.integration.compose.GlideNode.launchRequest.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RequestBuilder requestBuilder2 = GlideNode.this.requestBuilder;
                if (requestBuilder2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("requestBuilder");
                    requestBuilder2 = null;
                }
                if (Intrinsics.areEqual(requestBuilder2, requestBuilder)) {
                    Preconditions.checkArgument(GlideNode.this.currentJob == null);
                    GlideNode glideNode = GlideNode.this;
                    glideNode.currentJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.plus(glideNode.getCoroutineScope(), Dispatchers.getMain().getImmediate()), null, null, new C01951(GlideNode.this, requestBuilder, null), 3, null);
                }
            }

            /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.GlideNode$launchRequest$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: GlideModifier.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.bumptech.glide.integration.compose.GlideNode$launchRequest$1$1", f = "GlideModifier.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
            static final class C01951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ RequestBuilder<Drawable> $requestBuilder;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ GlideNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01951(GlideNode glideNode, RequestBuilder<Drawable> requestBuilder, Continuation<? super C01951> continuation) {
                    super(2, continuation);
                    this.this$0 = glideNode;
                    this.$requestBuilder = requestBuilder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C01951 c01951 = new C01951(this.this$0, this.$requestBuilder, continuation);
                    c01951.L$0 = obj;
                    return c01951;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        ResolvableGlideSize resolvableGlideSize = null;
                        this.this$0.placeholder = null;
                        this.this$0.placeholderPositionAndSize = null;
                        RequestBuilder<Drawable> requestBuilder = this.$requestBuilder;
                        ResolvableGlideSize resolvableGlideSize2 = this.this$0.resolvableGlideSize;
                        if (resolvableGlideSize2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("resolvableGlideSize");
                        } else {
                            resolvableGlideSize = resolvableGlideSize2;
                        }
                        Flow flowFlowResolvable = FlowsKt.flowResolvable(requestBuilder, resolvableGlideSize);
                        final GlideNode glideNode = this.this$0;
                        final RequestBuilder<Drawable> requestBuilder2 = this.$requestBuilder;
                        this.label = 1;
                        if (flowFlowResolvable.collect(new FlowCollector<GlideFlowInstant<Drawable>>() { // from class: com.bumptech.glide.integration.compose.GlideNode.launchRequest.1.1.1

                            /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.GlideNode$launchRequest$1$1$1$WhenMappings */
                            /* JADX INFO: compiled from: GlideModifier.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[Status.values().length];
                                    try {
                                        iArr[Status.RUNNING.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[Status.CLEARED.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[Status.FAILED.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    try {
                                        iArr[Status.SUCCEEDED.ordinal()] = 4;
                                    } catch (NoSuchFieldError unused4) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(GlideFlowInstant<Drawable> glideFlowInstant, Continuation continuation) {
                                return emit2(glideFlowInstant, (Continuation<? super Unit>) continuation);
                            }

                            /* JADX INFO: renamed from: emit, reason: avoid collision after fix types in other method */
                            public final Object emit2(GlideFlowInstant<Drawable> glideFlowInstant, Continuation<? super Unit> continuation) {
                                RequestState.Loading loading;
                                Painter painter;
                                Primary.PrimaryDrawable primaryDrawable;
                                Pair pair;
                                if (glideFlowInstant instanceof Resource) {
                                    Resource resource = (Resource) glideFlowInstant;
                                    glideNode.maybeAnimate(coroutineScope, resource);
                                    pair = new Pair(new RequestState.Success(resource.getDataSource()), new Primary.PrimaryDrawable((Drawable) resource.getResource()));
                                } else if (glideFlowInstant instanceof com.bumptech.glide.integration.ktx.Placeholder) {
                                    int i2 = WhenMappings.$EnumSwitchMapping$0[glideFlowInstant.getStatus().ordinal()];
                                    if (i2 == 1 || i2 == 2) {
                                        loading = RequestState.Loading.INSTANCE;
                                    } else {
                                        if (i2 != 3) {
                                            if (i2 != 4) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            throw new IllegalStateException();
                                        }
                                        loading = RequestState.Failure.INSTANCE;
                                    }
                                    if (loading instanceof RequestState.Loading) {
                                        painter = glideNode.loadingPlaceholder;
                                    } else if (loading instanceof RequestState.Failure) {
                                        painter = glideNode.errorPlaceholder;
                                    } else {
                                        if (loading instanceof RequestState.Success) {
                                            throw new IllegalStateException();
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    if (painter != null) {
                                        primaryDrawable = new Primary.PrimaryPainter(painter);
                                    } else {
                                        primaryDrawable = new Primary.PrimaryDrawable(((com.bumptech.glide.integration.ktx.Placeholder) glideFlowInstant).getPlaceholder());
                                    }
                                    glideNode.placeholder = primaryDrawable.getPainter();
                                    glideNode.placeholderPositionAndSize = null;
                                    pair = new Pair(loading, primaryDrawable);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                RequestState requestState = (RequestState) pair.component1();
                                Primary primary = (Primary) pair.component2();
                                glideNode.updatePrimary(primary);
                                RequestListener requestListener = glideNode.requestListener;
                                if (requestListener != null) {
                                    requestListener.onStateChanged(ModelExtractorKt.getInternalModel(requestBuilder2), primary.getPainter(), requestState);
                                }
                                glideNode.state = requestState;
                                if (glideNode.hasFixedSize) {
                                    DrawModifierNodeKt.invalidateDraw(glideNode);
                                } else {
                                    LayoutModifierNodeKt.invalidateMeasurement(glideNode);
                                }
                                return Unit.INSTANCE;
                            }
                        }, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX INFO: compiled from: GlideModifier.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\fH&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideNode$Primary;", "", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "onSet", "", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "onUnset", "PrimaryDrawable", "PrimaryPainter", "Lcom/bumptech/glide/integration/compose/GlideNode$Primary$PrimaryDrawable;", "Lcom/bumptech/glide/integration/compose/GlideNode$Primary$PrimaryPainter;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static abstract class Primary {
        public /* synthetic */ Primary(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Drawable getDrawable();

        public abstract Painter getPainter();

        public abstract void onSet(Drawable.Callback callback);

        public abstract void onUnset();

        /* JADX INFO: compiled from: GlideModifier.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideNode$Primary$PrimaryDrawable;", "Lcom/bumptech/glide/integration/compose/GlideNode$Primary;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "onSet", "", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "onUnset", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PrimaryDrawable extends Primary {
            public static final int $stable = 8;
            private final Drawable drawable;
            private final Painter painter;

            /* JADX WARN: Multi-variable type inference failed */
            public PrimaryDrawable(Drawable drawable) {
                super(0 == true ? 1 : 0);
                this.drawable = drawable;
                Drawable drawable2 = getDrawable();
                this.painter = drawable2 != null ? PainterKt.toPainter(drawable2) : null;
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public Drawable getDrawable() {
                return this.drawable;
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public Painter getPainter() {
                return this.painter;
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public void onUnset() {
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    drawable.setCallback(null);
                }
                Drawable drawable2 = getDrawable();
                if (drawable2 != null) {
                    drawable2.setVisible(false, false);
                }
                Object drawable3 = getDrawable();
                Animatable animatable = drawable3 instanceof Animatable ? (Animatable) drawable3 : null;
                if (animatable != null) {
                    animatable.stop();
                }
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public void onSet(Drawable.Callback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    drawable.setCallback(callback);
                }
                Drawable drawable2 = getDrawable();
                if (drawable2 != null) {
                    drawable2.setVisible(true, true);
                }
                Object drawable3 = getDrawable();
                Animatable animatable = drawable3 instanceof Animatable ? (Animatable) drawable3 : null;
                if (animatable != null) {
                    animatable.start();
                }
            }
        }

        private Primary() {
        }

        /* JADX INFO: compiled from: GlideModifier.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideNode$Primary$PrimaryPainter;", "Lcom/bumptech/glide/integration/compose/GlideNode$Primary;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "drawable", "", "getDrawable", "()Ljava/lang/Void;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "onSet", "", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "onUnset", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class PrimaryPainter extends Primary {
            public static final int $stable = 8;
            private final Void drawable;
            private final Painter painter;

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public void onSet(Drawable.Callback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public void onUnset() {
            }

            public PrimaryPainter(Painter painter) {
                super(null);
                this.painter = painter;
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public /* bridge */ /* synthetic */ Drawable getDrawable() {
                return (Drawable) getDrawable();
            }

            @Override // com.bumptech.glide.integration.compose.GlideNode.Primary
            public Painter getPainter() {
                return this.painter;
            }

            public Void getDrawable() {
                return this.drawable;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePrimary(Primary newPrimary) {
        Primary primary = this.primary;
        if (primary != null) {
            primary.onUnset();
        }
        this.primary = newPrimary;
        if (newPrimary != null) {
            newPrimary.onSet(getCallback());
        }
        this.drawablePositionAndSize = null;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        clear();
        if (Intrinsics.areEqual(this.transition, DoNotTransition.INSTANCE)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C17381(null), 3, null);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.integration.compose.GlideNode$onDetach$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlideModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.bumptech.glide.integration.compose.GlideNode$onDetach$1", f = "GlideModifier.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
    static final class C17381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C17381(Continuation<? super C17381> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GlideNode.this.new C17381(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17381) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GlideNode.this.transition.stop(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void clear() {
        this.isFirstResource = true;
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.currentJob = null;
        this.state = RequestState.Loading.INSTANCE;
        updatePrimary(null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo372measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        ResolvableGlideSize resolvableGlideSize = null;
        this.placeholderPositionAndSize = null;
        this.drawablePositionAndSize = null;
        this.hasFixedSize = m13150hasFixedSizeBRTryo0(j);
        this.inferredGlideSize = SizesKt.m13172inferredGlideSizeBRTryo0(j);
        ResolvableGlideSize resolvableGlideSize2 = this.resolvableGlideSize;
        if (resolvableGlideSize2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resolvableGlideSize");
        } else {
            resolvableGlideSize = resolvableGlideSize2;
        }
        if (resolvableGlideSize instanceof AsyncGlideSize) {
            Size size = this.inferredGlideSize;
            if (size != null) {
                ((AsyncGlideSize) resolvableGlideSize).setSize(size);
            }
        } else {
            boolean z = resolvableGlideSize instanceof ImmediateGlideSize;
        }
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(m13154modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measure, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideNode$measure$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, placeableMo8265measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: renamed from: hasFixedSize-BRTryo0, reason: not valid java name */
    private final boolean m13150hasFixedSizeBRTryo0(long j) {
        return Constraints.m9638getHasFixedWidthimpl(j) && Constraints.m9637getHasFixedHeightimpl(j);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m13154modifyConstraintsZezNO4M(long constraints) {
        Painter painter;
        int iM9642getMinWidthimpl;
        int iM9641getMinHeightimpl;
        if (m13150hasFixedSizeBRTryo0(constraints)) {
            return Constraints.m9630copyZbe2FdA$default(constraints, Constraints.m9640getMaxWidthimpl(constraints), 0, Constraints.m9639getMaxHeightimpl(constraints), 0, 10, null);
        }
        Primary primary = this.primary;
        if (primary != null && (painter = primary.getPainter()) != null) {
            long drawableIntrinsicSize = painter.getDrawableIntrinsicSize();
            if (Constraints.m9638getHasFixedWidthimpl(constraints)) {
                iM9642getMinWidthimpl = Constraints.m9640getMaxWidthimpl(constraints);
            } else if (m13153isValidWidthuvyYCjk(drawableIntrinsicSize)) {
                iM9642getMinWidthimpl = MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6638getWidthimpl(drawableIntrinsicSize));
            } else {
                iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(constraints);
            }
            if (Constraints.m9637getHasFixedHeightimpl(constraints)) {
                iM9641getMinHeightimpl = Constraints.m9639getMaxHeightimpl(constraints);
            } else if (m13152isValidHeightuvyYCjk(drawableIntrinsicSize)) {
                iM9641getMinHeightimpl = MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6635getHeightimpl(drawableIntrinsicSize));
            } else {
                iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(constraints);
            }
            int iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(constraints, iM9642getMinWidthimpl);
            int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(constraints, iM9641getMinHeightimpl);
            long jSize = SizeKt.Size(iM9642getMinWidthimpl, iM9641getMinHeightimpl);
            ContentScale contentScale = this.contentScale;
            if (contentScale == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentScale");
                contentScale = null;
            }
            long jMo8258computeScaleFactorH7hwNQA = contentScale.mo8258computeScaleFactorH7hwNQA(jSize, SizeKt.Size(iM9657constrainWidthK40F9xA, iM9656constrainHeightK40F9xA));
            if (!ScaleFactor.m8380equalsimpl0(jMo8258computeScaleFactorH7hwNQA, ScaleFactor.INSTANCE.m8388getUnspecified_hLwfpc())) {
                long jM8396timesUQTWf7w = ScaleFactorKt.m8396timesUQTWf7w(jSize, jMo8258computeScaleFactorH7hwNQA);
                return Constraints.m9630copyZbe2FdA$default(constraints, ConstraintsKt.m9657constrainWidthK40F9xA(constraints, MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6638getWidthimpl(jM8396timesUQTWf7w))), 0, ConstraintsKt.m9656constrainHeightK40F9xA(constraints, MathKt.roundToInt(androidx.compose.ui.geometry.Size.m6635getHeightimpl(jM8396timesUQTWf7w))), 0, 10, null);
            }
        }
        return constraints;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        GlideModifierKt.setDisplayedDrawable(semanticsPropertyReceiver, new Function0<Drawable>() { // from class: com.bumptech.glide.integration.compose.GlideNode.applySemantics.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                Primary primary = GlideNode.this.primary;
                if (primary != null) {
                    return primary.getDrawable();
                }
                return null;
            }
        });
        GlideModifierKt.setDisplayedPainter(semanticsPropertyReceiver, new Function0<Painter>() { // from class: com.bumptech.glide.integration.compose.GlideNode.applySemantics.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Painter invoke() {
                Primary primary = GlideNode.this.primary;
                if (primary != null) {
                    return primary.getPainter();
                }
                return null;
            }
        });
    }

    public boolean equals(Object other) {
        if (other instanceof GlideNode) {
            RequestBuilder<Drawable> requestBuilder = this.requestBuilder;
            Alignment alignment = null;
            if (requestBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestBuilder");
                requestBuilder = null;
            }
            GlideNode glideNode = (GlideNode) other;
            RequestBuilder<Drawable> requestBuilder2 = glideNode.requestBuilder;
            if (requestBuilder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("requestBuilder");
                requestBuilder2 = null;
            }
            if (Intrinsics.areEqual(requestBuilder, requestBuilder2)) {
                ContentScale contentScale = this.contentScale;
                if (contentScale == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentScale");
                    contentScale = null;
                }
                ContentScale contentScale2 = glideNode.contentScale;
                if (contentScale2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentScale");
                    contentScale2 = null;
                }
                if (Intrinsics.areEqual(contentScale, contentScale2)) {
                    Alignment alignment2 = this.alignment;
                    if (alignment2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("alignment");
                        alignment2 = null;
                    }
                    Alignment alignment3 = glideNode.alignment;
                    if (alignment3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("alignment");
                    } else {
                        alignment = alignment3;
                    }
                    if (Intrinsics.areEqual(alignment2, alignment) && Intrinsics.areEqual(this.colorFilter, glideNode.colorFilter) && Intrinsics.areEqual(this.requestListener, glideNode.requestListener) && this.draw == glideNode.draw && Intrinsics.areEqual(this.transitionFactory, glideNode.transitionFactory) && this.alpha == glideNode.alpha && Intrinsics.areEqual(this.loadingPlaceholder, glideNode.loadingPlaceholder) && Intrinsics.areEqual(this.errorPlaceholder, glideNode.errorPlaceholder)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        RequestBuilder<Drawable> requestBuilder = this.requestBuilder;
        Alignment alignment = null;
        if (requestBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBuilder");
            requestBuilder = null;
        }
        int iHashCode = requestBuilder.hashCode() * 31;
        ContentScale contentScale = this.contentScale;
        if (contentScale == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentScale");
            contentScale = null;
        }
        int iHashCode2 = (iHashCode + contentScale.hashCode()) * 31;
        Alignment alignment2 = this.alignment;
        if (alignment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alignment");
        } else {
            alignment = alignment2;
        }
        int iHashCode3 = (iHashCode2 + alignment.hashCode()) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int iHashCode4 = (((iHashCode3 + (colorFilter != null ? colorFilter.hashCode() : 0)) * 31) + Boolean.hashCode(this.draw)) * 31;
        RequestListener requestListener = this.requestListener;
        int iHashCode5 = (((((iHashCode4 + (requestListener != null ? requestListener.hashCode() : 0)) * 31) + this.transitionFactory.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        Painter painter = this.loadingPlaceholder;
        int iHashCode6 = (iHashCode5 + (painter != null ? painter.hashCode() : 0)) * 31;
        Painter painter2 = this.errorPlaceholder;
        return iHashCode6 + (painter2 != null ? painter2.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isValidWidth-uvyYCjk, reason: not valid java name */
    private final boolean m13153isValidWidthuvyYCjk(long j) {
        return j != androidx.compose.ui.geometry.Size.INSTANCE.m6646getUnspecifiedNHjbRc() && isValidDimension(androidx.compose.ui.geometry.Size.m6638getWidthimpl(j));
    }

    /* JADX INFO: renamed from: isValidHeight-uvyYCjk, reason: not valid java name */
    private final boolean m13152isValidHeightuvyYCjk(long j) {
        return j != androidx.compose.ui.geometry.Size.INSTANCE.m6646getUnspecifiedNHjbRc() && isValidDimension(androidx.compose.ui.geometry.Size.m6635getHeightimpl(j));
    }
}

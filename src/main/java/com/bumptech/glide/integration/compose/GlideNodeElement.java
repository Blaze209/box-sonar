package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.bumptech.glide.ModelExtractorKt;
import com.bumptech.glide.RequestBuilder;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideModifier.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bi\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÂ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0015HÂ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÂ\u0003J\t\u0010\u001d\u001a\u00020\tHÂ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÂ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010 \u001a\u0004\u0018\u00010\rHÂ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000fHÂ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0011HÂ\u0003¢\u0006\u0002\u0010#J\u000b\u0010$\u001a\u0004\u0018\u00010\u0013HÂ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0015HÂ\u0003J\u0086\u0001\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0002H\u0016J\u0013\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0002H\u0016J\f\u00103\u001a\u000201*\u000204H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bumptech/glide/integration/compose/GlideNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/bumptech/glide/integration/compose/GlideNode;", "requestBuilder", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "requestListener", "Lcom/bumptech/glide/integration/compose/RequestListener;", "draw", "", "transitionFactory", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "loadingPlaceholder", "Landroidx/compose/ui/graphics/painter/Painter;", "errorPlaceholder", "(Lcom/bumptech/glide/RequestBuilder;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;Ljava/lang/Float;Landroidx/compose/ui/graphics/ColorFilter;Lcom/bumptech/glide/integration/compose/RequestListener;Ljava/lang/Boolean;Lcom/bumptech/glide/integration/compose/Transition$Factory;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)V", "Ljava/lang/Float;", "Ljava/lang/Boolean;", "component1", "component10", "component2", "component3", "component4", "()Ljava/lang/Float;", "component5", "component6", "component7", "()Ljava/lang/Boolean;", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/bumptech/glide/RequestBuilder;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;Ljava/lang/Float;Landroidx/compose/ui/graphics/ColorFilter;Lcom/bumptech/glide/integration/compose/RequestListener;Ljava/lang/Boolean;Lcom/bumptech/glide/integration/compose/Transition$Factory;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)Lcom/bumptech/glide/integration/compose/GlideNodeElement;", PasskeyWebListener.CREATE_UNIQUE_KEY, "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GlideNodeElement extends ModifierNodeElement<GlideNode> {
    private final Alignment alignment;
    private final Float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Boolean draw;
    private final Painter errorPlaceholder;
    private final Painter loadingPlaceholder;
    private final RequestBuilder<Drawable> requestBuilder;
    private final RequestListener requestListener;
    private final Transition.Factory transitionFactory;

    private final RequestBuilder<Drawable> component1() {
        return this.requestBuilder;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    private final Painter getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    private final RequestListener getRequestListener() {
        return this.requestListener;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    private final Boolean getDraw() {
        return this.draw;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final Painter getLoadingPlaceholder() {
        return this.loadingPlaceholder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlideNodeElement copy$default(GlideNodeElement glideNodeElement, RequestBuilder requestBuilder, ContentScale contentScale, Alignment alignment, Float f, ColorFilter colorFilter, RequestListener requestListener, Boolean bool, Transition.Factory factory, Painter painter, Painter painter2, int i, Object obj) {
        if ((i & 1) != 0) {
            requestBuilder = glideNodeElement.requestBuilder;
        }
        if ((i & 2) != 0) {
            contentScale = glideNodeElement.contentScale;
        }
        if ((i & 4) != 0) {
            alignment = glideNodeElement.alignment;
        }
        if ((i & 8) != 0) {
            f = glideNodeElement.alpha;
        }
        if ((i & 16) != 0) {
            colorFilter = glideNodeElement.colorFilter;
        }
        if ((i & 32) != 0) {
            requestListener = glideNodeElement.requestListener;
        }
        if ((i & 64) != 0) {
            bool = glideNodeElement.draw;
        }
        if ((i & 128) != 0) {
            factory = glideNodeElement.transitionFactory;
        }
        if ((i & 256) != 0) {
            painter = glideNodeElement.loadingPlaceholder;
        }
        if ((i & 512) != 0) {
            painter2 = glideNodeElement.errorPlaceholder;
        }
        Painter painter3 = painter;
        Painter painter4 = painter2;
        Boolean bool2 = bool;
        Transition.Factory factory2 = factory;
        ColorFilter colorFilter2 = colorFilter;
        RequestListener requestListener2 = requestListener;
        return glideNodeElement.copy(requestBuilder, contentScale, alignment, f, colorFilter2, requestListener2, bool2, factory2, painter3, painter4);
    }

    public final GlideNodeElement copy(RequestBuilder<Drawable> requestBuilder, ContentScale contentScale, Alignment alignment, Float alpha, ColorFilter colorFilter, RequestListener requestListener, Boolean draw, Transition.Factory transitionFactory, Painter loadingPlaceholder, Painter errorPlaceholder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new GlideNodeElement(requestBuilder, contentScale, alignment, alpha, colorFilter, requestListener, draw, transitionFactory, loadingPlaceholder, errorPlaceholder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlideNodeElement)) {
            return false;
        }
        GlideNodeElement glideNodeElement = (GlideNodeElement) other;
        return Intrinsics.areEqual(this.requestBuilder, glideNodeElement.requestBuilder) && Intrinsics.areEqual(this.contentScale, glideNodeElement.contentScale) && Intrinsics.areEqual(this.alignment, glideNodeElement.alignment) && Intrinsics.areEqual((Object) this.alpha, (Object) glideNodeElement.alpha) && Intrinsics.areEqual(this.colorFilter, glideNodeElement.colorFilter) && Intrinsics.areEqual(this.requestListener, glideNodeElement.requestListener) && Intrinsics.areEqual(this.draw, glideNodeElement.draw) && Intrinsics.areEqual(this.transitionFactory, glideNodeElement.transitionFactory) && Intrinsics.areEqual(this.loadingPlaceholder, glideNodeElement.loadingPlaceholder) && Intrinsics.areEqual(this.errorPlaceholder, glideNodeElement.errorPlaceholder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((((this.requestBuilder.hashCode() * 31) + this.contentScale.hashCode()) * 31) + this.alignment.hashCode()) * 31;
        Float f = this.alpha;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        ColorFilter colorFilter = this.colorFilter;
        int iHashCode3 = (iHashCode2 + (colorFilter == null ? 0 : colorFilter.hashCode())) * 31;
        RequestListener requestListener = this.requestListener;
        int iHashCode4 = (iHashCode3 + (requestListener == null ? 0 : requestListener.hashCode())) * 31;
        Boolean bool = this.draw;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Transition.Factory factory = this.transitionFactory;
        int iHashCode6 = (iHashCode5 + (factory == null ? 0 : factory.hashCode())) * 31;
        Painter painter = this.loadingPlaceholder;
        int iHashCode7 = (iHashCode6 + (painter == null ? 0 : painter.hashCode())) * 31;
        Painter painter2 = this.errorPlaceholder;
        return iHashCode7 + (painter2 != null ? painter2.hashCode() : 0);
    }

    public String toString() {
        return "GlideNodeElement(requestBuilder=" + this.requestBuilder + ", contentScale=" + this.contentScale + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ", requestListener=" + this.requestListener + ", draw=" + this.draw + ", transitionFactory=" + this.transitionFactory + ", loadingPlaceholder=" + this.loadingPlaceholder + ", errorPlaceholder=" + this.errorPlaceholder + ')';
    }

    public GlideNodeElement(RequestBuilder<Drawable> requestBuilder, ContentScale contentScale, Alignment alignment, Float f, ColorFilter colorFilter, RequestListener requestListener, Boolean bool, Transition.Factory factory, Painter painter, Painter painter2) {
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.requestBuilder = requestBuilder;
        this.contentScale = contentScale;
        this.alignment = alignment;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.requestListener = requestListener;
        this.draw = bool;
        this.transitionFactory = factory;
        this.loadingPlaceholder = painter;
        this.errorPlaceholder = painter2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public GlideNode getNode() {
        GlideNode glideNode = new GlideNode();
        update(glideNode);
        return glideNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(GlideNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.onNewRequest(this.requestBuilder, this.contentScale, this.alignment, this.alpha, this.colorFilter, this.requestListener, this.draw, this.transitionFactory, this.loadingPlaceholder, this.errorPlaceholder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        String str;
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("GlideNode");
        inspectorInfo.getProperties().set("model", ModelExtractorKt.getInternalModel(this.requestBuilder));
        ValueElementSequence properties = inspectorInfo.getProperties();
        Object objOverrideSize = SizesKt.overrideSize(this.requestBuilder);
        if (objOverrideSize == null) {
            objOverrideSize = "LayoutBased";
        }
        properties.set("size", objOverrideSize);
        inspectorInfo.getProperties().set("alignment", this.alignment);
        inspectorInfo.getProperties().set("contentScale", this.contentScale);
        inspectorInfo.getProperties().set("colorFilter", this.colorFilter);
        inspectorInfo.getProperties().set("draw", this.draw);
        ValueElementSequence properties2 = inspectorInfo.getProperties();
        Transition.Factory factory = this.transitionFactory;
        if (factory instanceof DoNotTransition.Factory) {
            str = "None";
        } else {
            str = factory instanceof CrossFade ? "CrossFade" : "Custom: " + this.transitionFactory;
        }
        properties2.set("transition", str);
    }
}

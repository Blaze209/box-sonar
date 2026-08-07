package com.box.android.preview.annotations.ui.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.box.android.preview.R;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InkToolView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b'\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0016H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/InkToolView;", "Landroid/widget/LinearLayout;", "Lcom/box/android/preview/annotations/ui/views/AnnotationToolView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tip", "Landroid/widget/ImageView;", "getTip", "()Landroid/widget/ImageView;", "setTip", "(Landroid/widget/ImageView;)V", ViewProps.TOP, "getTop", "setTop", ViewProps.BOTTOM, "getBottom", "setBottom", "tipResourceId", "", "getTipResourceId", "()Ljava/lang/Integer;", "setTipResourceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "topResourceId", "getTopResourceId", "setTopResourceId", "bottomResourceId", "getBottomResourceId", "setBottomResourceId", "selectedColorResource", "getSelectedColorResource", "setSelectedColorResource", "constraint", "Landroidx/constraintlayout/widget/ConstraintLayout;", "setupImages", "", "selectTool", "deselectTool", "animateHelper", "finalLayout", "setColor", "color", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class InkToolView extends LinearLayout implements AnnotationToolView {
    private static final long TOOL_ANIMATION_TIME = 500;
    private ImageView bottom;
    private Integer bottomResourceId;
    private final ConstraintLayout constraint;
    private Integer selectedColorResource;
    private ImageView tip;
    private Integer tipResourceId;
    private ImageView top;
    private Integer topResourceId;
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InkToolView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.annotation_tool_default, (ViewGroup) this, true);
        View viewFindViewById = viewInflate.findViewById(R.id.annotation_tool_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.constraint = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.tip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.tip = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.top);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.top = (ImageView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.bottom);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.bottom = (ImageView) viewFindViewById4;
        setOrientation(1);
    }

    public final ImageView getTip() {
        return this.tip;
    }

    public final void setTip(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.tip = imageView;
    }

    @Override // android.view.View
    public final ImageView getTop() {
        return this.top;
    }

    public final void setTop(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.top = imageView;
    }

    @Override // android.view.View
    public final ImageView getBottom() {
        return this.bottom;
    }

    public final void setBottom(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.bottom = imageView;
    }

    public final Integer getTipResourceId() {
        return this.tipResourceId;
    }

    public final void setTipResourceId(Integer num) {
        this.tipResourceId = num;
    }

    public final Integer getTopResourceId() {
        return this.topResourceId;
    }

    public final void setTopResourceId(Integer num) {
        this.topResourceId = num;
    }

    public final Integer getBottomResourceId() {
        return this.bottomResourceId;
    }

    public final void setBottomResourceId(Integer num) {
        this.bottomResourceId = num;
    }

    public final Integer getSelectedColorResource() {
        return this.selectedColorResource;
    }

    public final void setSelectedColorResource(Integer num) {
        this.selectedColorResource = num;
    }

    public final void setupImages() {
        Integer num = this.tipResourceId;
        if (num != null) {
            this.tip.setImageDrawable(ResourcesCompat.getDrawable(getResources(), num.intValue(), null));
        }
        Integer num2 = this.topResourceId;
        if (num2 != null) {
            this.top.setImageDrawable(ResourcesCompat.getDrawable(getResources(), num2.intValue(), null));
        }
        Integer num3 = this.bottomResourceId;
        if (num3 != null) {
            this.bottom.setImageDrawable(ResourcesCompat.getDrawable(getResources(), num3.intValue(), null));
        }
    }

    @Override // com.box.android.preview.annotations.ui.views.AnnotationToolView
    public void selectTool() {
        animateHelper(R.layout.annotation_tool_selected);
    }

    @Override // com.box.android.preview.annotations.ui.views.AnnotationToolView
    public void deselectTool() {
        animateHelper(R.layout.annotation_tool_default);
    }

    private final void animateHelper(final int finalLayout) {
        post(new Runnable() { // from class: com.box.android.preview.annotations.ui.views.InkToolView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InkToolView.animateHelper$lambda$0(this.f$0, finalLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateHelper$lambda$0(InkToolView inkToolView, int i) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(inkToolView.getContext(), i);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
        changeBounds.setDuration(500L);
        TransitionManager.beginDelayedTransition(inkToolView.constraint, changeBounds);
        constraintSet.applyTo(inkToolView.constraint);
    }

    @Override // com.box.android.preview.annotations.ui.views.AnnotationToolView
    public void setColor(int color) {
        this.selectedColorResource = Integer.valueOf(color);
        Drawable drawable = this.tip.getDrawable();
        if (drawable != null) {
            drawable.setTint(color);
        }
    }
}

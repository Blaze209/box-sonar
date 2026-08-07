package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.core.graphics.Insets;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.d8.a;
import sdk.pendo.io.d8.b;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.views.utils.BackgroundRenderingUtils;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020&H\u0007J\b\u0010'\u001a\u00020!H\u0002J0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014J\u0018\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0007H\u0014J\b\u00101\u001a\u00020!H\u0016J\b\u00102\u001a\u00020!H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u0007H\u0016J\u0012\u00105\u001a\u00020!2\b\u00106\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u0007H\u0016J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020\u0007H\u0016J\b\u0010B\u001a\u00020\u0015H\u0007J\u0006\u0010C\u001a\u00020\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011¨\u0006D"}, d2 = {"Lsdk/pendo/io/views/custom/PendoScrollView;", "Landroid/widget/ScrollView;", "Lsdk/pendo/io/views/custom/IBackgroundRenderView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackgroundColor", "", "mBackgroundImageUrl", "", "mBorderColor", "mBorderWidth", "getMBorderWidth$annotations", "()V", "getMBorderWidth", "()I", "setMBorderWidth", "(I)V", "mCornerRadii", "", "mGotBackgroundColor", "", "getMGotBackgroundColor$annotations", "getMGotBackgroundColor", "()Z", "setMGotBackgroundColor", "(Z)V", "mImageFillType", "<set-?>", "mLayoutMaxWidth", "getMLayoutMaxWidth", "setLayoutMaxWidth", "addExtraPaddingIfNeeded", "", "addPaddingForInsets", "getBackgroundDrawable", "getLayoutMaxWidth", "getScreenSize", "Landroid/graphics/Point;", "maybeAddPaddingForInsets", "onLayout", "changed", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "renderBackground", "renderView", "setBackgroundColor", "color", "setCornerRadii", "cornerRadii", "setCornerRadius", "cornerRadius", "", "setImageBackgroundURL", "url", "setImageFillType", "fillType", "setStrokeColor", "strokeColor", "setStrokeWidth", "strokeWidth", "shouldApplyPadding", "shouldSetBackgroundColor", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoScrollView extends ScrollView implements IBackgroundRenderView {
    private int mBackgroundColor;
    private String mBackgroundImageUrl;
    private int mBorderColor;
    private int mBorderWidth;
    private float[] mCornerRadii;
    private boolean mGotBackgroundColor;
    private String mImageFillType;
    private int mLayoutMaxWidth;

    /* JADX INFO: renamed from: sdk.pendo.io.views.custom.PendoScrollView$renderBackground$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, PendoScrollView.class, "addExtraPaddingIfNeeded", "addExtraPaddingIfNeeded()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((PendoScrollView) this.receiver).addExtraPaddingIfNeeded();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoScrollView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void addPaddingForInsets() {
        final Insets insetsA = b.a((ViewGroup) this);
        if (insetsA.top == 0 && insetsA.bottom == 0) {
            return;
        }
        post(new Runnable() { // from class: sdk.pendo.io.views.custom.PendoScrollView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PendoScrollView.addPaddingForInsets$lambda$0(this.f$0, insetsA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addPaddingForInsets$lambda$0(PendoScrollView this$0, Insets padding) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(padding, "$padding");
        this$0.setPadding(this$0.getPaddingLeft(), this$0.getPaddingTop() + padding.top, this$0.getPaddingRight(), this$0.getPaddingBottom() + padding.bottom);
    }

    public static /* synthetic */ void getMBorderWidth$annotations() {
    }

    public static /* synthetic */ void getMGotBackgroundColor$annotations() {
    }

    private final void maybeAddPaddingForInsets() {
        if (shouldApplyPadding()) {
            addPaddingForInsets();
        }
    }

    public final void addExtraPaddingIfNeeded() {
        int i = this.mBorderWidth;
        if (i > 0) {
            int i2 = i / 3;
            setPadding(getPaddingLeft() + i2, getPaddingTop() + i2, getPaddingRight() + i2, getPaddingBottom() + i2);
        }
    }

    /* JADX INFO: renamed from: getBackgroundDrawable, reason: from getter */
    public final int getMBackgroundColor() {
        return this.mBackgroundColor;
    }

    public final int getLayoutMaxWidth() {
        int i = this.mLayoutMaxWidth;
        if (i > 0) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    public final int getMBorderWidth() {
        return this.mBorderWidth;
    }

    public final boolean getMGotBackgroundColor() {
        return this.mGotBackgroundColor;
    }

    public final int getMLayoutMaxWidth() {
        return this.mLayoutMaxWidth;
    }

    public final Point getScreenSize() {
        Point point = new Point();
        if (!(getParent() instanceof PendoBannerView)) {
            return AndroidUtils.h();
        }
        point.x = getWidth();
        point.y = getHeight();
        return point;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        maybeAddPaddingForInsets();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i = this.mLayoutMaxWidth;
        if (i > 0 && i >= getMinimumWidth() && this.mLayoutMaxWidth < size) {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLayoutMaxWidth, View.MeasureSpec.getMode(widthMeasureSpec));
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void renderBackground() {
        BackgroundRenderingUtils.a.a(this, new a(this.mBackgroundImageUrl, this.mImageFillType, this.mBackgroundColor, this.mBorderColor, this.mBorderWidth, this.mCornerRadii, getScreenSize()), new AnonymousClass1(this));
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (shouldSetBackgroundColor()) {
            addExtraPaddingIfNeeded();
            GradientDrawable gradientDrawable = new GradientDrawable();
            Drawable drawableMutate = gradientDrawable.mutate();
            Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) drawableMutate).setColor(this.mBackgroundColor);
            if (this.mBorderWidth > 0) {
                Drawable drawableMutate2 = gradientDrawable.mutate();
                Intrinsics.checkNotNull(drawableMutate2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                ((GradientDrawable) drawableMutate2).setStroke(this.mBorderWidth, this.mBorderColor);
            }
            if (this.mCornerRadii != null) {
                Drawable drawableMutate3 = gradientDrawable.mutate();
                Intrinsics.checkNotNull(drawableMutate3, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                ((GradientDrawable) drawableMutate3).setCornerRadii(this.mCornerRadii);
            }
            setBackground(gradientDrawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.mBackgroundColor = color;
        this.mGotBackgroundColor = true;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] cornerRadii) {
        this.mCornerRadii = cornerRadii != null ? (float[]) cornerRadii.clone() : null;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadii = new float[]{cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius};
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageBackgroundURL(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mBackgroundImageUrl = url;
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageFillType(String fillType) {
        Intrinsics.checkNotNullParameter(fillType, "fillType");
        this.mImageFillType = fillType;
    }

    public final void setLayoutMaxWidth(int i) {
        this.mLayoutMaxWidth = i;
    }

    public final void setMBorderWidth(int i) {
        this.mBorderWidth = i;
    }

    public final void setMGotBackgroundColor(boolean z) {
        this.mGotBackgroundColor = z;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int strokeColor) {
        this.mBorderColor = strokeColor;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int strokeWidth) {
        this.mBorderWidth = strokeWidth;
    }

    public final boolean shouldApplyPadding() {
        return !e1.h(getRootView());
    }

    public final boolean shouldSetBackgroundColor() {
        return this.mGotBackgroundColor || this.mCornerRadii != null || this.mBorderWidth > 0;
    }
}

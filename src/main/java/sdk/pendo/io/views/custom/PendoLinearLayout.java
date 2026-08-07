package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import sdk.pendo.io.d8.a;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.views.utils.BackgroundRenderingUtils;

/* JADX INFO: loaded from: classes5.dex */
public class PendoLinearLayout extends LinearLayout implements IBackgroundRenderView {
    private int mBackgroundColor;
    private String mBackgroundImageUrl;
    private int mBorderColor;
    int mBorderWidth;
    private float[] mCornerRadii;
    boolean mGotBackgroundColor;
    private String mImageFillType;
    int mLayoutMaxWidth;

    public PendoLinearLayout(Context context) {
        this(context, null);
    }

    void addExtraPaddingIfNeeded() {
        int i = this.mBorderWidth;
        if (i > 0) {
            int i2 = i / 3;
            setPadding(getPaddingLeft() + i2, getPaddingTop() + i2, getPaddingRight() + i2, getPaddingBottom() + i2);
        }
    }

    public String getImageBackgroundImageUrl() {
        return this.mBackgroundImageUrl;
    }

    public String getImageFillType() {
        return this.mImageFillType;
    }

    public int getLayoutMaxWidth() {
        int i = this.mLayoutMaxWidth;
        if (i > 0) {
            return i;
        }
        return Integer.MAX_VALUE;
    }

    public Point getScreenSize() {
        Point point = new Point();
        if (!(getParent() instanceof PendoBannerView)) {
            return AndroidUtils.h();
        }
        point.x = getWidth();
        point.y = getHeight();
        return point;
    }

    /* JADX INFO: renamed from: lambda$renderBackground$0$sdk-pendo-io-views-custom-PendoLinearLayout, reason: not valid java name */
    /* synthetic */ Unit m16866xd16862ca() {
        addExtraPaddingIfNeeded();
        return Unit.INSTANCE;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.mLayoutMaxWidth;
        if (i3 > 0 && i3 >= getMinimumWidth() && this.mLayoutMaxWidth < size) {
            i = View.MeasureSpec.makeMeasureSpec(this.mLayoutMaxWidth, View.MeasureSpec.getMode(i));
        }
        super.onMeasure(i, i2);
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void renderBackground() {
        BackgroundRenderingUtils.a.a(this, new a(this.mBackgroundImageUrl, this.mImageFillType, this.mBackgroundColor, this.mBorderColor, this.mBorderWidth, this.mCornerRadii, getScreenSize()), new Function0() { // from class: sdk.pendo.io.views.custom.PendoLinearLayout$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.m16866xd16862ca();
            }
        });
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        if (shouldSetBackgroundColor()) {
            addExtraPaddingIfNeeded();
            GradientDrawable gradientDrawable = new GradientDrawable();
            ((GradientDrawable) gradientDrawable.mutate()).setColor(this.mBackgroundColor);
            if (this.mBorderWidth > 0) {
                ((GradientDrawable) gradientDrawable.mutate()).setStroke(this.mBorderWidth, this.mBorderColor);
            }
            if (this.mCornerRadii != null) {
                ((GradientDrawable) gradientDrawable.mutate()).setCornerRadii(this.mCornerRadii);
            }
            setBackground(gradientDrawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        this.mGotBackgroundColor = true;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] fArr) {
        this.mCornerRadii = (float[]) fArr.clone();
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float f) {
        this.mCornerRadii = new float[]{f, f, f, f, f, f, f, f};
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageBackgroundURL(String str) {
        this.mBackgroundImageUrl = str;
    }

    @Override // sdk.pendo.io.views.custom.IBackgroundRenderView
    public void setImageFillType(String str) {
        this.mImageFillType = str;
    }

    public void setLayoutMaxWidth(int i) {
        this.mLayoutMaxWidth = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int i) {
        this.mBorderColor = i;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int i) {
        this.mBorderWidth = i;
    }

    boolean shouldSetBackgroundColor() {
        return this.mGotBackgroundColor || this.mCornerRadii != null || this.mBorderWidth > 0;
    }

    public PendoLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PendoLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }

    public PendoLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setWillNotDraw(false);
    }
}

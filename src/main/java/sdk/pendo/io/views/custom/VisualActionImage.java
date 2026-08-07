package sdk.pendo.io.views.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.glide.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.c2.b;
import sdk.pendo.io.listeners.glide.GlideListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`¢\u0006\u0004\bb\u0010cB\u001b\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u0010d\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bb\u0010eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J0\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0014J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u000fH\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u000fH\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u0012\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0010\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u000fH\u0016R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010>\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u0010H\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bR\u0010SR\"\u0010T\u001a\u00020Q8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\bT\u0010S\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]¨\u0006f"}, d2 = {"Lsdk/pendo/io/views/custom/VisualActionImage;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lsdk/pendo/io/views/custom/ActionableBlock;", "Lsdk/pendo/io/views/custom/PendoCustomView;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "", "url", "setResourceURL", "", "adjustViewBounds", "setAdjustViewBounds", "changed", "", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onLayout", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/view/ViewGroup;", "parentView", "calcImageRect", "", "getElementId", "Lsdk/pendo/io/c2/b;", "Lsdk/pendo/io/views/custom/ActionableBlock$OnSubmitAction;", "getOnSubmit", "onSubmit", "setOnSubmit", "", "Lsdk/pendo/io/actions/PendoCommand;", "commands", "setActions", "Landroid/view/View;", "v", ViewProps.ON_CLICK, "contentDescription", "setContentDescription", "strokeWidth", "setStrokeWidth", "strokeColor", "setStrokeColor", "", "cornerRadius", "setCornerRadius", "renderView", "", "cornerRadii", "setCornerRadii", "color", "setBackgroundColor", "mAdjustViewBounds", "Z", "mGuideId", "Ljava/lang/String;", "mCommands", "Ljava/util/List;", "mCornerRadius", "F", "getMCornerRadius$pendoIO_release", "()F", "setMCornerRadius$pendoIO_release", "(F)V", "mFrameWidth", "getMFrameWidth$pendoIO_release", "setMFrameWidth$pendoIO_release", "mFrameColor", "I", "mBackgroundColor", "getMBackgroundColor$pendoIO_release", "()I", "setMBackgroundColor$pendoIO_release", "(I)V", "Landroid/graphics/Path;", "mClipPath", "Landroid/graphics/Path;", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Paint;", "mBorderPaint", "getMBorderPaint$pendoIO_release", "()Landroid/graphics/Paint;", "setMBorderPaint$pendoIO_release", "(Landroid/graphics/Paint;)V", "Landroid/graphics/RectF;", "mRectForView", "Landroid/graphics/RectF;", "isInScrollingContainer", "()Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "guideId", "(Landroid/content/Context;Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class VisualActionImage extends AppCompatImageView implements ActionableBlock, PendoCustomView {
    private boolean mAdjustViewBounds;
    private int mBackgroundColor;
    public Paint mBorderPaint;
    private final Path mClipPath;
    private List<PendoCommand> mCommands;
    private float mCornerRadius;
    private int mFrameColor;
    private float mFrameWidth;
    private String mGuideId;
    private Paint mPaint;
    private RectF mRectForView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VisualActionImage(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final void calcImageRect(ViewGroup parentView) {
        float f;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        float width = getWidth();
        float height = getHeight();
        float width2 = getWidth() - ((parentView.getWidth() - parentView.getPaddingStart()) - parentView.getPaddingEnd());
        PendoLogger.d("VisualActionImage:  width = " + getWidth() + ", parentView.width = " + parentView.getWidth(), new Object[0]);
        if (getWidth() <= 0 || parentView.getWidth() <= 0 || width2 <= 0.0f) {
            f = 0.0f;
        } else {
            f = width2 / 2;
            width = getWidth() - f;
        }
        this.mRectForView.set(f, 0.0f, width, height);
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public CharSequence getElementId() {
        CharSequence contentDescription = getContentDescription();
        Intrinsics.checkNotNullExpressionValue(contentDescription, "getContentDescription(...)");
        return contentDescription;
    }

    /* JADX INFO: renamed from: getMBackgroundColor$pendoIO_release, reason: from getter */
    public final int getMBackgroundColor() {
        return this.mBackgroundColor;
    }

    public final Paint getMBorderPaint$pendoIO_release() {
        Paint paint = this.mBorderPaint;
        if (paint != null) {
            return paint;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBorderPaint");
        return null;
    }

    /* JADX INFO: renamed from: getMCornerRadius$pendoIO_release, reason: from getter */
    public final float getMCornerRadius() {
        return this.mCornerRadius;
    }

    /* JADX INFO: renamed from: getMFrameWidth$pendoIO_release, reason: from getter */
    public final float getMFrameWidth() {
        return this.mFrameWidth;
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public b<ActionableBlock.OnSubmitAction, String> getOnSubmit() {
        b<ActionableBlock.OnSubmitAction, String> bVarA = b.a(ActionableBlock.OnSubmitAction.CLOSE, null);
        Intrinsics.checkNotNullExpressionValue(bVarA, "of(...)");
        return bVarA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        List<PendoCommand> list = this.mCommands;
        if (list != null) {
            if (list.isEmpty()) {
                PendoLogger.d("No commands.", new Object[0]);
                return;
            }
            JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(list);
            PendoCommandDispatcher.getInstance().dispatchCommands(list, PendoCommandEventType.UserEventType.TAP_ON, true);
            Unit unit = Unit.INSTANCE;
            PendoLogger.d("No commands.", new Object[0]);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        try {
            if (getDrawable() != null && (this.mCornerRadius != 0.0f || this.mFrameWidth != 0.0f)) {
                this.mClipPath.reset();
                Path path = this.mClipPath;
                RectF rectF = this.mRectForView;
                float f = this.mCornerRadius;
                path.addRoundRect(rectF, f, f, Path.Direction.CW);
                canvas.clipPath(this.mClipPath);
                RectF rectF2 = this.mRectForView;
                float f2 = this.mCornerRadius;
                Paint paint = this.mPaint;
                if (paint == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPaint");
                    paint = null;
                }
                canvas.drawRoundRect(rectF2, f2, f2, paint);
                super.onDraw(canvas);
                if (this.mFrameWidth > 0.0f) {
                    RectF rectF3 = this.mRectForView;
                    float f3 = this.mCornerRadius;
                    canvas.drawRoundRect(rectF3, f3, f3, getMBorderPaint$pendoIO_release());
                    return;
                }
                return;
            }
            super.onDraw(canvas);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            setImageBitmap(null);
            setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.LinearLayout");
        calcImageRect((LinearLayout) parent);
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMin;
        int iMin2;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (this.mAdjustViewBounds) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int size = View.MeasureSpec.getSize(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
            int mode = View.MeasureSpec.getMode(heightMeasureSpec);
            int mode2 = View.MeasureSpec.getMode(widthMeasureSpec);
            if (mode == 1073741824 && mode2 != 1073741824) {
                int i = (intrinsicWidth * size) / intrinsicHeight;
                if (isInScrollingContainer()) {
                    setMeasuredDimension(i, size);
                    return;
                } else {
                    iMin = Math.min(i, size2);
                    iMin2 = Math.min(size, size);
                }
            } else if (mode2 == 1073741824 && mode != 1073741824) {
                int i2 = (intrinsicHeight * size2) / intrinsicWidth;
                if (isInScrollingContainer()) {
                    setMeasuredDimension(size2, i2);
                    return;
                } else {
                    iMin = Math.min(size2, size2);
                    iMin2 = Math.min(i2, size);
                }
            }
            setMeasuredDimension(iMin, iMin2);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void renderView() {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(this.mBackgroundColor);
        if (this.mFrameWidth > 0.0f) {
            setMBorderPaint$pendoIO_release(new Paint(1));
            getMBorderPaint$pendoIO_release().setStyle(Paint.Style.STROKE);
            getMBorderPaint$pendoIO_release().setColor(this.mFrameColor);
            getMBorderPaint$pendoIO_release().setStrokeWidth(this.mFrameWidth * 2);
        }
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setActions(List<PendoCommand> commands) {
        if (commands != null) {
            if (commands.isEmpty()) {
                PendoLogger.d("No commands.", new Object[0]);
                return;
            }
            this.mCommands = commands;
            Unit unit = Unit.INSTANCE;
            PendoLogger.d("No commands.", new Object[0]);
        }
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean adjustViewBounds) {
        this.mAdjustViewBounds = adjustViewBounds;
        ImageView.ScaleType scaleType = getScaleType();
        super.setAdjustViewBounds(adjustViewBounds);
        setScaleType(scaleType);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        this.mBackgroundColor = color;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence contentDescription) {
        super.setContentDescription(contentDescription);
        setImportantForAccessibility(1);
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadii(float[] cornerRadii) {
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadius = cornerRadius;
    }

    public final void setMBackgroundColor$pendoIO_release(int i) {
        this.mBackgroundColor = i;
    }

    public final void setMBorderPaint$pendoIO_release(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.mBorderPaint = paint;
    }

    public final void setMCornerRadius$pendoIO_release(float f) {
        this.mCornerRadius = f;
    }

    public final void setMFrameWidth$pendoIO_release(float f) {
        this.mFrameWidth = f;
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setOnSubmit(String onSubmit) {
        Intrinsics.checkNotNullParameter(onSubmit, "onSubmit");
    }

    public final void setResourceURL(String url) {
        Point pointH = AndroidUtils.h();
        a.d(getContext()).m14710load(url).listener(new GlideListener(this.mGuideId, null, PendoCommandAction.PendoInternalAction.IMAGES_SET, this)).centerInside().override(pointH.x, pointH.y).submit();
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeColor(int strokeColor) {
        this.mFrameColor = strokeColor;
    }

    @Override // sdk.pendo.io.views.custom.PendoCustomView
    public void setStrokeWidth(int strokeWidth) {
        this.mFrameWidth = strokeWidth;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VisualActionImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClipPath = new Path();
        this.mRectForView = new RectF();
        setOnClickListener(this);
        setClickable(false);
        setImportantForAccessibility(2);
    }

    public /* synthetic */ VisualActionImage(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VisualActionImage(Context context, String str) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGuideId = str;
    }
}

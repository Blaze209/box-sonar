package com.pspdfkit.internal.ui.inspector;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.g9;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR6\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\"\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/pspdfkit/internal/ui/inspector/ColorPaletteView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "value", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/util/List;", "getAvailableColors", "()Ljava/util/List;", "setAvailableColors", "(Ljava/util/List;)V", "availableColors", "Lcom/pspdfkit/internal/ui/inspector/ColorPaletteView$a;", "b", "Lcom/pspdfkit/internal/ui/inspector/ColorPaletteView$a;", "getOnColorPickedListener", "()Lcom/pspdfkit/internal/ui/inspector/ColorPaletteView$a;", "setOnColorPickedListener", "(Lcom/pspdfkit/internal/ui/inspector/ColorPaletteView$a;)V", "onColorPickedListener", "", "c", "Z", "getShowSelectionIndicator", "()Z", "setShowSelectionIndicator", "(Z)V", "showSelectionIndicator", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ColorPaletteView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public List<Integer> availableColors;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public a onColorPickedListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean showSelectionIndicator;
    public int d;
    public final int e;
    public int f;
    public int g;
    public final LayerDrawable h;

    public interface a {
        void a(ColorPaletteView colorPaletteView, int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorPaletteView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    public static final void a(ColorPaletteView colorPaletteView, int i, View view) {
        if (colorPaletteView.d == i && colorPaletteView.showSelectionIndicator) {
            return;
        }
        colorPaletteView.d = i;
        colorPaletteView.a();
        a aVar = colorPaletteView.onColorPickedListener;
        if (aVar != null) {
            aVar.a(colorPaletteView, i);
        }
    }

    public final void b() {
        removeAllViews();
        Iterator<Integer> it = this.availableColors.iterator();
        while (it.hasNext()) {
            final int iIntValue = it.next().intValue();
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setBackground(new RippleDrawable(ColorStateList.valueOf(Color.argb(66, 255, 255, 255)), new g9(getContext(), iIntValue, 4), null));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ui.inspector.ColorPaletteView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ColorPaletteView.a(this.f$0, iIntValue, view);
                }
            });
            imageView.setClickable(true);
            imageView.setTag(Integer.valueOf(iIntValue));
            addView(imageView);
        }
    }

    public final List<Integer> getAvailableColors() {
        return this.availableColors;
    }

    public final a getOnColorPickedListener() {
        return this.onColorPickedListener;
    }

    public final boolean getShowSelectionIndicator() {
        return this.showSelectionIndicator;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = this.g;
        int measuredWidth = (getMeasuredWidth() - (i5 * 9)) / 2;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int i7 = this.e;
            int i8 = ((i6 % 9) * i5) + measuredWidth + i7;
            int i9 = ((i6 / 9) * i5) + i7;
            childAt.layout(i8, i9, childAt.getMeasuredWidth() + i8, childAt.getMeasuredHeight() + i9);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(0, i);
        this.g = (defaultSize - (this.e * 2)) / 9;
        this.f = (int) Math.ceil(((double) getChildCount()) / 9.0d);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.g - (this.e * 2), 1073741824);
        measureChildren(iMakeMeasureSpec, iMakeMeasureSpec);
        setMeasuredDimension(defaultSize, this.f * this.g);
    }

    public final void setAvailableColors(List<Integer> list) {
        list.getClass();
        this.availableColors = list;
        b();
        a();
    }

    public final void setOnColorPickedListener(a aVar) {
        this.onColorPickedListener = aVar;
    }

    public final void setShowSelectionIndicator(boolean z) {
        this.showSelectionIndicator = z;
        a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ColorPaletteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorPaletteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.availableColors = CollectionsKt.emptyList();
        this.d = -16777216;
        this.e = getResources().getDimensionPixelSize(R.dimen.pspdf__color_picker_color_padding);
        this.h = new LayerDrawable(new Drawable[]{a80.b(context, R.drawable.pspdf__ic_color_selected_bg), a80.a(context, R.drawable.pspdf__ic_color_selected, -1)});
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0034 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0036  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    /* JADX WARN: Code duplicated, block: B:34:0x003f A[SYNTHETIC] */
    public final void a() {
        ImageView imageView;
        int i = 0;
        if (this.showSelectionIndicator) {
            int childCount = getChildCount();
            while (i < childCount) {
                View childAt = getChildAt(i);
                boolean z = childAt instanceof ImageView;
                if (z) {
                    ImageView imageView2 = (ImageView) childAt;
                    Object tag = imageView2.getTag();
                    Integer num = tag instanceof Integer ? (Integer) tag : null;
                    int i2 = this.d;
                    if (num != null && num.intValue() == i2) {
                        imageView2.setImageDrawable(this.h);
                    } else {
                        if (z) {
                            imageView = (ImageView) childAt;
                        } else {
                            imageView = null;
                        }
                        if (imageView != null) {
                            imageView.setImageDrawable(null);
                        }
                    }
                } else {
                    if (z) {
                        imageView = (ImageView) childAt;
                    } else {
                        imageView = null;
                    }
                    if (imageView != null) {
                        imageView.setImageDrawable(null);
                    }
                }
                i++;
            }
            return;
        }
        int childCount2 = getChildCount();
        while (i < childCount2) {
            View childAt2 = getChildAt(i);
            if (childAt2 instanceof ImageView) {
                ((ImageView) childAt2).setImageDrawable(null);
            }
            i++;
        }
    }

    public /* synthetic */ ColorPaletteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

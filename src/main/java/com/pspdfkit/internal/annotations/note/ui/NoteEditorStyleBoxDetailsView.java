package com.pspdfkit.internal.annotations.note.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.pspdfkit.R;
import com.pspdfkit.internal.es;
import com.pspdfkit.internal.ww;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/internal/annotations/note/ui/NoteEditorStyleBoxDetailsView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/pspdfkit/internal/es;", "adapterCallbacks", "", "setAdapterCallbacks", "(Lcom/pspdfkit/internal/es;)V", "", HubsObservability.HUB_ASSET_ICON, "setSelectedIconItem", "(Ljava/lang/String;)V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getSelectedIconItem$annotations", "()V", "selectedIconItem", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoteEditorStyleBoxDetailsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public String selectedIconItem;
    public final int b;
    public es c;
    public int d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteEditorStyleBoxDetailsView(Context context) {
        this(context, null, 0, 0, 14, null);
        context.getClass();
    }

    private static /* synthetic */ void getSelectedIconItem$annotations() {
    }

    public final void a(List<String> list, List<Integer> list2) {
        list.getClass();
        list2.getClass();
        removeAllViews();
        this.d = 0;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.pspdf__note_editor_item_style_box_item_padding);
        for (final String str : list) {
            ImageView imageView = new ImageView(getContext());
            imageView.setTag(str);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, ContextCompat.getDrawable(imageView.getContext(), R.drawable.pspdf__rounded_rect_note_editor_style_box_item_selected));
            stateListDrawable.addState(new int[0], ContextCompat.getDrawable(imageView.getContext(), R.drawable.pspdf__rounded_rect_note_editor_style_box_item));
            imageView.setBackground(stateListDrawable);
            imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            imageView.setCropToPadding(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            float f = ww.a;
            str.getClass();
            Integer num = ww.l.get(str);
            imageView.setImageResource(num != null ? num.intValue() : ww.m);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.annotations.note.ui.NoteEditorStyleBoxDetailsView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoteEditorStyleBoxDetailsView.a(this.f$0, str, view);
                }
            });
            addView(imageView);
            this.d++;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            final int iIntValue = ((Number) it.next()).intValue();
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setTag(Integer.valueOf(iIntValue));
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.pspdf__rounded_rect_note_editor_style_box_item);
            GradientDrawable gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
            Drawable drawableMutate = gradientDrawable != null ? gradientDrawable.mutate() : null;
            GradientDrawable gradientDrawable2 = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(iIntValue);
            }
            imageView2.setBackground(gradientDrawable2);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.annotations.note.ui.NoteEditorStyleBoxDetailsView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoteEditorStyleBoxDetailsView.a(this.f$0, iIntValue, view);
                }
            });
            addView(imageView2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            int i7 = this.d;
            int i8 = (i6 < i7 || (i5 = i7 % 6) == 0) ? i6 : (6 - i5) + i6;
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i9 = this.b;
            int i10 = ((measuredWidth + i9) * (i8 % 6)) + paddingLeft;
            int i11 = ((i9 + measuredHeight) * (i8 / 6)) + paddingTop;
            childAt.layout(i10, i11, measuredWidth + i10, measuredHeight + i11);
            i6++;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.b * 5)) / 6;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824));
        }
        int i4 = this.d % 6;
        int childCount2 = getChildCount() + (i4 == 0 ? 0 : 6 - i4);
        int i5 = (childCount2 / 6) + (childCount2 % 6 != 0 ? 1 : 0);
        setMeasuredDimension(getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + ((i5 - 1) * this.b) + (measuredWidth * i5));
    }

    public final void setAdapterCallbacks(es adapterCallbacks) {
        this.c = adapterCallbacks;
    }

    public final void setSelectedIconItem(String icon) {
        ImageView imageView;
        String str = this.selectedIconItem;
        ImageView imageView2 = null;
        if (str == null) {
            imageView = null;
            break;
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                imageView = null;
                break;
            }
            View childAt = getChildAt(i);
            if (Intrinsics.areEqual(childAt.getTag(), str) && (childAt instanceof ImageView)) {
                imageView = (ImageView) childAt;
                break;
            }
            i++;
        }
        if (imageView != null) {
            imageView.setSelected(false);
        }
        this.selectedIconItem = icon;
        if (icon != null) {
            int childCount2 = getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt2 = getChildAt(i2);
                if (Intrinsics.areEqual(childAt2.getTag(), icon) && (childAt2 instanceof ImageView)) {
                    imageView2 = (ImageView) childAt2;
                    break;
                }
            }
        }
        if (imageView2 != null) {
            imageView2.setSelected(true);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteEditorStyleBoxDetailsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteEditorStyleBoxDetailsView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteEditorStyleBoxDetailsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        context.getClass();
        this.b = getResources().getDimensionPixelSize(R.dimen.pspdf__note_editor_item_style_box_details_item_spacing_dp);
    }

    public /* synthetic */ NoteEditorStyleBoxDetailsView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static final void a(NoteEditorStyleBoxDetailsView noteEditorStyleBoxDetailsView, String str, View view) {
        es esVar = noteEditorStyleBoxDetailsView.c;
        if (esVar != null) {
            esVar.a(str);
        }
    }

    public static final void a(NoteEditorStyleBoxDetailsView noteEditorStyleBoxDetailsView, int i, View view) {
        es esVar = noteEditorStyleBoxDetailsView.c;
        if (esVar != null) {
            esVar.a(i);
        }
    }
}

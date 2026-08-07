package com.pspdfkit.internal.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/pspdfkit/internal/ui/views/MovableImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MovableImageView extends AppCompatImageView {
    public float a;
    public float b;
    public float c;
    public float d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovableImageView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getRawX();
            this.b = motionEvent.getRawY();
            return true;
        }
        if (action != 2) {
            return true;
        }
        this.c = motionEvent.getRawX() - this.a;
        this.d = motionEvent.getRawY() - this.b;
        float x = getX() + this.c;
        float f = (-getWidth()) / 2.0f;
        Object parent = getParent();
        parent.getClass();
        setX(RangesKt.coerceIn(x, f, ((View) parent).getWidth() - (getWidth() / 2.0f)));
        float y = getY() + this.d;
        float f2 = (-getHeight()) / 2.0f;
        Object parent2 = getParent();
        parent2.getClass();
        setY(RangesKt.coerceIn(y, f2, ((View) parent2).getHeight() - (getHeight() / 2.0f)));
        this.a = motionEvent.getRawX();
        this.b = motionEvent.getRawY();
        return true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
    }

    public /* synthetic */ MovableImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

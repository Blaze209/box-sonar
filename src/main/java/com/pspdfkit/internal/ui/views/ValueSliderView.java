package com.pspdfkit.internal.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.timepicker.TimeModel;
import com.pspdfkit.R;
import com.pspdfkit.internal.r70;
import com.pspdfkit.ui.editor.UnitSelectionEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/pspdfkit/internal/ui/views/ValueSliderView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/Function1;", "", "e", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getValue", "()I", "value", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ValueSliderView extends LinearLayout {
    public final TextView a;
    public final SeekBar b;
    public final UnitSelectionEditText c;
    public int d;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> listener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValueSliderView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    public final void a(String str, int i) {
        str.getClass();
        this.d = i;
        this.a.setText(str);
        this.c.setUnitLabel(TimeModel.NUMBER_FORMAT, 0, 0, i, new UnitSelectionEditText.UnitSelectionListener() { // from class: com.pspdfkit.internal.ui.views.ValueSliderView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.editor.UnitSelectionEditText.UnitSelectionListener
            public final void onValueSet(UnitSelectionEditText unitSelectionEditText, int i2) {
                ValueSliderView.a(this.f$0, unitSelectionEditText, i2);
            }
        });
        this.b.setMax(i);
        this.b.setOnSeekBarChangeListener(new r70(i, this));
        a(0, false);
    }

    public final Function1<Integer, Unit> getListener() {
        return this.listener;
    }

    public final int getValue() {
        return this.b.getProgress();
    }

    public final void setListener(Function1<? super Integer, Unit> function1) {
        this.listener = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValueSliderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueSliderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        LayoutInflater.from(context).inflate(R.layout.pspdf__value_slider, this);
        setOrientation(1);
        View viewFindViewById = findViewById(R.id.pspdf__sliderLabel);
        viewFindViewById.getClass();
        this.a = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.pspdf__sliderSeekBar);
        viewFindViewById2.getClass();
        this.b = (SeekBar) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.pspdf__sliderUnitEditText);
        viewFindViewById3.getClass();
        this.c = (UnitSelectionEditText) viewFindViewById3;
    }

    public static final void a(ValueSliderView valueSliderView, UnitSelectionEditText unitSelectionEditText, int i) {
        unitSelectionEditText.getClass();
        valueSliderView.a(i, true);
    }

    public final void a(int i, boolean z) {
        Function1<? super Integer, Unit> function1;
        if (z) {
            i = Math.max(0, Math.min(i, this.d));
        }
        this.b.setProgress(i);
        this.c.setTextToFormat(i);
        if (!z || (function1 = this.listener) == null) {
            return;
        }
        function1.invoke(Integer.valueOf(i));
    }

    public /* synthetic */ ValueSliderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

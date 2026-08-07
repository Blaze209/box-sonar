package com.pspdfkit.internal;

import android.widget.SeekBar;
import com.pspdfkit.internal.ui.views.ValueSliderView;

/* JADX INFO: loaded from: classes3.dex */
public final class r70 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ ValueSliderView b;

    public r70(int i, ValueSliderView valueSliderView) {
        this.a = i;
        this.b = valueSliderView;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        seekBar.getClass();
        this.b.a(Math.max(0, Math.min(i, this.a)), z);
        this.b.c.focusCheck();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        seekBar.getClass();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        seekBar.getClass();
    }
}

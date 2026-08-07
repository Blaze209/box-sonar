package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import androidx.appcompat.widget.AppCompatSpinner;
import com.pspdfkit.internal.ct;
import com.pspdfkit.ui.fonts.Font;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends AppCompatSpinner {
    public a a;
    public boolean b;

    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        context.getClass();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        ct ctVar;
        super.onWindowFocusChanged(z);
        if (this.b && z) {
            this.b = false;
            a aVar = this.a;
            if (aVar != null) {
                c cVar = (c) aVar;
                setSelected(false);
                Font font = (Font) getSelectedItem();
                if (font == null || (ctVar = cVar.a.b) == null) {
                    return;
                }
                ctVar.a(font);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner, android.view.View
    public final boolean performClick() {
        this.b = true;
        if (this.a != null) {
            setSelected(true);
        }
        return super.performClick();
    }

    public final void setSpinnerEventsListener(a aVar) {
        this.a = aVar;
    }
}

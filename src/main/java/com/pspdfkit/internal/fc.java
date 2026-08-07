package com.pspdfkit.internal;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import androidx.core.internal.view.SupportMenu;
import com.google.android.material.textfield.TextInputLayout;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.pspdfkit.R;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import com.pspdfkit.internal.ui.views.ValueSliderView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class fc extends LinearLayout {
    public final ClipboardManager a;
    public final View b;
    public final ValueSliderView c;
    public final ValueSliderView d;
    public final ValueSliderView e;
    public final View f;
    public final TextInputLayout g;
    public final EditText h;
    public final RadioGroup i;
    public int j;
    public a k;

    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc(final Context context) {
        super(context, null, 0);
        context.getClass();
        Object systemService = context.getSystemService("clipboard");
        systemService.getClass();
        this.a = (ClipboardManager) systemService;
        this.j = SupportMenu.CATEGORY_MASK;
        LayoutInflater.from(context).inflate(R.layout.pspdf__custom_color_picker, this);
        setOrientation(1);
        View viewFindViewById = findViewById(R.id.pspdf__slider_container);
        viewFindViewById.getClass();
        this.b = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.pspdf__custom_color_slider_1);
        viewFindViewById2.getClass();
        ValueSliderView valueSliderView = (ValueSliderView) viewFindViewById2;
        this.c = valueSliderView;
        valueSliderView.setListener(new Function1() { // from class: com.pspdfkit.internal.fc$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return fc.a(this.f$0, ((Integer) obj).intValue());
            }
        });
        View viewFindViewById3 = findViewById(R.id.pspdf__custom_color_slider_2);
        viewFindViewById3.getClass();
        ValueSliderView valueSliderView2 = (ValueSliderView) viewFindViewById3;
        this.d = valueSliderView2;
        valueSliderView2.setListener(new Function1() { // from class: com.pspdfkit.internal.fc$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return fc.b(this.f$0, ((Integer) obj).intValue());
            }
        });
        View viewFindViewById4 = findViewById(R.id.pspdf__custom_color_slider_3);
        viewFindViewById4.getClass();
        ValueSliderView valueSliderView3 = (ValueSliderView) viewFindViewById4;
        this.e = valueSliderView3;
        valueSliderView3.setListener(new Function1() { // from class: com.pspdfkit.internal.fc$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return fc.c(this.f$0, ((Integer) obj).intValue());
            }
        });
        View viewFindViewById5 = findViewById(R.id.pspdf__custom_color_picker_switcher);
        viewFindViewById5.getClass();
        RadioGroup radioGroup = (RadioGroup) viewFindViewById5;
        this.i = radioGroup;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.pspdfkit.internal.fc$$ExternalSyntheticLambda3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                fc.a(this.f$0, radioGroup2, i);
            }
        });
        View viewFindViewById6 = findViewById(R.id.pspdf__hex_container);
        viewFindViewById6.getClass();
        this.f = viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.pspdf__hex_entry_container);
        viewFindViewById7.getClass();
        this.g = (TextInputLayout) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.pspdf__hex_entry);
        viewFindViewById8.getClass();
        EditText editText = (EditText) viewFindViewById8;
        this.h = editText;
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.pspdfkit.internal.fc$$ExternalSyntheticLambda4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return fc.a(this.f$0, textView, i, keyEvent);
            }
        });
        View viewFindViewById9 = findViewById(R.id.pspdf__paste_hex_button);
        viewFindViewById9.getClass();
        ((Button) viewFindViewById9).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.fc$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                fc.a(this.f$0, context, view);
            }
        });
        a();
    }

    public static final Unit a(fc fcVar, int i) {
        fcVar.b();
        return Unit.INSTANCE;
    }

    public static final Unit b(fc fcVar, int i) {
        fcVar.b();
        return Unit.INSTANCE;
    }

    public static final Unit c(fc fcVar, int i) {
        fcVar.b();
        return Unit.INSTANCE;
    }

    public final int getCurrentColor() {
        return this.j;
    }

    public final int getCurrentMode() {
        return this.i.getCheckedRadioButtonId();
    }

    public final a getListener() {
        return this.k;
    }

    public final void setCurrentColor(int i) {
        boolean z = this.j != i;
        this.j = i;
        if (z) {
            c();
        }
    }

    public final void setCurrentMode(int i) {
        this.i.check(i);
    }

    public final void setListener(a aVar) {
        this.k = aVar;
    }

    public static final void a(fc fcVar, RadioGroup radioGroup, int i) {
        radioGroup.getClass();
        if (i == R.id.pspdf__custom_color_picker_hsl) {
            fcVar.a();
            return;
        }
        if (i == R.id.pspdf__custom_color_picker_rgb) {
            fcVar.b.setVisibility(0);
            fcVar.f.setVisibility(4);
            ValueSliderView valueSliderView = fcVar.c;
            String strA = no.a(fcVar.getContext(), R.string.pspdf__color_red, null);
            strA.getClass();
            valueSliderView.a(strA, 255);
            ValueSliderView valueSliderView2 = fcVar.d;
            String strA2 = no.a(fcVar.getContext(), R.string.pspdf__color_green, null);
            strA2.getClass();
            valueSliderView2.a(strA2, 255);
            ValueSliderView valueSliderView3 = fcVar.e;
            String strA3 = no.a(fcVar.getContext(), R.string.pspdf__color_blue, null);
            strA3.getClass();
            valueSliderView3.a(strA3, 255);
            fcVar.i.check(R.id.pspdf__custom_color_picker_rgb);
            fcVar.c();
            return;
        }
        if (i == R.id.pspdf__custom_color_picker_hex) {
            fcVar.b.setVisibility(4);
            fcVar.f.setVisibility(0);
            fcVar.i.check(R.id.pspdf__custom_color_picker_hex);
            fcVar.c();
        }
    }

    public final void b() {
        int checkedRadioButtonId = this.i.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.pspdf__custom_color_picker_hsl) {
            this.j = ColorUtils.HSLToColor(new float[]{this.c.getValue(), this.d.getValue() / 100.0f, this.e.getValue() / 100.0f});
        } else if (checkedRadioButtonId == R.id.pspdf__custom_color_picker_rgb) {
            this.j = Color.rgb(this.c.getValue(), this.d.getValue(), this.e.getValue());
        } else if (checkedRadioButtonId == R.id.pspdf__custom_color_picker_hex) {
            try {
                this.j = Color.parseColor("#" + ((Object) this.h.getText()));
                this.g.setError(null);
            } catch (IllegalArgumentException unused) {
                this.g.setError(no.a(getContext(), R.string.pspdf__color_picker_invalid_color_value, null));
            }
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.j);
        }
    }

    public final void c() {
        int checkedRadioButtonId = this.i.getCheckedRadioButtonId();
        if (checkedRadioButtonId == R.id.pspdf__custom_color_picker_hsl) {
            float[] fArr = new float[3];
            ColorUtils.colorToHSL(this.j, fArr);
            this.c.a((int) fArr[0], false);
            float f = 100;
            this.d.a((int) (fArr[1] * f), false);
            this.e.a((int) (fArr[2] * f), false);
            return;
        }
        if (checkedRadioButtonId == R.id.pspdf__custom_color_picker_rgb) {
            this.c.a(Color.red(this.j), false);
            this.d.a(Color.green(this.j), false);
            this.e.a(Color.blue(this.j), false);
        } else if (checkedRadioButtonId == R.id.pspdf__custom_color_picker_hex) {
            this.h.setText(u40.a(this.j, false, false));
        }
    }

    public static final boolean a(fc fcVar, TextView textView, int i, KeyEvent keyEvent) {
        fcVar.b();
        return false;
    }

    public static final void a(fc fcVar, Context context, View view) {
        ClipData primaryClip = MAMClipboard.getPrimaryClip(fcVar.a);
        if (primaryClip != null) {
            if (primaryClip.getDescription().hasMimeType("text/plain") || primaryClip.getDescription().hasMimeType("text/html")) {
                CharSequence text = primaryClip.getItemAt(0).getText();
                try {
                    text.getClass();
                    if (!StringsKt.startsWith$default(text, ColorSerializer.PREFIX, false, 2, (Object) null)) {
                        text = "#" + ((Object) text);
                    }
                    int color = Color.parseColor(text.toString());
                    fcVar.setCurrentColor(color);
                    fcVar.c();
                    a aVar = fcVar.k;
                    if (aVar != null) {
                        aVar.a(color);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (IllegalArgumentException unused) {
                    Toast.makeText(context, no.a(context, R.string.pspdf__color_picker_invalid_color_value, null), 0).show();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    public final void a() {
        this.b.setVisibility(0);
        this.f.setVisibility(4);
        ValueSliderView valueSliderView = this.c;
        String strA = no.a(getContext(), R.string.pspdf__color_picker_hue, null);
        strA.getClass();
        valueSliderView.a(strA, 360);
        ValueSliderView valueSliderView2 = this.d;
        String strA2 = no.a(getContext(), R.string.pspdf__color_picker_saturation, null);
        strA2.getClass();
        valueSliderView2.a(strA2, 100);
        ValueSliderView valueSliderView3 = this.e;
        String strA3 = no.a(getContext(), R.string.pspdf__color_picker_lightness, null);
        strA3.getClass();
        valueSliderView3.a(strA3, 100);
        this.i.check(R.id.pspdf__custom_color_picker_hsl);
        c();
    }
}

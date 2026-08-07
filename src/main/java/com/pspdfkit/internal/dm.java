package com.pspdfkit.internal;

import com.pspdfkit.R;
import com.pspdfkit.ui.fonts.Font;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dm extends Font {
    public final int a;

    public static final class a extends dm {
        public static final a b = new a();

        public a() {
            super("Courier", R.drawable.pspdf__ic_font_courier);
        }
    }

    public static final class b extends dm {
        public static final b b = new b();

        public b() {
            super("Helvetica", R.drawable.pspdf__ic_font_helvetica);
        }
    }

    public static final class c extends dm {
        public static final c b = new c();

        public c() {
            super("Times", R.drawable.pspdf__ic_font_times);
        }
    }

    public dm(String str, int i) {
        super(str, null, null, 6, null);
        this.a = i;
    }
}

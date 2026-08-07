package io.noties.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

/* JADX INFO: loaded from: classes4.dex */
public class NoCopySpannableFactory extends Spannable.Factory {
    public static NoCopySpannableFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        if (charSequence instanceof Spannable) {
            return (Spannable) charSequence;
        }
        return new SpannableString(charSequence);
    }

    static class Holder {
        private static final NoCopySpannableFactory INSTANCE = new NoCopySpannableFactory();

        Holder() {
        }
    }
}

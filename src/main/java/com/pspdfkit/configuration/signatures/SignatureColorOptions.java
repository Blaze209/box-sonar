package com.pspdfkit.configuration.signatures;

import android.content.Context;
import android.os.Parcelable;
import com.pspdfkit.R;

/* JADX INFO: loaded from: classes3.dex */
public interface SignatureColorOptions extends Parcelable {
    static SignatureColorOptions fromColorInt(int i, int i2, int i3) {
        return new ColorIntOptions(i, i2, i3);
    }

    static SignatureColorOptions fromColorRes(int i, int i2, int i3) {
        return new ColorResOptions(i, i2, i3);
    }

    static SignatureColorOptions fromDefaults() {
        return new ColorResOptions(R.color.pspdf__electronic_signature_drawing_primary, R.color.pspdf__electronic_signature_drawing_secondary, R.color.pspdf__electronic_signature_drawing_tertiary);
    }

    int option1(Context context);

    int option2(Context context);

    int option3(Context context);
}

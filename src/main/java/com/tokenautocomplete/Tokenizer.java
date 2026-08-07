package com.tokenautocomplete;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface Tokenizer extends Parcelable {
    boolean containsTokenTerminator(CharSequence charSequence);

    List<Range> findTokenRanges(CharSequence charSequence, int i, int i2);

    CharSequence wrapTokenValue(CharSequence charSequence);
}

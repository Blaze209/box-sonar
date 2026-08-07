package com.tokenautocomplete;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SpanUtils {

    private static class EllipsizeCallback implements TextUtils.EllipsizeCallback {
        int end;
        int start;

        private EllipsizeCallback() {
            this.start = 0;
            this.end = 0;
        }

        @Override // android.text.TextUtils.EllipsizeCallback
        public void ellipsized(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    public static Spanned ellipsizeWithSpans(CharSequence charSequence, CountSpan countSpan, int i, TextPaint textPaint, CharSequence charSequence2, float f) {
        float countTextWidthForPaint;
        if (countSpan != null) {
            countSpan.setCount(i);
            countTextWidthForPaint = countSpan.getCountTextWidthForPaint(textPaint);
        } else {
            countTextWidthForPaint = 0.0f;
        }
        EllipsizeCallback ellipsizeCallback = new EllipsizeCallback();
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(charSequence2, textPaint, f - countTextWidthForPaint, TextUtils.TruncateAt.END, false, ellipsizeCallback);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequenceEllipsize);
        if (charSequenceEllipsize instanceof Spanned) {
            TextUtils.copySpansFrom((Spanned) charSequenceEllipsize, 0, charSequenceEllipsize.length(), Object.class, spannableStringBuilder, 0);
        }
        if (charSequence != null && charSequence.length() > ellipsizeCallback.start) {
            spannableStringBuilder.replace(0, ellipsizeCallback.start, charSequence);
            ellipsizeCallback.end = (ellipsizeCallback.end + charSequence.length()) - ellipsizeCallback.start;
            ellipsizeCallback.start = charSequence.length();
        }
        if (ellipsizeCallback.start == ellipsizeCallback.end) {
            return null;
        }
        if (countSpan != null) {
            countSpan.setCount(i - ((TokenCompleteTextView.TokenImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), TokenCompleteTextView.TokenImageSpan.class)).length);
            spannableStringBuilder.replace(ellipsizeCallback.start, spannableStringBuilder.length(), (CharSequence) countSpan.getCountText());
            spannableStringBuilder.setSpan(countSpan, ellipsizeCallback.start, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }
}

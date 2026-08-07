package io.noties.markwon;

import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class PrecomputedTextSetterCompat implements Markwon.TextSetter {
    private final Executor executor;

    public static PrecomputedTextSetterCompat create(Executor executor) {
        return new PrecomputedTextSetterCompat(executor);
    }

    PrecomputedTextSetterCompat(Executor executor) {
        this.executor = executor;
    }

    @Override // io.noties.markwon.Markwon.TextSetter
    public void setText(TextView textView, final Spanned spanned, final TextView.BufferType bufferType, final Runnable runnable) {
        final WeakReference weakReference = new WeakReference(textView);
        this.executor.execute(new Runnable() { // from class: io.noties.markwon.PrecomputedTextSetterCompat.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    PrecomputedTextCompat precomputedTextCompatPrecomputedText = PrecomputedTextSetterCompat.precomputedText((TextView) weakReference.get(), spanned);
                    if (precomputedTextCompatPrecomputedText != null) {
                        PrecomputedTextSetterCompat.applyText((TextView) weakReference.get(), precomputedTextCompatPrecomputedText, bufferType, runnable);
                    }
                } catch (Throwable th) {
                    Log.e("PrecomputdTxtSetterCmpt", "Exception during pre-computing text", th);
                    PrecomputedTextSetterCompat.applyText((TextView) weakReference.get(), spanned, bufferType, runnable);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PrecomputedTextCompat precomputedText(TextView textView, Spanned spanned) {
        if (textView == null) {
            return null;
        }
        return PrecomputedTextCompat.create(spanned, new PrecomputedTextCompat.Params(textView.getTextMetricsParams()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyText(final TextView textView, final Spanned spanned, final TextView.BufferType bufferType, final Runnable runnable) {
        if (textView != null) {
            textView.post(new Runnable() { // from class: io.noties.markwon.PrecomputedTextSetterCompat.2
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(spanned, bufferType);
                    runnable.run();
                }
            });
        }
    }
}

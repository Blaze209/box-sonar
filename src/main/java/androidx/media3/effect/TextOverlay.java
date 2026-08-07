package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.media3.common.OverlaySettings;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
public abstract class TextOverlay extends BitmapOverlay {
    public static final int TEXT_SIZE_PIXELS = 100;
    private Bitmap lastBitmap;
    private SpannableString lastText;

    public abstract SpannableString getText(long j);

    public static TextOverlay createStaticTextOverlay(final SpannableString spannableString) {
        return new TextOverlay() { // from class: androidx.media3.effect.TextOverlay.1
            @Override // androidx.media3.effect.TextOverlay
            public SpannableString getText(long j) {
                return spannableString;
            }
        };
    }

    public static TextOverlay createStaticTextOverlay(final SpannableString spannableString, final StaticOverlaySettings staticOverlaySettings) {
        return new TextOverlay() { // from class: androidx.media3.effect.TextOverlay.2
            @Override // androidx.media3.effect.TextOverlay
            public SpannableString getText(long j) {
                return spannableString;
            }

            @Override // androidx.media3.effect.TextureOverlay
            public OverlaySettings getOverlaySettings(long j) {
                return staticOverlaySettings;
            }
        };
    }

    @Override // androidx.media3.effect.BitmapOverlay
    public Bitmap getBitmap(long j) {
        SpannableString text = getText(j);
        if (!text.equals(this.lastText)) {
            this.lastText = text;
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(100.0f);
            StaticLayout staticLayoutCreateStaticLayout = createStaticLayout(text, textPaint, getSpannedTextWidth(text, textPaint));
            Bitmap bitmap = this.lastBitmap;
            if (bitmap == null || bitmap.getWidth() != staticLayoutCreateStaticLayout.getWidth() || this.lastBitmap.getHeight() != staticLayoutCreateStaticLayout.getHeight()) {
                this.lastBitmap = Bitmap.createBitmap(staticLayoutCreateStaticLayout.getWidth(), staticLayoutCreateStaticLayout.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas((Bitmap) Preconditions.checkNotNull(this.lastBitmap));
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            staticLayoutCreateStaticLayout.draw(canvas);
        }
        return (Bitmap) Preconditions.checkNotNull(this.lastBitmap);
    }

    private int getSpannedTextWidth(SpannableString spannableString, TextPaint textPaint) {
        StaticLayout staticLayoutCreateStaticLayout = createStaticLayout(spannableString, textPaint, (int) textPaint.measureText(spannableString, 0, spannableString.length()));
        int lineCount = staticLayoutCreateStaticLayout.getLineCount();
        float lineWidth = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            lineWidth += staticLayoutCreateStaticLayout.getLineWidth(i);
        }
        return (int) Math.ceil(lineWidth);
    }

    private StaticLayout createStaticLayout(SpannableString spannableString, TextPaint textPaint, int i) {
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i).build();
    }
}

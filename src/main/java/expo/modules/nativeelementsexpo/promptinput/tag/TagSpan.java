package expo.modules.nativeelementsexpo.promptinput.tag;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TagSpan.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0003\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J2\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016JP\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006*"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/tag/TagSpan;", "Landroid/text/style/ReplacementSpan;", "backgroundColor", "", "tagValue", "", "type", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", HubsObservability.HUB_ASSET_ICON, "Landroid/graphics/drawable/Drawable;", "textColor", "<init>", "(ILjava/lang/String;Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;Landroid/graphics/drawable/Drawable;I)V", "getBackgroundColor", "()I", "getTagValue", "()Ljava/lang/String;", "getType", "()Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getTextColor", "iconSizePx", "paint", "Landroid/graphics/Paint;", "getSize", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", ViewProps.TOP, "y", ViewProps.BOTTOM, "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagSpan extends ReplacementSpan {
    private static final float CORNER_RADIUS_DP = 4.0f;
    private static final float ICON_TEXT_GAP_PX = 3.0f;
    private static final float VERTICAL_PADDING_PX = 1.0f;
    private final int backgroundColor;
    private final Drawable icon;
    private final String tagValue;
    private final int textColor;
    private final TagType type;
    public static final int $stable = 8;

    public /* synthetic */ TagSpan(int i, String str, TagType tagType, Drawable drawable, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, tagType, (i3 & 8) != 0 ? null : drawable, (i3 & 16) != 0 ? -14540254 : i2);
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getTagValue() {
        return this.tagValue;
    }

    public final TagType getType() {
        return this.type;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public TagSpan(int i, String tagValue, TagType tagType, Drawable drawable, int i2) {
        Intrinsics.checkNotNullParameter(tagValue, "tagValue");
        this.backgroundColor = i;
        this.tagValue = tagValue;
        this.type = tagType;
        this.icon = drawable;
        this.textColor = i2;
    }

    private final int iconSizePx(Paint paint) {
        return RangesKt.coerceAtLeast((int) (-paint.getFontMetrics().ascent), 1);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        float fMeasureText;
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        if (fm != null) {
            paint.getFontMetricsInt(fm);
        }
        if (this.icon != null && start < end) {
            fMeasureText = iconSizePx(paint) + 3.0f + paint.measureText(text, start + 1, end);
        } else {
            fMeasureText = paint.measureText(text, start, end);
        }
        return (int) fMeasureText;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float fMeasureText;
        Paint paint2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f = Resources.getSystem().getDisplayMetrics().density * 4.0f;
        if (this.icon != null && start < end) {
            fMeasureText = iconSizePx(paint) + 3.0f + paint.measureText(text, start + 1, end);
        } else {
            fMeasureText = paint.measureText(text, start, end);
        }
        int color = paint.getColor();
        paint.setColor(this.backgroundColor);
        canvas.drawRoundRect(new RectF(x, top + 1.0f, fMeasureText + x, bottom - 1.0f), f, f, paint);
        paint.setColor(this.textColor);
        boolean zIsFakeBoldText = paint.isFakeBoldText();
        paint.setFakeBoldText(true);
        if (this.icon != null && start < end) {
            int iIconSizePx = iconSizePx(paint);
            int i = ((top + bottom) - iIconSizePx) / 2;
            this.icon.setTint(this.textColor);
            int i2 = (int) x;
            this.icon.setBounds(i2, i, i2 + iIconSizePx, i + iIconSizePx);
            this.icon.draw(canvas);
            canvas.drawText(text, start + 1, end, iIconSizePx + x + 3.0f, y, paint);
            paint2 = paint;
        } else {
            paint2 = paint;
            canvas.drawText(text, start, end, x, y, paint2);
        }
        paint2.setColor(color);
        paint2.setFakeBoldText(zIsFakeBoldText);
    }
}

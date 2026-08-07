package io.noties.markwon.ext.tables;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import io.noties.markwon.core.spans.TextLayoutSpan;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.utils.LeadingMarginUtils;
import io.noties.markwon.utils.SpanUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class TableRowSpan extends ReplacementSpan {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    private final List<Cell> cells;
    private final boolean header;
    private int height;
    private Invalidator invalidator;
    private final List<Layout> layouts;
    private final boolean odd;
    private final TableTheme theme;
    private int width;
    private final Rect rect = new Rect();
    private final Paint paint = new Paint(1);
    private final TextPaint textPaint = new TextPaint();

    @Retention(RetentionPolicy.SOURCE)
    public @interface Alignment {
    }

    public interface Invalidator {
        void invalidate();
    }

    public static class Cell {
        final int alignment;
        final CharSequence text;

        public Cell(int i, CharSequence charSequence) {
            this.alignment = i;
            this.text = charSequence;
        }

        public int alignment() {
            return this.alignment;
        }

        public CharSequence text() {
            return this.text;
        }

        public String toString() {
            return "Cell{alignment=" + this.alignment + ", text=" + ((Object) this.text) + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public TableRowSpan(TableTheme tableTheme, List<Cell> list, boolean z, boolean z2) {
        this.theme = tableTheme;
        this.cells = list;
        this.layouts = new ArrayList(list.size());
        this.header = z;
        this.odd = z2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.layouts.size() > 0 && fontMetricsInt != null) {
            Iterator<Layout> it = this.layouts.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int height = it.next().getHeight();
                if (height > i3) {
                    i3 = height;
                }
            }
            this.height = i3;
            fontMetricsInt.ascent = -(i3 + (this.theme.tableCellPadding() * 2));
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.width;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x015a  */
    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        boolean z;
        Invalidator invalidator;
        int iWidth = SpanUtils.width(canvas, charSequence);
        if (recreateLayouts(iWidth)) {
            this.width = iWidth;
            if (paint instanceof TextPaint) {
                this.textPaint.set((TextPaint) paint);
            } else {
                this.textPaint.set(paint);
            }
            makeNewLayouts();
        }
        int iTableCellPadding = this.theme.tableCellPadding();
        int size = this.layouts.size();
        int iCellWidth = cellWidth(size);
        int i7 = iCellWidth - (this.width / size);
        if (this.header) {
            this.theme.applyTableHeaderRowStyle(this.paint);
        } else if (this.odd) {
            this.theme.applyTableOddRowStyle(this.paint);
        } else {
            this.theme.applyTableEvenRowStyle(this.paint);
        }
        if (this.paint.getColor() != 0) {
            int iSave = canvas.save();
            try {
                this.rect.set(0, 0, this.width, i5 - i3);
                canvas.translate(f, i3);
                canvas.drawRect(this.rect, this.paint);
                canvas.restoreToCount(iSave);
            } catch (Throwable th) {
                canvas.restoreToCount(iSave);
                throw th;
            }
        }
        this.paint.set(paint);
        this.theme.applyTableBorderStyle(this.paint);
        int iTableBorderWidth = this.theme.tableBorderWidth(this.paint);
        boolean z2 = iTableBorderWidth > 0;
        int i8 = i5 - i3;
        int i9 = (i8 - this.height) / 4;
        if (z2) {
            i6 = 0;
            TableSpan[] tableSpanArr = (TableSpan[]) ((Spanned) charSequence).getSpans(i, i2, TableSpan.class);
            if (tableSpanArr == null || tableSpanArr.length <= 0 || !LeadingMarginUtils.selfStart(i, charSequence, tableSpanArr[0])) {
                z = false;
            } else {
                this.rect.set((int) f, i3, this.width, i3 + iTableBorderWidth);
                canvas.drawRect(this.rect, this.paint);
                z = true;
            }
            this.rect.set((int) f, i5 - iTableBorderWidth, this.width, i5);
            canvas.drawRect(this.rect, this.paint);
        } else {
            i6 = 0;
            z = false;
        }
        int i10 = iTableBorderWidth / 2;
        int i11 = z ? iTableBorderWidth : i6;
        int i12 = i8 - iTableBorderWidth;
        int i13 = i6;
        int height = i13;
        while (i13 < size) {
            Layout layout = this.layouts.get(i13);
            int iSave2 = canvas.save();
            int i14 = size;
            try {
                canvas.translate(f + (i13 * iCellWidth), i3);
                if (z2) {
                    if (i13 == 0) {
                        this.rect.set(i6, i11, iTableBorderWidth, i12);
                    } else {
                        this.rect.set(-i10, i11, i10, i12);
                    }
                    canvas.drawRect(this.rect, this.paint);
                    if (i13 == i14 - 1) {
                        this.rect.set((iCellWidth - iTableBorderWidth) - i7, i11, iCellWidth - i7, i12);
                        canvas.drawRect(this.rect, this.paint);
                    }
                }
                canvas.translate(iTableCellPadding, iTableCellPadding + i9);
                layout.draw(canvas);
                if (layout.getHeight() > height) {
                    height = layout.getHeight();
                }
                canvas.restoreToCount(iSave2);
                i13++;
                i10 = i10;
                size = i14;
                i6 = 0;
            } catch (Throwable th2) {
                canvas.restoreToCount(iSave2);
                throw th2;
            }
        }
        if (this.height == height || (invalidator = this.invalidator) == null) {
            return;
        }
        invalidator.invalidate();
    }

    private boolean recreateLayouts(int i) {
        return this.width != i;
    }

    private void makeNewLayouts() {
        this.textPaint.setFakeBoldText(this.header);
        int size = this.cells.size();
        int iCellWidth = cellWidth(size) - (this.theme.tableCellPadding() * 2);
        this.layouts.clear();
        int size2 = this.cells.size();
        for (int i = 0; i < size2; i++) {
            makeLayout(i, iCellWidth, this.cells.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout(final int i, final int i2, final Cell cell) {
        Spannable spannableString;
        Runnable runnable = new Runnable() { // from class: io.noties.markwon.ext.tables.TableRowSpan.1
            @Override // java.lang.Runnable
            public void run() {
                Invalidator invalidator = TableRowSpan.this.invalidator;
                if (invalidator != null) {
                    TableRowSpan.this.layouts.remove(i);
                    TableRowSpan.this.makeLayout(i, i2, cell);
                    invalidator.invalidate();
                }
            }
        };
        if (cell.text instanceof Spannable) {
            spannableString = (Spannable) cell.text;
        } else {
            spannableString = new SpannableString(cell.text);
        }
        Spannable spannable = spannableString;
        StaticLayout staticLayout = new StaticLayout(spannable, this.textPaint, i2, alignment(cell.alignment), 1.0f, 0.0f, false);
        TextLayoutSpan.applyTo(spannable, staticLayout);
        scheduleAsyncDrawables(spannable, runnable);
        this.layouts.add(i, staticLayout);
    }

    private void scheduleAsyncDrawables(Spannable spannable, final Runnable runnable) {
        AsyncDrawableSpan[] asyncDrawableSpanArr = (AsyncDrawableSpan[]) spannable.getSpans(0, spannable.length(), AsyncDrawableSpan.class);
        if (asyncDrawableSpanArr == null || asyncDrawableSpanArr.length <= 0) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArr) {
            AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
            if (!drawable.isAttached()) {
                drawable.setCallback2(new CallbackAdapter() { // from class: io.noties.markwon.ext.tables.TableRowSpan.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // io.noties.markwon.ext.tables.TableRowSpan.CallbackAdapter, android.graphics.drawable.Drawable.Callback
                    public void invalidateDrawable(Drawable drawable2) {
                        runnable.run();
                    }
                });
            }
        }
    }

    public Layout findLayoutForHorizontalOffset(int i) {
        int size = this.layouts.size();
        int iCellWidth = i / cellWidth(size);
        if (iCellWidth >= size) {
            return null;
        }
        return this.layouts.get(iCellWidth);
    }

    public int cellWidth() {
        return cellWidth(this.layouts.size());
    }

    protected int cellWidth(int i) {
        return (int) (((this.width * 1.0f) / i) + 0.5f);
    }

    private static Layout.Alignment alignment(int i) {
        if (i == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (i == 2) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public void invalidator(Invalidator invalidator) {
        this.invalidator = invalidator;
    }

    private static abstract class CallbackAdapter implements Drawable.Callback {
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        private CallbackAdapter() {
        }
    }
}

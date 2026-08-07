package io.noties.markwon.recycler.table;

import android.graphics.Paint;
import io.noties.markwon.ext.tables.TableTheme;
import io.noties.markwon.utils.ColorUtils;

/* JADX INFO: loaded from: classes4.dex */
public class TableEntryTheme extends TableTheme {
    public static TableEntryTheme create(TableTheme tableTheme) {
        return new TableEntryTheme(tableTheme.asBuilder());
    }

    protected TableEntryTheme(TableTheme.Builder builder) {
        super(builder);
    }

    @Override // io.noties.markwon.ext.tables.TableTheme
    public int tableCellPadding() {
        return this.tableCellPadding;
    }

    public int tableBorderColor(Paint paint) {
        if (this.tableBorderColor == 0) {
            return ColorUtils.applyAlpha(paint.getColor(), 75);
        }
        return this.tableBorderColor;
    }

    @Override // io.noties.markwon.ext.tables.TableTheme
    public int tableBorderWidth(Paint paint) {
        if (this.tableBorderWidth < 0) {
            return (int) (paint.getStrokeWidth() + 0.5f);
        }
        return this.tableBorderWidth;
    }

    public int tableOddRowBackgroundColor(Paint paint) {
        if (this.tableOddRowBackgroundColor == 0) {
            return ColorUtils.applyAlpha(paint.getColor(), 22);
        }
        return this.tableOddRowBackgroundColor;
    }

    public int tableEvenRowBackgroundColor() {
        return this.tableEvenRowBackgroundColor;
    }

    public int tableHeaderRowBackgroundColor() {
        return this.tableHeaderRowBackgroundColor;
    }
}

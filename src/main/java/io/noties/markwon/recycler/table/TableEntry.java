package io.noties.markwon.recycler.table;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import io.noties.markwon.ext.tables.Table;
import io.noties.markwon.recycler.MarkwonAdapter;
import io.noties.markwon.utils.NoCopySpannableFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.commonmark.ext.gfm.tables.TableBlock;

/* JADX INFO: loaded from: classes4.dex */
public class TableEntry extends MarkwonAdapter.Entry<TableBlock, Holder> {
    private final boolean cellTextCenterVertical;
    private LayoutInflater inflater;
    private final boolean isRecyclable;
    private final Map<TableBlock, Table> map = new HashMap(3);
    private final int tableIdRes;
    private final int tableLayoutResId;
    private final int textIdRes;
    private final int textLayoutResId;

    public interface Builder {
        TableEntry build();

        Builder cellTextCenterVertical(boolean z);

        Builder isRecyclable(boolean z);

        Builder tableLayout(int i, int i2);

        Builder tableLayoutIsRoot(int i);

        Builder textLayout(int i, int i2);

        Builder textLayoutIsRoot(int i);
    }

    public interface BuilderConfigure {
        void configure(Builder builder);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static TableEntry create(BuilderConfigure builderConfigure) {
        Builder builder = builder();
        builderConfigure.configure(builder);
        return builder.build();
    }

    TableEntry(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.tableLayoutResId = i;
        this.tableIdRes = i2;
        this.textLayoutResId = i3;
        this.textIdRes = i4;
        this.isRecyclable = z;
        this.cellTextCenterVertical = z2;
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public Holder createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new Holder(this.isRecyclable, this.tableIdRes, layoutInflater.inflate(this.tableLayoutResId, viewGroup, false));
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public void bindHolder(Markwon markwon, Holder holder, TableBlock tableBlock) {
        int i;
        Table table = this.map.get(tableBlock);
        if (table == null) {
            table = Table.parse(markwon, tableBlock);
            this.map.put(tableBlock, table);
        }
        TableLayout tableLayout = holder.tableLayout;
        if (table == null || table == tableLayout.getTag(this.tableLayoutResId)) {
            return;
        }
        tableLayout.setTag(this.tableLayoutResId, table);
        TableEntryPlugin tableEntryPlugin = (TableEntryPlugin) markwon.getPlugin(TableEntryPlugin.class);
        if (tableEntryPlugin == null) {
            throw new IllegalStateException("No TableEntryPlugin is found. Make sure that it is _used_ whilst configuring Markwon instance");
        }
        TableEntryTheme tableEntryThemeTheme = tableEntryPlugin.theme();
        int i2 = 0;
        TextView textViewEnsureTextView = ensureTextView(tableLayout, 0, 0);
        int iTableBorderWidth = tableEntryThemeTheme.tableBorderWidth(textViewEnsureTextView.getPaint());
        int iTableBorderColor = tableEntryThemeTheme.tableBorderColor(textViewEnsureTextView.getPaint());
        int iTableCellPadding = tableEntryThemeTheme.tableCellPadding();
        ensureTableBorderBackground(tableLayout, iTableBorderWidth, iTableBorderColor);
        List<Table.Row> listRows = table.rows();
        int size = listRows.size();
        int size2 = size > 0 ? listRows.get(0).columns().size() : 0;
        int i3 = 0;
        while (i3 < size) {
            Table.Row row = listRows.get(i3);
            TableRow tableRowEnsureRow = ensureRow(tableLayout, i3);
            int i4 = i2;
            while (i4 < size2) {
                Table.Column column = row.columns().get(i4);
                TextView textViewEnsureTextView2 = ensureTextView(tableLayout, i3, i4);
                List<Table.Row> list = listRows;
                Table.Row row2 = row;
                textViewEnsureTextView2.setGravity(textGravity(column.alignment(), this.cellTextCenterVertical));
                textViewEnsureTextView2.getPaint().setFakeBoldText(row2.header());
                if (iTableCellPadding > 0) {
                    textViewEnsureTextView2.setPadding(iTableCellPadding, iTableCellPadding, iTableCellPadding, iTableCellPadding);
                }
                ensureTableBorderBackground(textViewEnsureTextView2, iTableBorderWidth, iTableBorderColor);
                markwon.setParsedMarkdown(textViewEnsureTextView2, column.content());
                i4++;
                listRows = list;
                row = row2;
            }
            List<Table.Row> list2 = listRows;
            if (row.header()) {
                tableRowEnsureRow.setBackgroundColor(tableEntryThemeTheme.tableHeaderRowBackgroundColor());
            } else {
                if (i3 % 2 == 1) {
                    tableRowEnsureRow.setBackgroundColor(tableEntryThemeTheme.tableEvenRowBackgroundColor());
                } else {
                    i = 0;
                    tableRowEnsureRow.setBackgroundColor(tableEntryThemeTheme.tableOddRowBackgroundColor(ensureTextView(tableLayout, i3, 0).getPaint()));
                }
                i3++;
                i2 = i;
                listRows = list2;
            }
            i = 0;
            i3++;
            i2 = i;
            listRows = list2;
        }
        removeUnused(tableLayout, size, size2);
    }

    private TableRow ensureRow(TableLayout tableLayout, int i) {
        int childCount = tableLayout.getChildCount();
        if (i >= childCount) {
            Context context = tableLayout.getContext();
            for (int i2 = (i - childCount) + 1; i2 > 0; i2--) {
                tableLayout.addView(new TableRow(context));
            }
        }
        return (TableRow) tableLayout.getChildAt(i);
    }

    private TextView ensureTextView(TableLayout tableLayout, int i, int i2) {
        TextView textView;
        TableRow tableRowEnsureRow = ensureRow(tableLayout, i);
        int childCount = tableRowEnsureRow.getChildCount();
        if (i2 >= childCount) {
            LayoutInflater layoutInflaterEnsureInflater = ensureInflater(tableLayout.getContext());
            boolean z = false;
            for (int i3 = (i2 - childCount) + 1; i3 > 0; i3--) {
                View viewInflate = layoutInflaterEnsureInflater.inflate(this.textLayoutResId, (ViewGroup) tableRowEnsureRow, false);
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                if (layoutParams.height != -1) {
                    layoutParams.height = -1;
                }
                if (!z) {
                    int i4 = this.textIdRes;
                    if (i4 == 0) {
                        if (!(viewInflate instanceof TextView)) {
                            throw new IllegalStateException(String.format("textLayoutResId(R.layout.%s) has other than TextView root view. Specify TextView ID explicitly", tableLayout.getContext().getResources().getResourceName(this.textLayoutResId)));
                        }
                        textView = (TextView) viewInflate;
                    } else {
                        TextView textView2 = (TextView) viewInflate.findViewById(i4);
                        if (textView2 == null) {
                            Resources resources = tableLayout.getContext().getResources();
                            throw new NullPointerException(String.format("textLayoutResId(R.layout.%s) has no TextView found by id(R.id.%s): %s", resources.getResourceName(this.textLayoutResId), resources.getResourceName(this.textIdRes), viewInflate));
                        }
                        textView = textView2;
                    }
                    z = true;
                } else {
                    int i5 = this.textIdRes;
                    if (i5 == 0) {
                        textView = (TextView) viewInflate;
                    } else {
                        textView = (TextView) viewInflate.findViewById(i5);
                    }
                }
                textView.setSpannableFactory(NoCopySpannableFactory.getInstance());
                tableRowEnsureRow.addView(textView);
            }
        }
        View childAt = tableRowEnsureRow.getChildAt(i2);
        int i6 = this.textIdRes;
        if (i6 == 0) {
            return (TextView) childAt;
        }
        return (TextView) childAt.findViewById(i6);
    }

    private void ensureTableBorderBackground(View view, int i, int i2) {
        if (i == 0) {
            view.setBackground(null);
            return;
        }
        Drawable background = view.getBackground();
        if (!(background instanceof TableBorderDrawable)) {
            TableBorderDrawable tableBorderDrawable = new TableBorderDrawable();
            tableBorderDrawable.update(i, i2);
            view.setBackground(tableBorderDrawable);
            return;
        }
        ((TableBorderDrawable) background).update(i, i2);
    }

    private LayoutInflater ensureInflater(Context context) {
        if (this.inflater == null) {
            this.inflater = LayoutInflater.from(context);
        }
        return this.inflater;
    }

    static void removeUnused(TableLayout tableLayout, int i, int i2) {
        int childCount = tableLayout.getChildCount();
        if (childCount > i) {
            tableLayout.removeViews(i, childCount - i);
        }
        for (int i3 = 0; i3 < i; i3++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i3);
            int childCount2 = tableRow.getChildCount();
            if (childCount2 > i2) {
                tableRow.removeViews(i2, childCount2 - i2);
            }
        }
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public void clear() {
        this.map.clear();
    }

    public static class Holder extends MarkwonAdapter.Holder {
        final TableLayout tableLayout;

        public Holder(boolean z, int i, View view) {
            TableLayout tableLayout;
            super(view);
            setIsRecyclable(z);
            if (i == 0) {
                if (!(view instanceof TableLayout)) {
                    throw new IllegalStateException("Root view is not TableLayout. Please provide TableLayout ID explicitly");
                }
                tableLayout = (TableLayout) view;
            } else {
                tableLayout = (TableLayout) requireView(i);
            }
            this.tableLayout = tableLayout;
        }
    }

    /* JADX INFO: renamed from: io.noties.markwon.recycler.table.TableEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$noties$markwon$ext$tables$Table$Alignment;

        static {
            int[] iArr = new int[Table.Alignment.values().length];
            $SwitchMap$io$noties$markwon$ext$tables$Table$Alignment = iArr;
            try {
                iArr[Table.Alignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$noties$markwon$ext$tables$Table$Alignment[Table.Alignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$noties$markwon$ext$tables$Table$Alignment[Table.Alignment.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static int textGravity(Table.Alignment alignment, boolean z) {
        int i = AnonymousClass1.$SwitchMap$io$noties$markwon$ext$tables$Table$Alignment[alignment.ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 1;
            } else {
                if (i != 3) {
                    throw new IllegalStateException("Unknown table alignment: " + alignment);
                }
                i2 = 5;
            }
        }
        return z ? i2 | 16 : i2;
    }

    static class BuilderImpl implements Builder {
        private boolean cellTextCenterVertical = true;
        private boolean isRecyclable = true;
        private int tableIdRes;
        private int tableLayoutResId;
        private int textIdRes;
        private int textLayoutResId;

        BuilderImpl() {
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public Builder tableLayout(int i, int i2) {
            this.tableLayoutResId = i;
            this.tableIdRes = i2;
            return this;
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public Builder tableLayoutIsRoot(int i) {
            this.tableLayoutResId = i;
            this.tableIdRes = 0;
            return this;
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public Builder textLayout(int i, int i2) {
            this.textLayoutResId = i;
            this.textIdRes = i2;
            return this;
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public Builder textLayoutIsRoot(int i) {
            this.textLayoutResId = i;
            this.textIdRes = 0;
            return this;
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public Builder cellTextCenterVertical(boolean z) {
            this.cellTextCenterVertical = z;
            return this;
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public Builder isRecyclable(boolean z) {
            this.isRecyclable = z;
            return this;
        }

        @Override // io.noties.markwon.recycler.table.TableEntry.Builder
        public TableEntry build() {
            if (this.tableLayoutResId == 0) {
                throw new IllegalStateException("`tableLayoutResId` argument is required");
            }
            if (this.textLayoutResId == 0) {
                throw new IllegalStateException("`textLayoutResId` argument is required");
            }
            return new TableEntry(this.tableLayoutResId, this.tableIdRes, this.textLayoutResId, this.textIdRes, this.isRecyclable, this.cellTextCenterVertical);
        }
    }
}

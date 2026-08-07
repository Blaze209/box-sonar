package io.noties.markwon.recycler.table;

import android.content.Context;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.ext.tables.TableTheme;
import java.util.Collections;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes4.dex */
public class TableEntryPlugin extends AbstractMarkwonPlugin {
    private final TableEntryTheme theme;

    public static TableEntryPlugin create(Context context) {
        return create(TableTheme.create(context));
    }

    public static TableEntryPlugin create(TableTheme tableTheme) {
        return new TableEntryPlugin(TableEntryTheme.create(tableTheme));
    }

    public static TableEntryPlugin create(TablePlugin.ThemeConfigure themeConfigure) {
        TableTheme.Builder builder = new TableTheme.Builder();
        themeConfigure.configureTheme(builder);
        return new TableEntryPlugin(new TableEntryTheme(builder));
    }

    public static TableEntryPlugin create(TablePlugin tablePlugin) {
        return create(tablePlugin.theme());
    }

    TableEntryPlugin(TableEntryTheme tableEntryTheme) {
        this.theme = tableEntryTheme;
    }

    public TableEntryTheme theme() {
        return this.theme;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
        builder.extensions(Collections.singleton(TablesExtension.create()));
    }
}

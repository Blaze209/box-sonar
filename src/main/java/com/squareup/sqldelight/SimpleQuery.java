package com.squareup.sqldelight;

import com.box.android.common.utilities.BoxCommonConstants;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.db.SqlDriver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Query.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BS\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/squareup/sqldelight/SimpleQuery;", "RowType", "", "Lcom/squareup/sqldelight/Query;", "identifier", "", "queries", "", "driver", "Lcom/squareup/sqldelight/db/SqlDriver;", BoxCommonConstants.EXTRA_FILE_NAME, "", "label", "query", "mapper", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlCursor;", "(ILjava/util/List;Lcom/squareup/sqldelight/db/SqlDriver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "execute", "toString", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class SimpleQuery<RowType> extends Query<RowType> {
    private final SqlDriver driver;
    private final String fileName;
    private final int identifier;
    private final String label;
    private final String query;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleQuery(int i, List<Query<?>> queries, SqlDriver driver, String fileName, String label, String query, Function1<? super SqlCursor, ? extends RowType> mapper) {
        super(queries, mapper);
        Intrinsics.checkNotNullParameter(queries, "queries");
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.identifier = i;
        this.driver = driver;
        this.fileName = fileName;
        this.label = label;
        this.query = query;
    }

    @Override // com.squareup.sqldelight.Query
    public SqlCursor execute() {
        return SqlDriver.DefaultImpls.executeQuery$default(this.driver, Integer.valueOf(this.identifier), this.query, 0, null, 8, null);
    }

    public String toString() {
        return this.fileName + AbstractJsonLexerKt.COLON + this.label;
    }
}

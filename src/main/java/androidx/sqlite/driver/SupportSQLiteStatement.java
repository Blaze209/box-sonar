package androidx.sqlite.driver;

import android.database.Cursor;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00132\u00020\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0001\u0004\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "getDb", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "getSql", "()Ljava/lang/String;", "isClosed", "", "()Z", "setClosed", "(Z)V", "throwIfClosed", "", "Companion", "TransactionSQLiteStatement", "JournalModeSetStatement", "RowSQLiteStatement", "OtherSQLiteStatement", "Landroidx/sqlite/driver/SupportSQLiteStatement$JournalModeSetStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement$OtherSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement$RowSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement$TransactionSQLiteStatement;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SupportSQLiteStatement implements SQLiteStatement {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SupportSQLiteDatabase db;
    private boolean isClosed;
    private final String sql;

    public /* synthetic */ SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(supportSQLiteDatabase, str);
    }

    private SupportSQLiteStatement(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        this.db = supportSQLiteDatabase;
        this.sql = str;
    }

    protected final SupportSQLiteDatabase getDb() {
        return this.db;
    }

    protected final String getSql() {
        return this.sql;
    }

    /* JADX INFO: renamed from: isClosed, reason: from getter */
    protected final boolean getIsClosed() {
        return this.isClosed;
    }

    protected final void setClosed(boolean z) {
        this.isClosed = z;
    }

    protected final void throwIfClosed() {
        if (this.isClosed) {
            SQLite.throwSQLiteException(21, "statement is closed");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\tH\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002¨\u0006\u0018"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Landroidx/sqlite/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "getTransactionOperation", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "prefix", "getSpecialOperation", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation;", "isRowStatement", "", "getStatementPrefix", "getStatementPrefix$sqlite_framework", "getStatementPrefixIndex", "", "s", "TransactionOperation", "SpecialOperation", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "", "<init>", "(Ljava/lang/String;I)V", "END", "ROLLBACK", "BEGIN_EXCLUSIVE", "BEGIN_IMMEDIATE", "BEGIN_DEFERRED", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        private enum TransactionOperation {
            END,
            ROLLBACK,
            BEGIN_EXCLUSIVE,
            BEGIN_IMMEDIATE,
            BEGIN_DEFERRED;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<TransactionOperation> getEntries() {
                return $ENTRIES;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SupportSQLiteStatement create(SupportSQLiteDatabase db, String sql) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            String upperCase = StringsKt.trim((CharSequence) sql).toString().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String statementPrefix$sqlite_framework = getStatementPrefix$sqlite_framework(upperCase);
            if (statementPrefix$sqlite_framework == null) {
                return new OtherSQLiteStatement(db, sql);
            }
            TransactionOperation transactionOperation = getTransactionOperation(statementPrefix$sqlite_framework, upperCase);
            if (transactionOperation != null) {
                return new TransactionSQLiteStatement(db, sql, transactionOperation);
            }
            if (getSpecialOperation(statementPrefix$sqlite_framework, upperCase) instanceof SpecialOperation.JournalModeOperation) {
                return new JournalModeSetStatement(db, sql, new RowSQLiteStatement(db, sql));
            }
            if (isRowStatement(statementPrefix$sqlite_framework)) {
                return new RowSQLiteStatement(db, sql);
            }
            return new OtherSQLiteStatement(db, sql);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        
            if (r4.equals("END") == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        
            if (r4.equals("COM") == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        
            return androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.END;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation getTransactionOperation(java.lang.String r4, java.lang.String r5) {
            /*
                r3 = this;
                int r3 = r4.hashCode()
                r0 = 2
                r1 = 0
                r2 = 0
                switch(r3) {
                    case 65636: goto L39;
                    case 66913: goto L2d;
                    case 68795: goto L24;
                    case 81327: goto Lb;
                    default: goto La;
                }
            La:
                goto L61
            Lb:
                java.lang.String r3 = "ROL"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L14
                goto L61
            L14:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r3 = " TO "
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = kotlin.text.StringsKt.contains$default(r5, r3, r1, r0, r2)
                if (r3 == 0) goto L21
                return r2
            L21:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.ROLLBACK
                return r3
            L24:
                java.lang.String r3 = "END"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L36
                goto L61
            L2d:
                java.lang.String r3 = "COM"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L36
                goto L61
            L36:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.END
                return r3
            L39:
                java.lang.String r3 = "BEG"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L42
                goto L61
            L42:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                java.lang.String r3 = "EXCLUSIVE"
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = kotlin.text.StringsKt.contains$default(r5, r3, r1, r0, r2)
                if (r3 == 0) goto L51
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.BEGIN_EXCLUSIVE
                return r3
            L51:
                java.lang.String r3 = "IMMEDIATE"
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = kotlin.text.StringsKt.contains$default(r5, r3, r1, r0, r2)
                if (r3 == 0) goto L5e
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.BEGIN_IMMEDIATE
                return r3
            L5e:
                androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation r3 = androidx.sqlite.driver.SupportSQLiteStatement.Companion.TransactionOperation.BEGIN_DEFERRED
                return r3
            L61:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.driver.SupportSQLiteStatement.Companion.getTransactionOperation(java.lang.String, java.lang.String):androidx.sqlite.driver.SupportSQLiteStatement$Companion$TransactionOperation");
        }

        private final SpecialOperation getSpecialOperation(String prefix, String sql) {
            if (!Intrinsics.areEqual(prefix, "PRA")) {
                return null;
            }
            String lowerCase = sql.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return StringsKt.contains$default((CharSequence) StringsKt.substringAfter(lowerCase, "journal_mode", ""), (CharSequence) SimpleComparison.EQUAL_TO_OPERATION, false, 2, (Object) null) ? SpecialOperation.JournalModeOperation.INSTANCE : null;
        }

        private final boolean isRowStatement(String prefix) {
            int iHashCode = prefix.hashCode();
            if (iHashCode == 79487) {
                return prefix.equals("PRA");
            }
            if (iHashCode != 81978) {
                return iHashCode == 85954 && prefix.equals("WIT");
            }
            return prefix.equals("SEL");
        }

        public final String getStatementPrefix$sqlite_framework(String sql) {
            Intrinsics.checkNotNullParameter(sql, "sql");
            int statementPrefixIndex = getStatementPrefixIndex(sql);
            if (statementPrefixIndex < 0 || statementPrefixIndex > sql.length()) {
                return null;
            }
            String strSubstring = sql.substring(statementPrefixIndex, Math.min(statementPrefixIndex + 3, sql.length()));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        private final int getStatementPrefixIndex(String s) {
            int i;
            int length = s.length() - 2;
            if (length < 0) {
                return -1;
            }
            int iIndexOf$default = 0;
            while (iIndexOf$default < length) {
                char cCharAt = s.charAt(iIndexOf$default);
                if (Intrinsics.compare((int) cCharAt, 32) > 0) {
                    if (cCharAt == '-') {
                        if (s.charAt(iIndexOf$default + 1) == '-') {
                            iIndexOf$default = StringsKt.indexOf$default((CharSequence) s, '\n', iIndexOf$default + 2, false, 4, (Object) null);
                            if (iIndexOf$default < 0) {
                                return -1;
                            }
                        }
                    } else if (cCharAt == '/') {
                        int iIndexOf$default2 = iIndexOf$default + 1;
                        if (s.charAt(iIndexOf$default2) == '*') {
                            do {
                                iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) s, '*', iIndexOf$default2 + 1, false, 4, (Object) null);
                                if (iIndexOf$default2 >= 0) {
                                    i = iIndexOf$default2 + 1;
                                    if (i >= length) {
                                        break;
                                    }
                                } else {
                                    return -1;
                                }
                            } while (s.charAt(i) != '/');
                            iIndexOf$default = iIndexOf$default2 + 2;
                        }
                    }
                    return iIndexOf$default;
                }
                iIndexOf$default++;
            }
            return -1;
        }

        /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation;", "", "<init>", "()V", "JournalModeOperation", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation;", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        private static abstract class SpecialOperation {
            public /* synthetic */ SpecialOperation(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation$JournalModeOperation;", "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$SpecialOperation;", "<init>", "()V", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class JournalModeOperation extends SpecialOperation {
                public static final JournalModeOperation INSTANCE = new JournalModeOperation();

                private JournalModeOperation() {
                    super(null);
                }
            }

            private SpecialOperation() {
            }
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006%"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$TransactionSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", SerializedNames.OPERATION, "Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;)V", "getOperation", "()Landroidx/sqlite/driver/SupportSQLiteStatement$Companion$TransactionOperation;", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "bindLong", "", "bindText", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", HeaderElements.CLOSE, "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class TransactionSQLiteStatement extends SupportSQLiteStatement {
        private final Companion.TransactionOperation operation;

        /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Companion.TransactionOperation.values().length];
                try {
                    iArr[Companion.TransactionOperation.END.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Companion.TransactionOperation.ROLLBACK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Companion.TransactionOperation.BEGIN_EXCLUSIVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Companion.TransactionOperation.BEGIN_IMMEDIATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Companion.TransactionOperation.BEGIN_DEFERRED.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final Companion.TransactionOperation getOperation() {
            return this.operation;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionSQLiteStatement(SupportSQLiteDatabase db, String sql, Companion.TransactionOperation operation) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(operation, "operation");
            this.operation = operation;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindBlob */
        public void mo10940bindBlob(int index, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindDouble */
        public void mo10941bindDouble(int index, double value) {
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindLong */
        public void mo10942bindLong(int index, long value) {
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindText */
        public void mo10944bindText(int index, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindNull */
        public void mo10943bindNull(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(25, "column index out of range");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            int i = WhenMappings.$EnumSwitchMapping$0[this.operation.ordinal()];
            if (i == 1) {
                getDb().setTransactionSuccessful();
                getDb().endTransaction();
                return false;
            }
            if (i == 2) {
                getDb().endTransaction();
                return false;
            }
            if (i == 3) {
                getDb().beginTransaction();
                return false;
            }
            if (i == 4) {
                getDb().beginTransactionNonExclusive();
                return false;
            }
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            getDb().beginTransactionReadOnly();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: clearBindings */
        public void mo10945clearBindings() {
            throwIfClosed();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            setClosed(true);
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001b\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u001b\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096\u0001J\u001b\u0010\u0013\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0014H\u0096\u0001J\u001b\u0010\u0015\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0016H\u0096\u0001J\u001b\u0010\u0017\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u001b\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0019H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u001b\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0096\u0001J\t\u0010\u001c\u001a\u00020\rH\u0096\u0001J\t\u0010\u001d\u001a\u00020\rH\u0096\u0001J\u0013\u0010\u001e\u001a\u00020\u00112\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010 \u001a\u00020\u000fH\u0096\u0001J\u0013\u0010!\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0096\u0001J\u0013\u0010$\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010%\u001a\u00020\u00142\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010&\u001a\u00020\u00162\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010'\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010(\u001a\u00020\u00192\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010)\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010*\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010+\u001a\u00020\rH\u0096\u0001R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$JournalModeSetStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "Landroidx/sqlite/SQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "delegate", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;Landroidx/sqlite/driver/SupportSQLiteStatement;)V", "step", "", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindBoolean", "bindDouble", "", "bindFloat", "", "bindInt", "bindLong", "", "bindNull", "bindText", "clearBindings", HeaderElements.CLOSE, "getBlob", "getBoolean", "getColumnCount", "getColumnName", "getColumnNames", "", "getColumnType", "getDouble", "getFloat", "getInt", "getLong", "getText", "isNull", "reset", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class JournalModeSetStatement extends SupportSQLiteStatement implements SQLiteStatement {
        private final SupportSQLiteStatement delegate;

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindBlob */
        public void mo10940bindBlob(int index, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.delegate.mo10940bindBlob(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindBoolean(int index, boolean value) {
            this.delegate.bindBoolean(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindDouble */
        public void mo10941bindDouble(int index, double value) {
            this.delegate.mo10941bindDouble(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindFloat(int index, float value) {
            this.delegate.bindFloat(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void bindInt(int index, int value) {
            this.delegate.bindInt(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindLong */
        public void mo10942bindLong(int index, long value) {
            this.delegate.mo10942bindLong(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindNull */
        public void mo10943bindNull(int index) {
            this.delegate.mo10943bindNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindText */
        public void mo10944bindText(int index, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.delegate.mo10944bindText(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: clearBindings */
        public void mo10945clearBindings() {
            this.delegate.mo10945clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            return this.delegate.getBlob(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean getBoolean(int index) {
            return this.delegate.getBoolean(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            return this.delegate.getColumnName(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public List<String> getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            return this.delegate.getColumnType(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            return this.delegate.getDouble(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public float getFloat(int index) {
            return this.delegate.getFloat(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getInt(int index) {
            return this.delegate.getInt(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            return this.delegate.getLong(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            return this.delegate.getText(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            return this.delegate.isNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            this.delegate.reset();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JournalModeSetStatement(SupportSQLiteDatabase db, String sql, SupportSQLiteStatement delegate) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.delegate = delegate;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            boolean zStep = this.delegate.step();
            if (StringsKt.equals(getText(0), "wal", true)) {
                getDb().enableWriteAheadLogging();
                return zStep;
            }
            getDb().disableWriteAheadLogging();
            return zStep;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0017H\u0016J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J\u0018\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$RowSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "bindingTypes", "", "longBindings", "", "doubleBindings", "", "stringBindings", "", "[Ljava/lang/String;", "blobBindings", "", "[[B", "cursor", "Landroid/database/Cursor;", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "bindDouble", "", "bindLong", "", "bindText", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", HeaderElements.CLOSE, "ensureCapacity", "columnType", "ensureCursor", "throwIfNoRow", "throwIfInvalidColumn", "c", "Companion", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class RowSQLiteStatement extends SupportSQLiteStatement {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private int[] bindingTypes;
        private byte[][] blobBindings;
        private Cursor cursor;
        private double[] doubleBindings;
        private long[] longBindings;
        private String[] stringBindings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RowSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindBlob */
        public void mo10940bindBlob(int index, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            ensureCapacity(4, index);
            this.bindingTypes[index] = 4;
            this.blobBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindDouble */
        public void mo10941bindDouble(int index, double value) {
            throwIfClosed();
            ensureCapacity(2, index);
            this.bindingTypes[index] = 2;
            this.doubleBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindLong */
        public void mo10942bindLong(int index, long value) {
            throwIfClosed();
            ensureCapacity(1, index);
            this.bindingTypes[index] = 1;
            this.longBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindText */
        public void mo10944bindText(int index, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            ensureCapacity(3, index);
            this.bindingTypes[index] = 3;
            this.stringBindings[index] = value;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindNull */
        public void mo10943bindNull(int index) {
            throwIfClosed();
            ensureCapacity(5, index);
            this.bindingTypes[index] = 5;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            byte[] blob = cursorThrowIfNoRow.getBlob(index);
            Intrinsics.checkNotNullExpressionValue(blob, "getBlob(...)");
            return blob;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            return cursorThrowIfNoRow.getDouble(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            return cursorThrowIfNoRow.getLong(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            String string = cursorThrowIfNoRow.getString(index);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            throwIfClosed();
            Cursor cursorThrowIfNoRow = throwIfNoRow();
            throwIfInvalidColumn(cursorThrowIfNoRow, index);
            return cursorThrowIfNoRow.isNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.getColumnCount();
            }
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            throwIfInvalidColumn(cursor, index);
            String columnName = cursor.getColumnName(index);
            Intrinsics.checkNotNullExpressionValue(columnName, "getColumnName(...)");
            return columnName;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            throwIfInvalidColumn(cursor, index);
            return INSTANCE.getDataType(cursor, index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            ensureCursor();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor.moveToNext();
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
            Cursor cursor = this.cursor;
            if (cursor != null) {
                cursor.close();
            }
            this.cursor = null;
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: clearBindings */
        public void mo10945clearBindings() {
            throwIfClosed();
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (!getIsClosed()) {
                mo10945clearBindings();
                reset();
            }
            setClosed(true);
        }

        private final void ensureCapacity(int columnType, int index) {
            int i = index + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, i);
                Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
                this.bindingTypes = iArrCopyOf;
            }
            if (columnType == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, i);
                    Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
                    this.longBindings = jArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i) {
                    double[] dArrCopyOf = Arrays.copyOf(dArr, i);
                    Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
                    this.doubleBindings = dArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i) {
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, i);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    this.stringBindings = (String[]) objArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i) {
                Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
                this.blobBindings = (byte[][]) objArrCopyOf2;
            }
        }

        private final void ensureCursor() {
            if (this.cursor == null) {
                this.cursor = getDb().query(new SupportSQLiteQuery() { // from class: androidx.sqlite.driver.SupportSQLiteStatement$RowSQLiteStatement$ensureCursor$1
                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public String getSql() {
                        return this.this$0.getSql();
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public void bindTo(SupportSQLiteProgram statement) {
                        Intrinsics.checkNotNullParameter(statement, "statement");
                        int length = this.this$0.bindingTypes.length;
                        for (int i = 1; i < length; i++) {
                            int i2 = this.this$0.bindingTypes[i];
                            if (i2 == 1) {
                                statement.bindLong(i, this.this$0.longBindings[i]);
                            } else if (i2 == 2) {
                                statement.bindDouble(i, this.this$0.doubleBindings[i]);
                            } else if (i2 == 3) {
                                String str = this.this$0.stringBindings[i];
                                Intrinsics.checkNotNull(str);
                                statement.bindString(i, str);
                            } else if (i2 == 4) {
                                byte[] bArr = this.this$0.blobBindings[i];
                                Intrinsics.checkNotNull(bArr);
                                statement.bindBlob(i, bArr);
                            } else if (i2 == 5) {
                                statement.bindNull(i);
                            }
                        }
                    }

                    @Override // androidx.sqlite.db.SupportSQLiteQuery
                    public int getArgCount() {
                        return this.this$0.bindingTypes.length;
                    }
                });
            }
        }

        private final Cursor throwIfNoRow() {
            Cursor cursor = this.cursor;
            if (cursor != null) {
                return cursor;
            }
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        private final void throwIfInvalidColumn(Cursor c, int index) {
            if (index < 0 || index >= c.getColumnCount()) {
                SQLite.throwSQLiteException(25, "column index out of range");
                throw new KotlinNothingValueException();
            }
        }

        /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$RowSQLiteStatement$Companion;", "", "<init>", "()V", "getDataType", "", "Landroid/database/Cursor;", FirebaseAnalytics.Param.INDEX, "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int getDataType(Cursor cursor, int i) {
                int type = cursor.getType(i);
                int type2 = cursor.getType(i);
                if (type2 == 0) {
                    return 5;
                }
                int i2 = 1;
                if (type2 != 1) {
                    i2 = 2;
                    if (type2 != 2) {
                        i2 = 3;
                        if (type2 != 3) {
                            if (type2 == 4) {
                                return 4;
                            }
                            throw new IllegalStateException(("Unknown field type: " + type).toString());
                        }
                    }
                }
                return i2;
            }
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteStatement.android.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/sqlite/driver/SupportSQLiteStatement$OtherSQLiteStatement;", "Landroidx/sqlite/driver/SupportSQLiteStatement;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "sql", "", "<init>", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "delegate", "Landroidx/sqlite/db/SupportSQLiteStatement;", "Landroidx/sqlite/driver/SupportStatement;", "bindBlob", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "bindLong", "", "bindText", "bindNull", "getBlob", "getDouble", "getLong", "getText", "isNull", "", "getColumnCount", "getColumnName", "getColumnType", "step", "reset", "clearBindings", HeaderElements.CLOSE, "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class OtherSQLiteStatement extends SupportSQLiteStatement {
        private final androidx.sqlite.db.SupportSQLiteStatement delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OtherSQLiteStatement(SupportSQLiteDatabase db, String sql) {
            super(db, sql, null);
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(sql, "sql");
            this.delegate = db.compileStatement(sql);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindBlob */
        public void mo10940bindBlob(int index, byte[] value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            this.delegate.bindBlob(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindDouble */
        public void mo10941bindDouble(int index, double value) {
            throwIfClosed();
            this.delegate.bindDouble(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindLong */
        public void mo10942bindLong(int index, long value) {
            throwIfClosed();
            this.delegate.bindLong(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindText */
        public void mo10944bindText(int index, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            throwIfClosed();
            this.delegate.bindString(index, value);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: bindNull */
        public void mo10943bindNull(int index) {
            throwIfClosed();
            this.delegate.bindNull(index);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            throwIfClosed();
            return 0;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int index) {
            throwIfClosed();
            SQLite.throwSQLiteException(21, "no row");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            throwIfClosed();
            this.delegate.execute();
            return false;
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            throwIfClosed();
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* JADX INFO: renamed from: clearBindings */
        public void mo10945clearBindings() {
            throwIfClosed();
            this.delegate.clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            setClosed(true);
        }
    }
}

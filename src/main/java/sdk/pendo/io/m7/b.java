package sdk.pendo.io.m7;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements sdk.pendo.io.m7.a {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<sdk.pendo.io.m7.c> b;
    private final SharedSQLiteStatement c;
    private final SharedSQLiteStatement d;
    private final SharedSQLiteStatement e;

    class a implements Callable<Integer> {
        final /* synthetic */ RoomSQLiteQuery a;

        a(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            Cursor cursorQuery = DBUtil.query(b.this.a, this.a, false, null);
            try {
                return cursorQuery.moveToFirst() ? Integer.valueOf(cursorQuery.getInt(0)) : 0;
            } finally {
                cursorQuery.close();
                this.a.release();
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.m7.b$b, reason: collision with other inner class name */
    class CallableC0422b implements Callable<Long> {
        final /* synthetic */ RoomSQLiteQuery a;

        CallableC0422b(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() {
            Cursor cursorQuery = DBUtil.query(b.this.a, this.a, false, null);
            try {
                return cursorQuery.moveToFirst() ? Long.valueOf(cursorQuery.getLong(0)) : 0L;
            } finally {
                cursorQuery.close();
                this.a.release();
            }
        }
    }

    class c extends EntityInsertionAdapter<sdk.pendo.io.m7.c> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, sdk.pendo.io.m7.c cVar) {
            supportSQLiteStatement.bindLong(1, cVar.getId());
            supportSQLiteStatement.bindString(2, cVar.getPayload());
            supportSQLiteStatement.bindLong(3, cVar.getPayloadSize());
            supportSQLiteStatement.bindLong(4, cVar.getIsSending() ? 1L : 0L);
        }

        @Override // androidx.room.SharedSQLiteStatement
        protected String createQuery() {
            return "INSERT OR ABORT INTO `session_replay_table` (`id`,`payload`,`payload_size`,`is_sending`) VALUES (nullif(?, 0),?,?,?)";
        }
    }

    class d extends SharedSQLiteStatement {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE session_replay_table SET is_sending = ? WHERE id = ?";
        }
    }

    class e extends SharedSQLiteStatement {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM session_replay_table WHERE id = ?";
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE session_replay_table SET is_sending = 0 WHERE is_sending = 1";
        }
    }

    class g implements Callable<Long> {
        final /* synthetic */ sdk.pendo.io.m7.c a;

        g(sdk.pendo.io.m7.c cVar) {
            this.a = cVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long call() {
            b.this.a.beginTransaction();
            try {
                Long lValueOf = Long.valueOf(b.this.b.insertAndReturnId(this.a));
                b.this.a.setTransactionSuccessful();
                return lValueOf;
            } finally {
                b.this.a.endTransaction();
            }
        }
    }

    class h implements Callable<Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ long b;

        h(boolean z, long j) {
            this.a = z;
            this.b = j;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() {
            SupportSQLiteStatement supportSQLiteStatementAcquire = b.this.c.acquire();
            supportSQLiteStatementAcquire.bindLong(1, this.a ? 1L : 0L);
            supportSQLiteStatementAcquire.bindLong(2, this.b);
            try {
                b.this.a.beginTransaction();
                try {
                    supportSQLiteStatementAcquire.executeUpdateDelete();
                    b.this.a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    b.this.a.endTransaction();
                    b.this.c.release(supportSQLiteStatementAcquire);
                    return unit;
                } catch (Throwable th) {
                    b.this.a.endTransaction();
                    throw th;
                }
            } catch (Throwable th2) {
                b.this.c.release(supportSQLiteStatementAcquire);
                throw th2;
            }
        }
    }

    class i implements Callable<Integer> {
        final /* synthetic */ long a;

        i(long j) {
            this.a = j;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            SupportSQLiteStatement supportSQLiteStatementAcquire = b.this.d.acquire();
            supportSQLiteStatementAcquire.bindLong(1, this.a);
            try {
                b.this.a.beginTransaction();
                try {
                    Integer numValueOf = Integer.valueOf(supportSQLiteStatementAcquire.executeUpdateDelete());
                    b.this.a.setTransactionSuccessful();
                    b.this.a.endTransaction();
                    b.this.d.release(supportSQLiteStatementAcquire);
                    return numValueOf;
                } catch (Throwable th) {
                    b.this.a.endTransaction();
                    throw th;
                }
            } catch (Throwable th2) {
                b.this.d.release(supportSQLiteStatementAcquire);
                throw th2;
            }
        }
    }

    class j implements Callable<Unit> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit call() {
            SupportSQLiteStatement supportSQLiteStatementAcquire = b.this.e.acquire();
            try {
                b.this.a.beginTransaction();
                try {
                    supportSQLiteStatementAcquire.executeUpdateDelete();
                    b.this.a.setTransactionSuccessful();
                    Unit unit = Unit.INSTANCE;
                    b.this.a.endTransaction();
                    b.this.e.release(supportSQLiteStatementAcquire);
                    return unit;
                } catch (Throwable th) {
                    b.this.a.endTransaction();
                    throw th;
                }
            } catch (Throwable th2) {
                b.this.e.release(supportSQLiteStatementAcquire);
                throw th2;
            }
        }
    }

    class k implements Callable<List<sdk.pendo.io.m7.c>> {
        final /* synthetic */ RoomSQLiteQuery a;

        k(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<sdk.pendo.io.m7.c> call() {
            Cursor cursorQuery = DBUtil.query(b.this.a, this.a, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payload");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payload_size");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "is_sending");
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new sdk.pendo.io.m7.c(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getInt(columnIndexOrThrow4) != 0));
                }
                cursorQuery.close();
                this.a.release();
                return arrayList;
            } catch (Throwable th) {
                cursorQuery.close();
                this.a.release();
                throw th;
            }
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new c(roomDatabase);
        this.c = new d(roomDatabase);
        this.d = new e(roomDatabase);
        this.e = new f(roomDatabase);
    }

    @Override // sdk.pendo.io.m7.a
    public Object a(long j2, Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.a, true, new i(j2), continuation);
    }

    @Override // sdk.pendo.io.m7.a
    public Object b(Continuation<? super Integer> continuation) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM session_replay_table WHERE is_sending = 1", 0);
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new a(roomSQLiteQueryAcquire), continuation);
    }

    @Override // sdk.pendo.io.m7.a
    public Object c(Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.a, true, new j(), continuation);
    }

    @Override // sdk.pendo.io.m7.a
    public Object a(int i2, Continuation<? super List<sdk.pendo.io.m7.c>> continuation) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM session_replay_table WHERE is_sending = 0 ORDER BY id ASC LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new k(roomSQLiteQueryAcquire), continuation);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    @Override // sdk.pendo.io.m7.a
    public Object a(sdk.pendo.io.m7.c cVar, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.a, true, new g(cVar), continuation);
    }

    @Override // sdk.pendo.io.m7.a
    public Object a(Continuation<? super Long> continuation) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COALESCE(SUM(payload_size), 0) FROM session_replay_table", 0);
        return CoroutinesRoom.execute(this.a, false, DBUtil.createCancellationSignal(), new CallableC0422b(roomSQLiteQueryAcquire), continuation);
    }

    @Override // sdk.pendo.io.m7.a
    public Object a(long j2, boolean z, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.a, true, new h(z, j2), continuation);
    }
}

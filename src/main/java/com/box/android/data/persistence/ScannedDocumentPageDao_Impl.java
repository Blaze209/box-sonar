package com.box.android.data.persistence;

import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ScannedDocumentPageDao_Impl.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0012H\u0016J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/persistence/ScannedDocumentPageDao_Impl;", "Lcom/box/android/data/persistence/ScannedDocumentPageDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfScannedDocumentPageEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/box/android/data/persistence/ScannedDocumentPageEntity;", "__documentPageFilterTypeConverter", "Lcom/box/android/data/persistence/DocumentPageFilterTypeConverter;", "__dateToLongConverter", "Lcom/box/android/data/persistence/DateToLongConverter;", "insertOrUpdateScannedDocumentPage", "", "scannedDocumentPage", "(Lcom/box/android/data/persistence/ScannedDocumentPageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeScannedDocumentPages", "Lkotlinx/coroutines/flow/Flow;", "", "getScannedDocumentPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllDocumentPages", "", "deletePage", "pageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScannedDocumentPageDao_Impl implements ScannedDocumentPageDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateToLongConverter __dateToLongConverter;
    private final RoomDatabase __db;
    private final DocumentPageFilterTypeConverter __documentPageFilterTypeConverter;
    private final EntityInsertAdapter<ScannedDocumentPageEntity> __insertAdapterOfScannedDocumentPageEntity;

    public ScannedDocumentPageDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__documentPageFilterTypeConverter = new DocumentPageFilterTypeConverter();
        this.__dateToLongConverter = new DateToLongConverter();
        this.__db = __db;
        this.__insertAdapterOfScannedDocumentPageEntity = new EntityInsertAdapter<ScannedDocumentPageEntity>() { // from class: com.box.android.data.persistence.ScannedDocumentPageDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `scanned_document_pages` (`id`,`original_file`,`enhanced_file`,`filter_type`,`distortion_correction`,`rotation_angle`,`version`,`created_at`,`quad_x1`,`quad_y1`,`quad_x2`,`quad_y2`,`quad_x3`,`quad_y3`,`quad_x4`,`quad_y4`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, ScannedDocumentPageEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo10942bindLong(1, entity.getId());
                statement.mo10944bindText(2, entity.getOriginalImagePath());
                statement.mo10944bindText(3, entity.getEnhancedImagePath());
                statement.mo10944bindText(4, ScannedDocumentPageDao_Impl.this.__documentPageFilterTypeConverter.fromDocumentPageFilterType(entity.getFilterType()));
                statement.mo10942bindLong(5, entity.getDistortionCorrectionEnabled() ? 1L : 0L);
                statement.mo10942bindLong(6, entity.getRotationAngle());
                statement.mo10942bindLong(7, entity.getVersion());
                Long lDateToTimestamp = ScannedDocumentPageDao_Impl.this.__dateToLongConverter.dateToTimestamp(entity.getCreatedAt());
                if (lDateToTimestamp == null) {
                    statement.mo10943bindNull(8);
                } else {
                    statement.mo10942bindLong(8, lDateToTimestamp.longValue());
                }
                DocumentPosition quadrangle = entity.getQuadrangle();
                if (quadrangle != null) {
                    statement.mo10941bindDouble(9, quadrangle.getX1());
                    statement.mo10941bindDouble(10, quadrangle.getY1());
                    statement.mo10941bindDouble(11, quadrangle.getX2());
                    statement.mo10941bindDouble(12, quadrangle.getY2());
                    statement.mo10941bindDouble(13, quadrangle.getX3());
                    statement.mo10941bindDouble(14, quadrangle.getY3());
                    statement.mo10941bindDouble(15, quadrangle.getX4());
                    statement.mo10941bindDouble(16, quadrangle.getY4());
                    return;
                }
                statement.mo10943bindNull(9);
                statement.mo10943bindNull(10);
                statement.mo10943bindNull(11);
                statement.mo10943bindNull(12);
                statement.mo10943bindNull(13);
                statement.mo10943bindNull(14);
                statement.mo10943bindNull(15);
                statement.mo10943bindNull(16);
            }
        };
    }

    @Override // com.box.android.data.persistence.ScannedDocumentPageDao
    public Object insertOrUpdateScannedDocumentPage(final ScannedDocumentPageEntity scannedDocumentPageEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.ScannedDocumentPageDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(ScannedDocumentPageDao_Impl.insertOrUpdateScannedDocumentPage$lambda$0(this.f$0, scannedDocumentPageEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insertOrUpdateScannedDocumentPage$lambda$0(ScannedDocumentPageDao_Impl scannedDocumentPageDao_Impl, ScannedDocumentPageEntity scannedDocumentPageEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return scannedDocumentPageDao_Impl.__insertAdapterOfScannedDocumentPageEntity.insertAndReturnId(_connection, scannedDocumentPageEntity);
    }

    @Override // com.box.android.data.persistence.ScannedDocumentPageDao
    public Flow<List<ScannedDocumentPageEntity>> observeScannedDocumentPages() {
        final String str = "SELECT * from scanned_document_pages ORDER BY created_at";
        return FlowUtil.createFlow(this.__db, false, new String[]{"scanned_document_pages"}, new Function1() { // from class: com.box.android.data.persistence.ScannedDocumentPageDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScannedDocumentPageDao_Impl.observeScannedDocumentPages$lambda$0(str, this, (SQLiteConnection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List observeScannedDocumentPages$lambda$0(String str, ScannedDocumentPageDao_Impl scannedDocumentPageDao_Impl, SQLiteConnection _connection) {
        int i;
        int i2;
        int i3;
        int i4;
        DocumentPosition documentPosition;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "original_file");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "enhanced_file");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, BoxAmplitudeAnalytics.SearchEventPropertyBuilder.SEARCH_FILTER_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "distortion_correction");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rotation_angle");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x1");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y1");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x2");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y2");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x3");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y3");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x4");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y4");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i7 = columnIndexOrThrow13;
                ArrayList arrayList2 = arrayList;
                int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                int i9 = columnIndexOrThrow;
                DocumentPageFilterType documentPageFilterType = scannedDocumentPageDao_Impl.__documentPageFilterTypeConverter.toDocumentPageFilterType(sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                int i10 = columnIndexOrThrow2;
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                int i12 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                Date dateFromTimestamp = scannedDocumentPageDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow9) && sQLiteStatementPrepare.isNull(columnIndexOrThrow10) && sQLiteStatementPrepare.isNull(columnIndexOrThrow11) && sQLiteStatementPrepare.isNull(columnIndexOrThrow12)) {
                    i3 = i7;
                    if (sQLiteStatementPrepare.isNull(i3)) {
                        i = columnIndexOrThrow14;
                        if (sQLiteStatementPrepare.isNull(i)) {
                            i2 = columnIndexOrThrow15;
                            if (sQLiteStatementPrepare.isNull(i2)) {
                                columnIndexOrThrow3 = columnIndexOrThrow3;
                                i4 = columnIndexOrThrow16;
                                if (sQLiteStatementPrepare.isNull(i4)) {
                                    i5 = i;
                                    documentPosition = null;
                                    i6 = i3;
                                } else {
                                    i6 = i3;
                                    i5 = i;
                                    documentPosition = new DocumentPosition((float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow9), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow10), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow11), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow12), (float) sQLiteStatementPrepare.getDouble(i3), (float) sQLiteStatementPrepare.getDouble(i), (float) sQLiteStatementPrepare.getDouble(i2), (float) sQLiteStatementPrepare.getDouble(i4));
                                }
                            }
                            arrayList2.add(new ScannedDocumentPageEntity(i8, text, text2, documentPageFilterType, documentPosition, z, i11, i12, dateFromTimestamp));
                            int i13 = i4;
                            columnIndexOrThrow3 = columnIndexOrThrow3;
                            columnIndexOrThrow14 = i5;
                            columnIndexOrThrow16 = i13;
                            arrayList = arrayList2;
                            columnIndexOrThrow2 = i10;
                            columnIndexOrThrow4 = columnIndexOrThrow4;
                            columnIndexOrThrow15 = i2;
                            columnIndexOrThrow13 = i6;
                            columnIndexOrThrow5 = columnIndexOrThrow5;
                            columnIndexOrThrow = i9;
                        }
                    } else {
                        i = columnIndexOrThrow14;
                    }
                    i2 = columnIndexOrThrow15;
                } else {
                    i = columnIndexOrThrow14;
                    i2 = columnIndexOrThrow15;
                    i3 = i7;
                }
                i4 = columnIndexOrThrow16;
                i6 = i3;
                i5 = i;
                documentPosition = new DocumentPosition((float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow9), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow10), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow11), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow12), (float) sQLiteStatementPrepare.getDouble(i3), (float) sQLiteStatementPrepare.getDouble(i), (float) sQLiteStatementPrepare.getDouble(i2), (float) sQLiteStatementPrepare.getDouble(i4));
                arrayList2.add(new ScannedDocumentPageEntity(i8, text, text2, documentPageFilterType, documentPosition, z, i11, i12, dateFromTimestamp));
                int i14 = i4;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow14 = i5;
                columnIndexOrThrow16 = i14;
                arrayList = arrayList2;
                columnIndexOrThrow2 = i10;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                columnIndexOrThrow15 = i2;
                columnIndexOrThrow13 = i6;
                columnIndexOrThrow5 = columnIndexOrThrow5;
                columnIndexOrThrow = i9;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.ScannedDocumentPageDao
    public Object getScannedDocumentPages(Continuation<? super List<ScannedDocumentPageEntity>> continuation) {
        final String str = "SELECT * from scanned_document_pages ORDER BY created_at";
        return DBUtil.performSuspending(this.__db, true, false, new Function1() { // from class: com.box.android.data.persistence.ScannedDocumentPageDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScannedDocumentPageDao_Impl.getScannedDocumentPages$lambda$0(str, this, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getScannedDocumentPages$lambda$0(String str, ScannedDocumentPageDao_Impl scannedDocumentPageDao_Impl, SQLiteConnection _connection) {
        int i;
        int i2;
        int i3;
        int i4;
        DocumentPosition documentPosition;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "original_file");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "enhanced_file");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, BoxAmplitudeAnalytics.SearchEventPropertyBuilder.SEARCH_FILTER_TYPE);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "distortion_correction");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "rotation_angle");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "created_at");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x1");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y1");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x2");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y2");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x3");
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y3");
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_x4");
            int columnIndexOrThrow16 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "quad_y4");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i7 = columnIndexOrThrow13;
                ArrayList arrayList2 = arrayList;
                int i8 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                String text2 = sQLiteStatementPrepare.getText(columnIndexOrThrow3);
                int i9 = columnIndexOrThrow;
                DocumentPageFilterType documentPageFilterType = scannedDocumentPageDao_Impl.__documentPageFilterTypeConverter.toDocumentPageFilterType(sQLiteStatementPrepare.getText(columnIndexOrThrow4));
                int i10 = columnIndexOrThrow2;
                boolean z = ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow5)) != 0;
                int i11 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow6);
                int i12 = (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7);
                Date dateFromTimestamp = scannedDocumentPageDao_Impl.__dateToLongConverter.fromTimestamp(sQLiteStatementPrepare.isNull(columnIndexOrThrow8) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
                if (dateFromTimestamp == null) {
                    throw new IllegalStateException("Expected NON-NULL 'java.util.Date', but it was NULL.".toString());
                }
                if (sQLiteStatementPrepare.isNull(columnIndexOrThrow9) && sQLiteStatementPrepare.isNull(columnIndexOrThrow10) && sQLiteStatementPrepare.isNull(columnIndexOrThrow11) && sQLiteStatementPrepare.isNull(columnIndexOrThrow12)) {
                    i3 = i7;
                    if (sQLiteStatementPrepare.isNull(i3)) {
                        i = columnIndexOrThrow14;
                        if (sQLiteStatementPrepare.isNull(i)) {
                            i2 = columnIndexOrThrow15;
                            if (sQLiteStatementPrepare.isNull(i2)) {
                                columnIndexOrThrow3 = columnIndexOrThrow3;
                                i4 = columnIndexOrThrow16;
                                if (sQLiteStatementPrepare.isNull(i4)) {
                                    i5 = i;
                                    documentPosition = null;
                                    i6 = i3;
                                } else {
                                    i6 = i3;
                                    i5 = i;
                                    documentPosition = new DocumentPosition((float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow9), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow10), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow11), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow12), (float) sQLiteStatementPrepare.getDouble(i3), (float) sQLiteStatementPrepare.getDouble(i), (float) sQLiteStatementPrepare.getDouble(i2), (float) sQLiteStatementPrepare.getDouble(i4));
                                }
                            }
                            arrayList2.add(new ScannedDocumentPageEntity(i8, text, text2, documentPageFilterType, documentPosition, z, i11, i12, dateFromTimestamp));
                            int i13 = i4;
                            columnIndexOrThrow3 = columnIndexOrThrow3;
                            columnIndexOrThrow14 = i5;
                            columnIndexOrThrow16 = i13;
                            arrayList = arrayList2;
                            columnIndexOrThrow2 = i10;
                            columnIndexOrThrow4 = columnIndexOrThrow4;
                            columnIndexOrThrow15 = i2;
                            columnIndexOrThrow13 = i6;
                            columnIndexOrThrow5 = columnIndexOrThrow5;
                            columnIndexOrThrow = i9;
                        }
                    } else {
                        i = columnIndexOrThrow14;
                    }
                    i2 = columnIndexOrThrow15;
                } else {
                    i = columnIndexOrThrow14;
                    i2 = columnIndexOrThrow15;
                    i3 = i7;
                }
                i4 = columnIndexOrThrow16;
                i6 = i3;
                i5 = i;
                documentPosition = new DocumentPosition((float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow9), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow10), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow11), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow12), (float) sQLiteStatementPrepare.getDouble(i3), (float) sQLiteStatementPrepare.getDouble(i), (float) sQLiteStatementPrepare.getDouble(i2), (float) sQLiteStatementPrepare.getDouble(i4));
                arrayList2.add(new ScannedDocumentPageEntity(i8, text, text2, documentPageFilterType, documentPosition, z, i11, i12, dateFromTimestamp));
                int i14 = i4;
                columnIndexOrThrow3 = columnIndexOrThrow3;
                columnIndexOrThrow14 = i5;
                columnIndexOrThrow16 = i14;
                arrayList = arrayList2;
                columnIndexOrThrow2 = i10;
                columnIndexOrThrow4 = columnIndexOrThrow4;
                columnIndexOrThrow15 = i2;
                columnIndexOrThrow13 = i6;
                columnIndexOrThrow5 = columnIndexOrThrow5;
                columnIndexOrThrow = i9;
            }
            ArrayList arrayList3 = arrayList;
            sQLiteStatementPrepare.close();
            return arrayList3;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.box.android.data.persistence.ScannedDocumentPageDao
    public Object deleteAllDocumentPages(Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM scanned_document_pages";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.ScannedDocumentPageDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScannedDocumentPageDao_Impl.deleteAllDocumentPages$lambda$0(str, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteAllDocumentPages$lambda$0(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.box.android.data.persistence.ScannedDocumentPageDao
    public Object deletePage(final int i, Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM scanned_document_pages WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.box.android.data.persistence.ScannedDocumentPageDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScannedDocumentPageDao_Impl.deletePage$lambda$0(str, i, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deletePage$lambda$0(String str, int i, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo10942bindLong(1, i);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: ScannedDocumentPageDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/persistence/ScannedDocumentPageDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}

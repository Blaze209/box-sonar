package com.box.android.domain.localrepo.sqlitetables;

import android.util.Pair;
import com.box.android.domain.localrepo.ISQLHelper;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class BoxSqlQueryManager {
    private static final String ASCENDING = "ASC";
    private static final String COLLATE_NOCASE = " COLLATE NOCASE ";
    private static final String DESCENDING = "DESC";
    private final ISQLHelper mHelper;

    public BoxSqlQueryManager(ISQLHelper iSQLHelper) {
        this.mHelper = iSQLHelper;
    }

    public <T extends BoxTypedObjectSQLData> List<T> queryForColumn(Class<T> cls, String str, String str2, String str3, boolean z) throws SQLException {
        Dao<T, String> dao = this.mHelper.getDao(cls);
        return getQueryList(dao.queryBuilder().orderByRaw(str3 + COLLATE_NOCASE + (z ? "ASC" : "DESC")).where().eq(str, str2).prepare(), dao);
    }

    public <T extends BoxTypedObjectSQLData> List<T> queryForColumnWithMax(Class<T> cls, String str, boolean z, Long l) throws SQLException {
        Dao<T, String> dao = this.mHelper.getDao(cls);
        return getQueryList(dao.queryBuilder().orderByRaw(str + COLLATE_NOCASE + (z ? "ASC" : "DESC")).limit(l).prepare(), dao);
    }

    public <T extends BoxTypedObjectSQLData> List<T> queryForColumnAndGroup(Class<T> cls, String str, String str2, String str3) throws SQLException {
        Dao<T, String> dao = this.mHelper.getDao(cls);
        return getQueryList(dao.queryBuilder().groupBy(str3).where().eq(str, str2).prepare(), dao);
    }

    public <T extends BoxTypedObjectSQLData> BoxQueryBuilder<T> getQueryBuilder(Class<T> cls) throws SQLException {
        return new BoxQueryBuilder<>(this.mHelper.getDao(cls));
    }

    public class BoxQueryBuilder<T extends BoxTypedObjectSQLData> {
        private final Dao<T, String> mDao;
        private boolean mLimitUsed;
        private StringBuilder mOrderBy;
        private QueryBuilder<T, String> mQBuilder;

        private BoxQueryBuilder(Dao<T, String> dao) {
            this.mOrderBy = new StringBuilder();
            this.mDao = dao;
            this.mQBuilder = dao.queryBuilder();
        }

        public BoxQueryBuilder<T> queryColumn(String str, Object... objArr) throws SQLException {
            if (objArr != null) {
                if (objArr.length > 1) {
                    Where<T, String> where = this.mQBuilder.where();
                    for (int i = 0; i < objArr.length; i++) {
                        where = where.eq(str, objArr[i]);
                        if (i < objArr.length - 1) {
                            where = where.or();
                        }
                    }
                    return this;
                }
                this.mQBuilder.where().eq(str, objArr[0]);
                return this;
            }
            this.mQBuilder.where().eq(str, objArr);
            return this;
        }

        public BoxQueryBuilder<T> queryColumnsAND(List<Pair<String, ? extends Object>> list) throws SQLException {
            Where<T, String> where = this.mQBuilder.where();
            if (list != null) {
                boolean z = true;
                for (Pair<String, ? extends Object> pair : list) {
                    if (!z) {
                        where = where.and();
                    }
                    where = where.eq((String) pair.first, pair.second);
                    z = false;
                }
            }
            return this;
        }

        public BoxQueryBuilder<T> queryColumnNotNull(String str) throws SQLException {
            this.mQBuilder.where().isNotNull(str);
            return this;
        }

        public BoxQueryBuilder<T> orderBy(String str, boolean z) {
            if (this.mOrderBy.length() > 0) {
                this.mOrderBy.append(", ");
            }
            this.mOrderBy.append(str + BoxSqlQueryManager.COLLATE_NOCASE + (z ? "ASC" : "DESC"));
            return this;
        }

        public BoxQueryBuilder<T> groupBy(String str) {
            this.mQBuilder.groupBy(str);
            return this;
        }

        public BoxQueryBuilder<T> limit(long j) {
            this.mQBuilder.limit(Long.valueOf(j));
            this.mLimitUsed = true;
            return this;
        }

        public BoxQueryBuilder<T> offset(long j) throws SQLException {
            this.mQBuilder.offset(Long.valueOf(j));
            if (!this.mLimitUsed) {
                this.mQBuilder.limit((Long) (-1L));
            }
            return this;
        }

        public List<T> execute() throws SQLException {
            if (this.mOrderBy.length() > 0) {
                this.mQBuilder.orderByRaw(this.mOrderBy.toString());
            }
            return BoxSqlQueryManager.this.getQueryList(this.mQBuilder.prepare(), this.mDao);
        }
    }

    public <A extends BoxTypedObjectSQLData, B extends BoxTypedObjectSQLData> List<A> queryForColumnWithMaxWhileFilteringWithJoin(Class<A> cls, Class<B> cls2, String str, boolean z, Long l, Map<String, Iterable<?>> map) throws SQLException {
        QueryBuilder queryBuilderBuildQueryForColumnWithMaxWhileFiltering = buildQueryForColumnWithMaxWhileFiltering(this.mHelper.getDao(cls), str, z, l, map);
        QueryBuilder<?, ?> queryBuilder = this.mHelper.getDao(cls2).queryBuilder();
        queryBuilder.where().gt("id", 0);
        return queryBuilderBuildQueryForColumnWithMaxWhileFiltering.join(queryBuilder).query();
    }

    public <A extends BoxTypedObjectSQLData, B extends BoxTypedObjectSQLData> List<A> queryForColumnsWithJoin(Class<A> cls, Class<B> cls2, String str, boolean z, String str2, String str3) throws SQLException {
        QueryBuilder queryBuilder = this.mHelper.getDao(cls).queryBuilder();
        queryBuilder.where().in(str, Boolean.valueOf(z));
        QueryBuilder<?, ?> queryBuilder2 = this.mHelper.getDao(cls2).queryBuilder();
        queryBuilder2.where().in(str2, str3);
        return queryBuilder.join(queryBuilder2).query();
    }

    public <A extends BoxTypedObjectSQLData, B extends BoxTypedObjectSQLData> List<A> queryForColumnsWithJoin(Class<A> cls, Class<B> cls2, String str, boolean z, Map<String, Iterable<?>> map) throws SQLException {
        QueryBuilder queryBuilder = this.mHelper.getDao(cls).queryBuilder();
        queryBuilder.where().in(str, Boolean.valueOf(z));
        QueryBuilder<?, ?> queryBuilder2 = this.mHelper.getDao(cls2).queryBuilder();
        addFiltersToQuery(queryBuilder2, map);
        return queryBuilder.join(queryBuilder2).query();
    }

    public <T extends BoxTypedObjectSQLData> List<T> queryForColumnWithMaxWhileFiltering(Class<T> cls, String str, boolean z, Long l, Map<String, Iterable<?>> map) throws SQLException {
        Dao<T, String> dao = this.mHelper.getDao(cls);
        return getQueryList(buildQueryForColumnWithMaxWhileFiltering(dao, str, z, l, map).prepare(), dao);
    }

    private <T extends BoxTypedObjectSQLData> QueryBuilder<T, String> buildQueryForColumnWithMaxWhileFiltering(Dao<T, String> dao, String str, boolean z, Long l, Map<String, Iterable<?>> map) throws SQLException {
        return addFiltersToQuery(dao.queryBuilder().orderByRaw(str + COLLATE_NOCASE + (z ? "ASC" : "DESC")).limit(l), map);
    }

    private <T extends BoxTypedObjectSQLData> QueryBuilder<T, String> addFiltersToQuery(QueryBuilder<T, String> queryBuilder, Map<String, Iterable<?>> map) throws SQLException {
        if (map != null && !map.isEmpty()) {
            Where<T, String> where = queryBuilder.where();
            int i = 0;
            for (Map.Entry<String, Iterable<?>> entry : map.entrySet()) {
                int i2 = i + 1;
                if (i != 0) {
                    where.and();
                }
                where.in(entry.getKey(), entry.getValue());
                i = i2;
            }
        }
        return queryBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends BoxTypedObjectSQLData> List<T> getQueryList(PreparedQuery<T> preparedQuery, Dao<T, String> dao) throws SQLException {
        ArrayList arrayList = new ArrayList();
        CloseableIterator<T> it = dao.iterator(preparedQuery);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        it.closeQuietly();
        return arrayList;
    }

    public <T extends BoxTypedObjectSQLData> List<T> queryForColumn(Class<T> cls, String str, Object obj) throws SQLException {
        Dao<T, String> dao = this.mHelper.getDao(cls);
        return getQueryList(dao.queryBuilder().where().eq(str, obj).prepare(), dao);
    }

    public <T extends BoxTypedObjectSQLData> T queryForId(Class<T> cls, String str) throws SQLException {
        return (T) this.mHelper.getDao(cls).queryForId(str);
    }

    public <T extends BoxTypedObjectSQLData> T queryForNth(Class<T> cls, String str, boolean z, long j) throws SQLException {
        Dao<T, String> dao = this.mHelper.getDao(cls);
        long j2 = j - 1;
        return getQueryList(dao.queryBuilder().orderByRaw(str + COLLATE_NOCASE + (z ? "ASC" : "DESC")).limit(Long.valueOf(j2)).offset(Long.valueOf(j2)).prepare(), dao).get(0);
    }

    public <T extends BoxTypedObjectSQLData> void clearTable(Class<T> cls) throws SQLException {
        TableUtils.clearTable(this.mHelper.getConnectionSource(), cls);
    }

    public <T extends BoxTypedObjectSQLData> void delete(Class<T> cls, String str, Object obj) throws SQLException {
        DeleteBuilder deleteBuilder = this.mHelper.getDao(cls).deleteBuilder();
        deleteBuilder.where().eq(str, obj);
        deleteBuilder.delete();
    }

    public <T extends BoxTypedObjectSQLData> void delete(Class<T> cls, String str, List<String> list) throws SQLException {
        DeleteBuilder deleteBuilder = this.mHelper.getDao(cls).deleteBuilder();
        deleteBuilder.where().in(str, list);
        deleteBuilder.delete();
    }

    public <T extends BoxTypedObjectSQLData> void deleteWhereLessThanThreshold(Class<T> cls, String str, long j) throws SQLException {
        DeleteBuilder deleteBuilder = this.mHelper.getDao(cls).deleteBuilder();
        deleteBuilder.where().lt(str, Long.valueOf(j));
        deleteBuilder.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BoxTypedObjectSQLData> void deleteWhereCountMoreThanThreshold(Class<T> cls, String str, boolean z, long j, String str2, Object obj, String str3) throws SQLException {
        Dao dao = this.mHelper.getDao(cls);
        QueryBuilder<?, ?> queryBuilder = dao.queryBuilder();
        queryBuilder.selectColumns(str3);
        if (str2 != null && obj != null) {
            queryBuilder.where().eq(str2, obj);
        }
        queryBuilder.limit((Long) (-1L));
        queryBuilder.offset(Long.valueOf(j));
        queryBuilder.orderByRaw(str + " " + (z ? "ASC" : "DESC"));
        DeleteBuilder deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().in(str3, queryBuilder);
        deleteBuilder.delete();
    }

    public <T extends BoxTypedObjectSQLData> void create(T t) throws SQLException {
        this.mHelper.getDao(t.getClass()).create(t);
    }

    public <T extends BoxTypedObjectSQLData> void update(T t) throws SQLException {
        this.mHelper.getDao(t.getClass()).update(t);
    }

    public <T extends BoxTypedObjectSQLData> void createOrUpdate(T t) throws SQLException {
        this.mHelper.getDao(t.getClass()).createOrUpdate(t);
    }

    public <T extends BoxTypedObjectSQLData> T createIfNotExists(T t) throws SQLException {
        return (T) this.mHelper.getDao(t.getClass()).createIfNotExists(t);
    }

    public <T extends BoxTypedObjectSQLData> void createOrUpdateColumns(T t, Map<String, Object> map) throws SQLException {
        Dao dao = this.mHelper.getDao(t.getClass());
        if (map == null || map.size() == 0 || !dao.idExists(t.getId())) {
            createOrUpdate(t);
            return;
        }
        UpdateBuilder updateBuilder = dao.updateBuilder();
        updateBuilder.where().idEq(t.getId());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            updateBuilder.updateColumnValue(entry.getKey(), entry.getValue());
        }
        updateBuilder.update();
    }

    public <T extends BoxTypedObjectSQLData> void deleteByItemId(Class<T> cls, String str) throws SQLException {
        delete(cls, "id", str);
    }
}

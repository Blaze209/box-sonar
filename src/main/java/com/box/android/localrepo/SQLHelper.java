package com.box.android.localrepo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.box.android.domain.localrepo.ISQLHelper;
import com.box.android.domain.localrepo.sqlitetables.BoxCollaborationSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCollectionItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCollectionSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCommentSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxEventSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFeedCachingSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFolderSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationMuteSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxSqlQueryManager;
import com.box.android.domain.localrepo.sqlitetables.BoxTaskCollaboratorsSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxTaskSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxTypedObjectSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxUserSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxWebLinkSQLData;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public class SQLHelper extends OrmLiteSqliteOpenHelper implements ISQLHelper {
    public static final int VERSION = 13;
    private Dao<BoxCollaborationSQLData, String> collabDao;
    private Dao<BoxCollectionSQLData, String> collectionDao;
    private Dao<BoxCollectionItemSQLData, String> collectionItemDao;
    private Dao<BoxCommentSQLData, String> commentDao;
    private Dao<BoxEventSQLData, String> eventDao;
    private Dao<BoxFileSQLData, String> fileDao;
    private Dao<BoxFolderSQLData, String> folderDao;
    private Dao<BoxPushNotificationMuteSQLData, String> pushNotificationMuteDao;
    private Dao<BoxPushNotificationSQLData, String> pushNotificationsDao;
    private Dao<BoxRecentFileSQLData, String> recentDao;
    private Dao<BoxRecentItemSQLData, String> recentItemDao;
    private final ArrayList<Class<? extends BaseDaoEnabled>> tableDataClass;
    private Dao<BoxUserSQLData, String> userDao;
    private Dao<BoxWebLinkSQLData, String> weblinkDao;

    public SQLHelper(Context context) {
        super(context, SQLProvider.getCurrentDataBaseName(), null, 13);
        ArrayList<Class<? extends BaseDaoEnabled>> arrayList = new ArrayList<>();
        this.tableDataClass = arrayList;
        arrayList.add(BoxFileSQLData.class);
        arrayList.add(BoxFolderSQLData.class);
        arrayList.add(BoxCommentSQLData.class);
        arrayList.add(BoxCollaborationSQLData.class);
        arrayList.add(BoxUserSQLData.class);
        arrayList.add(BoxWebLinkSQLData.class);
        arrayList.add(BoxRecentItemSQLData.class);
        arrayList.add(BoxRecentFileSQLData.class);
        arrayList.add(BoxEventSQLData.class);
        arrayList.add(BoxCollectionSQLData.class);
        arrayList.add(BoxCollectionItemSQLData.class);
        arrayList.add(BoxPushNotificationMuteSQLData.class);
        arrayList.add(BoxPushNotificationSQLData.class);
        arrayList.add(BoxTaskSQLData.class);
        arrayList.add(BoxTaskCollaboratorsSQLData.class);
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        createTablesIfTheyDontExist(connectionSource);
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        if (i < 3) {
            upgradeToVersion3(sQLiteDatabase, connectionSource);
        }
        if (i < 13) {
            upgradeToVersion13(connectionSource);
        }
        createTablesIfTheyDontExist(connectionSource);
    }

    private void upgradeToVersion13(ConnectionSource connectionSource) {
        try {
            TableUtils.dropTable(connectionSource, BoxFeedCachingSQLData.class, true);
        } catch (SQLException unused) {
        }
    }

    private void upgradeToVersion3(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        ArrayList<Class> arrayList = new ArrayList();
        arrayList.add(BoxFileSQLData.class);
        arrayList.add(BoxFolderSQLData.class);
        arrayList.add(BoxWebLinkSQLData.class);
        arrayList.add(BoxEventSQLData.class);
        for (Class cls : arrayList) {
            try {
                TableUtils.dropTable(connectionSource, cls, true);
                TableUtils.createTable(connectionSource, cls);
            } catch (SQLException unused) {
            }
        }
    }

    private void createTablesIfTheyDontExist(ConnectionSource connectionSource) {
        Iterator<Class<? extends BaseDaoEnabled>> it = this.tableDataClass.iterator();
        while (it.hasNext()) {
            try {
                TableUtils.createTableIfNotExists(connectionSource, it.next());
            } catch (SQLException e) {
                BoxLogUtils.logException(e);
            }
        }
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public void clearTables(Context context) {
        try {
            Iterator<Class<? extends BaseDaoEnabled>> it = this.tableDataClass.iterator();
            while (it.hasNext()) {
                TableUtils.clearTable(this.connectionSource, it.next());
            }
        } catch (IllegalStateException e) {
            BoxLogUtils.logException(e);
        } catch (SQLException e2) {
            BoxLogUtils.logException(e2);
        }
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxFileSQLData, String> getBoxFileDao() throws SQLException {
        if (this.fileDao == null) {
            this.fileDao = getDao(BoxFileSQLData.class);
        }
        return this.fileDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxFolderSQLData, String> getBoxFolderDao() throws SQLException {
        if (this.folderDao == null) {
            this.folderDao = getDao(BoxFolderSQLData.class);
        }
        return this.folderDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxCommentSQLData, String> getBoxCommentDao() throws SQLException {
        if (this.commentDao == null) {
            this.commentDao = getDao(BoxCommentSQLData.class);
        }
        return this.commentDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxWebLinkSQLData, String> getBoxWebLinkDao() throws SQLException {
        if (this.weblinkDao == null) {
            this.weblinkDao = getDao(BoxWebLinkSQLData.class);
        }
        return this.weblinkDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxCollaborationSQLData, String> getBoxCollaborationDao() throws SQLException {
        if (this.collabDao == null) {
            this.collabDao = getDao(BoxCollaborationSQLData.class);
        }
        return this.collabDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxUserSQLData, String> getBoxUserDao() throws SQLException {
        if (this.userDao == null) {
            this.userDao = getDao(BoxUserSQLData.class);
        }
        return this.userDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxRecentFileSQLData, String> getBoxRecentDao() throws SQLException {
        if (this.recentDao == null) {
            this.recentDao = getDao(BoxRecentFileSQLData.class);
        }
        return this.recentDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxRecentItemSQLData, String> getBoxRecentItemDao() throws SQLException {
        if (this.recentItemDao == null) {
            this.recentItemDao = getDao(BoxRecentItemSQLData.class);
        }
        return this.recentItemDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxPushNotificationMuteSQLData, String> getPushNotificationMuteDao() throws SQLException {
        if (this.pushNotificationMuteDao == null) {
            this.pushNotificationMuteDao = getDao(BoxPushNotificationMuteSQLData.class);
        }
        return this.pushNotificationMuteDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxPushNotificationSQLData, String> getPushNotificationDao() throws SQLException {
        if (this.pushNotificationsDao == null) {
            this.pushNotificationsDao = getDao(BoxPushNotificationSQLData.class);
        }
        return this.pushNotificationsDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxEventSQLData, String> getBoxEventDao() throws SQLException {
        if (this.eventDao == null) {
            this.eventDao = getDao(BoxEventSQLData.class);
        }
        return this.eventDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxCollectionSQLData, String> getBoxCollectionDao() throws SQLException {
        if (this.collectionDao == null) {
            this.collectionDao = getDao(BoxCollectionSQLData.class);
        }
        return this.collectionDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<BoxCollectionItemSQLData, String> getBoxCollectionItemDao() throws SQLException {
        if (this.collectionItemDao == null) {
            this.collectionItemDao = getDao(BoxCollectionItemSQLData.class);
        }
        return this.collectionItemDao;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public Dao<? extends BoxTypedObjectSQLData, String> getDao(String str) throws SQLException {
        if (str.equals("file")) {
            return getBoxFileDao();
        }
        if (str.equals("folder")) {
            return getBoxFolderDao();
        }
        if (str.equals("comment")) {
            return getBoxCommentDao();
        }
        if (str.equals(BoxCollaboration.TYPE)) {
            return getBoxCollaborationDao();
        }
        if (str.equals("user")) {
            return getBoxUserDao();
        }
        if (str.equals(BoxBookmark.TYPE)) {
            return getBoxWebLinkDao();
        }
        if (str.equals("event")) {
            return getBoxEventDao();
        }
        if (str.equals(BoxCollection.TYPE)) {
            return getBoxCollectionDao();
        }
        return null;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public BoxTypedObjectSQLData newSQLDataInstance(BoxJsonObject boxJsonObject) {
        if (boxJsonObject instanceof BoxFile) {
            return new BoxFileSQLData((BoxFile) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxFolder) {
            return new BoxFolderSQLData((BoxFolder) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxComment) {
            return new BoxCommentSQLData((BoxComment) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxCollaboration) {
            return new BoxCollaborationSQLData((BoxCollaboration) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxUser) {
            return new BoxUserSQLData((BoxUser) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxBookmark) {
            return new BoxWebLinkSQLData((BoxBookmark) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxEvent) {
            return new BoxEventSQLData((BoxEvent) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxCollection) {
            return new BoxCollectionSQLData((BoxCollection) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxRecentItem) {
            return new BoxRecentItemSQLData((BoxRecentItem) boxJsonObject);
        }
        if (boxJsonObject instanceof BoxTask) {
            throw new RuntimeException("BoxTaskSqlData requires task collaborator role, which is not part of object");
        }
        return null;
    }

    @Override // com.box.android.domain.localrepo.ISQLHelper
    public BoxSqlQueryManager getQueryManager() {
        return new BoxSqlQueryManager(this);
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper, android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.fileDao = null;
        this.folderDao = null;
        this.collabDao = null;
        this.commentDao = null;
        this.weblinkDao = null;
        this.userDao = null;
        this.recentDao = null;
        this.eventDao = null;
        this.pushNotificationMuteDao = null;
    }
}

package com.box.android.domain.localrepo;

import android.content.Context;
import com.box.android.domain.localrepo.sqlitetables.BoxCollaborationSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCollectionItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCollectionSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCommentSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxEventSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFolderSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationMuteSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxSqlQueryManager;
import com.box.android.domain.localrepo.sqlitetables.BoxTypedObjectSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxUserSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxWebLinkSQLData;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes11.dex */
public interface ISQLHelper {
    void clearTables(Context context);

    Dao<BoxCollaborationSQLData, String> getBoxCollaborationDao() throws SQLException;

    Dao<BoxCollectionSQLData, String> getBoxCollectionDao() throws SQLException;

    Dao<BoxCollectionItemSQLData, String> getBoxCollectionItemDao() throws SQLException;

    Dao<BoxCommentSQLData, String> getBoxCommentDao() throws SQLException;

    Dao<BoxEventSQLData, String> getBoxEventDao() throws SQLException;

    Dao<BoxFileSQLData, String> getBoxFileDao() throws SQLException;

    Dao<BoxFolderSQLData, String> getBoxFolderDao() throws SQLException;

    Dao<BoxRecentFileSQLData, String> getBoxRecentDao() throws SQLException;

    Dao<BoxRecentItemSQLData, String> getBoxRecentItemDao() throws SQLException;

    Dao<BoxUserSQLData, String> getBoxUserDao() throws SQLException;

    Dao<BoxWebLinkSQLData, String> getBoxWebLinkDao() throws SQLException;

    ConnectionSource getConnectionSource();

    <D extends Dao<T, ?>, T> D getDao(Class<T> cls) throws SQLException;

    Dao<? extends BoxTypedObjectSQLData, String> getDao(String str) throws SQLException;

    Dao<BoxPushNotificationSQLData, String> getPushNotificationDao() throws SQLException;

    Dao<BoxPushNotificationMuteSQLData, String> getPushNotificationMuteDao() throws SQLException;

    BoxSqlQueryManager getQueryManager();

    BoxTypedObjectSQLData newSQLDataInstance(BoxJsonObject boxJsonObject);
}

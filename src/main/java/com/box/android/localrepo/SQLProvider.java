package com.box.android.localrepo;

import android.content.Context;
import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.usercontext.UserContextComponent;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes12.dex */
public class SQLProvider extends UserContextComponent {
    public static final String DATABASE_NAME_PREFIX = "BoxSQLiteDB";
    private static String currentDatabaseName;
    private final Context mAppContext;
    private SQLHelper sqlHelper;

    public SQLProvider(Context context) {
        this.mAppContext = context;
    }

    private static String constructDataBaseName(String str) {
        return "BoxSQLiteDB_" + str;
    }

    public static String getCurrentDataBaseName() {
        return currentDatabaseName;
    }

    public SQLHelper getSQLHelper() {
        return this.sqlHelper;
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String str) throws IUserContextComponent.UserContextComponentCreationException {
        super.onCreate(str);
        currentDatabaseName = constructDataBaseName(str);
        SQLHelper sQLHelper = this.sqlHelper;
        if (sQLHelper != null && sQLHelper.isOpen()) {
            OpenHelperManager.releaseHelper();
        }
        this.sqlHelper = (SQLHelper) OpenHelperManager.getHelper(this.mAppContext, SQLHelper.class);
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
        OpenHelperManager.releaseHelper();
        super.onSoftDestroy();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        SQLHelper sQLHelper = this.sqlHelper;
        if (sQLHelper != null) {
            try {
                sQLHelper.getConnectionSource().close();
            } catch (SQLException e) {
                BoxLogUtils.logException(e);
            }
            BoxBaseApplication.getInstance().deleteDatabase(getCurrentDataBaseName());
        }
        OpenHelperManager.releaseHelper();
        super.onHardDestroy();
    }
}

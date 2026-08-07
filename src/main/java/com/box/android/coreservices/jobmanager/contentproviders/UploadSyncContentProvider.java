package com.box.android.coreservices.jobmanager.contentproviders;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.dao.BoxLocalFileData;
import com.box.android.domain.identity.Crypto;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalAutoContentUploadInformation;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.j256.ormlite.field.FieldType;
import com.microsoft.intune.mam.client.content.MAMContentProvider;
import dagger.hilt.EntryPoints;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class UploadSyncContentProvider extends MAMContentProvider {
    public static final String BOX_UPLOAD_SYNC_FILES = "upload_sync_files";
    public static final int BOX_UPLOAD_SYNC_FILES_TOKEN = 100;
    private static final String BOX_USER_ID = "com.box.android.userId";
    public static final String COLUMN_IS_DIRECTORY = "_directory";
    public static final String COLUMN_PATH = "_path";
    public static final String COLUMN_SHA1 = "_sha1";
    private static final String CONTENT_SCHEME = "content://";
    private static final String FILE_TYPE = "file";
    private static String providerAuthority;
    private IUserContextManager mUserContextManager;
    private static final UriMatcher BOX_URI_MATCHER = buildUriMatcher();
    private static final String TAG = UploadSyncContentProvider.class.getName();

    interface UploadSyncContentProviderEntryPoint {
        IUserContextManager userContextManager();
    }

    private static UriMatcher buildUriMatcher() {
        return new UriMatcher(-1);
    }

    public static Uri buildUri(String str) {
        Uri uriBuild = Uri.parse("content://" + providerAuthority).buildUpon().appendQueryParameter(BOX_USER_ID, str).build();
        BoxLogUtils.v(TAG, "buildUri(): Created uri: " + uriBuild);
        return uriBuild;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("URI: " + uri + " not supported.");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (BOX_URI_MATCHER.match(uri) == 100) {
            return "file";
        }
        throw new UnsupportedOperationException("URI " + uri + " is not supported.");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("URI: " + uri + " not supported.");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        providerAuthority = getContext().getResources().getString(R.string.uploadSyncProviderAuthority);
        BoxLogUtils.d(TAG, "Created");
        return true;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.mUserContextManager = ((UploadSyncContentProviderEntryPoint) EntryPoints.get(requireContext().getApplicationContext(), UploadSyncContentProviderEntryPoint.class)).userContextManager();
        String filePath = getFilePath(uri);
        String str3 = TAG;
        BoxLogUtils.v(str3, "query(): Received query call with uri: " + uri);
        BoxLogUtils.v(str3, "query(): Source folder path: " + filePath);
        return getCursorForFiles(filePath);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("URI: " + uri + " not supported.");
    }

    private Cursor getCursorForFiles(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = {FieldType.FOREIGN_ID_FIELD_SUFFIX, "_display_name", "_size", COLUMN_PATH, COLUMN_SHA1, COLUMN_IS_DIRECTORY};
        ArrayList<File> arrayList = new ArrayList(20);
        ArrayList<File> arrayList2 = new ArrayList(100);
        File file = new File(str);
        addContentToArrays(file, arrayList2, arrayList);
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        if (file.isFile()) {
            addRow(matrixCursor, file, 0, file.getAbsolutePath(), false);
            return matrixCursor;
        }
        int i = 0;
        for (File file2 : arrayList) {
            addRow(matrixCursor, file2, i, file2.getAbsolutePath(), true);
            i++;
        }
        for (File file3 : arrayList2) {
            addRow(matrixCursor, file3, i, file3.getAbsolutePath(), false);
            i++;
        }
        return matrixCursor;
    }

    private void addContentToArrays(File file, List<File> list, List<File> list2) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory() && isValidDirectory(file2)) {
                list2.add(file2);
                addContentToArrays(file2, list, list2);
            } else if (!file2.isDirectory()) {
                list.add(file2);
            }
        }
    }

    private boolean isValidDirectory(File file) {
        String name = file.getName();
        return StringUtils.isNotBlank(name) && !name.startsWith(".");
    }

    private String getUsersUploadDirectory(String str) {
        IUserContextManager iUserContextManager = this.mUserContextManager;
        if (iUserContextManager != null && iUserContextManager.hasValidUserId() && this.mUserContextManager.getCurrentContextId().equals(str)) {
            return ((ILocalAutoContentUploadInformation) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION)).getUploadFolder();
        }
        return null;
    }

    private String getFilePath(Uri uri) {
        return getUsersUploadDirectory(uri.getQueryParameter(BOX_USER_ID));
    }

    private void addRow(MatrixCursor matrixCursor, File file, int i, String str, boolean z) {
        matrixCursor.addRow(new Object[]{Integer.valueOf(i), file.getName(), Integer.valueOf((int) file.length()), str, getSha1(file), Integer.valueOf(z ? 1 : 0)});
    }

    private String getSha1(File file) {
        try {
            if (!file.exists() || !file.isFile()) {
                return "";
            }
            BoxLocalFileData boxLocalFileData = getBoxLocalFileData(file);
            if (boxLocalFileData != null && boxLocalFileData.isConsistentWith(file)) {
                return boxLocalFileData.getSha1();
            }
            String strSha1 = Crypto.sha1(new FileInputStream(file));
            storeLocalFileData(file, strSha1);
            return strSha1;
        } catch (FileNotFoundException e) {
            BoxLogUtils.logException(e);
            return "";
        } catch (IOException e2) {
            BoxLogUtils.logException(e2);
            return "";
        }
    }

    private BoxLocalFileData getBoxLocalFileData(File file) {
        String string = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.AUTO_CONTENT_UPLOAD_LOCAL_META_DATA).getString(file.getAbsolutePath(), null);
        if (string == null) {
            return null;
        }
        return deserializeBoxLocalFileData(string);
    }

    private void storeLocalFileData(File file, String str) {
        SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.AUTO_CONTENT_UPLOAD_LOCAL_META_DATA);
        String strSerializeBoxLocalFileData = serializeBoxLocalFileData(new BoxLocalFileData(file.getAbsolutePath(), str, file.lastModified(), file.length()));
        if (strSerializeBoxLocalFileData != null) {
            userSharedPrefs.edit().putString(file.getAbsolutePath(), strSerializeBoxLocalFileData).apply();
        }
    }

    private BoxLocalFileData deserializeBoxLocalFileData(String str) {
        return (BoxLocalFileData) BoxEntity.createEntityFromJson(str);
    }

    private String serializeBoxLocalFileData(BoxLocalFileData boxLocalFileData) {
        return boxLocalFileData.toJson();
    }
}

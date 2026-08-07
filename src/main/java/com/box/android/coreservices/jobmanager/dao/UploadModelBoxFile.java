package com.box.android.coreservices.jobmanager.dao;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.media3.common.MimeTypes;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FileUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.j256.ormlite.field.FieldType;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class UploadModelBoxFile implements Cloneable {
    private static final String CONTENT_SCHEME = "content";
    private static final String FILE_SCHEME = "file";
    private static final int MICRO_THUMB_SIZE = 96;
    private String fileNameOnly;
    private UriFile fileToUpload;
    private String mFileName;
    private String mId;
    private double mSize;
    private Uri mUri;
    private String fileExtension = "";
    private boolean mEnabled = true;
    private boolean mOverwriteExisting = false;
    private boolean overUploadLimit = false;
    private boolean getFileAttempted = false;
    private long mLastUpdated = -1;

    private static String[] getNameAndExtension(String str) {
        String[] strArr = new String[2];
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf > 0) {
            strArr[0] = str.substring(iLastIndexOf + 1);
        } else {
            strArr[0] = str;
        }
        int iLastIndexOf2 = strArr[0].lastIndexOf(46);
        if (iLastIndexOf2 >= 0) {
            strArr[1] = strArr[0].substring(iLastIndexOf2);
            strArr[0] = strArr[0].substring(0, iLastIndexOf2);
        }
        if (strArr[1] == null) {
            strArr[1] = "";
        }
        if (strArr[1].length() > 1) {
            strArr[1] = strArr[1].substring(1);
        }
        strArr[0] = filteredName(strArr[0]);
        return strArr;
    }

    private static String filteredName(String str) {
        return str == null ? "" : str;
    }

    public void setActionViewIntent(Intent intent, IUserContextManager iUserContextManager) throws ParseException {
        try {
            setUri(intent.getData());
            if (getFile(iUserContextManager).length() >= getSize()) {
            } else {
                throw new ParseException("File incomplete", 0);
            }
        } catch (ParseException unused) {
            throw new ParseException("No information parsable", 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x009a  */
    public void setUri(Uri uri) throws ParseException {
        String string;
        long length;
        long jCurrentTimeMillis;
        long j;
        this.mUri = uri;
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase("file")) {
            String[] nameAndExtension = getNameAndExtension(this.mUri.getLastPathSegment());
            string = nameAndExtension[0];
            this.fileExtension = nameAndExtension[1];
            File file = new File(this.mUri.getPath());
            length = file.length();
            jCurrentTimeMillis = file.lastModified();
        } else if (scheme.equalsIgnoreCase("content")) {
            ContentResolver contentResolver = ApplicationProvider.getApplication().getContentResolver();
            Uri treeUriForFolder = FileUtil.formatTreeUriForFolder(uri, ApplicationProvider.getApplication().getApplicationContext());
            try {
                Cursor cursorQuery = MAMContentResolverManagement.query(contentResolver, treeUriForFolder, new String[]{"_display_name", "_size"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            string = cursorQuery.getString(0);
                            j = cursorQuery.getLong(1);
                            if (string != null) {
                                String[] nameAndExtension2 = getNameAndExtension(string);
                                String str = nameAndExtension2[0];
                                this.fileExtension = nameAndExtension2[1];
                                string = str;
                            }
                        } else {
                            string = null;
                            j = 0;
                        }
                    } catch (Throwable th) {
                        if (cursorQuery == null) {
                            throw th;
                        }
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } else {
                    string = null;
                    j = 0;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (string == null) {
                    String type = MAMContentResolverManagement.getType(contentResolver, treeUriForFolder);
                    if (type != null && !type.equals("image") && !type.equals(MimeTypes.BASE_TYPE_VIDEO)) {
                        type = null;
                    }
                    String[] nameAndExtension3 = getNameAndExtension(CommonBoxUtil.getTimestampedName(type, null, CommonBoxUtil.getFileExtension(this.mUri.getLastPathSegment(), ""), new Date()));
                    string = nameAndExtension3[0];
                    this.fileExtension = nameAndExtension3[1];
                }
                jCurrentTimeMillis = 0;
                length = j;
            } catch (SQLiteException | SecurityException unused) {
                return;
            }
        } else if (scheme.contains("http")) {
            String[] nameAndExtension4 = getNameAndExtension(this.mUri.toString().substring(this.mUri.toString().lastIndexOf("/") + 1));
            string = nameAndExtension4[0];
            this.fileExtension = nameAndExtension4[1];
            length = 0;
            jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        } else {
            string = null;
            length = 0;
            jCurrentTimeMillis = 0;
        }
        setNameWithoutExtension(string);
        setSize(length);
        setLastUpdated(jCurrentTimeMillis);
        if (string == null) {
            throw new ParseException("No information parsable", 0);
        }
        if (this.fileExtension == null) {
            this.fileExtension = "";
        }
    }

    public void setNameWithoutExtension(String str) {
        this.fileNameOnly = str;
        if (StringUtils.isEmpty(this.fileExtension)) {
            return;
        }
        setFileName(this.fileNameOnly + "." + this.fileExtension);
    }

    public String getNameWithoutExtension() {
        return this.fileNameOnly;
    }

    public String getFileName() {
        if (StringUtils.isEmpty(this.fileExtension)) {
            return this.fileNameOnly;
        }
        return this.mFileName;
    }

    public void setFileName(String str) {
        this.mFileName = str;
        if (StringUtils.isNotEmpty(str)) {
            String[] nameAndExtension = getNameAndExtension(str);
            this.fileNameOnly = nameAndExtension[0];
            this.fileExtension = nameAndExtension[1];
        }
    }

    public String getFileAbsolutePath(IUserContextManager iUserContextManager) {
        return getFile(iUserContextManager).getAbsolutePath();
    }

    public Uri getUri() {
        return this.mUri;
    }

    public static class UriFile extends File implements Serializable {
        private String mUriAsString;

        private UriFile() {
            super("");
        }

        public UriFile(File file) {
            super(file.getAbsolutePath());
        }

        public UriFile(Uri uri) {
            super("");
            this.mUriAsString = uri.toString();
        }

        public Uri getUri() {
            String str = this.mUriAsString;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        @Override // java.io.File
        public long length() {
            if (this.mUriAsString == null) {
                return super.length();
            }
            Cursor cursorQuery = MAMContentResolverManagement.query(ApplicationProvider.getApplication().getContentResolver(), FileUtil.formatTreeUriForFolder(getUri(), ApplicationProvider.getApplication().getApplicationContext()), null, null, null, null);
            cursorQuery.moveToFirst();
            long j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_size"));
            cursorQuery.close();
            return j;
        }

        @Override // java.io.File
        public boolean delete() {
            if (this.mUriAsString != null) {
                ApplicationProvider.getApplication().getContentResolver().releasePersistableUriPermission(getUri(), 1);
            }
            return super.delete();
        }

        public boolean deleteIfTemporary(IUserContextManager iUserContextManager) {
            if (this.mUriAsString != null) {
                ApplicationProvider.getApplication().getContentResolver().releasePersistableUriPermission(getUri(), 1);
                return true;
            }
            if (iUserContextManager.getPreviewStorage().getTempUploadDirectory() == null || !getAbsolutePath().startsWith(iUserContextManager.getPreviewStorage().getTempUploadDirectory().getAbsolutePath())) {
                return false;
            }
            delete();
            return true;
        }

        public InputStream getInputStream() throws FileNotFoundException {
            if (this.mUriAsString == null) {
                return new FileInputStream(this);
            }
            return MAMContentResolverManagement.openInputStream(ApplicationProvider.getApplication().getContentResolver(), getUri());
        }

        @Override // java.io.File
        public String getAbsolutePath() {
            String str = this.mUriAsString;
            return str != null ? str : super.getAbsolutePath();
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0250 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0297 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:? A[Catch: all -> 0x02af, SYNTHETIC, TryCatch #11 {, blocks: (B:5:0x0010, B:7:0x0016, B:9:0x001c, B:11:0x0024, B:13:0x002c, B:16:0x0030, B:18:0x0040, B:35:0x00c1, B:51:0x016b, B:92:0x0266, B:94:0x026a, B:96:0x0270, B:98:0x0278, B:99:0x028e, B:54:0x0171, B:55:0x0180, B:88:0x0250, B:91:0x0255, B:105:0x0297, B:109:0x02ae, B:108:0x029c, B:38:0x00d0, B:19:0x0053, B:21:0x005b, B:24:0x006c, B:26:0x008b, B:28:0x0091, B:30:0x00a7, B:32:0x00b2, B:34:0x00bf), top: B:130:0x0010, inners: #0, #4, #5, #7, #10 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x019e A[Catch: Exception -> 0x01a2, all -> 0x0292, TRY_LEAVE, TryCatch #8 {Exception -> 0x01a2, blocks: (B:66:0x0196, B:68:0x019e), top: B:126:0x0196, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01f3 A[Catch: all -> 0x0292, TryCatch #1 {all -> 0x0292, blocks: (B:48:0x0157, B:49:0x015f, B:66:0x0196, B:68:0x019e, B:72:0x01aa, B:74:0x01dd, B:76:0x01e9, B:86:0x0239, B:77:0x01f3, B:79:0x01f7, B:81:0x0203, B:82:0x0222, B:84:0x0226, B:85:0x0230, B:71:0x01a3, B:44:0x011b, B:46:0x0123, B:47:0x012b), top: B:115:0x00e4, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01f7 A[Catch: all -> 0x0292, TryCatch #1 {all -> 0x0292, blocks: (B:48:0x0157, B:49:0x015f, B:66:0x0196, B:68:0x019e, B:72:0x01aa, B:74:0x01dd, B:76:0x01e9, B:86:0x0239, B:77:0x01f3, B:79:0x01f7, B:81:0x0203, B:82:0x0222, B:84:0x0226, B:85:0x0230, B:71:0x01a3, B:44:0x011b, B:46:0x0123, B:47:0x012b), top: B:115:0x00e4, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0222 A[Catch: all -> 0x0292, TryCatch #1 {all -> 0x0292, blocks: (B:48:0x0157, B:49:0x015f, B:66:0x0196, B:68:0x019e, B:72:0x01aa, B:74:0x01dd, B:76:0x01e9, B:86:0x0239, B:77:0x01f3, B:79:0x01f7, B:81:0x0203, B:82:0x0222, B:84:0x0226, B:85:0x0230, B:71:0x01a3, B:44:0x011b, B:46:0x0123, B:47:0x012b), top: B:115:0x00e4, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0226 A[Catch: all -> 0x0292, TryCatch #1 {all -> 0x0292, blocks: (B:48:0x0157, B:49:0x015f, B:66:0x0196, B:68:0x019e, B:72:0x01aa, B:74:0x01dd, B:76:0x01e9, B:86:0x0239, B:77:0x01f3, B:79:0x01f7, B:81:0x0203, B:82:0x0222, B:84:0x0226, B:85:0x0230, B:71:0x01a3, B:44:0x011b, B:46:0x0123, B:47:0x012b), top: B:115:0x00e4, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0230 A[Catch: all -> 0x0292, TryCatch #1 {all -> 0x0292, blocks: (B:48:0x0157, B:49:0x015f, B:66:0x0196, B:68:0x019e, B:72:0x01aa, B:74:0x01dd, B:76:0x01e9, B:86:0x0239, B:77:0x01f3, B:79:0x01f7, B:81:0x0203, B:82:0x0222, B:84:0x0226, B:85:0x0230, B:71:0x01a3, B:44:0x011b, B:46:0x0123, B:47:0x012b), top: B:115:0x00e4, inners: #8 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.InputStream] */
    public synchronized UriFile getFile(IUserContextManager iUserContextManager) {
        ?? r7;
        Throwable th;
        Exception exc;
        File fileCreateTemporaryPendingUploadFile;
        StringBuilder sb;
        String str;
        UriFile uriFile;
        InputStream inputStreamOpenInputStream;
        String str2 = "Cannot persist ";
        synchronized (this) {
            this.getFileAttempted = true;
            UriFile uriFile2 = this.fileToUpload;
            if (uriFile2 != null && (uriFile2.getUri() != null || (this.fileToUpload.isFile() && this.fileToUpload.canRead()))) {
                return this.fileToUpload;
            }
            String scheme = this.mUri.getScheme();
            ?? r11 = 0;
            if (scheme.equalsIgnoreCase("file")) {
                this.fileToUpload = new UriFile(new File(this.mUri.getEncodedPath()));
            } else {
                if (scheme.equalsIgnoreCase("content") && DocumentsContract.isDocumentUri(ApplicationProvider.getApplication().getApplicationContext(), this.mUri)) {
                    try {
                        Cursor cursorQuery = MAMContentResolverManagement.query(ApplicationProvider.getApplication().getContentResolver(), this.mUri, new String[]{"_data", "_display_name"}, null, null, null);
                        if (cursorQuery != null && cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            cursorQuery.close();
                            if (!SdkUtils.isBlank(string) && new File(string).exists()) {
                                this.fileToUpload = new UriFile(new File(string));
                            }
                        }
                    } catch (Exception unused) {
                        this.fileToUpload = null;
                    }
                }
                throw th;
            }
            try {
                ApplicationProvider.getApplication().getContentResolver().takePersistableUriPermission(this.mUri, 1);
                r7 = str2;
            } catch (SecurityException e) {
                String str3 = "Cannot persist " + this.mUri;
                BoxLogUtils.e(str3, e);
                r7 = str3;
            }
            long length = 0;
            try {
                try {
                    if (scheme.contains("http")) {
                        URL url = new URL(this.mUri.toString());
                        URLConnection uRLConnectionOpenConnection = url.openConnection();
                        uRLConnectionOpenConnection.connect();
                        length = uRLConnectionOpenConnection.getContentLength();
                        inputStreamOpenInputStream = new BufferedInputStream(url.openStream());
                    } else {
                        inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(ApplicationProvider.getApplication().getContentResolver(), this.mUri);
                        try {
                            if (scheme.equalsIgnoreCase("file")) {
                                length = this.fileToUpload.length();
                                inputStreamOpenInputStream = inputStreamOpenInputStream;
                            } else {
                                Cursor cursorQuery2 = MAMContentResolverManagement.query(ApplicationProvider.getApplication().getContentResolver(), this.mUri, new String[]{"_size"}, null, null, null);
                                cursorQuery2.moveToFirst();
                                length = cursorQuery2.getLong(cursorQuery2.getColumnIndexOrThrow("_size"));
                                cursorQuery2.close();
                                inputStreamOpenInputStream = inputStreamOpenInputStream;
                            }
                        } catch (IOException | NullPointerException | SecurityException e2) {
                            exc = e2;
                            fileCreateTemporaryPendingUploadFile = null;
                            r7 = inputStreamOpenInputStream;
                            String absolutePath = "";
                            try {
                                absolutePath = this.fileToUpload.getAbsolutePath();
                                if (fileCreateTemporaryPendingUploadFile != null) {
                                    FileUtils.deleteDirectory(fileCreateTemporaryPendingUploadFile);
                                }
                            } catch (Exception e3) {
                                BoxLogUtils.e("UploadModelBoxFile", "Failed to delete temp upload file", e3);
                            }
                            BoxLogUtils.e("UploadModelBoxFile", "Copying file for upload failed! \nfileSize -> " + length + "\nsourceUri ->" + this.mUri + "\ntempFileUri ->" + absolutePath, exc);
                            this.fileToUpload = null;
                            sb = new StringBuilder();
                            if (!(exc instanceof FileNotFoundException)) {
                                if (!(exc instanceof IOException)) {
                                    if (exc instanceof SecurityException) {
                                        sb.append(CommonBoxUtil.LS(R.string.upload_file_not_accessible));
                                    } else {
                                        sb.append(CommonBoxUtil.LS(R.string.generic_error));
                                    }
                                } else if (exc instanceof SecurityException) {
                                    sb.append(CommonBoxUtil.LS(R.string.upload_file_not_accessible));
                                } else {
                                    sb.append(CommonBoxUtil.LS(R.string.generic_error));
                                }
                            } else if (!(exc instanceof IOException)) {
                                if (exc instanceof SecurityException) {
                                    sb.append(CommonBoxUtil.LS(R.string.upload_file_not_accessible));
                                } else {
                                    sb.append(CommonBoxUtil.LS(R.string.generic_error));
                                }
                            } else if (exc instanceof SecurityException) {
                                sb.append(CommonBoxUtil.LS(R.string.upload_file_not_accessible));
                            } else {
                                sb.append(CommonBoxUtil.LS(R.string.generic_error));
                            }
                            final String string2 = sb.toString();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Toast.makeText(ApplicationProvider.getApplication(), string2, 1).show();
                                }
                            });
                            if (r7 != 0) {
                                try {
                                    r7.close();
                                } catch (IOException e4) {
                                    e = e4;
                                    str = "Cannot close input stream for " + this.mUri;
                                    BoxLogUtils.e(str, e);
                                }
                            }
                            uriFile = this.fileToUpload;
                            if (uriFile != null) {
                                BoxLogUtils.e("UploadModelBoxFile", "File copy not null but not readable " + this.mUri);
                                this.fileToUpload = null;
                            }
                            return this.fileToUpload;
                        }
                    }
                    fileCreateTemporaryPendingUploadFile = iUserContextManager.getPreviewStorage().createTemporaryPendingUploadFile();
                    try {
                        FileUtils.copyInputStreamToFile(inputStreamOpenInputStream, fileCreateTemporaryPendingUploadFile);
                        this.fileToUpload = new UriFile(fileCreateTemporaryPendingUploadFile);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                str = "Cannot close input stream for " + this.mUri;
                                BoxLogUtils.e(str, e);
                            }
                        }
                    } catch (IOException | NullPointerException | SecurityException e6) {
                        exc = e6;
                        r7 = inputStreamOpenInputStream;
                        String absolutePath2 = "";
                        absolutePath2 = this.fileToUpload.getAbsolutePath();
                        if (fileCreateTemporaryPendingUploadFile != null) {
                            FileUtils.deleteDirectory(fileCreateTemporaryPendingUploadFile);
                        }
                        BoxLogUtils.e("UploadModelBoxFile", "Copying file for upload failed! \nfileSize -> " + length + "\nsourceUri ->" + this.mUri + "\ntempFileUri ->" + absolutePath2, exc);
                        this.fileToUpload = null;
                        sb = new StringBuilder();
                        if (!(exc instanceof FileNotFoundException) && exc.getMessage().contains("StorageFileLoadException")) {
                            sb.append(CommonBoxUtil.LS(R.string.upload_file_not_accessible));
                        } else if (!(exc instanceof IOException) && exc.getMessage().contains("No space left on device")) {
                            sb.append(String.format(ApplicationProvider.getApplication().getResources().getString(R.string.device_storage_error), SdkUtils.getLocalizedFileSize(length)));
                        } else if (exc instanceof SecurityException) {
                            sb.append(CommonBoxUtil.LS(R.string.upload_file_not_accessible));
                        } else {
                            sb.append(CommonBoxUtil.LS(R.string.generic_error));
                        }
                        final String string3 = sb.toString();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                Toast.makeText(ApplicationProvider.getApplication(), string3, 1).show();
                            }
                        });
                        if (r7 != 0) {
                            r7.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r11 = r7;
                    if (r11 != 0) {
                        try {
                            r11.close();
                            throw th;
                        } catch (IOException e7) {
                            BoxLogUtils.e("Cannot close input stream for " + this.mUri, e7);
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (IOException | NullPointerException | SecurityException e8) {
                exc = e8;
                r7 = 0;
                fileCreateTemporaryPendingUploadFile = null;
            } catch (Throwable th3) {
                th = th3;
                if (r11 != 0) {
                    r11.close();
                    throw th;
                }
                throw th;
            }
            uriFile = this.fileToUpload;
            if (uriFile != null && (!uriFile.isFile() || !this.fileToUpload.canRead())) {
                BoxLogUtils.e("UploadModelBoxFile", "File copy not null but not readable " + this.mUri);
                this.fileToUpload = null;
            }
            return this.fileToUpload;
        }
    }

    public boolean isFile() {
        if (this.mUri.getScheme().equalsIgnoreCase("content")) {
            return DocumentsContract.isDocumentUri(ApplicationProvider.getApplication(), this.mUri);
        }
        if (this.mUri.getScheme().equalsIgnoreCase("file")) {
            return new UriFile(new File(this.mUri.getEncodedPath())).isFile();
        }
        return false;
    }

    public Bitmap getThumbnailBitmap() {
        try {
            String scheme = this.mUri.getScheme();
            if (scheme.equalsIgnoreCase("content")) {
                Cursor cursorQuery = MAMContentResolverManagement.query(ApplicationProvider.getApplication().getContentResolver(), this.mUri, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "mime_type"}, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    Long lValueOf = Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX)));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"));
                    cursorQuery.close();
                    if (string.contains("image")) {
                        return MediaStore.Images.Thumbnails.getThumbnail(ApplicationProvider.getApplication().getContentResolver(), lValueOf.longValue(), 3, null);
                    }
                    if (string.contains(MimeTypes.BASE_TYPE_VIDEO)) {
                        return MediaStore.Video.Thumbnails.getThumbnail(ApplicationProvider.getApplication().getContentResolver(), lValueOf.longValue(), 3, null);
                    }
                }
            } else if (scheme.equalsIgnoreCase("file")) {
                return ThumbnailUtils.extractThumbnail(CommonBoxUtil.decodeSampledBitmapFromFile(new File(this.mUri.getPath()), 96, 96), 96, 96);
            }
        } catch (SQLiteException | OutOfMemoryError | SecurityException | Exception unused) {
        }
        return null;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public String getUpdatedString() {
        return BoxDateUtils.formatFileItemTime(getLastUpdated(), ApplicationProvider.getApplication().getApplicationContext());
    }

    public boolean isExistingNameConflict() {
        if (isOverwriteExisting()) {
            return false;
        }
        return BoxStaticUploadModel.nameAlreadyExists(getFileName());
    }

    public String getConflictedFileId() {
        return BoxStaticUploadModel.getConflictedFileId(getFileName());
    }

    public boolean isBlankFileName() {
        return StringUtils.isEmpty(getFileName());
    }

    public boolean isInvalidNameConflict() {
        if (getFileName() == null) {
            return true;
        }
        return !CommonBoxUtil.isFilenameValidForSD(getFileName());
    }

    public void setEnabledStatus(boolean z) {
        this.mEnabled = z;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isOverUploadLimit() {
        return this.overUploadLimit;
    }

    public void setOverUploadLimit(boolean z) {
        this.overUploadLimit = z;
    }

    public boolean isFileError() {
        if (!this.getFileAttempted) {
            return false;
        }
        UriFile uriFile = this.fileToUpload;
        return uriFile == null || uriFile.length() <= 0;
    }

    public boolean isFileErrorBackgroundThread(IUserContextManager iUserContextManager) {
        return getFile(iUserContextManager) == null;
    }

    public void setOverwriteExisting(boolean z) {
        this.mOverwriteExisting = z;
    }

    public boolean isOverwriteExisting() {
        return this.mOverwriteExisting;
    }

    public double getSize() {
        return this.mSize;
    }

    public void setSize(double d) {
        this.mSize = d;
    }

    public long getLastUpdated() {
        return this.mLastUpdated;
    }

    public void setLastUpdated(long j) {
        this.mLastUpdated = j;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }
}

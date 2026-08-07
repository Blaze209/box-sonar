package com.box.android.domain.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.j256.ormlite.field.FieldType;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileScannerUtil.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bJ\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bJ \u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/domain/utils/FileScannerUtil;", "", "<init>", "()V", "ALL_FILES_EXTERNAL", "Landroid/net/Uri;", "PROJECTION", "", "", "[Ljava/lang/String;", "PROJECTION_DATA_INDEX", "", "hasAnyFileModifiedAfter", "", "path", "lastSyncTime", "", "isAnyDeviceFileInSourceDirectory", "fileIds", "", "localPath", "context", "Landroid/content/Context;", "getFileNameFromPath", "filePath", "getPathFromBase", "baseDir", BoxCommonConstants.EXTRA_FILE_NAME, "getFileFromContentUri", "Ljava/io/File;", "uri", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileScannerUtil {
    private static final Uri ALL_FILES_EXTERNAL;
    public static final FileScannerUtil INSTANCE = new FileScannerUtil();
    private static final String[] PROJECTION;
    private static final int PROJECTION_DATA_INDEX = 1;

    private FileScannerUtil() {
    }

    static {
        Uri contentUri = MediaStore.Files.getContentUri(BoxAnalyticsParams.REFERRER_EXTERNAL);
        Intrinsics.checkNotNullExpressionValue(contentUri, "getContentUri(...)");
        ALL_FILES_EXTERNAL = contentUri;
        PROJECTION = new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "_data"};
    }

    public final boolean hasAnyFileModifiedAfter(String path, long lastSyncTime) {
        Intrinsics.checkNotNullParameter(path, "path");
        File[] fileArrListFiles = new File(path).listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        for (File file : fileArrListFiles) {
            if (file.lastModified() > lastSyncTime) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAnyDeviceFileInSourceDirectory(List<String> fileIds, String localPath, Context context) throws IOException {
        Intrinsics.checkNotNullParameter(fileIds, "fileIds");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(context, "context");
        if (fileIds.isEmpty()) {
            return false;
        }
        Cursor cursorQuery = MAMContentResolverManagement.query(context.getContentResolver(), ALL_FILES_EXTERNAL, PROJECTION, CollectionsKt.joinToString$default(fileIds, " OR ", null, null, 0, null, new Function1() { // from class: com.box.android.domain.utils.FileScannerUtil$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileScannerUtil.isAnyDeviceFileInSourceDirectory$lambda$0((String) obj);
            }
        }, 30, null), null, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(1);
                    Intrinsics.checkNotNull(string);
                    if (StringsKt.startsWith$default(string, localPath, false, 2, (Object) null)) {
                        CloseableKt.closeFinally(cursor, null);
                        return true;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence isAnyDeviceFileInSourceDirectory$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "_id='" + it + "'";
    }

    public final String getPathFromBase(String filePath, String baseDir, String fileName) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(baseDir, "baseDir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String strRemovePrefix = StringsKt.removePrefix(StringsKt.removeSuffix(filePath, (CharSequence) ("/" + fileName)), (CharSequence) baseDir);
        return strRemovePrefix.length() != 0 ? strRemovePrefix : "/";
    }

    public final File getFileFromContentUri(Context context, Uri uri, IBoxStorage boxStorage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        try {
            InputStream inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(context.getContentResolver(), uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                InputStream inputStream2 = inputStream;
                File fileCreateTemporaryPendingUploadFile = boxStorage.createTemporaryPendingUploadFile();
                Intrinsics.checkNotNull(fileCreateTemporaryPendingUploadFile);
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTemporaryPendingUploadFile);
                try {
                    ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(inputStream, null);
                    return fileCreateTemporaryPendingUploadFile;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStream, th3);
                    throw th4;
                }
            }
        } catch (IOException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to copy file from content URI: " + uri, e);
            return null;
        }
    }

    public final String getFileNameFromPath(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return Uri.parse(filePath).getLastPathSegment();
    }
}

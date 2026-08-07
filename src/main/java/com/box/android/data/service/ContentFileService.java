package com.box.android.data.service;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.net.UriKt;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.domain.services.IContentFileService;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/service/ContentFileService;", "Lcom/box/android/domain/services/IContentFileService;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "copyFileFromUri", "", "uri", "Landroid/net/Uri;", FirebaseAnalytics.Param.DESTINATION, "Ljava/io/File;", "getDisplayName", "", "hasStoragePermission", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ContentFileService implements IContentFileService {
    private final Context context;

    @Inject
    public ContentFileService(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.box.android.domain.services.IContentFileService
    public void copyFileFromUri(Uri uri, File destination) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(destination, "destination");
        InputStream inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(this.context.getContentResolver(), uri);
        if (inputStreamOpenInputStream != null) {
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                InputStream inputStream2 = inputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(destination);
                try {
                    long jCopyTo$default = ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    Long.valueOf(jCopyTo$default);
                    CloseableKt.closeFinally(inputStream, null);
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
        }
    }

    @Override // com.box.android.domain.services.IContentFileService
    public String getDisplayName(Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual(uri.getScheme(), "file")) {
            String name = UriKt.toFile(uri).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        Cursor cursorQuery = MAMContentResolverManagement.query(this.context.getContentResolver(), uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                String string = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name")) : null;
                CloseableKt.closeFinally(cursor, null);
                if (string != null) {
                    return string;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        String lastPathSegment = uri.getLastPathSegment();
        return lastPathSegment == null ? "unknown" : lastPathSegment;
    }

    @Override // com.box.android.domain.services.IContentFileService
    public boolean hasStoragePermission() {
        return OSPermissionUtils.INSTANCE.hasStoragePermission(true);
    }
}

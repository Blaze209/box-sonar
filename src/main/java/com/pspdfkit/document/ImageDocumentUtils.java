package com.pspdfkit.document;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.j256.ormlite.field.FieldType;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.document.providers.ContentResolverDataProvider;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wg;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ImageDocumentUtils {
    private static final String LOG_TAG = "Nutri.ImageDocUtils";

    private static Uri getFileUri(ImageDocument imageDocument) {
        DocumentSource imageDocumentSource = imageDocument.getImageDocumentSource();
        if (imageDocumentSource.getFileUri() != null) {
            return imageDocumentSource.getFileUri();
        }
        if (imageDocumentSource.getDataProvider() instanceof ContentResolverDataProvider) {
            return ((ContentResolverDataProvider) imageDocumentSource.getDataProvider()).getUri();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invalidateImageThumbnail(Context context, Uri uri) throws Exception {
        String strA = wg.a(context, uri);
        if (strA == null) {
            return;
        }
        Cursor cursorQuery = MAMContentResolverManagement.query(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX}, "_data=?", new String[]{new File(strA).getCanonicalPath()}, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return;
        }
        MAMContentResolverManagement.delete(context.getContentResolver(), MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, "image_id = ?", new String[]{String.valueOf(cursorQuery.getInt(0))});
        cursorQuery.close();
    }

    public static boolean isImageUri(Context context, Uri uri) {
        String fileExtensionFromUrl;
        uw.a(context, "context", null);
        uw.a(uri, "uri", null);
        String type = MAMContentResolverManagement.getType(context.getContentResolver(), uri);
        if (type == null && (fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString())) != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return type != null && type.startsWith("image/");
    }

    static /* synthetic */ void lambda$refreshMediaStore$1(Uri uri, Context context) throws Throwable {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    public static void refreshMediaStore(final Context context, ImageDocument imageDocument) {
        uw.a(context, "context", null);
        uw.a(imageDocument, "imageDocument", null);
        final Uri fileUri = getFileUri(imageDocument);
        if (fileUri == null) {
            return;
        }
        Completable.fromAction(new Action() { // from class: com.pspdfkit.document.ImageDocumentUtils$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Exception {
                ImageDocumentUtils.invalidateImageThumbnail(context, fileUri);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Action() { // from class: com.pspdfkit.document.ImageDocumentUtils$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                ImageDocumentUtils.lambda$refreshMediaStore$1(fileUri, context);
            }
        }, new Consumer() { // from class: com.pspdfkit.document.ImageDocumentUtils$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                PdfLog.w(ImageDocumentUtils.LOG_TAG, (Throwable) obj, "Failed to invalidate the image thumbnail.", new Object[0]);
            }
        });
    }
}

package com.microsoft.intune.mam.client.content;

import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsProvider;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedDocumentsProvider extends HookedContentProvider {
    DocumentsProvider asDocumentsProvider();

    String copyDocumentMAM(String str, String str2) throws FileNotFoundException;

    String copyDocumentReal(String str, String str2) throws FileNotFoundException;

    String createDocumentMAM(String str, String str2, String str3) throws FileNotFoundException;

    String createDocumentReal(String str, String str2, String str3) throws FileNotFoundException;

    IntentSender createWebLinkIntentMAM(String str, Bundle bundle) throws FileNotFoundException;

    IntentSender createWebLinkIntentReal(String str, Bundle bundle) throws FileNotFoundException;

    void deleteDocumentMAM(String str) throws FileNotFoundException;

    void deleteDocumentReal(String str) throws FileNotFoundException;

    void ejectRootMAM(String str);

    void ejectRootReal(String str);

    Object findDocumentPathMAM(String str, String str2) throws FileNotFoundException;

    Object findDocumentPathReal(String str, String str2) throws FileNotFoundException;

    String moveDocumentMAM(String str, String str2, String str3) throws FileNotFoundException;

    String moveDocumentReal(String str, String str2, String str3) throws FileNotFoundException;

    ParcelFileDescriptor openDocumentMAM(String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openDocumentThumbnailMAM(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openDocumentThumbnailReal(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedDocumentMAM(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor openTypedDocumentReal(String str, String str2, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    Cursor queryChildDocumentsMAM(String str, String[] strArr, Bundle bundle) throws FileNotFoundException;

    Cursor queryChildDocumentsMAM(String str, String[] strArr, String str2) throws FileNotFoundException;

    Cursor queryChildDocumentsReal(String str, String[] strArr, Bundle bundle) throws FileNotFoundException;

    Cursor queryDocumentMAM(String str, String[] strArr) throws FileNotFoundException;

    Cursor queryRecentDocumentsMAM(String str, String[] strArr) throws FileNotFoundException;

    Cursor queryRecentDocumentsReal(String str, String[] strArr) throws FileNotFoundException;

    Cursor queryRootsMAM(String[] strArr) throws FileNotFoundException;

    Cursor querySearchDocumentsMAM(String str, String str2, String[] strArr) throws FileNotFoundException;

    Cursor querySearchDocumentsReal(String str, String str2, String[] strArr) throws FileNotFoundException;

    void removeDocumentMAM(String str, String str2) throws FileNotFoundException;

    void removeDocumentReal(String str, String str2) throws FileNotFoundException;
}

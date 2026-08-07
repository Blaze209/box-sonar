package androidx.webkit;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.webkit.internal.WebViewGlueCommunicator;
import com.microsoft.intune.mam.client.content.MAMContentProvider;
import java.io.FileNotFoundException;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class DropDataContentProvider extends MAMContentProvider {
    DropDataContentProviderBoundaryInterface mImpl;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // com.microsoft.intune.mam.client.content.MAMContentProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException {
        return getDropImpl().openFile(this, uri);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return getDropImpl().query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return getDropImpl().getType(uri);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert method is not supported.");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("delete method is not supported.");
    }

    @Override // com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("update method is not supported.");
    }

    @Override // com.microsoft.intune.mam.client.content.MAMContentProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public Bundle callMAM(String str, String str2, Bundle bundle) {
        return getDropImpl().call(str, str2, bundle);
    }

    private DropDataContentProviderBoundaryInterface getDropImpl() {
        if (this.mImpl == null) {
            DropDataContentProviderBoundaryInterface dropDataProvider = WebViewGlueCommunicator.getFactory().getDropDataProvider();
            this.mImpl = dropDataProvider;
            dropDataProvider.onCreate();
        }
        return this.mImpl;
    }
}

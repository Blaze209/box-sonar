package external.sdk.pendo.io.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final UriMatcher URI_MATCHER;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream loadResourceFromUri(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = URI_MATCHER.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return openContactPhotoInputStream(contentResolver, uri);
            }
            if (iMatch != 5) {
                return (this.useMediaStoreApisIfAvailable && sdk.pendo.io.g.a.c(uri) && sdk.pendo.io.g.a.a()) ? openMediaStoreFileInputStream(uri, contentResolver) : MAMContentResolverManagement.openInputStream(contentResolver, uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return openContactPhotoInputStream(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    private InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private InputStream openMediaStoreFileInputStream(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorA = sdk.pendo.io.g.a.a(uri, contentResolver);
        if (assetFileDescriptorA == null) {
            throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
        try {
            return assetFileDescriptorA.createInputStream();
        } catch (IOException e) {
            try {
                assetFileDescriptorA.close();
            } catch (Exception unused) {
            }
            throw ((FileNotFoundException) new FileNotFoundException("Unable to create stream").initCause(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.glide.load.data.LocalUriFetcher
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // external.sdk.pendo.io.glide.load.data.LocalUriFetcher, external.sdk.pendo.io.glide.load.data.a
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.sdk.pendo.io.glide.load.data.LocalUriFetcher
    public InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamLoadResourceFromUri = loadResourceFromUri(uri, contentResolver);
        if (inputStreamLoadResourceFromUri != null) {
            return inputStreamLoadResourceFromUri;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z) {
        super(contentResolver, uri, z);
    }
}

package com.microsoft.intune.mam.client.app.offline;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior;
import com.microsoft.intune.mam.client.content.HookedCloudMediaProvider;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
final class OfflineCloudMediaProviderBehavior implements CloudMediaProviderBehavior {
    HookedCloudMediaProvider mProvider;

    OfflineCloudMediaProviderBehavior() {
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public Bundle onGetMediaCollectionInfo(Bundle bundle) {
        checkBlocked();
        return this.mProvider.onGetMediaCollectionInfoMAM(bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public ParcelFileDescriptor onOpenMedia(String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mProvider.onOpenMediaMAM(str, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public AssetFileDescriptor onOpenPreview(String str, Point point, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        checkBlocked();
        return this.mProvider.onOpenPreviewMAM(str, point, bundle, cancellationSignal);
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public Cursor onQueryAlbums(Bundle bundle) {
        checkBlocked();
        return this.mProvider.onQueryAlbumsMAM(bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public Cursor onQueryDeletedMedia(Bundle bundle) {
        checkBlocked();
        return this.mProvider.onQueryDeletedMediaMAM(bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public Cursor onQueryMedia(Bundle bundle) {
        checkBlocked();
        return this.mProvider.onQueryMediaMAM(bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior
    public Cursor onQueryAlbumsMAM(Bundle bundle) {
        return this.mProvider.onQueryAlbumsReal(bundle);
    }

    private void checkBlocked() {
        if (MAMInfo.isPolicyRequired()) {
            throw new SecurityException();
        }
    }
}

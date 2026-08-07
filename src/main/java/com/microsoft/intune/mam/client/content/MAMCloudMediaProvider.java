package com.microsoft.intune.mam.client.content;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.CloudMediaProvider;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMCloudMediaProvider extends CloudMediaProvider implements HookedCloudMediaProvider {
    private final CloudMediaProviderBehavior mBehavior = (CloudMediaProviderBehavior) MAMComponents.get(CloudMediaProviderBehavior.class);

    @Override // com.microsoft.intune.mam.client.content.HookedCloudMediaProvider
    public final CloudMediaProvider asCloudMediaProvider() {
        return this;
    }

    @Override // android.provider.CloudMediaProvider
    public Bundle onGetMediaCollectionInfo(Bundle bundle) {
        return this.mBehavior.onGetMediaCollectionInfo(bundle);
    }

    @Override // android.provider.CloudMediaProvider
    public ParcelFileDescriptor onOpenMedia(String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.onOpenMedia(str, bundle, cancellationSignal);
    }

    @Override // android.provider.CloudMediaProvider
    public AssetFileDescriptor onOpenPreview(String str, Point point, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return this.mBehavior.onOpenPreview(str, point, bundle, cancellationSignal);
    }

    @Override // android.provider.CloudMediaProvider
    public Cursor onQueryAlbums(Bundle bundle) {
        return this.mBehavior.onQueryAlbums(bundle);
    }

    @Override // android.provider.CloudMediaProvider
    public Cursor onQueryDeletedMedia(Bundle bundle) {
        return this.mBehavior.onQueryDeletedMedia(bundle);
    }

    @Override // android.provider.CloudMediaProvider
    public Cursor onQueryMedia(Bundle bundle) {
        return this.mBehavior.onQueryMedia(bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedCloudMediaProvider
    public Cursor onQueryAlbumsReal(Bundle bundle) {
        return super.onQueryAlbums(bundle);
    }

    @Override // com.microsoft.intune.mam.client.content.HookedCloudMediaProvider
    public Cursor onQueryAlbumsMAM(Bundle bundle) {
        return this.mBehavior.onQueryAlbumsMAM(bundle);
    }
}

package com.microsoft.intune.mam.client.content;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public interface CloudMediaProviderBehavior {
    Bundle onGetMediaCollectionInfo(Bundle bundle);

    ParcelFileDescriptor onOpenMedia(String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor onOpenPreview(String str, Point point, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    Cursor onQueryAlbums(Bundle bundle);

    Cursor onQueryAlbumsMAM(Bundle bundle);

    Cursor onQueryDeletedMedia(Bundle bundle);

    Cursor onQueryMedia(Bundle bundle);
}

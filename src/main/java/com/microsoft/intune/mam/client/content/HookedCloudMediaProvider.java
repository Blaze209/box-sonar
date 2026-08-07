package com.microsoft.intune.mam.client.content;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.CloudMediaProvider;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedCloudMediaProvider {
    CloudMediaProvider asCloudMediaProvider();

    Bundle onGetMediaCollectionInfoMAM(Bundle bundle);

    ParcelFileDescriptor onOpenMediaMAM(String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    AssetFileDescriptor onOpenPreviewMAM(String str, Point point, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException;

    Cursor onQueryAlbumsMAM(Bundle bundle);

    Cursor onQueryAlbumsReal(Bundle bundle);

    Cursor onQueryDeletedMediaMAM(Bundle bundle);

    Cursor onQueryMediaMAM(Bundle bundle);
}

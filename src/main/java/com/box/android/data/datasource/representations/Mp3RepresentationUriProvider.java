package com.box.android.data.datasource.representations;

import com.box.android.domain.models.ItemId;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Mp3RepresentationUriProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/box/android/data/datasource/representations/Mp3RepresentationUriProvider;", "", "<init>", "()V", "getMp3RepresentationUri", "Ljava/net/URI;", "kotlin.jvm.PlatformType", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Mp3RepresentationUriProvider {
    @Inject
    public Mp3RepresentationUriProvider() {
    }

    public final URI getMp3RepresentationUri(ItemId.Remote itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return URI.create("https://api.box.com/2.0/files/" + itemId.getBoxId() + "/preview.mp3");
    }
}

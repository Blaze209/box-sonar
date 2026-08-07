package com.box.android.domain.controller;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.collection.LruCache;
import androidx.core.app.NotificationCompat;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBrowseController.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H&J\u0014\u0010\u0013\u001a\u00020\u00002\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H&J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0005H&J.\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H&J.\u0010!\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0017H&J&\u0010-\u001a\u00020\u00102\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u000101H&R\u0012\u0010#\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R \u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020(\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R \u0010+\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020(\u0018\u00010'X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u00062À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/controller/IBrowseController;", "", "getSearchRequest", "Lcom/box/androidsdk/content/requests/BoxRequestsSearch$Search;", "query", "", "getThumbnailRequest", "Lcom/box/androidsdk/content/requests/BoxRequestsFile$DownloadThumbnail;", "fileId", "downloadFile", "Ljava/io/File;", "getRepresentationThumbnailRequest", "Lcom/box/androidsdk/content/requests/BoxRequestsFile$DownloadRepresentation;", BoxRepresentation.FIELD_REPRESENTATION, "Lcom/box/androidsdk/content/models/BoxRepresentation;", "execute", "", "request", "Lcom/box/androidsdk/content/requests/BoxRequest;", "setCompletedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/androidsdk/content/BoxFutureTask$OnCompletedListener;", "getRecentSearches", "Ljava/util/ArrayList;", "context", "Landroid/content/Context;", "user", "Lcom/box/androidsdk/content/models/BoxUser;", "addToRecentSearches", "recentSearch", "deleteFromRecentSearches", "indexToRemove", "", "saveRecentSearches", "searches", "thumbnailCacheDir", "getThumbnailCacheDir", "()Ljava/io/File;", "thumbnailCache", "Landroidx/collection/LruCache;", "Landroid/graphics/Bitmap;", "getThumbnailCache", "()Landroidx/collection/LruCache;", "iconResourceCache", "getIconResourceCache", "log", "tag", NotificationCompat.CATEGORY_MESSAGE, "t", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBrowseController {
    ArrayList<String> addToRecentSearches(Context context, BoxUser user, String recentSearch);

    ArrayList<String> deleteFromRecentSearches(Context context, BoxUser user, int indexToRemove);

    void execute(BoxRequest<?, ?> request);

    LruCache<Integer, Bitmap> getIconResourceCache();

    ArrayList<String> getRecentSearches(Context context, BoxUser user);

    BoxRequestsFile.DownloadRepresentation getRepresentationThumbnailRequest(String fileId, BoxRepresentation representation, File downloadFile);

    BoxRequestsSearch.Search getSearchRequest(String query);

    LruCache<File, Bitmap> getThumbnailCache();

    File getThumbnailCacheDir();

    BoxRequestsFile.DownloadThumbnail getThumbnailRequest(String fileId, File downloadFile);

    void log(String tag, String msg, Throwable t);

    void saveRecentSearches(Context context, BoxUser user, ArrayList<String> searches);

    IBrowseController setCompletedListener(BoxFutureTask.OnCompletedListener<?> listener);
}

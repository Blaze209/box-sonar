package com.box.android.base.presentation;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.collection.LruCache;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.R;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.base.presentation.utilities.FolderTypeIcon;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.mappers.PermissionsModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.services.IThumbnailService;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorRepresentations;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.bumptech.glide.Glide;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.WeakHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ThumbnailManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0017\u0018\u0000 M2\u00020\u0001:\u0003KLMB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007J\u001c\u0010\u001f\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'J,\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u001e2\b\b\u0002\u0010-\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010.J,\u0010#\u001a\u0004\u0018\u00010)2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010,\u001a\u00020\u001e2\b\b\u0002\u0010-\u001a\u00020\u001eH\u0087@¢\u0006\u0002\u0010/J \u0010#\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u0002032\b\b\u0002\u0010,\u001a\u00020\u001eH\u0016J \u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'2\b\u00106\u001a\u0004\u0018\u000107J2\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u00172\u0010\u0010:\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010;2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020'H\u0016J\u001c\u0010>\u001a\u00020$2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030@2\u0006\u0010=\u001a\u00020'H\u0016J2\u0010A\u001a\u00020$2\u0006\u00109\u001a\u00020\u00172\u0010\u0010:\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010;2\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020'H\u0002J\u0016\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020'J\u0018\u0010B\u001a\u00020$2\b\u0010F\u001a\u0004\u0018\u00010 2\u0006\u0010E\u001a\u00020'J\u0018\u0010#\u001a\u00020$2\b\u0010<\u001a\u0004\u0018\u00010)2\u0006\u0010E\u001a\u00020'J\"\u0010G\u001a\u00020\u001e2\u0010\u0010:\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010;2\u0006\u0010=\u001a\u00020'H\u0002J\u0016\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u0002032\u0006\u0010J\u001a\u000203R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006N"}, d2 = {"Lcom/box/android/base/presentation/ThumbnailManager;", "Lcom/box/android/base/presentation/LoaderDrawable$ImageReadyListener;", "mController", "Lcom/box/android/domain/controller/IBrowseController;", "mUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "thumbnailService", "Lcom/box/android/domain/services/IThumbnailService;", "<init>", "(Lcom/box/android/domain/controller/IBrowseController;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IThumbnailService;)V", "getMUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setMUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "mTargetToTask", "Ljava/util/WeakHashMap;", "", "Lcom/box/androidsdk/content/BoxFutureTask;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "getThumbnailForBoxItem", "Ljava/io/File;", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "getThumbnailForBoxFile", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "isLargeThumbnail", "", "getRepCacheName", "", BoxRepresentation.FIELD_REPRESENTATION, "Lcom/box/androidsdk/content/models/BoxRepresentation;", "loadThumbnail", "", "item", "targetImage", "Landroid/widget/ImageView;", "loadThumbnailFileModel", "Landroid/graphics/Bitmap;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "isLargeThumbnailNeeded", "loadFromCacheOnly", "(Lcom/box/android/domain/models/item/FileModel;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/box/androidsdk/content/models/BoxFile;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/base/compose/ItemThumbnail;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "loadThumbnailRepresentation", "file", "loadListener", "Lcom/box/android/base/presentation/ThumbnailManager$ImageLoadListener;", "onImageReady", "bitmapSourceFile", "request", "Lcom/box/androidsdk/content/requests/BoxRequest;", "bitmap", "view", "onImageException", "response", "Lcom/box/androidsdk/content/requests/BoxResponse;", "postLaterToView", "loadKnownThumbnail", "resourceId", "", "imageView", "fileUrl", "isRequestStillApplicable", "canReuseThumbnailFromOldItem", "oldItem", "newItem", "ImageLoadListener", "ViewData", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ThumbnailManager implements LoaderDrawable.ImageReadyListener {
    public static final String TYPE_REPRESENTATION = "REPS";
    private final IBrowseController mController;
    private WeakHashMap<Object, BoxFutureTask<?>> mTargetToTask;
    private IUserContextManager mUserContextManager;
    private final IThumbnailService thumbnailService;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ThumbnailManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/ThumbnailManager$ImageLoadListener;", "", "onSuccess", "", "onError", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ImageLoadListener {
        void onError();

        void onSuccess();
    }

    @JvmStatic
    public static final int getDefaultIconResource(ItemModel itemModel) {
        return INSTANCE.getDefaultIconResource(itemModel);
    }

    @JvmStatic
    public static final int getDefaultIconResource(BoxItem boxItem) {
        return INSTANCE.getDefaultIconResource(boxItem);
    }

    @JvmStatic
    public static final boolean isThumbnailAvailable(ItemModel itemModel) {
        return INSTANCE.isThumbnailAvailable(itemModel);
    }

    @JvmStatic
    public static final boolean isThumbnailAvailable(BoxItem boxItem) {
        return INSTANCE.isThumbnailAvailable(boxItem);
    }

    @JvmStatic
    private static final boolean isThumbnailAvailable(String str, PermissionsModel permissionsModel, boolean z) {
        return INSTANCE.isThumbnailAvailable(str, permissionsModel, z);
    }

    public final File getThumbnailForBoxFile(BoxFile boxFile) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        return getThumbnailForBoxFile$default(this, boxFile, false, 2, null);
    }

    @Inject
    public ThumbnailManager(IBrowseController mController, IUserContextManager mUserContextManager, IThumbnailService thumbnailService) {
        Intrinsics.checkNotNullParameter(mController, "mController");
        Intrinsics.checkNotNullParameter(mUserContextManager, "mUserContextManager");
        Intrinsics.checkNotNullParameter(thumbnailService, "thumbnailService");
        this.mController = mController;
        this.mUserContextManager = mUserContextManager;
        this.thumbnailService = thumbnailService;
        this.mTargetToTask = new WeakHashMap<>();
    }

    protected final IUserContextManager getMUserContextManager() {
        return this.mUserContextManager;
    }

    protected final void setMUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.mUserContextManager = iUserContextManager;
    }

    private final Handler getMHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public final File getThumbnailForBoxItem(BoxItem boxItem) {
        if (boxItem instanceof BoxFile) {
            return getThumbnailForBoxFile$default(this, (BoxFile) boxItem, false, 2, null);
        }
        return null;
    }

    public static /* synthetic */ File getThumbnailForBoxFile$default(ThumbnailManager thumbnailManager, BoxFile boxFile, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getThumbnailForBoxFile");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return thumbnailManager.getThumbnailForBoxFile(boxFile, z);
    }

    public final File getThumbnailForBoxFile(BoxFile boxFile, boolean isLargeThumbnail) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        return this.thumbnailService.getThumbnailFile(boxFile, isLargeThumbnail);
    }

    private final String getRepCacheName(BoxFile boxFile, BoxRepresentation representation) {
        if (boxFile == null || SdkUtils.isBlank(boxFile.getUserId()) || SdkUtils.isBlank(boxFile.getSha1()) || representation == null) {
            throw new IllegalArgumentException("BoxFile argument must not be null and must also contain an id, sha1 and representation".toString());
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ENGLISH, "%s_%s_%s.%s", Arrays.copyOf(new Object[]{boxFile.getUserId(), boxFile.getSha1(), representation.getProperties().getDimension(), representation.getRepresentationType()}, 4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final void loadThumbnail(BoxItem item, ImageView targetImage) {
        Bitmap bitmap;
        Bitmap bitmapDrawableToBitmap$default;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(targetImage, "targetImage");
        targetImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Companion companion = INSTANCE;
        Bitmap bitmap2 = null;
        File thumbnailForBoxFile$default = companion.isThumbnailAvailable(item) ? getThumbnailForBoxFile$default(this, (BoxFile) item, false, 2, null) : null;
        if (thumbnailForBoxFile$default != null) {
            BoxFutureTask<?> boxFutureTaskRemove = this.mTargetToTask.remove(targetImage);
            if (boxFutureTaskRemove != null) {
                boxFutureTaskRemove.cancel(false);
            }
            if (this.mController.getThumbnailCache() != null) {
                LruCache<File, Bitmap> thumbnailCache = this.mController.getThumbnailCache();
                Intrinsics.checkNotNull(thumbnailCache);
                if (thumbnailCache.get(thumbnailForBoxFile$default) != null) {
                    LruCache<File, Bitmap> thumbnailCache2 = this.mController.getThumbnailCache();
                    Intrinsics.checkNotNull(thumbnailCache2);
                    targetImage.setImageBitmap(thumbnailCache2.get(thumbnailForBoxFile$default));
                    return;
                }
            }
            int defaultIconResource = companion.getDefaultIconResource(item);
            if (this.mController.getIconResourceCache() != null) {
                LruCache<Integer, Bitmap> iconResourceCache = this.mController.getIconResourceCache();
                Intrinsics.checkNotNull(iconResourceCache);
                bitmap = iconResourceCache.get(Integer.valueOf(defaultIconResource));
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                Drawable drawable = ResourcesCompat.getDrawable(targetImage.getResources(), defaultIconResource, null);
                if (drawable != null) {
                    if (targetImage.getMeasuredWidth() > 0 && targetImage.getMeasuredHeight() > 0) {
                        bitmapDrawableToBitmap$default = CommonBoxUtil.INSTANCE.drawableToBitmap(drawable, Integer.valueOf(targetImage.getMeasuredWidth()), Integer.valueOf(targetImage.getMeasuredHeight()));
                    } else {
                        bitmapDrawableToBitmap$default = CommonBoxUtil.drawableToBitmap$default(CommonBoxUtil.INSTANCE, drawable, null, null, 6, null);
                    }
                    bitmap2 = bitmapDrawableToBitmap$default;
                }
                if (this.mController.getIconResourceCache() != null && bitmap2 != null) {
                    LruCache<Integer, Bitmap> iconResourceCache2 = this.mController.getIconResourceCache();
                    Intrinsics.checkNotNull(iconResourceCache2);
                    iconResourceCache2.put(Integer.valueOf(defaultIconResource), bitmap2);
                }
                bitmap = bitmap2;
            }
            IBrowseController iBrowseController = this.mController;
            String id = item.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            LoaderDrawable loaderDrawableCreate = LoaderDrawable.create(iBrowseController.getThumbnailRequest(id, thumbnailForBoxFile$default), item, targetImage, bitmap, this);
            targetImage.setImageDrawable(loaderDrawableCreate);
            LoaderDrawable.ThumbnailTask task = loaderDrawableCreate.getTask();
            if (task != null) {
                this.mTargetToTask.put(targetImage, task);
                IUserContextComponent userContextComponent = this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
                Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.identity.IExecutorPool");
                ((IExecutorPool) userContextComponent).getThumbnailsExecutor().execute(task);
                return;
            }
            return;
        }
        targetImage.setImageResource(companion.getDefaultIconResource(item));
    }

    public static /* synthetic */ Object loadThumbnailFileModel$default(ThumbnailManager thumbnailManager, FileModel fileModel, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadThumbnailFileModel");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return thumbnailManager.loadThumbnailFileModel(fileModel, z, z2, continuation);
    }

    public final Object loadThumbnailFileModel(FileModel fileModel, boolean z, boolean z2, Continuation<? super Bitmap> continuation) {
        return this.thumbnailService.getThumbnailFileModel(fileModel, z, z2, continuation);
    }

    public static /* synthetic */ Object loadThumbnail$default(ThumbnailManager thumbnailManager, BoxFile boxFile, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadThumbnail");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return thumbnailManager.loadThumbnail(boxFile, z, z2, continuation);
    }

    @Deprecated(message = "Use loadThumbnailFileModel instead")
    public final Object loadThumbnail(BoxFile boxFile, boolean z, boolean z2, Continuation<? super Bitmap> continuation) {
        return this.thumbnailService.getThumbnail(boxFile, z, z2, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.ThumbnailManager$loadThumbnail$3, reason: invalid class name */
    /* JADX INFO: compiled from: ThumbnailManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/compose/ItemThumbnail;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.ThumbnailManager$loadThumbnail$3", f = "ThumbnailManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5}, l = {194, 200, 201, 205, 206, 209}, m = "invokeSuspend", n = {"$this$flow", "boxItem", "$this$flow", "boxItem", "cachedBitmap", "it", "$i$a$-let-ThumbnailManager$loadThumbnail$3$1", "$this$flow", "boxItem", "cachedBitmap", "$this$flow", "boxItem", "cachedBitmap", "$this$flow", "boxItem", "cachedBitmap", "bitmap", "it", "$i$a$-let-ThumbnailManager$loadThumbnail$3$2", "$this$flow", "boxItem"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<FlowCollector<? super ItemThumbnail>, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isLargeThumbnailNeeded;
        final /* synthetic */ ItemModel $itemModel;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ ThumbnailManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ItemModel itemModel, ThumbnailManager thumbnailManager, boolean z, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
            this.this$0 = thumbnailManager;
            this.$isLargeThumbnailNeeded = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$itemModel, this.this$0, this.$isLargeThumbnailNeeded, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ItemThumbnail> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x008f  */
        /* JADX WARN: Code duplicated, block: B:23:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:26:0x00d3 A[PHI: r2 r6
          0x00d3: PHI (r2v15 android.graphics.Bitmap) = (r2v12 android.graphics.Bitmap), (r2v12 android.graphics.Bitmap), (r2v17 android.graphics.Bitmap) binds: [B:24:0x00cf, B:21:0x00ad, B:10:0x003e] A[DONT_GENERATE, DONT_INLINE]
          0x00d3: PHI (r6v4 com.box.androidsdk.content.models.BoxItem) = 
          (r6v2 com.box.androidsdk.content.models.BoxItem)
          (r6v2 com.box.androidsdk.content.models.BoxItem)
          (r6v6 com.box.androidsdk.content.models.BoxItem)
         binds: [B:24:0x00cf, B:21:0x00ad, B:10:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:28:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:31:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:34:0x00fe  */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x012a, code lost:
        
            if (r0.emit(r4, r10) == r1) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x014b, code lost:
        
            if (r0.emit(com.box.android.base.presentation.ThumbnailManager.INSTANCE.getDefaultThumbnail(r10.$itemModel), r10) == r1) goto L39;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 356
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.ThumbnailManager.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ Flow loadThumbnail$default(ThumbnailManager thumbnailManager, ItemModel itemModel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadThumbnail");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return thumbnailManager.loadThumbnail(itemModel, z);
    }

    public Flow<ItemThumbnail> loadThumbnail(ItemModel itemModel, boolean isLargeThumbnailNeeded) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        return FlowKt.flow(new AnonymousClass3(itemModel, this, isLargeThumbnailNeeded, null));
    }

    public final boolean loadThumbnailRepresentation(BoxFile file, ImageView targetImage, ImageLoadListener loadListener) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(targetImage, "targetImage");
        if (targetImage.getTag() == null) {
            targetImage.setTag(new ViewData(TYPE_REPRESENTATION, loadListener));
        }
        BoxIteratorRepresentations representations = file.getRepresentations();
        if (representations == null) {
            return false;
        }
        Iterator<BoxRepresentation> it = representations.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            BoxRepresentation next = it.next();
            String representationType = next.getRepresentationType();
            if (StringsKt.equals(BoxRepresentation.TYPE_PNG, representationType, true) || StringsKt.equals(BoxRepresentation.TYPE_JPG, representationType, true)) {
                BoxRepresentation.BoxRepContent content = next.getContent();
                if (content != null && content.getUrl() != null) {
                    File file2 = new File(this.mController.getThumbnailCacheDir(), getRepCacheName(file, next));
                    LruCache<File, Bitmap> thumbnailCache = this.mController.getThumbnailCache();
                    Intrinsics.checkNotNull(thumbnailCache);
                    Bitmap bitmap = thumbnailCache.get(file2);
                    if (bitmap != null) {
                        loadThumbnail(bitmap, targetImage);
                        return true;
                    }
                    try {
                        file2.createNewFile();
                    } catch (IOException unused) {
                        String simpleName = getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                        BoxLogUtils.e(simpleName, "Could not create rep file:" + file2.getName());
                    }
                    IBrowseController iBrowseController = this.mController;
                    String id = file.getUserId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    Intrinsics.checkNotNull(next);
                    LoaderDrawable loaderDrawableCreate = LoaderDrawable.create(iBrowseController.getRepresentationThumbnailRequest(id, next, file2), file, targetImage, (Bitmap) null, this);
                    targetImage.setImageDrawable(loaderDrawableCreate);
                    LoaderDrawable.ThumbnailTask task = loaderDrawableCreate.getTask();
                    if (task != null) {
                        this.mTargetToTask.put(targetImage, task);
                        IUserContextComponent userContextComponent = this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
                        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.identity.IExecutorPool");
                        ((IExecutorPool) userContextComponent).getThumbnailsExecutor().execute(task);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.box.android.base.presentation.LoaderDrawable.ImageReadyListener
    public void onImageReady(File bitmapSourceFile, BoxRequest<?, ?> request, Bitmap bitmap, ImageView view) {
        Intrinsics.checkNotNullParameter(bitmapSourceFile, "bitmapSourceFile");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(TYPE_REPRESENTATION, ViewData.INSTANCE.getImageType(view))) {
            LruCache<File, Bitmap> thumbnailCache = this.mController.getThumbnailCache();
            Intrinsics.checkNotNull(thumbnailCache);
            thumbnailCache.put(bitmapSourceFile, bitmap);
        } else if (view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
            Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, view.getMeasuredWidth(), view.getMeasuredHeight());
            LruCache<File, Bitmap> thumbnailCache2 = this.mController.getThumbnailCache();
            Intrinsics.checkNotNull(thumbnailCache2);
            Intrinsics.checkNotNull(bitmapExtractThumbnail);
            thumbnailCache2.put(bitmapSourceFile, bitmapExtractThumbnail);
            if (!Intrinsics.areEqual(bitmapExtractThumbnail, bitmap)) {
                bitmap.recycle();
            }
        } else {
            postLaterToView(bitmapSourceFile, request, bitmap, view);
            return;
        }
        LruCache<File, Bitmap> thumbnailCache3 = this.mController.getThumbnailCache();
        Intrinsics.checkNotNull(thumbnailCache3);
        Bitmap bitmap2 = thumbnailCache3.get(bitmapSourceFile);
        if (bitmap2 == null || !isRequestStillApplicable(request, view)) {
            return;
        }
        loadThumbnail(bitmap2, view);
    }

    @Override // com.box.android.base.presentation.LoaderDrawable.ImageReadyListener
    public void onImageException(BoxResponse<?> response, ImageView view) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(view, "view");
        response.getException().printStackTrace();
        ImageLoadListener imageLoadListener = ViewData.INSTANCE.getImageLoadListener(view);
        Intrinsics.checkNotNull(imageLoadListener);
        imageLoadListener.onError();
    }

    private final void postLaterToView(final File bitmapSourceFile, final BoxRequest<?, ?> request, final Bitmap bitmap, final ImageView view) {
        getMHandler().post(new Runnable() { // from class: com.box.android.base.presentation.ThumbnailManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ThumbnailManager.postLaterToView$lambda$0(view, this, bitmapSourceFile, request, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postLaterToView$lambda$0(final ImageView imageView, final ThumbnailManager thumbnailManager, final File file, final BoxRequest boxRequest, final Bitmap bitmap) {
        imageView.post(new Runnable() { // from class: com.box.android.base.presentation.ThumbnailManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ThumbnailManager.postLaterToView$lambda$0$0(this.f$0, file, boxRequest, bitmap, imageView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postLaterToView$lambda$0$0(final ThumbnailManager thumbnailManager, final File file, final BoxRequest boxRequest, final Bitmap bitmap, final ImageView imageView) {
        IUserContextComponent userContextComponent = thumbnailManager.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.identity.IExecutorPool");
        ((IExecutorPool) userContextComponent).getThumbnailsExecutor().execute(new Runnable() { // from class: com.box.android.base.presentation.ThumbnailManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onImageReady(file, boxRequest, bitmap, imageView);
            }
        });
    }

    public final void loadKnownThumbnail(int resourceId, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Glide.with(imageView).load(Integer.valueOf(resourceId)).override(imageView.getMeasuredHeight()).centerCrop().into(imageView);
    }

    public final void loadKnownThumbnail(String fileUrl, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Glide.with(imageView).load(fileUrl).override(imageView.getMeasuredHeight()).centerCrop().into(imageView);
    }

    public final void loadThumbnail(final Bitmap bitmap, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        ViewParent parent = imageView.getParent();
        boolean z = false;
        while (parent != null) {
            parent = parent.getParent();
            if (parent instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) parent;
                boolean z2 = recyclerView.getScrollState() != 0;
                if (z2) {
                    final WeakReference weakReference = new WeakReference(imageView);
                    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.box.android.base.presentation.ThumbnailManager.loadThumbnail.4
                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                            Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                            if (weakReference.get() == null) {
                                recyclerView2.removeOnScrollListener(this);
                                return;
                            }
                            if (newState == 0) {
                                ImageView imageView2 = weakReference.get();
                                if (imageView2 != null && (imageView2.getDrawable() instanceof LoaderDrawable)) {
                                    if (Intrinsics.areEqual(ThumbnailManager.TYPE_REPRESENTATION, ViewData.INSTANCE.getImageType(imageView2))) {
                                        ThumbnailManager thumbnailManager = this;
                                        Drawable drawable = imageView2.getDrawable();
                                        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.box.android.base.presentation.LoaderDrawable");
                                        BoxItem boxItem = ((LoaderDrawable) drawable).getTask().getBoxItem();
                                        Intrinsics.checkNotNull(boxItem, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
                                        thumbnailManager.loadThumbnailRepresentation((BoxFile) boxItem, imageView2, null);
                                    } else {
                                        ThumbnailManager thumbnailManager2 = this;
                                        Drawable drawable2 = imageView2.getDrawable();
                                        Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type com.box.android.base.presentation.LoaderDrawable");
                                        BoxItem boxItem2 = ((LoaderDrawable) drawable2).getTask().getBoxItem();
                                        Intrinsics.checkNotNullExpressionValue(boxItem2, "getBoxItem(...)");
                                        thumbnailManager2.loadThumbnail(boxItem2, imageView2);
                                    }
                                }
                                recyclerView2.removeOnScrollListener(this);
                            }
                        }
                    });
                }
                z = z2;
            }
        }
        if (z) {
            return;
        }
        getMHandler().post(new Runnable() { // from class: com.box.android.base.presentation.ThumbnailManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ThumbnailManager.loadThumbnail$lambda$1(imageView, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadThumbnail$lambda$1(ImageView imageView, Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
        ImageLoadListener imageLoadListener = ViewData.INSTANCE.getImageLoadListener(imageView);
        Intrinsics.checkNotNull(imageLoadListener);
        imageLoadListener.onSuccess();
    }

    private final boolean isRequestStillApplicable(BoxRequest<?, ?> request, ImageView view) {
        if (!(view.getDrawable() instanceof LoaderDrawable)) {
            return false;
        }
        Drawable drawable = view.getDrawable();
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.box.android.base.presentation.LoaderDrawable");
        return ((LoaderDrawable) drawable).matchesRequest(request);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    public final boolean canReuseThumbnailFromOldItem(ItemModel oldItem, ItemModel newItem) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!Intrinsics.areEqual(oldItem.getItemId(), newItem.getItemId())) {
            return false;
        }
        FileModel fileModel = ItemModelKt.fileModel(oldItem);
        FolderModel folderModel = oldItem instanceof FolderModel ? (FolderModel) oldItem : null;
        if (fileModel != null) {
            String sha1 = fileModel.getSha1();
            FileModel fileModel2 = ItemModelKt.fileModel(newItem);
            if (Intrinsics.areEqual(sha1, fileModel2 != null ? fileModel2.getSha1() : null)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (folderModel == null) {
            z2 = false;
        } else {
            FolderModel folderModel2 = newItem instanceof FolderModel ? (FolderModel) newItem : null;
            if (folderModel2 == null || folderModel.getHasCollaborations() != folderModel2.getHasCollaborations()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (folderModel == null) {
            z3 = false;
        } else {
            FolderModel folderModel3 = newItem instanceof FolderModel ? (FolderModel) newItem : null;
            if (folderModel3 == null || folderModel.isExternallyOwned() != folderModel3.isExternallyOwned()) {
                z3 = false;
            } else {
                z3 = true;
            }
        }
        return z || (z2 && z3);
    }

    /* JADX INFO: compiled from: ThumbnailManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/android/base/presentation/ThumbnailManager$ViewData;", "", "mImageType", "", "mListener", "Lcom/box/android/base/presentation/ThumbnailManager$ImageLoadListener;", "<init>", "(Ljava/lang/String;Lcom/box/android/base/presentation/ThumbnailManager$ImageLoadListener;)V", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class ViewData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ImageLoadListener NULL_LISTENER = new ImageLoadListener() { // from class: com.box.android.base.presentation.ThumbnailManager$ViewData$Companion$NULL_LISTENER$1
            @Override // com.box.android.base.presentation.ThumbnailManager.ImageLoadListener
            public void onError() {
            }

            @Override // com.box.android.base.presentation.ThumbnailManager.ImageLoadListener
            public void onSuccess() {
            }
        };
        private final String mImageType;
        private final ImageLoadListener mListener;

        /* JADX INFO: compiled from: ThumbnailManager.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/presentation/ThumbnailManager$ViewData$Companion;", "", "<init>", "()V", "NULL_LISTENER", "Lcom/box/android/base/presentation/ThumbnailManager$ImageLoadListener;", "getImageLoadListener", "view", "Landroid/widget/ImageView;", "getImageType", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ImageLoadListener getImageLoadListener(ImageView view) {
                if (view != null) {
                    Object tag = view.getTag();
                    ViewData viewData = tag instanceof ViewData ? (ViewData) tag : null;
                    if ((viewData != null ? viewData.mListener : null) != null) {
                        return viewData.mListener;
                    }
                }
                return ViewData.NULL_LISTENER;
            }

            public final String getImageType(ImageView view) {
                if (view == null) {
                    return null;
                }
                Object tag = view.getTag();
                ViewData viewData = tag instanceof ViewData ? (ViewData) tag : null;
                if (viewData != null) {
                    return viewData.mImageType;
                }
                return null;
            }
        }

        public ViewData(String mImageType, ImageLoadListener imageLoadListener) {
            Intrinsics.checkNotNullParameter(mImageType, "mImageType");
            this.mImageType = mImageType;
            this.mListener = imageLoadListener;
        }
    }

    /* JADX INFO: compiled from: ThumbnailManager.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\tH\u0007J$\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/presentation/ThumbnailManager$Companion;", "", "<init>", "()V", "TYPE_REPRESENTATION", "", "getDefaultThumbnail", "Lcom/box/android/base/compose/ItemThumbnail$Icon;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getDefaultIconResource", "", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "item", "isThumbnailAvailable", "", "name", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "isFile", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ItemThumbnail.Icon getDefaultThumbnail(ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            if (itemModel instanceof FolderModel) {
                FolderModel folderModel = (FolderModel) itemModel;
                FolderTypeIcon folderTypeIconFindFolderIcon = SupportedFileExtensionIcons.INSTANCE.findFolderIcon(folderModel.getHasCollaborations(), folderModel.isExternallyOwned());
                return new ItemThumbnail.Icon(folderTypeIconFindFolderIcon.getDrawable(), Integer.valueOf(folderTypeIconFindFolderIcon.getContentDescription()));
            }
            FileTypeIcon fileTypeIconFindFileIcon = SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(itemModel.getName(), ""));
            return new ItemThumbnail.Icon(fileTypeIconFindFileIcon.getDrawable(), Integer.valueOf(fileTypeIconFindFileIcon.getContentDescription()));
        }

        @JvmStatic
        public final int getDefaultIconResource(BoxItem boxItem) {
            Intrinsics.checkNotNullParameter(boxItem, "boxItem");
            ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxItem);
            if (itemModel != null) {
                return ThumbnailManager.INSTANCE.getDefaultIconResource(itemModel);
            }
            return SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(boxItem.getName(), "")).getDrawable();
        }

        @JvmStatic
        public final int getDefaultIconResource(ItemModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof FolderModel) {
                FolderModel folderModel = (FolderModel) item;
                if (folderModel.getHasCollaborations()) {
                    if (folderModel.isExternallyOwned()) {
                        return R.drawable.ic_folder_external;
                    }
                    return R.drawable.ic_folder_shared;
                }
                return R.drawable.ic_folder_personal;
            }
            if (item instanceof WebLinkModel) {
                return R.drawable.ic_box_browsesdk_web_link;
            }
            return SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(item.getName(), "")).getDrawable();
        }

        @JvmStatic
        public final boolean isThumbnailAvailable(BoxItem item) {
            if (item == null) {
                return false;
            }
            Companion companion = ThumbnailManager.INSTANCE;
            String name = item.getName();
            EnumSet<BoxItem.Permission> permissions = item.getPermissions();
            return companion.isThumbnailAvailable(name, permissions != null ? PermissionsModelMapper.INSTANCE.toPermissionsModel(permissions) : null, item instanceof BoxFile);
        }

        @JvmStatic
        public final boolean isThumbnailAvailable(ItemModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return isThumbnailAvailable(item.getName(), item.getPermissions(), (item instanceof FileModel) || (item instanceof RecentFileModel));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean isThumbnailAvailable(String name, PermissionsModel permissions, boolean isFile) {
            String str = name;
            if (str != null && !StringsKt.isBlank(str)) {
                String fileExtension = CommonBoxUtil.getFileExtension(name, "");
                boolean z = SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(fileExtension);
                if (isFile && ((permissions == null || permissions.getCanPreview()) && (z || SupportedFileExtensions.INSTANCE.isVideoExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isGifExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isInDesignExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isDocuWorksExtension(fileExtension)))) {
                    return true;
                }
            }
            return false;
        }
    }
}

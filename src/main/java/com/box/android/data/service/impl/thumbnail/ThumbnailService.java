package com.box.android.data.service.impl.thumbnail;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IThumbnailService;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ThumbnailService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0097@¢\u0006\u0002\u0010\u0017J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/box/android/data/service/impl/thumbnail/ThumbnailService;", "Lcom/box/android/domain/services/IThumbnailService;", "controller", "Lcom/box/android/domain/controller/IBrowseController;", "getThumbnailRepresentationsService", "Lcom/box/android/data/service/impl/thumbnail/GetThumbnailRepresentationsService;", "fileToBitmapDecoder", "Lcom/box/android/data/service/impl/thumbnail/FileToBitmapDecoder;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/controller/IBrowseController;Lcom/box/android/data/service/impl/thumbnail/GetThumbnailRepresentationsService;Lcom/box/android/data/service/impl/thumbnail/FileToBitmapDecoder;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getThumbnailFileModel", "Landroid/graphics/Bitmap;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "isLargeThumbnailNeeded", "", "loadFromCacheOnly", "(Lcom/box/android/domain/models/item/FileModel;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnail", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "(Lcom/box/androidsdk/content/models/BoxFile;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadThumbnail", "", "destinationUrl", "Ljava/net/URL;", "(Lcom/box/android/domain/models/item/FileModel;ZLjava/net/URL;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBestThumbnail", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnailFile", "Ljava/io/File;", "isLargeThumbnail", "isRepresentationThumbnailAvailable", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThumbnailService implements IThumbnailService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LARGE_THUMBNAIL_PREFIX = "large_";
    public static final String THUMBNAIL_FILE_EXTENSION = ".thumbnail";
    private final IBrowseController controller;
    private final CoroutineDispatcher coroutineDispatcher;
    private final FileToBitmapDecoder fileToBitmapDecoder;
    private final GetThumbnailRepresentationsService getThumbnailRepresentationsService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.thumbnail.ThumbnailService$getBestThumbnail$1, reason: invalid class name */
    /* JADX INFO: compiled from: ThumbnailService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.thumbnail.ThumbnailService", f = "ThumbnailService.kt", i = {0, 0, 0, 0}, l = {91}, m = "getBestThumbnail", n = {"fileModel", "$i$a$-firstNotNullOfOrNull-ThumbnailService$getBestThumbnail$2", "isLargeThumbnail", "loadFromCacheOnly"}, s = {"L$0", "I$0", "Z$0", "Z$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThumbnailService.this.getBestThumbnail(null, this);
        }
    }

    @Inject
    public ThumbnailService(IBrowseController controller, GetThumbnailRepresentationsService getThumbnailRepresentationsService, FileToBitmapDecoder fileToBitmapDecoder, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(getThumbnailRepresentationsService, "getThumbnailRepresentationsService");
        Intrinsics.checkNotNullParameter(fileToBitmapDecoder, "fileToBitmapDecoder");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.controller = controller;
        this.getThumbnailRepresentationsService = getThumbnailRepresentationsService;
        this.fileToBitmapDecoder = fileToBitmapDecoder;
        this.coroutineDispatcher = coroutineDispatcher;
        if (controller.getThumbnailCacheDir().exists()) {
            return;
        }
        controller.getThumbnailCacheDir().mkdirs();
    }

    @Override // com.box.android.domain.services.IThumbnailService
    public Object getThumbnailFileModel(FileModel fileModel, boolean z, boolean z2, Continuation<? super Bitmap> continuation) {
        return getThumbnail(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, fileModel, false, 1, null), z, z2, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.thumbnail.ThumbnailService$getThumbnail$2, reason: invalid class name */
    /* JADX INFO: compiled from: ThumbnailService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.thumbnail.ThumbnailService$getThumbnail$2", f = "ThumbnailService.kt", i = {0, 0, 0, 0}, l = {57}, m = "invokeSuspend", n = {"$this$withContext", "thumbnailFile", "cachedBitmap", "isCached"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ BoxFile $boxFile;
        final /* synthetic */ boolean $isLargeThumbnailNeeded;
        final /* synthetic */ boolean $loadFromCacheOnly;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BoxFile boxFile, boolean z, boolean z2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$boxFile = boxFile;
            this.$isLargeThumbnailNeeded = z;
            this.$loadFromCacheOnly = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ThumbnailService.this.new AnonymousClass2(this.$boxFile, this.$isLargeThumbnailNeeded, this.$loadFromCacheOnly, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d9  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws MalformedURLException {
            File thumbnailFile;
            File file;
            Bitmap bitmap;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!ThumbnailService.this.isRepresentationThumbnailAvailable(this.$boxFile) || (thumbnailFile = ThumbnailService.this.getThumbnailFile(this.$boxFile, this.$isLargeThumbnailNeeded)) == null) {
                    return null;
                }
                LruCache<File, Bitmap> thumbnailCache = ThumbnailService.this.controller.getThumbnailCache();
                Intrinsics.checkNotNull(thumbnailCache);
                Bitmap bitmap2 = thumbnailCache.get(thumbnailFile);
                if (ThumbnailService.this.controller.getThumbnailCache() != null && bitmap2 != null) {
                    return bitmap2;
                }
                int i2 = (!thumbnailFile.exists() || thumbnailFile.length() <= 0) ? 0 : 1;
                if (i2 == 0) {
                    if (this.$loadFromCacheOnly) {
                        return null;
                    }
                    ThumbnailService thumbnailService = ThumbnailService.this;
                    FileModel fileModel$default = FileModelMapper.toFileModel$default(FileModelMapper.INSTANCE, this.$boxFile, false, 1, null);
                    boolean z = this.$isLargeThumbnailNeeded;
                    URL url = thumbnailFile.toURI().toURL();
                    Intrinsics.checkNotNullExpressionValue(url, "toURL(...)");
                    this.L$0 = coroutineScope;
                    this.L$1 = thumbnailFile;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(bitmap2);
                    this.I$0 = i2;
                    this.label = 1;
                    if (thumbnailService.downloadThumbnail(fileModel$default, z, url, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    file = thumbnailFile;
                }
                FileToBitmapDecoder fileToBitmapDecoder = ThumbnailService.this.fileToBitmapDecoder;
                String absolutePath = thumbnailFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                bitmap = fileToBitmapDecoder.toBitmap(absolutePath);
                if (bitmap != null) {
                    LruCache<File, Bitmap> thumbnailCache2 = ThumbnailService.this.controller.getThumbnailCache();
                    Intrinsics.checkNotNull(thumbnailCache2);
                    thumbnailCache2.put(thumbnailFile, bitmap);
                    return bitmap;
                }
                thumbnailFile.delete();
                return null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$1;
            ResultKt.throwOnFailure(obj);
            thumbnailFile = file;
            FileToBitmapDecoder fileToBitmapDecoder2 = ThumbnailService.this.fileToBitmapDecoder;
            String absolutePath2 = thumbnailFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            bitmap = fileToBitmapDecoder2.toBitmap(absolutePath2);
            if (bitmap != null) {
                LruCache<File, Bitmap> thumbnailCache3 = ThumbnailService.this.controller.getThumbnailCache();
                Intrinsics.checkNotNull(thumbnailCache3);
                thumbnailCache3.put(thumbnailFile, bitmap);
                return bitmap;
            }
            thumbnailFile.delete();
            return null;
        }
    }

    @Override // com.box.android.domain.services.IThumbnailService
    @Deprecated(message = "Use getThumbnailFileModel instead")
    public Object getThumbnail(BoxFile boxFile, boolean z, boolean z2, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new AnonymousClass2(boxFile, z, z2, null), continuation);
    }

    public final Object downloadThumbnail(FileModel fileModel, boolean z, URL url, Continuation<? super Unit> continuation) {
        Object objDownloadThumbnail = this.getThumbnailRepresentationsService.downloadThumbnail(fileModel, z, url, continuation);
        return objDownloadThumbnail == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDownloadThumbnail : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0086  */
    /* JADX WARN: Code duplicated, block: B:19:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00b3 -> B:21:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.services.IThumbnailService
    public java.lang.Object getBestThumbnail(com.box.android.domain.models.item.FileModel r8, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.box.android.data.service.impl.thumbnail.ThumbnailService.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.data.service.impl.thumbnail.ThumbnailService$getBestThumbnail$1 r0 = (com.box.android.data.service.impl.thumbnail.ThumbnailService.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.data.service.impl.thumbnail.ThumbnailService$getBestThumbnail$1 r0 = new com.box.android.data.service.impl.thumbnail.ThumbnailService$getBestThumbnail$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            boolean r8 = r0.Z$1
            boolean r8 = r0.Z$0
            int r8 = r0.I$0
            java.lang.Object r8 = r0.L$1
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r2 = r0.L$0
            com.box.android.domain.models.item.FileModel r2 = (com.box.android.domain.models.item.FileModel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb6
        L3a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L42:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 3
            kotlin.Pair[] r9 = new kotlin.Pair[r9]
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r9[r3] = r2
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r9[r4] = r2
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r5 = 2
            r9[r5] = r2
            java.util.List r9 = kotlin.collections.CollectionsKt.listOf(r9)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r6 = r9
            r9 = r8
            r8 = r6
        L80:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lbd
            java.lang.Object r2 = r8.next()
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r5 = r2.component1()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            java.lang.Object r2 = r2.component2()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r0.L$0 = r9
            r0.L$1 = r8
            r0.I$0 = r3
            r0.Z$0 = r5
            r0.Z$1 = r2
            r0.label = r4
            java.lang.Object r2 = r7.getThumbnailFileModel(r9, r5, r2, r0)
            if (r2 != r1) goto Lb3
            return r1
        Lb3:
            r6 = r2
            r2 = r9
            r9 = r6
        Lb6:
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            if (r9 == 0) goto Lbb
            return r9
        Lbb:
            r9 = r2
            goto L80
        Lbd:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.thumbnail.ThumbnailService.getBestThumbnail(com.box.android.domain.models.item.FileModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.domain.services.IThumbnailService
    public File getThumbnailFile(BoxFile boxFile, boolean isLargeThumbnail) {
        File file;
        File parentFile;
        File parentFile2;
        File parentFile3;
        File parentFile4;
        File parentFile5;
        File parentFile6;
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        File file2 = null;
        try {
            File thumbnailCacheDir = this.controller.getThumbnailCacheDir();
            Companion companion = INSTANCE;
            file = new File(thumbnailCacheDir, companion.thumbnailFilePrefix(isLargeThumbnail) + companion.getCacheName(boxFile));
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                e = e;
                this.controller.log("getThumbnailForBoxFile ", "file.getAbsolutePath()  " + (file != null ? file.getAbsolutePath() : null) + " isFile " + (file != null ? Boolean.valueOf(file.isFile()) : null), null);
                this.controller.log("getThumbnailForBoxFile ", "file.getParentFile().exists() " + ((file == null || (parentFile6 = file.getParentFile()) == null) ? null : Boolean.valueOf(parentFile6.exists())) + " isDirectory " + ((file == null || (parentFile5 = file.getParentFile()) == null) ? null : Boolean.valueOf(parentFile5.isDirectory())), null);
                this.controller.log("getThumbnailForBoxFile ", "file.getParentFile().getParentFile.exists() " + ((file == null || (parentFile3 = file.getParentFile()) == null || (parentFile4 = parentFile3.getParentFile()) == null) ? null : Boolean.valueOf(parentFile4.exists())) + " isDirectory " + ((file == null || (parentFile = file.getParentFile()) == null || (parentFile2 = parentFile.getParentFile()) == null) ? null : Boolean.valueOf(parentFile2.isDirectory())), null);
                this.controller.log("getThumbnailForBoxFile", " IOException ", e);
                return file;
            } catch (IllegalArgumentException e2) {
                e = e2;
                file2 = file;
                BoxLogUtils.e("getThumbnailForBoxFile", e);
                return file2;
            }
        } catch (IOException e3) {
            e = e3;
            file = null;
        } catch (IllegalArgumentException e4) {
            e = e4;
        }
    }

    @Override // com.box.android.domain.services.IThumbnailService
    public boolean isRepresentationThumbnailAvailable(BoxItem item) {
        EnumSet<BoxItem.Permission> permissions;
        Intrinsics.checkNotNullParameter(item, "item");
        String name = item.getName();
        if (name == null || StringsKt.isBlank(name) || (permissions = item.getPermissions()) == null || !permissions.contains(BoxItem.Permission.CAN_PREVIEW)) {
            return false;
        }
        String lowerCase = CommonBoxUtil.getFileExtension(item.getName(), "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return IThumbnailService.INSTANCE.getREP_SUPPORTED_THUMBNAIL_EXTENSIONS().contains(lowerCase);
    }

    /* JADX INFO: compiled from: ThumbnailService.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/data/service/impl/thumbnail/ThumbnailService$Companion;", "", "<init>", "()V", "THUMBNAIL_FILE_EXTENSION", "", "LARGE_THUMBNAIL_PREFIX", "getCacheName", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "thumbnailFilePrefix", "isLargeThumbnail", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getCacheName(BoxFile boxFile) {
            if (boxFile == null || SdkUtils.isBlank(boxFile.getUserId()) || SdkUtils.isBlank(boxFile.getSha1())) {
                throw new IllegalArgumentException("BoxFile argument must not be null and must also contain an id and sha1".toString());
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ENGLISH, "%s_%s%s", Arrays.copyOf(new Object[]{boxFile.getUserId(), boxFile.getSha1(), ThumbnailService.THUMBNAIL_FILE_EXTENSION}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String thumbnailFilePrefix(boolean isLargeThumbnail) {
            return isLargeThumbnail ? ThumbnailService.LARGE_THUMBNAIL_PREFIX : "";
        }
    }
}

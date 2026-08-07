package com.box.android.domain.services;

import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import com.eclipsesource.json.JsonObject;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ICaptureThumbnailService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ICaptureThumbnailService;", "", "saveThumbnail", "", "url", "", "sha1", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnail", "Ljava/io/File;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICaptureThumbnailService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    File getThumbnail(String sha1);

    Object saveThumbnail(String str, String str2, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: ICaptureThumbnailService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/box/android/domain/services/ICaptureThumbnailService$Companion;", "", "<init>", "()V", "CAPTURE_THUMBNAIL_ID", "", "getBoxFileForCaptureThumbnail", "Lcom/box/androidsdk/content/models/BoxFile;", "sha1", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String CAPTURE_THUMBNAIL_ID = "CAPTURE_THUMBNAIL";

        private Companion() {
        }

        public final BoxFile getBoxFileForCaptureThumbnail(String sha1) {
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            JsonObject jsonObject = BoxFile.createFromId(CAPTURE_THUMBNAIL_ID).toJsonObject();
            jsonObject.add("sha1", sha1);
            BoxEntity boxEntityCreateEntityFromJson = BoxFile.createEntityFromJson(jsonObject);
            Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
            return (BoxFile) boxEntityCreateEntityFromJson;
        }
    }
}

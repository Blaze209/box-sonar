package com.box.android.domain.services;

import com.amplitude.api.Constants;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationStatus;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.FileVersionRepresentationsModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IRepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 $2\u00020\u0001:\u0001$J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0012J2\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH¦@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001eJ\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0015\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010#¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IRepresentationsService;", "", "fetchFileRepresentations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/RepresentationModel;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "hintsHeader", "", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFileRepresentationsForVersion", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/preview/FileVersionRepresentationsModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "Lcom/box/android/domain/models/ItemId;", Constants.AMP_PLAN_VERSION_ID, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadPreviewRepresentation", "Ljava/net/URL;", BoxRepresentation.FIELD_REPRESENTATION, "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/models/RepresentationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRepresentationToLegacyCache", "", "representationType", "Lcom/box/android/domain/preview/PreviewContentType$Representation;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/preview/PreviewContentType$Representation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadThumbnailRepresentation", "destinationURL", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/RepresentationModel;Ljava/net/URL;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeSureRepresentationIsReady", "(Lcom/box/android/domain/models/RepresentationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasCachedRepresentationPreview", "", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/RepresentationModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRepresentationsService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String DASH_MANIFEST_ASSET_PATH = "manifest.mpd";
    public static final String URL_TEMPLATE_ASSET_PATH = "{+asset_path}";

    Object downloadPreviewRepresentation(ItemId itemId, String str, RepresentationModel representationModel, Continuation<? super Result<URL, ? extends DomainError>> continuation);

    Object downloadRepresentationToLegacyCache(FileModel fileModel, PreviewContentType.Representation representation, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object downloadThumbnailRepresentation(FileModel fileModel, RepresentationModel representationModel, URL url, Continuation<? super Result<URL, ? extends DomainError>> continuation);

    Object fetchFileRepresentations(FileModel fileModel, String str, Continuation<? super Flow<? extends List<RepresentationModel>>> continuation);

    Object fetchFileRepresentationsForVersion(ItemId itemId, String str, Continuation<? super Result<FileVersionRepresentationsModel, ? extends DomainError>> continuation);

    Object hasCachedRepresentationPreview(FileModel fileModel, RepresentationModel representationModel, Continuation<? super Boolean> continuation);

    Object makeSureRepresentationIsReady(RepresentationModel representationModel, Continuation<? super Result<RepresentationModel, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: IRepresentationsService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/services/IRepresentationsService$Companion;", "", "<init>", "()V", "URL_TEMPLATE_ASSET_PATH", "", "DASH_MANIFEST_ASSET_PATH", "PASSWORD_PROTECTED_ERROR", "Lcom/box/android/domain/models/RepresentationStatus;", "getPASSWORD_PROTECTED_ERROR", "()Lcom/box/android/domain/models/RepresentationStatus;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public static final String DASH_MANIFEST_ASSET_PATH = "manifest.mpd";
        public static final String URL_TEMPLATE_ASSET_PATH = "{+asset_path}";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final RepresentationStatus PASSWORD_PROTECTED_ERROR = new RepresentationStatus(RepresentationStatus.State.ERROR, "error_password_protected");

        private Companion() {
        }

        public final RepresentationStatus getPASSWORD_PROTECTED_ERROR() {
            return PASSWORD_PROTECTED_ERROR;
        }
    }
}

package com.box.android.domain.models.boxai;

import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.SupportedFileExtensionsKt;
import com.box.androidsdk.content.models.BoxFile;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: AiFileType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/boxai/AiFileType;", "", LogFactory.PRIORITY_KEY, "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "DOCUMENT", "IMAGE", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum AiFileType {
    DOCUMENT(1),
    IMAGE(0);

    private final int priority;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> AI_SUPPORTED_DOCUMENT_EXTENSIONS = SetsKt.plus((Set<? extends String>) SetsKt.plus((Set<? extends String>) SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set) SupportedFileExtensions.INSTANCE.getDOCUMENT_EXTENSIONS(), (Iterable) SupportedFileExtensions.INSTANCE.getCODE_EXTENSIONS()), (Iterable) SupportedFileExtensions.INSTANCE.getPRESENTATION_EXTENSIONS()), (Iterable) SupportedFileExtensions.INSTANCE.getSPREADSHEET_EXTENSIONS()), (Iterable) SupportedFileExtensions.INSTANCE.getMICROSOFT_EXCEL_EXTENSIONS()), (Iterable) SupportedFileExtensions.INSTANCE.getMICROSOFT_POWERPOINT_EXTENSIONS()), (Iterable) SupportedFileExtensions.INSTANCE.getMICROSOFT_WORD_EXTENSIONS()), SupportedFileExtensions.DWG_EXTENSION), "boxnote");
    private static final Set<String> AI_SUPPORTED_IMAGE_EXTENSIONS = SetsKt.plus((Set<? extends String>) SetsKt.plus((Set<? extends String>) SetsKt.plus(SetsKt.plus(SupportedFileExtensions.INSTANCE.getIMAGE_EXTENSIONS(), SupportedFileExtensions.GIF_EXTENSION), (Iterable) SupportedFileExtensions.INSTANCE.getVECTOR_EXTENSIONS()), SupportedFileExtensions.PSD_EXTENSION), SupportedFileExtensions.AI_EXTENSION);

    public static EnumEntries<AiFileType> getEntries() {
        return $ENTRIES;
    }

    AiFileType(int i) {
        this.priority = i;
    }

    public final int getPriority() {
        return this.priority;
    }

    /* JADX INFO: compiled from: AiFileType.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/models/boxai/AiFileType$Companion;", "", "<init>", "()V", "AI_SUPPORTED_DOCUMENT_EXTENSIONS", "", "", "AI_SUPPORTED_IMAGE_EXTENSIONS", "fromExtensionOrNull", "Lcom/box/android/domain/models/boxai/AiFileType;", BoxFile.FIELD_EXTENSION, "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AiFileType fromExtensionOrNull(String extension) {
            Intrinsics.checkNotNullParameter(extension, "extension");
            if (SupportedFileExtensionsKt.isExtensionInSet(extension, AiFileType.AI_SUPPORTED_DOCUMENT_EXTENSIONS)) {
                return AiFileType.DOCUMENT;
            }
            if (SupportedFileExtensionsKt.isExtensionInSet(extension, AiFileType.AI_SUPPORTED_IMAGE_EXTENSIONS)) {
                return AiFileType.IMAGE;
            }
            return null;
        }
    }
}

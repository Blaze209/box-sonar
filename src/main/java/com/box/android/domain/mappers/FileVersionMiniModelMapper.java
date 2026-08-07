package com.box.android.domain.mappers;

import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.androidsdk.content.models.BoxFileVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionMiniModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000b\u001a\u00020\f*\u00020\rJ\n\u0010\u000e\u001a\u00020\u0005*\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/mappers/FileVersionMiniModelMapper;", "", "<init>", "()V", "QUOTES", "", "ID_FIELD", "TYPE_FIELD", "COMMA", "SHA1_FIELD", "SEMI_COLON", "toFileVersionMiniModel", "Lcom/box/android/domain/models/item/FileVersionMiniModel;", "Lcom/box/androidsdk/content/models/BoxFileVersion;", "toJsonString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileVersionMiniModelMapper {
    private static final String COMMA = ",";
    private static final String ID_FIELD = "id";
    public static final FileVersionMiniModelMapper INSTANCE = new FileVersionMiniModelMapper();
    private static final String QUOTES = "\"";
    private static final String SEMI_COLON = ":";
    private static final String SHA1_FIELD = "sha1";
    private static final String TYPE_FIELD = "type";

    private FileVersionMiniModelMapper() {
    }

    public final FileVersionMiniModel toFileVersionMiniModel(BoxFileVersion boxFileVersion) {
        Intrinsics.checkNotNullParameter(boxFileVersion, "<this>");
        String id = boxFileVersion.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String sha1 = boxFileVersion.getSha1();
        Intrinsics.checkNotNullExpressionValue(sha1, "getSha1(...)");
        return new FileVersionMiniModel(id, sha1);
    }

    public final String toJsonString(FileVersionMiniModel fileVersionMiniModel) {
        Intrinsics.checkNotNullParameter(fileVersionMiniModel, "<this>");
        StringBuilder sb = new StringBuilder("{\"id\":\"");
        sb.append(fileVersionMiniModel.getId()).append("\",\"type\":\"file_version\",\"sha1\":\"");
        sb.append(fileVersionMiniModel.getSha1()).append("\"}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "with(...)");
        return string;
    }
}

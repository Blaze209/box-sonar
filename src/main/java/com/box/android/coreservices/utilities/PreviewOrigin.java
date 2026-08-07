package com.box.android.coreservices.utilities;

import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationPropertiesModel;
import com.box.android.domain.models.RepresentationStatus;
import com.box.android.domain.models.RepresentationType;
import com.box.android.domain.preview.PreviewContentType;
import com.box.androidsdk.content.models.BoxFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PreviewStorageExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/box/android/coreservices/utilities/PreviewOrigin;", "", "<init>", "()V", "original", "Lcom/box/android/domain/preview/PreviewContentType$Original;", "representationWithExtension", "Lcom/box/android/domain/preview/PreviewContentType$Representation;", BoxFile.FIELD_EXTENSION, "", "previewWidth", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/box/android/domain/preview/PreviewContentType$Representation;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewOrigin {
    public static final PreviewOrigin INSTANCE = new PreviewOrigin();

    private PreviewOrigin() {
    }

    public final PreviewContentType.Original original() {
        return PreviewContentType.Original.INSTANCE;
    }

    public static /* synthetic */ PreviewContentType.Representation representationWithExtension$default(PreviewOrigin previewOrigin, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return previewOrigin.representationWithExtension(str, num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PreviewContentType.Representation representationWithExtension(String extension, Integer previewWidth) {
        String str;
        Intrinsics.checkNotNullParameter(extension, "extension");
        int i = 2;
        String str2 = null;
        Object[] objArr = 0;
        if (StringsKt.startsWith$default(extension, ".", false, 2, (Object) null)) {
            extension = extension.substring(1);
            Intrinsics.checkNotNullExpressionValue(extension, "substring(...)");
        }
        if (previewWidth != null) {
            int iIntValue = previewWidth.intValue();
            str = iIntValue + "x" + iIntValue;
        } else {
            str = null;
        }
        return new PreviewContentType.Representation(new RepresentationModel("", "", new RepresentationPropertiesModel(str, false, false), RepresentationType.INSTANCE.fromString(extension), new RepresentationStatus(RepresentationStatus.State.PENDING, str2, i, objArr == true ? 1 : 0)));
    }
}

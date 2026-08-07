package com.box.android.preview.annotations.cpl;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.fileactivity.model.UserUIModel;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"createState", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State$Companion;", "file", "Lcom/box/android/domain/models/item/FileModel;", "userInfo", "Lcom/box/androidsdk/content/models/BoxUser;", "additionalMarkups", "", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "annotationLocationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationReducerKt {
    public static final CreateAnnotationReducer.State createState(CreateAnnotationReducer.State.Companion companion, FileModel file, BoxUser userInfo, List<? extends BoxAnnotationMarkupType> additionalMarkups, AnnotationLocationModel annotationLocationModel) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(additionalMarkups, "additionalMarkups");
        Intrinsics.checkNotNullParameter(annotationLocationModel, "annotationLocationModel");
        FileVersionMiniModel fileVersion = file.getFileVersion();
        String id = fileVersion != null ? fileVersion.getId() : null;
        if (id != null) {
            ItemId itemId = file.getItemId();
            String id2 = userInfo.getUserId();
            Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
            return new CreateAnnotationReducer.State(itemId, id, additionalMarkups, null, new UserUIModel(id2, userInfo.getUserName(), null, null), null, null, null, null, null, false, null, false, false, null, annotationLocationModel, 32744, null);
        }
        BoxLogUtils.e(ExtensionsKt.getTAG(companion), "Cannot enter annotation creation mode. VersionId is null");
        return null;
    }
}

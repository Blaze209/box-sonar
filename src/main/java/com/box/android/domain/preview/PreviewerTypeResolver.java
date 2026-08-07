package com.box.android.domain.preview;

import com.box.android.domain.models.RepresentationModel;
import com.box.androidsdk.content.models.BoxFile;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PreviewerTypeResolver.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/preview/PreviewerTypeResolver;", "", "preferredPreviewers", "", "Lcom/box/android/domain/preview/PreviewerMapping;", BoxFile.FIELD_EXTENSION, "", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/domain/models/RepresentationModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PreviewerTypeResolver {
    List<PreviewerMapping> preferredPreviewers(String extension, List<RepresentationModel> representations);
}

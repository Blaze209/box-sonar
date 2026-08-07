package com.box.android.data.service.impl;

import com.box.android.data.api.models.MetadataTemplateDTO;
import com.box.android.data.api.models.MetadataTemplateFieldDTO;
import com.box.android.domain.models.metadata.MetadataTemplateFieldModel;
import com.box.android.domain.models.metadata.MetadataTemplateModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: FileMetadataService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toTemplateModel", "Lcom/box/android/domain/models/metadata/MetadataTemplateModel;", "Lcom/box/android/data/api/models/MetadataTemplateDTO;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataServiceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MetadataTemplateModel toTemplateModel(MetadataTemplateDTO metadataTemplateDTO) {
        String scope = metadataTemplateDTO.getScope();
        String templateKey = metadataTemplateDTO.getTemplateKey();
        String displayName = metadataTemplateDTO.getDisplayName();
        boolean hidden = metadataTemplateDTO.getHidden();
        List<MetadataTemplateFieldDTO> fields = metadataTemplateDTO.getFields();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields, 10));
        for (MetadataTemplateFieldDTO metadataTemplateFieldDTO : fields) {
            arrayList.add(new MetadataTemplateFieldModel(metadataTemplateFieldDTO.getKey(), metadataTemplateFieldDTO.getDisplayName(), metadataTemplateFieldDTO.getType()));
        }
        return new MetadataTemplateModel(scope, templateKey, displayName, hidden, arrayList);
    }
}

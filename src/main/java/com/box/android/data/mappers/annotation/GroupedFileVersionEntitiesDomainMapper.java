package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.data.persistence.annotations.GroupedFileVersionEntities;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupedFileVersionEntitiesDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/mappers/annotation/GroupedFileVersionEntitiesDomainMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/annotations/FileActivityModel$GroupedFileVersionModel;", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GroupedFileVersionEntitiesDomainMapper implements DomainMapper<FileActivityModel.GroupedFileVersionModel, GroupedFileVersionEntities> {
    private final Moshi moshi;

    @Inject
    public GroupedFileVersionEntitiesDomainMapper(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityModel.GroupedFileVersionModel toDomain(GroupedFileVersionEntities dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(Types.newParameterizedType(List.class, UserMiniDTO.class));
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        byte[] createdByJsonData = dataModel.getGroupedFileVersionsEntity().getCreatedByJsonData();
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        String str = new String(createdByJsonData, charsetForName);
        List list = (List) jsonAdapterAdapter.fromJson(str);
        if (list == null) {
            throw new IllegalStateException("versions not parsed correctly ".concat(str));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String name = ((UserMiniDTO) it.next()).getName();
            if (name != null) {
                arrayList.add(name);
            }
        }
        return new FileActivityModel.GroupedFileVersionModel(dataModel.getStartVersion().getNumber(), dataModel.getEndVersion().getNumber(), arrayList);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public GroupedFileVersionEntities fromDomain(FileActivityModel.GroupedFileVersionModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

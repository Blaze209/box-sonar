package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentEntityDomainMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/mappers/annotation/CommentEntityDomainMapper;", "Lcom/box/android/data/mappers/annotation/ActivityWithTagsEntityDomainMapper;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "commentDTODomainMapper", "Lcom/box/android/data/mappers/annotation/CommentDTODomainMapper;", "<init>", "(Lcom/squareup/moshi/Moshi;Lcom/box/android/data/mappers/annotation/CommentDTODomainMapper;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "toDomain", "dataModel", "replies", "", "fromDomain", "domainModel", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentEntityDomainMapper extends ActivityWithTagsEntityDomainMapper<FileActivityModel.CommentModel, CommentEntity> {
    public static final String MENTIONS_SYMBOL = "@";
    public static final String TAG_REGEX = "@\\[(\\d+):(.*?)]";
    private final CommentDTODomainMapper commentDTODomainMapper;
    private final Moshi moshi;

    @Inject
    public CommentEntityDomainMapper(Moshi moshi, CommentDTODomainMapper commentDTODomainMapper) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(commentDTODomainMapper, "commentDTODomainMapper");
        this.moshi = moshi;
        this.commentDTODomainMapper = commentDTODomainMapper;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityModel.CommentModel toDomain(CommentEntity dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        return toDomain(dataModel, CollectionsKt.emptyList());
    }

    public final FileActivityModel.CommentModel toDomain(CommentEntity dataModel, List<CommentEntity> replies) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Intrinsics.checkNotNullParameter(replies, "replies");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(CommentDTO.class);
        byte[] jsonData = dataModel.getJsonData();
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        String str = new String(jsonData, charsetForName);
        Intrinsics.checkNotNull(jsonAdapterAdapter);
        CommentDTO commentDTO = (CommentDTO) AnnotationEntityDomainMapperKt.fromJsonOrNull(jsonAdapterAdapter, str);
        if (commentDTO == null) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "comment JSON value ".concat(str));
            throw new IllegalStateException("comment not parsed correctly ".concat(str));
        }
        List<CommentEntity> list = replies;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toDomain((CommentEntity) it.next()));
        }
        return FileActivityModel.CommentModel.copy$default(this.commentDTODomainMapper.toDomain(commentDTO), null, null, null, null, null, arrayList, 0, null, null, null, 991, null);
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public CommentEntity fromDomain(FileActivityModel.CommentModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}

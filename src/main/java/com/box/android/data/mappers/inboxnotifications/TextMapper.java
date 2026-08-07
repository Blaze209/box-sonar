package com.box.android.data.mappers.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.TextAtomDTO;
import com.box.android.data.api.models.inboxnotifications.TextDTO;
import com.box.android.domain.models.inboxnotifications.TextAtomModel;
import com.box.android.domain.models.inboxnotifications.TextModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationUserMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/inboxnotifications/TextMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/inboxnotifications/TextModel;", "dto", "Lcom/box/android/data/api/models/inboxnotifications/TextDTO;", "fromDomain", "model", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextMapper {
    public static final TextMapper INSTANCE = new TextMapper();

    private TextMapper() {
    }

    public final TextModel toDomain(TextDTO dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        String type = dto.getType();
        List<TextAtomDTO> atoms = dto.getAtoms();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(atoms, 10));
        Iterator<T> it = atoms.iterator();
        while (it.hasNext()) {
            arrayList.add(TextAtomMapper.INSTANCE.toDomain((TextAtomDTO) it.next()));
        }
        return new TextModel(type, arrayList);
    }

    public final TextDTO fromDomain(TextModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String type = model.getType();
        List<TextAtomModel> atoms = model.getAtoms();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(atoms, 10));
        Iterator<T> it = atoms.iterator();
        while (it.hasNext()) {
            arrayList.add(TextAtomMapper.INSTANCE.fromDomain((TextAtomModel) it.next()));
        }
        return new TextDTO(type, arrayList);
    }
}

package com.box.android.data.mappers;

import com.box.android.data.api.models.RepresentationDTO;
import com.box.android.data.api.models.RepresentationState;
import com.box.android.data.api.models.RepresentationStatusDTO;
import com.box.android.data.api.models.RepresentationTypeDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.mappers.representations.RepresentationDTODomainMapper;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationStatus;
import com.box.android.domain.models.RepresentationType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationToDomainUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0000\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0000\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\u0000\u001a\u00020\b*\u00020\t¨\u0006\n"}, d2 = {"toDomain", "", "Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/android/data/api/models/RepresentationsDTO;", "Lcom/box/android/domain/models/RepresentationType;", "Lcom/box/android/data/api/models/RepresentationTypeDTO;", "Lcom/box/android/domain/models/RepresentationStatus;", "Lcom/box/android/data/api/models/RepresentationStatusDTO;", "Lcom/box/android/domain/models/RepresentationStatus$State;", "Lcom/box/android/data/api/models/RepresentationState;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RepresentationToDomainUtilsKt {

    /* JADX INFO: compiled from: RepresentationToDomainUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RepresentationTypeDTO.values().length];
            try {
                iArr[RepresentationTypeDTO.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RepresentationTypeDTO.JPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RepresentationTypeDTO.PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RepresentationTypeDTO.MP4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RepresentationTypeDTO.DASH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RepresentationTypeDTO.FILMSTRIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RepresentationTypeDTO.THREED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RepresentationTypeDTO.MP3.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RepresentationState.values().length];
            try {
                iArr2[RepresentationState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[RepresentationState.VIEWABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[RepresentationState.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[RepresentationState.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[RepresentationState.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final List<RepresentationModel> toDomain(RepresentationsDTO representationsDTO) {
        Intrinsics.checkNotNullParameter(representationsDTO, "<this>");
        List<RepresentationDTO> entries = representationsDTO.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(RepresentationDTODomainMapper.INSTANCE.toDomain((RepresentationDTO) it.next()));
        }
        return arrayList;
    }

    public static final RepresentationType toDomain(RepresentationTypeDTO representationTypeDTO) {
        Intrinsics.checkNotNullParameter(representationTypeDTO, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[representationTypeDTO.ordinal()]) {
            case 1:
                return RepresentationType.PDF;
            case 2:
                return RepresentationType.JPG;
            case 3:
                return RepresentationType.PNG;
            case 4:
                return RepresentationType.MP4;
            case 5:
                return RepresentationType.DASH;
            case 6:
                return RepresentationType.FILMSTRIP;
            case 7:
                return RepresentationType.THREED;
            case 8:
                return RepresentationType.MP3;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final RepresentationStatus toDomain(RepresentationStatusDTO representationStatusDTO) {
        Intrinsics.checkNotNullParameter(representationStatusDTO, "<this>");
        return new RepresentationStatus(toDomain(representationStatusDTO.getRepresentationState()), representationStatusDTO.getCode());
    }

    public static final RepresentationStatus.State toDomain(RepresentationState representationState) {
        Intrinsics.checkNotNullParameter(representationState, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[representationState.ordinal()];
        if (i == 1) {
            return RepresentationStatus.State.SUCCESS;
        }
        if (i == 2) {
            return RepresentationStatus.State.VIEWABLE;
        }
        if (i == 3) {
            return RepresentationStatus.State.PENDING;
        }
        if (i == 4) {
            return RepresentationStatus.State.NONE;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return RepresentationStatus.State.ERROR;
    }
}

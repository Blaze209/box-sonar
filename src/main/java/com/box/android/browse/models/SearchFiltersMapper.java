package com.box.android.browse.models;

import com.box.android.domain.models.search.FilesSearchFilters;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchFiltersMapper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\b\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\f\u0010\f\u001a\u00020\n*\u00020\u000bH\u0002J\f\u0010\r\u001a\u00020\u000b*\u00020\nH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0010*\u00020\u000fH\u0002J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0012H\u0002¨\u0006\u0016"}, d2 = {"Lcom/box/android/browse/models/SearchFiltersMapper;", "", "<init>", "()V", "toFilesSearchFilters", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "Lcom/box/android/browse/models/BoxSearchFilters;", "toLegacyBoxSearchFilters", "toItemTypes", "", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "Lcom/box/android/browse/models/BoxSearchFilters$ItemType;", "toFilterItemType", "toLegacyItemType", "toModifiedAfterDate", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "Lcom/box/android/browse/models/BoxSearchFilters$ItemModifiedDate;", "toSize", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "Lcom/box/android/browse/models/BoxSearchFilters$ItemSize;", "toLegacyItemModifiedDate", "toLegacySize", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchFiltersMapper {
    public static final int $stable = 0;
    public static final SearchFiltersMapper INSTANCE = new SearchFiltersMapper();

    /* JADX INFO: compiled from: SearchFiltersMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[BoxSearchFilters.ItemType.values().length];
            try {
                iArr[BoxSearchFilters.ItemType.Audio.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.BoxNote.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Document.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Autocad.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Image.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Pdf.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Presentation.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Spreadsheet.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Video.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BoxSearchFilters.ItemType.Folder.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BoxSearchFilters.ItemModifiedDate.values().length];
            try {
                iArr2[BoxSearchFilters.ItemModifiedDate.Any.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[BoxSearchFilters.ItemModifiedDate.PastDay.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[BoxSearchFilters.ItemModifiedDate.PastWeek.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[BoxSearchFilters.ItemModifiedDate.PastMonth.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[BoxSearchFilters.ItemModifiedDate.PastYear.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[BoxSearchFilters.ItemSize.values().length];
            try {
                iArr3[BoxSearchFilters.ItemSize.Any.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[BoxSearchFilters.ItemSize.lessThanOneMb.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[BoxSearchFilters.ItemSize.OneMbToFiveMb.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr3[BoxSearchFilters.ItemSize.FiveMbToTwentyFiveMb.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr3[BoxSearchFilters.ItemSize.TwentyFiveMbToHundredMb.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr3[BoxSearchFilters.ItemSize.HundredMbToOneGB.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private SearchFiltersMapper() {
    }

    public final FilesSearchFilters toFilesSearchFilters(BoxSearchFilters boxSearchFilters) {
        Intrinsics.checkNotNullParameter(boxSearchFilters, "<this>");
        HashSet<BoxSearchFilters.ItemType> mItemTypes = boxSearchFilters.mItemTypes;
        Intrinsics.checkNotNullExpressionValue(mItemTypes, "mItemTypes");
        Set<FilesSearchFilters.FilterItemType> itemTypes = toItemTypes(mItemTypes);
        BoxSearchFilters.ItemModifiedDate mItemModifiedDate = boxSearchFilters.mItemModifiedDate;
        Intrinsics.checkNotNullExpressionValue(mItemModifiedDate, "mItemModifiedDate");
        FilesSearchFilters.ModifiedAfterDate modifiedAfterDate = toModifiedAfterDate(mItemModifiedDate);
        BoxSearchFilters.ItemSize mItemSize = boxSearchFilters.mItemSize;
        Intrinsics.checkNotNullExpressionValue(mItemSize, "mItemSize");
        return new FilesSearchFilters(itemTypes, modifiedAfterDate, toSize(mItemSize));
    }

    public final BoxSearchFilters toLegacyBoxSearchFilters(FilesSearchFilters filesSearchFilters) {
        Intrinsics.checkNotNullParameter(filesSearchFilters, "<this>");
        BoxSearchFilters boxSearchFilters = new BoxSearchFilters();
        Iterator<T> it = filesSearchFilters.getItemTypes().iterator();
        while (it.hasNext()) {
            boxSearchFilters.addItemType(INSTANCE.toLegacyItemType((FilesSearchFilters.FilterItemType) it.next()));
        }
        boxSearchFilters.setItemModifiedDate(toLegacyItemModifiedDate(filesSearchFilters.getModifiedDate()));
        boxSearchFilters.setItemSize(toLegacySize(filesSearchFilters.getSize()));
        return boxSearchFilters;
    }

    private final Set<FilesSearchFilters.FilterItemType> toItemTypes(Set<? extends BoxSearchFilters.ItemType> set) {
        Set<? extends BoxSearchFilters.ItemType> set2 = set;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toFilterItemType((BoxSearchFilters.ItemType) it.next()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    private final FilesSearchFilters.FilterItemType toFilterItemType(BoxSearchFilters.ItemType itemType) {
        switch (WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()]) {
            case 1:
                return FilesSearchFilters.FilterItemType.FileType.Audio.INSTANCE;
            case 2:
                return FilesSearchFilters.FilterItemType.FileType.BoxNote.INSTANCE;
            case 3:
                return FilesSearchFilters.FilterItemType.FileType.Document.INSTANCE;
            case 4:
                return FilesSearchFilters.FilterItemType.FileType.Autocad.INSTANCE;
            case 5:
                return FilesSearchFilters.FilterItemType.FileType.Image.INSTANCE;
            case 6:
                return FilesSearchFilters.FilterItemType.FileType.Pdf.INSTANCE;
            case 7:
                return FilesSearchFilters.FilterItemType.FileType.Presentation.INSTANCE;
            case 8:
                return FilesSearchFilters.FilterItemType.FileType.Spreadsheet.INSTANCE;
            case 9:
                return FilesSearchFilters.FilterItemType.FileType.Video.INSTANCE;
            case 10:
                return FilesSearchFilters.FilterItemType.Folder.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final BoxSearchFilters.ItemType toLegacyItemType(FilesSearchFilters.FilterItemType filterItemType) {
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Audio.INSTANCE)) {
            return BoxSearchFilters.ItemType.Audio;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.BoxNote.INSTANCE)) {
            return BoxSearchFilters.ItemType.BoxNote;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Document.INSTANCE)) {
            return BoxSearchFilters.ItemType.Document;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Autocad.INSTANCE)) {
            return BoxSearchFilters.ItemType.Autocad;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Image.INSTANCE)) {
            return BoxSearchFilters.ItemType.Image;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Pdf.INSTANCE)) {
            return BoxSearchFilters.ItemType.Pdf;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Presentation.INSTANCE)) {
            return BoxSearchFilters.ItemType.Presentation;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Spreadsheet.INSTANCE)) {
            return BoxSearchFilters.ItemType.Spreadsheet;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Video.INSTANCE)) {
            return BoxSearchFilters.ItemType.Video;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.Folder.INSTANCE)) {
            return BoxSearchFilters.ItemType.Folder;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final FilesSearchFilters.ModifiedAfterDate toModifiedAfterDate(BoxSearchFilters.ItemModifiedDate itemModifiedDate) {
        int i = WhenMappings.$EnumSwitchMapping$1[itemModifiedDate.ordinal()];
        if (i == 1) {
            return FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE;
        }
        if (i == 2) {
            return FilesSearchFilters.ModifiedAfterDate.PastDay.INSTANCE;
        }
        if (i == 3) {
            return FilesSearchFilters.ModifiedAfterDate.PastWeek.INSTANCE;
        }
        if (i == 4) {
            return FilesSearchFilters.ModifiedAfterDate.PastMonth.INSTANCE;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return FilesSearchFilters.ModifiedAfterDate.PastYear.INSTANCE;
    }

    private final FilesSearchFilters.Size toSize(BoxSearchFilters.ItemSize itemSize) {
        switch (WhenMappings.$EnumSwitchMapping$2[itemSize.ordinal()]) {
            case 1:
                return FilesSearchFilters.Size.Any.INSTANCE;
            case 2:
                return FilesSearchFilters.Size.LessThan1Mb.INSTANCE;
            case 3:
                return FilesSearchFilters.Size.From1To5Mb.INSTANCE;
            case 4:
                return FilesSearchFilters.Size.From5To25Mb.INSTANCE;
            case 5:
                return FilesSearchFilters.Size.From25To100Mb.INSTANCE;
            case 6:
                return FilesSearchFilters.Size.From100MbTo1Gb.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final BoxSearchFilters.ItemModifiedDate toLegacyItemModifiedDate(FilesSearchFilters.ModifiedAfterDate modifiedAfterDate) {
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE)) {
            return BoxSearchFilters.ItemModifiedDate.Any;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastDay.INSTANCE)) {
            return BoxSearchFilters.ItemModifiedDate.PastDay;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastWeek.INSTANCE)) {
            return BoxSearchFilters.ItemModifiedDate.PastWeek;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastMonth.INSTANCE)) {
            return BoxSearchFilters.ItemModifiedDate.PastMonth;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastYear.INSTANCE)) {
            return BoxSearchFilters.ItemModifiedDate.PastYear;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final BoxSearchFilters.ItemSize toLegacySize(FilesSearchFilters.Size size) {
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.Any.INSTANCE)) {
            return BoxSearchFilters.ItemSize.Any;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.LessThan1Mb.INSTANCE)) {
            return BoxSearchFilters.ItemSize.lessThanOneMb;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From1To5Mb.INSTANCE)) {
            return BoxSearchFilters.ItemSize.OneMbToFiveMb;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From5To25Mb.INSTANCE)) {
            return BoxSearchFilters.ItemSize.FiveMbToTwentyFiveMb;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From25To100Mb.INSTANCE)) {
            return BoxSearchFilters.ItemSize.TwentyFiveMbToHundredMb;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From100MbTo1Gb.INSTANCE)) {
            return BoxSearchFilters.ItemSize.HundredMbToOneGB;
        }
        throw new NoWhenBranchMatchedException();
    }
}

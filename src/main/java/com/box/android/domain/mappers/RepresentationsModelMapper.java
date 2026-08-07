package com.box.android.domain.mappers;

import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationPropertiesModel;
import com.box.android.domain.models.RepresentationStatus;
import com.box.android.domain.models.RepresentationType;
import com.box.androidsdk.content.models.BoxEmbedLink;
import com.box.androidsdk.content.models.BoxIteratorRepresentations;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationsModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00050\tJ\n\u0010\n\u001a\u00020\u0006*\u00020\u0005J\n\u0010\u000b\u001a\u00020\f*\u00020\rJ\n\u0010\u000e\u001a\u00020\u000f*\u00020\fJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/mappers/RepresentationsModelMapper;", "", "<init>", "()V", "toRepresentationModel", "Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/androidsdk/content/models/BoxRepresentation;", "toBoxIteratorRepresentations", "Lcom/box/androidsdk/content/models/BoxIteratorRepresentations;", "", "toBoxRepresentation", "toRepresentationStatus", "Lcom/box/android/domain/models/RepresentationStatus$State;", "Lcom/box/androidsdk/content/models/BoxRepresentation$BoxRepStatus;", "toBoxRepStatus", "", "toBoxRepPropertiesMap", "Lcom/eclipsesource/json/JsonObject;", "Lcom/box/android/domain/models/RepresentationPropertiesModel;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationsModelMapper {
    public static final RepresentationsModelMapper INSTANCE = new RepresentationsModelMapper();

    /* JADX INFO: compiled from: RepresentationsModelMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RepresentationStatus.State.values().length];
            try {
                iArr[RepresentationStatus.State.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RepresentationStatus.State.VIEWABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RepresentationStatus.State.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RepresentationStatus.State.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RepresentationStatus.State.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RepresentationsModelMapper() {
    }

    public final RepresentationModel toRepresentationModel(BoxRepresentation boxRepresentation) {
        Intrinsics.checkNotNullParameter(boxRepresentation, "<this>");
        try {
            String url = boxRepresentation.getContent().getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            String url2 = boxRepresentation.getInfo().getUrl();
            Intrinsics.checkNotNullExpressionValue(url2, "getUrl(...)");
            BoxRepresentation.BoxRepPropertiesMap properties = boxRepresentation.getProperties();
            String dimension = properties != null ? properties.getDimension() : null;
            BoxRepresentation.BoxRepPropertiesMap properties2 = boxRepresentation.getProperties();
            boolean zIsPaged = properties2 != null ? properties2.isPaged() : false;
            BoxRepresentation.BoxRepPropertiesMap properties3 = boxRepresentation.getProperties();
            RepresentationPropertiesModel representationPropertiesModel = new RepresentationPropertiesModel(dimension, zIsPaged, properties3 != null ? properties3.isThumb() : false);
            RepresentationType.Companion companion = RepresentationType.INSTANCE;
            String representationType = boxRepresentation.getRepresentationType();
            Intrinsics.checkNotNullExpressionValue(representationType, "getRepresentationType(...)");
            RepresentationType representationTypeFromString = companion.fromString(representationType);
            BoxRepresentation.BoxRepStatus status = boxRepresentation.getStatus();
            Intrinsics.checkNotNullExpressionValue(status, "getStatus(...)");
            return new RepresentationModel(url, url2, representationPropertiesModel, representationTypeFromString, new RepresentationStatus(toRepresentationStatus(status), null, 2, null));
        } catch (Exception unused) {
            return null;
        }
    }

    public final BoxIteratorRepresentations toBoxIteratorRepresentations(List<RepresentationModel> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        List<RepresentationModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toBoxRepresentation((RepresentationModel) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            jsonArray.add(((BoxRepresentation) it2.next()).toJsonObject());
        }
        jsonObject.add("entries", jsonArray);
        return new BoxIteratorRepresentations(jsonObject);
    }

    public final BoxRepresentation toBoxRepresentation(RepresentationModel representationModel) {
        Intrinsics.checkNotNullParameter(representationModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObjectAdd = new BoxRepresentation.BoxRepContent().toJsonObject().add(BoxRepresentation.BoxRepContent.FIELD_URL, representationModel.getContentUrlTemplate());
        JsonObject jsonObject2 = new BoxRepresentation.BoxRepStatus().toJsonObject();
        RepresentationsModelMapper representationsModelMapper = INSTANCE;
        JsonObject jsonObjectAdd2 = jsonObject2.add("state", representationsModelMapper.toBoxRepStatus(representationModel.getStatus().getState()));
        JsonObject jsonObjectAdd3 = new BoxEmbedLink().toJsonObject().add("url", representationModel.getInfoUrl());
        jsonObject.add("content", jsonObjectAdd);
        jsonObject.add(BoxRepresentation.FIELD_REPRESENTATION, RepresentationType.INSTANCE.toBoxRepType(representationModel.getRepresentationType()));
        jsonObject.add("status", jsonObjectAdd2);
        jsonObject.add(BoxRepresentation.FIELD_INFO, jsonObjectAdd3);
        jsonObject.add("properties", representationsModelMapper.toBoxRepPropertiesMap(representationModel.getProperties()));
        return new BoxRepresentation(jsonObject);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final RepresentationStatus.State toRepresentationStatus(BoxRepresentation.BoxRepStatus boxRepStatus) {
        Intrinsics.checkNotNullParameter(boxRepStatus, "<this>");
        String state = boxRepStatus.getState();
        if (state != null) {
            switch (state.hashCode()) {
                case -1867169789:
                    if (state.equals("success")) {
                        return RepresentationStatus.State.SUCCESS;
                    }
                    break;
                case -682587753:
                    if (state.equals("pending")) {
                        return RepresentationStatus.State.PENDING;
                    }
                    break;
                case 3387192:
                    if (state.equals("none")) {
                        return RepresentationStatus.State.NONE;
                    }
                    break;
                case 96784904:
                    if (state.equals("error")) {
                        return RepresentationStatus.State.ERROR;
                    }
                    break;
                case 1196225919:
                    if (state.equals("viewable")) {
                        return RepresentationStatus.State.VIEWABLE;
                    }
                    break;
            }
        }
        return RepresentationStatus.State.ERROR;
    }

    public final String toBoxRepStatus(RepresentationStatus.State state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return "success";
        }
        if (i == 2) {
            return "viewable";
        }
        if (i == 3) {
            return "pending";
        }
        if (i == 4) {
            return "none";
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return "error";
    }

    private final JsonObject toBoxRepPropertiesMap(RepresentationPropertiesModel representationPropertiesModel) {
        JsonObject jsonObject = new BoxRepresentation.BoxRepPropertiesMap().toJsonObject();
        jsonObject.add(BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_PAGED, String.valueOf(representationPropertiesModel.getPaged()));
        jsonObject.add(BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_THUMB, String.valueOf(representationPropertiesModel.getThumb()));
        String dimensions = representationPropertiesModel.getDimensions();
        if (dimensions != null) {
            jsonObject.add(BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS, dimensions);
        }
        Intrinsics.checkNotNull(jsonObject);
        return jsonObject;
    }
}

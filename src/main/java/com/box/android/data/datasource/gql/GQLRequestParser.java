package com.box.android.data.datasource.gql;

import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okio.BufferedSink;
import okio.Okio;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: GQLRequestParser.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLRequestParser;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "jsonFromRequestBody", "", "request", "Lokhttp3/Request;", "parseName", "parseOperationName", "parseItemId", "parseItemType", "parseClientMutationId", "parseId", "parseParentId", "parseNewParentId", "parseNewName", "parseAllVariables", "Lcom/box/android/data/datasource/gql/GQLRequestParser$RequestVariables;", "RequestBody", "RequestVariables", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLRequestParser {
    private final Moshi moshi;

    @Inject
    public GQLRequestParser(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    /* JADX INFO: compiled from: GQLRequestParser.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLRequestParser$RequestBody;", "", "operationName", "", "variables", "Lcom/box/android/data/datasource/gql/GQLRequestParser$RequestVariables;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/datasource/gql/GQLRequestParser$RequestVariables;)V", "getOperationName", "()Ljava/lang/String;", "getVariables", "()Lcom/box/android/data/datasource/gql/GQLRequestParser$RequestVariables;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RequestBody {
        private final String operationName;
        private final RequestVariables variables;

        public static /* synthetic */ RequestBody copy$default(RequestBody requestBody, String str, RequestVariables requestVariables, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestBody.operationName;
            }
            if ((i & 2) != 0) {
                requestVariables = requestBody.variables;
            }
            return requestBody.copy(str, requestVariables);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getOperationName() {
            return this.operationName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RequestVariables getVariables() {
            return this.variables;
        }

        public final RequestBody copy(String operationName, RequestVariables variables) {
            Intrinsics.checkNotNullParameter(operationName, "operationName");
            Intrinsics.checkNotNullParameter(variables, "variables");
            return new RequestBody(operationName, variables);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestBody)) {
                return false;
            }
            RequestBody requestBody = (RequestBody) other;
            return Intrinsics.areEqual(this.operationName, requestBody.operationName) && Intrinsics.areEqual(this.variables, requestBody.variables);
        }

        public int hashCode() {
            return (this.operationName.hashCode() * 31) + this.variables.hashCode();
        }

        public String toString() {
            return "RequestBody(operationName=" + this.operationName + ", variables=" + this.variables + ")";
        }

        public RequestBody(String operationName, RequestVariables variables) {
            Intrinsics.checkNotNullParameter(operationName, "operationName");
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.operationName = operationName;
            this.variables = variables;
        }

        public final String getOperationName() {
            return this.operationName;
        }

        public final RequestVariables getVariables() {
            return this.variables;
        }
    }

    /* JADX INFO: compiled from: GQLRequestParser.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLRequestParser$RequestVariables;", "", "name", "", "itemId", "id", BoxItemJob.COLLECTION_ID, IdentificationData.FIELD_PARENT_ID, "newName", "newParentId", "type", "itemType", "clientMutationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getItemId", "getId", "getCollectionId", "getParentId", "getNewName", "getNewParentId", "getType", "getItemType", "getClientMutationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RequestVariables {
        private final String clientMutationId;
        private final String collectionId;
        private final String id;
        private final String itemId;
        private final String itemType;
        private final String name;
        private final String newName;
        private final String newParentId;
        private final String parentId;
        private final String type;

        public static /* synthetic */ RequestVariables copy$default(RequestVariables requestVariables, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
            if ((i & 1) != 0) {
                str = requestVariables.name;
            }
            if ((i & 2) != 0) {
                str2 = requestVariables.itemId;
            }
            if ((i & 4) != 0) {
                str3 = requestVariables.id;
            }
            if ((i & 8) != 0) {
                str4 = requestVariables.collectionId;
            }
            if ((i & 16) != 0) {
                str5 = requestVariables.parentId;
            }
            if ((i & 32) != 0) {
                str6 = requestVariables.newName;
            }
            if ((i & 64) != 0) {
                str7 = requestVariables.newParentId;
            }
            if ((i & 128) != 0) {
                str8 = requestVariables.type;
            }
            if ((i & 256) != 0) {
                str9 = requestVariables.itemType;
            }
            if ((i & 512) != 0) {
                str10 = requestVariables.clientMutationId;
            }
            String str11 = str9;
            String str12 = str10;
            String str13 = str7;
            String str14 = str8;
            String str15 = str5;
            String str16 = str6;
            return requestVariables.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getClientMutationId() {
            return this.clientMutationId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCollectionId() {
            return this.collectionId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getParentId() {
            return this.parentId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getNewName() {
            return this.newName;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getNewParentId() {
            return this.newParentId;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getItemType() {
            return this.itemType;
        }

        public final RequestVariables copy(String name, String itemId, String id, String collectionId, String parentId, String newName, String newParentId, String type, String itemType, String clientMutationId) {
            return new RequestVariables(name, itemId, id, collectionId, parentId, newName, newParentId, type, itemType, clientMutationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestVariables)) {
                return false;
            }
            RequestVariables requestVariables = (RequestVariables) other;
            return Intrinsics.areEqual(this.name, requestVariables.name) && Intrinsics.areEqual(this.itemId, requestVariables.itemId) && Intrinsics.areEqual(this.id, requestVariables.id) && Intrinsics.areEqual(this.collectionId, requestVariables.collectionId) && Intrinsics.areEqual(this.parentId, requestVariables.parentId) && Intrinsics.areEqual(this.newName, requestVariables.newName) && Intrinsics.areEqual(this.newParentId, requestVariables.newParentId) && Intrinsics.areEqual(this.type, requestVariables.type) && Intrinsics.areEqual(this.itemType, requestVariables.itemType) && Intrinsics.areEqual(this.clientMutationId, requestVariables.clientMutationId);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.itemId;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.id;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.collectionId;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.parentId;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.newName;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.newParentId;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.type;
            int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.itemType;
            int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.clientMutationId;
            return iHashCode9 + (str10 != null ? str10.hashCode() : 0);
        }

        public String toString() {
            return "RequestVariables(name=" + this.name + ", itemId=" + this.itemId + ", id=" + this.id + ", collectionId=" + this.collectionId + ", parentId=" + this.parentId + ", newName=" + this.newName + ", newParentId=" + this.newParentId + ", type=" + this.type + ", itemType=" + this.itemType + ", clientMutationId=" + this.clientMutationId + ")";
        }

        public RequestVariables(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            this.name = str;
            this.itemId = str2;
            this.id = str3;
            this.collectionId = str4;
            this.parentId = str5;
            this.newName = str6;
            this.newParentId = str7;
            this.type = str8;
            this.itemType = str9;
            this.clientMutationId = str10;
        }

        public final String getName() {
            return this.name;
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final String getId() {
            return this.id;
        }

        public final String getCollectionId() {
            return this.collectionId;
        }

        public final String getParentId() {
            return this.parentId;
        }

        public final String getNewName() {
            return this.newName;
        }

        public final String getNewParentId() {
            return this.newParentId;
        }

        public final String getType() {
            return this.type;
        }

        public final String getItemType() {
            return this.itemType;
        }

        public final String getClientMutationId() {
            return this.clientMutationId;
        }
    }

    private final String jsonFromRequestBody(Request request) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(byteArrayOutputStream));
        okhttp3.RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            requestBodyBody.writeTo(bufferedSinkBuffer);
        }
        bufferedSinkBuffer.emit().close();
        String string = byteArrayOutputStream.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String parseName(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getName();
    }

    public final String parseOperationName(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody != null) {
            return requestBody.getOperationName();
        }
        return null;
    }

    public final String parseItemId(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getItemId();
    }

    public final String parseItemType(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getType();
    }

    public final String parseClientMutationId(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getClientMutationId();
    }

    public final String parseId(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getId();
    }

    public final String parseParentId(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getParentId();
    }

    public final String parseNewParentId(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getNewParentId();
    }

    public final String parseNewName(Request request) {
        RequestVariables variables;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody == null || (variables = requestBody.getVariables()) == null) {
            return null;
        }
        return variables.getNewName();
    }

    public final RequestVariables parseAllVariables(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBody = (RequestBody) this.moshi.adapter(RequestBody.class).fromJson(jsonFromRequestBody(request));
        if (requestBody != null) {
            return requestBody.getVariables();
        }
        return null;
    }
}

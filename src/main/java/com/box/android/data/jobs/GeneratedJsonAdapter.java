package com.box.android.data.jobs;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineRunningInfoJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: MarkForOfflineRunningInfoJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/jobs/MarkForOfflineRunningInfoJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/jobs/MarkForOfflineRunningInfo;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "remoteAdapter", "Lcom/box/android/domain/models/ItemId$Remote;", "downloadStatusAdapter", "Lcom/box/android/data/jobs/DownloadStatus;", "nullableStringAdapter", "nullableDomainErrorAdapter", "Lcom/box/android/domain/models/DomainError;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<MarkForOfflineRunningInfo> {
    private volatile Constructor<MarkForOfflineRunningInfo> constructorRef;
    private final JsonAdapter<DownloadStatus> downloadStatusAdapter;
    private final JsonAdapter<DomainError> nullableDomainErrorAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<ItemId.Remote> remoteAdapter;
    private final JsonAdapter<String> stringAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("itemName", "itemRemoteId", "downloadOriginalStatus", "downloadPreviewStatus", "downloadOriginalJobId", "previewError");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "itemName");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<ItemId.Remote> jsonAdapterAdapter2 = moshi.adapter(ItemId.Remote.class, SetsKt.emptySet(), "itemRemoteId");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.remoteAdapter = jsonAdapterAdapter2;
        JsonAdapter<DownloadStatus> jsonAdapterAdapter3 = moshi.adapter(DownloadStatus.class, SetsKt.emptySet(), "downloadOriginalStatus");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.downloadStatusAdapter = jsonAdapterAdapter3;
        JsonAdapter<String> jsonAdapterAdapter4 = moshi.adapter(String.class, SetsKt.emptySet(), "downloadOriginalJobId");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.nullableStringAdapter = jsonAdapterAdapter4;
        JsonAdapter<DomainError> jsonAdapterAdapter5 = moshi.adapter(DomainError.class, SetsKt.emptySet(), "previewError");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.nullableDomainErrorAdapter = jsonAdapterAdapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(47);
        sb.append("GeneratedJsonAdapter(MarkForOfflineRunningInfo)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public MarkForOfflineRunningInfo fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        String strFromJson = null;
        ItemId.Remote remoteFromJson = null;
        DownloadStatus downloadStatusFromJson = null;
        DownloadStatus downloadStatusFromJson2 = null;
        String strFromJson2 = null;
        DomainError domainErrorFromJson = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    strFromJson = this.stringAdapter.fromJson(reader);
                    if (strFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("itemName", "itemName", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull;
                    }
                    break;
                    break;
                case 1:
                    remoteFromJson = this.remoteAdapter.fromJson(reader);
                    if (remoteFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("itemRemoteId", "itemRemoteId", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull2;
                    }
                    break;
                    break;
                case 2:
                    downloadStatusFromJson = this.downloadStatusAdapter.fromJson(reader);
                    if (downloadStatusFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull("downloadOriginalStatus", "downloadOriginalStatus", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull3;
                    }
                    i &= -5;
                    break;
                    break;
                case 3:
                    downloadStatusFromJson2 = this.downloadStatusAdapter.fromJson(reader);
                    if (downloadStatusFromJson2 == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("downloadPreviewStatus", "downloadPreviewStatus", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull4;
                    }
                    i &= -9;
                    break;
                    break;
                case 4:
                    strFromJson2 = this.nullableStringAdapter.fromJson(reader);
                    i &= -17;
                    break;
                case 5:
                    domainErrorFromJson = this.nullableDomainErrorAdapter.fromJson(reader);
                    i &= -33;
                    break;
            }
        }
        reader.endObject();
        if (i == -61) {
            DomainError domainError = domainErrorFromJson;
            String str = strFromJson2;
            DownloadStatus downloadStatus = downloadStatusFromJson2;
            DownloadStatus downloadStatus2 = downloadStatusFromJson;
            ItemId.Remote remote = remoteFromJson;
            String str2 = strFromJson;
            if (str2 == null) {
                JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("itemName", "itemName", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty;
            }
            if (remote == null) {
                JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("itemRemoteId", "itemRemoteId", reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty2;
            }
            Intrinsics.checkNotNull(downloadStatus2, "null cannot be cast to non-null type com.box.android.data.jobs.DownloadStatus");
            Intrinsics.checkNotNull(downloadStatus, "null cannot be cast to non-null type com.box.android.data.jobs.DownloadStatus");
            return new MarkForOfflineRunningInfo(str2, remote, downloadStatus2, downloadStatus, str, domainError);
        }
        DomainError domainError2 = domainErrorFromJson;
        String str3 = strFromJson2;
        DownloadStatus downloadStatus3 = downloadStatusFromJson2;
        DownloadStatus downloadStatus4 = downloadStatusFromJson;
        ItemId.Remote remote2 = remoteFromJson;
        String str4 = strFromJson;
        Constructor<MarkForOfflineRunningInfo> declaredConstructor = this.constructorRef;
        if (declaredConstructor == null) {
            declaredConstructor = MarkForOfflineRunningInfo.class.getDeclaredConstructor(String.class, ItemId.Remote.class, DownloadStatus.class, DownloadStatus.class, String.class, DomainError.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = declaredConstructor;
            Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
        }
        Constructor<MarkForOfflineRunningInfo> constructor = declaredConstructor;
        if (str4 == null) {
            JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("itemName", "itemName", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty3;
        }
        if (remote2 == null) {
            JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("itemRemoteId", "itemRemoteId", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty4;
        }
        MarkForOfflineRunningInfo markForOfflineRunningInfoNewInstance = constructor.newInstance(str4, remote2, downloadStatus4, downloadStatus3, str3, domainError2, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(markForOfflineRunningInfoNewInstance, "newInstance(...)");
        return markForOfflineRunningInfoNewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, MarkForOfflineRunningInfo value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("itemName");
        this.stringAdapter.toJson(writer, value_.getItemName());
        writer.name("itemRemoteId");
        this.remoteAdapter.toJson(writer, value_.getItemRemoteId());
        writer.name("downloadOriginalStatus");
        this.downloadStatusAdapter.toJson(writer, value_.getDownloadOriginalStatus());
        writer.name("downloadPreviewStatus");
        this.downloadStatusAdapter.toJson(writer, value_.getDownloadPreviewStatus());
        writer.name("downloadOriginalJobId");
        this.nullableStringAdapter.toJson(writer, value_.getDownloadOriginalJobId());
        writer.name("previewError");
        this.nullableDomainErrorAdapter.toJson(writer, value_.getPreviewError());
        writer.endObject();
    }
}

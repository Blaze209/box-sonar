package com.apollographql.apollo3.api.http;

import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Subscription;
import com.apollographql.apollo3.api.Upload;
import com.apollographql.apollo3.api.http.internal.UrlEncodeKt;
import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import com.apollographql.apollo3.api.json.internal.FileUploadAwareJsonWriter;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: DefaultHttpRequestComposer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/apollographql/apollo3/api/http/DefaultHttpRequestComposer;", "Lcom/apollographql/apollo3/api/http/HttpRequestComposer;", "serverUrl", "", "(Ljava/lang/String;)V", "compose", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "apolloRequest", "Lcom/apollographql/apollo3/api/ApolloRequest;", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultHttpRequestComposer implements HttpRequestComposer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HEADER_ACCEPT_NAME = "Accept";
    private static final String HEADER_ACCEPT_VALUE_DEFER = "multipart/mixed; deferSpec=20220824, application/json";
    private static final String HEADER_ACCEPT_VALUE_MULTIPART = "multipart/mixed; boundary=\"graphql\"; subscriptionSpec=1.0, application/json";
    public static final String HEADER_APOLLO_OPERATION_ID = "X-APOLLO-OPERATION-ID";
    public static final String HEADER_APOLLO_OPERATION_NAME = "X-APOLLO-OPERATION-NAME";
    private final String serverUrl;

    /* JADX INFO: compiled from: DefaultHttpRequestComposer.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            try {
                iArr[HttpMethod.Get.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HttpMethod.Post.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DefaultHttpRequestComposer(String serverUrl) {
        Intrinsics.checkNotNullParameter(serverUrl, "serverUrl");
        this.serverUrl = serverUrl;
    }

    @Override // com.apollographql.apollo3.api.http.HttpRequestComposer
    public <D extends Operation.Data> HttpRequest compose(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "apolloRequest");
        Operation<D> operation = apolloRequest.getOperation();
        CustomScalarAdapters customScalarAdapters = (CustomScalarAdapters) apolloRequest.getExecutionContext().get(CustomScalarAdapters.INSTANCE);
        if (customScalarAdapters == null) {
            customScalarAdapters = CustomScalarAdapters.Empty;
        }
        CustomScalarAdapters customScalarAdapters2 = customScalarAdapters;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpHeader(HEADER_APOLLO_OPERATION_ID, operation.id()));
        arrayList.add(new HttpHeader(HEADER_APOLLO_OPERATION_NAME, operation.name()));
        if (apolloRequest.getOperation() instanceof Subscription) {
            arrayList.add(new HttpHeader("Accept", HEADER_ACCEPT_VALUE_MULTIPART));
        } else {
            arrayList.add(new HttpHeader("Accept", HEADER_ACCEPT_VALUE_DEFER));
        }
        if (apolloRequest.getHttpHeaders() != null) {
            arrayList.addAll(apolloRequest.getHttpHeaders());
        }
        Boolean sendApqExtensions = apolloRequest.getSendApqExtensions();
        boolean zBooleanValue = sendApqExtensions != null ? sendApqExtensions.booleanValue() : false;
        Boolean sendDocument = apolloRequest.getSendDocument();
        boolean zBooleanValue2 = sendDocument != null ? sendDocument.booleanValue() : true;
        HttpMethod httpMethod = apolloRequest.getHttpMethod();
        if (httpMethod == null) {
            httpMethod = HttpMethod.Post;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[httpMethod.ordinal()];
        if (i == 1) {
            return new HttpRequest.Builder(HttpMethod.Get, INSTANCE.buildGetUrl(this.serverUrl, operation, customScalarAdapters2, zBooleanValue, zBooleanValue2)).addHeaders(arrayList).build();
        }
        if (i == 2) {
            return new HttpRequest.Builder(HttpMethod.Post, this.serverUrl).addHeaders(arrayList).body(INSTANCE.buildPostBody(operation, customScalarAdapters2, zBooleanValue, zBooleanValue2 ? operation.document() : null)).build();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: compiled from: DefaultHttpRequestComposer.kt */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J@\u0010\u0011\u001a\u00020\u0004\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J6\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010J:\u0010\u001d\u001a\u00020\u001e\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0007JI\u0010\u001d\u001a\u00020\u001e\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rJD\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0002J,\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00120%JN\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0\"\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010(\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0002J_\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0\"\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010(\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0002J\u001e\u0010)\u001a\u00020\u0004*\u00020\u00042\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/apollographql/apollo3/api/http/DefaultHttpRequestComposer$Companion;", "", "()V", "HEADER_ACCEPT_NAME", "", "HEADER_ACCEPT_VALUE_DEFER", "HEADER_ACCEPT_VALUE_MULTIPART", "HEADER_APOLLO_OPERATION_ID", "HEADER_APOLLO_OPERATION_NAME", "apqExtensionsWriter", "Lkotlin/Function1;", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "", "Lkotlin/ExtensionFunctionType;", "id", "sendApqExtensions", "", "buildGetUrl", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "serverUrl", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "sendDocument", "buildParamsMap", "Lokio/ByteString;", "autoPersistQueries", "buildPostBody", "Lcom/apollographql/apollo3/api/http/HttpBody;", "query", "extensionsWriter", "composeGetParams", "", "composePayload", "apolloRequest", "Lcom/apollographql/apollo3/api/ApolloRequest;", "composePostParams", "Lcom/apollographql/apollo3/api/Upload;", "writer", "appendQueryParameters", "parameters", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <D extends Operation.Data> String buildGetUrl(String serverUrl, Operation<D> operation, CustomScalarAdapters customScalarAdapters, boolean sendApqExtensions, boolean sendDocument) {
            return appendQueryParameters(serverUrl, composeGetParams(operation, customScalarAdapters, sendApqExtensions, sendDocument));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <D extends Operation.Data> Map<String, Upload> composePostParams(JsonWriter writer, Operation<D> operation, CustomScalarAdapters customScalarAdapters, boolean sendApqExtensions, String query) {
            return composePostParams(writer, operation, customScalarAdapters, query, apqExtensionsWriter(operation.id(), sendApqExtensions));
        }

        private final Function1<JsonWriter, Unit> apqExtensionsWriter(final String id, final boolean sendApqExtensions) {
            return new Function1<JsonWriter, Unit>() { // from class: com.apollographql.apollo3.api.http.DefaultHttpRequestComposer$Companion$apqExtensionsWriter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonWriter jsonWriter) throws IOException {
                    invoke2(jsonWriter);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonWriter jsonWriter) throws IOException {
                    Intrinsics.checkNotNullParameter(jsonWriter, "$this$null");
                    if (sendApqExtensions) {
                        jsonWriter.name("extensions");
                        String str = id;
                        jsonWriter.beginObject();
                        jsonWriter.name("persistedQuery");
                        jsonWriter.beginObject();
                        jsonWriter.name("version").value(1);
                        jsonWriter.name("sha256Hash").value(str);
                        jsonWriter.endObject();
                        jsonWriter.endObject();
                    }
                }
            };
        }

        private final <D extends Operation.Data> Map<String, String> composeGetParams(Operation<D> operation, CustomScalarAdapters customScalarAdapters, boolean autoPersistQueries, boolean sendDocument) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("operationName", operation.name());
            Buffer buffer = new Buffer();
            FileUploadAwareJsonWriter fileUploadAwareJsonWriter = new FileUploadAwareJsonWriter(new BufferedSinkJsonWriter(buffer, null));
            FileUploadAwareJsonWriter fileUploadAwareJsonWriter2 = fileUploadAwareJsonWriter;
            fileUploadAwareJsonWriter2.beginObject();
            operation.serializeVariables(fileUploadAwareJsonWriter2, customScalarAdapters);
            fileUploadAwareJsonWriter2.endObject();
            if (!fileUploadAwareJsonWriter.collectedUploads().isEmpty()) {
                throw new IllegalStateException("FileUpload and Http GET are not supported at the same time".toString());
            }
            linkedHashMap.put("variables", buffer.readUtf8());
            if (sendDocument) {
                linkedHashMap.put("query", operation.document());
            }
            if (autoPersistQueries) {
                Buffer buffer2 = new Buffer();
                BufferedSinkJsonWriter bufferedSinkJsonWriter = new BufferedSinkJsonWriter(buffer2, null);
                bufferedSinkJsonWriter.beginObject();
                bufferedSinkJsonWriter.name("persistedQuery");
                bufferedSinkJsonWriter.beginObject();
                bufferedSinkJsonWriter.name("version").value(1);
                bufferedSinkJsonWriter.name("sha256Hash").value(operation.id());
                bufferedSinkJsonWriter.endObject();
                bufferedSinkJsonWriter.endObject();
                linkedHashMap.put("extensions", buffer2.readUtf8());
            }
            return linkedHashMap;
        }

        public final String appendQueryParameters(String str, Map<String, String> parameters) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            boolean zContains$default = StringsKt.contains$default((CharSequence) str, (CharSequence) MsalUtils.QUERY_STRING_SYMBOL, false, 2, (Object) null);
            Iterator<T> it = parameters.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (zContains$default) {
                    sb.append(Typography.amp);
                } else {
                    sb.append('?');
                    zContains$default = true;
                }
                sb.append(UrlEncodeKt.urlEncode((String) entry.getKey()));
                sb.append('=');
                sb.append(UrlEncodeKt.urlEncode((String) entry.getValue()));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @Deprecated(message = "Use buildPostBody(operation, customScalarADapters, query, extensionsWriter) instead")
        public final <D extends Operation.Data> HttpBody buildPostBody(Operation<D> operation, CustomScalarAdapters customScalarAdapters, boolean autoPersistQueries, String query) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            return buildPostBody(operation, customScalarAdapters, query, apqExtensionsWriter(operation.id(), autoPersistQueries));
        }

        public final <D extends Operation.Data> Map<String, Object> composePayload(ApolloRequest<D> apolloRequest) {
            Intrinsics.checkNotNullParameter(apolloRequest, "apolloRequest");
            Operation<D> operation = apolloRequest.getOperation();
            Boolean sendApqExtensions = apolloRequest.getSendApqExtensions();
            boolean zBooleanValue = sendApqExtensions != null ? sendApqExtensions.booleanValue() : false;
            Boolean sendDocument = apolloRequest.getSendDocument();
            boolean zBooleanValue2 = sendDocument != null ? sendDocument.booleanValue() : true;
            CustomScalarAdapters customScalarAdapters = (CustomScalarAdapters) apolloRequest.getExecutionContext().get(CustomScalarAdapters.INSTANCE);
            if (customScalarAdapters == null) {
                throw new IllegalStateException("Cannot find a ResponseAdapterCache".toString());
            }
            String strDocument = zBooleanValue2 ? operation.document() : null;
            MapJsonWriter mapJsonWriter = new MapJsonWriter();
            DefaultHttpRequestComposer.INSTANCE.composePostParams(mapJsonWriter, operation, customScalarAdapters, zBooleanValue, strDocument);
            Object objRoot = mapJsonWriter.root();
            Intrinsics.checkNotNull(objRoot, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            return (Map) objRoot;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <D extends Operation.Data> Map<String, Upload> composePostParams(JsonWriter writer, Operation<D> operation, CustomScalarAdapters customScalarAdapters, String query, Function1<? super JsonWriter, Unit> extensionsWriter) throws IOException {
            writer.beginObject();
            writer.name("operationName");
            writer.value(operation.name());
            writer.name("variables");
            FileUploadAwareJsonWriter fileUploadAwareJsonWriter = new FileUploadAwareJsonWriter(writer);
            FileUploadAwareJsonWriter fileUploadAwareJsonWriter2 = fileUploadAwareJsonWriter;
            fileUploadAwareJsonWriter2.beginObject();
            operation.serializeVariables(fileUploadAwareJsonWriter2, customScalarAdapters);
            fileUploadAwareJsonWriter2.endObject();
            Map<String, Upload> mapCollectedUploads = fileUploadAwareJsonWriter.collectedUploads();
            if (query != null) {
                writer.name("query");
                writer.value(query);
            }
            extensionsWriter.invoke(writer);
            writer.endObject();
            return mapCollectedUploads;
        }

        public final <D extends Operation.Data> HttpBody buildPostBody(Operation<D> operation, CustomScalarAdapters customScalarAdapters, String query, Function1<? super JsonWriter, Unit> extensionsWriter) throws IOException {
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(extensionsWriter, "extensionsWriter");
            Buffer buffer = new Buffer();
            Map mapComposePostParams = DefaultHttpRequestComposer.INSTANCE.composePostParams(new BufferedSinkJsonWriter(buffer, null), operation, customScalarAdapters, query, extensionsWriter);
            final ByteString byteString = buffer.readByteString();
            if (mapComposePostParams.isEmpty()) {
                return new HttpBody() { // from class: com.apollographql.apollo3.api.http.DefaultHttpRequestComposer$Companion$buildPostBody$1
                    private final long contentLength;
                    private final String contentType = "application/json";

                    {
                        this.contentLength = this.$operationByteString.size();
                    }

                    @Override // com.apollographql.apollo3.api.http.HttpBody
                    public String getContentType() {
                        return this.contentType;
                    }

                    @Override // com.apollographql.apollo3.api.http.HttpBody
                    public long getContentLength() {
                        return this.contentLength;
                    }

                    @Override // com.apollographql.apollo3.api.http.HttpBody
                    public void writeTo(BufferedSink bufferedSink) throws IOException {
                        Intrinsics.checkNotNullParameter(bufferedSink, "bufferedSink");
                        bufferedSink.write(this.$operationByteString);
                    }
                };
            }
            return new UploadsHttpBody(mapComposePostParams, byteString);
        }

        public final <D extends Operation.Data> ByteString buildParamsMap(Operation<D> operation, CustomScalarAdapters customScalarAdapters, boolean autoPersistQueries, boolean sendDocument) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Buffer buffer = new Buffer();
            DefaultHttpRequestComposer.INSTANCE.composePostParams(new BufferedSinkJsonWriter(buffer, null), operation, customScalarAdapters, autoPersistQueries, sendDocument ? operation.document() : null);
            return buffer.readByteString();
        }
    }
}

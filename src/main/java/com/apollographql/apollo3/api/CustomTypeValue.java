package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "Used for backward compatibility with 2.x, use Adapter instead")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0007\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0003\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "Companion", "GraphQLBoolean", "GraphQLJsonList", "GraphQLJsonObject", "GraphQLNull", "GraphQLNumber", "GraphQLString", "Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLBoolean;", "Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLJsonList;", "Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLJsonObject;", "Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLNull;", "Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLNumber;", "Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLString;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class CustomTypeValue<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final T value;

    public /* synthetic */ CustomTypeValue(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    @JvmStatic
    public static final CustomTypeValue<?> fromRawValue(Object obj) {
        return INSTANCE.fromRawValue(obj);
    }

    private CustomTypeValue(T t) {
        this.value = t;
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLNull;", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "", "()V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphQLNull extends CustomTypeValue<Unit> {
        public static final GraphQLNull INSTANCE = new GraphQLNull();

        private GraphQLNull() {
            super(Unit.INSTANCE, null);
        }
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLString;", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "", "value", "(Ljava/lang/String;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphQLString extends CustomTypeValue<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GraphQLString(String value) {
            super(value, null);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLBoolean;", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "", "value", "(Z)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphQLBoolean extends CustomTypeValue<Boolean> {
        public GraphQLBoolean(boolean z) {
            super(Boolean.valueOf(z), null);
        }
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLNumber;", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "", "value", "(Ljava/lang/Number;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphQLNumber extends CustomTypeValue<Number> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GraphQLNumber(Number value) {
            super(value, null);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLJsonObject;", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "", "", "", "value", "(Ljava/util/Map;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphQLJsonObject extends CustomTypeValue<Map<String, ? extends Object>> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GraphQLJsonObject(Map<String, ? extends Object> value) {
            super(value, null);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$GraphQLJsonList;", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "", "", "value", "(Ljava/util/List;)V", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class GraphQLJsonList extends CustomTypeValue<List<? extends Object>> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GraphQLJsonList(List<? extends Object> value) {
            super(value, null);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* JADX INFO: compiled from: Version2CustomTypeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\u0006"}, d2 = {"Lcom/apollographql/apollo3/api/CustomTypeValue$Companion;", "", "()V", "fromRawValue", "Lcom/apollographql/apollo3/api/CustomTypeValue;", "value", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CustomTypeValue<?> fromRawValue(Object value) {
            if (value instanceof Map) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
                return new GraphQLJsonObject((Map) value);
            }
            if (value instanceof List) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
                return new GraphQLJsonList((List) value);
            }
            if (value instanceof Boolean) {
                return new GraphQLBoolean(((Boolean) value).booleanValue());
            }
            if (value instanceof Number) {
                return new GraphQLNumber((Number) value);
            }
            if (value == null) {
                return GraphQLNull.INSTANCE;
            }
            return new GraphQLString(value.toString());
        }
    }
}

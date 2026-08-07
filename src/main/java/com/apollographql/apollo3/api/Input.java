package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "Input is a helper class to help migrating to 3.x and will be removed in a future version")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/apollographql/apollo3/api/Input;", "", "()V", "Companion", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Input {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Deprecated(message = "absent() is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "Optional.Absent", imports = {}))
    @JvmStatic
    public static final <V> Optional.Absent absent() {
        return INSTANCE.absent();
    }

    @Deprecated(message = "fromNullable() is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "Optional.Present(value)", imports = {}))
    @JvmStatic
    public static final <V> Optional<V> fromNullable(V v) {
        return INSTANCE.fromNullable(v);
    }

    @Deprecated(message = "optional() is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "Optional.presentIfNotNull(value)", imports = {}))
    @JvmStatic
    public static final <V> Optional<V> optional(V v) {
        return INSTANCE.optional(v);
    }

    /* JADX INFO: compiled from: Input.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005H\u0007J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/api/Input$Companion;", "", "()V", "absent", "Lcom/apollographql/apollo3/api/Optional$Absent;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "fromNullable", "Lcom/apollographql/apollo3/api/Optional;", "value", "(Ljava/lang/Object;)Lcom/apollographql/apollo3/api/Optional;", "optional", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(message = "optional() is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "Optional.presentIfNotNull(value)", imports = {}))
        @JvmStatic
        public final <V> Optional<V> optional(V value) {
            return Optional.INSTANCE.presentIfNotNull(value);
        }

        @Deprecated(message = "fromNullable() is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "Optional.Present(value)", imports = {}))
        @JvmStatic
        public final <V> Optional<V> fromNullable(V value) {
            return new Optional.Present(value);
        }

        @Deprecated(message = "absent() is a helper function to help migrating to 3.x and will be removed in a future version", replaceWith = @ReplaceWith(expression = "Optional.Absent", imports = {}))
        @JvmStatic
        public final <V> Optional.Absent absent() {
            return Optional.Absent.INSTANCE;
        }
    }
}

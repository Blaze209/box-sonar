package com.box.androidsdk.content.utils.logging;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: compiled from: PIIMaskingToStringBuilder.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\f"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/PIIMaskingToStringBuilder;", "Lorg/apache/commons/lang3/builder/ReflectionToStringBuilder;", "value", "", "toStringStyle", "Lorg/apache/commons/lang3/builder/ToStringStyle;", "<init>", "(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V", "getValue", "field", "Ljava/lang/reflect/Field;", "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PIIMaskingToStringBuilder extends ReflectionToStringBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PIIMaskingToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        super(obj, toStringStyle);
        Intrinsics.checkNotNullParameter(toStringStyle, "toStringStyle");
    }

    public /* synthetic */ PIIMaskingToStringBuilder(Object obj, RecursivePIIMaskingToStringStyle recursivePIIMaskingToStringStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? RecursivePIIMaskingToStringStyle.INSTANCE : recursivePIIMaskingToStringStyle);
    }

    @Override // org.apache.commons.lang3.builder.ReflectionToStringBuilder
    protected Object getValue(Field field) {
        Object value;
        return (field == null || ((Safe) field.getAnnotation(Safe.class)) == null || (value = super.getValue(field)) == null) ? INSTANCE.mask(super.getValue(field)) : value;
    }

    /* JADX INFO: compiled from: PIIMaskingToStringBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001¨\u0006\b"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/PIIMaskingToStringBuilder$Companion;", "", "<init>", "()V", "toString", "", "value", "mask", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(Object value) {
            String string = new PIIMaskingToStringBuilder(value, RecursivePIIMaskingToStringStyle.INSTANCE).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public final String mask(Object value) {
            return Configuration.INSTANCE.getDataMaskingFunction().mask(value);
        }
    }
}

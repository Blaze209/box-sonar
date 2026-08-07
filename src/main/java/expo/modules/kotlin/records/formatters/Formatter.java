package expo.modules.kotlin.records.formatters;

import expo.modules.kotlin.records.Record;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: Formatter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0015B\u001f\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ7\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0013H\u0000¢\u0006\u0002\b\u0014R$\u0010\u0004\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/records/formatters/Formatter;", "RecordType", "Lexpo/modules/kotlin/records/Record;", "", "selectors", "", "Lexpo/modules/kotlin/records/formatters/PropertySelector;", "<init>", "(Ljava/util/List;)V", "getSelectors$expo_modules_core_release", "()Ljava/util/List;", "invoke", "Lexpo/modules/kotlin/records/formatters/FormattedRecord;", "record", "(Lexpo/modules/kotlin/records/Record;)Lexpo/modules/kotlin/records/formatters/FormattedRecord;", "format", "getAction", "Lkotlin/Function2;", "property", "Lkotlin/reflect/KProperty1;", "getAction$expo_modules_core_release", "Builder", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Formatter<RecordType extends Record> {
    public static final int $stable = 8;
    private final List<PropertySelector<RecordType, ?>> selectors;

    /* JADX WARN: Multi-variable type inference failed */
    public Formatter(List<? extends PropertySelector<RecordType, ?>> selectors) {
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        this.selectors = selectors;
    }

    public final List<PropertySelector<RecordType, ?>> getSelectors$expo_modules_core_release() {
        return this.selectors;
    }

    /* JADX INFO: compiled from: Formatter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\r\u001a\u0018\u0012\u0004\u0012\u0002H\u000f0\u000eR\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u000f0\b\"\u0004\b\u0002\u0010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u000f0\u0011J:\u0010\r\u001a\u0018\u0012\u0004\u0012\u0002H\u000f0\u0012R\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u000f0\b\"\b\b\u0002\u0010\u000f*\u00020\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u000f0\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0000¢\u0006\u0002\b\u0015R*\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0001\u0012\u0002\b\u00030\b0\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/records/formatters/Formatter$Builder;", "RecordType", "Lexpo/modules/kotlin/records/Record;", "", "<init>", "()V", "selectors", "", "Lexpo/modules/kotlin/records/formatters/PropertySelector;", "getSelectors$expo_modules_core_release", "()Ljava/util/List;", "setSelectors$expo_modules_core_release", "(Ljava/util/List;)V", "property", "Lexpo/modules/kotlin/records/formatters/PropertySelector$ActionBuilder;", "PropertyType", "propertyRef", "Lkotlin/reflect/KProperty1;", "Lexpo/modules/kotlin/records/formatters/PropertySelector$ActionBuilderForRecord;", "build", "Lexpo/modules/kotlin/records/formatters/Formatter;", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder<RecordType extends Record> {
        public static final int $stable = 8;
        private List<PropertySelector<RecordType, ?>> selectors = new ArrayList();

        public final List<PropertySelector<RecordType, ?>> getSelectors$expo_modules_core_release() {
            return this.selectors;
        }

        public final void setSelectors$expo_modules_core_release(List<PropertySelector<RecordType, ?>> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.selectors = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean property$lambda$0(KProperty1 kProperty1, KProperty1 property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Intrinsics.areEqual(property, kProperty1);
        }

        public final <PropertyType> PropertySelector<RecordType, PropertyType>.ActionBuilder<PropertyType> property(final KProperty1<RecordType, ? extends PropertyType> propertyRef) {
            Intrinsics.checkNotNullParameter(propertyRef, "propertyRef");
            PropertySelector<RecordType, ?> propertySelector = new PropertySelector<>(new Function1() { // from class: expo.modules.kotlin.records.formatters.Formatter$Builder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(Formatter.Builder.property$lambda$0(propertyRef, (KProperty1) obj));
                }
            });
            this.selectors.add(propertySelector);
            return new PropertySelector.ActionBuilder<>();
        }

        /* JADX INFO: renamed from: property, reason: collision with other method in class */
        public final <PropertyType extends Record> PropertySelector<RecordType, PropertyType>.ActionBuilderForRecord<PropertyType> m14559property(final KProperty1<RecordType, ? extends PropertyType> propertyRef) {
            Intrinsics.checkNotNullParameter(propertyRef, "propertyRef");
            PropertySelector<RecordType, ?> propertySelector = new PropertySelector<>(new Function1() { // from class: expo.modules.kotlin.records.formatters.Formatter$Builder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(Formatter.Builder.property$lambda$1(propertyRef, (KProperty1) obj));
                }
            });
            this.selectors.add(propertySelector);
            return new PropertySelector.ActionBuilderForRecord<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean property$lambda$1(KProperty1 kProperty1, KProperty1 property) {
            Intrinsics.checkNotNullParameter(property, "property");
            return Intrinsics.areEqual(property.getName(), kProperty1.getName()) && Intrinsics.areEqual(property.getReturnType(), kProperty1.getReturnType());
        }

        public final Formatter<RecordType> build$expo_modules_core_release() {
            return new Formatter<>(this.selectors);
        }
    }

    public final FormattedRecord<RecordType> invoke(RecordType record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return new FormattedRecord<>(record, this);
    }

    public final FormattedRecord<RecordType> format(RecordType record) {
        Intrinsics.checkNotNullParameter(record, "record");
        return new FormattedRecord<>(record, this);
    }

    public final Function2<Record, Object, Object> getAction$expo_modules_core_release(KProperty1<Record, ?> property) {
        Object next;
        Intrinsics.checkNotNullParameter(property, "property");
        Iterator<T> it = this.selectors.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((PropertySelector) next).getSelector$expo_modules_core_release().invoke(property).booleanValue());
        PropertySelector propertySelector = (PropertySelector) next;
        return (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propertySelector != null ? propertySelector.getAction$expo_modules_core_release() : null, 2);
    }
}

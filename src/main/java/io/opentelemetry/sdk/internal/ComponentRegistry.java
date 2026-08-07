package io.opentelemetry.sdk.internal;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ComponentRegistry<V> {
    private final Function<InstrumentationScopeInfo, V> factory;
    private final Map<String, V> componentByName = new ConcurrentHashMap();
    private final Map<String, Map<String, V>> componentByNameAndVersion = new ConcurrentHashMap();
    private final Map<String, Map<String, V>> componentByNameAndSchema = new ConcurrentHashMap();
    private final Map<String, Map<String, Map<String, V>>> componentByNameVersionAndSchema = new ConcurrentHashMap();
    private final Object lock = new Object();
    private final Set<V> allComponents = Collections.newSetFromMap(new IdentityHashMap());

    public ComponentRegistry(Function<InstrumentationScopeInfo, V> function) {
        this.factory = function;
    }

    public V get(final String str, @Nullable final String str2, @Nullable String str3, final Attributes attributes) {
        if (str2 != null && str3 != null) {
            return this.componentByNameVersionAndSchema.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ComponentRegistry.lambda$get$0((String) obj);
                }
            }).computeIfAbsent(str2, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ComponentRegistry.lambda$get$1((String) obj);
                }
            }).computeIfAbsent(str3, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda2
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m14756lambda$get$2$ioopentelemetrysdkinternalComponentRegistry(str, str2, attributes, (String) obj);
                }
            });
        }
        if (str2 != null) {
            return this.componentByNameAndVersion.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda3
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ComponentRegistry.lambda$get$3((String) obj);
                }
            }).computeIfAbsent(str2, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m14757lambda$get$4$ioopentelemetrysdkinternalComponentRegistry(str, attributes, (String) obj);
                }
            });
        }
        if (str3 != null) {
            return this.componentByNameAndSchema.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ComponentRegistry.lambda$get$5((String) obj);
                }
            }).computeIfAbsent(str3, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda6
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f$0.m14758lambda$get$6$ioopentelemetrysdkinternalComponentRegistry(str, attributes, (String) obj);
                }
            });
        }
        return this.componentByName.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.sdk.internal.ComponentRegistry$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m14759lambda$get$7$ioopentelemetrysdkinternalComponentRegistry(attributes, (String) obj);
            }
        });
    }

    static /* synthetic */ Map lambda$get$0(String str) {
        return new ConcurrentHashMap();
    }

    static /* synthetic */ Map lambda$get$1(String str) {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: renamed from: lambda$get$2$io-opentelemetry-sdk-internal-ComponentRegistry, reason: not valid java name */
    /* synthetic */ Object m14756lambda$get$2$ioopentelemetrysdkinternalComponentRegistry(String str, String str2, Attributes attributes, String str3) {
        return buildComponent(InstrumentationScopeInfo.builder(str).setVersion(str2).setSchemaUrl(str3).setAttributes(attributes).build());
    }

    static /* synthetic */ Map lambda$get$3(String str) {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: renamed from: lambda$get$4$io-opentelemetry-sdk-internal-ComponentRegistry, reason: not valid java name */
    /* synthetic */ Object m14757lambda$get$4$ioopentelemetrysdkinternalComponentRegistry(String str, Attributes attributes, String str2) {
        return buildComponent(InstrumentationScopeInfo.builder(str).setVersion(str2).setAttributes(attributes).build());
    }

    static /* synthetic */ Map lambda$get$5(String str) {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: renamed from: lambda$get$6$io-opentelemetry-sdk-internal-ComponentRegistry, reason: not valid java name */
    /* synthetic */ Object m14758lambda$get$6$ioopentelemetrysdkinternalComponentRegistry(String str, Attributes attributes, String str2) {
        return buildComponent(InstrumentationScopeInfo.builder(str).setSchemaUrl(str2).setAttributes(attributes).build());
    }

    /* JADX INFO: renamed from: lambda$get$7$io-opentelemetry-sdk-internal-ComponentRegistry, reason: not valid java name */
    /* synthetic */ Object m14759lambda$get$7$ioopentelemetrysdkinternalComponentRegistry(Attributes attributes, String str) {
        return buildComponent(InstrumentationScopeInfo.builder(str).setAttributes(attributes).build());
    }

    private V buildComponent(InstrumentationScopeInfo instrumentationScopeInfo) {
        V vApply = this.factory.apply(instrumentationScopeInfo);
        synchronized (this.lock) {
            this.allComponents.add(vApply);
        }
        return vApply;
    }

    public Collection<V> getComponents() {
        Collection<V> collectionUnmodifiableCollection;
        synchronized (this.lock) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(this.allComponents));
        }
        return collectionUnmodifiableCollection;
    }
}

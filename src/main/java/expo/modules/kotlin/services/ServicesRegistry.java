package expo.modules.kotlin.services;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.AppContext;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ServicesRegistry.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00002\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tJ\u001c\u0010\u000f\u001a\u00020\u00002\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\u0012J\u0015\u0010\u000f\u001a\u00020\u0000\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\nH\u0086\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\u00002\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u0014\u001a\u00020\nJ\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u001c\u0010\u0014\u001a\u0004\u0018\u0001H\u0013\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\nH\u0086\b¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\n0\b8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/services/ServicesRegistry;", "", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "registry", "", "Ljava/lang/Class;", "Lexpo/modules/kotlin/services/Service;", "getRegistry$annotations", "()V", "getRegistry", "()Ljava/util/Map;", "register", "serviceClass", "serviceClasses", "", ExifInterface.GPS_DIRECTION_TRUE, NotificationCompat.CATEGORY_SERVICE, "getServiceInterfaces", "()Lexpo/modules/kotlin/services/Service;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServicesRegistry {
    public static final int $stable = 8;
    private final WeakReference<AppContext> appContextHolder;
    private final Map<Class<? extends Service>, Service> registry;

    public static /* synthetic */ void getRegistry$annotations() {
    }

    public ServicesRegistry(WeakReference<AppContext> appContextHolder) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        this.appContextHolder = appContextHolder;
        this.registry = new LinkedHashMap();
    }

    public final Map<Class<? extends Service>, Service> getRegistry() {
        return this.registry;
    }

    public final ServicesRegistry register(Class<? extends Service> serviceClass) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        AppContext appContext = this.appContextHolder.get();
        if (appContext == null) {
            throw new IllegalArgumentException("Cannot register a service to an invalid app context.".toString());
        }
        Service serviceConstruct = Service.INSTANCE.construct(serviceClass, appContext);
        Iterator<Class<? extends Service>> it = getServiceInterfaces(serviceConstruct).iterator();
        while (it.hasNext()) {
            this.registry.put(it.next(), serviceConstruct);
        }
        return this;
    }

    public final ServicesRegistry register(List<? extends Class<? extends Service>> serviceClasses) {
        Intrinsics.checkNotNullParameter(serviceClasses, "serviceClasses");
        Iterator<T> it = serviceClasses.iterator();
        while (it.hasNext()) {
            register((Class<? extends Service>) it.next());
        }
        return this;
    }

    public final /* synthetic */ <T extends Service> ServicesRegistry register() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return register(Service.class);
    }

    public final ServicesRegistry register(Service service) {
        Intrinsics.checkNotNullParameter(service, "service");
        Iterator<Class<? extends Service>> it = getServiceInterfaces(service).iterator();
        while (it.hasNext()) {
            this.registry.put(it.next(), service);
        }
        return this;
    }

    public final ServicesRegistry register(Class<? extends Service> serviceClass, Service service) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Intrinsics.checkNotNullParameter(service, "service");
        this.registry.put(serviceClass, service);
        return this;
    }

    private final List<Class<? extends Service>> getServiceInterfaces(Service service) {
        Class<?> cls = service.getClass();
        Annotation[] annotationsByType = cls.getAnnotationsByType(ServiceInterface.class);
        Intrinsics.checkNotNullExpressionValue(annotationsByType, "getAnnotationsByType(...)");
        Annotation[] annotationArr = annotationsByType;
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(((ServiceInterface) annotation).clazz());
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        return arrayList2 == null ? CollectionsKt.listOf(cls) : arrayList2;
    }

    public final /* synthetic */ <T extends Service> T service() {
        Map<Class<? extends Service>, Service> registry = getRegistry();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Service service = registry.get(Service.class);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) service;
    }
}

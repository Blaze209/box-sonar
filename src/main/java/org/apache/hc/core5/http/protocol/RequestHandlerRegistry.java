package org.apache.hc.core5.http.protocol;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.MisdirectedRequestException;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RequestHandlerRegistry<T> implements HttpRequestMapper<T> {
    private static final String IP_127_0_0_1 = "127.0.0.1";
    private static final String LOCALHOST = "localhost";
    private final String canonicalHostName;
    private final LookupRegistry<T> primary;
    private final Supplier<LookupRegistry<T>> registrySupplier;
    private final ConcurrentMap<String, LookupRegistry<T>> virtualMap;

    public RequestHandlerRegistry(String str, Supplier<LookupRegistry<T>> supplier) {
        this.canonicalHostName = TextUtils.toLowerCase((String) Args.notNull(str, "Canonical hostname"));
        supplier = supplier == null ? new Supplier() { // from class: org.apache.hc.core5.http.protocol.RequestHandlerRegistry$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return new UriPatternMatcher();
            }
        } : supplier;
        this.registrySupplier = supplier;
        this.primary = supplier.get();
        this.virtualMap = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> LookupRegistry<T> newMatcher(UriPatternType uriPatternType) {
        if (uriPatternType == null) {
            return new UriPatternMatcher();
        }
        int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[uriPatternType.ordinal()];
        if (i == 1) {
            return new UriRegexMatcher();
        }
        if (i == 2) {
            return new UriPatternOrderedMatcher();
        }
        return new UriPatternMatcher();
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.protocol.RequestHandlerRegistry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType;

        static {
            int[] iArr = new int[UriPatternType.values().length];
            $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType = iArr;
            try {
                iArr[UriPatternType.REGEX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[UriPatternType.URI_PATTERN_IN_ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[UriPatternType.URI_PATTERN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RequestHandlerRegistry(String str, final UriPatternType uriPatternType) {
        this(str, new Supplier() { // from class: org.apache.hc.core5.http.protocol.RequestHandlerRegistry$$ExternalSyntheticLambda1
            @Override // org.apache.hc.core5.function.Supplier
            public final Object get() {
                return RequestHandlerRegistry.newMatcher(uriPatternType);
            }
        });
    }

    public RequestHandlerRegistry(UriPatternType uriPatternType) {
        this("localhost", uriPatternType);
    }

    public RequestHandlerRegistry() {
        this("localhost", UriPatternType.URI_PATTERN);
    }

    private LookupRegistry<T> getPatternMatcher(String str) {
        if (str == null || str.equals(this.canonicalHostName) || str.equals("localhost") || str.equals(IP_127_0_0_1)) {
            return this.primary;
        }
        return this.virtualMap.get(str);
    }

    @Override // org.apache.hc.core5.http.HttpRequestMapper
    public T resolve(HttpRequest httpRequest, HttpContext httpContext) throws MisdirectedRequestException {
        URIAuthority authority = httpRequest.getAuthority();
        LookupRegistry<T> patternMatcher = getPatternMatcher(authority != null ? TextUtils.toLowerCase(authority.getHostName()) : null);
        if (patternMatcher == null) {
            throw new MisdirectedRequestException("Not authoritative");
        }
        String path = httpRequest.getPath();
        int iIndexOf = path.indexOf(63);
        if (iIndexOf != -1) {
            path = path.substring(0, iIndexOf);
        }
        return patternMatcher.lookup(path);
    }

    public void register(String str, String str2, T t) {
        LookupRegistry<T> lookupRegistryPutIfAbsent;
        Args.notBlank(str2, "URI pattern");
        if (t == null) {
            return;
        }
        String lowerCase = TextUtils.toLowerCase(str);
        if (str == null || str.equals(this.canonicalHostName) || str.equals("localhost")) {
            this.primary.register(str2, t);
            return;
        }
        LookupRegistry<T> lookupRegistry = this.virtualMap.get(lowerCase);
        if (lookupRegistry == null && (lookupRegistryPutIfAbsent = this.virtualMap.putIfAbsent(lowerCase, (lookupRegistry = this.registrySupplier.get()))) != null) {
            lookupRegistry = lookupRegistryPutIfAbsent;
        }
        lookupRegistry.register(str2, t);
    }
}

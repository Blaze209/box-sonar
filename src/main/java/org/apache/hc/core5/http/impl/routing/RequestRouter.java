package org.apache.hc.core5.http.impl.routing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestMapper;
import org.apache.hc.core5.http.MisdirectedRequestException;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.UriPatternType;
import org.apache.hc.core5.net.URIAuthority;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class RequestRouter<T> implements HttpRequestMapper<T> {
    private final BiFunction<String, URIAuthority, URIAuthority> authorityResolver;
    private final Function<URIAuthority, Function<String, T>> authorityRouter;
    private final HttpRequestMapper<T> downstream;
    public static final URIAuthority LOCAL_AUTHORITY = new URIAuthority("localhost");
    public static final BiFunction<String, URIAuthority, URIAuthority> LOCAL_AUTHORITY_RESOLVER = new BiFunction() { // from class: org.apache.hc.core5.http.impl.routing.RequestRouter$$ExternalSyntheticLambda0
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return RequestRouter.LOCAL_AUTHORITY;
        }
    };
    public static final BiFunction<String, URIAuthority, URIAuthority> IGNORE_PORT_AUTHORITY_RESOLVER = new BiFunction() { // from class: org.apache.hc.core5.http.impl.routing.RequestRouter$$ExternalSyntheticLambda1
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return RequestRouter.lambda$static$4((String) obj, (URIAuthority) obj2);
        }
    };

    public static final class Entry<T> {
        public final PathRoute<String, T> route;
        public final URIAuthority uriAuthority;

        public Entry(URIAuthority uRIAuthority, String str, T t) {
            this.uriAuthority = uRIAuthority;
            this.route = new PathRoute<>(str, t);
        }

        public Entry(String str, String str2, T t) {
            this(new URIAuthority(str), str2, t);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Entry(String str, T t) {
            this((URIAuthority) null, str, t);
        }

        public String toString() {
            return this.uriAuthority + "/" + this.route;
        }
    }

    static class SingleAuthorityResolver<T> implements Function<URIAuthority, T> {
        private final T router;
        private final URIAuthority singleAuthority;

        SingleAuthorityResolver(URIAuthority uRIAuthority, T t) {
            this.singleAuthority = uRIAuthority;
            this.router = t;
        }

        @Override // java.util.function.Function
        public T apply(URIAuthority uRIAuthority) {
            if (this.singleAuthority.equals(uRIAuthority)) {
                return this.router;
            }
            return null;
        }

        public String toString() {
            return this.singleAuthority + " " + this.router;
        }
    }

    static class NoAuthorityResolver<T> implements Function<URIAuthority, T> {
        @Override // java.util.function.Function
        public T apply(URIAuthority uRIAuthority) {
            return null;
        }

        NoAuthorityResolver() {
        }
    }

    public static <T> RequestRouter<T> create(final URIAuthority uRIAuthority, final UriPatternType uriPatternType, List<Entry<T>> list, BiFunction<String, URIAuthority, URIAuthority> biFunction, HttpRequestMapper<T> httpRequestMapper) {
        Function singleAuthorityResolver;
        Function noAuthorityResolver;
        final Map map = (Map) list.stream().collect(Collectors.groupingBy(new Function() { // from class: org.apache.hc.core5.http.impl.routing.RequestRouter$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RequestRouter.lambda$create$0(uRIAuthority, (RequestRouter.Entry) obj);
            }
        }, Collectors.mapping(new Function() { // from class: org.apache.hc.core5.http.impl.routing.RequestRouter$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((RequestRouter.Entry) obj).route;
            }
        }, Collectors.collectingAndThen(Collectors.toList(), new Function() { // from class: org.apache.hc.core5.http.impl.routing.RequestRouter$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return RequestRouter.lambda$create$2(uriPatternType, (List) obj);
            }
        }))));
        if (map.isEmpty()) {
            noAuthorityResolver = new NoAuthorityResolver();
        } else {
            if (map.size() == 1) {
                Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                singleAuthorityResolver = new SingleAuthorityResolver((URIAuthority) entry.getKey(), entry.getValue());
            } else {
                map.getClass();
                singleAuthorityResolver = new Function() { // from class: org.apache.hc.core5.http.impl.routing.RequestRouter$$ExternalSyntheticLambda5
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return (Function) map.get((URIAuthority) obj);
                    }
                };
            }
            noAuthorityResolver = singleAuthorityResolver;
        }
        return new RequestRouter<>(noAuthorityResolver, biFunction, httpRequestMapper);
    }

    static /* synthetic */ URIAuthority lambda$create$0(URIAuthority uRIAuthority, Entry entry) {
        if (entry.uriAuthority != null) {
            return entry.uriAuthority;
        }
        return uRIAuthority != null ? uRIAuthority : LOCAL_AUTHORITY;
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.routing.RequestRouter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType;

        static {
            int[] iArr = new int[UriPatternType.values().length];
            $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType = iArr;
            try {
                iArr[UriPatternType.URI_PATTERN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[UriPatternType.URI_PATTERN_IN_ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[UriPatternType.REGEX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static /* synthetic */ Function lambda$create$2(UriPatternType uriPatternType, List list) {
        int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$protocol$UriPatternType[uriPatternType.ordinal()];
        if (i == 1) {
            return UriPathRouter.bestMatch(list);
        }
        if (i == 2) {
            return UriPathRouter.ordered(list);
        }
        if (i == 3) {
            return UriPathRouter.regEx(list);
        }
        throw new IllegalStateException("Unexpected pattern type: " + uriPatternType);
    }

    public static <T> Builder<T> builder(UriPatternType uriPatternType) {
        return new Builder<>(uriPatternType);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>(UriPatternType.URI_PATTERN);
    }

    static /* synthetic */ URIAuthority lambda$static$4(String str, URIAuthority uRIAuthority) {
        return (uRIAuthority == null || uRIAuthority.getPort() == -1) ? uRIAuthority : new URIAuthority(uRIAuthority.getHostName(), -1);
    }

    RequestRouter(Function<URIAuthority, Function<String, T>> function, BiFunction<String, URIAuthority, URIAuthority> biFunction, HttpRequestMapper<T> httpRequestMapper) {
        this.authorityRouter = function;
        this.authorityResolver = biFunction;
        this.downstream = httpRequestMapper;
    }

    @Override // org.apache.hc.core5.http.HttpRequestMapper
    public T resolve(HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        BiFunction<String, URIAuthority, URIAuthority> biFunction = this.authorityResolver;
        URIAuthority uRIAuthorityApply = biFunction != null ? biFunction.apply(httpRequest.getScheme(), httpRequest.getAuthority()) : httpRequest.getAuthority();
        Function<String, T> functionApply = uRIAuthorityApply != null ? this.authorityRouter.apply(uRIAuthorityApply) : null;
        if (functionApply == null) {
            HttpRequestMapper<T> httpRequestMapper = this.downstream;
            if (httpRequestMapper != null) {
                return httpRequestMapper.resolve(httpRequest, httpContext);
            }
            throw new MisdirectedRequestException("Not authoritative");
        }
        String path = httpRequest.getPath();
        int iIndexOf = path.indexOf(63);
        if (iIndexOf != -1) {
            path = path.substring(0, iIndexOf);
        }
        return functionApply.apply(path);
    }

    public static class Builder<T> {
        private BiFunction<String, URIAuthority, URIAuthority> authorityResolver;
        private HttpRequestMapper<T> downstream;
        private final List<Entry<T>> handlerEntries;
        private final UriPatternType patternType;

        Builder(UriPatternType uriPatternType) {
            this.patternType = uriPatternType == null ? UriPatternType.URI_PATTERN : uriPatternType;
            this.handlerEntries = new ArrayList();
        }

        public Builder<T> addRoute(URIAuthority uRIAuthority, String str, T t) {
            Args.notNull(uRIAuthority, "URI authority");
            Args.notBlank(str, "URI path pattern");
            Args.notNull(t, "Handler");
            this.handlerEntries.add(new Entry<>(uRIAuthority, str, t));
            return this;
        }

        public Builder<T> addRoute(String str, String str2, T t) {
            Args.notBlank(str, "Hostname");
            Args.notBlank(str2, "URI path pattern");
            Args.notNull(t, "Handler");
            this.handlerEntries.add(new Entry<>(str, str2, t));
            return this;
        }

        public Builder<T> resolveAuthority(BiFunction<String, URIAuthority, URIAuthority> biFunction) {
            this.authorityResolver = biFunction;
            return this;
        }

        public Builder<T> downstream(HttpRequestMapper<T> httpRequestMapper) {
            this.downstream = httpRequestMapper;
            return this;
        }

        public RequestRouter<T> build() {
            return RequestRouter.create(null, this.patternType, this.handlerEntries, this.authorityResolver, this.downstream);
        }
    }
}

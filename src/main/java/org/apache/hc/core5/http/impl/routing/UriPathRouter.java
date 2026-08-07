package org.apache.hc.core5.http.impl.routing;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes5.dex */
final class UriPathRouter<P, T> implements Function<String, T> {
    private static final PathPatternMatcher PATH_PATTERN_MATCHER = PathPatternMatcher.INSTANCE;
    private final BiFunction<String, List<PathRoute<P, T>>, T> pathRouter;
    private final List<PathRoute<P, T>> routes;

    static /* synthetic */ String lambda$bestMatch$1(String str) {
        return str;
    }

    static /* synthetic */ String lambda$ordered$2(String str) {
        return str;
    }

    UriPathRouter(final Function<String, P> function, BiFunction<String, List<PathRoute<P, T>>, T> biFunction, List<PathRoute<String, T>> list) {
        this.pathRouter = biFunction;
        this.routes = Collections.unmodifiableList((List) list.stream().map(new Function() { // from class: org.apache.hc.core5.http.impl.routing.UriPathRouter$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UriPathRouter.lambda$new$0(function, (PathRoute) obj);
            }
        }).collect(Collectors.toList()));
    }

    static /* synthetic */ PathRoute lambda$new$0(Function function, PathRoute pathRoute) {
        return new PathRoute(function.apply(pathRoute.pattern), pathRoute.handler);
    }

    @Override // java.util.function.Function
    public T apply(String str) {
        return this.pathRouter.apply(str, this.routes);
    }

    public String toString() {
        return this.routes.toString();
    }

    static <T> UriPathRouter<?, T> bestMatch(List<PathRoute<String, T>> list) {
        return new UriPathRouter<>(new Function() { // from class: org.apache.hc.core5.http.impl.routing.UriPathRouter$$ExternalSyntheticLambda3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UriPathRouter.lambda$bestMatch$1((String) obj);
            }
        }, new BestMatcher(), list);
    }

    static <T> UriPathRouter<?, T> ordered(List<PathRoute<String, T>> list) {
        return new UriPathRouter<>(new Function() { // from class: org.apache.hc.core5.http.impl.routing.UriPathRouter$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return UriPathRouter.lambda$ordered$2((String) obj);
            }
        }, new OrderedMatcher(), list);
    }

    static <T> UriPathRouter<?, T> regEx(List<PathRoute<String, T>> list) {
        return new UriPathRouter<>(new Function() { // from class: org.apache.hc.core5.http.impl.routing.UriPathRouter$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Pattern.compile((String) obj);
            }
        }, new RegexMatcher(), list);
    }

    static final class BestMatcher<T> implements BiFunction<String, List<PathRoute<String, T>>, T> {
        BestMatcher() {
        }

        @Override // java.util.function.BiFunction
        public T apply(String str, List<PathRoute<String, T>> list) {
            PathRoute<String, T> pathRoute = null;
            for (PathRoute<String, T> pathRoute2 : list) {
                if (!pathRoute2.pattern.equals(str)) {
                    if (UriPathRouter.PATH_PATTERN_MATCHER.match(pathRoute2.pattern, str) && (pathRoute == null || UriPathRouter.PATH_PATTERN_MATCHER.isBetter(pathRoute2.pattern, pathRoute.pattern))) {
                        pathRoute = pathRoute2;
                    }
                } else {
                    return pathRoute2.handler;
                }
            }
            if (pathRoute != null) {
                return pathRoute.handler;
            }
            return null;
        }
    }

    static final class OrderedMatcher<T> implements BiFunction<String, List<PathRoute<String, T>>, T> {
        OrderedMatcher() {
        }

        @Override // java.util.function.BiFunction
        public T apply(String str, List<PathRoute<String, T>> list) {
            for (PathRoute<String, T> pathRoute : list) {
                String str2 = pathRoute.pattern;
                if (!str.equals(str2)) {
                    if (UriPathRouter.PATH_PATTERN_MATCHER.match(str2, str)) {
                        return pathRoute.handler;
                    }
                } else {
                    return pathRoute.handler;
                }
            }
            return null;
        }
    }

    static final class RegexMatcher<T> implements BiFunction<String, List<PathRoute<Pattern, T>>, T> {
        RegexMatcher() {
        }

        @Override // java.util.function.BiFunction
        public T apply(String str, List<PathRoute<Pattern, T>> list) {
            for (PathRoute<Pattern, T> pathRoute : list) {
                if (pathRoute.pattern.matcher(str).matches()) {
                    return pathRoute.handler;
                }
            }
            return null;
        }
    }
}

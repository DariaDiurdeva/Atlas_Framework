package element;

import io.qameta.atlas.core.api.MethodExtension;
import io.qameta.atlas.core.internal.Configuration;
import io.qameta.atlas.core.util.MethodInfo;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class DefaultMethodExtension implements MethodExtension {

    @Override
    public boolean test(final Method method) {
        return method.isDefault();
    }

    @Override
    public Object invoke(final Object proxy, final MethodInfo methodInfo, final Configuration config) throws Throwable {
        final Class<?> declaringClass = methodInfo.getMethod().getDeclaringClass();
        return MethodHandles
                .lookup()
                .findSpecial(
                        declaringClass,
                        methodInfo.getMethod().getName(),
                        MethodType.methodType(
                                methodInfo.getMethod().getReturnType(),
                                methodInfo.getMethod().getParameterTypes()),
                        declaringClass)
                .bindTo(proxy)
                .invokeWithArguments(methodInfo.getArgs());
    }
}

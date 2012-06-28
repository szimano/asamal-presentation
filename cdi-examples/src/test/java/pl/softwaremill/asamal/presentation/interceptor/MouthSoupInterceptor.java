package pl.softwaremill.asamal.presentation.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.List;

@MouthSoap @Interceptor
public class MouthSoupInterceptor {

    private final static List<String> BAD_WORDS = Arrays.asList("motyla noga",
            "kurka wodna", ".net");

    private final static String CENSOR = "$%&#!!";

    @AroundInvoke
    public Object soapThatMouth(InvocationContext ctx) throws Exception {
        // check all string parameters and censor if needed
        for (int i = 0; i < ctx.getMethod().getParameterTypes().length; i++) {
            if (ctx.getMethod().getParameterTypes()[i].equals(String.class)) {
                if (BAD_WORDS.contains(ctx.getParameters()[i])) {
                    ctx.getParameters()[i] = CENSOR;
                }
            }
        }

        return ctx.proceed();
    }
}

package com.github.iweinzierl.android.logging;

import org.easymock.internal.ReflectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class AndroidLoggerTest {

    @Test
    public void testBuildMessage() throws Exception {
        AndroidLogger logger = new AndroidLogger(null, "--test--", "AndroidLoggerTest");

        Method buildMsg = ReflectionUtils.getDeclaredMethod(AndroidLogger.class, "buildMessage",
                new Class[]{String.class, Object[].class});
        buildMsg.setAccessible(true);

        String message = (String) buildMsg.invoke(logger, "Foo bar", null);

        Assert.assertEquals("AndroidLoggerTest -> Foo bar", message);
    }

    @Test
    public void testBuildMessageWithArgs() throws Exception {
        AndroidLogger logger = new AndroidLogger(null, "--test--", "AndroidLoggerTest");

        Method buildMsg = ReflectionUtils.getDeclaredMethod(AndroidLogger.class, "buildMessage",
                new Class[]{String.class, Object[].class});
        buildMsg.setAccessible(true);

        String message = (String) buildMsg.invoke(logger, "Foo {} with {}", new Object[]{"bar", "args"});

        Assert.assertEquals("AndroidLoggerTest -> Foo bar with args", message);
    }
}

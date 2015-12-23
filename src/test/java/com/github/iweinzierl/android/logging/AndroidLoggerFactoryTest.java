package com.github.iweinzierl.android.logging;

import java.lang.reflect.Method;

import org.easymock.internal.ReflectionUtils;

import org.junit.Assert;
import org.junit.Test;

public class AndroidLoggerFactoryTest {

    @Test
    public void testSplitName() throws Exception {
        AndroidLoggerFactory factory = AndroidLoggerFactory.getInstance();
        Method stripName = ReflectionUtils.getDeclaredMethod(AndroidLoggerFactory.class, "stripName",
                new Class[] {String.class});
        stripName.setAccessible(true);

        String easyName = (String) stripName.invoke(factory, "AndroidLoggerFactoryTest");
        Assert.assertEquals("AndroidLoggerFactoryTest", easyName);

        String complexName = (String) stripName.invoke(factory, "com.github.iweinzierl.android.logging.AndroidLoggerFactoryTest");
        Assert.assertEquals("AndroidLoggerFactoryTest", complexName);
    }
}

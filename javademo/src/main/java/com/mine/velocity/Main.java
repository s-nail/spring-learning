package com.mine.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.Properties;


/**
 * @author mingxin
 */
public class Main {

    public static void main(String[] args) {
       /* Main main = new Main();
        main.useVelocity();*/
        String str="总会在某一个回眸的时刻醉了流年，濡湿了柔软的心.总会有某一个回眸的时刻醉了流年，濡湿了柔软的心";
        str=str.replaceAll("总会在.+?流年", "总会有某一个回眸的时刻醉了流年");
        System.out.println(str);
    }

    public void useVelocityEngine() {
        try {
            VelocityEngine ve = new VelocityEngine();
            ve.init(getDefaultProp());
            VelocityContext context = new VelocityContext();
            context.put("hello", "Hello World!");
            StringWriter w = new StringWriter();
            Template t = ve.getTemplate("foo.vm");
            t.merge(context, w);
            System.out.println("template:" + w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void useVelocity() {
        try {
            Velocity.init(getDefaultProp());
            VelocityContext context = new VelocityContext();
            context.put("hello", "Hello World!");
            StringWriter w = new StringWriter();
            Template t = Velocity.getTemplate("foo.vm");
            t.merge(context, w);
            System.out.println("template:" + w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getDefaultProp() {
        Properties prop = new Properties();
        prop.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        prop.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        return prop;
    }
}
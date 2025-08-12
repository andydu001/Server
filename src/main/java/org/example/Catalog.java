package org.example;

import jakarta.servlet.ServletException;

import jakarta.servlet.descriptor.JspConfigDescriptor;

import jakarta.servlet.descriptor.JspPropertyGroupDescriptor;

import jakarta.servlet.descriptor.TaglibDescriptor;

import org.apache.catalina.Context;

import org.apache.catalina.LifecycleException;

import org.apache.catalina.loader.WebappLoader;

import org.apache.catalina.startup.ContextConfig;

import org.apache.catalina.startup.Tomcat;

import org.apache.catalina.webresources.StandardRoot;

import org.apache.tomcat.JarScanType;

import org.apache.tomcat.JarScanner;

import org.apache.tomcat.util.descriptor.web.*;

import org.springframework.boot.web.embedded.tomcat.TomcatReactiveWebServerFactory;

import org.springframework.boot.web.server.Ssl;

import java.io.File;

import java.net.InetAddress;

import java.net.UnknownHostException;

import java.util.ArrayList;

import java.util.Collection;

import java.util.function.Consumer;

public class Catalog extends TomcatReactiveWebServerFactory {
    public Catalog() throws LifecycleException, UnknownHostException, ServletException {


        setBaseDirectory(new File("C:\\Users"));

        addContextLifecycleListeners(new ContextConfig());

        Tomcat tomcat = new Tomcat();

        tomcat.getConnector().setSecure(true);

        Context context = tomcat.addContext("/J", "C:\\Users");

        SERC serc = new SERC();

        serc.onStartup(null,context.getServletContext());

        context.addWelcomeFile(Context.ADD_WELCOME_FILE_EVENT);

        context.setReloadable(true);

        context.setDisplayName("Andy");

        context.setStartStopThreads(2);

        context.setConfigured(true);

        context.setName("DOSE");

        context.setLogEffectiveWebXml(true);

        context.setXmlValidation(true);

        context.backgroundProcess();

        context.setLoader(new WebappLoader());

        StandardRoot standardRoot = new StandardRoot();

        setAddress(InetAddress.getLocalHost());

        standardRoot.setContext(context);

        standardRoot.start();

        setSsl(new Ssl());

        context.setResources( standardRoot);

        context.setXmlBlockExternal(false);

        Collection<JspPropertyGroupDescriptor> jspPropertyGroupDescriptors = new ArrayList<>();

        jspPropertyGroupDescriptors.add(new PropertyJs());

        Collection<TaglibDescriptor> taglibDescriptors = new ArrayList<>();

        taglibDescriptors.add(new Tag());

        context.setJspConfigDescriptor(new JspConfigDescriptor() {
            @Override
            public Collection<TaglibDescriptor> getTaglibs() {
                return taglibDescriptors;
            }

            @Override
            public Collection<JspPropertyGroupDescriptor> getJspPropertyGroups() {
                return jspPropertyGroupDescriptors;
            }
        });


        context.getServletContext().getJspConfigDescriptor().getTaglibs().iterator().forEachRemaining(new Consumer<TaglibDescriptor>() {
            @Override
            public void accept(TaglibDescriptor taglibDescriptor) {

            }
        });

        context.getJspConfigDescriptor().getTaglibs().iterator().forEachRemaining(new Consumer<TaglibDescriptor>() {
            @Override
            public void accept(TaglibDescriptor taglibDescriptor) {


            }
        });

        FragmentJarScannerCallback fragmentJarScannerCallback =  new FragmentJarScannerCallback(new WebXmlParser(true,true,false),true, true);

        JarScanner scanner = context.getJarScanner();

        scanner.scan(JarScanType.PLUGGABILITY, context.getServletContext(), fragmentJarScannerCallback);


        fragmentJarScannerCallback.getFragments().values().iterator().forEachRemaining(new Consumer<WebXml>() {
            @Override
            public void accept(WebXml webXml) {



            }
        });

        ErrorPage errorPage = new ErrorPage();

        errorPage.setErrorCode(404);

        errorPage.setLocation("/Andy.html");

        context.addErrorPage(errorPage);

        new Confi(context);

        getTomcatWebServer(tomcat).start();


    }
}

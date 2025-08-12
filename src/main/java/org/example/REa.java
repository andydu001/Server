package org.example;

import jakarta.servlet.ServletContext;

import org.apache.catalina.Context;

import org.apache.catalina.LifecycleException;

import org.apache.catalina.LifecycleListener;

import org.apache.catalina.Service;

import org.apache.catalina.connector.Connector;

import org.apache.catalina.connector.Request;

import org.apache.catalina.connector.Response;

import org.apache.catalina.loader.WebappLoader;

import org.apache.catalina.realm.NestedCredentialHandler;

import org.apache.catalina.session.StandardManager;

import org.apache.catalina.startup.Catalina;

import org.apache.catalina.startup.Tomcat;

import org.apache.juli.logging.LogFactory;

import org.apache.tomcat.JarScanType;

import org.apache.tomcat.JarScanner;

import org.apache.tomcat.util.descriptor.web.*;

import org.springframework.boot.ssl.SslBundle;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;

import org.springframework.boot.web.server.Compression;

import org.springframework.boot.web.server.Http2;

import org.springframework.boot.web.server.MimeMappings;

import org.springframework.boot.web.server.Ssl;

import org.springframework.boot.web.servlet.server.Session;

import javax.swing.plaf.metal.MetalLabelUI;

import java.io.File;

import java.io.IOException;

import java.net.InetAddress;

import java.net.UnknownHostException;

import java.time.Duration;

import java.util.Arrays;

import java.util.function.Consumer;

public class REa extends TomcatServletWebServerFactory {
    private String CONTEXT_PATH;
    private String CODE_BASE;

    public REa(String path, String base, String[] args) throws UnknownHostException {

        this.CONTEXT_PATH = path;

        this.CODE_BASE = base;

        Tomcat tomcat = getTomcatWebServer(new Tomcat()).getTomcat();

        addMimeMappings(new MimeMappings());

        getTomcatWebServer(new Tomcat()).start();

        tomcat.getEngine().backgroundProcess();

        tomcat.getHost().backgroundProcess();

        tomcat.getHost().getLogger().warn("This may not work");

        tomcat.getHost().getLogger().debug("JArs", new Throwable());

        setDisplayName("ANDY.SERVER");

        Session session = new Session();

        session.setPersistent(true);

        session.setStoreDir(new File("C:\\Users"));

        session.setTimeout(Duration.ofHours(1L));




        setSession(session);

        setServerHeader("ANDY");

        setDocumentRoot(new File("C:\\Users"));

        Ssl ssl = new Ssl();

        ssl.setEnabled(true);

        ssl.setClientAuth(Ssl.ClientAuth.NONE);

        ssl.setKeyPassword("0000000");

        ssl.setBundle("SslBundle");

        ssl.setProtocol(SslBundle.DEFAULT_PROTOCOL);

        setSsl(ssl);

        Compression compression = new Compression();

        compression.setEnabled(true);

        setCompression(compression);

        setAddress(InetAddress.getLocalHost());

        Http2 http2 = new Http2();

        http2.setEnabled(true);

        setHttp2(http2);

        setUseApr(true);

    }

    @Override
    protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
        // tomcat.setAddDefaultWebXmlToWebapp(true);

        //add child containers to this path
        try {
            tomcat.init();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }


        tomcat.addContext(tomcat.getHost(), "P",tomcat.getServer().getCatalinaHome().getAbsolutePath());

        Arrays.stream(tomcat.getServer().findServices()).iterator().forEachRemaining(new Consumer<Service>() {
            @Override
            public void accept(Service service) {
                System.out.println("ZOZ\t"+service.getName());
            }
        });


        Arrays.stream(tomcat.getServer().findLifecycleListeners()).iterator().forEachRemaining(new Consumer<LifecycleListener>() {
            @Override
            public void accept(LifecycleListener lifecycleListener) {
                System.out.println("ZOZ\t"+lifecycleListener);
            }
        });


        tomcat.getHost().setCreateDirs(true);

        tomcat.getEngine().getService().getMapper().addWelcomeFile("Anfu","C:\\Users\\andyd\\IdeaProjects\\JEEF\\tomcat.8080\\work\\Tomcat\\localhost\\ROOT\\G","2.0","welcome");

        Context context2  =  tomcat.addContext("/T","C:\\Users\\andyd\\IdeaProjects\\JEEF\\tomcat.8080\\work\\Tomcat\\localhost\\G");

        context2.addParameter("AS","D");

        context2.setName("LO");


        ServletContext servletContext =  context2.getServletContext();

        Context context = tomcat.addContext("/F","C:\\Users");


        context.setManager(new StandardManager());

        context.getManager().backgroundProcess();

        ErrorPage errorPage = new ErrorPage();

        errorPage.setErrorCode(404);

        errorPage.setLocation("/Andy.html");

        context.addErrorPage(errorPage);

        context.setMetadataComplete(true);

        context.setName("MAster");

        context.setCookies(true);

        context.setReloadable(true);

        context.setDisplayName("Ganster");

        context.setXmlValidation(true);

        context.setSessionTimeout(60);

        JarScanner scanner = context2.getJarScanner();



        context2.setLoader(new WebappLoader());

        FragmentJarScannerCallback fragmentJarScannerCallback =  new FragmentJarScannerCallback(new WebXmlParser(true,false,false),true, false);

        scanner.scan(JarScanType.PLUGGABILITY,  servletContext, fragmentJarScannerCallback);

        context2.setConfigured(true);

        tomcat.addUser("AA","0000");


        try {
            fragmentJarScannerCallback.scan(new File("C:\\Users\\andyd\\IdeaProjects\\JEEF\\tomcat.8080\\work\\Tomcat\\localhost\\G\\myjar.jar"),null,false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fragmentJarScannerCallback.getFragments().values().iterator().forEachRemaining(new Consumer<WebXml>() {
            @Override
            public void accept(WebXml webXml) {

                webXml.setWebappJar(true);

                webXml.setJarName("SA");

                ServletDef servletDef = new ServletDef();

                servletDef.setSmallIcon("😊😊");

                servletDef.setRunAs("andy.html");

            }
        });

        org.apache.catalina.Session session = context.getManager().createSession("createSession");

        tomcat.addWebapp("/S", "C:\\Users");//.getServletContext().addServlet("SED",new JspServlet());

        Connector connector = new Connector();

        org.apache.coyote.Request request = new org.apache.coyote.Request();

        request.setNote(1,"Get it to work");


        Response response = new Response(new org.apache.coyote.Response());

        context2.logAccess(new Request(connector, request),response,3,true);

        LoginConfig loginConfig = new LoginConfig();


        loginConfig.setLoginPage("/EWAndy.html");

        EBAse memoryRealm = new EBAse(LogFactory.getLog("AndyADS"));

        memoryRealm.setPathname("C:\\Users\\andyd\\IdeaProjects\\JEEF\\aanddy.txt");

        memoryRealm.setValidate(true);

        memoryRealm.setCredentialHandler(new NestedCredentialHandler());



        try {
            memoryRealm.preDeregister();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        context2.addWelcomeFile("Welcome");

        memoryRealm.setContainer(context2);

        try {
            memoryRealm.init();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

        try {
            memoryRealm.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

        try {
            memoryRealm.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }


        tomcat.getEngine().addPropertyChangeListener(new MetalLabelUI());

        context2.setRealm(memoryRealm);

        context2.setLoginConfig(loginConfig);

        tomcat.getServer().addService(tomcat.getService());

        Catalina catalina = new Catalina();

        catalina.setServer(tomcat.getServer());

        catalina.start();

        Confi contextConfig = new Confi(context2);

        context2.addLifecycleListener(contextConfig);

        contextConfig.setDefaultWebXml("tomcat.8080/conf/WWw.html");

        context2.addLifecycleListener(tomcat.getDefaultWebXmlListener());

        tomcat.setAddDefaultWebXmlToWebapp(true);

        tomcat.getServer().setCatalina(catalina);

        context2.reload();

        context2.setManager(new StandardManager());

        try {
            context2.getManager().load();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }


        return super.getTomcatWebServer(tomcat);
    }

    public String getCONTEXT_PATH() {
        return CONTEXT_PATH;
    }

    public void setCONTEXT_PATH(String CONTEXT_PATH) {
        this.CONTEXT_PATH = CONTEXT_PATH;
    }

    public String getCODE_BASE() {
        return CODE_BASE;
    }

    public void setCODE_BASE(String CODE_BASE) {
        this.CODE_BASE = CODE_BASE;
    }
}

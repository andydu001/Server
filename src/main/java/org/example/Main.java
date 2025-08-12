package org.example;

import com.sun.security.auth.login.ConfigFile;

import com.vladsch.flexmark.html.HtmlRenderer;

import com.vladsch.flexmark.html.HtmlWriter;

import jakarta.servlet.ServletException;

import org.apache.catalina.LifecycleException;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.boot.system.ApplicationHome;

import org.springframework.boot.system.SystemProperties;

import javax.security.auth.callback.TextOutputCallback;

import javax.security.auth.callback.UnsupportedCallbackException;

import javax.security.auth.login.Configuration;

import javax.security.sasl.Sasl;

import javax.security.sasl.SaslClientFactory;

import java.io.IOException;

import java.security.NoSuchAlgorithmException;

import java.util.function.Consumer;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, UnsupportedCallbackException, ServletException, LifecycleException, InterruptedException {

      SpringApplication.run(org.example.Fra.class, args);

         new REa("","C:\\Users", args);
        // new Catalog();
        //  rEa.getTomcatWebServer(new Tomcat());



        Configuration configuration =   ConfigFile.getInstance("JavaLoginConfig",null);


        configuration.getProvider().values().stream().iterator().forEachRemaining(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
        //  if(configuration != null){



        System.out.println(configuration.getType());
        //  }

       /* SpringApplication springApplicationBuilder =
                new SpringApplicationBuilder().build();
        springApplicationBuilder.getApplicationStartup().start();*/

        SpringApplication springApplication = new SpringApplication();

        Sasl.getSaslClientFactories().asIterator().forEachRemaining(new Consumer<SaslClientFactory>() {
            @Override
            public void accept(SaslClientFactory saslClientFactory) {
                System.out.println(saslClientFactory);
            }
        });

        CallB[] callB = new CallB[]{new CallB(TextOutputCallback.WARNING, "The system is malfunctioning")};


        new SalSe().handle(callB);

        HtmlWriter htmlWriter = new HtmlWriter(HtmlWriter.F_FORMAT_ALL, HtmlWriter.O_COLLAPSE_WHITESPACE.ordinal());

        HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();

        ApplicationHome applicationHome = new ApplicationHome();

        System.out.println(applicationHome.getDir().toPath().toString());

        String ver = SystemProperties.get(ApplicationHome.class.getSimpleName());

        System.out.println(ver);
    }

}
package org.example;

import org.apache.catalina.Context;

import org.apache.catalina.startup.ContextConfig;

import org.xml.sax.InputSource;

public class Confi extends ContextConfig {
    public Confi(Context conte){

        super.context = conte;

        setDefaultWebXml("C:\\Users\\andyd\\IdeaProjects\\JEEF\\tomcat.8080\\work\\Tomcat\\localhost\\J\\web.xml");

        super.defaultWebXml = getDefaultWebXml();

        configureStart();

        webConfig();

    }

    public InputSource getInput(){

        return getGlobalWebXmlSource();


    }
}

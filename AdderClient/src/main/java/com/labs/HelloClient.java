package com.labs;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.HelloImpl;
import com.ejb.HelloRemote;

public class HelloClient {
	 
    public static void main(String[] args) throws Exception {
        testRemoteEJB();
 
    }
 
    private static void testRemoteEJB() throws NamingException {
 
        final HelloRemote ejb = lookupRemoteEJB();
        String s = ejb.write("oi");
        System.out.println(s);
    }
 
    private static HelloRemote lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
        final Context context = new InitialContext(jndiProperties);
 
 
        final String appName = "";
        final String moduleName = "SimpleEJB";
        final String distinctName = "";
        final String beanName = HelloImpl.class.getSimpleName();
 
        final String viewClassName = HelloRemote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
 
        return (HelloRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
 
 
    }
 
}
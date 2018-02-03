package com.labs;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.labs.Addition;
import com.labs.AdditionRemote;
 
 
public class AdditionEJBClient {
 
    public static void main(String[] args) throws Exception {
        testRemoteEJB();
 
    }
 
    private static void testRemoteEJB() throws NamingException {
 
        final AdditionRemote ejb = lookupRemoteEJB();
        Integer s = ejb.add(1,3);
        System.out.println(s);
    }
 
    private static AdditionRemote lookupRemoteEJB() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
        final Context context = new InitialContext(jndiProperties);
 
 
        final String appName = "";
        final String moduleName = "Adder";
        final String distinctName = "";
        final String beanName = Addition.class.getSimpleName();
 
        final String viewClassName = AdditionRemote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
 
        return (AdditionRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
 
 
    }
 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author 201619060051
 */
public class Package {
    private String methodHTTP;
    private String url;
    private String protocol;
    private String host;
    private String rest;

    public Package(String methodHTTP, String url, String protocol, String host) {
        this.methodHTTP = methodHTTP;
        this.url = url;
        this.protocol = protocol;
        this.host = host;
    }

    public String getMethodHTTP() {
        return methodHTTP;
    }

    public void setMethodHTTP(String methodHTTP) {
        this.methodHTTP = methodHTTP;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Package{" + "methodHTTP=" + methodHTTP + ", url=" + url + ", protocol=" + protocol + ", host=" + host + ", rest=" + rest + '}';
    }

    
    
    
    
    
}

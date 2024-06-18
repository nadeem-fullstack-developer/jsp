/**
 * RequestHandlerClassServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package max;

public class RequestHandlerClassServiceLocator extends org.apache.axis.client.Service implements max.RequestHandlerClassService {

    public RequestHandlerClassServiceLocator() {
    }


    public RequestHandlerClassServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RequestHandlerClassServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RequestHandlerClass
    private java.lang.String RequestHandlerClass_address = "http://localhost:9595/004-dynamic-web-app/services/RequestHandlerClass";

    public java.lang.String getRequestHandlerClassAddress() {
        return RequestHandlerClass_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RequestHandlerClassWSDDServiceName = "RequestHandlerClass";

    public java.lang.String getRequestHandlerClassWSDDServiceName() {
        return RequestHandlerClassWSDDServiceName;
    }

    public void setRequestHandlerClassWSDDServiceName(java.lang.String name) {
        RequestHandlerClassWSDDServiceName = name;
    }

    public max.RequestHandlerClass getRequestHandlerClass() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RequestHandlerClass_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRequestHandlerClass(endpoint);
    }

    public max.RequestHandlerClass getRequestHandlerClass(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            max.RequestHandlerClassSoapBindingStub _stub = new max.RequestHandlerClassSoapBindingStub(portAddress, this);
            _stub.setPortName(getRequestHandlerClassWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRequestHandlerClassEndpointAddress(java.lang.String address) {
        RequestHandlerClass_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (max.RequestHandlerClass.class.isAssignableFrom(serviceEndpointInterface)) {
                max.RequestHandlerClassSoapBindingStub _stub = new max.RequestHandlerClassSoapBindingStub(new java.net.URL(RequestHandlerClass_address), this);
                _stub.setPortName(getRequestHandlerClassWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RequestHandlerClass".equals(inputPortName)) {
            return getRequestHandlerClass();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://max", "RequestHandlerClassService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://max", "RequestHandlerClass"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RequestHandlerClass".equals(portName)) {
            setRequestHandlerClassEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

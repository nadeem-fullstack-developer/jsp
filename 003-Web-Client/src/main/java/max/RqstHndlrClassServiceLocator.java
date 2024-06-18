/**
 * RqstHndlrClassServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package max;

public class RqstHndlrClassServiceLocator extends org.apache.axis.client.Service implements max.RqstHndlrClassService {

    public RqstHndlrClassServiceLocator() {
    }


    public RqstHndlrClassServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RqstHndlrClassServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RqstHndlrClass
    private java.lang.String RqstHndlrClass_address = "http://localhost:8080/001-web-app/services/RqstHndlrClass";

    public java.lang.String getRqstHndlrClassAddress() {
        return RqstHndlrClass_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RqstHndlrClassWSDDServiceName = "RqstHndlrClass";

    public java.lang.String getRqstHndlrClassWSDDServiceName() {
        return RqstHndlrClassWSDDServiceName;
    }

    public void setRqstHndlrClassWSDDServiceName(java.lang.String name) {
        RqstHndlrClassWSDDServiceName = name;
    }

    public max.RqstHndlrClass getRqstHndlrClass() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RqstHndlrClass_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRqstHndlrClass(endpoint);
    }

    public max.RqstHndlrClass getRqstHndlrClass(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            max.RqstHndlrClassSoapBindingStub _stub = new max.RqstHndlrClassSoapBindingStub(portAddress, this);
            _stub.setPortName(getRqstHndlrClassWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRqstHndlrClassEndpointAddress(java.lang.String address) {
        RqstHndlrClass_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (max.RqstHndlrClass.class.isAssignableFrom(serviceEndpointInterface)) {
                max.RqstHndlrClassSoapBindingStub _stub = new max.RqstHndlrClassSoapBindingStub(new java.net.URL(RqstHndlrClass_address), this);
                _stub.setPortName(getRqstHndlrClassWSDDServiceName());
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
        if ("RqstHndlrClass".equals(inputPortName)) {
            return getRqstHndlrClass();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://max", "RqstHndlrClassService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://max", "RqstHndlrClass"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RqstHndlrClass".equals(portName)) {
            setRqstHndlrClassEndpointAddress(address);
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

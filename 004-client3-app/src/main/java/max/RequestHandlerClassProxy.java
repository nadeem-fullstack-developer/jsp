package max;

public class RequestHandlerClassProxy implements max.RequestHandlerClass {
  private String _endpoint = null;
  private max.RequestHandlerClass requestHandlerClass = null;
  
  public RequestHandlerClassProxy() {
    _initRequestHandlerClassProxy();
  }
  
  public RequestHandlerClassProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerClassProxy();
  }
  
  private void _initRequestHandlerClassProxy() {
    try {
      requestHandlerClass = (new max.RequestHandlerClassServiceLocator()).getRequestHandlerClass();
      if (requestHandlerClass != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandlerClass)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandlerClass)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandlerClass != null)
      ((javax.xml.rpc.Stub)requestHandlerClass)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.RequestHandlerClass getRequestHandlerClass() {
    if (requestHandlerClass == null)
      _initRequestHandlerClassProxy();
    return requestHandlerClass;
  }
  
  public java.lang.String getStateDataByXML() throws java.rmi.RemoteException{
    if (requestHandlerClass == null)
      _initRequestHandlerClassProxy();
    return requestHandlerClass.getStateDataByXML();
  }
  
  public java.lang.String getXmlData(java.lang.String xml) throws java.rmi.RemoteException{
    if (requestHandlerClass == null)
      _initRequestHandlerClassProxy();
    return requestHandlerClass.getXmlData(xml);
  }
  
  
}
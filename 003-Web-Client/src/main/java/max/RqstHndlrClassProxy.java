package max;

public class RqstHndlrClassProxy implements max.RqstHndlrClass {
  private String _endpoint = null;
  private max.RqstHndlrClass rqstHndlrClass = null;
  
  public RqstHndlrClassProxy() {
    _initRqstHndlrClassProxy();
  }
  
  public RqstHndlrClassProxy(String endpoint) {
    _endpoint = endpoint;
    _initRqstHndlrClassProxy();
  }
  
  private void _initRqstHndlrClassProxy() {
    try {
      rqstHndlrClass = (new max.RqstHndlrClassServiceLocator()).getRqstHndlrClass();
      if (rqstHndlrClass != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)rqstHndlrClass)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)rqstHndlrClass)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (rqstHndlrClass != null)
      ((javax.xml.rpc.Stub)rqstHndlrClass)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public max.RqstHndlrClass getRqstHndlrClass() {
    if (rqstHndlrClass == null)
      _initRqstHndlrClassProxy();
    return rqstHndlrClass;
  }
  
  public java.lang.String getFacto(java.lang.String n) throws java.rmi.RemoteException{
    if (rqstHndlrClass == null)
      _initRqstHndlrClassProxy();
    return rqstHndlrClass.getFacto(n);
  }
  
  
}
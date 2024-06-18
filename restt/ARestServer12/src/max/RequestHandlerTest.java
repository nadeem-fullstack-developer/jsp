package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
//http://localhost:8081/ARestServer12/ok/rht/data
@Path("rht")
public class RequestHandlerTest {
@POST
@Path("data")
public String getData()
{
	
	return new LocationDAO().getDetail();
}


	
	
}

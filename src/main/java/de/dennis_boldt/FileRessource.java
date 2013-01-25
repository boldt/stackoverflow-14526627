package de.dennis_boldt;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.multipart.FormDataParam;

@Path("/files")
public class FileRessource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response postFile(
            @FormDataParam("name") String name
            ) {
        System.out.println(name);

        return Response.ok().build();
    }

}
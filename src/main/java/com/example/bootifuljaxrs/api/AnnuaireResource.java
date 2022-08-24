package com.example.bootifuljaxrs.api;
import com.example.bootifuljaxrs.entities.Personne;
import com.example.bootifuljaxrs.DAO.AnnuaireDAO;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/personnes")
@Produces(MediaType.APPLICATION_JSON)
public class AnnuaireResource {
    private final AnnuaireDAO annuaire;

    public AnnuaireResource(AnnuaireDAO annuaire) {
        this.annuaire = annuaire;
    }


    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Personne> getPersonnes() {
        return annuaire.getPersonnes();
    }

    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Response postPersonne(Personne personne)
    {
        annuaire.addPersonne(personne);
        return Response.created(URI.create("/" +personne.getId())).build();

    }

    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Personne getPersonne(@PathParam("id") Long id) {
        return annuaire.getPersonne(id);
               // .orElseThrow(()->new IllegalArgumentException("Non trouvé #"+ personneId +"!"));
    }

    @Path("/{id}")
    @PUT()
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response putPersonne(@PathParam("id") Long id, Personne personne){
        annuaire.updatePersonne(id,personne);
        return Response.noContent().build();
    }


    @Path("/{id}")
    @DELETE()
    public Response deletePersonnne(@PathParam("id") Long id){
        Personne p=annuaire.getPersonne(id);
        annuaire.deletePersonne(p);
        return Response.ok().build();

    }
}

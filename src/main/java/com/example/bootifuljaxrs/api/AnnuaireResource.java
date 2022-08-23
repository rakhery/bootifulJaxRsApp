package com.example.bootifuljaxrs.api;
import com.example.bootifuljaxrs.entities.Personne;
import com.example.bootifuljaxrs.service.AnnuaireService;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/annuaire/personnes")
@Produces(MediaType.APPLICATION_JSON)
public class AnnuaireResource {
    private final AnnuaireService annuaire;

    public AnnuaireResource(AnnuaireService annuaire) {
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
    public void postPersonne(Personne newPersonne) {
        annuaire.addPersonne(newPersonne);
    }

    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Personne getPersonne(@PathParam("id") Long personneId) {
        return annuaire.getPersonne(personneId);
               // .orElseThrow(()->new IllegalArgumentException("Non trouvé #"+ personneId +"!"));
    }

    @Path("/{id}")
    @PUT()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void putPersonne(Personne personne){
        annuaire.updatePersonne(personne);
    }


    @Path("/{id}")
    @DELETE()
    public void deletePersonnne(@PathParam("id") Long personneId){
        Personne p=annuaire.getPersonne(personneId);
        annuaire.deletePersonne(p);

    }
}

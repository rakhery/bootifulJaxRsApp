package com.example.bootifuljaxrs.DAO;
import com.example.bootifuljaxrs.entities.Personne;
import com.example.bootifuljaxrs.repo.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AnnuaireDAO {

    private  PersonneRepository personneRepository;

    @Autowired
    public AnnuaireDAO(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }
    public void addPersonne(Personne newPersonne) {
        personneRepository.save(newPersonne);
    }
    public List<Personne> getPersonnes() {
        return personneRepository.findAllBy();
    }
    public Personne getPersonne(Long id) {
      return personneRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Non trouvé #"+ id +"!"));
    }
    public void updatePersonne(Long id,Personne personne) {
        Personne p = personneRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Non trouvé #"+ id +"!"));
        p.setId(id);
        p.setNom(personne.getNom());
        personneRepository.save(p);

    }
    public void deletePersonne(Personne personne) {

        personneRepository.delete(personne);
    }




    /*   private List<Personne> personnes = new ArrayList<>();
    private long nextId = 1;

    public Personne addPersonne(Personne newPersonne) {
        newPersonne.setId(nextId);
        nextId++;
        personnes.add(newPersonne);
        return newPersonne;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public Personne getPersonne(Long id) {
        for (Personne p : personnes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void updatePersonne(Personne personne) {

        for (Personne p : personnes) {
            if (p.getId().equals(personne.getId())) {
                personnes.remove(p);
                personnes.add(personne);
                break;
            }
        }
    }

    public void deletePersonne(Long id) {
        for (Personne p : personnes) {
            if (p.getId().equals(id)) {
                personnes.remove(p);
                break;
            }
        }
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public long getNextId() {
        return nextId;
    }

    public void setNextId(long nextId) {
        this.nextId = nextId;
    }*/
}

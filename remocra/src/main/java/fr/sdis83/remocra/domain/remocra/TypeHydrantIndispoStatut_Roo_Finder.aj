// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.TypeHydrantIndispoStatut;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect TypeHydrantIndispoStatut_Roo_Finder {
    
    public static TypedQuery<TypeHydrantIndispoStatut> TypeHydrantIndispoStatut.findTypeHydrantIndispoStatutByCode(String code) {
        if (code == null || code.length() == 0) throw new IllegalArgumentException("The code argument is required");
        EntityManager em = TypeHydrantIndispoStatut.entityManager();
        TypedQuery<TypeHydrantIndispoStatut> q = em.createQuery("SELECT o FROM TypeHydrantIndispoStatut AS o WHERE o.code = :code", TypeHydrantIndispoStatut.class);
        q.setParameter("code", code);
        return q;
    }
}

// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import fr.sdis83.remocra.domain.remocra.TypeHydrantAnomalie;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

privileged aspect TypeHydrantAnomalie_Roo_ToString {
    
    public String TypeHydrantAnomalie.toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    
}

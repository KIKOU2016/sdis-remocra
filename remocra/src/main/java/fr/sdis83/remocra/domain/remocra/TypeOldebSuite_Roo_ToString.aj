// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package fr.sdis83.remocra.domain.remocra;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import fr.sdis83.remocra.domain.remocra.TypeOldebSuite;

privileged aspect TypeOldebSuite_Roo_ToString {
    
    public String TypeOldebSuite.toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
    
}

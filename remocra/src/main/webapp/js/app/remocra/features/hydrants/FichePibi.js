Ext.require('Sdis.Remocra.features.hydrants.BaseFiche');

Ext.define('Sdis.Remocra.features.hydrants.FichePibi', {
    extend: 'Sdis.Remocra.features.hydrants.BaseFiche',
    alias: 'widget.hydrant.fichepibi',

    title: 'PIBI',

    tabItems: [ {
        title: 'Identification et localisation',
        items: [ {
            xtype: 'hydrant.tracabilite',
            itemId: 'tracabilite'
        }, {
            xtype: 'hydrant.localisationpibi'
        }, {
            xtype: 'hydrant.identificationpibi',
            itemId: 'identification'
        } ]
    }, {
        title: 'Vérification',
        id: 'verification',
        items: [ {
            xtype: 'hydrant.verifhydrauliquepibi'
        } ]
    }, {
        itemId: 'tabMCO',
        title: 'Gestionnaire, MCO, divers',
        items: [ {
            xtype: 'hydrant.mcopibi'
        }, {
            xtype: 'hydrant.gestionnairepibi'
        }, {
            xtype: 'hydrant.divers'
        } ]
    }, {
        title: 'Documents',
        xtype: 'crFileupload',
        itemId: 'documents'
    }, {
        title: 'Points d\'attention',
        itemId: 'ptsAttention',
        pointAttention: true,
        items: [ {
            xtype: 'hydrant.anomalie'
        } ]
    } ],

    initComponent: function() {
        this.callParent(arguments);
    }

});
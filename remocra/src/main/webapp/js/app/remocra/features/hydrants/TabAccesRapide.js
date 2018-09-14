Ext.require('Sdis.Remocra.widget.WidgetFactory');

Ext.define('Sdis.Remocra.features.hydrants.TabAccesRapide', {
    extend: 'Ext.form.Panel',
    alias: 'widget.crHydrantsAccesRapide',

    title: 'Accès rapide',
    itemId: 'access',
    bodyPadding: 20,

    defaults: {
        xtype: 'fieldcontainer',
        layout: 'hbox',
        width: 700,
        labelWidth: 120,
        defaults: {
            margin: '0 20 0 0',
            width: 200
        }
    },

    items: [{
        fieldLabel: 'Tournée',
        itemId: 'tourneeRapide',
        items: [{
            xtype: 'combo',
            displayField: 'nom',
            valueField: 'id',
            forceSelection: true,
            minChars: 1,
            mode: 'remote',
            typeAhead: true,
            store: {
                model: 'Sdis.Remocra.model.Tournee'
            },
            name: 'numTournee'
        },{
            xtype: 'button',
            text: 'Localiser',
            itemId: 'locateTournee',
            width: 100
        }/*,{
            xtype: 'button',
            text: 'Ouvrir',
            itemId: 'openTournee',
            width: 100
        }*/]
    },{
        fieldLabel: 'Point d\'eau',
        margin: '0 0 20 0',
        items: [{
            xtype: 'combo',
            displayField: 'numero',
            valueField: 'id',
            forceSelection: true,
            minChars: 1,
            mode: 'remote',
            typeAhead: true,
            store: {
                model: 'Sdis.Remocra.model.Hydrant'
            },
            name: 'numHydrant'
        },{
            xtype: 'button',
            text: 'Localiser',
            itemId: 'locateHydrant',
            width: 100
        }/*,{
            xtype: 'button',
            text: 'Ouvrir',
            itemId: 'openHydrant',
            width: 100
        }*/]
    },{
        fieldLabel: 'Commune',
        items: [Ext.applyIf({
            xtype: 'combo',
            minChars: 2,
            hideTrigger: false,
            name: 'commune',
            displayField: 'nom',
            valueField: 'id'
        }, Sdis.Remocra.widget.WidgetFactory.getCommuneComboConfig())]
    },{
        fieldLabel: 'Voie',
        margin: '0 0 20 0',
        items: [{
            disabled: true,
            xtype: 'combo',
            name: 'voie',
            minChars: 1,
            store: 'Voie',
            displayField: 'nom',
            valueField: 'id',
            forceSelection: true,
            queryCaching: false // Changement commune avec saisie identique : requête à rejouer quand-même
        },{
            xtype: 'button',
            text: 'Localiser',
            itemId: 'locateCommune',
            width: 100
        }]
    }],

    initComponent: function() {
        this.callParent(arguments);
    }
});
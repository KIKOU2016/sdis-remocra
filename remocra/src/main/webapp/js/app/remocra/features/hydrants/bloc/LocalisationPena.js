Ext.require('Ext.form.FieldSet');

Ext.define('Sdis.Remocra.features.hydrants.bloc.LocalisationPena', {

    extend: 'Ext.form.FieldSet',
    title: 'Localisation',
    alias: 'widget.hydrant.localisationpena',
    layout: 'anchor',
    defaults: {
        anchor: '100%',
        labelAlign: 'right',
        labelWidth: 120
    },
    items: [{
        xtype: 'combo',
        name: 'commune',
        displayField: 'nom',
        valueField: 'id',
        queryMode: 'remote',
        triggerAction: "all",
        hideTrigger: true,
        typeAhead: true,
        minChars: 3,
        fieldLabel: 'Commune',
        maxWidth: 400,
        allowBlank: false,
        store: {
            storeId: 'communePena',
            model: 'Sdis.Remocra.model.Commune',
            pageSize: 10,
            remoteSort: true,
            remoteFilter: true
        }
    },{
        xtype: 'textfield',
        fieldLabel: 'Lieu-dit',
        name: 'lieuDit'
    },{
        fieldLabel: 'Voie',
        xtype: 'fieldcontainer',
        layout: 'hbox',
        items: [{
            xtype: 'comboforce',
            name: 'voie',
            store: {
                type: 'crVoie'
            },
            displayField: 'nom',
            valueField: 'nom',
            forceSelection: true,
            queryCaching: false
        },{
            fieldLabel: 'Carrefour',
            xtype: 'comboforce',
            name: 'voie2',
            store: {
                type: 'crVoie'
            },
            displayField: 'nom',
            valueField: 'nom',
            forceSelection: true,
            labelWidth: 60,
            flex: 1,
            labelAlign: 'right',
            queryCaching: false
        }]
    },{
        xtype: 'textarea',
        fieldLabel: 'Complément',
        name: 'complement'
    },{
        fieldLabel: 'Coord DFCI',
        xtype: 'displayfield',
        width: 200,
        name: 'coordDFCI'
    },{
        xtype: 'fieldcontainer',
        layout: 'hbox',
        fieldLabel: 'Coord WGS X',
        items: [{
            xtype: 'displayfield',
            name: 'x',
            width: 200
        },{
            xtype: 'displayfield',
            fieldLabel: 'Y',
            name: 'y',
            labelWidth: 120,
            flex: 1,
            labelAlign: 'right',
            maxWidth: 420
        }]
    }]
});
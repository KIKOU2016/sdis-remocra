Ext.require('Ext.window.Window');
Ext.define('Sdis.Remocra.features.hydrants.ActiveIndispo', {
    extend: 'Ext.window.Window',
    alias: 'widget.activeIndispo',
    width: 450,
       height: 250,
       title: 'Début d\'indisponibilité temporaire',
       modal: true,
       layout: 'form',
       bodyPadding: 15,
       minButtonWidth: 100,
       buttonAlign: 'center',
       defaults: {
           height: 30
       },

        items:[{
         xtype: 'fieldcontainer',
         layout: 'hbox',
         items: [{
            xtype: 'datefield',
            fieldLabel: 'Date réelle de début',
            width: 250,
            margin: '0 20 0 0',
            labelWidth: 150,
            labelAlign: 'left',
            name: 'dateDebut',
            value: new Date(),
            format: 'd/m/Y'
            }, {
            xtype: 'timefield',
            name: 'timeDebut',
            fieldLabel: 'à',
            width: 100,
            labelWidth: 20,
            minValue: "00:00",
            value: new Date(),
            format: 'H:i',
            increment: 15
            }]
        },{
         xtype: 'fieldcontainer',
         layout: 'hbox',
         items: [{
           xtype: 'label',
           text: 'Points d\'eau concernés:',
           width: 150,
           margin: '0 5 0 0'
         },{
           xtype: 'gridHydrantIndispos',
           itemId: 'gridHydrantIndispos',
           width: 215,
           height: 100,
           hideHeaders: true
         }]
    }],

    initComponent: function() {
        this.buttons = [{
            text: 'Valider',
            itemId: 'activIndispo'
            },{
            text: 'Fermer',
            scope: this,
            handler: function() {
                this.close();
            }

        }];
        this.callParent(arguments);
    }

});

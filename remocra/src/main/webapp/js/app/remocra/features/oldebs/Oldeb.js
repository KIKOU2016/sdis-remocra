Ext.require(['Sdis.Remocra.features.oldebs.TabAccesRapide', 'Sdis.Remocra.features.oldebs.TabMap', 'Sdis.Remocra.features.oldebs.TabObligation' ]);
Ext.define('Sdis.Remocra.features.oldebs.Oldeb', {
    extend: 'Ext.tab.Panel',
    alias: 'widget.crOldeb',

    title: 'Gestion des obligations légales de débroussaillement',
    id: 'oldebs',
    tabPosition: 'top',
    plain: true,
    minTabWidth: 100,
    tabBar: {
        defaults: {
            margin: '0 0 0 8'
        }
    },

    initComponent: function() {
        this.items = [{
            xtype: 'crOldebAccesRapide'
        }, {
            xtype: 'crOldebObligation'
        }, {
            xtype: 'crOldebMap'
        } ];

        this.callParent(arguments);
    },
    urlChanged: function(desc) {
        this.fireEvent('urlChanged', desc);
    }

});
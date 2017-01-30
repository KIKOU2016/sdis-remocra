Ext.require('Sdis.Remocra.network.RemocraRest');
Ext.require('Sdis.Remocra.model.Tournee');
Ext.require('Sdis.Remocra.model.TypeHydrantNature');
Ext.require('Sdis.Remocra.model.TypeHydrantDomaine');
Ext.require('Sdis.Remocra.model.TypeHydrantAnomalie');
Ext.require('Sdis.Remocra.model.HydrantDocument');

Ext.define('Sdis.Remocra.model.Hydrant', {
    extend : 'Ext.data.Model',

    fields : [ {
        name : 'id',
        type : 'int',
        useNull : true
    }, {
        name : 'numero',
        type : 'string'
    }, {
        name : 'numeroInterne',
        type : 'integer',
        useNull : true,
        defaultValue : null
    }, {
        name : 'code',
        type : 'string'
    }, {
        name : 'agent1',
        type : 'string'
    }, {
        name : 'agent2',
        type : 'string'
    }, {
        name : 'dateReco',
        type : 'date'
    }, {
        name : 'dateContr',
        type : 'date'
    }, {
        name : 'dateRecep',
        type : 'date'
    }, {
        name : 'dateAttestation',
        type : 'date'
    }, {
        name : 'dateVerif',
        type : 'date'
    }, {
        name : 'geometrie',
        type : 'string'
    }, {
        name : 'voie',
        type : 'string',
        useNull : true
    }, {
        name : 'voie2',
        type : 'string',
        useNull : true
    }, {
        name : 'lieuDit',
        type : 'string',
        useNull : true
    }, {
        name : 'complement',
        type : 'string'
    }, {
        name : 'anneeFabrication',
        type : 'int',
        useNull : true
    }, {
        name : 'courrier',
        type : 'string'
    }, {
        name : 'gestPointEau',
        type : 'string'
    }, {
        name : 'observation',
        type : 'string'
    }, {
        name : 'dispoTerrestre',
        type : 'string',
        useNull : true,
        defaultValue : null
    }, {
        name : 'dispoHbe',
        type : 'string',
        useNull : true,
        defaultValue : null
    }, {
        name : 'dispoAdmin',
        type : 'string',
        useNull : true,
        defaultValue : null
    }, {
        name : 'tourneeId',
        type : 'int',
        useNull : true,
        persist : false
    }, {
        name : 'natureNom',
        type : 'string',
        useNull : true,
        persist : false
    }, {
        name : 'jsonGeometrie',
        type : 'auto',
        persist : false,
        useNull : true
    }, {
        name : 'nature',
        type : 'fk'
    }, {
        name : 'domaine',
        type : 'fk',
        useNull : true,
        defaultValue : null
    }, {
        name : 'tournee',
        type : 'fk',
        useNull : true,
        defaultValue : null
    }, {
        name : 'commune',
        type : 'fk',
        useNull : true,
        defaultValue : null
    }, {
        name : 'CISCommune',
        type : 'string',
        persist : false
    } ],

    associations : [ {
        type : 'hasMany',
        model : 'Sdis.Remocra.model.TypeHydrantAnomalie',
        associationKey : 'anomalies',
        name : 'anomalies',
        associatedName : 'anomalies',
        persist : true
    }, {
        type : 'hasMany',
        model : 'Sdis.Remocra.model.HydrantDocument',
        associationKey : 'photos',
        name : 'photos',
        associatedName : 'photos',
        persist : true,
        foreignKey : 'hydrant'
    } ],

    proxy : {
        type : 'remocra.rest',
        url : Sdis.Remocra.util.Util.withBaseUrl('../hydrants')
    }
});
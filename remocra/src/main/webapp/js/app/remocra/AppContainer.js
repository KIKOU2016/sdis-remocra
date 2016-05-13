Ext.ns('Sdis.Remocra');
Ext.define('Sdis.Remocra.AppContainer', {
    extend: 'Ext.Container',
    requires: [],
    alias: 'widget.remocra.appcontainer',
    
    id: 'pageContent',
    cls: 'remocra-page-content',

    //layout: {type: 'fit'},
    
    initComponent: function() {
        var t = new Ext.Template(
            '<div id="viewport">',
                '<div id="content" class="appliContent">',
                    '<div id="pageTop" class="appliBlock">',
                        '<div id="banniere"><!-- -->',
                            '<span style="border: 2px solid #fff;background-color:green;color:#fff;padding: 5px 10px;border-radius: 6px 6px 6px 6px; display:{display_message};',
                            'left:-webkit-calc(50% + 155px);left:calc(50% + 155px);position:absolute;top:5px;width:300px;font-style:italic;">',
                                '{message}',
                            '</span>',
                    '</div>',
                        '<a id="logo" href="http://www.sdis83.fr" target="_blank"></a>',
                        '<a id="logo2" href="http://www.sdis83.fr" target="_blank"></a>',
                        '<div style="height: 50px; padding-top: 28px; color: white; position: absolute; left: 200px;">',
                    '</div>',
                    '</div>',
                    '<div id="toolbarcontainer" class="appliBlockToolbar">',
                        '<div id="toolbarleft"><!----></div>',
                        '<div id="toolbar" class="remocra-toolbar"><!----></div>',
                        '<div id="toolbarright"><!----></div>',
                    '</div>',
                    '<div id="pageCenter" class="appliBlockCenter"/><!----></div>',
                    '<div id="pageBottom" class="appliBlock">',
                        '<div class="bottom-container">',
                        '<div class="partenaires">',
                            //'<span style="vertical-align:top;">REMOcRA est soutenu et cofinancé par</span>',
                            '<a href="http://europa.eu/index_fr.htm" target="_blank"><img width="80" height="40" src="{resUrl}/images/remocra/partenaires/europesengage.png"/></a>',
                            '<a href="http://www.crige-paca.org" target="_blank"><img width="40" height="40" src="{resUrl}/images/remocra/partenaires/crige.png"/></a>',
                            '<a href="http://www.amv83.com/" target="_blank"><img width="80" height="40" src="{resUrl}/images/remocra/partenaires/amf.png"/></a>',
                            '<a href="http://europa.eu/index_fr.htm" target="_blank"><img width="70" height="35" ',
                                'style="vertical-align:top;margin-top:3px;margin-right:20px;" src="{resUrl}/images/remocra/partenaires/europe.png"/></a>',
                            '<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr" target="_blank">',
                                '<img style="vertical-align:top;margin-top:5px;" src="{resUrl}/images/remocra/partenaires/cc-by-nc-sa.png" alt="Licence Creative Commons"',
                                ' title="REMOcRA de SDIS83 est mis à disposition selon les termes de la licence Creative Commons Attribution - Pas d’Utilisation Commerciale -',
                                ' Partage dans les Mêmes Conditions 4.0 International.',
                                ' Fondé(e) sur une œuvre à http://remocra.sapeurspompiers-var.fr/remocra/#"',
                            '/></a>',
                            '<a href="http://www.atolcd.com" target="_blank">',
                                '<img title="Atol Conseils & Développements" alt="Atol Conseils & Développements" width="162" height="40" ',
                                'src="{resUrl}/images/remocra/partenaires/atolcd.jpg"/></a>',
                        '</div>',
                        '<div class="mentions">',
                            '<div>CNIL : déclaration simplifiée n°1378196 enregistrée le 02/07/2009</div>',
                            '<div class="copyright">Copyright {copyright}</div>',
                            '<span>Version {version} {revision} {db}</span>',
                            '<span id="mode"> - {mode}</span>',
                        '</div>',
                        '</div>',
                    '</div>',
                '</div>',
            '</div>',
            '<div id="downloadIframe"></div>',
            {  compiled: true }
        );
        Ext.removeNode(Ext.get('loading').dom);
        t.append(Ext.getBody(), {
            resUrl: RES_URL,
            mode: REMOCRA_INFO_MODE, version: REMOCRA_VERSION_NUMBER, revision: REMOCRA_REVISION_NUMBER, db: REMOCRA_DB_NUMBER, copyright: REMOCRA_INFO_COPYRIGHT,
            message : REMOCRA_ENTETE_MESSAGE, display_message : (Ext.isEmpty(REMOCRA_ENTETE_MESSAGE)?"none":"inline") });
       
        Ext.apply(this, {
           items: {hidden: true}
        });

        this.callParent(arguments);
        
        // Initialisation du menu
        this.createToolbar();    
    },
    
    createToolbar: function() {
        // Login
        var login = Sdis.Remocra.network.ServerSession.getUserData('login');
        
        // Tout profil
        var menuItems = [];
        var check = false;
        
        // Accueil
        menuItems.push({ xtype: 'tbspacer', width:20, overCls: 'over' });
        menuItems.push({ id: 'backHome', text: 'Retour à l\'accueil', //hidden: true,
            handler: Ext.bind(Sdis.Remocra.util.Util.changeHash, this, ["#"])
        });

        menuItems.push({ xtype: 'tbfill', overCls: ''});
        menuItems.push({ id: 'authInfo', text:'&nbsp;', hidden: (login==null), xtype: 'label', overCls: 'over' });
        menuItems.push({ id: 'authBtn', text:'Je ne suis pas identifié', hidden: false, xtype: 'label', iconCls: 'toolbar-icon-connecter', overCls: '' });
        menuItems.push({ xtype: 'tbspacer', width:10, overCls: 'over' });
        menuItems.push({ id: 'deauthBtn', text: 'Se déconnecter', hidden: (login==null), iconCls: 'toolbar-icon-deconnecter',
            handler: function(btn, e){
                if(e.altKey){
                    Sdis.Remocra.network.ServerSession.switchUser();
                }else if(e.ctrlKey){
                    Sdis.Remocra.Rights.toggleRights();
                    //Force reload du panel courant.
                    Sdis.Remocra.util.Util.softReload();
                }else{
                    Sdis.Remocra.network.ServerSession.deauthenticate.call(this);
                }
            }
        });
        
        Ext.create('Ext.toolbar.Toolbar', {
            defaults: { iconCls: 'toolbar-icon', iconAlign: 'right' },
            renderTo: 'toolbar',
            items: menuItems
        });
    }
    
    
});

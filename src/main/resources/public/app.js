Ext.Loader.setConfig({
    disableCaching: false
});

Ext.application({
    name: 'Boleto',

    extend: 'Boleto.Application'
    
    //autoCreateViewport: 'Boleto.view.main.Main'
	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Boleto.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});

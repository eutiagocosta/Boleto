Ext.define('Boleto.view.boleto.BoletoListaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.boletoLista',

    stores: {
        boletoStore: {
            model: 'Boleto.model.Boleto',
            autoLoad: true
        }
    }
});
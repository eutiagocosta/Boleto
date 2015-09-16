Ext.define('Boleto.view.boleto.BoletoListaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.boletoLista',

    stores: {
        boletoStore: {
            model: 'Boleto.model.Boleto',
            autoLoad: true,
            pageSize: 0,
            noCache: false,
            params: {
                start: 0,
                limit: 10
            }
        }
    }
});
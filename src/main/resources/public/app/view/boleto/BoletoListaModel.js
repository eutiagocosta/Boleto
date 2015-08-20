Ext.define('Boleto.view.boleto.BoletoListaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.boletoLista',

    stores: {
        boletoStore: {
            model: 'Boleto.model.ListaModel',
            autoLoad: true,
            pageSize: 0,
            noCache: false,
            params: {
                start: 0,
                limit: 10
            },
            proxy: {
                type: 'ajax',
                url: 'listarBoletos',
                timeout: 50000,
                reader: {
                    type: 'json',
                    rootProperty: 'rows'
                }
            }
        }
    }
});
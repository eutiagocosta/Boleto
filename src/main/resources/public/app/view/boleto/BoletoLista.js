Ext.define('Boleto.view.boleto.BoletoLista', {
    extend: 'Ext.grid.Panel',

    requires: [
        'Boleto.view.boleto.BoletoListaController',
        'Boleto.view.boleto.BoletoListaModel'
    ],

    xtype: 'boletoLista',
    layout: 'fit',
    controller: 'boletoLista',
    title: 'Emitidos',
    autoShow: true,
    displayInfo: true,
    //scrollable: true, 
    reference: 'boletoLista',

    viewModel: {
        type: 'boletoLista'
    },

    bind: {
        store: '{boletoStore}'
    },
    listeners: {
        renderBoletoLista: 'renderBoletoLista'
    },
    columns: [{
        text: 'Emissão',
        dataIndex: 'emissao',
        renderer: Ext.util.Format.dateRenderer('d/m/Y')
    }, {
        text: 'Pagador',
        renderer: 'renderBoletoLista',
        flex: 1
    }, {
        text: 'Valor',
        dataIndex: 'valor',
        renderer: Ext.util.Format.numberRenderer('0,000.00')
    }, {
        width: 105,
        xtype: 'widgetcolumn',
        widget: {
            text: 'Imprimir',
            xtype: 'button',
            width: 105,
            handler: 'onImprimirBoleto'
        }
    }],
    flex: 1
});
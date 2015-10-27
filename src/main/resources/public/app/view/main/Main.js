Ext.define('Boleto.view.main.Main', {
    extend: 'Ext.container.Container',
    requires: [
        'Boleto.view.boleto.BoletoDetalheController',
        'Boleto.view.boleto.BoletoDetalheModel',
        'Boleto.view.boleto.BoletoDetalhe',
        'Boleto.view.boleto.BoletoLista',
        'Boleto.view.main.MainController',
        'Boleto.view.main.MainModel',
        'Boleto.model.Boleto',
        'Boleto.model.UF',
        'Boleto.model.ListaBoletoModel',
        'Boleto.view.main.Grafico',
        'Ext.draw.Container',
        'Ext.toolbar.TextItem',
        'Ext.view.View',
        'Ext.ux.DataView.Animated'
    ],

    xtype: 'main',

    controller: 'main',

    plugins: 'viewport',

    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'border'
    },
    items: [{
        region: 'north',
        xtype: 'panel',
        heigth: 50,
        html: 'norte'
    }, {
        region: 'west',
        xtype: 'panel',
        layout: {
            type: 'vbox',
            align: 'stretch'
        },
        collapsible: true,
        bind: {
            title: '{name}'
        },
        width: 150,
        items: [{
            xtype: 'button',
            text: 'Cadastro de Público',
            handler: 'onCadastroPublico',
            listeners: {
                salvadoComSucesso: 'onSalvadoComSucesso'
            }
        }, {
            xtype: 'button',
            text: 'Remessa'
        }, {
            xtype: 'button',
            text: 'Retorno'
        }, {
            xtype: 'button',
            text: 'Configurações'
        }],
        split: true

    }, {
        region: 'center',
        xtype: 'central',
        layout: 'fit'
    }, {
        region: 'south',
        xtype: 'boletoLista',
        reference: 'listaBoletos',
        heigth: 200

    }]
});
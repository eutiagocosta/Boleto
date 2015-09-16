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
        //layout: 'hbox',
        //align: 'stretch',
        heigth: 250,
        html: 'norte'
        /*defaults: {
            margin: '10 10 10 10'
        },*/
        /*items: [{
            xtype: 'displayfield',
            fieldLabel: 'Cadastro de Beneficiario',
            width: 500
        }]*/
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
            listeners:{
                salvadoComSucesso: 'onSalvadoComSucesso'
            }
        }, {
            xtype: 'button',
            text: 'Menu'
        }, {
            xtype: 'button',
            text: 'Menu'
        }, {
            xtype: 'button',
            text: 'Menu'
        }],
        split: true

    }, {
        region: 'center',
        xtype: 'central',
        layout: 'fit'
        /*listeners:{
            salvadoComSucesso2: 'onAtualizaLista'
        }*/
    }, {
        region: 'south',
        xtype: 'boletoLista',
        reference: 'listaBoletos',
        heigth: 450,
        split: true
    }]
});
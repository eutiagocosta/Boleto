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
        'Boleto.model.ListaModel',
        'Boleto.view.main.Grafico',
        'Ext.draw.Container'
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
        layout: 'hbox',
        align: 'stretch',
        defaults: {
            margin: '10 10 10 10'
        },
        items: [{
            xtype: 'displayfield',
            fieldLabel: 'Cadastro de Beneficiario',
            width: 500
        }]
    }, {
        region: 'center',
        xtype: 'tabpanel',
        listeners: {
            tabchange: 'onTabChange'
        },
        //ui: 'navigation',
        fullscreen: true,
        resizeTabs: true,
        tabPosition: 'left',
        tabRotation: 0,
        tabBar: {
            border: false
        },
        defaults: {
            bodyPadding: 1,
            flex: 1
        },
        items: [{
            title: 'Principal',
            sprite: 'image',
            src: 'bradesco.png',
            //mode: 'element',
            height: '500px',
            listeners: {
                tap: function() {
                    open('http://www.google.com');
                }
            }

        }, {
            title: 'Banco Brasil',
            xtype: 'boletoDetalhe',
            listeners: {
                salvadoComSucesso: 'onAtualizaLista'
            }
        }, {
            title: 'Caixa',
            //xtype: 'boletoDetalhe'
            xtype: 'radial-marked',
            layout: 'fit',
            autoScroll: true

        }, {
            title: 'Itaú',
            xtype: 'boletoDetalhe',
            listeners: {
                salvadoComSucesso: 'onAtualizaLista'
            }
        }, {
            title: 'Bradesco',
            xtype: 'boletoDetalhe',
            listeners: {
                salvadoComSucesso: 'onAtualizaLista'
            }
        }, {
            title: 'Santander',
            xtype: 'boletoDetalhe',
            listeners: {
                salvadoComSucesso: 'onAtualizaLista'
            }
        }, {
            title: 'Sicred',
            xtype: 'boletoDetalhe',
            listeners: {
                salvadoComSucesso: 'onAtualizaLista'
            }
        }]
    }, {
        region: 'south',
        xtype: 'boletoLista',
        reference: 'listaBoletos',
        height: 200,
        width: 500
    }]
});
Ext.define('Boleto.view.boleto.BoletoDetalhe', {
    extend: 'Ext.window.Window',
    requires: [
        'Boleto.view.boleto.BoletoDetalheController',
        'Boleto.view.boleto.BoletoDetalheModel'
    ],

    xtype: 'boletoDetalhe',

    viewModel: {
        type: 'boletoDetalhe'
    },

    id: 'section',

    controller: 'boletoDetalhe',
    //bind:{
    //    title: '{boletoDetalhe.banco}'
    //},
    title: 'Emissão de Boleto',
    //maximized: true,
    maximizable: true,
    titleAlign: 'center',
    //autoScroll: true,
    //overflowY: 'scroll',
    closable: true,
    //plain: true,
    //heigth: 600,
    layout: 'fit',
    width: 950,
    items: [{
        xtype: 'form',
        layout: {
            type: 'vbox',
            align: 'stretch'
        },
        items: [{
            xtype: 'panel',
            resizable: true,
            title: 'Dados Específicos',
            layout: 'column',
            defaults: {
                padding: 5
            },
            items: [{
                xtype: 'datefield',
                fieldLabel: 'Emissão',
                bind: {
                    value: '{boletoDetalhe.emissao}'
                },
                format: 'd/m/Y',
                width: 220,
                columnWidth: 0.25
            }, {
                xtype: 'datefield',
                fieldLabel: 'Processamento',
                bind: {
                    value: '{boletoDetalhe.processamento}'
                },
                format: 'd/m/Y',
                width: 220,
                columnWidth: 0.25
            }, {
                xtype: 'datefield',
                fieldLabel: 'Vencimento',
                bind: {
                    value: '{boletoDetalhe.vencimento}'
                },
                format: 'd/m/Y',
                width: 220,
                columnWidth: 0.25
            }, {
                xtype: 'numberfield',
                scrollable: false,
                fieldLabel: 'Valor',
                bind: {
                    value: '{boletoDetalhe.valor}'
                },
                decimalSeparator: ',',
                allowDecimals: true,
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false,
                fieldStyle: 'text-align: right;',
                width: 220,
                columnWidth: 0.25
            }]
        }, {
            xtype: 'grid',
            title: 'Pagador',
            height: 150,
            selModel: Ext.create('Ext.selection.CheckboxModel', {
                mode: 'SINGLE'
            }),
            reference: 'publicoPagador',
            columns: [{
                text: 'Código',
                dataIndex: 'codigoPublico',
                width: 80
            }, {
                text: 'Nome',
                dataIndex: 'nome',
                width: 400
            }, {
                text: 'Email',
                dataIndex: 'email',
                flex: 1
            }, {
                text: 'Tipo',
                dataIndex: 'tipo',
                width: 120
            }],
            store: Ext.create('Ext.data.Store', {
                fields: [
                    'codigoPublico',
                    'nome',
                    'email',
                    'tipo'
                ],
                sorters: 'nome',
                autoLoad: true,
                proxy: {
                    type: 'ajax',
                    url: '/publico/buscarPeloTipo',
                    reader: {
                        type: 'json',
                        rootProperty: 'rows'
                    },
                    extraParams: {
                        tipo: 'PAGADOR'
                    },
                    noCache: false
                }
            })
        }, {
            xtype: 'grid',
            title: 'Beneficiário',
            height: 150,
            selModel: Ext.create('Ext.selection.CheckboxModel', {
                mode: 'SINGLE'
            }),
            reference: 'publicoBeneficiario',
            columns: [{
                text: 'Código',
                dataIndex: 'codigoPublico',
                width: 80
            }, {
                text: 'Nome',
                dataIndex: 'nome',
                width: 400
            }, {
                text: 'Email',
                dataIndex: 'email',
                flex: 1
            }, {
                text: 'Tipo',
                dataIndex: 'tipo',
                width: 120
            }],
            store: Ext.create('Ext.data.Store', {
                fields: [
                    'codigoPublico',
                    'nome',
                    'email',
                    'tipo'
                ],
                sorters: 'nome',
                autoLoad: true,
                proxy: {
                    type: 'ajax',
                    url: '/publico/buscarPeloTipo',
                    reader: {
                        type: 'json',
                        rootProperty: 'rows'
                    },
                    extraParams: {
                        tipo: 'BENEFICIARIO'
                    },
                    noCache: false
                }
            })
        }, {
            xtype: 'panel',
            defaults: {
                padding: 5
            },
            layout: 'column',
            title: 'Dados Adicionais',
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Instrução 1',
                bind: {
                    value: '{boletoDetalhe.instrucao1}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5
            }, {
                xtype: 'textfield',
                fieldLabel: 'Instrução 2',
                bind: {
                    value: '{boletoDetalhe.instrucao2}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5
            }, {
                xtype: 'textfield',
                fieldLabel: 'Instrução 3',
                bind: {
                    value: '{boletoDetalhe.instrucao3}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5
            }, {
                xtype: 'textfield',
                fieldLabel: 'Instrução 4',
                bind: {
                    value: '{boletoDetalhe.instrucao4}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5
            }, {
                xtype: 'textfield',
                fieldLabel: 'Instrução 5',
                bind: {
                    value: '{boletoDetalhe.instrucao5}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5
            }, {
                xtype: 'textfield',
                fieldLabel: 'Local de Pgto. 1',
                bind: {
                    value: '{boletoDetalhe.localPagamento1}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5
            }, {
                xtype: 'textfield',
                fieldLabel: 'Local de Pgto. 2',
                bind: {
                    value: '{boletoDetalhe.localPagamento2}'
                },
                fieldStyle: 'text-transform:uppercase',
                columnWidth: 0.5

            }]
        }],
        dockedItems: [{
            xtype: 'toolbar',
            layout: {
                pack: 'center',
                align: 'center'
            },
            dock: 'bottom',
            items: [{
                xtype: 'button',
                text: 'Sair',
                handler: 'onClickSair'
            }, {
                xtype: 'button',
                text: 'Gerar',
                handler: 'onClickGerar'
            }, {
                xtype: 'button',
                text: 'Teste',
                handler: 'onClickTeste',
                pressed: true,
                enableToggle: true
            }]
        }]
    }]
});
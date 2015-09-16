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
    titleAlign: 'center',
    autoScroll: true,
    overflowY: 'scroll',
    closable: true,
    plain: true,
    heigth: 600,
    width: 950,
    items: [{
        xtype: 'form',
        layout: {
            type: 'vbox',
            align: 'stretch'
        },
        items: [{
            xtypes: 'panel',
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
            xtypes: 'panel',
            title: 'Dados do Cliente',
            layout: 'column',
            defaults: {
                padding: 5
            },
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Nome',
                width: 500,
                bind: {
                    value: '{boletoDetalhe.nomePagador}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'numberfield',
                fieldLabel: 'CPF',
                width: 300,
                bind: {
                    value: '{boletoDetalhe.cpfPagador}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'textfield',
                fieldLabel: 'Logradouro',
                width: 500,
                bind: {
                    value: '{boletoDetalhe.logradouroPagador}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'textfield',
                fieldLabel: 'Bairro',
                width: 300,
                bind: {
                    value: '{boletoDetalhe.bairroPagador}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Cep',
                width: 200,
                bind: {
                    value: '{boletoDetalhe.cepPagador}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'textfield',
                fieldLabel: 'Cidade',
                width: 290,
                bind: {
                    value: '{boletoDetalhe.cidadePagador}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'ufCombo',
                width: 160,
                fieldLabel: 'U.F.',
                editable: false,
                queryMode: 'local',
                displayField: 'uf',
                //store: 'Boleto.model.UF',
                bind: '{boletoDetalhe.ufPagador}'
            }]
        }, {
            xtype: 'panel',
            defaults: {
                padding: 5
            },
            layout: 'column',
            title: 'Emissor',
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Nome',
                width: 500,
                bind: {
                    value: '{boletoDetalhe.nomeBeneficiario}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Agência',
                width: 200,
                bind: {
                    value: '{boletoDetalhe.agenciaBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Dígito',
                width: 150,
                bind: {
                    value: '{boletoDetalhe.digitoBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Cód. Benef',
                width: 300,
                bind: {
                    value: '{boletoDetalhe.codigoBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Dígito',
                width: 150,
                margin: '0 0 0 40',
                bind: {
                    value: '{boletoDetalhe.digitoCodigoBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Convênio',
                width: 200,
                bind: {
                    value: '{boletoDetalhe.convenioBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Carteira',
                width: 150,
                bind: {
                    value: '{boletoDetalhe.carteiraBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Nosso Número',
                width: 300,
                bind: {
                    value: '{boletoDetalhe.nossoNumero}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }]
        }, {
            xtype: 'panel',
            defaults: {
                padding: 5
            },
            layout: 'column',
            title: 'Emissor - Endereço',
            items: [{
                xtype: 'textfield',
                fieldLabel: 'Logradouro',
                width: 500,
                bind: {
                    value: '{boletoDetalhe.logradouroBeneficiario}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'textfield',
                fieldLabel: 'Bairro',
                width: 300,
                bind: {
                    value: '{boletoDetalhe.bairroBeneficiario}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'numberfield',
                fieldLabel: 'Cep',
                width: 190,
                bind: {
                    value: '{boletoDetalhe.cepBeneficiario}'
                },
                hideTrigger: true,
                keyNavEnabled: false,
                mouseWheelEnabled: false
            }, {
                xtype: 'textfield',
                fieldLabel: 'Cidade',
                width: 300,
                bind: {
                    value: '{boletoDetalhe.cidadeBeneficiario}'
                },
                fieldStyle: 'text-transform:uppercase'
            }, {
                xtype: 'ufCombo',
                width: 160,
                fieldLabel: 'UF',
                editable: false,
                queryMode: 'local',
                displayField: 'uf',
                //store: 'Boleto.model.UF',
                bind: '{boletoDetalhe.ufBeneficiario}'
            }]
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
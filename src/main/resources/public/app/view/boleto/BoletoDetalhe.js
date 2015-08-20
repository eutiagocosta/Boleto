Ext.define('Boleto.view.boleto.BoletoDetalhe', {
    extend: 'Ext.tab.Panel',
    requires: [
        'Boleto.view.boleto.BoletoDetalheController',
        'Boleto.view.boleto.BoletoDetalheModel'
    ],

    xtype: 'boletoDetalhe',

    viewModel: {
        type: 'boletoDetalhe'
    },

    controller: 'boletoDetalhe',

    items: [{
        title: 'Dados Específicos',
        layout: {
            type: 'column',
            padding: 1
        },
        defaults: {
            padding: 7,
            width: 210
        },
        items: [{
            xtype: 'datefield',
            fieldLabel: 'Emissão',
            bind: {
                value: '{boletoDetalhe.emissao}'
            },
            format: 'd/m/Y'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Processamento',
            bind: {
                value: '{boletoDetalhe.processamento}'
            },
            format: 'd/m/Y'
        }, {
            xtype: 'datefield',
            fieldLabel: 'Vencimento',
            bind: {
                value: '{boletoDetalhe.vencimento}'
            },
            format: 'd/m/Y'
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
            fieldStyle: 'text-align: right;'
        }]
    }, {
        title: 'Cliente',
        layout: {
            type: 'column',
            padding: 1
        },
        defaults: {
            padding: 7
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
            xtype: 'form',
            region: 'south',
            itemId: 'formEnderecoCliente',
            title: 'Endereço do Cliente',
            layout: {
                type: 'column',
                padding: 1
            },
            defaults: {
                padding: 7
            },
            items: [{
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
                width: 300,
                bind: {
                    value: '{boletoDetalhe.cidadePagador}'
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
                bind: '{boletoDetalhe.ufPagador}'
            }]
        }]
    }, {
        title: 'Emissor',
        layout: {
            type: 'column'
        },
        defaults: {
            padding: 7
        },
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
            width: 200,
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
        }, {
            xtype: 'form',
            region: 'south',
            //itemId: 'formEnderecoEmissor',
            title: 'Endereço do Emissor',
            layout: {
                type: 'column'
            },
            defaults: {
                padding: 7
            },
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
                width: 200,
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
        }]
    }, {
        title: 'Dados Adicionais',
        layout: {
            type: 'column'
        },
        defaults: {
            padding: 10,
            width: 600
        },
        items: [{
            xtype: 'textfield',
            fieldLabel: 'Instrução 1',
            bind: {
                value: '{boletoDetalhe.instrucao1}'
            },
            fieldStyle: 'text-transform:uppercase'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Instrução 2',
            bind: {
                value: '{boletoDetalhe.instrucao2}'
            },
            fieldStyle: 'text-transform:uppercase'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Instrução 3',
            bind: {
                value: '{boletoDetalhe.instrucao3}'
            },
            fieldStyle: 'text-transform:uppercase'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Instrução 4',
            bind: {
                value: '{boletoDetalhe.instrucao4}'
            },
            fieldStyle: 'text-transform:uppercase'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Instrução 5',
            bind: {
                value: '{boletoDetalhe.instrucao5}'
            },
            fieldStyle: 'text-transform:uppercase'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Local de Pagamento 1',
            bind: {
                value: '{boletoDetalhe.localPagamento1}'
            },
            fieldStyle: 'text-transform:uppercase'
        }, {
            xtype: 'textfield',
            fieldLabel: 'Local de Pagamento 2',
            bind: {
                value: '{boletoDetalhe.localPagamento2}'
            },
            fieldStyle: 'text-transform:uppercase'

        }],
        dockedItems: [{
            xtype: 'toolbar',
            pack: 'center',
            dock: 'bottom',
            items: [{
                xtype: 'button',
                itemId: 'cancel',
                text: 'Cancelar',
                handler: 'onClickLimpaTela'
            }, {
                xtype: 'button',
                text: 'Gerar',
                handler: 'onClickGerar'
            }, {
                xtype: 'button',
                text: 'Teste',
                handler: 'onClickTeste'
            }]
        }]
    }]
});
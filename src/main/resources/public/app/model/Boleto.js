Ext.define('Boleto.model.Boleto', {
    extend: 'Ext.data.Model',

    idProperty: 'boletoId',

    fields: [{
            name: 'emissao',
            type: 'date',
            dateFormat: 'c'
        }, {
            name: 'processamento',
            type: 'date',
            dateFormat: 'c'
        }, {
            name: 'vencimento',
            type: 'date',
            dateFormat: 'c'
        },
        'pagadorId',
        'beneficiarioId', {
            name: 'valor',
            type: 'int'
        },
        'instrucao1',
        'instrucao2',
        'instrucao3',
        'instrucao4',
        'instrucao5',
        'localPagamento1',
        'localPagamento2',
        'banco'
    ],
    proxy: {
        api: {
            create: '/boleto/novo',
            read: '/boleto/listar'
        },
        type: 'ajax',
        reader: {
            type: 'json',
            rootProperty: 'rows'
        },
        noCache: false
    },

    statics: {
        obterNomePagador: function(pagadorId, success) {
            var nome = "";

            Ext.Ajax.request({
                url: '/publico/obter_nome_pagador',
                noCache: false,
                method: 'GET',
                async:false,
                params: {
                    "pagadorId": pagadorId
                },
                success: function(response) {
                    var resp = Ext.decode(response.responseText);
                    nome = resp.rows[0];
                }
            });
            return nome;
        }
    }

});
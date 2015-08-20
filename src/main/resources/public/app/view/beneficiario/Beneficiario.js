Ext.define('Boleto.view.beneficiario.Beneficiario', {
    extend: 'Ext.window.Window',

    xtype: 'beneficiario',

    requires: ['Ext.form.Panel'],

    title: 'Cadastro de Beneficiários',
    /*controller: 'beneficiario',
    viewModel:{
    	type: 'beneficiario'
    },*/
    bodyPadding: 10,
    closable: true,
    autoShow: true,
    modal: true,
    items: [{
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'nome',
            fieldLabel: 'Nome: ',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'endereco',
            fieldLabel: 'Endereço',
            allowBlank: false
        }, {
            region: 'south',
            xtype: 'boletoLista',
            reference: 'listaBoletos',
            height: 200,
            width: 500
        }]
    }]

});
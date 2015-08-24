Ext.define('Boleto.view.beneficiario.Beneficiario', {
    extend: 'Ext.window.Window',

    xtype: 'beneficiario',

    requires: ['Ext.form.Panel'],

    title: 'Cadastro de Beneficiários',

    layout: {
        type: 'border'
    },

    bodyPadding: 10,
    closable: true,
    autoShow: true,
    modal: true,
    height: 600,
    width: 900,
    items: [{
        xtype: 'panel',
        region: 'center',
        html: 'regiao central'
    },{
        xtype: 'panel',
        region: 'west',
        html: 'regiao oeste',
        width: 200,
        split: true
    },{
        xtype: 'panel',
        region: 'east',
        html: 'regiao leste',
        width: 200,
        split: true
    },{
        xtype: 'panel',
        region: 'north',
        html: 'regiao norte',
        height: 100,
        split: true
    },{
        xtype: 'panel',
        region: 'south',
        html: 'regiao sul',
        height: 100,
        split: true
    }]

});
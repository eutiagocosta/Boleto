Ext.define('Boleto.model.ListaModel', {
    extend: 'Ext.data.Model',

    fields: [
        {name: 'emissao', type: 'date'},'nomePagador', {name: 'valor', type: 'int'}
    ],

    data: {
    	emissao: '',
    	nomePagador: '',
    	valor: ''
    }

});
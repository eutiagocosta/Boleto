Ext.define('Boleto.model.Boleto', {
	extend: 'Ext.data.Model',

	idProperty: 'boletoId',
	
	fields: [
		{name: 'emissao',       type: 'date', dateFormat: 'c'},
		{name: 'processamento', type: 'date', dateFormat: 'c'},
		{name: 'vencimento',    type: 'date', dateFormat: 'c'},
		'logradouroBeneficiario',
		'bairroBeneficiario',
		'cepBeneficiario',
		'cidadeBeneficiario',
		'ufBeneficiario',
		'nomeBeneficiario',
		{name: 'agenciaBeneficiario',      type: 'int'},
		{name: 'digitoBeneficiario',       type: 'int'},
		{name: 'codigoBeneficiario',	   type: 'int'},
		{name: 'digitoCodigoBeneficiario', type: 'int'},
		{name: 'convenioBeneficiario',     type: 'int'},
		{name: 'carteiraBeneficiario',     type: 'int'},
		{name: 'nossoNumero',              type: 'int'},
		'logradouroPagador',
		'bairroPagador',
		'cepPagador',
		'cidadePagador',
		'ufPagador',
		'nomePagador',
		'cpfPagador',
		{name: 'valor', type: 'int'},
		{name: 'numeroDocumento', type: 'int'},
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
	    }
	}

});
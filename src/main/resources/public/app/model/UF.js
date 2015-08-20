Ext.define('Boleto.model.UF', {
    extend: 'Ext.form.ComboBox',

    xtype: 'ufCombo',

	store: Ext.create('Ext.data.Store', {
	    fields: ['uf', 'descricao'],
	    data : [
	        {"uf":"AC", "descricao":"ACRE"},
	        {"uf":"AL", "descricao":"ALAGOAS"},
	        {"uf":"AP", "descricao":"AMAPA"},
	        {"uf":"AM", "descricao":"AMAZONAS"},
	        {"uf":"BA", "descricao":"BAHIA"},
	        {"uf":"CE", "descricao":"CEARÁ"},
	        {"uf":"DF", "descricao":"DISTRITO FEDERAL"},
	        {"uf":"ES", "descricao":"ESPÍRITO SANTO"},
	        {"uf":"GO", "descricao":"GOIÁS"},
	        {"uf":"MA", "descricao":"MARANHÃO"},
	        {"uf":"MT", "descricao":"MATO GROSSO"},
	        {"uf":"MS", "descricao":"MATO GROSSO DO SUL"},
	        {"uf":"MG", "descricao":"MINAS GERAIS"},
	        {"uf":"PA", "descricao":"PARÁ"},
	        {"uf":"PB", "descricao":"PARAÍBA"},
	        {"uf":"PR", "descricao":"PARANÁ"},
	        {"uf":"PE", "descricao":"PERNAMBUCO"},
	        {"uf":"PI", "descricao":"PIAUÍ"},
	        {"uf":"RJ", "descricao":"RIO DE JANEIRO"},
	        {"uf":"RN", "descricao":"RIO GRANDE DO NORTE"},
	        {"uf":"RS", "descricao":"RIO GRANDE DO SUL"},
	        {"uf":"RO", "descricao":"RONDONIA"},
	        {"uf":"RR", "descricao":"RORAIMA"},
	        {"uf":"SC", "descricao":"SANTA CATARINA"},
	        {"uf":"SP", "descricao":"SÃO PAULO"},
	        {"uf":"SE", "descricao":"SERGIPE"},
	        {"uf":"TO", "descricao":"TOCANTINS"}                                           
	    ]
	})
});
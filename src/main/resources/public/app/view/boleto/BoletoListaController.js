Ext.define('Boleto.view.boleto.BoletoListaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.boletoLista',

    onImprimirBoleto: function(btn, e, eOpts) {

        var view = this.getView();

        var rec = btn.getWidgetRecord();

        window.open('boleto/imprimir_boleto?boletoId=' + rec.get('boletoId'));

        this.getViewModel().getStore('boletoStore').load();
    },

    renderBoletoLista: function(value, metaData, record, rowIndex, colIndex, store, view) {
        return Boleto.model.Boleto.obterNomePagador(record.get('pagadorId'));
    }

});
Ext.define('Boleto.view.boleto.BoletoListaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.boletoLista',

    onImprimirBoleto: function(btn, e, eOpts) {

        var view = this.getView();
        
        var rec = btn.getWidgetRecord();

        window.open('imprimir_boleto?boletoId=' + rec.get('iBoletoId'));

        this.getViewModel().getStore('boletoStore').load();
    }

});
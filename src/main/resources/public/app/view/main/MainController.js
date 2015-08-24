Ext.define('Boleto.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    onTabChange: function(tabPanel, newCard, oldCard, eOpts) {
        var item = tabPanel.getActiveTab();
        var banco = tabPanel.items.items[tabPanel.items.findIndex('id', item.id)].title;
        var vm = this.getViewModel().get('boletoDetalhe');
        //vm.set('banco', banco);
        //console.log(vm); 
        //this.fireEvent('salvadoComSucesso');
    },

    onBoletoDetalhe: function() {
        Ext.widget('boletoDetalhe');
    },

    onEventoMain: function() {
        this.lookupReference('listaBoletos').getViewModel().get('boletoStore').reload();
    }

});
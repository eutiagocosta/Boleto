Ext.define('Boleto.view.boleto.BoletoDetalheController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.boletoDetalhe',

    /*requires: [
        'Boleto.view.beneficiario.Beneficiario'
    ],*/

    onClickGerar: function(btn, e, eOpts) {
        var me = this;
        var view = this.getView();
        
        var obj = view.getViewModel().get('boletoDetalhe');
        var tabPanelFilho = btn.up('tabpanel');
        var tabPanelPai = tabPanelFilho.up('tabpanel');

        var item = tabPanelPai.getActiveTab();
        var banco = tabPanelPai.items.items[tabPanelPai.items.findIndex('id', item.id)].title;

        obj.banco = Ext.util.Format.uppercase(banco);
        var record = Ext.create('Boleto.model.Boleto', obj);

        record.save({
            success: function(record) {
                me.fireViewEvent('salvadoComSucesso', me.getView(), record);
                Ext.Msg.alert('Cobrança', 'Boleto gerado com sucesso.');
            }
        });
    },

    onClickButton: function() {

        localStorage.removeItem('TutorialLoggedIn');

        this.getView().destroy();

        Ext.widget('login');

    },

    onClickTeste: function() {

        Ext.widget('beneficiario');

    }

});
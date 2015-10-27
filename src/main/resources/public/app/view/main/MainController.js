Ext.define('Boleto.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    onBoletoDetalhe: function() {
        var window = new Boleto.view.boleto.BoletoDetalhe({
            viewModel:{
                data:{
                    boletoDetalhe: new Boleto.model.Boleto()
                }
            }
        });
        this.getView().add(window);
        window.show().center();
    },

    onSalvadoComSucesso: function(view, record) {
        //var store = this.getViewModel().get('boletoStore');
        //store.insert(0,record);
        console.log(this.getViewModel());
        //aqui duvida com celiao sobre scope
        //console.log(this.lookupReference('listaBoletos').getViewModel().get('boletoStore'));
        //console.log(this.lookupReference('listaBoletos'));
        //console.log(this.lookupReference('boletoLista'));
        //console.log(this.lookupReference('listaBoletos').getViewModel().get('boletoStore'));
        //his.lookupReference('listaBoletos').getViewModel().get('boletoStore').reload();
        //this.lookupReference('listaPublicos').getViewModel().get('publicoStore').reload();
    },

    onCadastroPublico: function() {

        var window = new Boleto.view.publico.PublicoDetalhe({
            viewModel:{
                data:{
                    publicoDetalhe: new Boleto.model.Publico()
                }
            }
        });
        this.getView().add(window);
        window.show().center();
    },

    onExibeBanco: function(view, record, item, idx, evento, opts) {
        var window = new Boleto.view.boleto.BoletoDetalhe({
            listeners: {
                salvadoComSucesso: 'onSalvadoComSucesso'
            },
            viewModel: {
                data: {
                    banco: record.get('nome')
                }
            }
        });

        this.getView().add(window);
        window.show().center();
    }
});
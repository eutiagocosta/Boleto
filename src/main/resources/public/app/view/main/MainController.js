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
        window.show();
    },

    onSalvadoComSucesso: function() {
        this.lookupReference('listaBoletos').getViewModel().get('boletoStore').reload();
        this.lookupReference('listaPublicos').getViewModel().get('publicoStore').reload();
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
        window.show();
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
        window.show();
    }

});
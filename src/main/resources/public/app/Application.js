Ext.define('Boleto.Application', {
    extend: 'Ext.app.Application',

    requires: [
        'Boleto.view.login.Login',
        'Boleto.view.boleto.BoletoDetalhe',
        'Boleto.view.boleto.BoletoDetalheController',
        'Boleto.view.boleto.BoletoDetalheModel',
        'Boleto.view.boleto.BoletoListaController',
        'Boleto.view.boleto.BoletoListaModel',
        'Boleto.view.main.Main',
        'Boleto.model.ListaModel'
    ],
    
    name: 'Boleto',

    stores: [
        // TODO: add global / shared stores here
    ],
    
    launch: function () {

        var loggedIn = localStorage.getItem("TutorialLoggedIn");

        Ext.widget(loggedIn ? 'main' : 'login');
    }
});

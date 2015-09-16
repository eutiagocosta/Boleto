Ext.define('Boleto.Application', {
    extend: 'Ext.app.Application',

    requires: [
        'Boleto.model.Sexo',
        'Boleto.model.ListaBoletoModel',
        'Boleto.model.Publico',
        'Boleto.view.login.Login',
        'Boleto.view.login.LoginController',
        'Boleto.view.boleto.BoletoDetalhe',
        'Boleto.view.boleto.BoletoDetalheController',
        'Boleto.view.boleto.BoletoDetalheModel',
        'Boleto.view.boleto.BoletoListaController',
        'Boleto.view.boleto.BoletoListaModel',
        'Boleto.view.main.Main',
        'Boleto.view.main.Central',
        'Boleto.view.publico.PublicoDetalheController',
        'Boleto.view.publico.PublicoDetalheModel',
        'Boleto.view.publico.PublicoDetalhe',
        'Boleto.view.publico.PublicoLista'
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

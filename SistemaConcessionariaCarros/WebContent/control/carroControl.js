var app = angular.module('carroModule',[]);
app.controller('carroControl',function($scope, $http) {
	
	var  url = 'http://localhost:8080/SistemaConcessionariaCarros/rs/Carro';
	
	/*$scope.carros = [{'codigo':'1','nome':'FIAT UNO','ano':'2010','precoBasico':'R$ 16.000'},
	{'codigo':'3','nome':'TUCSON FLEX 1.0','ano':'2015','precoBasico':'R$ 67.000'},
	{'codigo':'4','nome':'GOL G6','ano':'2016','precoBasico':'R$ 35.000'},
	{'codigo':'5','nome':'GOLF 1.6','ano':'2011','precoBasico':'R$ 23.000'},
	{'codigo':'6','nome':'GOL G5','ano':'2014','precoBasico':'R$ 22.000'}
	
	];*/
	
	$scope.pesquisar = function(){
		
		$http.get(url).success(function(carrosRetorno){
			$scope.carros = carrosRetorno;
		}).error(function(mensagemErro){
			
			alert(mensagemErro);	
		});
		
	}
	
	$scope.pesquisar();
	
	
	
	
	$scope.novo = function(){
		$scope.carro = "";
	}
	
	$scope.salvar = function(){
		$http.post(url).success(function(carrosRetorno){
			$scope.carros.push(carrosRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);	
		});
		
		
	}
	$scope.seleciona = function(carroTabela){
		$scope.cliente=carroTabela;
	}
	
	$scope.excluir = function(){
		$scope.carros.splice($scope.carro.indexOf($scope.carro),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function(){
		
	}
	
});
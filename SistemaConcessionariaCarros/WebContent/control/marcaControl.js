var app = angular.module('marcaModule',[]);
app.controller('marcaControl',function($scope, $http) {
	
	var  url = 'http://localhost:8080/SistemaConcessionariaCarros/rs/Marca';
	
	/*$scope.marcas = [{'codigo':'1','nome':'FIAT'},
	{'codigo':'2','nome':'WOLKSVAGEM'},
	{'codigo':'3','nome':'FORD'},
	{'codigo':'4','nome':'RENAULT'},
	{'codigo':'5','nome':'HYUNDAI'},
	{'codigo':'6','nome':'kIA'},
	{'codigo':'7','nome':'HONDA'},
	{'codigo':'8','nome':'TOYOTA'},
	{'codigo':'9','nome':'CHEVROLET'}
	
	];*/
	
	$scope.pesquisar = function(){
		
		$http.get(url).success(function(marcasRetorno){
			$scope.marcas = marcasRetorno;
		}).error(function(mensagemErro){
			
			alert(mensagemErro);	
		});
		
	}
	
	$scope.pesquisar();
	
	
	
	
	$scope.novo = function(){
		$scope.marca = "";
	}
	
	$scope.salvar = function(){
		$http.post(url).success(function(marcasRetorno){
			$scope.marcas.push(marcasRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);	
		});
		
		
	}
	$scope.seleciona = function(marcaTabela){
		$scope.marca=marcaTabela;
	}
	
	$scope.excluir = function(){
		$scope.marcas.splice($scope.marca.indexOf($scope.marca),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function(){
		
	}
	
});
var app = angular.module('acessorioModule',[]);
app.controller('acessorioControl',function($scope,$http) {
	
	
	 var  url = 'http://localhost:8080/SistemaConcessionariaCarros/rs/Acessorio'
	
	/*$scope.acessorios = [{'codigo':'1','tipo':'TRAVA ELETRICA','preco':'R$ 350'},
	{'codigo':'2','tipo':'FREIO ABS','preco':'R$ 850'},
	{'codigo':'3','tipo':'VIDRO ELETRICA','preco':'R$ 450'},
	{'codigo':'4','tipo':'ALARME POSITRON','preco':'R$ 250'},
	{'codigo':'5','tipo':'SOM PIONNER','preco':'R$ 750'}
	
	];*/
	
	$scope.pesquisar = function(){
		
		$http.get(url).success(function(acessoriosRetorno){
			$scope.acessorios = acessoriosRetorno;
		}).error(function(mensagemErro){
			
			alert(mensagemErro);	
		});
		
	}
	
	$scope.pesquisar();
	
	
	
	
	$scope.novo = function(){
		$scope.acessorio = "";
	}
	
	$scope.salvar = function(){
		$http.post(url).success(function(acessoriosRetorno){
			$scope.acessorios.push(acessoriosRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);	
		});
		
		
	}
	$scope.seleciona = function(acessorioTabela){
		$scope.acessorio=acessorioTabela;
	}
	
	$scope.excluir = function(){
		$scope.acessorios.splice($scope.acessorio.indexOf($scope.acessorio),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function(){
		
	}
	
});
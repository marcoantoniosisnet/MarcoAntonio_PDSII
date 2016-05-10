SELECT * FROM dbconcessionaria.tb_acessorio;

insert into tb_marca(CD_MARCA,NM_MARCA)
values (1,'FIAT'),
(2,'WOLKSVAGEM'),
	(3,'FORD'),
	(4,'RENAULT'),
	(5,'HYUNDAI'),
	(6,'kIA'),
	(7,'HONDA'),
	(8,'TOYOTA'),
	(9,'CHEVROLET');
    
    insert into tb_carro(CD_CARRO,NM_CARRO, DT_ANO, PRECO_BASICO, MARCA)
values (1,'FIAT UNO',2010, 16.000,1),
	(2,'HB20 FLEX 1.0',2015, 45.000,5),
	(3,'TUCSON FLEX 1.0',2015, 67.000,6),
	(4,'GOL G6', 2016, 35.000,2),
	(5,'GOLF 1.6', 2011, 23.000,2),
	(6,'GOL G5', 2014, 22.000,2);
    
     insert into tb_acessorio(CD_ACESSORIO,TP_TIPO,PC_PRECO,CARRO)
values (1,'TRAVA ELETRICA', 350,1),
	(2,'FREIO ABS', 850,3),
	(3,'VIDRO ELETRICA',450,2),
	(4,'ALARME POSITRON',250,2),
	(5,'SOM PIONNER', 750,5);
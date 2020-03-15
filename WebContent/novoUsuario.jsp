<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sistema: TemSpotify</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<p id="creditos" align="right">Developed by Vanderson de
					Oliveira Souza</p>
			</div>
		</div>
		<!-- Logo -->

		<div class="row">
			<div class="col-md-12">
				<h1 class="tituloPrincipal">Tem Spotify, sua playlist na Web</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12"></div>
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<form role="form" action="efetivarCadastro" method="POST">

						<div class="form-group">
							<label for="inputNome">Seu Nome:</label> <input type="text"
								name="txtNome" class="form-control" id="inputNome">
						</div>

						<div class="form-group">
							<label for="inputEmail"> Seu Email: </label> <input type="email"
								name="txtEmail" class="form-control" id="inputEmail">
						</div>
						<div class="form-group">

							<label for="inputSenha"> Sua Senha: </label> <input
								name="txtSenha" type="password" class="form-control"
								id="inputSenha">
						</div>

						<button type="submit" class="btn btn-primary">Efetivar
							cadastro</button>
					</form>
				</div>
				<div class="col-md-2"></div>
			<div class="row">
				<div class="col-md-12"></div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
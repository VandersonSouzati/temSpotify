<!DOCTYPE html>
<jsp:useBean id="Usuario" type="br.com.temspotify.model.Usuario"
	scope="session" />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		<!-- Logo -->

		<div class="row">
			<div class="col-md-12">
				<h3 class="tituloPrincipal">Tem Spotify, sua playlist na Web</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4>Minhas Playlists</h4>
			</div>
		</div>
		<div class="row" id="menu">
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-8">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link" href="#">Nova
							Playlist</a></li>
					<li class="nav-item"><a class="nav-link" href=".\myplaylist">Minha
							Playlist</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Upload
							Musica</a></li>
				</ul>
			</div>
			<div class="col-md-2">&nbsp</div>
		</div>
		
		<!-- Iterar minha playlist -->
		<c:forEach var="playlist" items=${Usuario.playlists }>
			<div class="row">
				<div class="col-md-2">&nbsp</div>
				<div class="col-md-8">${playlist.titulo }</div>
				<div class="col-md-2">&nbsp</div>
			</div>
		</c:forEach>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
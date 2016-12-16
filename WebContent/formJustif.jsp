<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisie de justificatif</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="CSS/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="CSS/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">
</head>
<body>
	<div class="container">
		<form>
			<div class="form-group row">
				<label for="lgFormGroupInput"
					class="col-sm-2 col-form-label col-form-label-lg">Nom
					Etudiant</label>
				<div class="col-sm-10">
					<input type="email" class="form-control form-control-lg"
						id="lgFormGroupInput" placeholder="you@example.com">
				</div>
			</div>
			<div class="form-group row">
				<label for="lgFormGroupInput"
					class="col-sm-2 col-form-label col-form-label-lg">Libelle</label>
				<div class="col-sm-10">
					<input type="email" class="form-control form-control-lg"
						id="lgFormGroupInput" placeholder="you@example.com">
				</div>
			</div>
			<div class="container">
				<div class="row">
					<label for="lgFormGroupInput"
						class="col-sm-2 col-form-label col-form-label-lg">DateDebut</label>
					<div class='col-sm-6'>
						<input type='text' class="form-control" id='datetimepicker4' />
					</div>
					<script type="text/javascript">
						$(function() {
							$('#datetimepicker4').datetimepicker();
						});
					</script>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<label for="lgFormGroupInput"
						class="col-sm-2 col-form-label col-form-label-lg">DateFin</label>
					<div class='col-sm-6'>
						<input type='text' class="form-control" id='datetimepicker4' />
					</div>
					<script type="text/javascript">
						$(function() {
							$('#datetimepicker4').datetimepicker();
						});
					</script>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
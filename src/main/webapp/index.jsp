<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <title>Iniciar sesi&#243;n</title>
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-6 mt-5">
                <h1 class="text-center fw-bold">Iniciar sesi&#243;n</h1>
                <!-- Login -->
                <form action="Usuario" id="form" method="POST" class="needs-validation text-start" novalidate>
                    <div class="mb-3">
                        <label for="email" class="form-label">Correo electr&#243;nico
                            <span class="text-danger">*</span></label>
                        <input type="email" class="form-control" name="email" id="email" placeholder="janedoe@mail.com"
                            minlength="10" required />
                        <input type="hidden" name="opcion" id="opcion" value="1">
                        <span class="invalid-feedback text-size-r">El correo solo puede contener letras,
                            números, puntos,
                            guiones, guion bajo, debe ser un correo válido y no puede
                            estar vacío</span>
                        <span class="valid-feedback">Correo valido</span>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Contrase&#241;a <span
                                class="text-danger">*</span></label>
                        <input type="password" class="form-control" name="pass" id="password" placeholder=""
                            minlength="10" maxlength="30" required />
                        <span class="invalid-feedback text-size-r">La contrase&#241;a debe ser de 10 a 30
                            caracteres</span>
                        <span class="valid-feedback">Contraseña valida</span>
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" name="connected" class="form-check-input" />
                        <label for="connected" class="form-check-label text-size-r">Mantenerme conectado</label>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary text-white w-100 fw-bold text-size-18 px-3 fw-bold"
                            id="btnIniciarSesion">
                            Iniciar sesi&#243;n
                        </button>
                    </div>
                </form>
                <div id="msg"></div>
                <!-- /Login -->
            </div>
            <div class="col-md-6">

            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script> -->

    <script>
        const form = document.getElementById('form');

        form.addEventListener('submit', (e) => {
            e.preventDefault();
            login();
        });



        function login() {
            var parametro = {
                "opcion": document.getElementById('opcion').value,
                "email": document.getElementById('email').value,
                "pass": document.getElementById('password').value
            }

            $.ajax({
                data: parametro,
                url: 'Usuario',
                type: 'POST',
                success: function (saludo) {
                    $('#msg').html(saludo);
                }
            });
        };
    </script>

    <script>
        // let btnSignUp = document.getElementById("btnSignUp"),
        //     formSignUp = document.getElementById("formSignUp"),
        //     divSignUp = document.getElementById("divSignUp"),
        //     btnSignIn = document.getElementById("btnSignIn"),
        //     formSignIn = document.getElementById("formSignIn"),
        //     divSignIn = document.getElementById("divSignIn");

        // btnSignUp.addEventListener("click", () => {
        //     btnSignIn.classList.remove("d-none");
        //     formSignUp.classList.remove("d-none");
        //     btnSignUp.classList.add("d-none");
        //     formSignIn.classList.add("d-none");
        // });

        // btnSignIn.addEventListener("click", () => {
        //     btnSignIn.classList.add("d-none");
        //     formSignUp.classList.add("d-none");
        //     btnSignUp.classList.remove("d-none");
        //     formSignIn.classList.remove("d-none");
        // });
    </script>
</body>

</html>
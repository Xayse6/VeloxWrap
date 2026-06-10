$(document).ready(function () {

    // máscara CPF
    $("#cpf").mask("000.000.000-00");

    function getCpfLimpo() {
        return $('#cpf').val().replace(/\D/g, '');
    }

    function validarCPF(cpf) {

        if (!cpf || cpf.length !== 11 || /^(\d)\1{10}$/.test(cpf)) {
            return false;
        }

        let soma = 0;
        let resto;

        // 1º dígito
        for (let i = 0; i < 9; i++) {
            soma += parseInt(cpf.charAt(i)) * (10 - i);
        }

        resto = (soma * 10) % 11;
        if (resto === 10 || resto === 11) resto = 0;

        if (resto !== parseInt(cpf.charAt(9))) {
            return false;
        }

        // 2º dígito
        soma = 0;

        for (let i = 0; i < 10; i++) {
            soma += parseInt(cpf.charAt(i)) * (11 - i);
        }

        resto = (soma * 10) % 11;
        if (resto === 10 || resto === 11) resto = 0;

        return resto === parseInt(cpf.charAt(10));
    }

    // 🔥 valida ao sair do campo
    $('#cpf').on('blur', function () {

        const cpf = getCpfLimpo();

        if (cpf.length === 0) return;

        if (cpf.length !== 11 || !validarCPF(cpf)) {

            Swal.fire({
                icon: 'warning',
                title: 'CPF inválido!',
                text: 'Verifique os números informados.'
            }).then(() => {
                $('#cpf').focus();
            });

            return;
        }
    });

    // 🔥 submit do form
    $(document).on('submit', '#formUsuario', function (e) {

        e.preventDefault();

        const cpf = getCpfLimpo();

        $('#cpf').val(cpf);


        if (cpf.length !== 11 || !validarCPF(cpf)) {

            Swal.fire({
                icon: 'warning',
                title: 'CPF inválido!',
                text: 'Corrija o CPF antes de salvar.'
            });

            return;
        }

        $.ajax({
            type: 'POST',
            url: '/UsuarioCadastrar',
            data: $(this).serialize(),

            success: function (data) {

                if (data.trim() === "1") {

                    Swal.fire({
                        icon: 'success',
                        title: 'Sucesso!',
                        text: 'Operação realizada com sucesso!',
                        timer: 2000,
                        showConfirmButton: false
                    }).then(() => {
                        window.location.href = '/usuarios';
                    });

                } else {

                    Swal.fire({
                        icon: 'error',
                        title: 'Erro',
                        text: 'Não foi possível salvar.'
                    });
                }
            },

            error: function () {
                Swal.fire({
                    icon: 'error',
                    title: 'Erro',
                    text: 'Falha no servidor.'
                });
            }
        });
    });

});
$(document).ready(function () {

    function validarPlaca(placa) {
        const regex = /^([A-Z]{3}-?[0-9]{4}|[A-Z]{3}[0-9][A-Z][0-9]{2})$/;
        return regex.test(placa);
    }

    $('#formVeiculo').on('submit', function (e) {
        e.preventDefault();

        const $form = $(this);

        const idVeiculo = $('#idVeiculo').val();

        const placaInput = $('#placa');
        const placa = $('#placa').val().toUpperCase().trim();
        $('#placa').val(placa);

        if (!validarPlaca(placa)) {
            Swal.fire({
                icon: 'error',
                title: 'Placa inválida',
                text: 'Informe uma placa válida (Ex: AAA-1234 ou ABC1D23).'
            });

            return;
        }

        $form.find(':disabled').prop('disabled', false);

        $.ajax({
            type: 'POST',
            url: '/veiculo/cadastrar',
            data: $form.serialize(),

            success: function (data) {

                if (data.trim() === "1") {

                    Swal.fire({
                        icon: 'success',
                        title: idVeiculo ? 'Atualizado!' : 'Sucesso!',
                        text: idVeiculo ? 'Veículo atualizado com sucesso!' : 'Veículo cadastrado com sucesso!',
                        timer: 2000,
                        showConfirmButton: false
                    }).then(() => {
                        window.location.href = '/veiculos';
                    });

                } else {

                    Swal.fire({
                        icon: 'error',
                        title: 'Erro',
                        text: 'Não foi possível salvar o veículo.'
                    });
                }
            },

            error: function () {

                Swal.fire({
                    icon: 'error',
                    title: 'Erro',
                    text: 'Falha no servidor. Tente novamente.'
                });

            }
        });

    });

});
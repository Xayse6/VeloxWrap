$(document).ready(function () {
    $('#formModelo').submit(function (e) {
        e.preventDefault();
        let id = $('#idModelo').val();
        let method = (id && id > 0) ? 'PUT' : 'POST';
        let url = (id && id > 0)
            ? '/modelos/' + id
            : '/modelos';

        $.ajax({
            type: method,
            url: url,
            data: $(this).serialize(),

            success: function (data) {

                if (data.trim() === "1") {

                    Swal.fire({
                        icon: 'success',
                        title: 'Sucesso!',
                        text: 'Modelo salvo com sucesso!',
                        timer: 2000,
                        showConfirmButton: false
                    }).then(() => {
                        window.location.href = '/modelos';
                    });

                } else {

                    Swal.fire({
                        icon: 'error',
                        title: 'Erro',
                        text: 'Não foi possível salvar o modelo.'
                    });

                }
            },

            error: function () {
                Swal.fire({
                    icon: 'error',
                    title: 'Erro',
                    text: 'Falha ao comunicar com o servidor.'
                });
            }
        });
    });
});